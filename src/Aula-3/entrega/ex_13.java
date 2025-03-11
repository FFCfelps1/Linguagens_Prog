import java.util.Scanner;  // Importa a classe Scanner

public class ex_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria o objeto Scanner para ler a entrada do usuário
        
        // Definição de variáveis
        String data;

        // Entrada de dados
        System.out.print("Informe a data: ");
        data = scanner.nextLine();

        // Separa e junta os respectivos
        String dia = data.substring(0,2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6, data.length());
        // Imprime resultado
        System.out.println("O resultado do dia: " + dia);
        System.out.println("O resultado do mes: " + mes);
        System.out.println("O resultado do ano: " + ano);
        
        // Fecha o scanner
        scanner.close();
    }
}