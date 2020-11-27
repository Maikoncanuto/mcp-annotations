package com.github.maikoncanuto.services.validators;

import com.github.maikoncanuto.domain.annotations.AllNotNull;
import com.github.maikoncanuto.domain.annotations.ReturnNotNull;
import com.github.maikoncanuto.domain.exceptions.NotFoundException;

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

    public static void returnNotNull(final InvocationContext invocationContext, final Object process) throws NotFoundException {
        if (nonNull(invocationContext.getMethod().getAnnotation(ReturnNotNull.class)))
            if (isNull(process))
                throw new NotFoundException(String.format("Objeto não existe para o retorno do método %s", invocationContext.getMethod().getName()));
    }
}
