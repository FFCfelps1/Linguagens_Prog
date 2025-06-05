/*
 * Criar um algoritmo que leia um número que será o limite
superior de um intervalo e imprimir todos os números
ímpares menores do que esse número. Exemplo: limite 15,
imprime 1, 3,5, 7, 9, 11, 13;
 */

import java.util.Scanner;

public class ex_21 {
    //entrada de dados
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int limite;

        System.out.println("Digite o limite superior: ");
        limite = scanner.nextInt();

        System.out.println("Tabela de conversão: ");
        for (int i = 0; i < limite; i ++){
            System.out.println(i);
        }
    }
}