import java.util.ArrayList;

public class Deposito {
    private ArrayList<Caixa> caixas;

    public Deposito() {
        caixas = new ArrayList<>();
    }

    public void adicionarCaixa(Caixa caixa) {
        caixas.add(caixa);
    }

    public boolean removerCaixaPorDono(String dono) {
        for (int i = 0; i < caixas.size(); i++) {
            if (caixas.get(i).getDono().equalsIgnoreCase(dono)) {
                caixas.remove(i);
                return true;
            }
        }
        return false;
    }

    public int encontrarCaixaPorDono(String dono) {
        for (int i = 0; i < caixas.size(); i++) {
            if (caixas.get(i).getDono().equalsIgnoreCase(dono)) {
                return i;
            }
        }
        return -1;
    }

    public boolean mudarLocalCaixa(String dono, String novoCorredor, int novaPosicao) {
        int index = encontrarCaixaPorDono(dono);
        if (index != -1) {
            Caixa caixa = caixas.get(index);
            caixa.setCorredor(novoCorredor);
            caixa.setPosicao(novaPosicao);
            return true;
        }
        return false;
    }

    public ArrayList<Caixa> caixasMaisPesadasQue(double pesoMinimo) {
        ArrayList<Caixa> resultado = new ArrayList<>();
        for (Caixa caixa : caixas) {
            if (caixa.getPeso() > pesoMinimo) {
                resultado.add(caixa);
            }
        }
        return resultado;
    }
}
