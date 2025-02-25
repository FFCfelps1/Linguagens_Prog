import java.util.Scanner;

public class ex_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variáveis para armazenar os dígitos
        char milhar, centena, dezena, unidade;

        // Solicita e lê os dígitos um por um
        System.out.print("Digite o dígito da milhar (um único número): ");
        milhar = scanner.next().charAt(0);

        System.out.print("Digite o dígito da centena (um único número): ");
        centena = scanner.next().charAt(0);

        System.out.print("Digite o dígito da dezena (um único número): ");
        dezena = scanner.next().charAt(0);

        System.out.print("Digite o dígito da unidade (um único número): ");
        unidade = scanner.next().charAt(0);

        // Concatena os dígitos em uma String
        String numeroFinal = "" + milhar + centena + dezena + unidade;

        // Exibe o resultado
        System.out.println("O número final é: " + numeroFinal);

        // Fecha o scanner
        scanner.close();
    }
}