import javax.swing.JOptionPane;

public class TesteProduto {
    public static void main(String[] args) {
        // Ler valores do produto usando JOptionPane
        String nome = JOptionPane.showInputDialog("Digite o nome do produto:");
        String precoStr = JOptionPane.showInputDialog("Digite o preço do produto:");
        String quantidadeStr = JOptionPane.showInputDialog("Digite a quantidade do produto:");

        // Converter os valores para os tipos corretos
        double preco = Double.parseDouble(precoStr);
        int quantidade = Integer.parseInt(quantidadeStr);

        // Instanciar o produto
        Produto produto = new Produto(nome, preco, quantidade);

        // Exibir o produto criado
        JOptionPane.showMessageDialog(null, "Produto criado:\n" + produto);
    }
}