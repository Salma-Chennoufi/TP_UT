/*
 * Copyright 2015-2025 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * https://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTests {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }


    // CAS NORMAUX

    @Test
    void testAdd_NormalCase() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void testSubtract_NormalCase() {
        assertEquals(2, calculator.subtract(5, 3));
    }

    @Test
    void testMultiply_NormalCase() {
        assertEquals(12, calculator.multiply(3, 4));
    }

    @Test
    void testDivide_NormalCase() {
        assertEquals(2, calculator.divide(10, 5));
    }


    //  CAS LIMITES


    @Test
    void testAdd_WithZero() {
        assertEquals(7, calculator.add(7, 0));
    }

    @Test
    void testMultiply_WithZero() {
        assertEquals(0, calculator.multiply(9, 0));
    }

    @Test
    void testSubtract_NegativeResult() {
        assertEquals(-2, calculator.subtract(3, 5));
    }

    @Test
    void testAdd_LargeNumbers() {
        assertEquals(2_000_000_000, calculator.add(1_000_000_000, 1_000_000_000));
    }

    // EXCEPTIONS


    @Test
    void testDivide_ByZero() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.divide(10, 0));
    }



/*
	@Test
	@DisplayName("1 + 1 = 2")
	void addsTwoNumbers() {
		Calculator calculator = new Calculator();
		assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
	}

	@ParameterizedTest(name = "{0} + {1} = {2}", quoteTextArguments = false)
	@CsvSource(textBlock = """
			0,    1,   1
			1,    2,   3
			49,  51, 100
			1,  100, 101
			""")
	void add(int first, int second, int expectedResult) {
		Calculator calculator = new Calculator();
		assertEquals(expectedResult, calculator.add(first, second),
				() -> first + " + " + second + " should equal " + expectedResult);
	}

 */
}
