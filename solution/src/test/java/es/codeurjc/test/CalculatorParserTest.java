package es.codeurjc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorParserTest {
    private CalculatorParser calculator;
    
    @BeforeEach
    public void setUp() {
        calculator = new CalculatorParser();
    }

    @Test
    @DisplayName("Un número se devuelve como tal")
    public void testSingleNumber() {
        CalculatorParser calculator = new CalculatorParser();
        assertEquals(1, calculator.parse("1"));
    }

    @Test
    @DisplayName("Introducimos la suma")
    public void testSuma() {
        CalculatorParser calculator = new CalculatorParser();
        assertEquals(2, calculator.parse("1 + 1"));
    }

    @Test
    @DisplayName("Introducimos la resta")
    public void testResta() {
        CalculatorParser calculator = new CalculatorParser();
        assertEquals(2, calculator.parse("5 - 3"));
    }

    @Test
    @DisplayName("No se permiten letras, se lanzará una excepción")
    public void testLetra() {
        
        assertThrows(UnsupportedOperationException.class, () -> {
            calculator.parse("A");
        });
    }

    @Test
    @DisplayName("Introducimos la resta")
    public void testOpeConcat() {
        CalculatorParser calculator = new CalculatorParser();
        assertEquals(1, calculator.parse("5 - 3 - 1"));
    }
}

