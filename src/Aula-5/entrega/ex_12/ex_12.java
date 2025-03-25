/*
 * Entrar com um número e verificar se ele é um número primo;
 */

 import java.util.Scanner;

 public class ex_12 {
    //entrada de dados
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int var;

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
        }
    }
}