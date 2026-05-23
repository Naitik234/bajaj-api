package com.bajaj.bfhl.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Data Transfer Object (DTO) for standard BFHL GET response.
 */
public class BfhlGetResponse {

    @JsonProperty("operation_code")
    private int operationCode;

    public BfhlGetResponse() {
    }

    public BfhlGetResponse(int operationCode) {
        this.operationCode = operationCode;
    }

    public int getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(int operationCode) {
        this.operationCode = operationCode;
    }
}
