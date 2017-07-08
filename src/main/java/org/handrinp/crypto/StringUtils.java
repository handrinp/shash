package org.handrinp.crypto;

public class StringUtils {
	public static String fromBytes(byte[] bytes) {
		char[] chars = new char[bytes.length];

		for (int i = 0; i < bytes.length; ++i) {
			chars[i] = (char) bytes[i];
		}

		return new String(chars);
	}

	public static byte[] fromString(String string) {
		byte[] bytes = new byte[string.length()];

		for (int i = 0; i < bytes.length; ++i) {
			bytes[i] = (byte) string.charAt(i);
		}

		return bytes;
	}
}
