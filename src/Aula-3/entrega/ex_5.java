import java.io.*;

public class ex_5 {
    public static void main(String[] args) {
        String[] palavras = new String[10];
        int count = 0;
        
        try {
            // Abrindo o arquivo para leitura
            BufferedReader reader = new BufferedReader(new FileReader("palavras.txt"));
            String linha;
            
            // Lendo as palavras do arquivo
            while ((linha = reader.readLine()) != null && count < 10) {
                palavras[count] = linha;
                count++;
            }
            
            // Fechando o arquivo
            reader.close();
            
            // Exibindo as palavras no console em ordem inversa
            System.out.println("Palavras em ordem inversa:");
            for (int i = count - 1; i >= 0; i--) {
                System.out.println(palavras[i]);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}