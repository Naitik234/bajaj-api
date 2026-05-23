package com.bajaj.bfhl.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Data Transfer Object (DTO) for standard successful BFHL API POST response.
 */
public class BfhlResponse {

    @JsonProperty("is_success")
    private boolean isSuccess;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("email")
    private String email;

    @JsonProperty("roll_number")
    private String rollNumber;

    @JsonProperty("numbers")
    private List<String> numbers;

    @JsonProperty("alphabets")
    private List<String> alphabets;

    // Constructors
    public BfhlResponse() {
    }

    public BfhlResponse(boolean isSuccess, String userId, String email, String rollNumber, List<String> numbers, List<String> alphabets) {
        this.isSuccess = isSuccess;
        this.userId = userId;
        this.email = email;
        this.rollNumber = rollNumber;
        this.numbers = numbers;
        this.alphabets = alphabets;
    }

    // Getters and Setters
    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    public List<String> getAlphabets() {
        return alphabets;
    }

    public void setAlphabets(List<String> alphabets) {
        this.alphabets = alphabets;
    }
}
