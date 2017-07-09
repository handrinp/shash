package org.handrinp.crypto;

public class Shash {
	private Hash hash;

	public Shash(Hash hash) {
		this.hash = hash;
	}

	public void setHash(Hash hash) {
		this.hash = hash;
	}

	public Hash getHash() {
		return hash;
	}

	public String hash(String input) {
		byte[] hashable = StringUtils.fromString(input);
		byte[] hashed = hash.hash(hashable);
		return StringUtils.fromBytes(hashed);
	}
}
