import java.util.ArrayList;

public class ProgramaAcesso {
    public static void main(String[] args) {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Funcionario("João", 25, 3000, "Analista"));
        pessoas.add(new FuncionarioAposentado("Maria", 65, 5000, "Gerente", 2500));
        pessoas.add(new Funcionario("Pedro", 19, 2000, "Estagiário"));

        for (Pessoa p : pessoas) {
            System.out.println("Nome: " + p.getNome());
            if (p instanceof FuncionarioAposentado) {
                System.out.println("Categoria: " + ((FuncionarioAposentado) p).categoria());
            } else if (p instanceof Funcionario) {
                System.out.println("Categoria: " + ((Funcionario) p).categoria());
            }
        }
    }
}
