/*
 * Ajude uma escola a montar as divisões do laboratório de
programação. Para isso, escreva um algoritmo que leia o
nome do aluno e diga em qual divisão ele está respeitando a
regra abaixo (dica: use o método charAt(posição):
- alunos cujo nome começa com as letras de A a K estão na D1;
- alunos cujo nome começa com as letras de L a N estão na D2;
- alunos cujo nome começa com as letras de O a Z estão na D3
 */

 package ex_28;

 import java.util.Scanner;

 public class ex_28 {
 
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nome;

        System.out.println("Digite nome de interesse: ");
        nome = scanner.nextLine();

        char letra_1 = nome.charAt(0);
        letra_1 = Character.toLowerCase(letra_1);

        if ('a' <= letra_1 && letra_1 <= 'k'){
            System.out.println("O aluno está na D1");
        } else if ('l' <= letra_1 && letra_1 <= 'n'){
            System.out.println("O aluno está na D2");
        } else if ('o' <= letra_1 && letra_1 <= 'z'){
            System.out.println("O aluno está na D3");
          }        


     }
 }
