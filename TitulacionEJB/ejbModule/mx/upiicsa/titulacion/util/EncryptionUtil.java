package mx.upiicsa.titulacion.util;

import mx.upiicsa.titulacion.common.constantes.Constants;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.util.password.BasicPasswordEncryptor;

public class EncryptionUtil {

	public static String encriptarPassword(final String password) {
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		return passwordEncryptor.encryptPassword(password);
	}

	public static String encriptarCadena(String cadenaOrigen) {
		StandardPBEStringEncryptor stringEncryptor = new StandardPBEStringEncryptor();
		stringEncryptor.setProvider(new BouncyCastleProvider());
		stringEncryptor.setAlgorithm(Constants.TITULACION_ENCRYPTION_ALGORITHM);
		stringEncryptor.setPassword(Constants.TITULACION_ENCRYPTION_PASSWORD);
		return stringEncryptor.encrypt(cadenaOrigen);
	}
}
