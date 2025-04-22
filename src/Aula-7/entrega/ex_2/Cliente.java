/*
 * a) A classe Cliente possui os atributos nome e cpf, ambos do tipo String, e um atributo conta do tipo ContaCorrente.
 * Crie um construtor que receba os atributos como parâmetros e os métodos de acesso e os modificadores;
 */

public class Cliente {
    private String nome;
    private String cpf;
    private ContaCorrente conta;

    public Cliente(String nome, String cpf, ContaCorrente conta) {
        this.nome = nome;
        this.cpf = cpf;
        this.conta = conta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ContaCorrente getConta() {
        return conta;
    }

    public void setConta(ContaCorrente conta) {
        this.conta = conta;
    }
}