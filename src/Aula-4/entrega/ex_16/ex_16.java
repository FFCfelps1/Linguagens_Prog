/*
 * Crie um algoritmo que leia dois números e imprimir uma
mensagem dizendo se são iguais ou diferentes;
 */

import java.util.Scanner;

public class ex_16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o primeiro número: ");
        int num1 = scanner.nextInt();

        System.out.println("Digite o segundo número: ");
        int num2 = scanner.nextInt();

        if (num1 == num2) {
            System.out.println("Os números são iguais");
        } else {
            System.out.println("Os números são diferentes");
        }
    }
}