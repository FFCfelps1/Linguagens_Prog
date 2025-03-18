/*
 * Entrar com um número e informar se ele é ou não divisível
por 5;
 */

import java.util.Scanner;

public class ex_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número: ");
        int num = scanner.nextInt();

        if (num % 5 == 0) {
            System.out.println("O número é divisível por 5");
        } else {
            System.out.println("O número não é divisível por 5");
        }
    }
}