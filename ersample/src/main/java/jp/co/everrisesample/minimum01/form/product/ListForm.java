package jp.co.everrisesample.minimum01.form.product;

import org.seasar.struts.annotation.IntRange;
import org.seasar.struts.annotation.IntegerType;
import org.seasar.struts.annotation.Mask;
import org.seasar.struts.annotation.Required;
import org.seasar.struts.annotation.Arg;
import org.seasar.struts.annotation.Msg;


public class ListForm {
    public String name;

    @Required(target = "list", arg0 = @Arg(key = "product.list.error.limit.require", resource = true))
    @IntRange(min=1, max=1000, msg=@Msg(key="product.list.error.limit.invalid"))
    @Mask(mask="^[0-9]+$", msg=@Msg(key="product.list.error.limit.invalid"), arg0=@Arg(key="afd", resource=false))
    @IntegerType
    public String limit;

    public int limitAsInt(){
        return Integer.valueOf(limit);
    }

    @Required(target = "list", arg0 = @Arg(key = "product.list.error.page", resource = true))
    @IntRange(min=1, max = 1000, msg=@Msg(key="product.list.error.limit.invalid"))
    @IntegerType
    public String page;

    public int pageAsInt(){
        return Integer.valueOf(page);
    }

    public String orderColumn;

    public String orderBy;
}
