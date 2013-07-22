package jp.co.everrisesample.minimum01.interceptor;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.struts.util.TokenProcessor;
import org.seasar.framework.aop.interceptors.AbstractInterceptor;
import org.seasar.struts.util.RequestUtil;

public class TokenInterceptor extends AbstractInterceptor{
    private static final long serialVersionUID = 1L;

    public Object invoke(MethodInvocation invocation) throws Throwable{
        TokenProcessor.getInstance().saveToken(RequestUtil.getRequest());
        return invocation.proceed();
    }
}
