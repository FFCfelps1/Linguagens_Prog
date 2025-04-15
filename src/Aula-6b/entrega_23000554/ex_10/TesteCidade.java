import javax.swing.JOptionPane;

public class TesteCidade {
    public static void main(String[] args) {
        // Ler informações da cidade usando JOptionPane
        String nome = JOptionPane.showInputDialog("Digite o nome da cidade:");
        String estado = JOptionPane.showInputDialog("Digite o estado da cidade:");
        String populacaoStr = JOptionPane.showInputDialog("Digite a população da cidade:");

        // Converter a população para inteiro
        int populacao = Integer.parseInt(populacaoStr);

        // Criar o objeto Cidade
        Cidade cidade = new Cidade(nome, estado, populacao);

        // Exibir a frase formatada com as informações da cidade
        JOptionPane.showMessageDialog(null, "A cidade de " + cidade.getNome() + 
                ", localizada em " + cidade.getEstado() + 
                ", possui " + String.format("%,d", cidade.getPopulacao()) + " habitantes.");
    }
}