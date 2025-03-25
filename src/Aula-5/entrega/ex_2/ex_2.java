/*
 * Entrar com vários números positivos e imprimir a média dos números digitados;
 */

public class ex_2 {
    public static void main(String[] args) {
        int var = 0;
        int sum = 0;
        int count = 0;
        do {
            sum += var;
            count += 1;
            var += 1;
        } while (var < 39);
        System.out.println("Média: " + sum/count);
    }
    
}
