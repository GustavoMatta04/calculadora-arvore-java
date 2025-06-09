
public class NoOperador extends No {
    private char operador;

    public NoOperador(char operador, No esquerdo, No direito) {
        this.operador = operador;
        this.esquerdo = esquerdo;
        this.direito = direito;
    }

    @Override
    public float visitar() {
        float esq = esquerdo.visitar();
        float dir = direito.visitar();

        switch (operador) {
            case '+': return esq + dir;
            case '-': return esq - dir;
            case '*': return esq * dir;
            case '/': return esq / dir;
            default: return Float.NaN;
        }
    }

    @Override
    public String toString() {
        return Character.toString(operador);
    }
}
