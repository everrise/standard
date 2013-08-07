package jp.co.everrisesample.minimum01.action.product;

import javax.annotation.Resource;

import jp.co.everrisesample.minimum01.action.AbstractAction;
import jp.co.everrisesample.minimum01.dto.ListForPageDto;
import jp.co.everrisesample.minimum01.entity.Product;
import jp.co.everrisesample.minimum01.form.product.ListForm;
import jp.co.everrisesample.minimum01.service.ProductService;

import org.apache.commons.lang3.math.NumberUtils;
import org.seasar.extension.jdbc.OrderByItem;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

/**
 *
 * @author TanTai
 *
 */
public class ListAction extends AbstractAction {

    @ActionForm
    @Resource
    public ListForm listForm;

    @Resource
    public ProductService productService;

    public ListForPageDto<Product> pageData;

    /**
     * @author TanTai
     * @return
     */
    @Execute(validator = false)
    public String index() {
        listForm.limit = "10";
        listForm.page = "1";
        listForm.orderColumn = "name";
        listForm.orderBy = "asc";
        listForm.name = "";
        return list();
    }

    /**
     * @author TanTai
     * @return
     */
    @Execute(validator = false, urlPattern = "{limit}/{page}/{orderColumn}/{orderBy}")
    public String listAll() {
        return list();
    }
    /**
     * @author TanTai
     * @return
     */
    @Execute(validator = true, input="index.jsp", urlPattern = "{limit}/{page}/{orderColumn}/{orderBy}/{name}")
    public String list() {
        OrderByItem orderByItem = new OrderByItem(listForm.orderColumn + " " + listForm.orderBy);// listForm.orderColumnAsOrderByItem();
        this.pageData = productService.findAllNamePageLimit(listForm.name,
                orderByItem, NumberUtils.toInt(listForm.limit, 1),
                NumberUtils.toInt(listForm.page, 1));
        return "index.jsp";
    }
/*
    public ActionMessages validate(){
        ActionMessages errors = new ActionMessages();


        return errors;
    }
*/
}
