package exemplo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.zip.CRC32;

public class Checksum {
    //Método Contrutor
    public Checksum(char c[]){
    }

    //determina o complemento de dois de um vetor de caracteres
    public String calcularComplemento2(char caracteres[]){
        //System.out.println(caracteres);
        int soma=0;
        String bin;
        int complementoDois, complementoUm;
        for(int i=0; i<caracteres.length; i++){
            soma += (int) caracteres[i];                //somando os valores inteiros de cada caractere
        }
        //normalizando o resultado (valor fixo de bits)
        soma = soma & 0xFF;       //8 bits

        //complemento de um 
        complementoUm = ~soma;

        //complemento de dois também normalizado
        complementoDois = (complementoUm+1) & 0xFF;
        //transformação do complemento de dois em caractere
        bin = Integer.toBinaryString(complementoDois);
        //System.out.println(bin);
        int valorInt = Integer.parseInt(bin, 2);
        //System.out.println(valorInt);
        char c = (char) valorInt;                       //caractere correspondente ao inteiro determinado
        String str = new String(caracteres);
        return str+c;                                   //concatenação da string de caracteres com o char do complemento de dois
    }
    //lendo caracteres do arquivo de texto
     public String leCharDoArquivoTexto(String caminhoArquivo){
        try{
            String conteudo = Files.readString(Paths.get(caminhoArquivo));                              //leitura do conteúdo inteiro do arquivo e armazená-lo em uma única String=> usar apenas para pequenos arquivos
            char[] dadosArquivo = conteudo.toCharArray();                                               //conteúdo do arquivo como array de caracteres para dar entrada ao complemento e dois
            return calcularComplemento2(dadosArquivo);                                                  //retorna o valor do complemento de dois 
        } catch (IOException e) {                                                                       //bloco de código executado quando houver erro 
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return "";
        }
    }

    //grava no arquivo de saída a partir de um arquivo de entrada
    public void gravaChecksumSeparado(String arquivoEntrada, String arquivoSaida) {
        try{
            // Lê conteúdo do arquivo de entrada
            String conteudo = Files.readString(Paths.get(arquivoEntrada));                              //leitura do conteúdo inteiro do arquivo => usar apenas para pequenos arquivos
            char[] dadosArquivo = conteudo.toCharArray();                                               //conteúdo do arquivo como array de caracteres 

            // Calcula checksum
            String checksum = calcularComplemento2(dadosArquivo);
            // Converte checksum para string e grava no arquivo de saída
            Files.writeString(Paths.get(arquivoSaida), checksum,                                        //grava o valor do chacksum no arquivo de saída 
                              StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);         //StandardOpenOptioN.CREAT: cria o arquivo se não existe;StandardOpenOption.
                                                                                                        //TRUNCATE_EXISTING: escreve sobre o arquivo já existente      

            System.out.println("Checksum gravado com sucesso em: " + arquivoSaida);
        } catch (IOException e) {
            System.out.println("Erro ao gravar arquivo: " + e.getMessage());
        }
    }
    //cálculo de CRC (Cyclic Redundancy Check)
    public long calcularCRC(char[] dados){
        CRC32 crc = new CRC32();
        String str = new String(dados);
        byte[] bytes = str.getBytes();
        crc.update(bytes, 0, bytes.length);
        long valorCRC = crc.getValue();
        //System.out.println(valorCRC);
        return valorCRC;
    }
}
