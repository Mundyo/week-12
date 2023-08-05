package com.promineotech;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

    private TestDemo testDemo;

    @BeforeEach
    void setUp() throws Exception {
        testDemo = new TestDemo();
    }

    @ParameterizedTest
    @MethodSource("argumentsForAddPositive")
    void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
        if (!expectException) {
            assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
        } else {
            assertThatThrownBy(() -> testDemo.addPositive(a, b))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    static Stream<Arguments> argumentsForAddPositive() {
        return Stream.of(
            // Positive numbers that should be added correctly
            Arguments.of(2, 3, 5, false),
            Arguments.of(5, 8, 13, false),

            // Zero and negative numbers that should throw an exception
            Arguments.of(0, 5, 0, true),
            Arguments.of(-3, 4, 0, true),
            Arguments.of(7, -1, 0, true)
        );
    }

    @Test
    void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
        // Test some pairs of positive numbers and their expected sums
        assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
        assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
        assertThat(testDemo.addPositive(33, 67)).isEqualTo(100);
        assertThat(testDemo.addPositive(4, 6)).isEqualTo(10);
        assertThat(testDemo.addPositive(40, 30)).isEqualTo(70);
        assertThat(testDemo.addPositive(7, 3)).isEqualTo(10);
        assertThat(testDemo.addPositive(100, 200)).isEqualTo(300);
    }

    @ParameterizedTest
    @MethodSource("argumentsForMultiplyPositive")
    void assertThatPositiveNumbersAreMultipliedCorrectly(int a, int b, int expected, boolean expectException) {
        if (!expectException) {
            assertThat(testDemo.multiplyPositive(a, b)).isEqualTo(expected);
        } else {
            assertThatThrownBy(() -> testDemo.multiplyPositive(a, b))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    static Stream<Arguments> argumentsForMultiplyPositive() {
        return Stream.of(
            // Positive numbers that should be multiplied correctly
            Arguments.of(2, 3, 6, false),
            Arguments.of(5, 8, 40, false),

            // Zero and negative numbers that should throw an exception
            Arguments.of(0, 5, 0, true),
            Arguments.of(-3, 4, 0, true),
            Arguments.of(7, -1, 0, true)
        );
    }

    @Test
    void assertThatExceptionIsThrownForZeroOrNegativeNumbers() {
        // Test with zero or negative numbers to ensure the method throws an IllegalArgumentException
        assertThatThrownBy(() -> testDemo.multiplyPositive(0, 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Both parameters must be positive!");

        assertThatThrownBy(() -> testDemo.multiplyPositive(-3, 4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Both parameters must be positive!");

        assertThatThrownBy(() -> testDemo.multiplyPositive(7, -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Both parameters must be positive!");
    }
    @Test
    void assertThatNumberSquaredIsCorrect() {
        // Mock the TestDemo class to return 5 when getRandomInt is called
        TestDemo mockDemo = spy(testDemo);
        doReturn(5).when(mockDemo).getRandomInt();

        // Call the method randomNumberSquared on the mocked TestDemo object
        int fiveSquared = mockDemo.randomNumberSquared();

        // Use assertThat to test that the value returned from randomNumberSquared is equal to 5 squared
        assertThat(fiveSquared).isEqualTo(25);
}
}    







