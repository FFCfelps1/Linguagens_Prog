public class ex_4 {
    public static void main(String[] args) {
        int var = 20;
        int var2 = 1;
        do {
            System.out.println("valor 1:    " + var + "  valor 2:    " + var2);
            var -= 1;
            var2 += 1;
        } while (var > 0);
    }
}