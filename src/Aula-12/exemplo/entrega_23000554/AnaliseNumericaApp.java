package entrega_23000554;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.stream.*;

public class AnaliseNumericaApp extends JFrame {
    private double[] vetor = new double[0];
    private JTable tabela = new JTable();

    public AnaliseNumericaApp() {
        super("Análise Numérica - App Java");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();

        // Menu Vetor
        JMenu menuVetor = new JMenu("Vetor");
        JMenuItem itemDimensiona = new JMenuItem("Dimensiona");
        JMenuItem itemDigita = new JMenuItem("Digita");
        JMenuItem itemApresenta = new JMenuItem("Apresenta");

        itemDimensiona.addActionListener(e -> dimensionaVetor());
        itemDigita.addActionListener(e -> digitaVetor());
        itemApresenta.addActionListener(e -> apresentaVetor());

        menuVetor.add(itemDimensiona);
        menuVetor.add(itemDigita);
        menuVetor.add(itemApresenta);

        // Menu PROBEST
        JMenu menuProb = new JMenu("PROBEST");
        adicionarItemCalculoProb(menuProb, "Média", this::calculaMedia);
        adicionarItemCalculoProb(menuProb, "Desvio Padrão", this::calculaDesvioPadrao);
        adicionarItemCalculoProb(menuProb, "Variância", this::calculaVariancia);
        adicionarItemCalculoProb(menuProb, "Mediana", this::calculaMediana);
        adicionarItemCalculoProb(menuProb, "Coef. Assimetria", this::calculaCoefAssimetria);
        adicionarItemCalculoProb(menuProb, "Coef. Variação", this::calculaCoefVariacao);

        // Menu CDI
        JMenu menuCDI = new JMenu("CDI");
        adicionarItemCalculoProb(menuCDI, "Função", this::aplicaFuncao);
        adicionarItemCalculoProb(menuCDI, "Derivada", this::calculaDerivada);

        // Menu ALGESD
        JMenu menuALGESD = new JMenu("ALGESD");

        JMenu menuOrdenacao = new JMenu("Ordenação");
        adicionarItemOrdenacao(menuOrdenacao, "Trocas", this::ordenacaoTroca);
        adicionarItemOrdenacao(menuOrdenacao, "Seleção", this::ordenacaoSelecao);
        adicionarItemOrdenacao(menuOrdenacao, "Inserção", this::ordenacaoInsercao);
        adicionarItemOrdenacao(menuOrdenacao, "Quick", this::ordenacaoQuickSort);
        adicionarItemOrdenacao(menuOrdenacao, "Merge", this::ordenacaoMergeSort);

        JMenu menuBusca = new JMenu("Busca");
        adicionarItemBusca(menuBusca, "Linear Iterativa", this::buscaLinearIterativa);
        adicionarItemBusca(menuBusca, "Linear Recursiva", this::buscaLinearRecursiva);
        adicionarItemBusca(menuBusca, "Binária Iterativa", this::buscaBinariaIterativa);
        adicionarItemBusca(menuBusca, "Binária Recursiva", this::buscaBinariaRecursiva);

        menuALGESD.add(menuOrdenacao);
        menuALGESD.add(menuBusca);

        menuBar.add(menuVetor);
        menuBar.add(menuProb);
        menuBar.add(menuCDI);
        menuBar.add(menuALGESD);
        setJMenuBar(menuBar);

        add(new JScrollPane(tabela), BorderLayout.CENTER);
    }

    // --- VETOR ---
    private void dimensionaVetor() {
        String input = JOptionPane.showInputDialog(this, "Informe o tamanho do vetor:");
        if (input != null) {
            int tamanho = Integer.parseInt(input);
            vetor = new double[tamanho];
            JOptionPane.showMessageDialog(this, "Vetor criado com " + tamanho + " posições.");
        }
    }

    private void digitaVetor() {
        if (vetor.length == 0) {
            JOptionPane.showMessageDialog(this, "Dimensione o vetor primeiro.");
            return;
        }
        for (int i = 0; i < vetor.length; i++) {
            String input = JOptionPane.showInputDialog(this, "Digite o valor na posição " + i + ":");
            vetor[i] = Double.parseDouble(input);
        }
    }

    private void apresentaVetor() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Índice");
        model.addColumn("Valor");

        for (int i = 0; i < vetor.length; i++) {
            model.addRow(new Object[]{i, vetor[i]});
        }

        tabela.setModel(model);
    }

    // --- PROBEST ---
    private void adicionarItemCalculoProb(JMenu menu, String nome, Runnable acao) {
        JMenuItem item = new JMenuItem(nome);
        item.addActionListener(e -> acao.run());
        menu.add(item);
    }

    private void calculaMedia() {
        double media = Arrays.stream(vetor).average().orElse(0);
        mostrarResultado("Média", media);
    }

    private void calculaDesvioPadrao() {
        double media = Arrays.stream(vetor).average().orElse(0);
        double soma = Arrays.stream(vetor).map(x -> Math.pow(x - media, 2)).sum();
        double dp = Math.sqrt(soma / vetor.length);
        mostrarResultado("Desvio Padrão", dp);
    }

    private void calculaVariancia() {
        double media = Arrays.stream(vetor).average().orElse(0);
        double soma = Arrays.stream(vetor).map(x -> Math.pow(x - media, 2)).sum();
        mostrarResultado("Variância", soma / vetor.length);
    }

    private void calculaMediana() {
        double[] sorted = Arrays.copyOf(vetor, vetor.length);
        Arrays.sort(sorted);
        double mediana;
        if (sorted.length % 2 == 0)
            mediana = (sorted[sorted.length / 2 - 1] + sorted[sorted.length / 2]) / 2.0;
        else
            mediana = sorted[sorted.length / 2];
        mostrarResultado("Mediana", mediana);
    }

    private void calculaCoefAssimetria() {
        double media = Arrays.stream(vetor).average().orElse(0);
        double dp = Math.sqrt(Arrays.stream(vetor).map(x -> Math.pow(x - media, 2)).sum() / vetor.length);
        double assimetria = Arrays.stream(vetor).map(x -> Math.pow((x - media) / dp, 3)).sum() / vetor.length;
        mostrarResultado("Coef. Assimetria", assimetria);
    }

    private void calculaCoefVariacao() {
        double media = Arrays.stream(vetor).average().orElse(0);
        double dp = Math.sqrt(Arrays.stream(vetor).map(x -> Math.pow(x - media, 2)).sum() / vetor.length);
        mostrarResultado("Coef. Variação (%)", (dp / media) * 100);
    }

    // --- CDI ---
    private void aplicaFuncao() {
        String input = JOptionPane.showInputDialog(this, "Digite a função a aplicar (ex: x*2, x+1):");
        if (input != null) {
            // Exemplo simplificado: função "x+1" vira x+1
            for (int i = 0; i < vetor.length; i++) {
                vetor[i] = vetor[i] + 1; // você pode usar ScriptEngine para avaliar expressões
            }
            apresentaVetor();
        }
    }

    private void calculaDerivada() {
        double[] derivada = new double[vetor.length - 1];
        for (int i = 0; i < derivada.length; i++) {
            derivada[i] = vetor[i + 1] - vetor[i];
        }
        vetor = derivada;
        apresentaVetor();
    }

    // --- ALGESD: Ordenações ---
    private void adicionarItemOrdenacao(JMenu menu, String nome, Runnable acao) {
        JMenuItem item = new JMenuItem(nome);
        item.addActionListener(e -> acao.run());
        menu.add(item);
    }

    private void ordenacaoTroca() {
        for (int i = 0; i < vetor.length - 1; i++) {
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[i] > vetor[j]) {
                    double tmp = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = tmp;
                }
            }
        }
        apresentaVetor();
    }

    private void ordenacaoSelecao() {
        for (int i = 0; i < vetor.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[min]) min = j;
            }
            double tmp = vetor[i];
            vetor[i] = vetor[min];
            vetor[min] = tmp;
        }
        apresentaVetor();
    }

    private void ordenacaoInsercao() {
        for (int i = 1; i < vetor.length; i++) {
            double chave = vetor[i];
            int j = i - 1;
            while (j >= 0 && vetor[j] > chave) {
                vetor[j + 1] = vetor[j];
                j--;
            }
            vetor[j + 1] = chave;
        }
        apresentaVetor();
    }

    private void ordenacaoQuickSort() {
        quickSort(vetor, 0, vetor.length - 1);
        apresentaVetor();
    }

    private void quickSort(double[] v, int inicio, int fim) {
        if (inicio < fim) {
            int p = particiona(v, inicio, fim);
            quickSort(v, inicio, p - 1);
            quickSort(v, p + 1, fim);
        }
    }

    private int particiona(double[] v, int inicio, int fim) {
        double pivo = v[fim];
        int i = inicio - 1;
        for (int j = inicio; j < fim; j++) {
            if (v[j] < pivo) {
                i++;
                double tmp = v[i]; v[i] = v[j]; v[j] = tmp;
            }
        }
        double tmp = v[i + 1]; v[i + 1] = v[fim]; v[fim] = tmp;
        return i + 1;
    }

    private void ordenacaoMergeSort() {
        vetor = mergeSort(vetor);
        apresentaVetor();
    }

    private double[] mergeSort(double[] v) {
        if (v.length <= 1) return v;
        int mid = v.length / 2;
        return merge(mergeSort(Arrays.copyOfRange(v, 0, mid)), mergeSort(Arrays.copyOfRange(v, mid, v.length)));
    }

    private double[] merge(double[] a, double[] b) {
        double[] r = new double[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            r[k++] = a[i] < b[j] ? a[i++] : b[j++];
        }
        while (i < a.length) r[k++] = a[i++];
        while (j < b.length) r[k++] = b[j++];
        return r;
    }

    // --- ALGESD: Buscas ---
    private void adicionarItemBusca(JMenu menu, String nome, Runnable acao) {
        JMenuItem item = new JMenuItem(nome);
        item.addActionListener(e -> acao.run());
        menu.add(item);
    }

    private void buscaLinearIterativa() {
        String chaveStr = JOptionPane.showInputDialog(this, "Digite valor a buscar:");
        double chave = Double.parseDouble(chaveStr);
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == chave) {
                mostrarResultado("Encontrado na posição", i);
                return;
            }
        }
        mostrarResultado("Não encontrado", -1);
    }

    private void buscaLinearRecursiva() {
        String chaveStr = JOptionPane.showInputDialog(this, "Digite valor a buscar:");
        double chave = Double.parseDouble(chaveStr);
        buscarLinearRec(vetor, 0, chave);
    }

    private void buscarLinearRec(double[] v, int i, double chave) {
        if (i >= v.length) {
            mostrarResultado("Não encontrado", -1);
        } else if (v[i] == chave) {
            mostrarResultado("Encontrado na posição", i);
        } else {
            buscarLinearRec(v, i + 1, chave);
        }
    }

    private void buscaBinariaIterativa() {
        ordenarParaBusca();
        String chaveStr = JOptionPane.showInputDialog(this, "Digite valor a buscar:");
        double chave = Double.parseDouble(chaveStr);
        int inicio = 0, fim = vetor.length - 1;
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (vetor[meio] == chave) {
                mostrarResultado("Encontrado na posição", meio);
                return;
            } else if (vetor[meio] < chave) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        mostrarResultado("Não encontrado", -1);
    }

    private void buscaBinariaRecursiva() {
        ordenarParaBusca();
        String chaveStr = JOptionPane.showInputDialog(this, "Digite valor a buscar:");
        double chave = Double.parseDouble(chaveStr);
        int resultado = buscaBinariaRec(vetor, 0, vetor.length - 1, chave);
        mostrarResultado(resultado >= 0 ? "Encontrado na posição" : "Não encontrado", resultado);
    }

    private int buscaBinariaRec(double[] v, int inicio, int fim, double chave) {
        if (inicio > fim) return -1;
        int meio = (inicio + fim) / 2;
        if (v[meio] == chave) return meio;
        if (chave < v[meio]) return buscaBinariaRec(v, inicio, meio - 1, chave);
        return buscaBinariaRec(v, meio + 1, fim, chave);
    }

    private void ordenarParaBusca() {
        Object[] options = {"Trocas", "Seleção", "Inserção", "Quick", "Merge"};
        String escolha = (String) JOptionPane.showInputDialog(this, "Escolha algoritmo para ordenar:", "Ordenar",
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (escolha == null) return;

        switch (escolha) {
            case "Trocas": ordenacaoTroca(); break;
            case "Seleção": ordenacaoSelecao(); break;
            case "Inserção": ordenacaoInsercao(); break;
            case "Quick": ordenacaoQuickSort(); break;
            case "Merge": ordenacaoMergeSort(); break;
        }
    }

    private void mostrarResultado(String titulo, double valor) {
        JOptionPane.showMessageDialog(this, titulo + ": " + valor);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AnaliseNumericaApp().setVisible(true));
    }
}
