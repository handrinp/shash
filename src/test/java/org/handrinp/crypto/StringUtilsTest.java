package org.handrinp.crypto;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import org.handrinp.crypto.StringUtils;

public class StringUtilsTest {
	@Test
	public void testFromBytes() {
		byte[] bytes = new byte[] { (byte) 72, (byte) 101, (byte) 108, (byte) 108, (byte) 111, };

		assertEquals("Hello", StringUtils.bytesToString(bytes));
	}

	@Test
	public void testFromString() {
		byte[] bytes = new byte[] { (byte) 72, (byte) 101, (byte) 108, (byte) 108, (byte) 111, };

		byte[] testBytes = StringUtils.stringToBytes("Hello");

		for (int i = 0; i < bytes.length; ++i) {
			assertEquals(bytes[i], testBytes[i]);
		}
	}

	@Test
	public void testBothWays() {
		String start = "This is a starting <code>String</code>!!! - wish me luck :)";
		assertEquals(start, StringUtils.bytesToString(StringUtils.stringToBytes(start)));
	}
}
