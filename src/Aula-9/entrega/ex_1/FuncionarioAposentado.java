// Classe FuncionarioAposentado
public class FuncionarioAposentado extends Funcionario {
    private double salarioAposentadoria;

    public FuncionarioAposentado(String nome, int idade, double salario, String cargo, double salarioAposentadoria) {
        super(nome, idade, salario, cargo);
        this.salarioAposentadoria = salarioAposentadoria;
    }

    public double getSalarioAposentadoria() {
        return salarioAposentadoria;
    }
    public void setSalarioAposentadoria(double salarioAposentadoria) {
        this.salarioAposentadoria = salarioAposentadoria;
    }

    @Override
    public int categoria() {
        return 50; // categoria fixa diferente para aposentado
    }
}
