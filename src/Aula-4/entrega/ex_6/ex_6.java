/*
 * Entrar com um número e imprimir uma das mensagens: maior
do que 20, igual a 20 ou menor do que 20;
 */

import java.util.Scanner;

public class ex_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número: ");
        int num = scanner.nextInt();

        if (num > 20) {
            System.out.println("O número é maior que 20");
        } else if (num == 20) {
            System.out.println("O número é igual a 20");
        } else {
            System.out.println("O número é menor que 20");
        }
    }
}