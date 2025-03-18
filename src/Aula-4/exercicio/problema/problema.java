/*
 * A prefeitura de Rio dos Grilos abriu uma linha de crédito para
seus funcionários. O valor máximo da prestação não poderá
ultrapassar a 30% do salário bruto de cada um.
Fazer um algoritmo que permita entrar com o salário bruto e
o valor da prestação. Daí, informar se o empréstimo pode ou
não ser concedido.
 */

import java.util.Scanner;

public class problema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Salário bruto: ");
        double salario = scanner.nextDouble();

        System.out.print("Valor da prestação: ");
        double prestacao = scanner.nextDouble();

        if (prestacao > salario * 0.3) {
            System.out.println("Empréstimo não pode ser concedido");
        } else {
            System.out.println("Empréstimo pode ser concedido");
        }
    }
}
