import java.util.Scanner;  // Importa a classe Scanner

public class ex_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria o objeto Scanner para ler a entrada do usuário

        // Declaração de variáveis
        String txt1;
        String txt2;
        String txt3;

        // Entrada de dados do usuário
        System.out.println("Digite uma palavra de seu desejo: ");
        txt1 = scanner.nextLine();

        System.out.println("Digite uma palavra de seu desejo: ");
        txt2 = scanner.nextLine();

        System.out.println("Digite uma palavra de seu desejo: ");
        txt3 = scanner.nextLine();

        // Mostra as strings digitadas com espaços entre elas
        System.out.println("Você digitou: " + txt3 + " " + txt2 + " " + txt1);

        // Fecha o scanner (opcional, mas recomendado)
        scanner.close();
    }
}