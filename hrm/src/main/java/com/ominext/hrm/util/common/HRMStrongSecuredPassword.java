package com.ominext.hrm.util.common;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class HRMStrongSecuredPassword {

	private HRMStrongSecuredPassword() {
	}

	/**
	 * @param originalPassword
	 * @param storedPassword
	 * @return
	 * @throws Exception
	 */
	public static boolean validatePassword(String originalPassword, String storedPassword)
			throws Exception {
		String[] parts = storedPassword.split(":");
		int iterations = Integer.parseInt(parts[0]);
		byte[] salt = fromHex(parts[1]);
		byte[] hash = fromHex(parts[2]);

		PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(), salt, iterations, hash.length * 8);

		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

		byte[] testHash = skf.generateSecret(spec).getEncoded();

		int diff = hash.length ^ testHash.length;

		for (int i = 0; i < hash.length && i < testHash.length; i++) {
			diff |= hash[i] ^ testHash[i];
		}

		return diff == 0;
	}

	/**
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public static String generateStrongPasswordHash(String password) throws Exception {
		int iterations = 1000;
		char[] chars = password.toCharArray();
		byte[] salt = getSalt().getBytes();

		PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		byte[] hash = skf.generateSecret(spec).getEncoded();
		return iterations + ":" + toHex(salt) + ":" + toHex(hash);

	}

	/**
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	private static String getSalt() throws NoSuchAlgorithmException {
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt = new byte[16];
		sr.nextBytes(salt);
		return salt.toString();
	}

	/**
	 * @param array
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	private static String toHex(byte[] array) throws NoSuchAlgorithmException {
		BigInteger bi = new BigInteger(1, array);
		String hex = bi.toString(16);
		int paddingLength = (array.length * 2) - hex.length();
		if (paddingLength > 0) {
			return String.format("%0" + paddingLength + "d", 0) + hex;
		} else {
			return hex;
		}
	}

	/**
	 * @param hex
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	private static byte[] fromHex(String hex) throws NoSuchAlgorithmException {
		byte[] bytes = new byte[hex.length() / 2];
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
		}
		return bytes;
	}
}
