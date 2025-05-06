import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Teste {
    public static void main(String[] args) {
        Deposito deposito = new Deposito();
        int opcao;

        do {
            String menu = "1. Adicionar caixa\n" +
                          "2. Remover caixa\n" +
                          "3. Procurar caixa\n" +
                          "4. Mudar local da caixa\n" +
                          "5. Listar caixas mais pesadas que 10.0\n" +
                          "6. Sair";
            String input = JOptionPane.showInputDialog(menu);
            if (input == null) break; // Cancelar fecha o programa
            opcao = Integer.parseInt(input);

            switch (opcao) {
                case 1:
                    String corredor = JOptionPane.showInputDialog("Informe o corredor:");
                    int posicao = Integer.parseInt(JOptionPane.showInputDialog("Informe a posição:"));
                    double peso = Double.parseDouble(JOptionPane.showInputDialog("Informe o peso:"));
                    String dono = JOptionPane.showInputDialog("Informe o nome do dono:");
                    deposito.adicionarCaixa(new Caixa(corredor, posicao, peso, dono));
                    JOptionPane.showMessageDialog(null, "Caixa adicionada!");
                    break;

                case 2:
                    String donoRemover = JOptionPane.showInputDialog("Informe o nome do dono da caixa a remover:");
                    boolean removido = deposito.removerCaixaPorDono(donoRemover);
                    if (removido) {
                        JOptionPane.showMessageDialog(null, "Caixa removida!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Caixa não encontrada.");
                    }
                    break;

                case 3:
                    String donoBuscar = JOptionPane.showInputDialog("Informe o nome do dono da caixa:");
                    int index = deposito.encontrarCaixaPorDono(donoBuscar);
                    if (index != -1) {
                        JOptionPane.showMessageDialog(null, "Caixa encontrada na posição " + index);
                    } else {
                        JOptionPane.showMessageDialog(null, "Caixa não encontrada.");
                    }
                    break;

                case 4:
                    String donoAlterar = JOptionPane.showInputDialog("Informe o nome do dono da caixa:");
                    String novoCorredor = JOptionPane.showInputDialog("Informe o novo corredor:");
                    int novaPosicao = Integer.parseInt(JOptionPane.showInputDialog("Informe a nova posição:"));
                    boolean alterado = deposito.mudarLocalCaixa(donoAlterar, novoCorredor, novaPosicao);
                    if (alterado) {
                        JOptionPane.showMessageDialog(null, "Local da caixa alterado!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Caixa não encontrada.");
                    }
                    break;

                case 5:
                    ArrayList<Caixa> pesadas = deposito.caixasMaisPesadasQue(10.0);
                    if (pesadas.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nenhuma caixa com peso acima de 10.0.");
                    } else {
                        StringBuilder sb = new StringBuilder();
                        for (Caixa c : pesadas) {
                            sb.append(c.toString()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, sb.toString());
                    }
                    break;

                case 6:
                    JOptionPane.showMessageDialog(null, "Saindo do sistema...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
            }

        } while (opcao != 6);
    }
}
