import java.sql.*;
import java.util.ArrayList;

public class Disciplina {
    private String nome;
    private ArrayList<Professor> professores;
    private String codigo;

    // Construtor padrão
    public Disciplina() {
        this.professores = new ArrayList<>();
    }

    // Construtor com código
    public Disciplina(String codigo) {
        this.codigo = codigo;
        this.professores = new ArrayList<>();
    }

    // Construtor completo
    public Disciplina(String nome, String codigo, ArrayList<Professor> professores) {
        this.nome = nome;
        this.codigo = codigo;
        this.professores = professores != null ? professores : new ArrayList<>();
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(ArrayList<Professor> professores) {
        this.professores = professores;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    // toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Disciplina [Nome=").append(nome)
          .append(", Código=").append(codigo)
          .append(", Professores=[");
        for (Professor p : professores) {
            sb.append(p.toString()).append(", ");
        }
        if (!professores.isEmpty()) {
            sb.setLength(sb.length() - 2); // remover última vírgula
        }
        sb.append("]]");
        return sb.toString();
    }

    // Persistência

    public void inserir(Connection conn) {
        String sqlDisciplina = "INSERT INTO disciplina (codigo, nome) VALUES (?, ?)";
        String sqlRelacionamento = "INSERT INTO disciplina_professor (codigo_disciplina, matricula_professor) VALUES (?, ?)";

        try (
            PreparedStatement stmtDisciplina = conn.prepareStatement(sqlDisciplina);
            PreparedStatement stmtRelacionamento = conn.prepareStatement(sqlRelacionamento)
        ) {
            stmtDisciplina.setString(1, codigo);
            stmtDisciplina.setString(2, nome);
            stmtDisciplina.executeUpdate();

            for (Professor p : professores) {
                stmtRelacionamento.setString(1, codigo);
                stmtRelacionamento.setInt(2, p.getMatricula());
                stmtRelacionamento.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterar(Connection conn) {
        String sqlDisciplina = "UPDATE disciplina SET nome = ? WHERE codigo = ?";
        String sqlDeleteRelacionamentos = "DELETE FROM disciplina_professor WHERE codigo_disciplina = ?";
        String sqlRelacionamento = "INSERT INTO disciplina_professor (codigo_disciplina, matricula_professor) VALUES (?, ?)";

        try (
            PreparedStatement stmtDisciplina = conn.prepareStatement(sqlDisciplina);
            PreparedStatement stmtDeleteRelacionamentos = conn.prepareStatement(sqlDeleteRelacionamentos);
            PreparedStatement stmtRelacionamento = conn.prepareStatement(sqlRelacionamento)
        ) {
            stmtDisciplina.setString(1, nome);
            stmtDisciplina.setString(2, codigo);
            stmtDisciplina.executeUpdate();

            stmtDeleteRelacionamentos.setString(1, codigo);
            stmtDeleteRelacionamentos.executeUpdate();

            for (Professor p : professores) {
                stmtRelacionamento.setString(1, codigo);
                stmtRelacionamento.setInt(2, p.getMatricula());
                stmtRelacionamento.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(Connection conn) {
        String sqlRelacionamentos = "DELETE FROM disciplina_professor WHERE codigo_disciplina = ?";
        String sqlDisciplina = "DELETE FROM disciplina WHERE codigo = ?";

        try (
            PreparedStatement stmtRelacionamentos = conn.prepareStatement(sqlRelacionamentos);
            PreparedStatement stmtDisciplina = conn.prepareStatement(sqlDisciplina)
        ) {
            stmtRelacionamentos.setString(1, codigo);
            stmtRelacionamentos.executeUpdate();

            stmtDisciplina.setString(1, codigo);
            stmtDisciplina.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void carregar(Connection conn) {
        String sqlDisciplina = "SELECT nome FROM disciplina WHERE codigo = ?";
        String sqlProfessores = "SELECT p.nome, p.idade, p.matricula FROM professor p " +
                                "JOIN disciplina_professor dp ON p.matricula = dp.matricula_professor " +
                                "WHERE dp.codigo_disciplina = ?";

        try (
            PreparedStatement stmtDisciplina = conn.prepareStatement(sqlDisciplina);
            PreparedStatement stmtProfessores = conn.prepareStatement(sqlProfessores)
        ) {
            stmtDisciplina.setString(1, codigo);
            try (ResultSet rs = stmtDisciplina.executeQuery()) {
                if (rs.next()) {
                    this.nome = rs.getString("nome");
                }
            }

            stmtProfessores.setString(1, codigo);
            try (ResultSet rs = stmtProfessores.executeQuery()) {
                professores.clear();
                while (rs.next()) {
                    Professor p = new Professor(
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getInt("matricula")
                    );
                    professores.add(p);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
