public class Employee {

	private String name;
	private int idNumber;
	private String department;
	private String position;

	public Employee() {
		this.name = "(not set)";
		this.idNumber = 0;
		this.department = "(not set)";
		this.position = "(not set)";
	}

	public Employee(String name, int idNumber) {
		this.name = name;
		this.idNumber = idNumber;
		this.department = "(not set)";
		this.position = "(not set)";
	}

	public Employee(String name, int idNumber, String department) {
		this.name = name;
		this.idNumber = idNumber;
		this.department = department;
		this.position = "(not set)";
	}

	public Employee(String name, int idNumber, String department, String position) {
		this.name = name;
		this.idNumber = idNumber;
		this.department = department;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public int getIdNumber() {
		return idNumber;
	}

	public String getDepartment() {
		return department;
	}

	public String getPosition() {
		return position;
	}
}