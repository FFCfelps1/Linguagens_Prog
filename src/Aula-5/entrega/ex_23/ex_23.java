/*
 * Escrever um algoritmo que lê̂ repetidamente o valor do preço
de uma mercadoria e a quantidade de itens comprados dessa
mercadoria. Quando a quantidade lida for igual a zero, o
algoritmo deve mostrar o total a ser pago. O algoritmo não
deve computar valores negativos de preço ou de quantidade;
neste caso, o algoritmo deve pedir que o usuário digite
novamente o valor do preço ou da quantidade digitados
indevidamente (sugestão: usar outro loop faça-enquanto para
cada caso).
OBS.: Considerar a quantidade de mercadorias compradas
é desconhecida;
 */

 import java.util.Scanner;

public class ex_23 {
    //entrada de dados
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double preco;
        int quantidade;
        double total = 0;

        do{
            do {
                System.out.println("Digite o preço: ");
                preco = scanner.nextDouble();
                if (preco < 0){
                    System.out.println("Preço inválido, digite novamente.");
                }
            } while (preco < 0);

            do {
                System.out.println("Digite a quantidade: ");
                quantidade = scanner.nextInt();
                if (quantidade < 0){
                    System.out.println("Quantidade inválida, digite novamente.");
                } else {
                    total += preco * quantidade;
                }
            } while (quantidade < 0);
            
        } while (quantidade != 0);

        System.out.println("Total a ser pago: " + total);
    }
}