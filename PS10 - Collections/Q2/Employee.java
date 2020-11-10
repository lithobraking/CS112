import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Employee {
	private String eID = null;
	private String firstName = null;
	private String lastName = null;
	private String email = null;

	public Employee(String eID, String firstName, String lastName, String email) {
	    this.eID = eID;
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.email = email;
    }

    public static TreeMap<String, Employee> load() {
		TreeMap<String, Employee> employees = new TreeMap<>();

		try {
			Scanner employeeDB = new Scanner(new File("employees.txt"));

			try {
				for (int i = 0; employeeDB.hasNextLine(); i++) {
					String line = employeeDB.nextLine();
//					System.out.println("1 - Line is currently: " + line);
					if (line.equalsIgnoreCase("id\tfirst_name\tlast_name\temail")) {
						continue;
					}
//					System.out.println("2 - Line is currently: " + line);
					String[] current = line.split("\t");
//					System.out.println("3 - Line is currently: " + line);

					String eID = current[0];
					String firstName = current[1];
					String lastName = current[2];
					String email = current[3];

//					System.out.println("4 - Line is currently: " + line);

					Employee e = new Employee(eID, firstName, lastName, email);
					employees.put(e.eID, e);

				}

//				System.out.println(employees);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return employees;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s %s %s", eID, firstName, lastName, email);
    }
}