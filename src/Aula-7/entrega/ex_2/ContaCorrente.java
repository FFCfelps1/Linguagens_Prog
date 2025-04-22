/*
 * b) A classe ContaCorrente tem os atributos numero e digito, ambos int, o atributo agencia do tipo Agencia e o
 * atributo saldo do tipo double. Crie um construtor que receba os atributos como parâmetros e os métodos de
 * acesso e os modificadores. Crie também um método depositar() que receba um parâmetro double com o valor
 * do depósito e aumente o saldo da conta. Crie também um método sacar() que receba um parâmetro double com o
 * valor do saque e diminua o saldo da conta;
 * 
 * Crie, finalmente, um método imprimirSaldo() que imprima o numero da conta corrente com dígito, o número da agência com
 * dígito e o saldo da conta corrente;
 * 
 * na classe ContaCorrente, o número da conta deve ter no máximo 4 dígitos e ser positivo. O digito da conta
 * deve ser validado a partir do seguinte algoritmo de módulo 11: multiplique o primeiro dígito da conta por 4, o
 * segundo por 6, o terceiro por 8 e o quarto por 2; some tudo e calcule o resto da divisão (módulo) da soma por 11.
 * Este é o valor do dígito. Obs.: se o resultado for 10 o dígito é 0;
 */

public class ContaCorrente {
    private int numero;
    private int digito;
    private Agencia agencia;
    private double saldo;

    public ContaCorrente(int numero, int digito, Agencia agencia) {
        this.numero = numero;
        this.digito = digito;
        this.agencia = agencia;
        this.saldo = 0.0; // Inicializa o saldo como zero
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    // Métodos depositar e sacar
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Valor de saque inválido ou saldo insuficiente.");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public int getDigito() {
        return digito;
    }

    public void setDigito(int digito) {
        this.digito = digito;
    }

    public void imprimirSaldo() {
        System.out.println("Conta Corrente: " + numero + "-" + digito);
        System.out.println("Agência: " + agencia.getNumero() + "-" + agencia.getDigito());
        System.out.println("Saldo: R$ " + saldo);
    }

    public boolean validarDigito() {
        int[] pesos = {4, 6, 8, 2};
        int soma = 0;
        String numeroStr = String.format("%04d", numero); // Formata o número da conta para ter 4 dígitos

        for (int i = 0; i < numeroStr.length(); i++) {
            soma += Character.getNumericValue(numeroStr.charAt(i)) * pesos[i];
        }

        int digitoCalculado = soma % 11;
        if (digitoCalculado == 10) {
            digitoCalculado = 0;
        }

        return digitoCalculado == digito;
    }

    public void validarConta() {
        if (numero < 0 || numero > 9999) {
            System.out.println("Número da conta inválido. Deve ter no máximo 4 dígitos e ser positivo.");
        } else if (!validarDigito()) {
            System.out.println("Dígito da conta inválido.");
        } else {
            System.out.println("Conta válida.");
        }
    }
}