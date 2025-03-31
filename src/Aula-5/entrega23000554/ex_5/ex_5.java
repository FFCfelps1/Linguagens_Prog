/*
 * Ler vários números até entrar o número -999. Para cada
número, imprimir sua raiz quadrada e seu inverso;
 */

//bibliotecas
import java.util.Scanner;

public class ex_5 {
    //entrada de dados
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double var = 0;
        do {
            System.out.println("Digite um número: ");
            var = scanner.nextDouble();
            if (var != -999){
                System.out.println("Raiz quadrada: " + Math.sqrt(var));
                System.out.println("Inverso: " + 1/var);
            }
        } while (var != -999);
    }
}