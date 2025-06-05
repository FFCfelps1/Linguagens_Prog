public class Exemplo {
    public static void main(String[] args) {
        String texto = "Java World!";
        // Obtendo a substring do índice 7 ao 11
        String substring1 = texto.substring(7, 11); // O índice final é exclusivo
        System.out.println("Substring: " + substring1);
        String substring2 = texto.substring(7, 10); // O índice final é exclusivo
        System.out.println("Substring: " + substring2);
    }
}