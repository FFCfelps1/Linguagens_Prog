import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class CadastroAlunos extends JFrame {
    private JTextField txtRA, txtNome, txtSobrenome, txtP1, txtP2, txtP3, txtP4;
    private JButton btnCadastrar, btnLimpar;
    
    public CadastroAlunos() {
        setTitle("Sistema de Cadastro de Alunos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Configuração do layout
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Título
        JLabel lblTitulo = new JLabel("CADASTRO DE ALUNOS");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(lblTitulo, gbc);
        
        // Reset gridwidth e anchor
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        
        // Campos de entrada
        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("RA:"), gbc);
        gbc.gridx = 1;
        txtRA = new JTextField(15);
        add(txtRA, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Nome:"), gbc);
        gbc.gridx = 1;
        txtNome = new JTextField(15);
        add(txtNome, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        add(new JLabel("Sobrenome:"), gbc);
        gbc.gridx = 1;
        txtSobrenome = new JTextField(15);
        add(txtSobrenome, gbc);
        
        gbc.gridx = 0; gbc.gridy = 4;
        add(new JLabel("Nota P1:"), gbc);
        gbc.gridx = 1;
        txtP1 = new JTextField(15);
        add(txtP1, gbc);
        
        gbc.gridx = 0; gbc.gridy = 5;
        add(new JLabel("Nota P2:"), gbc);
        gbc.gridx = 1;
        txtP2 = new JTextField(15);
        add(txtP2, gbc);
        
        gbc.gridx = 0; gbc.gridy = 6;
        add(new JLabel("Nota P3:"), gbc);
        gbc.gridx = 1;
        txtP3 = new JTextField(15);
        add(txtP3, gbc);
        
        gbc.gridx = 0; gbc.gridy = 7;
        add(new JLabel("Nota P4:"), gbc);
        gbc.gridx = 1;
        txtP4 = new JTextField(15);
        add(txtP4, gbc);
        
        // Botões
        JPanel panelBotoes = new JPanel();
        btnCadastrar = new JButton("Cadastrar");
        btnLimpar = new JButton("Limpar");
        
        panelBotoes.add(btnCadastrar);
        panelBotoes.add(btnLimpar);
        
        gbc.gridx = 0; gbc.gridy = 8; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(panelBotoes, gbc);
        
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
    
    private void cadastrarAluno() {
        try {
            // Validação dos campos
            if (txtRA.getText().trim().isEmpty() || txtNome.getText().trim().isEmpty() ||
                txtSobrenome.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios!");
                return;
            }
            
            // Validação das notas
            double p1 = Double.parseDouble(txtP1.getText().trim());
            double p2 = Double.parseDouble(txtP2.getText().trim());
            double p3 = Double.parseDouble(txtP3.getText().trim());
            double p4 = Double.parseDouble(txtP4.getText().trim());
            
            // Gravação no arquivo
            FileWriter writer = new FileWriter("alunos.txt", true);
            String linha = txtRA.getText().trim() + ";" + 
                          txtNome.getText().trim() + ";" + 
                          txtSobrenome.getText().trim() + ";" + 
                          p1 + ";" + p2 + ";" + p3 + ";" + p4 + "\n";
            writer.write(linha);
            writer.close();
            
            JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso!");
            limparCampos();
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Erro: Digite valores numéricos válidos para as notas!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar no arquivo: " + ex.getMessage());
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
        txtRA.requestFocus();
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