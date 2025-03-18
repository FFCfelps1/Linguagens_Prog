/*
 * 1. Construir um algoritmo que leia dois valores numéricos
inteiros e efetue a adição deles; caso o resultado seja maior
que 10, apresentá-lo;
 */

import java.util.Scanner;

public class ex_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o primeiro número: ");
        int num1 = scanner.nextInt();

        System.out.println("Digite o segundo número: ");
        int num2 = scanner.nextInt();

        int soma = num1 + num2;

        if (soma > 10) {
            System.out.println("A soma dos números é: " + soma);
        }
    }
}