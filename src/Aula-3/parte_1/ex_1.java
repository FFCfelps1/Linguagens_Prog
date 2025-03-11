import java.util.Scanner;  // Importa a classe Scanner

public class ex_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria o objeto Scanner para ler a entrada do usuário
        int controle = 1;

        do {
            // Definição das variáveis
            String nome;
            String produto;
            int quantidade;
            float preco;

            // Entrada de dados
            System.out.print("Digite o nome do comprador: ");
            nome = scanner.nextLine();
            System.out.print("Digite o nome do produto: ");
            produto = scanner.nextLine();
            System.out.print("Digite a quantidade adquirida: ");
            quantidade = scanner.nextInt();
            System.out.print("Digite o preço unitário do produto: ");
            preco = scanner.nextFloat();

            // Cálculo do valor total
            float total = quantidade * preco;

            // Impressão da Nota Fiscal
            System.out.println("\n==============================");
            System.out.println("         NOTA FISCAL           ");
            System.out.println("==============================");
            System.out.println("Nome do comprador: " + nome);
            System.out.println("Produto adquirido: " + produto);
            System.out.println("Quantidade: " + quantidade);
            System.out.println("Preço unitário: R$ " + String.format("%.2f", preco));
            System.out.println("Valor total: R$ " + String.format("%.2f", total));
            System.out.println("==============================");

            // Verifica se o usuário deseja continuar
            System.out.print("\nDeseja continuar? (1 - Sim / 0 - Não): ");
            controle = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha deixada pelo nextInt()
            
        } while (controle == 1);

        // Fecha o scanner
        scanner.close();
    }
}