// Importação da classe Scanner para entrada de dados
import java.util.Scanner;

public class Teste {
    // Criação de um objeto Scanner para ler a entrada do usuário
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Relogio relogio = new Relogio();
    
        for (int i = 0; i < 1440; i++) {
            // Simular a passagem de 1 minuto
            try {
                Thread.sleep(900); // Pausa por 1 minuto (1000 ms)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    
            // Incrementar o tempo no relógio
            relogio.ticTac(1); // Passa o valor 1 para indicar 1 minuto

            // Verificar se é AM ou PM e mostrar
            String periodo = (relogio.hora.getValor() < 12) ? "AM" : "PM";
            System.out.println(relogio.mostra()+ " " + periodo);
        }
        scanner.close();
    }
}