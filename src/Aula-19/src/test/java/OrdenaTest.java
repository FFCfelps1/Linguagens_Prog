import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import exemplo.Ordena;

public class OrdenaTest {
    
    // Testa ordenação básica de dois elementos
    @Test
    public void testOrdenacaoDecrescente(){
        int[] proposto = {9, 10};
        int[] esperado = {10, 9};

        Ordena ordena = new Ordena();
        ordena.ordenaNumerosDecrescentes(proposto);

        assertArrayEquals(esperado, proposto, "O vetor não foi ordenado corretamente em ordem decrescente.");
    }

    // Verifica se o tamanho do vetor é preservado
    @Test
    public void testMesmoTamanho() {
        int[] proposto = {1, 2};
        int[] esperado = {2, 1};
        
        Ordena ordena = new Ordena();
        ordena.ordenaNumerosDecrescentes(proposto);
        
        assertEquals(esperado.length, proposto.length, "O tamanho do vetor deve permanecer o mesmo.");
        assertArrayEquals(esperado, proposto, "O vetor não foi ordenado corretamente.");
    }

    // Testa comportamento com números duplicados
    @Test
    public void testNumerosIguais() {
        int[] proposto = {5, 5};
        int[] esperado = {5, 5};

        Ordena ordena = new Ordena();
        ordena.ordenaNumerosDecrescentes(proposto);

        assertArrayEquals(esperado, proposto, "Vetores com números iguais não devem ser alterados.");
    }
    
    // Verifica se vetor vazio é tratado corretamente
    @Test
    public void testVetorVazio() {
        int[] proposto = {};
        int[] esperado = {};

        Ordena ordena = new Ordena();
        ordena.ordenaNumerosDecrescentes(proposto);

        assertArrayEquals(esperado, proposto, "Vetor vazio deve permanecer vazio.");
    }
    
    // Testa vetor com apenas um elemento
    @Test
    public void testUmElemento() {
        int[] proposto = {42};
        int[] esperado = {42};

        Ordena ordena = new Ordena();
        ordena.ordenaNumerosDecrescentes(proposto);

        assertArrayEquals(esperado, proposto, "Vetor com um elemento deve permanecer inalterado.");
    }
    
    // Verifica se vetor já ordenado permanece igual
    @Test
    public void testVetorJaOrdenado() {
        int[] proposto = {10, 8, 6, 4, 2};
        int[] esperado = {10, 8, 6, 4, 2};

        Ordena ordena = new Ordena();
        ordena.ordenaNumerosDecrescentes(proposto);

        assertArrayEquals(esperado, proposto, "Vetor já ordenado deve permanecer igual.");
    }
    
    // Testa inversão de vetor em ordem crescente
    @Test
    public void testVetorOrdemCrescente() {
        int[] proposto = {1, 3, 5, 7, 9};
        int[] esperado = {9, 7, 5, 3, 1};

        Ordena ordena = new Ordena();
        ordena.ordenaNumerosDecrescentes(proposto);

        assertArrayEquals(esperado, proposto, "Vetor em ordem crescente deve ser invertido.");
    }
    
    // Verifica ordenação de números negativos
    @Test
    public void testNumerosNegativos() {
        int[] proposto = {-1, -5, -3};
        int[] esperado = {-1, -3, -5};

        Ordena ordena = new Ordena();
        ordena.ordenaNumerosDecrescentes(proposto);

        assertArrayEquals(esperado, proposto, "Números negativos devem ser ordenados corretamente.");
    }
    
    // Testa ordenação com números positivos, negativos e zero
    @Test
    public void testNumerosMistos() {
        int[] proposto = {-2, 0, 5, -10, 3};
        int[] esperado = {5, 3, 0, -2, -10};

        Ordena ordena = new Ordena();
        ordena.ordenaNumerosDecrescentes(proposto);

        assertArrayEquals(esperado, proposto, "Números positivos, negativos e zero devem ser ordenados corretamente.");
    }
}