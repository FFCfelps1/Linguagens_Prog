import javax.swing.JOptionPane;

public class TesteFuncionario {
    public static void main(String[] args) {
        // Ler informações do funcionário usando JOptionPane
        String nome = JOptionPane.showInputDialog("Digite o nome do funcionário:");
        String cargo = JOptionPane.showInputDialog("Digite o cargo do funcionário:");
        String salarioStr = JOptionPane.showInputDialog("Digite o salário mensal do funcionário:");

        // Converter o salário para double
        double salario = Double.parseDouble(salarioStr);

        // Criar o objeto Funcionario
        Funcionario funcionario = new Funcionario(nome, cargo, salario);

        // Calcular o salário anual
        double salarioAnual = funcionario.calcularSalarioAnual();

        // Exibir as informações do funcionário e o salário anual
        JOptionPane.showMessageDialog(null, "Informações do Funcionário:\n" +
                "Nome: " + funcionario.getNome() + "\n" +
                "Cargo: " + funcionario.getCargo() + "\n" +
                "Salário Mensal: R$ " + funcionario.getSalario() + "\n" +
                "Salário Anual: R$ " + salarioAnual);
    }
}