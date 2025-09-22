public class DebugChecksum {
    public static void main(String[] args) {
        String s = "Casa1";
        char[] data = s.toCharArray();
        
        System.out.println("Calculando checksum para: " + s);
        System.out.println("Caracteres:");
        
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            char c = data[i];
            int b = c % 256; // pega o byte baixo
            sum += b;
            System.out.println("  '" + c + "' -> ASCII " + (int)c + " -> byte baixo " + b);
        }
        
        System.out.println("Soma total: " + sum);
        sum = sum % 256;
        System.out.println("Soma módulo 256: " + sum + " (0x" + Integer.toHexString(sum).toUpperCase() + ")");
        
        int complement = (256 - sum) % 256;
        System.out.println("Complemento de 2: (256 - " + sum + ") % 256 = " + complement + " (0x" + Integer.toHexString(complement).toUpperCase() + ")");
        
        // Verificar se está igual ao método original
        int checksum = CheckSum.calcularChecksum(s);
        System.out.println("Resultado final: " + checksum + " (0x" + Integer.toHexString(checksum).toUpperCase() + ")");
    }
}
