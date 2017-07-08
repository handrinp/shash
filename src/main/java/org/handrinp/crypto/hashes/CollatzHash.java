package org.handrinp.crypto.hashes;

import java.math.BigInteger;
import java.util.Random;

import org.handrinp.crypto.Hash;
import org.handrinp.crypto.SingleKey;

public class CollatzHash implements SingleKey, Hash {
	private BigInteger key;

	public CollatzHash() {
		this.key = BigInteger.probablePrime(256, new Random());
	}

	public CollatzHash(byte[] key) {
		setKey(key);
	}

	public CollatzHash(BigInteger key) {
		setKey(key);
	}

	public void setKey(BigInteger key) {
		this.key = key;
	}

	public void setKey(byte[] key) {
		setKey(new BigInteger(key));
	}

	@Override
	public byte[] getKey() {
		return key.toByteArray();
	}

	protected static BigInteger collatz(BigInteger n) {
		// newN = (n << 1) + n + 1 = 2n + n + 1 = 3n + 1
		BigInteger newN = n.shiftLeft(1).add(n).add(BigInteger.ONE);
		return newN.shiftRight(newN.getLowestSetBit());
	}

	@Override
	public byte[] hash(byte[] input) {
		byte[] output = new byte[input.length];
		BigInteger curKey = new BigInteger(key.toByteArray());

		for (int i = 0; i < input.length; ++i) {
			output[i] = (byte) (input[i] ^ curKey.byteValue());
			curKey = collatz(curKey);

			if (curKey.equals(BigInteger.ONE)) {
				curKey = new BigInteger(key.toByteArray());
			}
		}

		return output;
	}
}
