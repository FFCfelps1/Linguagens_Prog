import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SimpleServer2Test {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Cria o ServerSocket na porta 12345
            serverSocket = new ServerSocket(12345);
            exibirCabecalho();
            System.out.println("[SERVIDOR] Aguardando conexao na porta 12345...");
            System.out.println("=" .repeat(70));
            
            // Aguarda a conexao do cliente
            clientSocket = serverSocket.accept();
            System.out.println("\n[CONEXAO] Cliente conectado!");
            System.out.println("[INFO] Endereco IP: " + clientSocket.getInetAddress().getHostAddress());
            System.out.println("[INFO] Porta remota: " + clientSocket.getPort());
            System.out.println("=" .repeat(70));
            System.out.println("[SERVIDOR] Aguardando mensagens do cliente...\n");
            
            // Configura os streams de entrada e saida
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            
            String mensagemRecebida;
            int contadorMensagens = 0;
            
            // Loop para receber mensagens do cliente
            while ((mensagemRecebida = in.readLine()) != null) {
                contadorMensagens++;
                
                System.out.println("\n" + "=" .repeat(70));
                System.out.println("[MENSAGEM #" + contadorMensagens + " RECEBIDA]");
                System.out.println("=" .repeat(70));
                System.out.println("Cliente enviou: " + mensagemRecebida);
                System.out.println("-" .repeat(70));
                
                // Se receber "sair", encerra a conexao
                if (mensagemRecebida.equalsIgnoreCase("sair")) {
                    System.out.println("\n[AVISO] Cliente solicitou encerramento da conexao.");
                    System.out.println("[ACAO] Enviando confirmacao de encerramento...");
                    out.println("Servidor recebeu: sair - Conexao sera encerrada.");
                    System.out.println("[OK] Confirmacao enviada. Encerrando servidor...");
                    break;
                }
                
                // Monta a resposta padrao
                String respostaPadrao = "Servidor recebeu: " + mensagemRecebida;
                System.out.println("\nResposta padrao gerada:");
                System.out.println(">>> " + respostaPadrao);
                System.out.println("-" .repeat(70));
                
                // Solicita confirmacao ou edicao
                System.out.println("\nOpcoes:");
                System.out.println("  [1] Confirmar e enviar a resposta padrao");
                System.out.println("  [2] Editar a resposta antes de enviar");
                System.out.println("  [3] Enviar resposta personalizada");
                System.out.print("\nEscolha uma opcao (1/2/3): ");
                
                String opcao = scanner.nextLine().trim();
                String respostaFinal;
                
                switch (opcao) {
                    case "1":
                        // Confirma a resposta padrao
                        respostaFinal = respostaPadrao;
                        System.out.println("\n[OK] Resposta padrao confirmada.");
                        break;
                        
                    case "2":
                        // Edita a resposta padrao
                        System.out.print("\nEdite a resposta (atual: \"" + respostaPadrao + "\"): ");
                        String edicao = scanner.nextLine().trim();
                        if (edicao.isEmpty()) {
                            respostaFinal = respostaPadrao;
                            System.out.println("[AVISO] Edicao vazia. Usando resposta padrao.");
                        } else {
                            respostaFinal = edicao;
                            System.out.println("[OK] Resposta editada com sucesso.");
                        }
                        break;
                        
                    case "3":
                        // Cria resposta completamente personalizada
                        System.out.print("\nDigite a resposta personalizada: ");
                        String personalizada = scanner.nextLine().trim();
                        if (personalizada.isEmpty()) {
                            respostaFinal = respostaPadrao;
                            System.out.println("[AVISO] Resposta vazia. Usando resposta padrao.");
                        } else {
                            respostaFinal = personalizada;
                            System.out.println("[OK] Resposta personalizada criada.");
                        }
                        break;
                        
                    default:
                        // Opcao invalida, usa resposta padrao
                        respostaFinal = respostaPadrao;
                        System.out.println("\n[AVISO] Opcao invalida. Usando resposta padrao.");
                        break;
                }
                
                // Envia a resposta final ao cliente
                System.out.println("\n[ENVIANDO] Resposta ao cliente:");
                System.out.println(">>> " + respostaFinal);
                out.println(respostaFinal);
                System.out.println("[OK] Resposta enviada com sucesso!");
                System.out.println("=" .repeat(70));
                
                // Aguarda proxima mensagem
                System.out.println("\n[SERVIDOR] Aguardando proxima mensagem...\n");
            }
            
        } catch (IOException e) {
            System.err.println("\n[ERRO] Erro no servidor: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Fecha os recursos
            try {
                if (scanner != null) scanner.close();
                if (out != null) out.close();
                if (in != null) in.close();
                if (clientSocket != null) clientSocket.close();
                if (serverSocket != null) serverSocket.close();
                
                System.out.println("\n" + "=" .repeat(70));
                System.out.println("[ENCERRADO] Servidor encerrado com sucesso.");
                System.out.println("[INFO] Todos os recursos foram liberados.");
                System.out.println("=" .repeat(70));
            } catch (IOException e) {
                System.err.println("[ERRO] Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }
    
    /**
     * Exibe o cabecalho do servidor no console
     */
    private static void exibirCabecalho() {
        System.out.println("\n" + "=" .repeat(70));
        System.out.println("        SERVIDOR TCP INTERATIVO - SimpleServer2Test");
        System.out.println("=" .repeat(70));
        System.out.println("[VERSAO] 2.0 - Com interface de console interativa");
        System.out.println("[PORTA] 12345");
        System.out.println("[FUNCAO] Recebe mensagens e permite edicao antes de responder");
        System.out.println("=" .repeat(70) + "\n");
    }
}
