package jp.co.everrisesample.minimum01.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.seasar.framework.aop.annotation.Interceptor;

/**
 * 認証の必要なアクション対して付与
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Interceptor
public @interface Auth {

}

