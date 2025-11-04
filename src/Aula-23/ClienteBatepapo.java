import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteBatepapo {
    private static final String ENDERECO_SERVIDOR = "localhost";
    private static final int PORTA = 12345;
    
    public static void main(String[] args) {
        try {
            SocketCliente cliente = new SocketCliente(ENDERECO_SERVIDOR, PORTA);
            System.out.println("Conectado ao servidor de bate-papo!");
            
            // Thread para receber mensagens do servidor
            Thread threadReceber = new Thread(new RecebedorMensagens(cliente));
            threadReceber.start();
            
            // Thread para enviar mensagens ao servidor
            Thread threadEnviar = new Thread(new EnviadorMensagens(cliente));
            threadEnviar.start();
            
        } catch (IOException e) {
            System.err.println("Erro ao conectar ao servidor: " + e.getMessage());
            System.err.println("Certifique-se de que o servidor está em execução.");
        }
    }
    
    // Classe interna para receber mensagens do servidor
    private static class RecebedorMensagens implements Runnable {
        private SocketCliente cliente;
        
        public RecebedorMensagens(SocketCliente cliente) {
            this.cliente = cliente;
        }
        
        @Override
        public void run() {
            try {
                String mensagem;
                while (cliente.estaConectado() && (mensagem = cliente.receberMensagem()) != null) {
                    System.out.println(mensagem);
                }
            } catch (IOException e) {
                if (cliente.estaConectado()) {
                    System.err.println("Erro ao receber mensagem: " + e.getMessage());
                }
            }
        }
    }
    
    // Classe interna para enviar mensagens ao servidor
    private static class EnviadorMensagens implements Runnable {
        private SocketCliente cliente;
        
        public EnviadorMensagens(SocketCliente cliente) {
            this.cliente = cliente;
        }
        
        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            
            try {
                while (cliente.estaConectado()) {
                    String mensagem = scanner.nextLine();
                    cliente.enviarMensagem(mensagem);
                    
                    if (mensagem.equalsIgnoreCase("sair")) {
                        System.out.println("Desconectando do chat...");
                        cliente.fecharConexao();
                        System.exit(0);
                        break;
                    }
                }
            } catch (IOException e) {
                System.err.println("Erro ao enviar mensagem: " + e.getMessage());
            } finally {
                scanner.close();
            }
        }
    }
}