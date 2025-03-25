/*
 * Imprimir na tela todos os números de 1 a 100 e a soma deles;
 */

 public class ex_8 {
    public static void main(String[] args) {
        int var = 1;
        int soma = 0;
        do {
                soma += var;
                System.out.println("valor 1:    " + var);
            var += 1;
            
        } while (var < 101);
        System.out.println("Resultado: " + soma);
    }
}