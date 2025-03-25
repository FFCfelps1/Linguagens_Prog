/*
 * Ler vários números e informar quantos números entre 100 e
200 foram digitados. Quando o valor 0 (zero) for lido o
algoritmo deverá cessar sua execução;
 */

//bibliotecas
import java.util.Scanner;

public class ex_3 {
    //entrada de dados
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int var = 0;
        int count = 0;
        do {
            System.out.println("Digite um número: ");
            var = scanner.nextInt();
            if (var >= 100 && var <= 200){
                count += 1;
            }
        } while (var != 0);
        System.out.println("Quantidade de números entre 100 e 200: " + count);

        scanner.close();
    }
}
