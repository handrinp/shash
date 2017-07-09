package org.handrinp.crypto;

import java.nio.charset.Charset;

public class StringUtils {
	public static final Charset CHARSET = Charset.defaultCharset();

	public static String bytesToString(byte[] bytes) {
		return new String(bytes, CHARSET);
	}

	public static byte[] stringToBytes(String string) {
		return string.getBytes(CHARSET);
	}
}
