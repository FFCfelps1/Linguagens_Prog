import javax.swing.JOptionPane;

public class TesteFilme {
    public static void main(String[] args) {
        // Ler informações do filme usando JOptionPane
        String nome = JOptionPane.showInputDialog("Digite o nome do filme:");
        String diretor = JOptionPane.showInputDialog("Digite o nome do diretor:");
        String anoDeLancamentoStr = JOptionPane.showInputDialog("Digite o ano de lançamento do filme:");

        // Converter o ano de lançamento para inteiro
        int anoDeLancamento = Integer.parseInt(anoDeLancamentoStr);

        // Criar o objeto Filme
        Filme filme = new Filme(nome, diretor, anoDeLancamento);

        // Exibir as informações do filme
        JOptionPane.showMessageDialog(null, "Informações do Filme:\n" +
                "Nome: " + filme.getNome() + "\n" +
                "Diretor: " + filme.getDiretor() + "\n" +
                "Ano de Lançamento: " + filme.getAnoDeLancamento());
    }
}