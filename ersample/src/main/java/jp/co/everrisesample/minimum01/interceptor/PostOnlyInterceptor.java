package jp.co.everrisesample.minimum01.interceptor;

import javax.servlet.http.HttpServletRequest;


import org.aopalliance.intercept.MethodInvocation;
import org.seasar.framework.aop.interceptors.AbstractInterceptor;
import org.seasar.framework.container.SingletonS2Container;

/**
 * Implements accept post method only (excluded other methods)
 */
public class PostOnlyInterceptor extends AbstractInterceptor{
    private static final long serialVersionUID = 1L;
    public Object invoke(MethodInvocation invocation) throws Throwable{
        HttpServletRequest req = SingletonS2Container.getComponent(HttpServletRequest.class);
        if("post".equalsIgnoreCase(req.getMethod())){
            return invocation.proceed();
        }else{
            throw new RuntimeException();
        }
    }
}
