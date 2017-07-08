package org.handrinp.crypto;

public interface Cipher {
	public byte[] encode(byte[] plaintext);

	public byte[] decode(byte[] ciphertext);
}
