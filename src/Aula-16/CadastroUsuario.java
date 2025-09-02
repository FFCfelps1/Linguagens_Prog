import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CadastroUsuario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== SISTEMA DE CADASTRO DE USUÁRIO ===");
        System.out.println();
        
        // Entrada de dados do usuário
        System.out.print("Digite o NOME do usuário: ");
        String nome = scanner.nextLine();
        
        System.out.print("Digite a SENHA do usuário: ");
        String senha = scanner.nextLine();
        
        // Gravação no arquivo de texto
        try {
            FileWriter writer = new FileWriter("usuarios.txt", true); // true para append
            writer.write(nome + ";" + senha + "\n");
            writer.close();
            
            System.out.println("\n*** USUÁRIO CADASTRADO COM SUCESSO! ***");
            System.out.println("Nome: " + nome);
            System.out.println("Dados gravados no arquivo 'usuarios.txt'");
            
        } catch (IOException e) {
            System.err.println("Erro ao gravar no arquivo: " + e.getMessage());
        }
        
        scanner.close();
    }
}