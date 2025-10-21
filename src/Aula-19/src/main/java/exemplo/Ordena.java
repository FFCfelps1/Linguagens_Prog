package exemplo;

/**
 * Classe responsável por operações de ordenação de arrays
 */
public class Ordena {
    
    /**
     * Ordena um array de inteiros em ordem decrescente usando o algoritmo Bubble Sort
     * @param array Array de inteiros a ser ordenado
     */
    public void ordenaNumerosDecrescentes(int[] array) {
        // Percorre o array do segundo elemento até o final
        for (int i = 1; i < array.length; i++) {
            // Percorre o array de trás para frente até a posição atual
            for (int j = array.length - 1; j >= i; j--) {
                // Se o elemento anterior é menor que o atual, troca as posições
                if (array[j - 1] < array[j]) {
                    trocarElementos(array, j - 1, j);
                }
            }
        }
    }
    
    /**
     * Método auxiliar para trocar dois elementos de posição no array
     * @param array Array onde será feita a troca
     * @param indice1 Primeiro índice
     * @param indice2 Segundo índice
     */
    private void trocarElementos(int[] array, int indice1, int indice2) {
        int temp = array[indice1];
        array[indice1] = array[indice2];
        array[indice2] = temp;
    }
}
