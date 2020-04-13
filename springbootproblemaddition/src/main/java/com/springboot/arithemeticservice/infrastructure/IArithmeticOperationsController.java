package com.springboot.arithemeticservice.infrastructure;

import com.springboot.arithemeticservice.infrastructure.request.ArithmeticData;
import org.springframework.http.ResponseEntity;

public interface IArithmeticOperationsController {
    ResponseEntity addNumbers(ArithmeticData arithmeticData);

    ResponseEntity subtractNumbers(ArithmeticData arithmeticData);
}
