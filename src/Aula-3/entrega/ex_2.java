import java.util.Scanner;  // Importa a classe Scanner

public class ex_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria o objeto Scanner para ler a entrada do usuário
        
        // Definição de variáveis
        float base;
        float altura;

        // Calcula a área do retângulo
        System.out.print("Digite a base do retângulo: ");
        base = scanner.nextInt();
        System.out.print("Digite a altura do retângulo: ");
        altura = scanner.nextInt();

        System.out.println("A área total do retângulo: " + base * altura);
        
        // Fecha o scanner
        scanner.close();
    }
}