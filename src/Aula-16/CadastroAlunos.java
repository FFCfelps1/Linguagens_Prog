import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

public class CadastroAlunos extends JFrame {
    private JTextField txtRA, txtNome, txtSobrenome, txtP1, txtP2, txtP3, txtP4;
    private JButton btnCadastrar, btnLimpar;
    
    public CadastroAlunos() {
        setTitle("Sistema de Cadastro de Alunos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Painel principal
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Título
        JLabel lblTitulo = new JLabel("CADASTRO DE ALUNOS");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelPrincipal.add(lblTitulo);
        painelPrincipal.add(Box.createVerticalStrut(20));
        
        // Campos de entrada
        painelPrincipal.add(criarCampo("RA:", txtRA = new JTextField(15)));
        painelPrincipal.add(criarCampo("Nome:", txtNome = new JTextField(15)));
        painelPrincipal.add(criarCampo("Sobrenome:", txtSobrenome = new JTextField(15)));
        painelPrincipal.add(criarCampo("Nota P1:", txtP1 = new JTextField(15)));
        painelPrincipal.add(criarCampo("Nota P2:", txtP2 = new JTextField(15)));
        painelPrincipal.add(criarCampo("Nota P3:", txtP3 = new JTextField(15)));
        painelPrincipal.add(criarCampo("Nota P4:", txtP4 = new JTextField(15)));
        
        painelPrincipal.add(Box.createVerticalStrut(20));
        
        // Botões
        JPanel panelBotoes = new JPanel(new FlowLayout());
        btnCadastrar = new JButton("Cadastrar");
        btnLimpar = new JButton("Limpar");
        
        panelBotoes.add(btnCadastrar);
        panelBotoes.add(btnLimpar);
        painelPrincipal.add(panelBotoes);
        
        add(painelPrincipal, BorderLayout.CENTER);
        
        // Eventos dos botões
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarAluno();
            }
        });
        
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
        
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    private JPanel criarCampo(String label, JTextField campo) {
        JPanel painel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lbl = new JLabel(label);
        lbl.setPreferredSize(new Dimension(100, 25));
        painel.add(lbl);
        painel.add(campo);
        return painel;
    }
    
    private void cadastrarAluno() {
        try {
            // Verificar se os campos estão preenchidos
            if (txtRA.getText().isEmpty() || txtNome.getText().isEmpty() ||
                txtSobrenome.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
                return;
            }
            
            // Pegar as notas
            double p1 = Double.parseDouble(txtP1.getText());
            double p2 = Double.parseDouble(txtP2.getText());
            double p3 = Double.parseDouble(txtP3.getText());
            double p4 = Double.parseDouble(txtP4.getText());
            
            // Salvar no arquivo
            FileWriter writer = new FileWriter("alunos.txt", true);
            String linha = txtRA.getText() + ";" + 
                          txtNome.getText() + ";" + 
                          txtSobrenome.getText() + ";" + 
                          p1 + ";" + p2 + ";" + p3 + ";" + p4 + "\n";
            writer.write(linha);
            writer.close();
            
            JOptionPane.showMessageDialog(this, "Aluno cadastrado!");
            limparCampos();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }
    
    private void limparCampos() {
        txtRA.setText("");
        txtNome.setText("");
        txtSobrenome.setText("");
        txtP1.setText("");
        txtP2.setText("");
        txtP3.setText("");
        txtP4.setText("");
    }
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CadastroAlunos().setVisible(true);
            }
        });
    }
}