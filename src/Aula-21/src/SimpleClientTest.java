import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class SimpleClientTest extends JFrame {
    // Componentes da interface
    private JTextField txtMensagem;
    private JTextArea txtAreaRespostas;
    private JTextArea txtAreaStatus;
    private JButton btnEnviar;
    private JButton btnLimpar;
    private JButton btnSair;
    
    // Componentes de rede
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private boolean conectado = false;
    
    public SimpleClientTest() {
        // Configurações da janela
        setTitle("Cliente TCP - Comunicação com Servidor");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Inicializa a interface gráfica
        inicializarComponentes();
        
        // Conecta ao servidor
        conectarAoServidor();
        
        // Adiciona listener para fechar conexão ao fechar janela
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                encerrarConexao();
            }
        });
    }
    
    private void inicializarComponentes() {
        // Painel principal com BorderLayout
        setLayout(new BorderLayout(10, 10));
        
        // ===== PAINEL SUPERIOR - TÍTULO =====
        JPanel painelTitulo = new JPanel();
        painelTitulo.setBackground(new Color(51, 102, 153));
        painelTitulo.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        JLabel lblTitulo = new JLabel("Sistema de Comunicacao Cliente-Servidor");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setForeground(Color.WHITE);
        painelTitulo.add(lblTitulo);
        add(painelTitulo, BorderLayout.NORTH);
        
        // ===== PAINEL CENTRAL - ÁREAS DE TEXTO =====
        JPanel painelCentral = new JPanel(new GridLayout(2, 1, 10, 10));
        painelCentral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Painel de Respostas do Servidor
        JPanel painelRespostas = new JPanel(new BorderLayout(5, 5));
        painelRespostas.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(51, 102, 153), 2),
            "Respostas do Servidor",
            0, 0, new Font("Arial", Font.BOLD, 12), new Color(51, 102, 153)));
        
        txtAreaRespostas = new JTextArea();
        txtAreaRespostas.setEditable(false);
        txtAreaRespostas.setFont(new Font("Monospaced", Font.PLAIN, 12));
        txtAreaRespostas.setLineWrap(true);
        txtAreaRespostas.setWrapStyleWord(true);
        JScrollPane scrollRespostas = new JScrollPane(txtAreaRespostas);
        painelRespostas.add(scrollRespostas, BorderLayout.CENTER);
        
        // Painel de Status da Comunicacao
        JPanel painelStatus = new JPanel(new BorderLayout(5, 5));
        painelStatus.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(0, 153, 76), 2),
            "Status da Comunicacao",
            0, 0, new Font("Arial", Font.BOLD, 12), new Color(0, 153, 76)));
        
        txtAreaStatus = new JTextArea();
        txtAreaStatus.setEditable(false);
        txtAreaStatus.setFont(new Font("Monospaced", Font.PLAIN, 11));
        txtAreaStatus.setLineWrap(true);
        txtAreaStatus.setWrapStyleWord(true);
        txtAreaStatus.setBackground(new Color(240, 255, 240));
        JScrollPane scrollStatus = new JScrollPane(txtAreaStatus);
        painelStatus.add(scrollStatus, BorderLayout.CENTER);
        
        painelCentral.add(painelRespostas);
        painelCentral.add(painelStatus);
        add(painelCentral, BorderLayout.CENTER);
        
        // ===== PAINEL INFERIOR - ENTRADA E BOTÕES =====
        JPanel painelInferior = new JPanel(new BorderLayout(10, 10));
        painelInferior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Painel de Entrada de Mensagem
        JPanel painelEntrada = new JPanel(new BorderLayout(5, 5));
        JLabel lblMensagem = new JLabel("Mensagem:");
        lblMensagem.setFont(new Font("Arial", Font.BOLD, 12));
        txtMensagem = new JTextField();
        txtMensagem.setFont(new Font("Arial", Font.PLAIN, 12));
        txtMensagem.setPreferredSize(new Dimension(0, 30));
        
        // Permite enviar com Enter
        txtMensagem.addActionListener(e -> enviarMensagem());
        
        painelEntrada.add(lblMensagem, BorderLayout.WEST);
        painelEntrada.add(txtMensagem, BorderLayout.CENTER);
        
        // Painel de Botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        
        btnEnviar = new JButton("Enviar");
        btnEnviar.setFont(new Font("Arial", Font.BOLD, 12));
        btnEnviar.setBackground(new Color(51, 153, 102));
        btnEnviar.setForeground(Color.WHITE);
        btnEnviar.setFocusPainted(false);
        btnEnviar.setOpaque(true);
        btnEnviar.setBorderPainted(false);
        btnEnviar.setPreferredSize(new Dimension(100, 35));
        btnEnviar.addActionListener(e -> enviarMensagem());
        
        btnLimpar = new JButton("Limpar");
        btnLimpar.setFont(new Font("Arial", Font.BOLD, 12));
        btnLimpar.setBackground(new Color(255, 153, 51));
        btnLimpar.setForeground(Color.WHITE);
        btnLimpar.setFocusPainted(false);
        btnLimpar.setOpaque(true);
        btnLimpar.setBorderPainted(false);
        btnLimpar.setPreferredSize(new Dimension(100, 35));
        btnLimpar.addActionListener(e -> limparCampos());
        
        btnSair = new JButton("Sair");
        btnSair.setFont(new Font("Arial", Font.BOLD, 12));
        btnSair.setBackground(new Color(204, 51, 51));
        btnSair.setForeground(Color.WHITE);
        btnSair.setFocusPainted(false);
        btnSair.setOpaque(true);
        btnSair.setBorderPainted(false);
        btnSair.setPreferredSize(new Dimension(100, 35));
        btnSair.addActionListener(e -> sair());
        
        painelBotoes.add(btnEnviar);
        painelBotoes.add(btnLimpar);
        painelBotoes.add(btnSair);
        
        painelInferior.add(painelEntrada, BorderLayout.CENTER);
        painelInferior.add(painelBotoes, BorderLayout.SOUTH);
        add(painelInferior, BorderLayout.SOUTH);
    }
    
    private void conectarAoServidor() {
        try {
            adicionarStatus("Tentando conectar ao servidor em localhost:12345...");
            socket = new Socket("localhost", 12345);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            conectado = true;
            adicionarStatus("OK Conectado ao servidor com sucesso!");
            adicionarStatus("Endereco: " + socket.getInetAddress().getHostAddress());
            adicionarStatus("Porta local: " + socket.getLocalPort());
            adicionarStatus("-----------------------------------");
        } catch (UnknownHostException e) {
            adicionarStatus("ERRO: Servidor nao encontrado - " + e.getMessage());
            desabilitarEnvio();
        } catch (IOException e) {
            adicionarStatus("ERRO: Nao foi possivel conectar ao servidor");
            adicionarStatus("  Verifique se o servidor esta em execucao!");
            desabilitarEnvio();
        }
    }
    
    private void enviarMensagem() {
        if (!conectado) {
            adicionarStatus("ERRO: Nao conectado ao servidor!");
            return;
        }
        
        String mensagem = txtMensagem.getText().trim();
        
        if (mensagem.isEmpty()) {
            adicionarStatus("ERRO: Mensagem vazia nao pode ser enviada!");
            return;
        }
        
        try {
            // Envia mensagem ao servidor
            adicionarStatus(">> Enviando: \"" + mensagem + "\"");
            out.println(mensagem);
            
            // Aguarda resposta do servidor em uma thread separada
            new Thread(() -> {
                try {
                    String resposta = in.readLine();
                    if (resposta != null) {
                        SwingUtilities.invokeLater(() -> {
                            adicionarResposta(resposta);
                            adicionarStatus("<< Resposta recebida");
                        });
                    }
                } catch (IOException e) {
                    SwingUtilities.invokeLater(() -> {
                        adicionarStatus("ERRO ao receber resposta: " + e.getMessage());
                    });
                }
            }).start();
            
            // Limpa o campo de entrada
            txtMensagem.setText("");
            txtMensagem.requestFocus();
            
            // Se enviou "sair", prepara para encerrar
            if (mensagem.equalsIgnoreCase("sair")) {
                adicionarStatus("Encerrando conexão...");
                Timer timer = new Timer(1000, e -> encerrarConexao());
                timer.setRepeats(false);
                timer.start();
            }
            
        } catch (Exception e) {
            adicionarStatus("ERRO ao enviar mensagem: " + e.getMessage());
        }
    }
    
    private void limparCampos() {
        txtMensagem.setText("");
        txtAreaRespostas.setText("");
        txtAreaStatus.setText("");
        adicionarStatus("Campos limpos");
        adicionarStatus("-----------------------------------");
        txtMensagem.requestFocus();
    }
    
    private void sair() {
        int opcao = JOptionPane.showConfirmDialog(
            this,
            "Deseja realmente sair e encerrar a conexão?",
            "Confirmar Saída",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        
        if (opcao == JOptionPane.YES_OPTION) {
            if (conectado) {
                // Envia mensagem "sair" ao servidor
                out.println("sair");
                adicionarStatus("Comando 'sair' enviado ao servidor");
            }
            encerrarConexao();
            System.exit(0);
        }
    }
    
    private void encerrarConexao() {
        try {
            if (out != null) out.close();
            if (in != null) in.close();
            if (socket != null) socket.close();
            conectado = false;
            adicionarStatus("OK Conexao encerrada");
        } catch (IOException e) {
            adicionarStatus("ERRO ao fechar recursos: " + e.getMessage());
        }
    }
    
    private void desabilitarEnvio() {
        btnEnviar.setEnabled(false);
        txtMensagem.setEnabled(false);
        txtMensagem.setText("Servidor nao disponivel");
    }
    
    private void adicionarResposta(String resposta) {
        String timestamp = new SimpleDateFormat("HH:mm:ss").format(new Date());
        txtAreaRespostas.append("[" + timestamp + "] " + resposta + "\n");
        // Auto-scroll para a ultima mensagem
        txtAreaRespostas.setCaretPosition(txtAreaRespostas.getDocument().getLength());
    }
    
    private void adicionarStatus(String status) {
        String timestamp = new SimpleDateFormat("HH:mm:ss").format(new Date());
        txtAreaStatus.append("[" + timestamp + "] " + status + "\n");
        // Auto-scroll para a ultima mensagem
        txtAreaStatus.setCaretPosition(txtAreaStatus.getDocument().getLength());
    }
    
    public static void main(String[] args) {
        // Usa o Look and Feel do sistema operacional
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Cria e exibe a interface na thread de eventos do Swing
        SwingUtilities.invokeLater(() -> {
            SimpleClientTest cliente = new SimpleClientTest();
            cliente.setVisible(true);
        });
    }
}