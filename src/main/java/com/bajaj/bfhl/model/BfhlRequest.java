package com.bajaj.bfhl.model;

import jakarta.validation.constraints.NotNull;
import java.util.List;

/**
 * Data Transfer Object (DTO) for incoming BFHL API POST requests.
 */
public class BfhlRequest {

    @NotNull(message = "data field cannot be null")
    private List<String> data;

    // Default constructor
    public BfhlRequest() {
    }

    // Parameterized constructor
    public BfhlRequest(List<String> data) {
        this.data = data;
    }

    // Getter and Setter
    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
