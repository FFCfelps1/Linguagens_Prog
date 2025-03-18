/*
 * Construir um algoritmo que indique se o número digitado
está compreendido entre 20 e 90 ou não;
 */

import java.util.Scanner;

public class ex_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número: ");
        int num = scanner.nextInt();

        if (num >= 20 && num <= 90) {
            System.out.println("O número está entre 20 e 90");
        } else {
            System.out.println("O número não está entre 20 e 90");
        }
    }
}