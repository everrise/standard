package jp.co.everrisesample.minimum01.action;

import javax.annotation.Resource;

import jp.co.everrisesample.minimum01.dao.UserDao;
import jp.co.everrisesample.minimum01.entity.User;
import jp.co.everrisesample.minimum01.form.LoginForm;
import jp.co.everrisesample.minimum01.service.LoginService;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.enums.SaveType;


/**
 * 
 *
 */
public class LoginAction extends AbstractAction{
    
    @ActionForm
    @Resource
    public LoginForm loginForm;
    
    @Resource
    protected LoginService loginService;
    @Resource
    protected UserDao userDao;
    

    
    /**
     * 
     */
    @Execute(validator = false, removeActionForm = true)
    public String index(){
        return "index.jsp";
    }
    /**
     * 
     */
    @Execute(validator = true, validate = "doLoginValidate", input = "?redirect=true", removeActionForm = true, saveErrors = SaveType.SESSION)
    public String doLogin(){
        User u = userDao.findByLoginIdAndPassword(loginForm.loginId, loginForm.password);
        loginUserDto.login(u);
        return "/top/?redirect=true";
    }
    public ActionMessages doLoginValidate(){
        ActionMessages errors = new ActionMessages();
        if(!loginService.canLogin(loginForm.loginId, loginForm.password)){
            errors.add("invalidIdOrPassword", new ActionMessage("login.error.invalidIdOrPassword"));
        }
        return errors;
    }
    @Execute(validator = false, removeActionForm = true)
    public String doLogout(){
        loginUserDto.logout();
        session.invalidate();
        return "?redirect=true";
    }
    
}
