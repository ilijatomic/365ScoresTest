package com.ikac.test.network.model;

/**
 * Created by ikac on 3/21/18.
 */

public class BaseModel {

    private Boolean status;
    private Integer code;
    private String errorMessage;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
