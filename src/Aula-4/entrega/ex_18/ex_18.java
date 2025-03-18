/*
 * Entrar com dois números e imprimi-los em ordem crescente
(suponha números diferentes);
 */

import java.util.Scanner;

public class ex_18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o primeiro número: ");
        int num1 = scanner.nextInt();

        System.out.println("Digite o segundo número: ");
        int num2 = scanner.nextInt();

        if (num1 < num2) {
            System.out.println("Os números em ordem crescente são: " + num1 + " e " + num2);
        } else {
            System.out.println("Os números em ordem crescente são: " + num2 + " e " + num1);
        }
    }
}