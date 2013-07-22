package jp.co.everrisesample.minimum01.action;

import javax.annotation.Resource;

import jp.co.everrisesample.minimum01.annotation.Auth;
import jp.co.everrisesample.minimum01.dao.UserDao;
import jp.co.everrisesample.minimum01.entity.User;
import jp.co.everrisesample.minimum01.form.UserEditForm;
import jp.co.everrisesample.minimum01.service.UserService;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.enums.SaveType;

/**
 * User edit Page
 * 
 */
public class UserEditAction extends AbstractAction{

    @ActionForm
    @Resource
    public UserEditForm userEditForm;

    @Resource
    protected UserService userService;

    @Resource
    protected UserDao userDao;
    
    /**
     * 
     * @return
     */
    @Auth
    @Execute(validator = false, urlPattern = "{userId}", removeActionForm = true)
    public String index(){
        long userId = userEditForm.userIdAsLong();
        User user = userDao.findById(userId);
        if(user == null){
            return "noUser.jsp";
        }
        if(!this.hasErrors()){
            this.userEditForm.fillParams(user);
        }
        this.userEditForm.password = null;
        this.userEditForm.repassword = null;
        return "index.jsp";
    }
    @Auth
    @Execute(validator = true, validate = "saveEditValidate", input = "{userId}?redirect=true", removeActionForm = true, saveErrors = SaveType.SESSION)
    public String saveEdit(){
        User user = userDao.update(
                userEditForm.userIdAsLong(),
                userEditForm.name,
                userEditForm.loginId,
                userEditForm.password);
        return "/userDetail/" + user.id.toString() + "?redirect=true";
    }
    public ActionMessages saveEditValidate(){
        ActionMessages errors = new ActionMessages();
        long userId = userEditForm.userIdAsLong();
        User user = userDao.findById(userId);
        if(user == null){
            // Allow anything error. This is marking of no user data.
            // Only marking. The message does'nt show for user.
            errors.add("nouser", new ActionMessage("", false));
        }
        if(!userService.isValidLoginIdForUpdate(userId, userEditForm.loginId)){
            errors.add("duplicateLoginId", new ActionMessage("userEdit.errors.duplicateLoginId", true));
        }
        return errors;
    }
}
