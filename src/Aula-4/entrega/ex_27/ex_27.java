/*
 * Entrar com um verbo no infinitivo e imprimir se o verbo é da
1ª conjugação (terminados em ar), da 2ª conjugação
(terminados em er), da 3ª conjugação (terminados em ir), se
não está no infinitivo (não termina em r) ou se provavelmente
nem é verbo no infinitivo (termina em or ou em ur);
 */

 package ex_27;
 import java.util.Scanner;

public class ex_27 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String verbo;

        System.out.println("Digite o verbo de interesse: ");
        verbo = scanner.nextLine();

        String conj = verbo.substring((verbo.length()-2), verbo.length());

        String resposta = "";

        switch (conj.toLowerCase()) {

            case "ar" : resposta = "1° cojunção";
                System.out.println("O verbo é:" + resposta);
                break;
            case "er" : resposta = "2° cojunção";
                System.out.println("O verbo é:" + resposta);
                break;
            case "ir" : resposta = "3° cojunção";
                System.out.println("O verbo é:" + resposta);
                break;
            default : 
                System.out.println("verbo não está no infinitivo, ou não termina com r");
                break;
        }
    }
}