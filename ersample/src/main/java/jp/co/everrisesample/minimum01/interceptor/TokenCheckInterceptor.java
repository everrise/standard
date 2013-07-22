package jp.co.everrisesample.minimum01.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.struts.util.TokenProcessor;
import org.seasar.framework.aop.interceptors.AbstractInterceptor;
import org.seasar.struts.util.RequestUtil;

/**
 * Strutsトークンをチェックする{@link MethodInterceptor}.<br>
 *
 * {@link TokenCheck}アノテーションのあるメソッドの実行前にStrutsトークンをチェックし、トークンが異なっていれば、
 * {@link InvalidTokenException}をスローします。
 *
 */
public class TokenCheckInterceptor extends AbstractInterceptor{
    private static final long serialVersionUID = 1L;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable{
        if(TokenProcessor.getInstance().isTokenValid(RequestUtil.getRequest(), true)){
            return invocation.proceed();
        }
        throw new RuntimeException();
    }
}
