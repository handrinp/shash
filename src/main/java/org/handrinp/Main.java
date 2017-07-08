package org.handrinp;

import java.util.Scanner;

import org.handrinp.crypto.Shash;
import org.handrinp.crypto.hashes.CollatzHash;

public class Main {
	public static void main(String[] args) {
		Shash col = new Shash(new CollatzHash());
		System.out.print("Input: ");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		in.close();
		String hashed = col.hash(input);
		System.out.println("Output: " + hashed);
		System.out.println("Rehashed: " + col.hash(hashed));
	}
}
