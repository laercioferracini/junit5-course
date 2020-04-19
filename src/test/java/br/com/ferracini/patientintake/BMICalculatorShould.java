package br.com.ferracini.patientintake;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author lferracini
 * @project = course-junit5
 * @since <pre>19/04/2020</pre>
 */
@DisplayName("BMI Calculator should")
class BMICalculatorShould {

    @Test
    @DisplayName("calculate BMI to two places correctly via inches and pounds")
    void calculateBmiCorrectly() {
        assertEquals(19.2, BMICalculator.calculateBmi(69, 130));
        assertEquals(21.52, BMICalculator.calculateBmi(70, 150));
    }
}