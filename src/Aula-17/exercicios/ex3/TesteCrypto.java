// Classe "TesteCrypto.java"
import java.io.File;

public class TesteCrypto
{
	public static void main(String[] args) throws Exception
	{
		// Lê o texto claro de um arquivo .txt
		String caminhoArquivo = "texto.txt";
		String sMsgClara = "";
		try {
			sMsgClara = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(caminhoArquivo)), "ISO-8859-1");
		} catch (java.io.IOException e) {
			System.out.println("Erro ao ler o arquivo: " + e.getMessage());
			return;
		}
	String sMsgCifrada = null;
	String sMsgDecifrada = null;
	byte[] bMsgClara = null;
	byte[] bMsgCifrada = null;
	byte[] bMsgDecifrada = null;
	Impressora prn = new Impressora();
	StringBuilder log = new StringBuilder();
	log.append("--------------------------------------------------------------------------\n");
	log.append(">>> Imprimindo mensagem original...\n\n");
	bMsgClara = sMsgClara.getBytes("ISO-8859-1");
	log.append("Mensagem Clara (Hexadecimal):\n");
	log.append(prn.hexBytesToString(bMsgClara)).append("\n");
	log.append("Mensagem Clara (String):\n");
	log.append(sMsgClara).append("\n\n");

		/*
		 * Criptografia Dummy ---------------------------------------------------
		 */
	log.append(">>> Cifrando com o algoritmo Dummy...\n\n");

		// Instancia um objeto da classe CryptoDummy
		CryptoDummy cdummy = new CryptoDummy();
		// Gera a chave criptografica Dummy simetrica e nome do arquivo onde sera armazenada
		cdummy.geraChave(new File("chave.dummy"));
		// Gera a cifra Dummy da mensagem dada, com a chave Dummy simetrica dada
		cdummy.geraCifra(bMsgClara, new File("chave.dummy"));
		// Recebe o texto cifrado
		bMsgCifrada = cdummy.getTextCifrado();
		// Converte o texto byte[] no equivalente String
		sMsgCifrada = (new String(bMsgCifrada, "ISO-8859-1"));
	log.append("Mensagem Cifrada (Hexadecimal):\n");
	log.append(prn.hexBytesToString(bMsgCifrada)).append("\n");
	log.append("Mensagem Cifrada (String):\n");
	log.append(sMsgCifrada).append("\n\n");

	log.append(">>> Decifrando com o algoritmo Dummy...\n\n");
		// Gera a decifra Dummy da mensagem dada, segundo a chave Dummy simetrica gerada
		cdummy.geraDecifra(bMsgCifrada, new File("chave.dummy"));
		// recebe o texto decifrado
		bMsgDecifrada = cdummy.getTextoDecifrado();
		// Converte o texto byte[] no equivalente String
		sMsgDecifrada = (new String(bMsgDecifrada, "ISO-8859-1"));
	log.append("Mensagem Decifrada (Hexadecimal):\n");
	log.append(prn.hexBytesToString(bMsgDecifrada)).append("\n");
	log.append("Mensagem Decifrada (String):\n");
	log.append(sMsgDecifrada).append("\n\n");

		/*
		 * Criptografia AES -----------------------------------------------------
		 */
	log.append(">>> Cifrando com o algoritmo AES...\n\n");

		// Instancia um objeto da classe CryptoAES
		CryptoAES caes = new CryptoAES();
		// Gera a Chave criptografica AES simetrica e o nome do arquivo onde será armazenada
		caes.geraChave(new File("chave.simetrica"));
		// Gera a cifra AES da mensagem dada, com a chave simetrica dada
		caes.geraCifra(bMsgClara, new File("chave.simetrica"));
		// Recebe o texto cifrado
		bMsgCifrada = caes.getTextoCifrado();
		// Converte o texto byte[] no equivalente String
		sMsgCifrada = (new String(bMsgCifrada, "ISO-8859-1"));
	log.append("Mensagem Cifrada (Hexadecimal):\n");
	log.append(prn.hexBytesToString(bMsgCifrada)).append("\n");
	log.append("Mensagem Cifrada (String):\n");
	log.append(sMsgCifrada).append("\n\n");

	log.append(">>> Decifrando com o algoritmo AES...\n\n");
		// Gera a decifra AES da mensagem dada, segundo a chave simetrica gerada
		caes.geraDecifra(bMsgCifrada, new File("chave.simetrica"));
		// recebe o texto decifrado
		bMsgDecifrada = caes.getTextoDecifrado();
		// Converte o texto byte[] no equivalente String
		sMsgDecifrada = (new String(bMsgDecifrada, "ISO-8859-1"));
	log.append("Mensagem Decifrada (Hexadecimal):\n");
	log.append(prn.hexBytesToString(bMsgDecifrada)).append("\n");
	log.append("Mensagem Decifrada (String):\n");
	log.append(sMsgDecifrada).append("\n\n");

		/*
		 * Criptografia RSA -----------------------------------------------------
		 */
	log.append(">>> Cifrando com o algoritmo RSA...\n\n");

		// Instancia um objeto da classe CryptoRSA
		CryptoRSA crsa = new CryptoRSA();
		// Gera as Chaves criptografica RSA publica e privada e os arquivos onde armazenar
		crsa.geraParDeChaves(new File("chave.publica"), new File("chave.privada"));
		// Gera a cifra RSA da mensagem dada, segundo a chave publica gerada
		crsa.geraCifra(bMsgClara, new File("chave.publica"));
		// Recebe o texto cifrado
		bMsgCifrada = crsa.getTextoCifrado();
		// Converte o texto byte[] no equivalente String
		sMsgCifrada = (new String(bMsgCifrada, "ISO-8859-1"));
	log.append("Mensagem Cifrada (Hexadecimal):\n");
	log.append(prn.hexBytesToString(bMsgCifrada)).append("\n");
	log.append("Mensagem Cifrada (String):\n");
	log.append(sMsgCifrada).append("\n\n");

	log.append(">>> Decifrando com o algoritmo RSA...\n\n");
		// Gera a decifra RSA da mensagem dada, segundo a chave privada gerada
		crsa.geraDecifra(bMsgCifrada, new File("chave.privada"));
		// recebe o texto decifrado
		bMsgDecifrada = crsa.getTextoDecifrado();
		// Converte o texto byte[] no equivalente String
		sMsgDecifrada = (new String(bMsgDecifrada, "ISO-8859-1"));
	log.append("Mensagem Decifrada (Hexadecimal):\n");
	log.append(prn.hexBytesToString(bMsgDecifrada)).append("\n");
	log.append("Mensagem Decifrada (String):\n");
	log.append(sMsgDecifrada).append("\n\n");
		// Salva todo o log em um arquivo texto
		try (java.io.FileWriter writer = new java.io.FileWriter("resultado.txt", false)) {
			writer.write(log.toString());
		} catch (java.io.IOException e) {
			// Não printa nada no console
		}
	}
}
