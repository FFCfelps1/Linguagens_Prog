import java.util.Scanner;  // Importa a classe Scanner

public class ex_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria o objeto Scanner para ler a entrada do usuário
        
        // Definição de variáveis
        float valor;
        
        // Entrada de dados
        System.out.print("Informe o valor a ser elevado ao quadrado: ");
        valor = scanner.nextInt();
        
        // Calcula o quadrado do valor
        double resultado = Math.pow(valor, 2);
        
        // Imprime resultado
        System.out.println("O resultado do valor obtido: " + String.format("%.2f", resultado));
        
        // Fecha o scanner
        scanner.close();
    }
}