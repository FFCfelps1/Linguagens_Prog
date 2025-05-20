import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora extends JFrame implements ActionListener {
    private JTextField display;
    private int num1 = 0, num2 = 0;
    private String operador = "";
    private boolean novoNumero = true;

    public Calculadora() {
        setTitle("Calculadora");
        setSize(250, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField("0");
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(4, 4, 5, 5));

        String[] botoes = {
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "*",
            "0", "C", "=", "/"
        };

        for (String texto : botoes) {
            JButton btn = new JButton(texto);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.addActionListener(this);
            painel.add(btn);
        }

        add(painel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.matches("\\d")) { // Se for número
            if (novoNumero) {
                display.setText(comando);
                novoNumero = false;
            } else {
                display.setText(display.getText().equals("0") ? comando : display.getText() + comando);
            }
        } else if (comando.matches("[+\\-*/]")) { // Se for operador
            num1 = Integer.parseInt(display.getText());
            operador = comando;
            novoNumero = true;
        } else if (comando.equals("=")) {
            num2 = Integer.parseInt(display.getText());
            int resultado = 0;
            switch (operador) {
                case "+": resultado = num1 + num2; break;
                case "-": resultado = num1 - num2; break;
                case "*": resultado = num1 * num2; break;
                case "/": 
                    if (num2 != 0) resultado = num1 / num2;
                    else {
                        display.setText("Erro");
                        novoNumero = true;
                        return;
                    }
                    break;
            }
            display.setText(String.valueOf(resultado));
            novoNumero = true;
        } else if (comando.equals("C")) {
            display.setText("0");
            num1 = num2 = 0;
            operador = "";
            novoNumero = true;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Calculadora().setVisible(true);
        });
    }
}