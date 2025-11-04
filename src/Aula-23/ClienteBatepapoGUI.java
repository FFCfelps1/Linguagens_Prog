import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ClienteBatepapoGUI extends JFrame {
    private static final String ENDERECO_SERVIDOR = "localhost";
    private static final int PORTA = 12345;
    
    // Componentes da interface
    private JTextArea areaChat;
    private JTextField campoMensagem;
    private JButton btnEnviar;
    private JButton btnLimpar;
    private JButton btnSair;
    private JLabel lblStatus;
    
    // Cliente socket
    private SocketCliente cliente;
    private Thread threadReceber;
    
    public ClienteBatepapoGUI() {
        configurarInterface();
        conectarServidor();
    }
    
    private void configurarInterface() {
        setTitle("Chat Cliente");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        
        // Painel superior com status
        JPanel painelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lblStatus = new JLabel("Status: Desconectado");
        lblStatus.setForeground(Color.RED);
        painelSuperior.add(lblStatus);
        add(painelSuperior, BorderLayout.NORTH);
        
        // Área de chat (centro)
        areaChat = new JTextArea();
        areaChat.setEditable(false);
        areaChat.setFont(new Font("Monospaced", Font.PLAIN, 12));
        areaChat.setLineWrap(true);
        areaChat.setWrapStyleWord(true);
        JScrollPane scrollChat = new JScrollPane(areaChat);
        scrollChat.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollChat, BorderLayout.CENTER);
        
        // Painel inferior com entrada e botões
        JPanel painelInferior = new JPanel(new BorderLayout(5, 5));
        
        // Campo de mensagem
        campoMensagem = new JTextField();
        campoMensagem.setFont(new Font("Arial", Font.PLAIN, 14));
        campoMensagem.addActionListener(e -> enviarMensagem());
        painelInferior.add(campoMensagem, BorderLayout.CENTER);
        
        // Painel de botões
        JPanel painelBotoes = new JPanel(new GridLayout(1, 3, 5, 5));
        
        btnEnviar = new JButton("Enviar");
        btnEnviar.setBackground(new Color(46, 204, 113));
        btnEnviar.setForeground(Color.WHITE);
        btnEnviar.setFocusPainted(false);
        btnEnviar.addActionListener(e -> enviarMensagem());
        
        btnLimpar = new JButton("Limpar");
        btnLimpar.setBackground(new Color(52, 152, 219));
        btnLimpar.setForeground(Color.WHITE);
        btnLimpar.setFocusPainted(false);
        btnLimpar.addActionListener(e -> limparChat());
        
        btnSair = new JButton("Sair");
        btnSair.setBackground(new Color(231, 76, 60));
        btnSair.setForeground(Color.WHITE);
        btnSair.setFocusPainted(false);
        btnSair.addActionListener(e -> sairChat());
        
        painelBotoes.add(btnEnviar);
        painelBotoes.add(btnLimpar);
        painelBotoes.add(btnSair);
        
        painelInferior.add(painelBotoes, BorderLayout.EAST);
        
        // Adiciona padding ao painel inferior
        JPanel painelInferiorComPadding = new JPanel(new BorderLayout());
        painelInferiorComPadding.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        painelInferiorComPadding.add(painelInferior);
        
        add(painelInferiorComPadding, BorderLayout.SOUTH);
        
        // Adiciona padding geral
        ((JPanel)getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        setLocationRelativeTo(null);
    }
    
    private void conectarServidor() {
        try {
            cliente = new SocketCliente(ENDERECO_SERVIDOR, PORTA);
            atualizarStatus("Conectado", Color.GREEN);
            adicionarMensagemChat("=== Conectado ao servidor de bate-papo! ===\n");
            
            // Inicia thread para receber mensagens
            threadReceber = new Thread(() -> {
                try {
                    String mensagem;
                    while (cliente.estaConectado() && (mensagem = cliente.receberMensagem()) != null) {
                        final String msg = mensagem;
                        SwingUtilities.invokeLater(() -> adicionarMensagemChat(msg + "\n"));
                    }
                } catch (IOException e) {
                    if (cliente.estaConectado()) {
                        SwingUtilities.invokeLater(() -> {
                            adicionarMensagemChat("=== Erro na conexão: " + e.getMessage() + " ===\n");
                            atualizarStatus("Desconectado", Color.RED);
                        });
                    }
                }
            });
            threadReceber.start();
            
        } catch (IOException e) {
            atualizarStatus("Erro de Conexão", Color.RED);
            adicionarMensagemChat("=== Erro ao conectar ao servidor ===\n");
            adicionarMensagemChat("=== Certifique-se de que o servidor está rodando ===\n");
            JOptionPane.showMessageDialog(this,
                "Não foi possível conectar ao servidor.\n" +
                "Certifique-se de que o servidor está em execução.",
                "Erro de Conexão",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void enviarMensagem() {
        String mensagem = campoMensagem.getText().trim();
        
        if (mensagem.isEmpty()) {
            return;
        }
        
        if (!cliente.estaConectado()) {
            JOptionPane.showMessageDialog(this,
                "Não conectado ao servidor!",
                "Erro",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            cliente.enviarMensagem(mensagem);
            campoMensagem.setText("");
            campoMensagem.requestFocus();
            
            if (mensagem.equalsIgnoreCase("sair")) {
                sairChat();
            }
        } catch (Exception e) {
            adicionarMensagemChat("=== Erro ao enviar mensagem ===\n");
            JOptionPane.showMessageDialog(this,
                "Erro ao enviar mensagem: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void limparChat() {
        int resposta = JOptionPane.showConfirmDialog(this,
            "Deseja realmente limpar todo o histórico do chat?",
            "Confirmar Limpeza",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        
        if (resposta == JOptionPane.YES_OPTION) {
            areaChat.setText("");
            adicionarMensagemChat("=== Chat limpo ===\n");
        }
    }
    
    private void sairChat() {
        int resposta = JOptionPane.showConfirmDialog(this,
            "Deseja realmente sair do chat?",
            "Confirmar Saída",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        
        if (resposta == JOptionPane.YES_OPTION) {
            try {
                if (cliente != null && cliente.estaConectado()) {
                    cliente.enviarMensagem("sair");
                    cliente.fecharConexao();
                }
            } catch (IOException e) {
                System.err.println("Erro ao fechar conexão: " + e.getMessage());
            } finally {
                System.exit(0);
            }
        }
    }
    
    private void adicionarMensagemChat(String mensagem) {
        areaChat.append(mensagem);
        areaChat.setCaretPosition(areaChat.getDocument().getLength());
    }
    
    private void atualizarStatus(String status, Color cor) {
        lblStatus.setText("Status: " + status);
        lblStatus.setForeground(cor);
    }
    
    public static void main(String[] args) {
        // Define look and feel do sistema
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Cria e exibe a interface
        SwingUtilities.invokeLater(() -> {
            ClienteBatepapoGUI cliente = new ClienteBatepapoGUI();
            cliente.setVisible(true);
        });
    }
}   