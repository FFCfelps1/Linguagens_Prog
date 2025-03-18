/*
 * Entrar com um número e imprimir uma das mensagens: é
múltiplo de 3 ou não é;
 */

import java.util.Scanner;

public class ex_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número: ");
        int num = scanner.nextInt();

        if (num % 3 == 0) {
            System.out.println("O número é múltiplo de 3");
        } else {
            System.out.println("O número não é múltiplo de 3");
        }
    }
}