public class Comissionado extends Mensalista {
    private double comissao;

    public Comissionado() {
        super();
        this.comissao = 0.0;
    }

    public Comissionado(String nome, String sobrenome, String cpf, double salarioMensal, double comissao) {
        super(nome, sobrenome, cpf, salarioMensal);
        this.comissao = comissao;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    @Override
    public String dados() {
        return super.dados() + ", Comissão: R$" + comissao;
    }
}
