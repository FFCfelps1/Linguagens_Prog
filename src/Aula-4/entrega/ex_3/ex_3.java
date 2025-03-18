/*
 * Entrar com um número e imprimir a raiz quadrada do número
caso ele seja positivo e o quadrado do número caso seja
negativo;
Desvios Condicionais e Switch-case
 */

import java.util.Scanner;

public class ex_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número: ");
        int num = scanner.nextInt();

        if (num >= 0) {
            System.out.println("A raiz quadrada do número é: " + Math.sqrt(num));
        } else {
            System.out.println("O quadrado do número é: " + Math.pow(num, 2));
        }
    }
}