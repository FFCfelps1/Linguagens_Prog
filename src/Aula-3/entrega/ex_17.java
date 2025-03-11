import java.util.Scanner;  // Importa a classe Scanner

public class ex_17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria o objeto Scanner para ler a entrada do usuário
        
        // Definição de variáveis
        float valor;
        
        // Entrada de dados
        System.out.print("Informe o valor a ser elevado ao quadrado e ser feito raiz quadrada: ");
        valor = scanner.nextInt();
        
        // Calcula o quadrado do valor e raiz quadrada
        double resultado_quadrado = Math.pow(valor, 2);
        double resultado_raiz = Math.sqrt(valor);
        
        // Imprime resultado
        System.out.println("O resultado do valor ao quadrado: " + String.format("%.2f", resultado_quadrado));
        System.out.println("O resultado da raiz quadrada do valor: " + String.format("%.2f", resultado_raiz));
        
        // Fecha o scanner
        scanner.close();
    }
}