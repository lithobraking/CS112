import javax.crypto.SealedObject;
import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Car {
	private final String make;
	private final String model;
	private final String year;
	private final String vin;

	public Car(String make, String model, String year) {
		this.make = make;
		this.model = model;
		this.year = year;
		vin = null;
	}

	public Car(String make, String model, String year, String vin) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.vin = vin;
	}

	@Override
	public String toString() {
		return String.format("%15s%25s%5s%18s", this.getMake(), this.getModel(), this.getYear(), this.getVin());
	}

	// getter methods
	public String getMake() {
		return make;
	}
	public String getModel() {
		return model;
	}
	public String getYear() {
		return year;
	}
	public String getVin() { return vin; }
}

public class DisplayCars {
	public static void main(String[] args) {
		try {
			File f = new File("car-list.txt");
			Scanner s = new Scanner(f);

			try {
				String make = null;
				String model = null;
				String year = null;
				String vin = null;
				Scanner ui = new Scanner(System.in);

				ArrayList<Car> cars = new ArrayList<>(80);
				for (int i = 0; s.hasNextLine(); i++) {
					String[] splitString = s.nextLine().split("\t");
					if (splitString[0].equalsIgnoreCase("make")) {
						continue;
					}
					make = splitString[0];
					model = splitString[1];
					year = splitString[2];
					vin = splitString[3];
					cars.add(new Car(make, model, year, vin));
				}

				System.out.println("What car make are you looking for?");
				ArrayList<Car> searchedMake;
				String inputMake = ui.nextLine();
				searchedMake = CarSearch.searchMakeUnsorted(cars, inputMake);

				System.out.println("Oldest " + inputMake);
				System.out.println(CarSearch.searchOldestMake(searchedMake));

				System.out.println("Newest " + inputMake);
				System.out.println(CarSearch.searchNewestMake(searchedMake));

			}
			catch (Exception e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}