package jp.co.everrisesample.minimum01.action;

import jp.co.everrisesample.minimum01.annotation.Auth;
import jp.co.everrisesample.minimum01.annotation.PostOnly;

import org.seasar.struts.annotation.Execute;

/**
 * 
 *
 */
public class TopAction extends AbstractAction{
    
    
    /**
     * 
     */
    @Auth
    @Execute(validator = false)
    public String index(){
        return "index.jsp";
    }
    @Execute(validator = false)
    public String prePostOnly(){
        return "prePostOnly.jsp";
    }
    @PostOnly
    @Execute(validator = false)
    public String postOnly(){
        return "postOnly.jsp";
    }
}
