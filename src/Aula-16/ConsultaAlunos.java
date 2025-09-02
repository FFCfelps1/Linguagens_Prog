import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

public class ConsultaAlunos extends JFrame {
    private JTextField txtRABusca;
    private JButton btnConsultar, btnLimpar;
    private JTextArea txtResultado;
    
    public ConsultaAlunos() {
        setTitle("Sistema de Consulta de Alunos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        
        // Painel superior - Busca
        JPanel panelBusca = new JPanel(new FlowLayout());
        panelBusca.setBorder(BorderFactory.createTitledBorder("Consulta por RA"));
        
        panelBusca.add(new JLabel("RA:"));
        txtRABusca = new JTextField(15);
        panelBusca.add(txtRABusca);
        
        btnConsultar = new JButton("Consultar");
        btnLimpar = new JButton("Limpar");
        panelBusca.add(btnConsultar);
        panelBusca.add(btnLimpar);
        
        add(panelBusca, BorderLayout.NORTH);
        
        // Painel central - Resultado
        JPanel panelResultado = new JPanel(new BorderLayout());
        panelResultado.setBorder(BorderFactory.createTitledBorder("Resultado da Consulta"));
        
        txtResultado = new JTextArea(12, 50);
        txtResultado.setEditable(false);
        txtResultado.setFont(new Font("Monospaced", Font.PLAIN, 12));
        txtResultado.setBackground(Color.WHITE);
        
        JScrollPane scrollPane = new JScrollPane(txtResultado);
        panelResultado.add(scrollPane, BorderLayout.CENTER);
        
        add(panelResultado, BorderLayout.CENTER);
        
        // Eventos dos botões
        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarAluno();
            }
        });
        
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparResultado();
            }
        });
        
        // Enter no campo de busca
        txtRABusca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarAluno();
            }
        });
        
        pack();
        setLocationRelativeTo(null);
        setResizable(true);
    }
    
    private void consultarAluno() {
        String raBuscado = txtRABusca.getText();
        
        if (raBuscado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite o RA!");
            return;
        }
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("alunos.txt"));
            String linha;
            boolean encontrou = false;
            
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                String ra = dados[0];
                
                if (ra.equals(raBuscado)) {
                    encontrou = true;
                    String nome = dados[1];
                    String sobrenome = dados[2];
                    double p1 = Double.parseDouble(dados[3]);
                    double p2 = Double.parseDouble(dados[4]);
                    double p3 = Double.parseDouble(dados[5]);
                    double p4 = Double.parseDouble(dados[6]);
                    double media = (p1 + p2 + p3 + p4) / 4;
                    
                    String resultado = "RA: " + ra + "\n";
                    resultado += "Nome: " + nome + " " + sobrenome + "\n";
                    resultado += "P1: " + p1 + "\n";
                    resultado += "P2: " + p2 + "\n";
                    resultado += "P3: " + p3 + "\n";
                    resultado += "P4: " + p4 + "\n";
                    resultado += "Média: " + media + "\n";
                    
                    txtResultado.setText(resultado);
                    break;
                }
            }
            
            if (!encontrou) {
                txtResultado.setText("Aluno não encontrado!");
            }
            
            reader.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }
    
    private void limparResultado() {
        txtRABusca.setText("");
        txtResultado.setText("");
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
                new ConsultaAlunos().setVisible(true);
            }
        });
    }
}