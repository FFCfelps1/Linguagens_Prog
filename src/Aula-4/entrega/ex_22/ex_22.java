/*
 * Ler três números e armazenar o maior número na variável de
nome maior (suponha números diferentes);
 */

 import java.util.Scanner;

 public class ex_22 {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
 
         System.out.println("Digite o primeiro número: ");
         int num1 = scanner.nextInt();
 
         System.out.println("Digite o segundo número: ");
         int num2 = scanner.nextInt();
 
         System.out.println("Digite o segundo número: ");
         int num3 = scanner.nextInt();
        
        int maior = 0;

        if (num1 > num2 && num1 > num3){
            maior = num1;
        } else if (num2 > num3 && num2 > num1){
            maior = num2;
        } else if (num3 > num1 && num3 > num2){
            maior = num3;
        }
        
        System.out.println("O maior número é: " + maior);
     }
 }