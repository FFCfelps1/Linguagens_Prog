/*
 * Criar um algoritmo que leia um número que será o limite
superior de um intervalo e o incremento. Imprimir todos os
números do intervalo de 0 até esse número, de incremento
em incremento. Ex.: limite 20, incremento 5; vai imprimir 0, 5,
10, 15, 20;
 */

import java.util.Scanner;

public class ex_19 {
    //entrada de dados
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int limite;
        int incremento;

        System.out.println("Digite o limite superior: ");
        limite = scanner.nextInt();
        System.out.println("Digite o incremento: ");
        incremento = scanner.nextInt();

        System.out.println("Tabela de conversão: ");
        for (int i = 0; i <= limite; i += incremento){
            System.out.println(i);
        }
    }
}