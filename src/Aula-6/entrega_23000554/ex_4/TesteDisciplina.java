import javax.swing.JOptionPane;

public class TesteDisciplina {
    public static void main(String[] args) {
        // Leitura dos dados usando JOptionPane
        String nome = JOptionPane.showInputDialog("Digite o nome da disciplina:");
        String professor = JOptionPane.showInputDialog("Digite o nome do professor:");
        
        // Leitura do semestre (convertendo de String para int)
        int semestre = Integer.parseInt(JOptionPane.showInputDialog("Digite o semestre:"));
        
        // Leitura da oferta da disciplina (convertendo de String para boolean)
        boolean ofertada = JOptionPane.showConfirmDialog(null, 
                "A disciplina está sendo ofertada?", 
                "Oferta da Disciplina", 
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

        // Criação da disciplina
        Disciplina disciplina = new Disciplina(nome, professor, semestre, ofertada);

        // Exibição da disciplina criada
        JOptionPane.showMessageDialog(null, "Disciplina criada:\n" + disciplina);
    }
}