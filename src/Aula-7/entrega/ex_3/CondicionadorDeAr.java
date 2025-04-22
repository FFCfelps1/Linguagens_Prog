/*O ar condicionado, deve fazer o papel de ver se o Termostato deve funcionar ou não indicando se ele está ligado
 * ou não. O ar condicionado deve ter um método que liga o termostato, um método que desliga o termostato
 */

public class CondicionadorDeAr {
    private boolean ligado;
    private Termostato termostato;

    public CondicionadorDeAr() {
        this.ligado = false;
        this.termostato = new Termostato();
    }

    public void ligar() {
        this.ligado = true;
        System.out.println("Condicionador de ar ligado.");
    }
    
    public void desligar() {
        this.ligado = false;
        System.out.println("Condicionador de ar desligado.");
    }

    public boolean isLigado() {
        return ligado;
    }

    public Termostato getTermostato() {
        return termostato;
    }
}