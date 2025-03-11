// programa para calcular área de losango

import java.util.Scanner;  // Importa a classe Scanner

public class ex_19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria o objeto Scanner para ler a entrada do usuário
        
        // Definição de variáveis
        float D;
        float d;

        // Calcula a área do retângulo
        System.out.print("Digite a base: ");
        D = scanner.nextInt();
        System.out.print("Digite a altura: ");
        d = scanner.nextInt();

        // Imprime resultado
        System.out.println("Área: " + String.format("%.2f", (D * d) / 2));
        
        // Fecha o scanner
        scanner.close();
    }
}