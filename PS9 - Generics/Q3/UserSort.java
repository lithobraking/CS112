import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class UserSort {

    public static void main(String[] args) {
        ArrayList<User> users = null;

        try {
            Scanner userDB = new Scanner(new File("user-database.txt"));

            try {
                String username = null;
                String password = null;
                users = new ArrayList<>(1005);

                for (int i = 0; userDB.hasNextLine(); i++) {
                    String line = userDB.nextLine();
                    if (line.equalsIgnoreCase("username\tpassword")) {
                        continue;
                    }

                    String[] splitString = line.split("\t");
                    username = splitString[0];
                    password = splitString[1];
                    users.add(new User(username, password));
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner ui = new Scanner(System.in);
        System.out.println("Enter a starting point and ending point");
        int start = Integer.parseInt(ui.next());
        int end = Integer.parseInt(ui.next());

        Sort iSort = new Sort();
        iSort.insertionSort(users, start, end).forEach(System.out::println);
    }
}
