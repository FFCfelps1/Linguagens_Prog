import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/seu_banco";
        String user = "seu_usuario";
        String password = "sua_senha";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            // Criar agência
            Agencia agencia = new Agencia("Agência Central", 1234);
            agencia.inserir(conn);

            // Criar conta
            ContaCorrente conta = new ContaCorrente(5678, agencia);
            conta.depositar(1000);
            conta.inserir(conn);

            // Criar cliente
            Cliente cliente = new Cliente("João da Silva", "12345678900", conta);
            cliente.inserir(conn);

            // Consultar saldo e imprimir
            conta.imprimirSaldo();

            // Teste de saque
            conta.sacar(300);
            conta.atualizar(conn);

            // Saldo final
            conta.imprimirSaldo();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
