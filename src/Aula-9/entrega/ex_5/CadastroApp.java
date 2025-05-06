import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CadastroApp {
    public static void main(String[] args) {
        BancoDeClientes banco = new BancoDeClientes();
        int opcao;

        do {
            String menu = "1. Inserir cliente\n" +
                          "2. Remover cliente\n" +
                          "3. Alterar cliente\n" +
                          "4. Listar cliente por ID\n" +
                          "5. Listar todos os clientes\n" +
                          "6. Sair";
            String input = JOptionPane.showInputDialog(menu);
            if (input == null) break;
            opcao = Integer.parseInt(input);

            switch (opcao) {
                case 1:
                    int id = Integer.parseInt(JOptionPane.showInputDialog("ID do cliente:"));
                    String nome = JOptionPane.showInputDialog("Nome do cliente:");
                    String fone = JOptionPane.showInputDialog("Telefone do cliente:");
                    banco.inserirCliente(new Cliente(id, nome, fone));
                    JOptionPane.showMessageDialog(null, "Cliente inserido!");
                    break;

                case 2:
                    int idRemover = Integer.parseInt(JOptionPane.showInputDialog("ID do cliente a remover:"));
                    boolean removido = banco.removerCliente(idRemover);
                    JOptionPane.showMessageDialog(null, removido ? "Cliente removido!" : "Cliente não encontrado.");
                    break;

                case 3:
                    int idAlterar = Integer.parseInt(JOptionPane.showInputDialog("ID do cliente a alterar:"));
                    String novoNome = JOptionPane.showInputDialog("Novo nome:");
                    String novoFone = JOptionPane.showInputDialog("Novo telefone:");
                    boolean alterado = banco.alterarCliente(idAlterar, novoNome, novoFone);
                    JOptionPane.showMessageDialog(null, alterado ? "Cliente alterado!" : "Cliente não encontrado.");
                    break;

                case 4:
                    int idBuscar = Integer.parseInt(JOptionPane.showInputDialog("ID do cliente a listar:"));
                    Cliente c = banco.buscarCliente(idBuscar);
                    JOptionPane.showMessageDialog(null, (c != null) ? c.toString() : "Cliente não encontrado.");
                    break;

                case 5:
                    ArrayList<Cliente> todos = banco.listarTodos();
                    if (todos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado.");
                    } else {
                        StringBuilder sb = new StringBuilder();
                        for (Cliente cliente : todos) {
                            sb.append(cliente.toString()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, sb.toString());
                    }
                    break;

                case 6:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.");
            }

        } while (opcao != 6);
    }
}
