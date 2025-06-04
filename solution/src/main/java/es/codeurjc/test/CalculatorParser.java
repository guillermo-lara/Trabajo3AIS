package es.codeurjc.test;

public class CalculatorParser {

    public int parse(String expression) {

        if (expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException("La expresión no puede estar vacía o ser null");
        } else {

            expression = expression.trim();
            String[] caracteres = expression.split(" ");

            if (expression.matches((".*[a-zA-Z].*"))) {
                throw new UnsupportedOperationException("Invalid expression");

            } else {
                int inicio = 0;
                int numero = 0;
                if ((caracteres[0].equals("+")) || caracteres[0].equals("-")) {
                    inicio = 1;
                    if (caracteres[0].equals("-")) {
                        numero -= Integer.parseInt(caracteres[1]);
                    } else {
                        numero = Integer.parseInt(caracteres[1]);
                    }
                } else {
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
    }
}
