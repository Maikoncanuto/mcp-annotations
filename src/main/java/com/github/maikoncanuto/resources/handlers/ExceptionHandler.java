package com.github.maikoncanuto.resources.handlers;

import com.github.maikoncanuto.domain.dtos.ResponseApi;
import com.github.maikoncanuto.domain.exceptions.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static java.lang.String.valueOf;
import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.status;

@Provider
public class ExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(final Exception e) {
        final var response = new ResponseApi();

        response.setCode(toCodeException(e));
        response.setErro(e.getCause().getMessage());

        return status(INTERNAL_SERVER_ERROR).entity(response).build();
    }

    private String toCodeException(Exception e) {
        if (e.getCause() instanceof NotFoundException)
            return valueOf(NOT_FOUND.getStatusCode());

        return valueOf(INTERNAL_SERVER_ERROR.getStatusCode());
    }
}
