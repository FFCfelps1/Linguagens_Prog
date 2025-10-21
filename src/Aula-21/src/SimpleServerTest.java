import java.io.*;
import java.net.*;

public class SimpleServerTest {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        
        try {
            // Cria o ServerSocket na porta 12345
            serverSocket = new ServerSocket(12345);
            System.out.println("Servidor aguardando conexão na porta 12345...");
            
            // Aguarda a conexão do cliente
            clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado: " + clientSocket.getInetAddress().getHostAddress());
            
            // Configura os streams de entrada e saída
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            
            String mensagemRecebida;
            
            // Loop para receber mensagens do cliente
            while ((mensagemRecebida = in.readLine()) != null) {
                System.out.println("Mensagem recebida do cliente: " + mensagemRecebida);
                
                // Envia resposta ao cliente
                String resposta = "Servidor recebeu: " + mensagemRecebida;
                out.println(resposta);
                System.out.println("Resposta enviada ao cliente: " + resposta);
                
                // Se receber "sair", encerra a conexão
                if (mensagemRecebida.equalsIgnoreCase("sair")) {
                    System.out.println("Cliente solicitou encerramento.");
                    break;
                }
            }
            
        } catch (IOException e) {
            System.err.println("Erro no servidor: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Fecha os recursos
            try {
                if (out != null) out.close();
                if (in != null) in.close();
                if (clientSocket != null) clientSocket.close();
                if (serverSocket != null) serverSocket.close();
                System.out.println("Servidor encerrado.");
            } catch (IOException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }
}