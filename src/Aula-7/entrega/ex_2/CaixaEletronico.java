/*
 * e) Para testar, faça uma classe CaixaEletronico, que irá conter o método main(). Nele, instancie um cliente com os seguintes dados:
 * Nome: Ademar Apior
 * CPF: 123231518-12
 * Conta Corrente: 1234 Dígito: 4
 * Agencia: 7890 Dígito: 5
 * Saldo Inicial: 150.00
 * 
 * Operações:
 * - sacar 140.0 (sucesso);
 * - consultar saldo (resultado é 10.0);
 * - sacar 200.0 (falha);
 * - consultar saldo (resultado é 10.0);
 * - depositar 25.45 (sucesso);
 * - imprimir saldo (além dos dados de cliente, conta e agencia, o saldo deve ser 35.45).
 */

public class CaixaEletronico {
    public static void main(String[] args) {
        // Criação da agência
        Agencia agencia = new Agencia("Agência Central", 7890, 5);

        // Criação da conta corrente
        ContaCorrente conta = new ContaCorrente(1234, 4, agencia);
        conta.depositar(150.00); // Depósito inicial

        // Criação do cliente
        Cliente cliente = new Cliente("Ademar Apior", "123231518-12", conta);

        // Exibição dos dados do cliente e saldo da conta
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        cliente.getConta().imprimirSaldo();

        // Operações
        System.out.println("\nRealizando operações...\n");

        // Saque de 140.0 (sucesso)
        conta.sacar(140.0);
        System.out.println("Saque de 140.0 realizado com sucesso.");

        // Consulta de saldo (resultado é 10.0)
        System.out.println("Saldo atual: " + conta.getSaldo());

        // Saque de 200.0 (falha)
        conta.sacar(200.0);
        System.out.println("Tentativa de saque de 200.0 falhou.");

        // Consulta de saldo (resultado é 10.0)
        System.out.println("Saldo atual: " + conta.getSaldo());

        // Depósito de 25.45 (sucesso)
        conta.depositar(25.45);
        System.out.println("Depósito de 25.45 realizado com sucesso.");

        // Imprimir saldo (além dos dados de cliente, conta e agência, o saldo deve ser 35.45)
        System.out.println("Dados da conta após depósito:");
        cliente.getConta().imprimirSaldo();
    }
}