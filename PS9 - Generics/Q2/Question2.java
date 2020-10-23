import java.util.ArrayList;
import java.util.List;

public class Question2 {
  public static <T extends Comparable<T>> void test(T a, T b) {
    int result = a.compareTo(b);
    System.out.println("-- Running test --");
    if (result < 0) {
      System.out.println("First user is LESS THAN second user");
    } else if (result == 0) {
      System.out.println("First user is EQUAL TO second user");
    } else {
      System.out.println("First user is GREATER THAN second user");
    }
    System.out.println(a + "\n" + b);
  }

  public static void main(String[] args) {
    User u1 = new User("mike", "password");
    User u2 = new User("Bob", "HANCOCKcollege123");
    User u3 = new User("Bernard", "ahc!!");
    User u4 = new User("Sandy", "12345");
    User u5 = new User("Alice", "hancockCOLLEGE123");

    ArrayList<User> data = new ArrayList<>();
    data.add(u1);
    data.add(u2);
    data.add(u3);
    data.add(u4);
    data.add(u5);

    for (User c1 : data)
    {
      for (User c2 : data)
      {
        test(c1, c2);
      }
    }
  }
}
