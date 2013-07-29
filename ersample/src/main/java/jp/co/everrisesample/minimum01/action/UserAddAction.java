package jp.co.everrisesample.minimum01.action;

import javax.annotation.Resource;

import jp.co.everrisesample.minimum01.annotation.Auth;
import jp.co.everrisesample.minimum01.dao.UserDao;
import jp.co.everrisesample.minimum01.entity.User;
import jp.co.everrisesample.minimum01.form.UserAddForm;
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
public class UserAddAction extends AbstractAction{

    @ActionForm
    @Resource
    public UserAddForm userAddForm;
    @Resource
    protected UserService userService;

    @Resource
    protected UserDao userDao;

    /**
     *
     * @return
     */
    @Auth
    @Execute(validator = false, removeActionForm = true)
    public String index(){
        userAddForm.password = null;
        userAddForm.repassword = null;
        return "index.jsp";
    }
    @Auth
    @Execute(validator = true, validate = "saveAddValidate", input = "?redirect=true", removeActionForm = true, saveErrors = SaveType.SESSION)
    public String saveAdd(){
        User user = userService.createUser(userAddForm.name, userAddForm.loginId, userAddForm.password);
        return "/userDetail/" + user.id.toString() + "?redirect=true";
    }
    public ActionMessages saveAddValidate(){
        ActionMessages errors = new ActionMessages();
        if(!userService.isValidLoginIdForCreate(userAddForm.loginId)){
            errors.add("duplicateLoginId", new ActionMessage("userAdd.errors.duplicateLoginId", true));
        }

        return errors;
    }
}
