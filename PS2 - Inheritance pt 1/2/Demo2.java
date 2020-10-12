public class Demo2 {
    public static void main(String[] args) {
        Phone test1 = new SmartPhone("Bret", "1234567890");
        Phone test2 = new SmartPhone("Alice", "8059226966", "info@test.com");
        Phone test3 = new SmartPhone();
        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test3);
    }
}
