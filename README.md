# CalculatorParser

Nombre de los alumnos: Guillermo Manuel Lara Salazar y Paula Marcela Barroso Robleda

### Ejemplo 1

**INPUT y OUTPUT**: "1" -> 1

**EJ1. Código de test**
```java
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
}
```

**EJ1. Mensaje del test añadido que NO PASA**
```log
java.lang.UnsupportedOperationException: Not implemented yet 
```

**EJ1. Código mínimo para que el test pase**

Se implementa el valor fijo 1 para hacer pasar la prueba

```java
public int parse(String expression) {
    int num = 1;   
    return num;
}
```

**EJ1. Captura de que TODOS los test PASAN**

![Pasa](capturas/image1_1.png "Pasa")

**EJ1. Refactorización**

Se simplifica el código eliminando la variable temporal innecesaria
```java
public int parse(String expression) {
    return 1;
}
```

**EJ1. Captura de que TODOS los tests PASAN tras la refactorización**

![Pasa](capturas/image1_2.png "Pasa tras refactorización")

### Ejemplo 2


**INPUT y OUTPUT**: "2" -> 2

**EJ2. Código de test**
```java
    @Test
    @DisplayName("Un número se devuelve como tal")
    public void test2() {
        assertEquals(2, calculator.parse("2"));
    }

```

**EJ2. Mensaje del test añadido que NO PASA**
```log
org.opentest4j.AssertionFailedError: expected: <2> but was: <1>
```

**EJ2. Código mínimo para que el test pase**

Se implementa un condicional para manejar ambos casos ("1" y "2")

```java
public int parse(String expression) {
    if(expression.equals("2")) {
        return 2;
    }
    return 1;
}
```

**EJ2. Captura de que TODOS los test PASAN**

![Pasa](capturas/image2_1.png "Test pasa con implementación inicial")

**EJ2. Refactorización**

En este caso consideramos que no hace falta refactorización.

### Ejemplo 3


**INPUT y OUTPUT**: "3" -> 3

**EJ3. Código de test**
```java
    @Test
    @DisplayName("Un número se devuelve como tal")
    public void test3() {
        assertEquals(3, calculator.parse("3"));
    }
```

**EJ3. Mensaje del test añadido que NO PASA**
```log
org.opentest4j.AssertionFailedError: expected: <3> but was: <1>
```

**EJ3. Código mínimo para que el test pase**
Si input es 1, devolverá 1; si es 2, devuelve 2 y, en cualquier otro caso, devuelve 3.
Se implementa la conversión directa del String a int usando Integer.parseInt()

```java
public int parse(String expression) {
    return Integer.parseInt(expression);
}
```

**EJ3. Captura de que TODOS los test PASAN**

![Pasa](capturas/image3_1.png "Test pasa con implementación inicial")

**EJ3. Refactorización**

En este caso consideramos que no hace falta refactorización.

### Ejemplo 4

**INPUT y OUTPUT**: "1 + 1" → 2

**EJ4. Código de test**
```java

    @Test
    @DisplayName("Suma simple de dos números")
    public void test4() {
        assertEquals(2, calculator.parse("1 + 1"));
    }
```

**EJ4. Mensaje del test añadido que NO PASA**
```log
java.lang.NumberFormatException: For input string: "1 + 1"
```

**EJ4. Código mínimo para que el test pase**

Se implementa un caso específico para la suma "1 + 1"

```java
public int parse(String expression) {
    String secuence = "1 + 1";
    if (expression.equals(secuence)) {
        return 2;
    } else {
        return Integer.parseInt(expression);
    }
}
```

**EJ4. Captura de que TODOS los test PASAN**

![Pasa](capturas/image4_1.png "Test pasa con implementación inicial")

**EJ4. Refactorización**

Se simplifica eliminando la variable temporal innecesaria

```java
public int parse(String expression) {
    if (expression.equals("1 + 1")) {
        return 2;
    }
    return Integer.parseInt(expression);
}
```

**EJ4. Captura de que TODOS los tests PASAN tras la refactorización**

![Pasa](capturas/image4_2.png "Test pasa tras refactorización")

### Ejemplo 5

**INPUT y OUTPUT**: "2 + 3" → 5

**EJ5. Código de test**
```java
    @Test
    @DisplayName("Suma de dos números diferentes")
    public void test5() {
        assertEquals(5, calculator.parse("2 + 3"));
    }
```

**EJ5. Mensaje del test añadido que NO PASA**
```log
java.lang.NumberFormatException: For input string: "2 + 3"
```

**EJ5. Código mínimo para que el test pase**

Hace la suma si hay dos números con un "+" en medio, y si no, solo devuelve el número que le pasaste. Para ello divimos los caracteres del String con la función trim().

```java
public int parse(String expression) {
    expression = expression.trim();
    String[] parts = expression.split(" ");
    
    if(parts.length == 3) {
        int num1 = Integer.parseInt(parts[0]);
        int num2 = Integer.parseInt(parts[2]);
        return num1 + num2;
    }
    else if (parts.length == 1){
    return Integer.parseInt(expression);
    }
    else throw new UnsupportedOperationException("Not implemented yet");
}
```

**EJ5. Captura de que TODOS los test PASAN**

![Pasa](capturas/image5_1.png "Test pasa con implementación inicial")

**EJ5. Refactorización**

En este caso consideramos que no hace falta refactorización.

### Ejemplo 6

**INPUT y OUTPUT**: "2 + 3 + 4" → 9

**EJ6. Código de test**
```java
    @Test
    @DisplayName("Suma de tres números")
    public void test6() {
        assertEquals(9, calculator.parse("2 + 3 + 4"));
    }
```

**EJ6. Mensaje del test añadido que NO PASA**
```log
java.lang.UnsupportedOperationException: Not implemented yet
```

**EJ6. Código mínimo para que el test pase**

El codigo divide el String que se pasa por terminal en un Array de Strungs, los numeros pares del Array de Strings contienen los números y dependiendo del tamaño del Array se procesa de una manera u otra

```java
public int parse(String expression) {
    expression = expression.trim();
    String[] parts = expression.split(" ");
    
    if (parts.lenght == 1){
        return Integer.parseInt(parts[0]);
    }
    else if(parts.length == 3) {
        return Integer.parseInt(parts[0]) + Integer.parseInt(parts[2]);
    } else if(parts.length == 5) {
        return Integer.parseInt(parts[0]) + Integer.parseInt(parts[2]) + Integer.parseInt(parts[4]);
    }
    else throw new UnsupportedOperationException("Not implemented yet");
}
```

**EJ6. Captura de que TODOS los test PASAN**

![Pasa](capturas/image6_1.png "Test pasa con implementación inicial")

**EJ6. Refactorización**

En este caso consideramos que no hace falta refactorización.

### Ejemplo 7

**INPUT y OUTPUT**: "1 + 2 + 3 + 4" -> 10

**EJ7. Código de test**
```java
    @Test
    @DisplayName("Un número se devuelve como tal")
    public void test7() {
        assertEquals(10, calculator.parse("1 + 2 + 3 + 4"));
    }
```

**EJ7. Mensaje del test añadido que NO PASA**

```log
java.lang.UnsupportedOperationException: Not implemented yet
```

**EJ7. Código mínimo para que el test pase**

Nos hemos dado cuenta que siempre hay un espacio entre caracteres que podemos utilizar para separarlos y poder capturar los datos que necesitamos. Sigue siempre una misma fórmula, "número" "+" "número" o "número" a partir de aqui hemos desarrollado un código que sigue esta fórmula.

```java
public int parse(String expression) {
    expression = expression.trim();
    String[] caracteres = expression.split(" ");
    
    int numero = Integer.parseInt(caracteres[0]);
    for(int i = 0; i < caracteres.length - 1; i = i + 2){
        if (caracteres[i+1].equals("+")){
            numero += Integer.parseInt(caracteres[i+2]);
        } else throw new UnsupportedOperationException("Not implemented yet");
    }
    return numero;
}
```

**EJ7. Captura de que TODOS los test PASAN**

![Pasa](capturas/image7_1.png "Pasa")

**EJ7. Refactorización**

En este caso consideramos que no hace falta refactorización.

### Ejemplo 8

**INPUT y OUTPUT**: "A" -> UnsupportedOperationException

**EJ8. Código de test**
```java
    @Test
    @DisplayName("No se permiten letras, se lanzará una excepción")
    public void test8() {
        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () -> {
            calculator.parse("A");
        });
        assertEquals("Invalid expression", exception.getMessage());
    }
```

**EJ8. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: Unexpected exception type thrown, 
expected: <java.lang.UnsupportedOperationException> 
but was: <java.lang.NumberFormatException>
        at org.junit.jupiter.api.AssertionFailureBuilder.build(AssertionFailureBuilder.java:151)
        at org.junit.jupiter.api.AssertThrows.assertThrows(AssertThrows.java:67)
        ...
Caused by: java.lang.NumberFormatException: For input string: "A"
        at java.base/java.lang.Integer.parseInt(Integer.java:662)
        at es.codeurjc.test.CalculatorParser.parse(CalculatorParser.java:70)
        ...
```

**EJ8. Código mínimo para que el test pase**

Se añade una comprobación específica para el carácter "A" que lanza la excepción requerida.

```java
public int parse(String expression) {
    expression = expression.trim();
    if(expression.equals("A")) { 
        throw new UnsupportedOperationException("Invalid expression");
    }
    String[] caracteres = expression.split(" ");
    int numero = Integer.parseInt(caracteres[0]);
    for(int i = 0; i < caracteres.length - 1; i = i + 2) {
        if (caracteres[i+1].equals("+")) {
            numero += Integer.parseInt(caracteres[i+2]);
        } else throw new UnsupportedOperationException("Not implemented yet");
    }
    return numero;
}
```

**EJ8. Captura de que TODOS los test PASAN**

![Pasa](capturas/image8.png "Pasa")

**EJ8. Refactorización**

En este caso consideramos que no hace falta refactorización.

### Ejemplo 9


**INPUT y OUTPUT**: "B" -> UnsupportedOperationException

**EJ9. Código de test**
```java
    @Test
    @DisplayName("No se permiten letras, se lanzará una excepción")
    public void test9() {
        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () -> {
            calculator.parse("B");
        });
        assertEquals("Invalid expression", exception.getMessage());
    }
```

**EJ9. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: Unexpected exception type thrown,
expected: <java.lang.UnsupportedOperationException>
but was: <java.lang.NumberFormatException>
        at org.junit.jupiter.api.AssertionFailureBuilder.build(AssertionFailureBuilder.java:151)
        ...
Caused by: java.lang.NumberFormatException: For input string: "B"
        at java.base/java.lang.Integer.parseInt(Integer.java:662)
        ...
```

**EJ9. Código mínimo para que el test pase**

Implementación inicial que comprueba específicamente "A" o "B"

```java
public int parse(String expression) {
    expression = expression.trim();
    if(expression.equals("A") || expression.equals("B")) {
        throw new UnsupportedOperationException("Invalid expression");
    }
    String[] caracteres = expression.split(" ");
    
    int numero = Integer.parseInt(caracteres[0]);
    for(int i = 0; i < caracteres.length - 1; i = i + 2) {
        if (caracteres[i+1].equals("+")) {
            numero += Integer.parseInt(caracteres[i+2]);
        } else throw new UnsupportedOperationException("Not implemented yet");
    }
    return numero;
}
```

**EJ9. Captura de que TODOS los test PASAN**

![Pasa](capturas/image9.png "Pasa")

**EJ9. Refactorización**

En este caso consideramos que no hace falta refactorización.

### Ejemplo 10

**INPUT y OUTPUT**: "k" → UnsupportedOperationException

**EJ10. Código de test**
```java
    @Test
    @DisplayName("No se permiten letras, se lanzará una excepción")
    public void testLetra() {
        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () -> {
            calculator.parse("k");
        });
        assertEquals("Invalid expression", exception.getMessage());

    }
```

**EJ10. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: Unexpected exception type thrown, 
expected: <java.lang.UnsupportedOperationException> 
but was: <java.lang.NumberFormatException>
        at org.junit.jupiter.api.AssertionFailureBuilder.build(...)
        ...
Caused by: java.lang.NumberFormatException: For input string: "k"
        at java.base/java.lang.Integer.parseInt(...)
        ...
```

**EJ10. Código mínimo para que el test pase**

Implementación inicial que comprueba específicamente "A", "B" o "k":

```java
public int parse(String expression) {
    expression = expression.trim();
    if(expression.equals("A") || expression.equals("B") || expression.equals("k")) {
        throw new UnsupportedOperationException("Invalid expression");
    }
    String[] caracteres = expression.split(" ");
    
    int numero = Integer.parseInt(caracteres[0]);
    for(int i = 0; i < caracteres.length - 1; i = i + 2) {
        if (caracteres[i+1].equals("+")) {
            numero += Integer.parseInt(caracteres[i+2]);
        } else throw new UnsupportedOperationException("Not implemented yet");
    }
    return numero;
}
```

**EJ10. Captura de que TODOS los test PASAN**

![Pasa](capturas/image10.png "Pasa")

**EJ10. Refactorización**

En este caso consideramos que no hace falta refactorización.

### Ejemplo 11


**INPUT y OUTPUT**: "HoLa" → UnsupportedOperationException

**EJ11. Código de test**
```java
    @Test
    @DisplayName("No se permiten palabras, se lanzará una excepción")
    public void test10() {
        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () -> {
            calculator.parse("HoLa");
        });
        assertEquals("Invalid expression", exception.getMessage());
    }
```

**EJ11. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: Unexpected exception type thrown, 
expected: <java.lang.UnsupportedOperationException> 
but was: <java.lang.NumberFormatException>
        at org.junit.jupiter.api.AssertionFailureBuilder.build(...)
        ...
Caused by: java.lang.NumberFormatException: For input string: "HoLa"
        at java.base/java.lang.Integer.parseInt(...)
        ...
```

**EJ11. Código mínimo para que el test pase**

Este código suma números separados por "+" en una cadena, y lanza error si la expresión solo tiene letras.

```java
    public int parse(String expression) {
        expression = expression.trim();
        	 if(expression.matches("^[A-Za-z]+$")){
            throw new UnsupportedOperationException("Invalid expression");
        }
        String[] caracteres = expression.split(" ");
        int inicio=0;
        int numero=Integer.parseInt(caracteres[0]);
        for(int i=inicio;i<caracteres.length-1;i=i+2){
            if (caracteres[i+1].equals("+")){
                    numero+=Integer.parseInt(caracteres[i+2]);
            }else throw new UnsupportedOperationException("Not implemented yet");
        }
        return numero;
    }
```

**EJ11. Captura de que TODOS los test PASAN**

![Pasa](capturas/image11.png "Pasa")

**EJ11. Refactorización**

En este caso consideramos que no hace falta refactorización.

### Ejemplo 12


**INPUT y OUTPUT**: "1 + A" → UnsupportedOperationException

**EJ12. Código de test**
```java
    @Test
    @DisplayName("No se permiten expresiones con letras")
    public void test12() {
        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () -> {
            calculator.parse("1 + A");
        });
        assertEquals("Invalid expression", exception.getMessage());
    }
```

**EJ12. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: Unexpected exception type thrown, 
expected: <java.lang.UnsupportedOperationException> 
but was: <java.lang.NumberFormatException>
        at org.junit.jupiter.api.AssertionFailureBuilder.build(...)
        ...
Caused by: java.lang.NumberFormatException: For input string: "A"
        at java.base/java.lang.Integer.parseInt(...)
        ...
```

**EJ12. Código mínimo para que el test pase**

Este código suma números separados por "+" y lanza un error si la expresión contiene letras.

```java
    public int parse(String expression) {
        expression = expression.trim();
        	 if(expression.matches(".*[A-Za-z].*")){
            throw new UnsupportedOperationException("Invalid expression");
        }
        String[] caracteres = expression.split(" ");
        int inicio=0;
        int numero=Integer.parseInt(caracteres[0]);
        for(int i=inicio;i<caracteres.length-1;i=i+2){
            if (caracteres[i+1].equals("+")){
                    numero+=Integer.parseInt(caracteres[i+2]);
            }else throw new UnsupportedOperationException("Not implemented yet");
        }
        return numero;
    }
```

**EJ12. Captura de que TODOS los test PASAN**

![Pasa](capturas/image12.png "Pasa")

**EJ12. Refactorización**

En este caso consideramos que no hace falta refactorización.

### Ejemplo 13

**INPUT y OUTPUT**: "5 - 3" → 2

**EJ13. Código de test**
```java
@Test
@DisplayName("Test operación de resta")
public void test13() {
    assertEquals(2, calculator.parse("5 - 3"));
}
```

**EJ13. Mensaje del test añadido que NO PASA**

```log
java.lang.UnsupportedOperationException: Not implemented yet
```

**EJ13. Código mínimo para que el test pase**

Este código evalúa sumas de números (como "1 + 2 + 3"), lanza error si hay letras, y solo resuelve "5 - 3" como una resta específica.

```java
  public int parse(String expression) {
        expression = expression.trim();
        if((expression.matches(".*[A-Za-z].*"))){ 
            throw new UnsupportedOperationException("Invalid expression");
        }else{
            String[] caracteres = expression.split(" ");
            int inicio=0;
            int numero=Integer.parseInt(caracteres[0]);
            if(expression.length()==1){
                return numero;
            }
            if(caracteres[1].equals("+")){
                for(int i=inicio;i<caracteres.length-1;i=i+2){
                    if (caracteres[i+1].equals("+")){
                            numero+=Integer.parseInt(caracteres[i+2]);
                    }
                }
                return numero;
            }else{
                if (expression.equals("5 - 3")){
                    int result=2;
                    return result;
                }
            }
            return 0;
        }
    }
```

**EJ13. Captura de que TODOS los test PASAN**

![Pasa](capturas/image13_1.png "Pasa")

**EJ13. Refactorización**

Se quitó una variable que no hacía falta, se devolvió el valor directo, se junto el else if y se añadió el throw del Not implemented yet, dejando el código más limpio y rápido de leer.

```java
public int parse(String expression) {
        expression = expression.trim();
        if((expression.matches(".*[A-Za-z].*"))){ 
            throw new UnsupportedOperationException("Invalid expression");
        }else{
            String[] caracteres = expression.split(" ");
            int inicio=0;
            int numero=Integer.parseInt(caracteres[0]);
            if(expression.length()==1){
                return numero;
            }
            if(caracteres[1].equals("+")){
                for(int i=inicio;i<caracteres.length-1;i=i+2){
                    if (caracteres[i+1].equals("+")){
                            numero+=Integer.parseInt(caracteres[i+2]);
                    }
                }
                return numero;
            }else if (expression.equals("5 - 3")){
                return 2;
            } else throw new UnsupportedOperationException("Not implemented yet");
        }
    }
```

**EJ13. Captura de que TODOS los tests PASAN tras la refactorización**

![Pasa](capturas/image13_2.png "Pasa")

### Ejemplo 14

**INPUT y OUTPUT**: "1 - 2" → -1

**EJ14. Código de test**
```java
@Test
@DisplayName("Test resta con resultado negativo")
public void test14() {
    assertEquals(-1, calculator.parse("1 - 2"));
}
```

**EJ14. Mensaje del test añadido que NO PASA**

```log
java.lang.UnsupportedOperationException: Not implemented yet 
```

**EJ14. Código mínimo para que el test pase**

Este código suma números si la expresión usa "+", resuelve "5 - 3" como caso especial, lanza error si hay letras y devuelve -1 si no reconoce la operación.

```java
    public int parse(String expression) {
        expression = expression.trim();
        if((expression.matches(".*[A-Za-z].*"))){ 
            throw new UnsupportedOperationException("Invalid expression");
        }else{
            String[] caracteres = expression.split(" ");
            int inicio=0;
            int numero=Integer.parseInt(caracteres[0]);
            if(expression.length()==1){
                return numero;
            }
            if(caracteres[1].equals("+")){
                for(int i=inicio;i<caracteres.length-1;i=i+2){
                    if (caracteres[i+1].equals("+")){
                            numero+=Integer.parseInt(caracteres[i+2]);
                    }
                }
                return numero;
            }else if (expression.equals("5 - 3")){
                    return -2;
            }else if (expression.equals("1 - 2")){
                    return -1;
            }else throw new UnsupportedOperationException("Not implemented yet");
        }
    }

```

**EJ14. Captura de que TODOS los test PASAN**

![Pasa](capturas/image14.png "Pasa")

### Ejemplo 15


**INPUT y OUTPUT**: "7 - 2 - 1" → 4

**EJ15. Código de test**
```java
@Test
@DisplayName("Test múltiples restas consecutivas")
public void testMultiplesRestas() {
    assertEquals(4, calculator.parse("7 - 2 - 1"));
}
```

**EJ15. Mensaje del test añadido que NO PASA**

```log
java.lang.UnsupportedOperationException: Not implemented yet 
```

**EJ15. Código mínimo para que el test pase**

Se ha programado este código teniendo en cuenta de que la cadena de caracteres si tiene un "+" todas las funciones de serán restas, si al principio entra un "-" dependiendo de la cantidad de caracteres hará una resta con 2 números o 3 números.

```java
        public int parse(String expression) {
        expression = expression.trim();
        if((expression.matches(".*[A-Za-z].*"))){ 
            throw new UnsupportedOperationException("Invalid expression");

        }else{
            String[] characters = expression.split(" ");
            int inicio=0;
            int numero=Integer.parseInt(characters[0]);
            if(expression.length()==1){
                return numero;
            }
            if(characters[1].equals("+")){
                for(int i=inicio;i<characters.length-1;i=i+2){
                    if (characters[i+1].equals("+")){
                            numero+=Integer.parseInt(characters[i+2]);
                    }else throw new UnsupportedOperationException("Not implemented yet");
                }
                return numero;
            }else if (characters.length==3){
                return Integer.parseInt(characters[0]) - Integer.parseInt(characters[2]);
            }else if (characters.length==5){
                return Integer.parseInt(characters[0]) - Integer.parseInt(characters[2]) - Integer.parseInt(characters[4]);
            }else throw new UnsupportedOperationException("Not implemented yet");
        }
    }
```

**EJ15. Captura de que TODOS los test PASAN**

![Pasa](capturas/image15.png "Pasa")


### Ejemplo 16

**INPUT y OUTPUT**: "9 - 5 - 3 - 1" → 0

**EJ16. Código de test**
```java
@Test
@DisplayName("Test múltiples restas consecutivas con 4 operandos")
public void test16() {
    assertEquals(0, calculator.parse("9 - 5 - 3 - 1"));
}
```

**EJ16. Mensaje del test añadido que NO PASA**

```log
java.lang.UnsupportedOperationException: Not implemented yet
```

**EJ16. Código mínimo para que el test pase**

Nos hemos dado cuenta que el primer simbolo indica el tipo de operación que se va a realizar, si el primer simbolo es un "+" se realizaran sumas hasta llegar al final del Array, si fuese un "-" se realizarian restas.

```java
    public int parse(String expression) {
        expression = expression.trim();
        if((expression.matches(".*[A-Za-z].*"))){ 
            throw new UnsupportedOperationException("Invalid expression");

        }else{
            String[] characters = expression.split(" ");
            int inicio=0;
            int numero=Integer.parseInt(characters[0]);
            if(expression.length()==1){
                return numero;
            }
            if(characters[1].equals("+")){
                for(int i=inicio;i<characters.length-1;i=i+2){
                    if (characters[i+1].equals("+")){
                            numero+=Integer.parseInt(characters[i+2]);
                    }else throw new UnsupportedOperationException("Not implemented yet");
                }
                return numero;
            }else if(characters[1].equals("-")){
                for(int i=inicio;i<characters.length-1;i=i+2){
                    if (characters[i+1].equals("-")){
                            numero-=Integer.parseInt(characters[i+2]);
                    }else throw new UnsupportedOperationException("Not implemented yet");
                }
                return numero;
            }else throw new UnsupportedOperationException("Not implemented yet");
        }
    }
```


**EJ16. Captura de que TODOS los test PASAN**

![Pasa](capturas/image16.png "Pasa")


### Ejemplo 17

**INPUT y OUTPUT**: "7 + 1 - 5" → 3

**EJ17. Código de test**
```java
@Test
@DisplayName("Test combinación de sumas y restas")
public void test17() {
    assertEquals(3, calculator.parse("7 + 1 - 5"));
}
```

**EJ17. Mensaje del test añadido que NO PASA**

```log
java.lang.UnsupportedOperationException: Not implemented yet
```

**EJ17. Código mínimo para que el test pase**

Ahora si el primer símbolo es "+" no indica que el resto de operaciones vayan a ser sumas, por lo que hay que añadir en el for dedicado a las sumas que tambíen pueden haber restas.

```java
    public int parse(String expression) {
        expression = expression.trim();
        if((expression.matches(".*[A-Za-z].*"))){ 
            throw new UnsupportedOperationException("Invalid expression");

        }else{
            String[] characters = expression.split(" ");
            int inicio=0;
            int numero=Integer.parseInt(characters[0]);
            if(expression.length()==1){
                return numero;
            }
            if(characters[1].equals("+")){
                for(int i=inicio;i<characters.length-1;i=i+2){
                    if (characters[i+1].equals("+")){
                            numero+=Integer.parseInt(characters[i+2]);
                    }else if (characters[i+1].equals("-")){
                            numero-= 5;
                    }
                    else throw new UnsupportedOperationException("Not implemented yet");
                }
                return numero;
            }else if(characters[1].equals("-")){
                for(int i=inicio;i<characters.length-1;i=i+2){
                    if (characters[i+1].equals("-")){
                            numero-=Integer.parseInt(characters[i+2]);
                    }else throw new UnsupportedOperationException("Not implemented yet");
                }
                return numero;
            }else throw new UnsupportedOperationException("Not implemented yet");
        }
    }
```

**EJ17. Captura de que TODOS los test PASAN**

![Pasa](capturas/image17.png "Pasa")

### Ejemplo 18

**INPUT y OUTPUT**: "9 - 5 + 4" → 8

**EJ18. Código de test**
```java
@Test
@DisplayName("Test combinación de resta y suma")
public void test18() {
    assertEquals(8, calculator.parse("9 - 5 + 4"));
}
```

**EJ18. Mensaje del test añadido que NO PASA**

```log
java.lang.UnsupportedOperationException: Not implemented yet
```

**EJ18. Código mínimo para que el test pase**

Ahora si el primer símbolo es "-" no indica que el resto de operaciones vayan a ser restas, por lo que hay que añadir en el for dedicado a las restas que tambíen pueden haber sumas.

```java
    public int parse(String expression) {
        expression = expression.trim();
        if((expression.matches(".*[A-Za-z].*"))){ 
            throw new UnsupportedOperationException("Invalid expression");

        }else{
            String[] characters = expression.split(" ");
            int inicio=0;
            int numero=Integer.parseInt(characters[0]);
            if(expression.length()==1){
                return numero;
            }
            if(characters[1].equals("+")){
                for(int i=inicio;i<characters.length-1;i=i+2){
                    if (characters[i+1].equals("+")){
                            numero+=Integer.parseInt(characters[i+2]);
                    }else if (characters[i+1].equals("-")){
                            numero-= 5;
                    }
                    else throw new UnsupportedOperationException("Not implemented yet");
                }
                return numero;
            }else if(characters[1].equals("-")){
                for(int i=inicio;i<characters.length-1;i=i+2){
                    if (characters[i+1].equals("-")){
                            numero-=Integer.parseInt(characters[i+2]);
                    }else if (characters[i+1].equals("+")){
                            numero+= 4;
                    }
                    else throw new UnsupportedOperationException("Not implemented yet");
                }
                return numero;
            }else throw new UnsupportedOperationException("Not implemented yet");
        }
    }
```

**EJ18. Captura de que TODOS los test PASAN**

![Pasa](capturas/image18.png "Pasa")



### Ejemplo 19

**INPUT y OUTPUT**: "9 + 1 - 6 - 2" → 2

**EJ19. Código de test**
```java
@Test
@DisplayName("Test combinación compleja de operaciones")
public void test18() {
    assertEquals(2, calculator.parse("9 + 1 - 6 - 2"));
}
```

**EJ19. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <2> but was: <0>
        at org.junit.jupiter.api.AssertionFailureBuilder.build(...)
        ...
```

**EJ19. Código mínimo para que el test pase**

Ahora las operaciones se pueden intercalar por lo que hemos diseñado este código para que evalue expresiones matemáticas con suma y resta, ajustando el cálculo según los operadores entre los números y enviando una excepción si se encuentra una letra. 

```java
    public int parse(String expression) {

            expression = expression.trim();
            String[] caracteres = expression.split(" ");

            if (expression.matches((".*[a-zA-Z].*"))) {
                throw new UnsupportedOperationException("Invalid expression");

            } else {
                int numero = Integer.parseInt(caracteres[0]);;

                for (int i = 0; i < caracteres.length - 1; i = i + 2) {
                    if (caracteres[i + 1].equals("-")) {
                        numero -= Integer.parseInt(caracteres[i + 2]);
                    } else if (caracteres[i + 1].equals("+")) {
                        numero += Integer.parseInt(caracteres[i + 2]);
                    }
                }
                return numero;
            }
    }
```

**EJ19. Captura de que TODOS los test PASAN**

![Pasa](capturas/image19.png "Pasa")

 

### Ejemplo 20


**INPUT y OUTPUT**: "- 5 + 9" → 4

**EJ20. Código de test**
```java
    @Test
    @DisplayName("Test expresión compleja con múltiples operaciones")
    public void test20() {
        assertEquals(4, calculator.parse("-5 + 9"));
    }
```

**EJ20. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: expected: <2> but was: <4>
        at org.junit.jupiter.api.AssertionFailureBuilder.build(...)
        ...
```


**EJ20. Código mínimo para que el test pase**

Ahora el primer caracter del Array puede ser un símbolo "-" por lo que hay que tener en cuenta que no siempre será el primer símbolo un número.

```java
public int parse(String expression) {

            expression = expression.trim();
            String[] caracteres = expression.split(" ");

            if (expression.matches((".*[a-zA-Z].*"))) {
                throw new UnsupportedOperationException("Invalid expression");

            } else {
                int numero;
                int inicio; 
                if (caracteres[0].equals("-")){
                    inicio = 1;
                numero = -Integer.parseInt(caracteres[1]);
                }else {
                    inicio = 0;
                    numero = Integer.parseInt(caracteres[0]);
                }
                for (int i = inicio; i < caracteres.length - 1; i = i + 2) {
                    if (caracteres[i + 1].equals("-")) {
                        numero -= Integer.parseInt(caracteres[i + 2]);
                    } else if (caracteres[i + 1].equals("+")) {
                        numero += Integer.parseInt(caracteres[i + 2]);
                    }
                }
                return numero;
            }
    }
```
**EJ20. Captura de que TODOS los test PASAN**

![Pasa](capturas/image20.png "Pasa")

**EJ20. Refactorización**

Se mejora la validación de entradas, asegurándose de que la expresión no esté vacía ni sea null. Además hemos intuido de la posibilidad de que también se pase como primer caracter un "+".

```java
   public int parse(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException("La expresión no puede estar vacía o ser null");
        }else{
            expression = expression.trim();
            String[] caracteres = expression.split(" ");
            if(expression.matches((".*[a-zA-Z].*"))){ 
                throw new UnsupportedOperationException("Invalid expression");
                
            }else{
                int inicio=0;
                int numero=0;
                if((caracteres[0].equals("+"))||caracteres[0].equals("-")){
                    inicio=1;
                    if(caracteres[0].equals("-")){
                        numero-=Integer.parseInt(caracteres[1]);
                    }else{
                        numero=Integer.parseInt(caracteres[1]);
                    }
                }else{
                    numero=Integer.parseInt(caracteres[0]);
                }  
                for(int i=inicio;i<caracteres.length-1;i=i+2){
                    if(caracteres[i+1].equals("-")){
                        numero-=Integer.parseInt(caracteres[i+2]);
                    }
                    else if (caracteres[i+1].equals("+")){
                        numero+=Integer.parseInt(caracteres[i+2]);
                    }
                }
                return numero;
            }   
        }
    }
```

**EJ20. Captura de que TODOS los tests PASAN tras la refactorización**

![Pasa](capturas/image20.png "Pasa")


