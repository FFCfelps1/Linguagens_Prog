import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Professor {
    private String nome;
    private int idade;
    private int matricula;

    // Construtor padrão
    public Professor() {
    }

    // Construtor com matrícula
    public Professor(int matricula) {
        this.matricula = matricula;
    }

    // Construtor completo
    public Professor(String nome, int idade, int matricula) {
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    // Método toString
    @Override
    public String toString() {
        return "Professor [Nome=" + nome + ", Idade=" + idade + ", Matrícula=" + matricula + "]";
    }

    // Métodos de persistência

    public void inserir(Connection conn) {
        String sql = "INSERT INTO professor (nome, idade, matricula) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setInt(2, idade);
            stmt.setInt(3, matricula);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterar(Connection conn) {
        String sql = "UPDATE professor SET nome = ?, idade = ? WHERE matricula = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setInt(2, idade);
            stmt.setInt(3, matricula);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(Connection conn) {
        String sql = "DELETE FROM professor WHERE matricula = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, matricula);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void carregar(Connection conn) {
        String sql = "SELECT nome, idade FROM professor WHERE matricula = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, matricula);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    this.nome = rs.getString("nome");
                    this.idade = rs.getInt("idade");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
