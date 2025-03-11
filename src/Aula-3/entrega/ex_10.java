import java.util.Scanner;  // Importa a classe Scanner

public class ex_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria o objeto Scanner para ler a entrada do usuário
        
        // Definição de variáveis
        int valor;
        int base;
        
        // Entrada de dados
        System.out.print("Informe o valor a ser elevado logaritimo: ");
        valor = scanner.nextInt();
        System.out.print("Informe o valor a ser base logaritimo: ");
        base = scanner.nextInt();
        
        // Calcula o logaritmo na base 10 do valor
        double resultado = log(base, valor);
        
        // Imprime resultado
        System.out.println("O resultado do valor obtido: " + String.format("%.2f", resultado));
        
        // Fecha o scanner
        scanner.close();
    }

    public static double log(double base, double valor) {
        return Math.log(valor) / Math.log(base);
    }
}