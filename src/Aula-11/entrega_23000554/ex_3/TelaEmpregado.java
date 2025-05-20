import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaEmpregado extends JFrame implements ActionListener {
    private JComboBox<String> cbTipo;
    private JTextField txtNome, txt1, txt2;
    private JLabel lbl1, lbl2;
    private JTextField txtSalario;
    private JButton btnCalcular, btnLimpar, btnSair;

    public TelaEmpregado() {
        super("Empregados");

        JPanel painelEntrada = new JPanel(new GridLayout(5, 2));
        painelEntrada.add(new JLabel("Nome:"));
        txtNome = new JTextField(15);
        painelEntrada.add(txtNome);

        painelEntrada.add(new JLabel("Tipo:"));
        cbTipo = new JComboBox<>(new String[]{"Mensalista", "Comissionado", "Horista", "Tarefeiro"});
        painelEntrada.add(cbTipo);

        lbl1 = new JLabel("Salário Mensal:");
        painelEntrada.add(lbl1);
        txt1 = new JTextField(10);
        painelEntrada.add(txt1);

        lbl2 = new JLabel("");
        painelEntrada.add(lbl2);
        txt2 = new JTextField(10);
        painelEntrada.add(txt2);

        painelEntrada.add(new JLabel("Salário Calculado:"));
        txtSalario = new JTextField(10);
        txtSalario.setEditable(false);
        painelEntrada.add(txtSalario);

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

        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void atualizarCampos() {
        String tipo = (String) cbTipo.getSelectedItem();
        if (tipo.equals("Mensalista")) {
            lbl1.setText("Salário Mensal:");
            lbl2.setText("");
            txt2.setVisible(false);
        } else if (tipo.equals("Comissionado")) {
            lbl1.setText("Total de Vendas:");
            lbl2.setText("Taxa (%):");
            lbl2.setVisible(true);
            txt2.setVisible(true);
        } else if (tipo.equals("Horista")) {
            lbl1.setText("Horas Trabalhadas:");
            lbl2.setText("Valor Hora:");
            lbl2.setVisible(true);
            txt2.setVisible(true);
        } else if (tipo.equals("Tarefeiro")) {
            lbl1.setText("Nº de Tarefas:");
            lbl2.setText("Valor por Tarefa:");
            lbl2.setVisible(true);
            txt2.setVisible(true);
        }
        txt1.setText("");
        txt2.setText("");
        txtSalario.setText("");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cbTipo) {
            atualizarCampos();
        } else if (e.getSource() == btnCalcular) {
            try {
                String nome = txtNome.getText();
                String tipo = (String) cbTipo.getSelectedItem();
                Empregado emp = null;
                if (tipo.equals("Mensalista")) {
                    double sal = Double.parseDouble(txt1.getText());
                    emp = new Mensalista(nome, sal);
                } else if (tipo.equals("Comissionado")) {
                    double vendas = Double.parseDouble(txt1.getText());
                    double taxa = Double.parseDouble(txt2.getText()) / 100.0;
                    emp = new Comissionado(nome, vendas, taxa);
                } else if (tipo.equals("Horista")) {
                    double horas = Double.parseDouble(txt1.getText());
                    double valorHora = Double.parseDouble(txt2.getText());
                    emp = new Horista(nome, horas, valorHora);
                } else if (tipo.equals("Tarefeiro")) {
                    int tarefas = Integer.parseInt(txt1.getText());
                    double valorTarefa = Double.parseDouble(txt2.getText());
                    emp = new Tarefeiro(nome, tarefas, valorTarefa);
                }
                txtSalario.setText(String.format("%.2f", emp.calcularSalario()));
                JOptionPane.showMessageDialog(this, emp, "Empregado", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Dados inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnLimpar) {
            txtNome.setText("");
            txt1.setText("");
            txt2.setText("");
            txtSalario.setText("");
        } else if (e.getSource() == btnSair) {
            System.exit(0);
        }
    }
}