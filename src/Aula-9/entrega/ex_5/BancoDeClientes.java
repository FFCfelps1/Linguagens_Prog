import java.util.ArrayList;

public class BancoDeClientes {
    private ArrayList<Cliente> clientes;

    public BancoDeClientes() {
        clientes = new ArrayList<>();
    }

    public void inserirCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public boolean removerCliente(int id) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == id) {
                clientes.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean alterarCliente(int id, String novoNome, String novoFone) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                c.setNome(novoNome);
                c.setFone(novoFone);
                return true;
            }
        }
        return false;
    }

    public Cliente buscarCliente(int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Cliente> listarTodos() {
        return clientes;
    }
}
