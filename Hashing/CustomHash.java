import java.util.Scanner;

public class CustomHash {

    public static int hashFunction(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int hashScore = 0;

        for (int i = 0; i < chars.length; i++) {
            if (!Character.isLetter(chars[i])) {
                continue;
            }

            if (chars[i] == 97) { // Aa
                hashScore += 100;
            } else if (chars[i] == 101) { // Ee
                hashScore += 200;
            } else if (chars[i] == 105) { // Ii
                hashScore += 300;
            } else if (chars[i] == 111) { // Oo
                hashScore += 400;
            } else if (chars[i] == 117) { // Uu
                hashScore += 500;
            } else {
                if (Character.isLetter(chars[i])) {
                    hashScore += (((int)chars[i] - 96) * (i + 1));
                }
            }
        }
        return hashScore;
    }

    public static void main(String[] args) {
        Scanner ui = new Scanner(System.in);
        String input;

        System.out.println("Enter any text");
        input = ui.nextLine();
        System.out.println("The CS112 hashcode for that string is " + hashFunction(input));

    }
}
