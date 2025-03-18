/*
 * Escrever, em Java, utilizandooperadores ternários, a classe
ValorEmTexto, cujos atributos únicos são:
a) valor, que é uma variável double, que armazenará um valor
monetário positivo, menor que R$1.000.000,00;
b) String textualiza(double valor), que receberá o conteúdo
numérico de valor como parâmetro e retornará uma String
equivalente ao valor textual da variável valor.
Ex.: double valor = 99.00;
String s = textualiza(valor);
s receberá “noventa e nove reais”
 */

 public class ex_2 {
    public static String textualiza(double valor) {
        if (valor < 0 || valor >= 1_000_000) {
            throw new IllegalArgumentException("Valor deve ser positivo e menor que R$1.000.000,00");
        }

        int inteiro = (int) valor;
        int centavos = (int) Math.round((valor - inteiro) * 100);

        String textoInteiro = converteNumero(inteiro);
        String textoCentavos = converteNumero(centavos);

        if (centavos > 0) {
            return textoInteiro + " reais e " + textoCentavos + " centavos";
        }
        return textoInteiro + " reais";
    }

    private static String converteNumero(int numero) {
        if (numero == 0) return "zero";

        String[] unidades = {"", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove"};
        String[] especiais = {"dez", "onze", "doze", "treze", "quatorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove"};
        String[] dezenas = {"", "dez", "vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa"};

        if (numero < 10) return unidades[numero];
        if (numero < 20) return especiais[numero - 10];

        int unidade = numero % 10;
        int dezena = numero / 10;
        return unidade == 0 ? dezenas[dezena] : dezenas[dezena] + " e " + unidades[unidade];
    }

    public static void main(String[] args) {
        System.out.println(textualiza(99.99)); // noventa e nove reais
    }
}
