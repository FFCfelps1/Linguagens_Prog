import java.util.Scanner;  // Importa a classe Scanner

public class ex_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria o objeto Scanner para ler a entrada do usuário
        
        // Definição de variáveis
        int valor;
        
        // Entrada de dados
        System.out.print("Informe o valor a ser elevado logaritimo: ");
        valor = scanner.nextInt();
        
        // Calcula o logaritmo na base 10 do valor
        double resultado = Math.log10(valor);
        
        // Imprime resultado
        System.out.println("O resultado do valor obtido: " + String.format("%.2f", resultado));
        
        // Fecha o scanner
        scanner.close();
    }
}