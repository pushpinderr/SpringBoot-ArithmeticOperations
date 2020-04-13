package com.springboot.arithemeticservice.domain;

import com.springboot.arithemeticservice.infrastructure.request.ArithmeticData;
import com.springboot.arithemeticservice.infrastructure.rest.ArithmeticOperationsController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArithmeticOperationsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArithmeticOperationsController.class);

    public long addNumbers(ArithmeticData arithmeticData) {
        LOGGER.info("Addition request received for numbers x: {} and y: {}", arithmeticData.getX(), arithmeticData.getY());
        return arithmeticData.getX() + arithmeticData.getY();
    }

    public long subtractNumbers(ArithmeticData arithmeticData) {
        LOGGER.info("Subtraction request received for numbers x: {} and y: {}", arithmeticData.getX(), arithmeticData.getY());
        return arithmeticData.getX() - arithmeticData.getY();
    }
}