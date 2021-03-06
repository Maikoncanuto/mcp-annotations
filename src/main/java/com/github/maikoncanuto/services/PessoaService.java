package com.github.maikoncanuto.services;

import com.github.maikoncanuto.domain.annotations.AllNotNull;
import com.github.maikoncanuto.domain.annotations.Auditoria;
import com.github.maikoncanuto.domain.annotations.ReturnNotNull;
import com.github.maikoncanuto.domain.entities.Pessoa;

import javax.enterprise.context.ApplicationScoped;

@Auditoria
@ApplicationScoped
public class PessoaService {

    @AllNotNull
    @ReturnNotNull
    public Pessoa create(final Pessoa pessoa, Boolean retornarNulo) {
        if (retornarNulo)
            return null;

        final var pessoaRetorno = new Pessoa();

        pessoaRetorno.setNome("Teste 1");
        pessoaRetorno.setIdade(10);

        return pessoaRetorno;
    }


}
