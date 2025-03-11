import java.util.Scanner;  // Importa a classe Scanner

public class ex_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria o objeto Scanner para ler a entrada do usuário
        
        // Definição de variáveis
        String txt1;
        String txt2;
        String txt3;

        // Entrada de dados
        System.out.print("Informe a string 1: ");
        txt1 = scanner.nextLine();
        System.out.print("Informe a string 2: ");
        txt2 = scanner.nextLine();
        System.out.print("Informe a string 3: ");
        txt3 = scanner.nextLine();
        
        // Calcula o valor do comprimento das 3 juntas
        int comprimento = txt1.length() + txt2.length() + txt3.length();
        
        // Imprime resultado
        System.out.println("O resultado do valor obtido: " + comprimento);
        
        // Fecha o scanner
        scanner.close();
    }
}