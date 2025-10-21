
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import exemplo.Checksum;


public class TestChecksum{
    @Test
    public void testCalcularComplemento2(){
        //Teste 1: String "Casa1"
        //valor esperado: Casa1W
        char arrayChar[] = "Casa1".toCharArray();
        Checksum checksum1 = new Checksum(arrayChar);
        String resultado1 = checksum1.calcularComplemento2("Casa1".toCharArray());
        System.out.println(checksum1);

        assertEquals("Casa1W", resultado1);
    }


    @Test
    public void testLeCharDoArquivoTexto(){
        File arquivo = new File("teste_arquivo.txt");
        try(FileWriter writer = new FileWriter(arquivo)){
            writer.write("Casa1");
        }catch (IOException e){
            System.out.println("Erro ao criar arquivo: "+e.getMessage());
        }

        Checksum checksum = new Checksum(new char[]{});
        String resultado = checksum.leCharDoArquivoTexto(arquivo.getPath());

        assertEquals("Casa1W", resultado);
    }

    @Test
    public void testGravaChecksumSeparado(){
        File arquivoEntrada = new File("teste_arquivo.txt");
        File arquivoSaida = new File("teste_saida.txt");

        try(FileWriter writer = new FileWriter(arquivoEntrada)){
            writer.write("Casa1");
        } catch (IOException e){
            System.out.println("Erro ao criar arquivo de entrada: "+e.getMessage());
        }

        Checksum checksum = new Checksum(new char[]{});
        checksum.gravaChecksumSeparado(arquivoEntrada.getPath(), arquivoSaida.getPath());

        try{
            String conteudoSaida = Files.readString(Paths.get(arquivoSaida.getPath()));
            String valorGravado = conteudoSaida.trim();                                     //garante que não haja espaço nem quebra de linha após o número gravado            

            assertEquals("Casa1W", valorGravado);
        }catch(IOException e){
            System.out.println("Erro ao criar arquivo de entrada: "+e.getMessage());
        }

    }
    @Test
    public void testCalcularCRC(){
        Checksum checksum = new Checksum(null);
        //Dados de entrada de exemplo
        char[] dados = "Casa1".toCharArray();
        //O valor em CRC32 (em decimal) de referência para "Hello World"
        long esperadoCRC = 560253239;

        //Calcula o CRC com a sua implementação
        long atualCRC = checksum.calcularCRC(dados);

        //Compara o resultado com o valor esperado
        assertEquals(esperadoCRC, atualCRC);
    }

}
