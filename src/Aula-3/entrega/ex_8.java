import java.util.Scanner;  // Importa a classe Scanner

public class ex_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria o objeto Scanner para ler a entrada do usuário
        
        // Definição de variáveis
        float ang;
        
        // Entrada de dados
        System.out.print("Informe o valor: ");
        ang = scanner.nextInt();

        double rad = (ang * Math.PI)/180;

        double seno = Math.sin(rad);
        double cosseno = Math.cos(rad);
        double tang = Math.tan(rad);
        // Imprime resultado
        System.out.println("O resultado da dezena obtido no cosseno, seno e tangente: " + seno + "\n" + cosseno + "\n" + tang);

        // Fecha o scanner
        scanner.close();
    }
}