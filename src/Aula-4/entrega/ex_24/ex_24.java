/*
 * Ler cinco números e identificar o maior e o menor de todos
(NÃO suponha números diferentes).
 */

 import java.util.Scanner;

 public class ex_24 {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
 
         System.out.println("Digite o primeiro número: ");
         int num1 = scanner.nextInt();
 
         System.out.println("Digite o segundo número: ");
         int num2 = scanner.nextInt();
 
         System.out.println("Digite o segundo número: ");
         int num3 = scanner.nextInt();

         System.out.println("Digite o segundo número: ");
         int num4 = scanner.nextInt();

         System.out.println("Digite o segundo número: ");
         int num5 = scanner.nextInt();
        
        // Verificando o maior número
        int maior = num1;

        if (num2 > maior) {
            maior = num2;
        }
        if (num3 > maior) {
            maior = num3;
        }
        if (num4 > maior) {
            maior = num4;
        }
        if (num5 > maior) {
            maior = num5;
        }

        // Verificando o menor número
        int menor = num1;

        if (num2 < menor) {
            menor = num2;
        }
        if (num3 < menor) {
            menor = num3;
        }
        if (num4 < menor) {
            menor = num4;
        }
        if (num5 < menor) {
            menor = num5;
        }


        System.out.println("O maior número é: " + maior);
        System.out.println("O menor número é: " + menor);

     }
 }