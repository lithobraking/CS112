import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileStatsMain
{
	public static void main(String[] args) throws FileNotFoundException {
		Scanner ui = new Scanner(System.in);

		System.out.println("Enter a filename");
		String userFile = ui.nextLine();
		FileStats fs = new FileStats(userFile);
		System.out.printf("%s has %d lines\n", userFile, fs.getNumLines());

		System.out.println("Enter some text");
		String userText = ui.nextLine();
		System.out.printf("%d line(s) contain \"%s\"\n", fs.getNumMatchingWords(userText), userText);
	}
}