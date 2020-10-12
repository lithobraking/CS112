import java.util.Scanner;

public class NumberTool {
	
	public static void test (SmartPhone contact) {
		System.out.println("Name: " + contact.getName());
		System.out.println("Phone: " + contact.getPhone());
		System.out.println("Email: " + contact.getEmail());
		System.out.println("Telephone neighbor: " + contact.getTelephoneNeighbor());
	}

	public static void main(String[] args) {
		Scanner ui = new Scanner(System.in);
		String inputName;
		String inputNumber;
		String inputEmail;

		System.out.println("New number creation tool");

		System.out.println("Enter name");
		inputName = ui.nextLine();

		System.out.println("Enter phone number");
		inputNumber = ui.nextLine();

		System.out.println("Enter email");
		inputEmail = ui.nextLine();

		SmartPhone cell = new SmartPhone(inputName, inputNumber, inputEmail);
		test(cell);
	}
}