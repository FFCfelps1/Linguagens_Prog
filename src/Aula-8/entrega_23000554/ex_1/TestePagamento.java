public class TestePagamento {
    public static void main(String[] args) {
        Pagamento pag = new Pagamento("João da Silva", "123.456.789-00", 100.0);
        System.out.println("Pagamento: " + pag.getNomeDoPagador() + ", CPF: " + pag.getCpf() + ", Valor: R$" + pag.getValorASerPago());

        CartaoDeCredito cc = new CartaoDeCredito("Maria Oliveira", "987.654.321-00", 250.0, "1111-2222-3333-4444");
        System.out.println("Cartão: " + cc.getNomeDoPagador() + ", CPF: " + cc.getCpf() + ", Cartão: " + cc.getNumeroDoCartao() + ", Valor: R$" + cc.getValorASerPago());

        Cheque ch = new Cheque("Carlos Souza", "456.789.123-00", 500.0, "CHQ123456");
        System.out.println("Cheque: " + ch.getNomeDoPagador() + ", CPF: " + ch.getCpf() + ", Cheque: " + ch.getNumeroDoCheque() + ", Valor: R$" + ch.getValorASerPago());

        Boleto bol = new Boleto("Ana Lima", "321.654.987-00", 750.0, "BOL789123", 15, 5, 2025);
        System.out.println("Boleto: " + bol.getNomeDoPagador() + ", CPF: " + bol.getCpf() + ", Boleto: " + bol.getNumeroDoBoleto() +
                           ", Vencimento: " + bol.getDia() + "/" + bol.getMes() + "/" + bol.getAno() + ", Valor: R$" + bol.getValorASerPago());
    }
}
