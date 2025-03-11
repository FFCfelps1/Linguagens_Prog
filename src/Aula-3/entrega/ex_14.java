import java.util.Scanner;  // Importa a classe Scanner

public class ex_14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria o objeto Scanner para ler a entrada do usuário
        
        // Definição de variáveis
        float a;
        float b;
        float c;
        // Entrada de dados
        System.out.print("Informe o valor de a: ");
        a = scanner.nextFloat();
        System.out.print("Informe o valor de b: ");
        b = scanner.nextFloat();
        System.out.print("Informe o valor de c: ");
        c = scanner.nextFloat();

        //Calcula o resultado
        double resultado = 2 * ((a - c) / 8) - b * 5;

        // Imprime resultado
        System.out.println("O resultado da dezena obtido no cosseno, seno e tangente: " + String.format("%.2f", resultado));

        // Fecha o scanner
        scanner.close();
    }
}