package com.bajaj.bfhl.service;

import com.bajaj.bfhl.model.BfhlRequest;
import com.bajaj.bfhl.model.BfhlResponse;

/**
 * Service interface for BFHL business logic operations.
 */
public interface BfhlService {

    /**
     * Processes request data by filtering numbers and alphabets and enriching with configured user info.
     *
     * @param request the incoming BfhlRequest containing data list
     * @return populated BfhlResponse
     */
    BfhlResponse processRequest(BfhlRequest request);
}
