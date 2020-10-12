import java.util.Scanner;
import java.io.*;

public class FileStats
{
	private String filename;
	private Scanner file;

	// constructor
	public FileStats(String fn) throws FileNotFoundException {
		filename = fn;
		file = new Scanner(new File(filename));	
	}

	public int getNumMatchingWords(String text) {
		// count the number of lines containing the key
		int linesContainingString = 0;
		String wordQuery = text.toLowerCase();
		String line;

		while (file.hasNextLine()) {
			line = file.nextLine().toLowerCase();

			if (line.contains(wordQuery)) {
				linesContainingString++;
			}
		}
		try {
			this.scannerReset();
		} catch (Exception fnfe) {
			System.out.println("Something went wrong.");
		}
		return linesContainingString;
	}

	public int getNumLines() {
		// get total number of lines in the file
		int lineCount = 0;

		while (file.hasNextLine()) {
			lineCount++;
			file.nextLine();
			
			if (!file.hasNextLine()) {
				break;
			}
		}
		try {
			this.scannerReset();
		} catch (Exception fileNotFoundException) {
			System.out.println("Something went wrong.");
		}
		return lineCount;
	}
	
	private void scannerReset() throws FileNotFoundException {
		file.close();
		file = null;
		file = new Scanner(new File(filename));
	}
}