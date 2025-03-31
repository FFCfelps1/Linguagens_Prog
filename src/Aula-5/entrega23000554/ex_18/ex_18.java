/*
 * Crie um algoritmo que calcule o fatorial de um número.
Exemplo: 0! = 1; 1! = 1; 2! = 1*2 = 2; 3! = 1*2*3 = 6; 4! =
1*2*3*4 = 24; 5! = 1*2*3*4*5 = 120;
 */

import java.util.Scanner;

public class ex_18 {
    //entrada de dados
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int var;
        int fat = 1;
        System.out.println("Digite um número: ");
        var = scanner.nextInt();

        for (int i = 1; i <= var; i++){
            fat *= i;
        }
        System.out.println("O fatorial de "+ var +" é: "+ fat);
    }
}