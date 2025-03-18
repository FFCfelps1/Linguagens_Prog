/*
 * Ler três números e escrever o maior número (suponha
números diferentes);
 */

import java.util.Scanner;

public class ex_21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o primeiro número: ");
        int num1 = scanner.nextInt();

        System.out.println("Digite o segundo número: ");
        int num2 = scanner.nextInt();

        System.out.println("Digite o segundo número: ");
        int num3 = scanner.nextInt();

        if (num1 > num2 && num1 > num3){
            System.out.println("O número 1 é maior que 2 e o 3: " + num1);
        } else if (num2 > num3 && num2 > num1){
            System.out.println("O número 2 é maior que 1 e o 3: " + num2);
        } else if (num3 > num1 && num3 > num2){
            System.out.println("O número 3 é maior que 1 e o 2: " + num3);
        }
    }
}