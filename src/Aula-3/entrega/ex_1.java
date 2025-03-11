import java.util.Scanner;  // Importa a classe Scanner

public class ex_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria o objeto Scanner para ler a entrada do usuário
        
        // Definição de variáveis
        int idade;

        // Calcula o tempo de vida em dias
        System.out.print("Digite a sua idade: ");
        idade = scanner.nextInt();
        System.out.println("Você viveu aproximadamente " + idade * 365 + " dias.");
        
        // Fecha o scanner
        scanner.close();
    }
}