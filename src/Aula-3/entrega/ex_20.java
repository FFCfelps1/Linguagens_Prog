// programa para calcular o terceiro lado de um triangulo

import java.util.Scanner;  // Importa a classe Scanner

public class ex_20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria o objeto Scanner para ler a entrada do usuário
        
        // Definição de variáveis
        float lado_1;
        float lado_2;
        float ang;

        // Calcula a área do retângulo
        System.out.print("Digite o valor do lado 1: ");
        lado_1 = scanner.nextInt();
        System.out.print("Digite o valor do lado 2: ");
        lado_2 = scanner.nextInt();
        System.out.print("Digite o valor do angulo entre eles: ");
        ang = scanner.nextInt();

        // Calcula o valor do angulo em rad
        double rad = (ang * Math.PI)/180;

        // Calcula o valor do terceiro lado
        double lado_3 = Math.sqrt(Math.pow(lado_1, 2) + Math.pow(lado_2, 2) - 2 * lado_1 * lado_2 * Math.cos(rad));



        // Imprime resultado
        System.out.println("Valor do terceiro lado: " + String.format("%.2f", lado_3));
        
        // Fecha o scanner
        scanner.close();
    }
}