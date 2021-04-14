package com.github.hugovallada.otbootcampcadastro.config.exception;

public class ApiError {

    private String name;

    private String msg;

    public ApiError(String name, String msg) {
        this.name = name;
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
