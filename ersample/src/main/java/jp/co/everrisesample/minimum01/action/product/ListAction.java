package jp.co.everrisesample.minimum01.action.product;

import javax.annotation.Resource;

import jp.co.everrise.utils.Converter;
import jp.co.everrisesample.minimum01.action.AbstractAction;
import jp.co.everrisesample.minimum01.dto.ListForPageDto;
import jp.co.everrisesample.minimum01.entity.Product;
import jp.co.everrisesample.minimum01.form.product.ListForm;
import jp.co.everrisesample.minimum01.service.ProductService;

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

        return "index.jsp";
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
                orderByItem, Converter.stringToInt(listForm.limit),
                Converter.stringToInt(listForm.page));
        return "index.jsp";
    }
/*
    public ActionMessages validate(){
        ActionMessages errors = new ActionMessages();


        return errors;
    }
*/
}
