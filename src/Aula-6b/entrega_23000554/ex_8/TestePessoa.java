import javax.swing.JOptionPane;

public class TestePessoa {
    public static void main(String[] args) {
        // Ler informações da pessoa usando JOptionPane
        String nome = JOptionPane.showInputDialog("Digite o nome da pessoa:");
        String idadeStr = JOptionPane.showInputDialog("Digite a idade da pessoa:");
        String alturaStr = JOptionPane.showInputDialog("Digite a altura da pessoa (em metros):");

        // Converter idade e altura para os tipos corretos
        int idade = Integer.parseInt(idadeStr);
        double altura = Double.parseDouble(alturaStr);

        // Criar o objeto Pessoa
        Pessoa pessoa = new Pessoa(nome, idade, altura);

        // Exibir mensagem de boas-vindas com as informações da pessoa
        JOptionPane.showMessageDialog(null, "Bem-vindo(a), " + pessoa.getNome() + "!\n" +
                "Idade: " + pessoa.getIdade() + " anos\n" +
                "Altura: " + pessoa.getAltura() + " metros");
    }
}