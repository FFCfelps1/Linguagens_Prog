/*
 * Ler um número inteiro de 3 dígitos e imprimir se o algarismo
da casa das dezenas é par ou ímpar;
 */

import java.util.Scanner;

public class ex_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número de 3 dígitos: ");
        int num = scanner.nextInt();

        if (num < 100 || num > 999) {
            System.out.println("O número não tem 3 dígitos");
            return;
        }

        int dezena = (num / 10) % 10;

        if (dezena % 2 == 0) {
            System.out.println("O algarismo da casa das dezenas é par");
        } else {
            System.out.println("O algarismo da casa das dezenas é ímpar");
        }
    }
}