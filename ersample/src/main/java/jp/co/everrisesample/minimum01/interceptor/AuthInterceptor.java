package jp.co.everrisesample.minimum01.interceptor;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import jp.co.everrisesample.minimum01.dto.LoginUserDto;

import org.aopalliance.intercept.MethodInvocation;
import org.seasar.framework.aop.interceptors.AbstractInterceptor;
import org.seasar.framework.beans.BeanDesc;
import org.seasar.framework.beans.factory.BeanDescFactory;
import org.seasar.framework.container.SingletonS2Container;


/**
 * ログイン確認用のインターセプター
 * ログインしてなかったらログイン画面に押し戻す
 *
 */
public class AuthInterceptor extends AbstractInterceptor{
    private static final long serialVersionUID = 1L;
    /**
     * 実行部
     * このメソッドが適用されるのはAuthアノテーションをつけているActionのみ
     * なのでログイン前で使うActionのことは考慮する必要が無い
     */
    public Object invoke(MethodInvocation invocation) throws Throwable{

        //変な書き方をしているのはhotdeployの際にオブジェクトの参照がおかしくなってしまうから
        Object loginDtoObj = SingletonS2Container.getComponent(LoginUserDto.class);
        BeanDesc loginDtoBeanDesc = BeanDescFactory.getBeanDesc(loginDtoObj.getClass());

        //こちらは同一である必要がないから普通に書いてる
        Map requestScope = (Map)SingletonS2Container.getComponent("requestScope");
        String contextPath = (String)requestScope.get("javax.servlet.forward.context_path");
        Boolean isLogin = (Boolean)loginDtoBeanDesc.invoke(loginDtoObj, "isLogin", null);

        if(!isLogin){
            try{
                String loginUrl = contextPath + "/login/";
                HttpServletResponse response = SingletonS2Container.getComponent(HttpServletResponse.class);
                response.sendRedirect(loginUrl);
            }catch(IOException e){
                e.printStackTrace();
            }
            return null;
        }
        return invocation.proceed();
    }
}
