
import java.util.*;

public class ArvoreExpressao {
    private No raiz = null;

    // Constrói a árvore a partir da expressão em notação infixa
    public void construir(String expressao) {
        List<String> posfixa = InfixaParaPosfixa.converter(expressao);
        Stack<No> pilha = new Stack<>();

        for (String token : posfixa) {
            if (token.matches("[0-9.]+")) {
                pilha.push(new NoOperando(Float.parseFloat(token)));
            } else {
                No direita = pilha.pop();
                No esquerda = pilha.pop();
                pilha.push(new NoOperador(token.charAt(0), esquerda, direita));
            }
        }

        raiz = pilha.pop();
    }

    // Percurso em pré-ordem
    public void preOrdem() {
        visitarPre(raiz);
    }

    private void visitarPre(No atual) {
        if (atual == null) return;
        System.out.print(atual + " ");
        visitarPre(atual.getEsquerdo());
        visitarPre(atual.getDireito());
    }

    // Percurso em in-ordem
    public void inOrdem() {
        visitarIn(raiz);
    }

    private void visitarIn(No atual) {
        if (atual == null) return;
        visitarIn(atual.getEsquerdo());
        System.out.print(atual + " ");
        visitarIn(atual.getDireito());
    }

    // Percurso em pós-ordem
    public void posOrdem() {
        visitarPos(raiz);
    }

    private void visitarPos(No atual) {
        if (atual == null) return;
        visitarPos(atual.getEsquerdo());
        visitarPos(atual.getDireito());
        System.out.print(atual + " ");
    }

    // Avalia o valor da expressão usando a árvore
    public float avaliar() {
        if (raiz != null) {
            return raiz.visitar();
        } else {
            System.out.println("A árvore ainda não foi construída.");
            return Float.NaN;
        }
    }

    // Fornece a raiz para percursos externos
    public No getRaiz() {
        return raiz;
    }
}
