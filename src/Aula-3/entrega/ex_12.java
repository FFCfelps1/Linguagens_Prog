import java.util.Scanner;  // Importa a classe Scanner

public class ex_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria o objeto Scanner para ler a entrada do usuário
        
        // Definição de variáveis
        int data;
        
        // Entrada de dados
        System.out.print("Informe data: ");
        data = scanner.nextInt();
        
        // Calcula o dia, mes e ano
        int ano = (data%100);
        int mes = ((data - ano)/100)%10;
        int dia = (data - ano - mes)/10000;
        
        
        // Imprime resultado
        System.out.println("O resultado do dia: " + dia);
        System.out.println("O resultado do mes: " + mes);
        System.out.println("O resultado do ano: " + ano);
        
        // Fecha o scanner
        scanner.close();
    }
}