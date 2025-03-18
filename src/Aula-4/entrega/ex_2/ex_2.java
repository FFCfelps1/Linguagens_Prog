/*
 * Construir um algoritmo que leia dois números e efetue a
adição. Caso o valor somado seja menor ou igual a 20, este
deverá ser apresentado subtraindo-se 5;
 */

import java.util.Scanner;

public class ex_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o primeiro número: ");
        int num1 = scanner.nextInt();

        System.out.println("Digite o segundo número: ");
        int num2 = scanner.nextInt();

        int soma = num1 + num2;

        if (soma <= 20) {
            System.out.println("A soma dos números menos 5: " + (soma - 5));
        }
    }
}
