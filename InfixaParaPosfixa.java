
import java.util.*;

public class InfixaParaPosfixa {

    private static final Map<Character, Integer> prioridade = Map.of(
        '+', 1,
        '-', 1,
        '*', 2,
        '/', 2
    );

    public static List<String> converter(String expressao) {
        List<String> posfixa = new ArrayList<>();
        Stack<Character> operadores = new Stack<>();
        StringBuilder numero = new StringBuilder();

        String exp = expressao.replaceAll("\\s+", "");

        for (int i = 0; i < exp.length(); i++) {
            char atual = exp.charAt(i);

            if (Character.isDigit(atual) || atual == '.') {
                numero.append(atual);
            } else {
                if (numero.length() > 0) {
                    posfixa.add(numero.toString());
                    numero.setLength(0);
                }

                if (atual == '(') {
                    operadores.push(atual);
                } else if (atual == ')') {
                    while (!operadores.isEmpty() && operadores.peek() != '(') {
                        posfixa.add(String.valueOf(operadores.pop()));
                    }
                    if (!operadores.isEmpty()) {
                        operadores.pop();
                    }
                } else if (prioridade.containsKey(atual)) {
                    while (!operadores.isEmpty() &&
                           operadores.peek() != '(' &&
                           prioridade.get(operadores.peek()) >= prioridade.get(atual)) {
                        posfixa.add(String.valueOf(operadores.pop()));
                    }
                    operadores.push(atual);
                }
            }
        }


        if (numero.length() > 0) {
            posfixa.add(numero.toString());
        }

        while (!operadores.isEmpty()) {
            posfixa.add(String.valueOf(operadores.pop()));
        }

        return posfixa;
    }
}
