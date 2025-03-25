/*
 * Uma empresa de fornecimento de energia elétrica faz a
leitura mensal dos medidores de consumo. Para cada
consumidor são digitados os seguintes dados: código do
consumidor, quantidade de kWh consumidos durante o mês,
tipo do consumidor. Os tipos podem ser 1 - residencial, preço
por kWh = R$ 0,3; 2 - comercial, preço por kWh = 0,5; 3 -
industrial, preço por kWh = 0,7. Os dados devem ser lidos até
que seja encontrado um consumidor com código 0 (zero).
Calcular e imprimir o custo total para cada consumidor, o
total de consumo para os três tipos de consumidor, a média
de consumo dos tipos 1 e 2.
 */

//bibliotecas
import java.util.Scanner;

public class ex_10 {
    //entrada de dados
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cod = 0;
        double kwh = 0;
        int tipo = 0;
        double total = 0;
        double total1 = 0;
        double total2 = 0;
        double total3 = 0;
        double media = 0;
        double media1 = 0;
        double media2 = 0;
        double media3 = 0;
        do {
            System.out.println("Digite o código do consumidor: ");
            cod = scanner.nextInt();
            if (cod != 0){
                System.out.println("Digite a quantidade de kWh consumidos: ");
                kwh = scanner.nextDouble();
                System.out.println("Digite o tipo do consumidor: ");
                tipo = scanner.nextInt();
                if (tipo == 1){
                    total1 += kwh * 0.3;
                    media1 += kwh;
                } else if (tipo == 2){
                    total2 += kwh * 0.5;
                    media2 += kwh;
                } else if (tipo == 3){
                    total3 += kwh * 0.7;
                    media3 += kwh;
                }
                total += kwh;
            }
        } while (cod != 0);
        media = (media1 + media2) / 2;
        System.out.println("Custo total para cada consumidor: " + total);
        System.out.println("Total de consumo para o tipo 1: " + total1);
        System.out.println("Total de consumo para o tipo 2: " + total2);
        System.out.println("Total de consumo para o tipo 3: " + total3);
        System.out.println("Média de consumo dos tipos 1 e 2: " + media);

        scanner.close();
    }
}