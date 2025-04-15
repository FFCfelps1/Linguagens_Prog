import javax.swing.JOptionPane;

public class TesteCelular {
    public static void main(String[] args) {
        // Ler informações do celular usando JOptionPane
        String marca = JOptionPane.showInputDialog("Digite a marca do celular:");
        String modelo = JOptionPane.showInputDialog("Digite o modelo do celular:");
        String capacidadeStr = JOptionPane.showInputDialog("Digite a capacidade de armazenamento (em GB):");

        // Converter a capacidade de armazenamento para inteiro
        int capacidadeArmazenamento = Integer.parseInt(capacidadeStr);

        // Criar o objeto Celular
        Celular celular = new Celular(marca, modelo, capacidadeArmazenamento);

        // Exibir as informações do celular formatadas como ficha técnica
        JOptionPane.showMessageDialog(null, "Ficha Técnica do Celular:\n" +
                "Marca: " + celular.getMarca() + "\n" +
                "Modelo: " + celular.getModelo() + "\n" +
                "Capacidade de Armazenamento: " + celular.getCapacidadeArmazenamento() + " GB");
    }
}