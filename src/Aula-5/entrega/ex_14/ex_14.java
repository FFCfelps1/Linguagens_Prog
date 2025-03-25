/*
 * Entrar com vários números e imprimir o maior. O algoritmo
para quando se digita -9999;
Laços de Repetição
 */

 import java.util.Scanner;

 public class ex_14 {
    //entrada de dados
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double var = 0;
        double anterior = 0;
        double maior = 0;
        do {
            System.out.println("Digite um número: ");
            var = scanner.nextDouble();
            if (var != -999){
                if (var > anterior){
                    maior = var;
                }else{
                    maior = anterior;
                }
                anterior = var;
            }
        } while (var != -999);

        System.out.println("O maior número digitado foi: " + maior);
    }
}
