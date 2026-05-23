package com.bajaj.bfhl.controller;

import com.bajaj.bfhl.model.BfhlGetResponse;
import com.bajaj.bfhl.model.BfhlRequest;
import com.bajaj.bfhl.model.BfhlResponse;
import com.bajaj.bfhl.service.BfhlService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller to handle REST requests for Bajaj Finserv Health Backend Challenge.
 */
@RestController
@RequestMapping("/bfhl")
@CrossOrigin(origins = "*") // Cross-origin resource sharing configured to allow frontend integration
public class BfhlController {

    private static final Logger logger = LoggerFactory.getLogger(BfhlController.class);
    private final BfhlService bfhlService;

    public BfhlController(BfhlService bfhlService) {
        this.bfhlService = bfhlService;
    }

    /**
     * POST /bfhl
     * Accepts a JSON request, classifies numbers and alphabets, and returns user details.
     *
     * @param request the input JSON payload containing "data"
     * @return the classified numbers/alphabets with user credentials
     */
    @PostMapping
    public ResponseEntity<BfhlResponse> processData(@Valid @RequestBody BfhlRequest request) {
        logger.info("Received POST request on /bfhl");
        BfhlResponse response = bfhlService.processRequest(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * GET /bfhl
     * Standard status check endpoint returning a hardcoded operation code.
     *
     * @return operation_code JSON
     */
    @GetMapping
    public ResponseEntity<BfhlGetResponse> getOperationCode() {
        logger.info("Received GET request on /bfhl");
        BfhlGetResponse getResponse = new BfhlGetResponse(1);
        return new ResponseEntity<>(getResponse, HttpStatus.OK);
    }
}
