import java.util.Scanner;  // Importa a classe Scanner

public class ex_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria o objeto Scanner para ler a entrada do usuário
        
        // Definição de variáveis
        double valor_ini;
        double valor_final;
        float juros;
        int meses;
        
        // Entrada de dados
        System.out.print("Informe o valor para consultar juros: ");
        valor_ini = scanner.nextDouble();
        System.out.print("Informe o juros a ser utilizado: ");
        juros = scanner.nextFloat();
        System.out.print("Informe o numero de meses: ");
        meses = scanner.nextInt();

        // Calcula o quadrado do valor
        valor_final = valor_ini * Math.pow((1+juros/100), meses);
        
        // Imprime resultado
        System.out.println("O resultado do valor obtido: " + String.format("%.2f", valor_final));
        
        // Fecha o scanner
        scanner.close();
    }
}