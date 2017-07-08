package org.handrinp.crypto.hashes;

import static org.junit.Assert.assertEquals;

import org.handrinp.crypto.StringUtils;
import org.junit.Test;

public class CollatzHashTest {
	@Test
	public void testHash() {
		CollatzHash ch = new CollatzHash();
		String message = "This is a good test message... wish it luck!";
		byte[] unhashed = StringUtils.fromString(message);
		byte[] hashed = ch.hash(unhashed);
		byte[] rehashed = ch.hash(hashed);

		for (int i = 0; i < unhashed.length; ++i) {
			assertEquals(unhashed[i], rehashed[i]);
		}
	}
}
