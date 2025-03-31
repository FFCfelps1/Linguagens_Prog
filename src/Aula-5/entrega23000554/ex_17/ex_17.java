/*
 * Faça um algoritmo para imprimir na tela uma tabela de
conversão de graus Celsius para graus Fahrenheit. Deseja-se
que o mesmo solicite ao usuário o limite inferior, o superior e
o incremento. Lembre-se que C = 5.(F-32)/9;
Laços de Repetição

 */

import java.util.Scanner;

public class ex_17 {
    //entrada de dados
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double celsius = 0;
        double fahrenheit = 0;
        double inferior;
        double superior;
        double incremento;

        System.out.println("Digite o limite inferior: ");
        inferior = scanner.nextDouble();
        System.out.println("Digite o limite superior: ");
        superior = scanner.nextDouble();
        System.out.println("Digite o incremento: ");
        incremento = scanner.nextDouble();

        System.out.println("Tabela de conversão: ");
        for (double i = inferior; i <= superior; i += incremento){
            fahrenheit = (9 * i + 160) / 5;
            System.out.println("Valor em Celsius: " + i + "   | Valor em Fahrenheit: " + fahrenheit);
        }
    }
}