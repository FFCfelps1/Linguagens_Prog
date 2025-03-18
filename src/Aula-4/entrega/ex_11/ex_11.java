/*
 * Entrar com um número e informar se ele é divisível por 3 e
por 7;
 */

import java.util.Scanner;

public class ex_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número: ");
        int num = scanner.nextInt();

        if (num % 3 == 0 && num % 7 == 0) {
            System.out.println("O número é divisível por 3 e 7");
        } else {
            System.out.println("O número não é divisível por 3 e 7");
        }
    }
}