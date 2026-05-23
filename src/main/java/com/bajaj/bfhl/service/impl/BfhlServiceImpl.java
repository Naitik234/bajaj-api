package com.bajaj.bfhl.service.impl;

import com.bajaj.bfhl.exception.InvalidInputException;
import com.bajaj.bfhl.model.BfhlRequest;
import com.bajaj.bfhl.model.BfhlResponse;
import com.bajaj.bfhl.service.BfhlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service implementation for processing BFHL requests.
 */
@Service
public class BfhlServiceImpl implements BfhlService {

    private static final Logger logger = LoggerFactory.getLogger(BfhlServiceImpl.class);

    @Value("${bfhl.user.id}")
    private String userId;

    @Value("${bfhl.email}")
    private String email;

    @Value("${bfhl.roll.number}")
    private String rollNumber;

    @Override
    public BfhlResponse processRequest(BfhlRequest request) {
        logger.debug("Processing request with data list size: {}", request.getData() != null ? request.getData().size() : "null");

        List<String> inputData = request.getData();
        List<String> numbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();

        if (inputData != null) {
            for (String element : inputData) {
                // Strict validation: Reject null elements
                if (element == null) {
                    throw new InvalidInputException("Input data array contains null elements.");
                }

                String trimmed = element.trim();
                // Strict validation: Reject empty strings
                if (trimmed.isEmpty()) {
                    throw new InvalidInputException("Input data array contains empty elements.");
                }

                // Check if element is a valid number (e.g. "123", "0")
                if (trimmed.matches("^\\d+$")) {
                    numbers.add(trimmed);
                } 
                // Check if element is a valid alphabet string (e.g. "a", "Z", "ABC")
                else if (trimmed.matches("^[a-zA-Z]+$")) {
                    alphabets.add(trimmed);
                } 
                // Throw exception for any special characters, spaces or invalid input types
                else {
                    throw new InvalidInputException("Invalid character/string found in data array: '" + element + "'. Elements must be purely alphanumeric (digits or alphabets only, no mixed characters or symbols).");
                }
            }
        }

        logger.debug("Separated input: numbers={}, alphabets={}", numbers, alphabets);

        return new BfhlResponse(
                true,
                userId,
                email,
                rollNumber,
                numbers,
                alphabets
        );
    }
}
