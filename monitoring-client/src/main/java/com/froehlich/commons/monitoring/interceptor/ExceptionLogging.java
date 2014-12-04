package com.froehlich.commons.monitoring.interceptor;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by mfroehlich on 04.12.2014.
 */
@InterceptorBinding
@Target(value = { ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ExceptionLogging {
}
