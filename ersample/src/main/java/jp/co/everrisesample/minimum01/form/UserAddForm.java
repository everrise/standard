package jp.co.everrisesample.minimum01.form;

import java.io.Serializable;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;
import org.seasar.struts.annotation.Arg;
import org.seasar.struts.annotation.Maxlength;
import org.seasar.struts.annotation.Minlength;
import org.seasar.struts.annotation.Msg;
import org.seasar.struts.annotation.Required;
import org.seasar.struts.annotation.Validwhen;

@Component(instance = InstanceType.SESSION)
public class UserAddForm implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Required(target = "saveAdd", arg0 = @Arg(key = "userAdd.input.name.label", resource = true))
    public String name;
    @Required(target = "saveAdd", arg0 = @Arg(key = "userAdd.input.loginid.label", resource = true))
    @Minlength(target = "saveAdd", minlength = 4, arg0 = @Arg(key = "userAdd.input.loginid.label", resource = true), arg1 = @Arg(key = "4", resource = false))
    @Maxlength(target = "saveAdd", maxlength = 255, arg0 = @Arg(key = "userAdd.input.loginid.label", resource = true), arg1 = @Arg(key = "255", resource = false))
    public String loginId;
    
    @Required(target = "saveAdd", arg0 = @Arg(key = "userAdd.input.password.label", resource = true))
    @Minlength(target = "saveAdd", minlength = 4, arg0 = @Arg(key = "userAdd.input.password.label", resource = true), arg1 = @Arg(key = "4", resource = false))
    @Maxlength(target = "saveAdd", maxlength = 255, arg0 = @Arg(key = "userAdd.input.password.label", resource = true), arg1 = @Arg(key = "255", resource = false))
    public String password;
    @Validwhen(target = "saveAdd", test = "(password == repassword)",
               msg = @Msg(key = "saveAdd.errors.passwordConfirm", resource = true))
    public String repassword;
}
