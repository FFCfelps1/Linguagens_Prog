import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ValidacaoLogin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== SISTEMA DE VALIDAÇÃO DE LOGIN ===");
        System.out.println();
        
        // Entrada de dados para validação
        System.out.print("Digite o NOME: ");
        String nomeDigitado = scanner.nextLine();
        
        System.out.print("Digite a SENHA: ");
        String senhaDigitada = scanner.nextLine();
        
        boolean loginValido = false;
        
        // Leitura e validação do arquivo
        try {
            BufferedReader reader = new BufferedReader(new FileReader("usuarios.txt"));
            String linha;
            
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                
                if (dados.length >= 2) {
                    String nomeArquivo = dados[0].trim();
                    String senhaArquivo = dados[1].trim();
                    
                    if (nomeArquivo.equals(nomeDigitado) && senhaArquivo.equals(senhaDigitada)) {
                        loginValido = true;
                        break;
                    }
                }
            }
            
            reader.close();
            
            // Resultado da validação
            System.out.println();
            if (loginValido) {
                System.out.println("*** LOGIN REALIZADO COM SUCESSO ***");
            } else {
                System.out.println("*** LOGIN E/OU SENHA ERRADO(S) ***");
            }
            
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            System.out.println("Certifique-se de que o arquivo 'usuarios.txt' existe.");
        }
        
        scanner.close();
    }
}