import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import exemplo.Retangulo;

public class RetanguloTest {
    
    // Teste básico de cálculo de área
    @Test
    public void testCalculaArea(){
        int base = 5, altura = 2;
        Retangulo ret = new Retangulo(base, altura);
        assertEquals(10, ret.calculaArea());
    }
    
    // Teste básico de cálculo de perímetro
    @Test
    public void testCalculaPerimetro(){
        int base = 5, altura = 2;
        Retangulo ret = new Retangulo(base, altura);
        assertEquals(14, ret.calculaPerimetro());
    }
    
    // Teste com valores unitários
    @Test
    public void testCalculaAreaUnitaria(){
        int base = 1, altura = 1;
        Retangulo ret = new Retangulo(base, altura);
        assertEquals(1, ret.calculaArea());
    }
    
    // Teste com valores zero
    @Test
    public void testCalculaAreaComZero(){
        int base = 0, altura = 5;
        Retangulo ret = new Retangulo(base, altura);
        assertEquals(0, ret.calculaArea());
    }
    
    // Teste perímetro com valores grandes
    @Test
    public void testCalculaPerimetroGrande(){
        int base = 100, altura = 50;
        Retangulo ret = new Retangulo(base, altura);
        assertEquals(300, ret.calculaPerimetro());
    }
    
    // Teste quadrado (base = altura)
    @Test
    public void testQuadrado(){
        int lado = 4;
        Retangulo ret = new Retangulo(lado, lado);
        assertEquals(16, ret.calculaArea());
        assertEquals(16, ret.calculaPerimetro());
    }
}
