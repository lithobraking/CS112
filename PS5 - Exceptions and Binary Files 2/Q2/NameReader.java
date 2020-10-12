import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class NameReader {
	public static void main(String[] args) {
		Scanner ui = new Scanner(System.in);
		ArrayList<String> names = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		int nameLength;
		int length;
		String name;

		System.out.println("Enter a length");
		nameLength = ui.nextInt();
		try {
			DataInputStream ds = new DataInputStream(new BufferedInputStream(new FileInputStream("names.dat")));

			boolean EOF = false;

			while(!EOF) {
				try {
					length = ds.readInt();
					for (int i = 1; i <= length; i++) {
						sb.append(ds.readChar());
					}
					name = sb.toString();
					names.add(name);
					sb.setLength(0);
				}
				catch (EOFException e) {
					EOF = true;
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		int resultCount = 0;
		System.out.println("Names of length " + nameLength);
		for (String s : names) {
			if (s.length() == nameLength) {
				System.out.println(s);
				resultCount++;
			}
		}
		System.out.println(resultCount + " results");
	}
}