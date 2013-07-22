package jp.co.everrisesample.minimum01.action;

import javax.annotation.Resource;
import jp.co.everrisesample.minimum01.annotation.Auth;
import jp.co.everrisesample.minimum01.dto.ListForPageDto;
import jp.co.everrisesample.minimum01.entity.User;
import jp.co.everrisesample.minimum01.form.UserListForm;
import jp.co.everrisesample.minimum01.service.UserService;

import org.seasar.extension.jdbc.OrderByItem;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

/**
 * User List Page
 * 
 */
public class UserListAction extends AbstractAction{

    @ActionForm
    @Resource
    public UserListForm userListForm;

    @Resource
    protected UserService userService;

    public ListForPageDto<User> pageData;
    
    /**
     * 
     * @return
     */
    @Auth
    @Execute(validator = false)
    public String index(){
        String name = userListForm.sw;
        OrderByItem orderByItem = userListForm.orderColumnAsOrderByItem();
        int limit = 10;
        int page = userListForm.pageAsInt();
        this.pageData = userService.searchByNameAndPageConditions(name, orderByItem, limit, page);
        return "index.jsp";
    }
}
