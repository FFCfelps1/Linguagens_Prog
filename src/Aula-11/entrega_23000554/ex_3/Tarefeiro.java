public class Tarefeiro extends Empregado {
    private int tarefas;
    private double valorTarefa;

    public Tarefeiro(String nome, int tarefas, double valorTarefa) {
        super(nome);
        this.tarefas = tarefas;
        this.valorTarefa = valorTarefa;
    }

    public double calcularSalario() {
        return tarefas * valorTarefa;
    }
}