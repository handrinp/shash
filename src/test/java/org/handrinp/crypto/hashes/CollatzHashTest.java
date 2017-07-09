package org.handrinp.crypto.hashes;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

public class CollatzHashTest {
	@Test
	public void testHash() {
		Random rand = new Random();
		CollatzHash ch = new CollatzHash();
		byte[] original = new byte[256];
		byte[] twiceHashed;

		for (int test = 0; test < 50; ++test) {
			ch = new CollatzHash();
			rand.nextBytes(original);
			twiceHashed = ch.hash(ch.hash(original));

			for (int i = 0; i < original.length; ++i) {
				assertEquals(original[i], twiceHashed[i]);
			}
		}
	}
}
