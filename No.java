
public class No {
    protected No esquerdo;
    protected No direito;

    public float visitar() {
        return Float.NaN;
    }

    public No getEsquerdo() {
        return esquerdo;
    }

    public No getDireito() {
        return direito;
    }

    public void setEsquerdo(No esquerdo) {
        this.esquerdo = esquerdo;
    }

    public void setDireito(No direito) {
        this.direito = direito;
    }

    public String toString() {
        return "";
    }
}
