import java.util.Scanner;

public class ex_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria o objeto Scanner para ler a entrada do usuário

        // Declaração de variáveis
        double peso;
        double altura;

        // Entrada de dados do usuário (com validação)
        System.out.println("Digite o peso: ");
        peso = scanner.nextDouble();

        System.out.println("Digite a altura: ");
        altura = scanner.nextDouble();

        // Mostra os dados digitados
        System.out.println("Seus dados digitados foram: " + peso + " e " + altura);

        // Fecha o scanner (opcional, mas recomendado)
        scanner.close();
    }
}