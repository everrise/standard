package jp.co.everrisesample.minimum01.action;

import jp.co.everrisesample.minimum01.annotation.Auth;
import jp.co.everrisesample.minimum01.catalog.COOKIE_KEY;

import org.seasar.struts.annotation.Execute;

/**
 *
 *
 */
public class CookieOpeAction extends AbstractAction{

    public String cookieValue;
    /**
     *
     */
    @Auth
    @Execute(validator = false)
    public String index(){
        cookieValue = this.getCookieValue(COOKIE_KEY.HOGE_PIYO);
        return "index.jsp";
    }
    @Execute(validator = false)
    public String putCookie(){
        this.putCookieValue(COOKIE_KEY.HOGE_PIYO, "123456789", 10);
        return "putCookie.jsp";
    }
    @Execute(validator = false)
    public String removeCookie(){
        this.removeCookieValue(COOKIE_KEY.HOGE_PIYO);
        return "removeCookie.jsp";
    }
}
