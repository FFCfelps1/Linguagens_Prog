import java.util.Scanner;  // Importa a classe Scanner

public class ex_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria o objeto Scanner para ler a entrada do usuário

        // Declaração de variáveis
        int numero;

        // Entrada de dados do usuário
        System.out.println("Digite um numero de seu desejo: ");
        numero = scanner.nextInt();

        // Mostra as strings digitadas com espaços entre elas
        System.out.println("Você digitou: " + numero);

        // Fecha o scanner (opcional, mas recomendado)
        scanner.close();
    }
}