

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

	public String getTeleponeNeighbor() {
		String temp = Long.toString(super.number + 1);
		if (hasPhoneNumber() == true) {
			return ("(" + temp.substring(0,3) + ") " + temp.substring(3,6) + "-" + temp.substring(6,10));
		} else {
			return "Cannot calculate phone number neighbor";
		}
	}

	// MARK: - Phone Number Methods

	public boolean hasPhoneNumber() {
		return (super.number + 1) > 0;
	}

	public String getAreaCode() {
		return number.substring(0, 3);
	}

	public String getPrefix() {
		return number.substring(3, 6);
	}

	public String getLineNumber() {
		return number.substring(6, 10);
	}

	public String toString() {
		return ("Name: " + super.name + "\nPhone: " + getPhone() + "\nEmail: " + getEmail() + "\n");
	}
}