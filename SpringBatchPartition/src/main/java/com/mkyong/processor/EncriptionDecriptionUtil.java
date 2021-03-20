package com.mkyong.processor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncriptionDecriptionUtil {
	private static final String CLASS_NAME = "EncriptionDecriptionUtil";
	private final static String algorithm = "AES";
	private final static Charset charset = StandardCharsets.UTF_8;
	private final static byte[] keyValue = "WJNPADUU23659524".getBytes(charset);

	public static SecretKeySpec generateKey(final byte[] decryptionKey) {
		String mtd = CLASS_NAME + " | setKey | ";
		System.out.println(mtd + "START");
		SecretKeySpec secretKey = new SecretKeySpec(decryptionKey, algorithm);
		System.out.println(mtd + "END");
		return secretKey;
	}

	public static String encrypt(final String valueToEncrypt) {
		String mtd = CLASS_NAME + " | encrypt | ";
		System.out.println(mtd + "START");
		try {
			SecretKeySpec secretKey = generateKey(keyValue);
			Cipher cipher = Cipher.getInstance(algorithm);
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			System.out.println(mtd + "END");
			return Base64.getEncoder().encodeToString(cipher.doFinal(valueToEncrypt.getBytes(charset)));
		} catch (Exception e) {
			System.err.println(mtd + e);
			e.printStackTrace();
		}
		System.out.println(mtd + "END");
		return null;
	}

	private static String decrypt(final String valueToEncrypt, final byte[] decryptionKey) {
		String mtd = CLASS_NAME + " | decrypt | ";
		System.out.println(mtd + "START");
		try {
			SecretKeySpec secretKey = generateKey(decryptionKey);
			Cipher cipher = Cipher.getInstance(algorithm);
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			System.out.println(mtd + "END");
			return new String(cipher.doFinal(Base64.getDecoder().decode(valueToEncrypt.getBytes(charset))));
		} catch (Exception e) {
			System.err.println(mtd + e);
			e.printStackTrace();
		}
		System.out.println(mtd + "END");
		return null;
	}

	public static String getDecryptedPassword(final String authFile, final String encryptedPassword) {
		String mtd = CLASS_NAME + " | getBufferedReader | ";
		String decryptedPassword = null;
		BufferedReader bufferedReader;
		try {
			bufferedReader = new BufferedReader(new FileReader(new File(authFile)));
			String encryptionKey = bufferedReader.readLine();
			if (encryptionKey != null) {
				decryptedPassword = decrypt(encryptedPassword, encryptionKey.getBytes(charset));
			} else {
				System.out.println(mtd + " No encryption key found in file " + authFile);
			}
			bufferedReader.close();
			return decryptedPassword;
		} catch (Exception ex) {
			System.err.println(mtd + " Something went wrong while decrypting password." + ex);
			ex.printStackTrace();
		}
		return null;
	}

	public static String getEncodedAuthKey(final String userName, final String password) {
		return Base64.getEncoder().encodeToString((userName + ":" + password).getBytes(charset));
	}
}
