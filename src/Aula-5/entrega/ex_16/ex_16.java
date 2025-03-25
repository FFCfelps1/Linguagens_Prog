/*
 * Faça um algoritmo para imprimir na tela uma tabela de
conversão de polegadas para centímetros. Deseja-se que a
tabela conste de valores desde 1 até 20 polegadas. Lembre-se
que 1 polegada equivale a 2,54 cm;
 */

 import java.util.Scanner;

 public class ex_16 {
     //entrada de dados
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        double centimetros = 0;

         System.out.println("Tabela de conversão: ");
         for (int i = 0; i < 21; i++){
            centimetros = i * 2.54;
            System.out.println("Valor em polegadas: " + i + "   | Valor em centímetros: " + centimetros);
         }
     }
 }