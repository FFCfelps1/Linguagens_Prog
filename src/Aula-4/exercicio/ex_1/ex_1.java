public class ex_1 {
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

        switch (numero) {
            case 10: return "dez";
            case 11: return "onze";
            case 12: return "doze";
            case 13: return "treze";
            case 14: return "quatorze";
            case 15: return "quinze";
            case 16: return "dezesseis";
            case 17: return "dezessete";
            case 18: return "dezoito";
            case 19: return "dezenove";
        }

        int unidade = numero % 10;
        int dezena = numero / 10;
        String texto = "";

        switch (dezena) {
            case 1: texto = "dez"; break;
            case 2: texto = "vinte"; break;
            case 3: texto = "trinta"; break;
            case 4: texto = "quarenta"; break;
            case 5: texto = "cinquenta"; break;
            case 6: texto = "sessenta"; break;
            case 7: texto = "setenta"; break;
            case 8: texto = "oitenta"; break;
            case 9: texto = "noventa"; break;
        }

        if (unidade > 0) {
            switch (unidade) {
                case 1: texto += " e um"; break;
                case 2: texto += " e dois"; break;
                case 3: texto += " e três"; break;
                case 4: texto += " e quatro"; break;
                case 5: texto += " e cinco"; break;
                case 6: texto += " e seis"; break;
                case 7: texto += " e sete"; break;
                case 8: texto += " e oito"; break;
                case 9: texto += " e nove"; break;
            }
        }
        
        return texto;
    }

    public static void main(String[] args) {
        System.out.println(textualiza(99.99)); // noventa e nove reais e noventa e nove centavos
    }
}
