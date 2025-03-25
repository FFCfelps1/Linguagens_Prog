/*
 * Imprimir em tela os 20 primeiros números pares, a partir de 0,
inclusive;
 */

public class ex_1 {
    public static void main(String[] args) {
        int var = 0;
        do {
            if (var%2 == 0){
                System.out.println("valor 1:    " + var);
            }
            var += 1;
        } while (var < 39);
    }
}