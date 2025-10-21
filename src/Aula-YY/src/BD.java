import java.sql.*;
import java.util.ArrayList;

public class BD {
    private static final String URL = "jdbc:mysql://localhost/investimentos";
    private static final String USUARIO = "root";
    private static final String SENHA = "180705";

    public static ArrayList<AplicacaoInvestimento> lerDados() throws Exception {
        ArrayList<AplicacaoInvestimento> lista = new ArrayList<>();
        Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM aplicacoes");
        while (rs.next()) {
            lista.add(new AplicacaoInvestimento(
                rs.getString("descricao"),
                rs.getDouble("saldo"),
                rs.getDouble("juros")
            ));
        }
        conn.close();
        return lista;
    }

    public static void salvarDados(ArrayList<AplicacaoInvestimento> lista) throws Exception {
        Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);

        for (AplicacaoInvestimento a : lista) {
            // Verifica se já existe a aplicação com esta descrição
            PreparedStatement psSelect = conn.prepareStatement(
                "SELECT id FROM aplicacoes WHERE descricao = ?"
            );
            psSelect.setString(1, a.getDescricao());
            ResultSet rs = psSelect.executeQuery();

            if (rs.next()) {
                // Já existe, então atualiza
                int id = rs.getInt("id");
                PreparedStatement psUpdate = conn.prepareStatement(
                    "UPDATE aplicacoes SET saldo = ?, juros = ? WHERE id = ?"
                );
                psUpdate.setDouble(1, a.getSaldo());
                psUpdate.setDouble(2, a.getJuros());
                psUpdate.setInt(3, id);
                psUpdate.executeUpdate();
            } else {
                // Não existe, insere
                PreparedStatement psInsert = conn.prepareStatement(
                    "INSERT INTO aplicacoes (descricao, saldo, juros) VALUES (?, ?, ?)"
                );
                psInsert.setString(1, a.getDescricao());
                psInsert.setDouble(2, a.getSaldo());
                psInsert.setDouble(3, a.getJuros());
                psInsert.executeUpdate();
            }
        }

        conn.close();
    }
}
