public class ContaBancaria {
    private String numeroConta;
    private String nomeTitular;
    private double saldo;

    // Construtor
    public ContaBancaria(String numeroConta, String nomeTitular, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.saldo = saldoInicial >= 0 ? saldoInicial : 0; // Garante que o saldo inicial não seja negativo
    }

    // Métodos de acesso (getters)
    public String getNumeroConta() {
        return numeroConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    // Métodos modificadores (setters)
    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            System.out.println("O saldo não pode ser negativo.");
        }
    }

    // Método para depositar valores
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            System.out.println("O valor do depósito deve ser positivo.");
        }
    }

    // Método para sacar valores
    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return true; // Saque realizado com sucesso
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para saque.");
            return false; // Saque não realizado
        }
    }
}