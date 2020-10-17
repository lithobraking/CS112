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

	public Car(String make, String model, String year) {
		this.make = make;
		this.model = model;
		this.year = year;
	}

	@Override
	public String toString() {
		return "Car {" +
				"make='" + make + '\'' +
				", model='" + model + '\'' +
				", year='" + year + '\'' +
				'}';
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
}

public class DisplayCars {
	public static void main(String[] args) {
		try {
			File f = new File("cars.txt");
			Scanner s = new Scanner(f);

			try {
				String make = null;
				String model = null;
				String year = null;
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
					cars.add(new Car(make, model, year));
				}

				System.out.println("What car make are you looking for?");
				ArrayList<Car> searchedMake = new ArrayList<>();
				searchedMake = CarSearch.searchMake(cars, ui.nextLine());

				for (Car car : searchedMake) {
					System.out.format("%15s%25s%5s%n", car.getMake(), car.getModel(), car.getYear());
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}