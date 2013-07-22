package jp.co.everrisesample.minimum01.form;

import java.io.Serializable;

import jp.co.everrisesample.minimum01.entity.User;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;
import org.seasar.struts.annotation.Arg;
import org.seasar.struts.annotation.Maxlength;
import org.seasar.struts.annotation.Minlength;
import org.seasar.struts.annotation.Msg;
import org.seasar.struts.annotation.Required;
import org.seasar.struts.annotation.Validwhen;

@Component(instance = InstanceType.SESSION)
public class UserEditForm implements Serializable{
    private static final long serialVersionUID = 1L;
    /**
     * ユーザーID
     */
    public String userId;
    public long userIdAsLong(){
        return Long.valueOf(this.userId);
    }
    @Required(target = "saveEdit", arg0 = @Arg(key = "userEdit.input.name.label", resource = true))
    public String name;
    @Required(target = "saveEdit", arg0 = @Arg(key = "userEdit.input.loginid.label", resource = true))
    @Minlength(target = "saveEdit", minlength = 4, arg0 = @Arg(key = "userEdit.input.loginid.label", resource = true), arg1 = @Arg(key = "4", resource = false))
    @Maxlength(target = "saveEdit", maxlength = 255, arg0 = @Arg(key = "userEdit.input.loginid.label", resource = true), arg1 = @Arg(key = "255", resource = false))
    public String loginId;
    @Minlength(target = "saveEdit", minlength = 4, arg0 = @Arg(key = "userEdit.input.password.label", resource = true), arg1 = @Arg(key = "4", resource = false))
    @Maxlength(target = "saveEdit", maxlength = 255, arg0 = @Arg(key = "userEdit.input.password.label", resource = true), arg1 = @Arg(key = "255", resource = false))
    public String password;
    @Validwhen(target = "saveEdit", test = "(password == repassword)",
               msg = @Msg(key = "userEdit.errors.passwordConfirm", resource = true))
    public String repassword;
    
    public void fillParams(User user){
        this.userId = Long.toString(user.id);
        this.name = user.name;
        this.loginId = user.loginId;
    }
}
