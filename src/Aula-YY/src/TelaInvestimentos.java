import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TelaInvestimentos extends JFrame {
    private ArrayList<JTextField> camposAplic, camposJuros, camposResultado;
    private JTextField campoSaldo;

    public TelaInvestimentos() {
        setTitle("Investimentos");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 4));

        add(new JLabel("Saldo (R$):"));
        campoSaldo = new JTextField();
        add(campoSaldo);
        add(new JLabel(""));
        add(new JLabel(""));

        camposAplic = new ArrayList<>();
        camposJuros = new ArrayList<>();
        camposResultado = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            JTextField txtAplic = new JTextField();
            JTextField txtJuros = new JTextField();
            JTextField txtResultado = new JTextField();
            txtResultado.setEditable(false);
            camposAplic.add(txtAplic);
            camposJuros.add(txtJuros);
            camposResultado.add(txtResultado);

            add(new JLabel("Aplicação:"));
            add(txtAplic);
            add(new JLabel("Juros (% a.m):"));
            add(txtJuros);
            add(new JLabel("Resultado (R$):"));
            add(txtResultado);
        }

        JButton ler = new JButton("Ler do BD");
        JButton salvar = new JButton("Salvar no BD");
        JButton sair = new JButton("Sair");

        ler.addActionListener(e -> {
            try {
                ArrayList<AplicacaoInvestimento> dados = BD.lerDados();
                for (int i = 0; i < dados.size(); i++) {
                    camposAplic.get(i).setText(dados.get(i).getDescricao());
                    camposJuros.get(i).setText(String.valueOf(dados.get(i).getJuros()));
                    double saldo = dados.get(i).getSaldo();
                    campoSaldo.setText(String.valueOf(saldo));
                    camposResultado.get(i).setText(String.format("%.2f", saldo + saldo * (dados.get(i).getJuros() / 100)));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        salvar.addActionListener(e -> {
            try {
                ArrayList<AplicacaoInvestimento> novaLista = new ArrayList<>();
                double saldo = Double.parseDouble(campoSaldo.getText());
                for (int i = 0; i < 3; i++) {
                    String nome = camposAplic.get(i).getText();
                    double juros = Double.parseDouble(camposJuros.get(i).getText());
                    novaLista.add(new AplicacaoInvestimento(nome, saldo, juros));
                }
                BD.salvarDados(novaLista);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        sair.addActionListener(e -> System.exit(0));

        add(ler);
        add(salvar);
        add(sair);
        add(new JLabel());

        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaInvestimentos();
    }
}
