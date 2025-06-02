import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class CalculadoraCientifica extends JFrame {
    private JTextField display;

    public CalculadoraCientifica() {
        setTitle("Calculadora");
        setSize(350, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        display = new JTextField("0");
        display.setEditable(false);
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 32));

        JPanel painel = new JPanel(new GridLayout(5, 5, 5, 5));
        String[] botoes = {
            "e", "π", "C", "⌫", "÷",
            "x²", "7", "8", "9", "×",
            "|x|", "4", "5", "6", "-",
            "1/x", "1", "2", "3", "+",
            "√x", "+/-", "0", ",", "="
        };

        for (String texto : botoes) {
            JButton btn = new JButton(texto);
            btn.setFont(new Font("Arial", Font.PLAIN, 20));
            btn.addActionListener(this::acaoBotao);
            painel.add(btn);
        }

        setLayout(new BorderLayout());
        add(display, BorderLayout.NORTH);
        add(painel, BorderLayout.CENTER);
    }

    private void acaoBotao(ActionEvent e) {
        String comando = ((JButton) e.getSource()).getText();
        try {
            switch (comando) {
                case "C":
                    display.setText("0");
                    break;

                case "⌫":
                    String texto = display.getText();
                    if (texto.length() > 1) {
                        display.setText(texto.substring(0, texto.length() - 1));
                    } else {
                        display.setText("0");
                    }
                    break;

                case "=":
                    String expr = display.getText()
                            .replace("×", "*")
                            .replace("÷", "/")
                            .replace(",", ".");

                    System.out.println("Expressão convertida: " + expr);

                    // Evita expressões inválidas (ex: "5+")
                    if (expr.matches(".*[+\\-*/]$")) {
                        display.setText("Erro");
                        break;
                    }

                    try {
                        double resultado = avaliarExpressao(expr);
                        // Formatar o resultado para remover decimais desnecessários
                        if (resultado == (long) resultado) {
                            display.setText(String.valueOf((long) resultado));
                        } else {
                            display.setText(String.valueOf(resultado));
                        }
                    } catch (Exception exEval) {
                        display.setText("Erro");
                    }
                    break;

                case "+/-":
                    double valor = Double.parseDouble(display.getText().replace(",", "."));
                    display.setText(formatarNumero(-valor));
                    break;

                case "π":
                    display.setText(String.valueOf(Math.PI));
                    break;

                case "e":
                    display.setText(String.valueOf(Math.E));
                    break;

                case "x²":
                    valor = Double.parseDouble(display.getText().replace(",", "."));
                    display.setText(formatarNumero(valor * valor));
                    break;

                case "√x":
                    valor = Double.parseDouble(display.getText().replace(",", "."));
                    if (valor < 0) {
                        display.setText("Erro");
                    } else {
                        display.setText(formatarNumero(Math.sqrt(valor)));
                    }
                    break;

                case "|x|":
                    valor = Double.parseDouble(display.getText().replace(",", "."));
                    display.setText(formatarNumero(Math.abs(valor)));
                    break;

                case "1/x":
                    valor = Double.parseDouble(display.getText().replace(",", "."));
                    if (valor == 0) {
                        display.setText("Erro");
                    } else {
                        display.setText(formatarNumero(1.0 / valor));
                    }
                    break;

                case ",":
                    if (!display.getText().contains(",")) {
                        display.setText(display.getText() + ",");
                    }
                    break;

                case "+": case "-": case "×": case "÷":
                    display.setText(display.getText() + comando);
                    break;

                default: // números
                    if (display.getText().equals("0") || display.getText().equals("Erro")) {
                        display.setText(comando);
                    } else {
                        display.setText(display.getText() + comando);
                    }
            }
        } catch (Exception ex) {
            display.setText("Erro");
        }
    }

    private String formatarNumero(double numero) {
        if (numero == (long) numero) {
            return String.valueOf((long) numero);
        } else {
            return String.valueOf(numero);
        }
    }

    // Método para avaliar expressões matemáticas simples
    private double avaliarExpressao(String expressao) throws Exception {
        // Remove espaços em branco
        expressao = expressao.replaceAll("\\s+", "");
        
        // Verifica se a expressão está vazia
        if (expressao.isEmpty()) {
            throw new Exception("Expressão vazia");
        }
        
        return avaliarAdicaoSubtracao(expressao);
    }
    
    private double avaliarAdicaoSubtracao(String expr) throws Exception {
        ArrayList<Double> numeros = new ArrayList<>();
        ArrayList<Character> operadores = new ArrayList<>();
        
        StringBuilder numeroAtual = new StringBuilder();
        
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            
            if (c == '+' || c == '-') {
                if (numeroAtual.length() == 0 && c == '-') {
                    // Número negativo no início
                    numeroAtual.append(c);
                } else if (i > 0 && (expr.charAt(i-1) == '*' || expr.charAt(i-1) == '/') && c == '-') {
                    // Número negativo após operador
                    numeroAtual.append(c);
                } else {
                    // Operador de adição/subtração
                    if (numeroAtual.length() > 0) {
                        numeros.add(Double.parseDouble(numeroAtual.toString()));
                        numeroAtual = new StringBuilder();
                    }
                    operadores.add(c);
                }
            } else if (c == '*' || c == '/') {
                if (numeroAtual.length() > 0) {
                    numeros.add(Double.parseDouble(numeroAtual.toString()));
                    numeroAtual = new StringBuilder();
                }
                operadores.add(c);
            } else if (Character.isDigit(c) || c == '.') {
                numeroAtual.append(c);
            } else {
                throw new Exception("Caractere inválido: " + c);
            }
        }
        
        // Adiciona o último número
        if (numeroAtual.length() > 0) {
            numeros.add(Double.parseDouble(numeroAtual.toString()));
        }
        
        // Primeiro, resolve multiplicação e divisão
        for (int i = 0; i < operadores.size(); i++) {
            if (operadores.get(i) == '*' || operadores.get(i) == '/') {
                double resultado;
                if (operadores.get(i) == '*') {
                    resultado = numeros.get(i) * numeros.get(i + 1);
                } else {
                    if (numeros.get(i + 1) == 0) {
                        throw new Exception("Divisão por zero");
                    }
                    resultado = numeros.get(i) / numeros.get(i + 1);
                }
                
                numeros.set(i, resultado);
                numeros.remove(i + 1);
                operadores.remove(i);
                i--; // Ajusta o índice após remoção
            }
        }
        
        // Depois, resolve adição e subtração
        double resultado = numeros.get(0);
        for (int i = 0; i < operadores.size(); i++) {
            if (operadores.get(i) == '+') {
                resultado += numeros.get(i + 1);
            } else if (operadores.get(i) == '-') {
                resultado -= numeros.get(i + 1);
            }
        }
        
        return resultado;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculadoraCientifica().setVisible(true);
        });
    }
}