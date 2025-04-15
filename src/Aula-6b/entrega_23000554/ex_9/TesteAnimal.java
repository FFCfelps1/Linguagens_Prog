import javax.swing.JOptionPane;

public class TesteAnimal {
    public static void main(String[] args) {
        // Ler informações do primeiro animal
        String especie1 = JOptionPane.showInputDialog("Digite a espécie do primeiro animal:");
        String nome1 = JOptionPane.showInputDialog("Digite o nome do primeiro animal:");
        String idade1Str = JOptionPane.showInputDialog("Digite a idade do primeiro animal:");
        int idade1 = Integer.parseInt(idade1Str);

        // Criar o primeiro objeto Animal
        Animal animal1 = new Animal(especie1, nome1, idade1);

        // Ler informações do segundo animal
        String especie2 = JOptionPane.showInputDialog("Digite a espécie do segundo animal:");
        String nome2 = JOptionPane.showInputDialog("Digite o nome do segundo animal:");
        String idade2Str = JOptionPane.showInputDialog("Digite a idade do segundo animal:");
        int idade2 = Integer.parseInt(idade2Str);

        // Criar o segundo objeto Animal
        Animal animal2 = new Animal(especie2, nome2, idade2);

        // Comparar as idades e exibir o resultado
        String comparacao;
        if (animal1.getIdade() > animal2.getIdade()) {
            comparacao = animal1.getNome() + " é mais velho que " + animal2.getNome() + ".";
        } else if (animal1.getIdade() < animal2.getIdade()) {
            comparacao = animal2.getNome() + " é mais velho que " + animal1.getNome() + ".";
        } else {
            comparacao = animal1.getNome() + " e " + animal2.getNome() + " têm a mesma idade.";
        }

        // Exibir as informações dos animais e a comparação
        JOptionPane.showMessageDialog(null, "Informações dos Animais:\n\n" +
                "Animal 1:\n" +
                "Espécie: " + animal1.getEspecie() + "\n" +
                "Nome: " + animal1.getNome() + "\n" +
                "Idade: " + animal1.getIdade() + " anos\n\n" +
                "Animal 2:\n" +
                "Espécie: " + animal2.getEspecie() + "\n" +
                "Nome: " + animal2.getNome() + "\n" +
                "Idade: " + animal2.getIdade() + " anos\n\n" +
                "Comparação: " + comparacao);
    }
}