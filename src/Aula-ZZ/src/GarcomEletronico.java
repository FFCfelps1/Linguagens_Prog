import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GarcomEletronico extends JFrame {

    private JLabel lblTela;
    private double valorEmTela = 0.0;
    private Pedido pedido = new Pedido();

    public GarcomEletronico() {
        setTitle("Garçom Eletrônico");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        lblTela = new JLabel("0", SwingConstants.RIGHT);
        lblTela.setFont(new Font("Arial", Font.BOLD, 30));
        add(lblTela, BorderLayout.NORTH);

        JPanel botoes = new JPanel(new GridLayout(4, 3, 5, 5));
        addBotao(botoes, "Entrada A (R$15,00)", 15);
        addBotao(botoes, "Entrada B (R$25,00)", 25);
        addBotaoAcao(botoes, "Incluir", e -> pedido.incluir(valorEmTela));
        addBotao(botoes, "Massa A (R$30,00)", 30);
        addBotao(botoes, "Massa B (R$40,00)", 40);
        addBotaoAcao(botoes, "Excluir", e -> pedido.excluir(valorEmTela));
        addBotao(botoes, "Doce A (R$25,00)", 25);
        addBotao(botoes, "Doce B (R$30,00)", 30);
        addBotaoAcao(botoes, "Iniciar", e -> {
            pedido.iniciar();
            lblTela.setText("0");
        });
        addBotao(botoes, "Bebida A (R$7,00)", 7);
        addBotao(botoes, "Bebida B (R$9,00)", 9);
        addBotaoAcao(botoes, "Totalizar", e -> lblTela.setText(String.format("%.2f", pedido.totalizar())));

        add(botoes, BorderLayout.CENTER);
        setVisible(true);
    }

    private void addBotao(JPanel panel, String texto, double valor) {
        JButton botao = new JButton(texto);
        botao.addActionListener(e -> {
            valorEmTela = valor;
            lblTela.setText(String.format("%.2f", valorEmTela));
        });
        panel.add(botao);
    }

    private void addBotaoAcao(JPanel panel, String texto, ActionListener acao) {
        JButton botao = new JButton(texto);
        botao.addActionListener(acao);
        panel.add(botao);
    }

    public static void main(String[] args) {
        new GarcomEletronico();
    }
}
