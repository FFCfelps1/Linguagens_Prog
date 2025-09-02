import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
        String raBuscado = txtRABusca.getText().trim();
        
        if (raBuscado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite o RA para consulta!");
            txtRABusca.requestFocus();
            return;
        }
        
        boolean encontrado = false;
        StringBuilder resultado = new StringBuilder();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("alunos.txt"));
            String linha;
            
            resultado.append("=".repeat(60)).append("\n");
            resultado.append("RESULTADO DA CONSULTA\n");
            resultado.append("=".repeat(60)).append("\n\n");
            
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                
                if (dados.length >= 7) {
                    String raArquivo = dados[0].trim();
                    
                    if (raArquivo.equals(raBuscado)) {
                        encontrado = true;
                        
                        String nome = dados[1].trim();
                        String sobrenome = dados[2].trim();
                        double p1 = Double.parseDouble(dados[3].trim());
                        double p2 = Double.parseDouble(dados[4].trim());
                        double p3 = Double.parseDouble(dados[5].trim());
                        double p4 = Double.parseDouble(dados[6].trim());
                        
                        double media = (p1 + p2 + p3 + p4) / 4.0;
                        
                        resultado.append("ALUNO ENCONTRADO!\n\n");
                        resultado.append(String.format("RA: %s\n", raArquivo));
                        resultado.append(String.format("Nome: %s\n", nome));
                        resultado.append(String.format("Sobrenome: %s\n", sobrenome));
                        resultado.append(String.format("Nome Completo: %s %s\n\n", nome, sobrenome));
                        
                        resultado.append("NOTAS:\n");
                        resultado.append(String.format("P1: %.2f\n", p1));
                        resultado.append(String.format("P2: %.2f\n", p2));
                        resultado.append(String.format("P3: %.2f\n", p3));
                        resultado.append(String.format("P4: %.2f\n\n", p4));
                        
                        resultado.append(String.format("MÉDIA: %.2f\n", media));
                        
                        if (media >= 7.0) {
                            resultado.append("SITUAÇÃO: APROVADO\n");
                        } else if (media >= 5.0) {
                            resultado.append("SITUAÇÃO: RECUPERAÇÃO\n");
                        } else {
                            resultado.append("SITUAÇÃO: REPROVADO\n");
                        }
                        
                        break;
                    }
                }
            }
            
            reader.close();
            
            if (!encontrado) {
                resultado.append("RA NÃO CADASTRADO\n\n");
                resultado.append("O RA informado não foi encontrado na base de dados.\n");
                resultado.append("Verifique se o número está correto ou se o aluno\n");
                resultado.append("foi cadastrado no sistema.\n");
            }
            
            txtResultado.setText(resultado.toString());
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, 
                "Erro ao ler o arquivo: " + e.getMessage() + 
                "\n\nCertifique-se de que o arquivo 'alunos.txt' existe.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                "Erro nos dados do arquivo. Verifique o formato das notas.");
        }
    }
    
    private void limparResultado() {
        txtRABusca.setText("");
        txtResultado.setText("");
        txtRABusca.requestFocus();
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