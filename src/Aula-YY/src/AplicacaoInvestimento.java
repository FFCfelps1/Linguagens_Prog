public class AplicacaoInvestimento {
    private String descricao;
    private double saldo;
    private double juros;

    public AplicacaoInvestimento(String descricao, double saldo, double juros) {
        this.descricao = descricao;
        this.saldo = saldo;
        this.juros = juros;
    }

    public double getResultado() {
        return saldo + saldo * (juros / 100);
    }

    // Getters
    public String getDescricao() {
        return descricao;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getJuros() {
        return juros;
    }

    // Setters
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }
}
