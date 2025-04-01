import javax.swing.JOptionPane;

public class TesteTurma {

    public static void main(String[] args) {
        // Coletando os dados da turma a ser cadastrada
        String nome = JOptionPane.showInputDialog("Nome da Turma");
        String curso = JOptionPane.showInputDialog("Curso");
        int quantidadeDeAlunos = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de Alunos"));
        int serie = Integer.parseInt(JOptionPane.showInputDialog("Série"));

        // Criando um objeto Turma
        Turma turma = new Turma(nome, curso, quantidadeDeAlunos, serie);

        // Montando a String de saída chamando os métodos de acesso da turma
        String msg = "Nome da Turma: " + turma.getNome() + "\nCurso: " + turma.getCurso()
                + "\nQuantidade de Alunos: " + turma.getQuantidadeDeAlunos()
                + "\nSérie: " + turma.getSerie();

        // Mostrando os dados da turma
        JOptionPane.showMessageDialog(null, msg);

        // Pedindo uma nova quantidade de alunos
        int novaQuantidadeDeAlunos = Integer.parseInt(JOptionPane.showInputDialog("Digite a nova quantidade de alunos"));
        turma.setQuantidadeDeAlunos(novaQuantidadeDeAlunos);

        // Montando a String de saída atualizada
        String msgAtualizada = "Nome da Turma: " + turma.getNome() + "\nCurso: " + turma.getCurso()
                + "\nQuantidade de Alunos: " + turma.getQuantidadeDeAlunos()
                + "\nSérie: " + turma.getSerie();

        // Mostrando os dados atualizados da turma
        JOptionPane.showMessageDialog(null, msgAtualizada);
    }
}