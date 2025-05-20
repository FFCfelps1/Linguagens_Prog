public class Comissionado extends Empregado {
    private double vendas;
    private double taxa;

    public Comissionado(String nome, double vendas, double taxa) {
        super(nome);
        this.vendas = vendas;
        this.taxa = taxa;
    }

    public double calcularSalario() {
        return vendas * taxa;
    }
}