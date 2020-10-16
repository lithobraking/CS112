import java.util.ArrayList;

public class Telephone {
	private String phoneNumber;
	ArrayList<String> comboList = new ArrayList<>();
	String[] keypadAssignments = {
		"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"
	};

	public Telephone(String phone) {
		phoneNumber = phone;
	}

	public ArrayList<String> getPossibilities() {
		return comboList;
	}
}