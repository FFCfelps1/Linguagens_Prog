/*
 * Escrever um algoritmo que lê̂ 2 números reais. A seguir, é
apresentado, para o usuário, o menu a seguir:
“Operações Disponíveis:
1. Adição;
2. Subtração;
3. Multiplicação;
4. Divisão;
9. Sair do Programa.
Digite o número de ordem da opção desejada: “
 */

import java.util.Scanner;

public class ex_25 {
    //entrada de dados
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2;
        int opcao;

        System.out.println("Digite o primeiro número: ");
        num1 = scanner.nextDouble();
        System.out.println("Digite o segundo número: ");
        num2 = scanner.nextDouble();

        do {
            System.out.println("Operações Disponíveis:\n1. Adição;\n2. Subtração;\n3. Multiplicação;\n4. Divisão;\n9. Sair do Programa.");
            System.out.println("Digite o número de ordem da opção desejada: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Resultado: " + (num1 + num2));
                    break;
                case 2:
                    System.out.println("Resultado: " + (num1 - num2));
                    break;
                case 3:
                    System.out.println("Resultado: " + (num1 * num2));
                    break;
                case 4:
                    System.out.println("Resultado: " + (num1 / num2));
                    break;
                case 9:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida, digite novamente.");
            }

        } while (opcao != 9);
    }
}