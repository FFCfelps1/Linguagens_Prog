package exercicio;
import javax.swing.JOptionPane;

public class TesteAluno {

    // cadastrar um novo aluno no método main
    public static void main(String[] args) {

        // coletando os dados do aluno a ser cadastrado
        String nome = JOptionPane.showInputDialog("Nome");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade"));
        double peso = Double.parseDouble(JOptionPane.showInputDialog("Peso"));
        // pega o primeiro caractere da String e retorna como char
        char sexo = JOptionPane.showInputDialog("Sexo M/F").charAt(0);

        // cria um objeto aluno
        Aluno aluno = new Aluno(nome, idade, peso, sexo);

        // monta a String de saída chamando os métodos de acesso do aluno
        String msg = "Nome: " + aluno.getNome() + "\nIdade: "
                + aluno.getIdade() + " anos" + "\nPeso: " + aluno.getPeso()
                + " kg";
        if (aluno.getFormando()) {
            msg += "\nFormando: sim";
        } else {
            msg += "\nFormando: não";
        }
        if (aluno.getSexo() == 'M') {
            msg += "\nSexo: masculino";
        } else {
            msg += "\nSexo: feminino";
        }

        // mostra o aluno
        JOptionPane.showMessageDialog(null, msg);
    }
}
