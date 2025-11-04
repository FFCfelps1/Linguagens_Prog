import java.io.*;
import java.net.*;
import java.util.*;

public class ServidorBatepapo {
    private static final int PORTA = 12345;
    private static Set<PrintWriter> escritoresClientes = new HashSet<>();
    
    public static void main(String[] args) {
        System.out.println("Servidor de Bate-Papo Iniciado...");
        ServerSocket servidorSocket = null;
        
        try {
            servidorSocket = new ServerSocket(PORTA);
            System.out.println("Aguardando conexões na porta " + PORTA);
            
            while (true) {
                Socket clienteSocket = servidorSocket.accept();
                System.out.println("Novo cliente conectado: " + clienteSocket.getInetAddress());
                
                // Cria uma nova thread para cada cliente
                Thread threadCliente = new Thread(new ManipuladorCliente(clienteSocket));
                threadCliente.start();
            }
        } catch (IOException e) {
            System.err.println("Erro no servidor: " + e.getMessage());
        } finally {
            try {
                if (servidorSocket != null) {
                    servidorSocket.close();
                }
            } catch (IOException e) {
                System.err.println("Erro ao fechar servidor: " + e.getMessage());
            }
        }
    }
    
    // Classe interna para manipular cada cliente
    private static class ManipuladorCliente implements Runnable {
        private Socket socket;
        private BufferedReader entrada;
        private PrintWriter saida;
        
        public ManipuladorCliente(Socket socket) {
            this.socket = socket;
        }
        
        @Override
        public void run() {
            try {
                entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                saida = new PrintWriter(socket.getOutputStream(), true);
                
                // Adiciona o escritor deste cliente ao conjunto
                synchronized (escritoresClientes) {
                    escritoresClientes.add(saida);
                }
                
                saida.println("Bem-vindo ao Chat! Digite suas mensagens (digite 'sair' para desconectar)");
                
                // Notifica todos sobre novo cliente
                transmitirMensagem("*** Novo cliente entrou no chat ***");
                
                String mensagem;
                while ((mensagem = entrada.readLine()) != null) {
                    if (mensagem.equalsIgnoreCase("sair")) {
                        break;
                    }
                    
                    System.out.println("Mensagem recebida: " + mensagem);
                    
                    // Transmite a mensagem para todos os clientes
                    transmitirMensagem(socket.getInetAddress().getHostAddress() + ": " + mensagem);
                }
            } catch (IOException e) {
                System.err.println("Erro no manipulador de cliente: " + e.getMessage());
            } finally {
                try {
                    // Remove o escritor do cliente
                    synchronized (escritoresClientes) {
                        escritoresClientes.remove(saida);
                    }
                    
                    transmitirMensagem("*** Um cliente saiu do chat ***");
                    
                    socket.close();
                    System.out.println("Cliente desconectado: " + socket.getInetAddress());
                } catch (IOException e) {
                    System.err.println("Erro ao fechar socket: " + e.getMessage());
                }
            }
        }
        
        // Método para transmitir mensagem para todos os clientes
        private void transmitirMensagem(String mensagem) {
            synchronized (escritoresClientes) {
                for (PrintWriter escritor : escritoresClientes) {
                    escritor.println(mensagem);
                }
            }
        }
    }
}