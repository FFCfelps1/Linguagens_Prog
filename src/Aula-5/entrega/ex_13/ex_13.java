/*
 * Escrever um algoritmo que receba vários números inteiros
positivos e imprima a quantidade de números primos dentre
os números que foram digitados. Parar quando for digitado
um número não positivo;
 */

 import java.util.Scanner;

 public class ex_13 {
    //entrada de dados
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int var;
        int soma = 0;
        do{
            System.out.println("Digite um número: ");
            var = scanner.nextInt();
            int div = 0;
            for (int i = 2; i < var; i++){
                if (var%i == 0){
                    div += 1;
                }
            }
            if (div == 0){
                System.out.println("O valor "+ var +" é primo");
                soma += 1;
            }
        }while (var > 0);

        System.out.println("A quantidade de números primos digitados foi de: " + soma);
    }
}