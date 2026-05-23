package com.bajaj.bfhl.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Standard API error response schema.
 */
public class ErrorResponse {

    @JsonProperty("is_success")
    private boolean isSuccess;

    @JsonProperty("error")
    private String error;

    public ErrorResponse() {
    }

    public ErrorResponse(String error) {
        this.isSuccess = false;
        this.error = error;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
