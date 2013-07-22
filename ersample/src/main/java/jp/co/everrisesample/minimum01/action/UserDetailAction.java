package jp.co.everrisesample.minimum01.action;

import javax.annotation.Resource;

import jp.co.everrisesample.minimum01.annotation.Auth;
import jp.co.everrisesample.minimum01.dao.UserDao;
import jp.co.everrisesample.minimum01.entity.User;
import jp.co.everrisesample.minimum01.form.UserDetailForm;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

/**
 * User detail Page
 * 
 */
public class UserDetailAction extends AbstractAction{

    @ActionForm
    @Resource
    public UserDetailForm userDetailForm;

    @Resource
    protected UserDao userDao;

    public User user;
    
    /**
     * 
     * @return
     */
    @Auth
    @Execute(validator = false, urlPattern="{userId}")
    public String index(){
        long userId = userDetailForm.userIdAsLong();
        this.user = userDao.findById(userId);
        return "index.jsp";
    }
}
