import java.util.Scanner;  // Importa a classe Scanner

public class ex_16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria o objeto Scanner para ler a entrada do usuário
        
        // Definição de variáveis
        float dividendo;
        float divisor;

        // Calcula a área do retângulo
        System.out.print("Digite o dividendo: ");
        dividendo = scanner.nextInt();
        System.out.print("Digite o divisor: ");
        divisor = scanner.nextInt();

        System.out.println("Divisor: " + String.format("%.2f", divisor));
        System.out.println("Dividendo: " + String.format("%.2f", dividendo));
        System.out.println("Dividendo: " + String.format("%.2f", dividendo % divisor));
        //quociente
        System.out.println("Quociente: " + String.format("%.2f", dividendo / divisor));
        
        // Fecha o scanner
        scanner.close();
    }
}