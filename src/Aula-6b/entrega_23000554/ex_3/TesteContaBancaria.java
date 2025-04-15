public class TesteContaBancaria {
    public static void main(String[] args) {
        // Criar uma conta bancária
        ContaBancaria conta = new ContaBancaria("12345-6", "João Silva", 1000.0);

        // Exibir informações iniciais da conta
        System.out.println("Informações iniciais da conta:");
        System.out.println("Número da Conta: " + conta.getNumeroConta());
        System.out.println("Titular: " + conta.getNomeTitular());
        System.out.println("Saldo: " + conta.getSaldo());

        // Realizar um depósito
        System.out.println("\nRealizando depósito de R$ 500.0...");
        conta.depositar(500.0);
        System.out.println("Saldo após depósito: " + conta.getSaldo());

        // Realizar um saque
        System.out.println("\nRealizando saque de R$ 300.0...");
        boolean saqueRealizado = conta.sacar(300.0);
        if (saqueRealizado) {
            System.out.println("Saque realizado com sucesso.");
        } else {
            System.out.println("Falha ao realizar o saque.");
        }
        System.out.println("Saldo após saque: " + conta.getSaldo());
    }
}