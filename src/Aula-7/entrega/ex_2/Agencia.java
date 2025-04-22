/*
 * d) A classe Agencia tem os atributos nome do tipo String, numero e digito do tipo int. Crie um construtor que
 * receba os atributos como parâmetros e os métodos de acesso e os modificadores. O numero e o digito da
 * Agencia devem seguir os mesmos padrões do número e do dígito da conta corrente;
 */

public class Agencia {
    private String nome;
    private int numero;
    private int digito;

    public Agencia(String nome, int numero, int digito) {
        this.nome = nome;
        this.numero = numero;
        this.digito = digito;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getDigito() {
        return digito;
    }

    public void setDigito(int digito) {
        this.digito = digito;
    }
}