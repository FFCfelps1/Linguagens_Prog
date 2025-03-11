import java.io.*;
import java.util.Scanner;

public class ex_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Entrada de dados via teclado
        System.out.print("Digite o nome do comprador: ");
        String nome = scanner.nextLine();
        
        System.out.print("Digite o nome do produto: ");
        String produto = scanner.nextLine();
        
        System.out.print("Digite a quantidade adquirida: ");
        int quantidade = scanner.nextInt();
        
        System.out.print("Digite o preço unitário do produto: ");
        float preco = scanner.nextFloat();
        
        // Fechando o scanner
        scanner.close();
        
        // Cálculo do valor total
        float total = quantidade * preco;
        
        try {
            // Abrindo o arquivo para escrita
            BufferedWriter writer = new BufferedWriter(new FileWriter("nota_fiscal.txt"));
            
            // Escrevendo a Nota Fiscal no arquivo
            writer.write("==============================\n");
            writer.write("         NOTA FISCAL           \n");
            writer.write("==============================\n");
            writer.write("Nome do comprador: " + nome + "\n");
            writer.write("Produto adquirido: " + produto + "\n");
            writer.write("Quantidade: " + quantidade + "\n");
            writer.write("Preço unitário: R$ " + String.format("%.2f", preco) + "\n");
            writer.write("Valor total: R$ " + String.format("%.2f", total) + "\n");
            writer.write("==============================\n");
            
            // Fechando o arquivo de escrita
            writer.close();
            
            System.out.println("Nota fiscal gerada com sucesso no arquivo 'nota_fiscal.txt'.");
        } catch (IOException e) {
            System.out.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }
}