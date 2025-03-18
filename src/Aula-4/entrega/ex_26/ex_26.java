package ex_26;

/*
 * Construir um algoritmo que leia três números que
representam os lados de um triângulo e que imprima se o
triângulo é equilátero (três lados iguais), isósceles (dois lados
iguais) ou escaleno (três lados diferentes). Antes, não se
esqueça de testar se os três lados realmente formam um
triângulo. Informe o usuário caso não formem;

 */

import java.util.Scanner;

public class ex_26 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b, c;
        System.out.println("Digite o valor do lado A: ");
        a = scanner.nextInt();
        System.out.println("Digite o valor do lado B: ");
        b = scanner.nextInt();
        System.out.println("Digite o valor do lado C: ");
        c = scanner.nextInt();
        
        if (a < b + c && b < a + c && c < a + b) {
            if (a == b && b == c) {
                System.out.println("Triângulo Equilátero");
            } else if (a == b || a == c || b == c) {
                System.out.println("Triângulo Isósceles");
            } else {
                System.out.println("Triângulo Escaleno");
            }
        } else {
            System.out.println("Os valores informados não formam um triângulo");
        }
    }

}
