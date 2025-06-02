import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = Conexao.conectar()) {

            // Criar professores
            Professor prof1 = new Professor("Maria", 40, 101);
            Professor prof2 = new Professor("Carlos", 50, 102);

            // Inserir professores no banco
            prof1.inserir(conn);
            prof2.inserir(conn);

            // Criar lista de professores
            ArrayList<Professor> listaProfessores = new ArrayList<>();
            listaProfessores.add(prof1);
            listaProfessores.add(prof2);

            // Criar disciplina
            Disciplina disciplina = new Disciplina("Estruturas de Dados", "ED001", listaProfessores);

            // Inserir disciplina
            disciplina.inserir(conn);
            System.out.println("Disciplina inserida:");

            // Carregar disciplina
            Disciplina d2 = new Disciplina("ED001");
            d2.carregar(conn);
            System.out.println(d2);

            // Alterar disciplina
            d2.setNome("Estrutura de Dados II");
            d2.getProfessores().remove(0); // Remove um professor
            d2.alterar(conn);
            System.out.println("Disciplina alterada:");

            // Carregar novamente após alteração
            Disciplina d3 = new Disciplina("ED001");
            d3.carregar(conn);
            System.out.println(d3);

            // Excluir disciplina
            d3.excluir(conn);
            System.out.println("Disciplina excluída.");

            // Opcional: excluir professores
            prof1.excluir(conn);
            prof2.excluir(conn);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
