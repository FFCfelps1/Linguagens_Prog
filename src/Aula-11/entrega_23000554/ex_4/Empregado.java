public abstract class Empregado extends PessoaFisica {
    public Empregado(String nome, String cpf) {
        super(nome, cpf);
    }
    public abstract double calcularSalario();

    public String toString() {
        return super.toString() + "\nSituação: Empregado\nSalário: " + String.format("%.2f", calcularSalario());
    }
}