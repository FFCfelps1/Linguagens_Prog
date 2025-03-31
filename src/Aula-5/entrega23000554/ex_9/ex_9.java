/*
 * Ler vários números até entrar o número -999. Para cada
número, imprimir seus divisores;
 */

 import java.util.Scanner;

 public class ex_9 {
    //entrada de dados
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double var = 0;
        do {
            System.out.println("Digite um número: ");
            var = scanner.nextDouble();
            if (var != -999){
                for (int i = 0; i < var; i++){
                    if (var%i == 0){
                        System.out.println("Valor " + i + " é divisivel por " + var);
                    }
                }
            }
        } while (var != -999);
    }
}