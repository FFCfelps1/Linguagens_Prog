//calcula área do triangulo
import java.util.Scanner;  // Importa a classe Scanner

public class ex_18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria o objeto Scanner para ler a entrada do usuário
        
        // Definição de variáveis
        float base;
        float altura;

        // Calcula a área do retângulo
        System.out.print("Digite a base: ");
        base = scanner.nextInt();
        System.out.print("Digite a altura: ");
        altura = scanner.nextInt();

        // Imprime resultado
        System.out.println("Área: " + String.format("%.2f", (base * altura) / 2));
        
        // Fecha o scanner
        scanner.close();
    }
}