/*
 * Entrar com o nome, idade e sexo de 20 pessoas. Imprimir o
nome sempre que a pessoa for do sexo masculino e tiver mais
de 21 anos;
 */

import java.util.Scanner;

public class ex_20 {
    //entrada de dados
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nome;
        int idade;
        char sexo;

        for (int i = 0; i < 20; i++){
            System.out.println("Digite o nome: ");
            nome = scanner.next();
            System.out.println("Digite a idade: ");
            idade = scanner.nextInt();
            System.out.println("Digite o sexo: ");
            sexo = scanner.next().charAt(0);

            if (sexo == 'm' && idade > 21){
                System.out.println(nome);
            }
        }
    }
}