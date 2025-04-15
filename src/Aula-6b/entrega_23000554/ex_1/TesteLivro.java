import javax.swing.JOptionPane;

public class TesteLivro {
    public static void main(String[] args) {
        // Ler informações do livro usando JOptionPane
        String titulo = JOptionPane.showInputDialog("Digite o título do livro:");
        String autor = JOptionPane.showInputDialog("Digite o autor do livro:");
        String nPaginasStr = JOptionPane.showInputDialog("Digite o número de páginas do livro:");

        // Converter o número de páginas para inteiro
        int nPaginas = Integer.parseInt(nPaginasStr);

        // Criar o objeto Livro
        Livro livro = new Livro(titulo, autor, nPaginas);

        // Exibir as informações do livro
        JOptionPane.showMessageDialog(null, "Informações do Livro:\n" +
                "Título: " + livro.getTitulo() + "\n" +
                "Autor: " + livro.getAutor() + "\n" +
                "Número de Páginas: " + livro.getNPaginas());
    }
}