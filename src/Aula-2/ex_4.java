import java.util.Scanner;  // Importa a classe Scanner

public class ex_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria o objeto Scanner para ler a entrada do usuário

        // Declaração de variáveis
        int dia;
        int mes;
        int ano;

        // Entrada de dados do usuário
        System.out.println("Digite o dia de seu desejo: ");
        dia = scanner.nextInt();

        System.out.println("Digite o mes de seu desejo: ");
        mes = scanner.nextInt();

        System.out.println("Digite o ano de seu desejo: ");
        ano = scanner.nextInt();

        //Verifica se o mes e o dia é real
        if (dia > 31 || mes > 12){
            System.out.println("Dia ou Mes digitado invalido.");
            System.exit(0);
        }

        // Mostra as strings digitadas com espaços entre elas
        System.out.println("A data digitada: " + dia + "/" + mes + "/" + ano);

        // Fecha o scanner (opcional, mas recomendado)
        scanner.close();
    }
}