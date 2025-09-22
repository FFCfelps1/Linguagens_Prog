// Checksum.java

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CheckSum {

    /**
     * Calcula checksum por Soma + Complemento de 2 (8-bit).
     * Recebe vetor de caracteres; usa o byte baixo (ASCII/UTF-8 compatível) de cada caractere.
     * Retorna valor 0..255 (int).
     */
    public static int calcularChecksum(char[] data) {
        int sum = 0;
        for (char c : data) {
                int b = c % 256; // pega o byte baixo
            sum += b;
            // se houver overflow além de 8 bits descarta o bit excedente automaticamente pela máscara abaixo
        }
            // manter apenas 8 bits (descartar MSB excedente)
            sum = sum % 256;

            // complemento de 2
            int complement = (256 - sum) % 256;
        return complement;
    }

    /** Sobrecarga útil */
    public static int calcularChecksum(String s) {
        if (s == null) return calcularChecksum(new char[0]);
        return calcularChecksum(s.toCharArray());
    }

    /**
     * Lê arquivo texto (usa bytes conforme arquivo), calcula checksum (Soma+Complemento2)
     * e grava em arquivo de saída: conteúdo original seguido pelo checksum em hex (por exemplo "0x57").
     * Retorna o checksum calculado (0..255).
     */
    public static int calcularChecksumDoArquivoTexto(Path entrada, Path saida) throws IOException {
        byte[] bytes = Files.readAllBytes(entrada);
        int sum = 0;
        for (byte bb : bytes) {
                sum += (bb % 256);
        }
            sum = sum % 256;
            int complement = (256 - sum) % 256;

        // Escrever conteúdo original e logo após o checksum em formato hex (por exemplo 0x57)
        // Mantemos o mesmo encoding dos bytes lidos.
        String checksumHex = String.format("0x%02X", complement);
        byte[] out = new byte[bytes.length + checksumHex.getBytes().length];
        System.arraycopy(bytes, 0, out, 0, bytes.length);
        System.arraycopy(checksumHex.getBytes(), 0, out, bytes.length, checksumHex.getBytes().length);
        Files.write(saida, out);
        return complement;
    }

    /**
     * CRC-16/CCITT (polynomial 0x1021), initial value 0xFFFF, no_reflection, no_xorout (padrão CCITT).
     * Retorna int 0..65535
     */
    public static int calcularCRC(byte[] data) {
        int crc = 0xFFFF;
        int poly = 0x1021;
        for (byte b : data) {
                int cur = (b % 256) << 8;
            crc ^= cur;
            for (int i = 0; i < 8; i++) {
                    if ((crc % 65536) >= 0x8000) {
                        crc = (((crc << 1) ^ poly) % 65536);
                    } else {
                        crc = ((crc << 1) % 65536);
                    }
            }
        }
            return crc % 65536;
    }

    // Métodos auxiliares opcionais:
    public static String toHexByte(int v) {
    return String.format("0x%02X", v % 256);
    }

    public static String toHexWord(int v) {
    return String.format("0x%04X", v % 65536);
    }
}
