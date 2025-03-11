import java.util.Scanner;  // Importa a classe Scanner

public class ex_15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria o objeto Scanner para ler a entrada do usuário
        
        // Definição de variáveis
        float raio;

        // Calcula a área do retângulo
        System.out.print("Digite o raio do círculo: ");
        raio = scanner.nextInt();

        System.out.println("A área total do retângulo: " + Math.PI * Math.pow(raio, 2));
        
        // Fecha o scanner
        scanner.close();
    }
}