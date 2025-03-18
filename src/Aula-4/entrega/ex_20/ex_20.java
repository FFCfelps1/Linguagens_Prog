/*
 * Criar um algoritmo que deixe entrar com dois números e
imprimir o quadrado do menor número e a raiz quadrada do
maior número, se for possível (suponha números diferentes);
 */

import java.util.Scanner;

public class ex_20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o primeiro número: ");
        int num1 = scanner.nextInt();

        System.out.println("Digite o segundo número: ");
        int num2 = scanner.nextInt();

        if (num1 < num2) {
            System.out.println("O quadrado do menor número é: " + Math.pow(num1, 2));
            System.out.println("A raiz quadrada do maior número é: " + Math.sqrt(num2));
        } else {
            System.out.println("O quadrado do menor número é: " + Math.pow(num2, 2));
            System.out.println("A raiz quadrada do maior número é: " + Math.sqrt(num1));
        }
    }
}