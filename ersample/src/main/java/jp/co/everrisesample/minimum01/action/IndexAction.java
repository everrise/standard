package jp.co.everrisesample.minimum01.action;

import org.seasar.struts.annotation.Execute;

/**
 * 
 *
 */
public class IndexAction extends AbstractAction{
    @Execute(validator = false)
    public String index(){
        return "index.jsp";
    }
}
