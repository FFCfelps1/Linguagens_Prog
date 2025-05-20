import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaRelogio extends JFrame {
    private Relogio relogio;
    private JLabel lblMostrador;

    public TelaRelogio() {
        relogio = new Relogio();
        lblMostrador = new JLabel(relogio.mostra(), SwingConstants.CENTER);
        lblMostrador.setFont(new Font("Arial", Font.BOLD, 48));
        lblMostrador.setForeground(Color.BLUE);

        JButton btnTicTac = new JButton("TicTac");
        JButton btnHora = new JButton("Hora");
        JButton btnMinuto = new JButton("Minuto");

        btnTicTac.addActionListener(e -> {
            relogio.tictac();
            atualizarMostrador();
        });

        btnHora.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(this, "Digite a hora (0-23):");
            try {
                int hora = Integer.parseInt(input);
                if (hora >= 0 && hora <= 23) {
                    relogio.acertaHora(hora);
                    atualizarMostrador();
                }
            } catch (Exception ex) {
                // Ignora entradas inválidas
            }
        });

        btnMinuto.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(this, "Digite o minuto (0-59):");
            try {
                int minuto = Integer.parseInt(input);
                if (minuto >= 0 && minuto <= 59) {
                    relogio.acertaMinuto(minuto);
                    atualizarMostrador();
                }
            } catch (Exception ex) {
                // Ignora entradas inválidas
            }
        });

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnTicTac);
        painelBotoes.add(btnHora);
        painelBotoes.add(btnMinuto);

        setLayout(new BorderLayout());
        add(lblMostrador, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        setTitle("Relógio Digital");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void atualizarMostrador() {
        lblMostrador.setText(relogio.mostra());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaRelogio().setVisible(true));
    }
}