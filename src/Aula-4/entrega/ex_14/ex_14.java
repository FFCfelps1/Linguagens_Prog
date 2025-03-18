/*
 * Ler um número inteiro de 4 dígitos e imprimir se é ou não
múltiplo de quatro o número formado pelos algarismos que
estão nas casas das unidades de milhar e das centenas;
 */

import java.util.Scanner;

public class ex_14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número de 4 dígitos: ");
        int num = scanner.nextInt();

        if (num < 1000 || num > 9999) {
            System.out.println("O número não tem 4 dígitos");
            return;
        }

        int milhar = num / 1000;
        int centena = (num / 100) % 10;

        int num2 = milhar * 10 + centena;

        if (num2 % 4 == 0) {
            System.out.println("O número formado pelos algarismos das casas das unidades de milhar e das centenas é múltiplo de 4");
        } else {
            System.out.println("O número formado pelos algarismos das casas das unidades de milhar e das centenas não é múltiplo de 4");
        }
    }
}