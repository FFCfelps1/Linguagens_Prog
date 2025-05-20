import javax.swing.*;
import java.awt.*;
import java.awt.event.*;    

public class TelaTexto extends JFrame {
    private JTextField campoTexto;
    private JButton btnMostrar, btnLimpar, btnSair;

    public TelaTexto() {
        super("Exemplo de Tela");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Texto:"));
        campoTexto = new JTextField(20);
        add(campoTexto);

        btnMostrar = new JButton("Mostrar");
        btnLimpar = new JButton("Limpar");
        btnSair = new JButton("Sair");

        add(btnMostrar);
        add(btnLimpar);
        add(btnSair);

        btnMostrar.addActionListener(e -> 
            JOptionPane.showMessageDialog(this, campoTexto.getText(), "Conteúdo", JOptionPane.INFORMATION_MESSAGE)
        );

        btnLimpar.addActionListener(e -> campoTexto.setText(""));

        btnSair.addActionListener(e -> System.exit(0));

        setSize(350, 120);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TelaTexto::new);
    }
}