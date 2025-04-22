/*
 * Crie um método aumentarTemperatura(), que aumenta a temperatura do termostato em um grau cada vez que é
 * chamado, até o limite de 28 graus. Crie um método reduzirTemperatura(), que reduz a temperatura em um
 * grau cada vez que é chamado, até o limite de 15 graus. Crie um método imprimirTemperatura(), que imprime a
 * temperatura atual. Não se esqueça de verificar se o condicionador está ligado antes de aumentar ou diminuir 
 * a temperatura ou imprimi-la;
 */

public class Termostato {

    private int temperatura;

    public Termostato() {
        this.temperatura = 20; // Temperatura inicial
    }

    public void aumentarTemperatura() {
        if (temperatura < 28) {
            temperatura++;
        } else {
            System.out.println("Temperatura já está no máximo de 28 graus.");
        }
    }

    public void reduzirTemperatura() {
        if (temperatura > 15) {
            temperatura--;
        } else {
            System.out.println("Temperatura já está no mínimo de 15 graus.");
        }
    }

    public void imprimirTemperatura() {
        System.out.println("Temperatura atual: " + temperatura + " graus.");
    }
}