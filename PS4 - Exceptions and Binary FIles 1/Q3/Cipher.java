class EmptyPlainText extends Exception {
	public EmptyPlainText() {
		super("Error: Nothing to encrypt!");
	}
}

class UselessKeyException extends Exception {
	private int uselessKey;
	public UselessKeyException(int uselessKey) {
		super("Error: Key is divisible by 26. That's a bad key!");
		this.uselessKey = uselessKey;
	}

	public int getUselessKey() {
		return uselessKey;
	}
}

public class Cipher {
	private final String plainText;
	private String cipherText;
	private int key;
	private char vanillaChar;

	// constructor
	public Cipher(String txt, int key) throws EmptyPlainText, UselessKeyException {
		if (txt.length() == 0) {
			throw new EmptyPlainText();
		} else {
			plainText = txt;
		}
		if (key % 26 == 0) {
			throw new UselessKeyException(key);
		} else {
			this.key = key;
		}

		encrypt(plainText, key);
	}

	// getter methods
	public String getPlainText() {
		return plainText;
	}
	public String getCipherText() {
		return cipherText;
	}
	public int getKey() {
		return key;
	}

	public void encrypt(String msg, int shift) {
		// ASCII codes 65-90 are uppercase alphabet
		// ASCII codes 97-122 are lowercase alphabet
		StringBuilder sb = new StringBuilder();


		// I'm pretty sure there's a way to do this with better time complexity than O(n^2),
		// but I've already spent enough time on this.
		for (int i = 0; i < msg.length(); i++) {
			vanillaChar = msg.charAt(i);
			if (Character.isLetter(vanillaChar)) {
				for (int j = 1; j <= (shift % 26); j++) {
					vanillaChar++;
					if (vanillaChar > 90 && vanillaChar < 97) {
						vanillaChar = 65;
					} else if (vanillaChar > 122) {
						vanillaChar = 97;
					}
				}
				sb.append(vanillaChar);
			} else {
				for (int g = 1; g <= (shift % 26); g++) {
					vanillaChar++;
				}
				sb.append(vanillaChar);
			}
		}
		cipherText = sb.toString();
	}
}