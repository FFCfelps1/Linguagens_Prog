import java.io.*;
import java.net.*;

public class SocketCliente {
    private Socket socket;
    private BufferedReader entrada;
    private PrintWriter saida;
    
    public SocketCliente(String endereco, int porta) throws IOException {
        socket = new Socket(endereco, porta);
        entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        saida = new PrintWriter(socket.getOutputStream(), true);
    }
    
    public void enviarMensagem(String mensagem) {
        saida.println(mensagem);
    }
    
    public String receberMensagem() throws IOException {
        return entrada.readLine();
    }
    
    public void fecharConexao() throws IOException {
        entrada.close();
        saida.close();
        socket.close();
    }
    
    public boolean estaConectado() {
        return socket != null && !socket.isClosed();
    }
}