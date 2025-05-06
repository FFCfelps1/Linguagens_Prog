// Classe Funcionario
public class Funcionario extends Pessoa {
    private double salario;
    private String cargo;

    public Funcionario(String nome, int idade, double salario, String cargo) {
        super(nome, idade);
        this.salario = salario;
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    // Método categoria() conforme o código da imagem
    public int categoria() {
        if (getIdade() > 20) {
            return 30;
        } else {
            return 10;
        }
    }

    public int categoria(int bonus) {
        if (getIdade() > 20) {
            return 30 + bonus;
        } else {
            return 10 + bonus;
        }
    }
}
