import java.util.Scanner;

public class EmployeeMain {
	public static void main(String[] args) {
		Scanner ui = new Scanner(System.in);
		String nameInput;
		int idInput;
		String departmentInput;
		String positionInput;

		// I could probably wrap this into a function (wait no, method - this is 
		// Java, not Swift) and call it multiple times. But I'm sleep-deprived 
		// and impatient so I might come back and do that later when I'm feeling 
		// physically better.
		// But in case I never get around to it, this code gets the job done.

		// number 1
		System.out.println("-- Employee Entry Form --");

		System.out.println("Enter name");
		nameInput = ui.nextLine();

		System.out.println("Enter ID");
		idInput = ui.nextInt();
		ui.nextLine();

		System.out.println("Enter department");
		departmentInput = ui.nextLine();

		System.out.println("Enter position");
		positionInput = ui.nextLine();

		Employee e1 = new Employee(nameInput, idInput, departmentInput, positionInput);

		// number 2
		System.out.println("-- Employee Entry Form --");

		System.out.println("Enter name");
		nameInput = ui.nextLine();

		System.out.println("Enter ID");
		idInput = ui.nextInt();
		ui.nextLine();

		System.out.println("Enter department");
		departmentInput = ui.nextLine();

		System.out.println("Enter position");
		positionInput = ui.nextLine();

		Employee e2 = new Employee(nameInput, idInput, departmentInput, positionInput);

		// number 3
		System.out.println("-- Employee Entry Form --");

		System.out.println("Enter name");
		nameInput = ui.nextLine();

		System.out.println("Enter ID");
		idInput = ui.nextInt();
		ui.nextLine();

		System.out.println("Enter department");
		departmentInput = ui.nextLine();

		System.out.println("Enter position");
		positionInput = ui.nextLine();

		Employee e3 = new Employee(nameInput, idInput, departmentInput, positionInput);

		// print to table. kind of crappily implemented, but achieves MVP reqs
		System.out.format("%12s%13s%13s%13s\n", "Name", "ID", "Department", "Position");
		System.out.format("%12s%13d%13s%13s\n", e1.getName(), e1.getIdNumber(), e1.getDepartment(), e1.getPosition());
		System.out.format("%12s%13d%13s%13s\n", e2.getName(), e2.getIdNumber(), e2.getDepartment(), e2.getPosition());
		System.out.format("%12s%13d%13s%13s\n", e3.getName(), e3.getIdNumber(), e3.getDepartment(), e3.getPosition());
	}
}