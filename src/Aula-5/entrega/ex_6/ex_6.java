/*
 * Imprimir na tela todos os números múltiplos de 5, no
intervalo de 1 a 500;
 */

 public class ex_6 {
    public static void main(String[] args) {
        int var = 1;
        do {
            if (var%5 == 0){
                System.out.println("valor 1:    " + var);
            }
            var += 1;
        } while (var < 501);
    }
}