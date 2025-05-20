public class Mostrador {
    private int valor;
    private int limite;

    public Mostrador(int limite) {
        this.limite = limite;
        this.valor = 0;
    }

    public void incrementar() {
        valor = (valor + 1) % limite;
    }

    public void setValor(int novoValor) {
        if (novoValor >= 0 && novoValor < limite) {
            valor = novoValor;
        }
    }

    public int getValor() {
        return valor;
    }

    public String getValorFormatado() {
        return String.format("%02d", valor);
    }
}