/*
 * Faça um algoritmo que peça para o usuário digitar um
número e mostre na tela a sequência de Fibonacci de 1 até
este número;
 */

import java.util.Scanner;

public class ex_15 {
    //entrada de dados
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int var;
        int fib = 1;
        int fib1 = 0;
        int fib2 = 1;
        System.out.println("Digite um número: ");
        var = scanner.nextInt();

        System.out.println("Sequência de Fibonacci: ");
        for (int i = 0; i < var; i++){
            System.out.println(fib);
            fib = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib;
        }
    }
}
