/*
Entrar com o nome, sexo e idade de uma pessoa. Se a pessoa
for do sexo feminino e tiver menos que 25 anos, imprimir
nome e a mensagem: ACEITA. Caso contrário, imprimir nome
e a mensagem: NÃO ACEITA. (Considerar f ou F);
 */

import java.util.Scanner;

public class ex_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o sexo (M/F): ");
        char sexo = scanner.next().charAt(0);

        System.out.println("Digite a idade: ");
        int idade = scanner.nextInt();

        if (sexo == 'F' || sexo == 'f') {
            if (idade < 25) {
                System.out.println(nome + " ACEITA");
            } else {
                System.out.println(nome + " NÃO ACEITA");
            }
        }
    }
}