package com.github.maikoncanuto.resources;

import com.github.maikoncanuto.domain.entities.Pessoa;
import com.github.maikoncanuto.services.PessoaService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/pessoas")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class PessoaResource {

    @Inject
    PessoaService pessoaService;

    @GET
    @Path("/preenchido")
    public Response createRetornarNulo() {
        final var pessoa = new Pessoa();
        final var pessoaRetorno = pessoaService.create(pessoa);
        return Response.ok()
                .entity(pessoaRetorno)
                .build();
    }

    @GET
    @Path("nao-preenchido")
    public Response createNormal() {
        var pessoaRetorno = pessoaService.create(null);
        return Response.ok().entity(pessoaRetorno).build();
    }


}
