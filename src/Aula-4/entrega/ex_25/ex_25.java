/*
Construir um algoritmo que leia três números e imprima se
eles podem ou não ser lados de um triângulo. Lembrando
que, para ser um triângulo, a soma de dois lados quaisquer
deve ser sempre maior que o lado que ficou de fora da soma.
 */

 import java.util.Scanner;

 public class ex_25 {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
 
         System.out.println("Digite o primeiro número: ");
         int a = scanner.nextInt();
 
         System.out.println("Digite o segundo número: ");
         int b = scanner.nextInt();
 
         System.out.println("Digite o segundo número: ");
         int c = scanner.nextInt();

        if (a + b >= c && a + c >= b && b + c >= a) {
            System.out.println("Os números podem ser lados de um triângulo.");
        } else {
            System.out.println("Os números não podem ser lados de um triângulo.");
        }
     }
 }