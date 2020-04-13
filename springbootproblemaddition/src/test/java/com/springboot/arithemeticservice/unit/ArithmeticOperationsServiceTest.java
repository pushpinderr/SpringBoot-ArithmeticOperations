package com.springboot.arithemeticservice.unit;

import com.springboot.arithemeticservice.domain.ArithmeticOperationsService;
import com.springboot.arithemeticservice.infrastructure.request.ArithmeticData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArithmeticOperationsServiceTest {
    private ArithmeticOperationsService arithmeticOperationsService;

    @BeforeEach
    public void init() {
        arithmeticOperationsService = new ArithmeticOperationsService();
    }

    @Test
    public void test_addition_of_two_positive_numbers() {
        //Given
        ArithmeticData arithmeticData = new ArithmeticData(100, 50);

        //When
        long sum = arithmeticOperationsService.addNumbers(arithmeticData);

        //Then
        assertEquals(150, sum);
    }

    @Test
    public void test_addition_of_two_negative_numbers() {
        //Given
        ArithmeticData arithmeticData = new ArithmeticData(-100, -50);

        //When
        long sum = arithmeticOperationsService.addNumbers(arithmeticData);

        //Then
        assertEquals(-150, sum);
    }

    @Test
    public void test_addition_of_one_positive_and_one_negative_number() {
        //Given
        ArithmeticData arithmeticData = new ArithmeticData(100, -50);

        //When
        long sum = arithmeticOperationsService.addNumbers(arithmeticData);

        //Then
        assertEquals(50, sum);
    }

    @Test
    public void test_addition_of_a_positive_number_with_zero() {
        //Given
        ArithmeticData arithmeticData = new ArithmeticData(100, 0);

        //When
        long sum = arithmeticOperationsService.addNumbers(arithmeticData);

        //Then
        assertEquals(100, sum);
    }

    @Test
    public void test_addition_of_a_negative_number_with_zero() {
        //Given
        ArithmeticData arithmeticData = new ArithmeticData(-100, 0);

        //When
        long sum = arithmeticOperationsService.addNumbers(arithmeticData);

        //Then
        assertEquals(-100, sum);
    }

    @Test
    public void test_addition_of_two_zeros() {
        //Given
        ArithmeticData arithmeticData = new ArithmeticData(0, 0);

        //When
        long sum = arithmeticOperationsService.addNumbers(arithmeticData);

        //Then
        assertEquals(0, sum);
    }

    @Test
    public void test_subtraction_of_two_positive_numbers() {
        //Given
        ArithmeticData arithmeticData = new ArithmeticData(100, 50);

        //When
        long sum = arithmeticOperationsService.subtractNumbers(arithmeticData);

        //Then
        assertEquals(50, sum);
    }

    @Test
    public void test_subtraction_of_two_negative_numbers() {
        //Given
        ArithmeticData arithmeticData = new ArithmeticData(-100, -50);

        //When
        long sum = arithmeticOperationsService.subtractNumbers(arithmeticData);

        //Then
        assertEquals(-50, sum);
    }

    @Test
    public void test_subtraction_of_one_positive_and_one_negative_number() {
        //Given
        ArithmeticData arithmeticData = new ArithmeticData(100, -50);

        //When
        long sum = arithmeticOperationsService.subtractNumbers(arithmeticData);

        //Then
        assertEquals(150, sum);
    }

    @Test
    public void test_subtraction_of_a_positive_number_with_zero() {
        //Given
        ArithmeticData arithmeticData = new ArithmeticData(100, 0);

        //When
        long sum = arithmeticOperationsService.subtractNumbers(arithmeticData);

        //Then
        assertEquals(100, sum);
    }

    @Test
    public void test_subtraction_of_a_negative_number_with_zero() {
        //Given
        ArithmeticData arithmeticData = new ArithmeticData(-100, 0);

        //When
        long sum = arithmeticOperationsService.subtractNumbers(arithmeticData);

        //Then
        assertEquals(-100, sum);
    }

    @Test
    public void test_subtraction_of_two_zeros() {
        //Given
        ArithmeticData arithmeticData = new ArithmeticData(0, 0);

        //When
        long sum = arithmeticOperationsService.subtractNumbers(arithmeticData);

        //Then
        assertEquals(0, sum);
    }
}