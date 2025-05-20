public abstract class Empregado {
    protected String nome;

    public Empregado(String nome) {
        this.nome = nome;
    }

    public abstract double calcularSalario();

    public String toString() {
        return "Nome: " + nome + "\nSalário: " + calcularSalario();
    }
}