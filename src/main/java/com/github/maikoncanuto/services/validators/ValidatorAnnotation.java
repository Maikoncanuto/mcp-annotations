package com.github.maikoncanuto.services.validators;

import com.github.maikoncanuto.domain.annotations.AllNotNull;

import javax.interceptor.InvocationContext;

import static java.lang.String.format;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class ValidatorAnnotation {

    private ValidatorAnnotation() {
    }

    public static void allNotNull(final InvocationContext invocationContext) throws Exception {
        if (nonNull(invocationContext.getMethod().getAnnotation(AllNotNull.class))) {
            final Object[] parameters = invocationContext.getParameters();

            if (nonNull(parameters)) {
                for (int i = 0; i < parameters.length; i++)
                    if (isNull(parameters[i]))
                        throw new Exception(format("Parametro na posicao %s está invalido no método %s", i, invocationContext.getMethod().getName()));
            }
        }

    }
}
