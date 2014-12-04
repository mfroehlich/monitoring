package com.froehlich.commons.monitoring.interceptor;

import org.slf4j.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * Created by mfroehlich on 04.12.2014.
 */
@Interceptor
@ExceptionLogging
public class ExceptionLoggingInterceptor {

    @Inject
    private Logger logger;

    @AroundInvoke
    public Object logException(InvocationContext context) throws Exception {
        try {
            return context.proceed();
        }
        catch (Exception e) {
            logger.error("Interceptor caught Exception. Logging it.", e);
            throw e;
        }
    }
}
