package com.ctw.workstation;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;


class MathOperationsTest {

    private static final Logger log = LoggerFactory.getLogger(MathOperationsTest.class);
    private static MathOperations operator;

    @BeforeAll
    static void setUp() {
        log.info("Setting up tests");
        operator = new MathOperations();
    }

    @BeforeEach
    void setUpEach() {
        log.info("Setting up before each test");
    }

    @AfterAll
    static void tearDown() {
        log.info("Closing tests");
    }

    @AfterEach
    void tearDownEach() {
        log.info("Tearing down after each test");
    }

    @Test
    public void adds_two_numbers_successfully() {
        // given
        int a = 5;
        int b = 6;
        int c = 7;

        // then
        assertAll(
                // when
                () -> assertEquals(11, operator.add(a,b)),
                () -> assertEquals(13, operator.add(b,c)),
                () -> assertEquals(12, operator.add(a,c))
        );
    }

    @Test
    public void divides_two_numbers_successfully() {
        // given
        int a = 10;
        int b = 2;

        // when
        int result = operator.divide(a, b);

        // then
        assertEquals(5, result);
    }

    @Test
    public void returns_zero_when_divisor_is_bigger_than_dividend() {
        // given
        int a = 1;
        int b = 2;

        // when
        int result = operator.divide(a, b);

        // then
        assertEquals(0.0, result);
    }

    @Test
    public void throws_arithmetic_exception_when_divisor_is_zero() {
        // given
        int a = 1;
        int b = 0;

        // then
        assertThrows(ArithmeticException.class, () -> {
            // when
            operator.divide(a, b);
        });

    }

}