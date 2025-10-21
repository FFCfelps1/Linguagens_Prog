public class Pedido {
    private double total;

    public Pedido() {
        this.total = 0.0;
    }

    public void incluir(double valor) {
        total += valor;
    }

    public void excluir(double valor) {
        total -= valor;
    }

    public void iniciar() {
        total = 0.0;
    }

    public double totalizar() {
        return total;
    }
}
