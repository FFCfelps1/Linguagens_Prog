/*
 * Entrar com o ano de nascimento de uma pessoa e o ano atual.
Imprimir a idade da pessoa. Não se esqueça de verificar se o
ano de nascimento é um ano válido;
 */

import java.util.Scanner;

public class ex_15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o ano de nascimento: ");
        int anoNascimento = scanner.nextInt();

        System.out.println("Digite o ano atual: ");
        int anoAtual = scanner.nextInt();

        if (anoNascimento < 0 || anoAtual < 0) {
            System.out.println("Ano inválido");
            return;
        }

        int idade = anoAtual - anoNascimento;

        System.out.println("A idade da pessoa é " + idade);
    }
}