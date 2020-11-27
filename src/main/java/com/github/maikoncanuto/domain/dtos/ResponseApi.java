package com.github.maikoncanuto.domain.dtos;

import java.io.Serializable;

public class ResponseApi implements Serializable {

    private String code;
    private Object data;
    private String erro;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }
}
