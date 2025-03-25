/*
 * Criar um algoritmo que leia um número que servirá para
controlar os números pares que serão impressos a partir de 2
Exemplo: quantos 4, imprime 2, 4, 6, 8;
 */

import java.util.Scanner;

public class ex_22 {
    //entrada de dados
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int limite;
        int var = 2;

        System.out.println("Digite a quantidade de pares: ");
        limite = scanner.nextInt();

        System.out.println("Tabela de conversão: ");
        for (int i = 0; i < limite; i ++){
            System.out.println(var);
            var += 2;
        }
    }
}