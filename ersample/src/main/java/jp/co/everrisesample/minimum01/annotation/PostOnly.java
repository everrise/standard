package jp.co.everrisesample.minimum01.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.seasar.framework.aop.annotation.Interceptor;

/**
 * Restricting post method for action method
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Interceptor
public @interface PostOnly{
}

