import java.io.*;
import java.util.Scanner;

public class BinaryReader {
    public static void main(String[] args) {
        Scanner ui = new Scanner(System.in);
        int total = 0;
        int current;
        int max = 0;
        int min = 0;
        System.out.println("Enter a filename");

        try {
            FileInputStream fStream = new FileInputStream(ui.nextLine());
            DataInputStream dStream = new DataInputStream(fStream);

            boolean fileEnd = false;

            while (!fileEnd) {
                try {
                    current = dStream.readInt();
                    total++;
                    if (min == 0) {
                        min = current;
                    }
                    if (current > max) {
                        max = current;
                    } else if (current < min) {
                        min = current;
                    }
                }
                catch (IOException e) {
                    fileEnd = true;
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.printf("Found %d integers.\n", total);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }
}

1496 2128 9278 7055