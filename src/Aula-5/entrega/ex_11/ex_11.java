/*
 * Entrar com a idade de várias pessoas e imprimir: total de
pessoas com menos de 21 anos e total de pessoas com mais
de 50 anos. Parar quando for digitada uma idade fora da faixa
0-120 anos;
 */

 import java.util.Scanner;

 public class ex_11 {
    //entrada de dados
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int var = 0;
        int menos_21 = 0;
        int maior_50 = 0;
        do {
            System.out.println("Digite uma idade: ");
            var = scanner.nextInt();
            if (var < 0 || var < 120){

                if (var < 21){
                    menos_21 += 1;
                }
                if (var > 50){
                    maior_50 += 1;
                }
            }
        } while (var < 0 || var < 120);
        System.out.println("valor de pessoas com menos de 21 anos: " + menos_21);
        System.out.println("valor de pessoas com mais de 50 anos: " + maior_50);
    }
}