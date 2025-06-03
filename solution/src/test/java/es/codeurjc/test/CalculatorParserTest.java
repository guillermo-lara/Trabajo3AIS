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
    public void test1() {
        assertEquals(1, calculator.parse("1"));
    }

    @Test
    @DisplayName("Un número se devuelve como tal")
    public void test2() {
        assertEquals(2, calculator.parse("2"));
    }

    @Test
    @DisplayName("Un número se devuelve como tal")
    public void test3() {
        assertEquals(3, calculator.parse("3"));
    }

    @Test
    @DisplayName("Suma simple de dos números")
    public void test4() {
        assertEquals(2, calculator.parse("1 + 1"));
    }

    @Test
    @DisplayName("Suma de dos números diferentes")
    public void test5() {
        assertEquals(5, calculator.parse("2 + 3"));
    }

    @Test
    @DisplayName("Suma de tres números")
    public void test6() {
        assertEquals(9, calculator.parse("2 + 3 + 4"));
    }

    @Test
    @DisplayName("Un número se devuelve como tal")
    public void test7() {
        assertEquals(10, calculator.parse("1 + 2 + 3 + 4"));
    }

    @Test
    @DisplayName("No se permiten letras, se lanzará una excepción")
    public void test8() {
        assertThrows(UnsupportedOperationException.class, () -> {
            calculator.parse("A");
        });
    }

    @Test
    @DisplayName("No se permiten letras, se lanzará una excepción")
    public void test9() {
        assertThrows(UnsupportedOperationException.class, () -> {
            calculator.parse("B");
        });
    }

@Test
@DisplayName("No se permiten letras, se lanzará una excepción")
public void test10() {
    assertThrows(UnsupportedOperationException.class, () -> {
        calculator.parse("k");
    });
}


@Test
@DisplayName("No se permiten palabras, se lanzará una excepción")
public void test11() {
    assertThrows(UnsupportedOperationException.class, () -> {
        calculator.parse("HoLa");
    });
}

@Test
@DisplayName("No se permiten expresiones con letras")
public void test12() {
    assertThrows(UnsupportedOperationException.class, () -> {
        calculator.parse("1 + A");
    });
}

@Test
@DisplayName("Test operación de resta")
public void test13() {
    CalculatorParser calculator = new CalculatorParser();
    assertEquals(2, calculator.parse("5 - 3"));
}

@Test
@DisplayName("Test resta con resultado negativo")
public void test14() {
    assertEquals(-1, calculator.parse("1 - 2"));
}

@Test
@DisplayName("Test múltiples restas consecutivas")
public void test15() {
    assertEquals(4, calculator.parse("7 - 2 - 1"));
}
@Test
@DisplayName("Test múltiples restas consecutivas con 4 operandos")
public void test16() {
    assertEquals(0, calculator.parse("9 - 5 - 3 - 1"));
}

@Test
@DisplayName("Test combinación de sumas y restas")
public void test17() {
    assertEquals(3, calculator.parse("7 + 1 - 5"));
}

@Test
@DisplayName("Test combinación de resta y suma")
public void test18() {
    assertEquals(8, calculator.parse("9 - 5 + 4"));
}

@Test
@DisplayName("Test combinación compleja de operaciones")
public void test19() {
    assertEquals(2, calculator.parse("9 + 1 - 6 - 2"));
}

@Test
@DisplayName("Test expresión compleja con múltiples operaciones")
public void test20() {
    assertEquals(2, calculator.parse("9 + 1 - 6 - 2"));
}




}
