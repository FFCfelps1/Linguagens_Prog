/*
 * Ler três números e armazená-los em três variáveis com os
seguintes nomes, de acordo com seus valores relativos:
maior, intermediário e menor (suponha números diferentes);
 */

 import java.util.Scanner;

 public class ex_23 {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
 
         System.out.println("Digite o primeiro número: ");
         int num1 = scanner.nextInt();
 
         System.out.println("Digite o segundo número: ");
         int num2 = scanner.nextInt();
 
         System.out.println("Digite o segundo número: ");
         int num3 = scanner.nextInt();
        
        int maior = 0;
        int intermediario = 0;
        int menor = 0;

        if (num1 > num2 && num1 > num3){
            maior = num1;
            if (num2 > num3){
                intermediario = num2;
                menor = num3;
            } else {
                intermediario = num3;
                menor = num2;
            }
        } else if (num2 > num3 && num2 > num1){
            maior = num2;
            if (num1 > num3){
                intermediario = num1;
                menor = num3;
            } else {
                intermediario = num3;
                menor = num1;
            }
        } else if (num3 > num1 && num3 > num2){
            maior = num3;
            if (num1 > num2){
                intermediario = num1;
                menor = num2;
            } else {
                intermediario = num2;
                menor = num1;
            }
        }
        
        System.out.println("O maior número é: " + maior);
        System.out.println("O intermediário número é: " + intermediario);
        System.out.println("O menor número é: " + menor);
     }
 }