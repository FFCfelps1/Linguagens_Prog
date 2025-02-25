import java.util.Scanner;

public class ex_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria o objeto Scanner para ler a entrada do usuário

        // Declaração de variáveis
        String entrada;

        // Criando uma lista de Character
        char [] arrayDeChars = new char[11];
        
        // Entrada de dados do usuário (com validação)
        for (int i = 0; i <= 10; i++) {
            System.out.println("Digite o char de sua escolha "+ i + ": ");
            entrada = scanner.nextLine();
    
            // Extrai o primeiro caractere da string
            char caractere = entrada.charAt(0);
            arrayDeChars[i] = caractere;
        }

        // Mostra os dados digitados
        System.out.println("A palavra formada apresentada: ");
        for (int i = 0; i <= 10; i++) {
            System.out.print(arrayDeChars[i]);
        }

        // Fecha o scanner (opcional, mas recomendado)
        scanner.close();
    }
}