package jp.co.everrisesample.minimum01.action;

import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.everrisesample.minimum01.Config;
import jp.co.everrisesample.minimum01.catalog.COOKIE_KEY;
import jp.co.everrisesample.minimum01.dto.LoginUserDto;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.TokenProcessor;
import org.seasar.framework.util.ResourceUtil;


/**
 * Base of action class
 *
 */
public abstract class AbstractAction{
    /**
     * ここにユーザー情報が入ってるからactionから使うときはここから取ろう
     */
    @Resource
    protected LoginUserDto loginUserDto;
    @Resource
    protected HttpServletRequest request;
    @Resource
    protected HttpServletResponse response;
    
    @Resource
    protected HttpSession session;
    @Resource
    protected Map<String, Cookie> cookie;
    
    @Resource
    public Config config;
    public Properties appProperties = ResourceUtil.getProperties("application.properties");
    
    /**
     * sessionの中にエラーメッセージがあるか否か
     * ActionMessagesUtil.hasErrorsのセッション版
     * @return
     */
    public boolean hasErrors(){
        ActionMessages errors = (ActionMessages) session.getAttribute(Globals.ERROR_KEY);
        if (errors != null && !errors.isEmpty()) {
            return true;
        }
        return false;
    }
    
    /**
     * GETリクエストかどうかを返します。
     * 
     * @return GETリクエストの場合 true
     */
    protected boolean isGet(){
        return "get".equalsIgnoreCase(this.request.getMethod());
    }

    /**
     * POSTリクエストかどうかを返します。
     * 
     * @return POSTリクエストの場合 true
     */
    protected boolean isPost(){
        return "post".equalsIgnoreCase(this.request.getMethod());
    }
    /**
     * get cookie value by key
     * @param key
     * @return
     */
    protected String getCookieValue(COOKIE_KEY key){
        Cookie c = this.cookie.get(key.v);
        if(c == null){
            return null;
        }
        return c.getValue();
    }
    /**
     * send cookie value to user
     * @param key
     * @param value
     * @param age
     */
    protected void putCookieValue(COOKIE_KEY key, String value, int age){
        Cookie c = new Cookie(key.v, value);
        c.setMaxAge(age);
        c.setPath(this.request.getContextPath());
        this.response.addCookie(c);
    }
    /**
     * remove user's cookie value 
     * @param key
     */
    protected void removeCookieValue(COOKIE_KEY key){
        this.putCookieValue(key, null, 0);
    }
    /**
     * checking exist cookie value by key
     * @param key
     * @return
     */
    protected boolean hasCookie(COOKIE_KEY key){
        Cookie c = (Cookie)this.cookie.get(key.v);
        return (c != null);
    }
    
    /**
     * Generate token, save the token in session and return the token value
     * @return
     */
    protected String initToken(){
        // later... automatically set token input inner s:form tag
        TokenProcessor.getInstance().saveToken(this.request);
        return (String) this.session.getAttribute(Globals.TRANSACTION_TOKEN_KEY);
    }
    /**
     * Remove a token from session 
     */
    protected void clearToken(){
        TokenProcessor.getInstance().resetToken(this.request);
    }
    /**
     * check token validness
     * assumed using inner validate method
     * @return
     */
    public ActionMessages tokenValidate(){
        ActionMessages errors = new ActionMessages();
        return this.tokenValidate(errors);
    }
    public ActionMessages tokenValidate(ActionMessages errors){
        if (!TokenProcessor.getInstance().isTokenValid(this.request, true)){
            errors.add("invalidToken", new ActionMessage("errors.token"));
        }
        return errors;
    }
}
