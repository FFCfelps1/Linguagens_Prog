public class Tarefeiro extends Empregado {
    private int tarefas;
    private double valorPorTarefa;

    public Tarefeiro() {
        super();
        this.tarefas = 0;
        this.valorPorTarefa = 0.0;
    }

    public Tarefeiro(String nome, String sobrenome, String cpf, int tarefas, double valorPorTarefa) {
        super(nome, sobrenome, cpf);
        this.tarefas = tarefas;
        this.valorPorTarefa = valorPorTarefa;
    }

    public int getTarefas() {
        return tarefas;
    }

    public void setTarefas(int tarefas) {
        this.tarefas = tarefas;
    }

    public double getValorPorTarefa() {
        return valorPorTarefa;
    }

    public void setValorPorTarefa(double valorPorTarefa) {
        this.valorPorTarefa = valorPorTarefa;
    }

    @Override
    public String dados() {
        return super.dados() + ", Tarefas: " + tarefas + ", Valor/Tarefa: R$" + valorPorTarefa;
    }
}
