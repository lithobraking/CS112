

public class SmartPhone extends Phone {
	protected String email;
	protected String number;

	public SmartPhone() {

	}

	public SmartPhone(String name, String number) {
		super(name, Long.parseLong(number));
		this.number = number;
	}

	public SmartPhone(String name, String number, String email) {
		super(name, Long.parseLong(number));
		this.email = email;
		this.number = number;
	}

	public String getPhone() {
		if (super.number > -1) {
			return Long.toString(super.number);
		} else {
			return "Not set";
		}
	}

	public String getEmail() {
		if (email != null) {
			return email;
		} else {
			return "None";
		}
	}

	public String toString() {
		return ("Name: " + super.name + "\nPhone: " + getPhone() + "\nEmail: " + getEmail() + "\n");
	}
}