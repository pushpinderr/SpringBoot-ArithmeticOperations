package com.springboot.arithemeticservice.infrastructure.rest;

import com.springboot.arithemeticservice.domain.ArithmeticOperationsService;
import com.springboot.arithemeticservice.infrastructure.IArithmeticOperationsController;
import com.springboot.arithemeticservice.infrastructure.request.ArithmeticData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping(path = "/api")
public class ArithmeticOperationsController implements IArithmeticOperationsController {
    @Autowired
    private ArithmeticOperationsService arithmeticOperationsService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ArithmeticOperationsController.class);

    @Override
    @PostMapping(path = "/add",
            produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE, TEXT_PLAIN_VALUE},
            consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE, TEXT_PLAIN_VALUE})
    public ResponseEntity addNumbers(@RequestBody ArithmeticData arithmeticData) {
        LOGGER.info("Addition request received for numbers x: {} and y: {}", arithmeticData.getX(), arithmeticData.getY());
        return new ResponseEntity(arithmeticOperationsService.addNumbers(arithmeticData), OK);
    }

    @Override
    @PostMapping(path = "/diff",
            produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE, TEXT_PLAIN_VALUE},
            consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE, TEXT_PLAIN_VALUE})
    public ResponseEntity subtractNumbers(@RequestBody ArithmeticData arithmeticData) {
        LOGGER.info("Subtraction request received for numbers x: {} and y: {}", arithmeticData.getX(), arithmeticData.getY());
        return new ResponseEntity(arithmeticOperationsService.subtractNumbers(arithmeticData), OK);
    }
}