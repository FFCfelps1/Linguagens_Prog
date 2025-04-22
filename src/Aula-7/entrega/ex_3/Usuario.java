/* c) Crie a classe Usuario, com o método main(). Neste método você deve instanciar um CondicionadorDeAr,
aumentar a temperatura para 30 graus (receber mensagem de erro), reduzir a temperatura para 10 graus
(receber mensagem de erro). Aumentar a temperatura para 25 graus e imprimir a temperatura.
*/

public class Usuario {
    public static void main(String[] args) {
        CondicionadorDeAr arCondicionado = new CondicionadorDeAr();
        
        // Tentar aumentar a temperatura para 30 graus
        for (int i = 0; i < 11; i++) {
            arCondicionado.getTermostato().aumentarTemperatura();
        }
        
        // Tentar reduzir a temperatura para 10 graus
        for (int i = 0; i < 16; i++) {
            arCondicionado.getTermostato().reduzirTemperatura();
        }
        
        // Aumentar a temperatura para 25 graus e imprimir
        for (int i = 0; i < 10; i++) {
            arCondicionado.getTermostato().aumentarTemperatura();
        }
        
        arCondicionado.getTermostato().imprimirTemperatura();
    }
}