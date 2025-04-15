import javax.swing.JOptionPane;

public class TesteCarro {
    public static void main(String[] args) {
        // Ler informações do carro usando JOptionPane
        String marca = JOptionPane.showInputDialog("Digite a marca do carro:");
        String modelo = JOptionPane.showInputDialog("Digite o modelo do carro:");
        String anoDeFabricacaoStr = JOptionPane.showInputDialog("Digite o ano de fabricação do carro:");

        // Converter o ano de fabricação para inteiro
        int anoDeFabricacao = Integer.parseInt(anoDeFabricacaoStr);

        // Criar o objeto Carro
        Carro carro = new Carro(marca, modelo, anoDeFabricacao);

        // Exibir as informações do carro
        JOptionPane.showMessageDialog(null, "Informações do Carro:\n" +
                "Marca: " + carro.getMarca() + "\n" +
                "Modelo: " + carro.getModelo() + "\n" +
                "Ano de Fabricação: " + carro.getAnoDeFabricacao());
    }
}