import java.util.Scanner;  // Importa a classe Scanner

public class ex_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria o objeto Scanner para ler a entrada do usuário
        
        // Definição de variáveis
        int valor;
        
        // Entrada de dados
        System.out.print("Informe o valor: ");
        valor = scanner.nextInt();

        int dezena = (valor%100) / 10;

        // Imprime resultado
        System.out.println("O resultado da dezena obtido: " + dezena);


        // Fecha o scanner
        scanner.close();
    }
}