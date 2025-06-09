
public class NoOperando extends No {
    private float valor;

    public NoOperando(float valor) {
        this.valor = valor;
    }

    @Override
    public float visitar() {
        return valor;
    }

    @Override
    public String toString() {
        return Float.toString(valor);
    }
}
