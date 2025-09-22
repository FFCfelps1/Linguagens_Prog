// Classe "CryptoAES.java"
import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.security.cert.*;

public class CryptoAES {
	private byte[] textoCifrado;
	private byte[] textoDecifrado;

	public CryptoAES() {
		textoCifrado = null;
		textoDecifrado = null;
	}

	public void geraChave(File fSim)
		throws IOException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
			   CertificateException, KeyStoreException {
		// Gera uma chave simetrica de 128 bits:
		KeyGenerator kg = KeyGenerator.getInstance("AES");
		kg.init(128);
		SecretKey sk = kg.generateKey();
		// Grava a chave simetrica em formato serializado
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fSim));
		oos.writeObject(sk);
		oos.close();
	}

	public void geraCifra(byte[] texto, File fSim)
		throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			   IllegalBlockSizeException, BadPaddingException,
			   InvalidAlgorithmParameterException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fSim));
		SecretKey isim = (SecretKey) ois.readObject();
		byte[] chave = isim.getEncoded();
		ois.close();
		Cipher aescf = Cipher.getInstance("AES/CBC/PKCS5Padding");
		IvParameterSpec ivspec = new IvParameterSpec(new byte[16]);
		aescf.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(chave, "AES"), ivspec);
		textoCifrado = aescf.doFinal(texto);
	}

	public byte[] getTextoCifrado() throws Exception {
		return textoCifrado;
	}

	public void geraDecifra(byte[] texto, File fSim)
		throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			   IllegalBlockSizeException, BadPaddingException,
			   InvalidAlgorithmParameterException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fSim));
		SecretKey isim = (SecretKey) ois.readObject();
		ois.close();
		Cipher aescf = Cipher.getInstance("AES/CBC/PKCS5Padding");
		IvParameterSpec ivspec = new IvParameterSpec(new byte[16]);
		aescf.init(Cipher.DECRYPT_MODE, isim, ivspec);
		textoDecifrado = aescf.doFinal(texto);
	}

	public byte[] getTextoDecifrado() throws Exception {
		return textoDecifrado;
	}
}
