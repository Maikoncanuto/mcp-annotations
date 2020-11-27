package com.github.maikoncanuto.inteceptors;

import com.github.maikoncanuto.domain.annotations.Auditoria;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import static com.github.maikoncanuto.services.validators.ValidatorAnnotation.allNotNull;

@Auditoria
@Interceptor
@Priority(1)
public class AuditoriaInterceptor {

    @AroundInvoke
    public Object intercept(final InvocationContext invocationContext) throws Exception {
        try {
            allNotNull(invocationContext);

            var process = invocationContext.proceed();
            return process;
        } catch (Exception e) {
            throw e;
        }
    }


}
