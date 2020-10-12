public class Demo3 {

    public static void test(SmartPhone f)
    {
        System.out.print(f);
        if (f.hasPhoneNumber()) {
            System.out.println("Area code: " + f.getAreaCode());
            System.out.println("Prefix: " + f.getPrefix());
            System.out.println("Line number: " + f.getLineNumber());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SmartPhone test1 = new SmartPhone("Bret", "1234567890");
        SmartPhone test2 = new SmartPhone("Alice", "8059226966", "info@test.com");
        SmartPhone test3 = new SmartPhone();
        test(test1);
        test(test2);
        test(test3);
    }

}
