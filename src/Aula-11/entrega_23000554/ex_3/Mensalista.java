public class Mensalista extends Empregado {
    private double salarioMensal;

    public Mensalista(String nome, double salarioMensal) {
        super(nome);
        this.salarioMensal = salarioMensal;
    }

    public double calcularSalario() {
        return salarioMensal;
    }
}