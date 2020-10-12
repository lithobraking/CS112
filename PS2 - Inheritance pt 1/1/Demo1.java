public class Demo1 {

    public static void test(Phone p) {
        System.out.println("Getter test:");
        System.out.println(p.getName());
        System.out.println(p.getNumber());
    }

    public static void main(String[] args) {
        Phone test1 = new SmartPhone();
        Phone test2 = new SmartPhone("Alice", "8059226966", "info@test.com");
        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test1);

        test(test1);
        test(test2);
    }

}
