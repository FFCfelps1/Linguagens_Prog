import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaPessoaFisica extends JFrame implements ActionListener {
    private JComboBox<String> cbTipo;
    private JTextField txtNome, txtCpf, txt1, txt2;
    private JLabel lbl1, lbl2;
    private JTextField txtRenda;
    private JButton btnCalcular, btnLimpar, btnSair;

    public TelaPessoaFisica() {
        super("Pessoa Física");

        JPanel painelEntrada = new JPanel(new GridLayout(6, 2));
        painelEntrada.add(new JLabel("Nome:"));
        txtNome = new JTextField(15);
        painelEntrada.add(txtNome);

        painelEntrada.add(new JLabel("CPF:"));
        txtCpf = new JTextField(15);
        painelEntrada.add(txtCpf);

        painelEntrada.add(new JLabel("Tipo:"));
        cbTipo = new JComboBox<>(new String[]{
            "Desempregado", "Mensalista", "Comissionado", "Horista", "Tarefeiro"
        });
        painelEntrada.add(cbTipo);

        lbl1 = new JLabel("");
        painelEntrada.add(lbl1);
        txt1 = new JTextField(10);
        painelEntrada.add(txt1);

        lbl2 = new JLabel("");
        painelEntrada.add(lbl2);
        txt2 = new JTextField(10);
        painelEntrada.add(txt2);

        painelEntrada.add(new JLabel("Renda/Salário:"));
        txtRenda = new JTextField(10);
        txtRenda.setEditable(false);
        painelEntrada.add(txtRenda);

        JPanel painelBotoes = new JPanel();
        btnCalcular = new JButton("Calcular");
        btnLimpar = new JButton("Limpar");
        btnSair = new JButton("Sair");
        painelBotoes.add(btnCalcular);
        painelBotoes.add(btnLimpar);
        painelBotoes.add(btnSair);

        Container caixa = getContentPane();
        caixa.setLayout(new BorderLayout());
        caixa.add(painelEntrada, BorderLayout.CENTER);
        caixa.add(painelBotoes, BorderLayout.SOUTH);

        cbTipo.addActionListener(this);
        btnCalcular.addActionListener(this);
        btnLimpar.addActionListener(this);
        btnSair.addActionListener(this);

        atualizarCampos();

        setSize(420, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void atualizarCampos() {
        String tipo = (String) cbTipo.getSelectedItem();
        if (tipo.equals("Desempregado")) {
            lbl1.setText("");
            lbl2.setText("");
            txt1.setVisible(false);
            txt2.setVisible(false);
        } else if (tipo.equals("Mensalista")) {
            lbl1.setText("Salário Mensal:");
            lbl2.setText("");
            txt1.setVisible(true);
            txt2.setVisible(false);
        } else if (tipo.equals("Comissionado")) {
            lbl1.setText("Total de Vendas:");
            lbl2.setText("Taxa (%):");
            txt1.setVisible(true);
            txt2.setVisible(true);
        } else if (tipo.equals("Horista")) {
            lbl1.setText("Horas Trabalhadas:");
            lbl2.setText("Valor Hora:");
            txt1.setVisible(true);
            txt2.setVisible(true);
        } else if (tipo.equals("Tarefeiro")) {
            lbl1.setText("Nº de Tarefas:");
            lbl2.setText("Valor por Tarefa:");
            txt1.setVisible(true);
            txt2.setVisible(true);
        }
        txt1.setText("");
        txt2.setText("");
        txtRenda.setText("");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cbTipo) {
            atualizarCampos();
        } else if (e.getSource() == btnCalcular) {
            try {
                String nome = txtNome.getText();
                String cpf = txtCpf.getText();
                String tipo = (String) cbTipo.getSelectedItem();
                PessoaFisica pf = null;
                if (tipo.equals("Desempregado")) {
                    pf = new Desempregado(nome, cpf);
                    txtRenda.setText("0.00");
                } else if (tipo.equals("Mensalista")) {
                    double sal = Double.parseDouble(txt1.getText());
                    pf = new Mensalista(nome, cpf, sal);
                    txtRenda.setText(String.format("%.2f", sal));
                } else if (tipo.equals("Comissionado")) {
                    double vendas = Double.parseDouble(txt1.getText());
                    double taxa = Double.parseDouble(txt2.getText()) / 100.0;
                    pf = new Comissionado(nome, cpf, vendas, taxa);
                    txtRenda.setText(String.format("%.2f", vendas * taxa));
                } else if (tipo.equals("Horista")) {
                    double horas = Double.parseDouble(txt1.getText());
                    double valorHora = Double.parseDouble(txt2.getText());
                    pf = new Horista(nome, cpf, horas, valorHora);
                    txtRenda.setText(String.format("%.2f", horas * valorHora));
                } else if (tipo.equals("Tarefeiro")) {
                    int tarefas = Integer.parseInt(txt1.getText());
                    double valorTarefa = Double.parseDouble(txt2.getText());
                    pf = new Tarefeiro(nome, cpf, tarefas, valorTarefa);
                    txtRenda.setText(String.format("%.2f", tarefas * valorTarefa));
                }
                JOptionPane.showMessageDialog(this, pf, "Pessoa Física", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Dados inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnLimpar) {
            txtNome.setText("");
            txtCpf.setText("");
            txt1.setText("");
            txt2.setText("");
            txtRenda.setText("");
        } else if (e.getSource() == btnSair) {
            System.exit(0);
        }
    }
}