package jp.co.everrisesample.minimum01.form;

import java.io.Serializable;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;
import org.seasar.struts.annotation.Arg;
import org.seasar.struts.annotation.Maxlength;
import org.seasar.struts.annotation.Minlength;
import org.seasar.struts.annotation.Required;

/**
 * received parameter for login  
 *
 */
@Component(instance = InstanceType.SESSION)
public class LoginForm implements Serializable{
    private static final long serialVersionUID = 1L;
    
    /**
     * login id
     */
    @Required(target = "doLogin", arg0 = @Arg(key = "login.loginid.label", resource = true))
    @Minlength(target = "doLogin", minlength = 4, arg0 = @Arg(key = "login.loginid.label", resource = true), arg1 = @Arg(key = "4", resource = false))
    @Maxlength(target = "doLogin", maxlength = 255, arg0 = @Arg(key = "login.loginid.label", resource = true), arg1 = @Arg(key = "255", resource = false))
    public String loginId;
    /**
     * password
     */
    @Required(target = "doLogin", arg0 = @Arg(key = "login.password.label", resource = true))
    @Minlength(target = "doLogin", minlength = 4, arg0 = @Arg(key = "login.password.label", resource = true), arg1 = @Arg(key = "4", resource = false))
    @Maxlength(target = "doLogin", maxlength = 255, arg0 = @Arg(key = "login.password.label", resource = true), arg1 = @Arg(key = "255", resource = false))
    public String password;
}
