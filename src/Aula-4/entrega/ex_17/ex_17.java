/*
 * Entrar com dois números e imprimir o menor número
(suponha números diferentes);
 */

import java.util.Scanner;

public class ex_17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o primeiro número: ");
        int num1 = scanner.nextInt();

        System.out.println("Digite o segundo número: ");
        int num2 = scanner.nextInt();

        if (num1 < num2) {
            System.out.println("O menor número é: " + num1);
        } else {
            System.out.println("O menor número é: " + num2);
        }
    }
}