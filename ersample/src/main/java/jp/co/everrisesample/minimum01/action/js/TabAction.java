package jp.co.everrisesample.minimum01.action.js;

import jp.co.everrisesample.minimum01.action.AbstractAction;
import org.seasar.struts.annotation.Execute;

/**
 *
 * @author TanTai
 *
 */
public class TabAction extends AbstractAction {

    /**
     * @author TanTai
     * @return
     */
    @Execute(validator = false)
    public String index() {

        return "index.jsp";
    }
}
