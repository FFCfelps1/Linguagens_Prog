/*
 * Desenvolver, baseado nos conceitos de Testes Unitários, uma
 * classe de testes unitários para a classe Checksum, capaz de
 * realizar os testes unitários e automatizados de todos os métodos
 * da classe Checksum (exceto do construtor).
 */

// ChecksumTest.java

import java.nio.file.Files;
import java.nio.file.Path;

public class TestCheckSum {

    // Método auxiliar para verificar igualdade de inteiros
    private static void assertEquals(int expected, int actual, String message) {
        if (expected == actual) {
            System.out.println("PASSOU: " + message + " (esperado: " + expected + ", obtido: " + actual + ")");
        } else {
            System.out.println("FALHOU: " + message + " (esperado: " + expected + ", obtido: " + actual + ")");
        }
    }

    // Método auxiliar para verificar igualdade de strings
    private static void assertEquals(String expected, String actual, String message) {
        if (expected.equals(actual)) {
            System.out.println("PASSOU: " + message + " (esperado: " + expected + ", obtido: " + actual + ")");
        } else {
            System.out.println("FALHOU: " + message + " (esperado: " + expected + ", obtido: " + actual + ")");
        }
    }

    // Método auxiliar para verificar condições booleanas
    private static void assertTrue(boolean condition, String message) {
        if (condition) {
            System.out.println("PASSOU: " + message);
        } else {
            System.out.println("FALHOU: " + message);
        }
    }

    public static void exemploCasa1_checksum() {
        String s = "Casa1";
        int expected = 0x57; // conforme exemplo das aulas (Soma + Complemento de 2)
        int got = CheckSum.calcularChecksum(s);
        assertEquals(expected, got, "Checksum de 'Casa1' deve ser 0x57 conforme exemplo.");
    }

    public static void calcularChecksumDoArquivoTexto_escreveArquivoComChecksum() throws Exception {
        Path tmpIn = Path.of("checksum-in.txt");
        Path tmpOut = Path.of("checksum-out.txt");
        
        String content = "Casa1";
        Files.write(tmpIn, content.getBytes());
        int cs = CheckSum.calcularChecksumDoArquivoTexto(tmpIn, tmpOut);
        // verificar checksum esperado
        assertEquals(0x57, cs, "Checksum deve ser 0x57 para 'Casa1'");
        // verificar que arquivo de saída termina com 0x57
        String out = new String(Files.readAllBytes(tmpOut));
        assertTrue(out.endsWith("0x57"), "Arquivo de saída deve terminar com o checksum 0x57");
        System.out.println("  Conteúdo gravado em checksum-out.txt: " + out);
    }

    public static void calcularCRC_pequenoVetor() {
        byte[] data = new byte[] {0x01, 0x02, 0x03, 0x04};
        int crc = CheckSum.calcularCRC(data);
        // aqui fazemos apenas uma verificação básica: crc deve estar no range 0..65535
        assertTrue(crc >= 0 && crc <= 0xFFFF, "CRC deve estar entre 0 e 65535");
        System.out.println("  CRC calculado: 0x" + Integer.toHexString(crc).toUpperCase());
    }

    public static void calcularChecksum_vazio() {
        assertEquals(0, CheckSum.calcularChecksum(""), "Checksum de string vazia deve ser 0");
    }

    public static void calcularChecksum_null() {
        assertEquals(0, CheckSum.calcularChecksum((String)null), "Checksum de null deve ser 0");
    }

    public static void toHexByte_funciona() {
        assertEquals("0x00", CheckSum.toHexByte(0), "toHexByte(0) deve retornar '0x00'");
        assertEquals("0xFF", CheckSum.toHexByte(255), "toHexByte(255) deve retornar '0xFF'");
        assertEquals("0x01", CheckSum.toHexByte(257), "toHexByte(257) deve retornar '0x01' (257 % 256 = 1)");
    }

    public static void toHexWord_funciona() {
        assertEquals("0x0000", CheckSum.toHexWord(0), "toHexWord(0) deve retornar '0x0000'");
        assertEquals("0xFFFF", CheckSum.toHexWord(65535), "toHexWord(65535) deve retornar '0xFFFF'");
        assertEquals("0x0001", CheckSum.toHexWord(65537), "toHexWord(65537) deve retornar '0x0001' (65537 % 65536 = 1)");
    }

    public static void main(String[] args) {
        System.out.println("=== EXECUTANDO TESTES DA CLASSE CheckSum ===\n");
        
        try {
            System.out.println("1. Testando calcularChecksum com 'Casa1':");
            exemploCasa1_checksum();
            
            System.out.println("\n2. Testando calcularChecksum com string vazia:");
            calcularChecksum_vazio();
            
            System.out.println("\n3. Testando calcularChecksum com null:");
            calcularChecksum_null();
            
            System.out.println("\n4. Testando calcularChecksumDoArquivoTexto:");
            calcularChecksumDoArquivoTexto_escreveArquivoComChecksum();
            
            System.out.println("\n5. Testando calcularCRC:");
            calcularCRC_pequenoVetor();
            
            System.out.println("\n6. Testando toHexByte:");
            toHexByte_funciona();
            
            System.out.println("\n7. Testando toHexWord:");
            toHexWord_funciona();
            
            System.out.println("\n=== TESTES CONCLUÍDOS ===");
            
        } catch (Exception e) {
            System.out.println("✗ ERRO durante execução dos testes: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
