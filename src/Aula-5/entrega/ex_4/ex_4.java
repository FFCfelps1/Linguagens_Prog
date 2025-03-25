/*
 * Entrar com nomes enquanto forem diferentes de FIM e
imprimir cada nome digitado;
 */

//bibliotecas
import java.util.Scanner;

public class ex_4 {
    //entrada de dados
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String var = "";
        do {
            System.out.println("Digite um nome: ");
            var = scanner.nextLine();
            if (!var.equals("FIM")){
                System.out.println("Nome digitado: " + var);
            }
        } while (!var.equals("FIM"));
    }
}