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
	public static void sortModels(ArrayList<Car> cars) {
		int start = 0;
		int end = 0;
		for (int i = 0; i < cars.size(); i ++) {
			String before = "not set";
			if ((i - 1) >= 0) {
				before = cars.get(i - 1).getMake();
			}

			String here = cars.get(i).getMake();

			String next = null;
			if ((i + 1) < cars.size()) {
				next = cars.get(i + 1).getMake();
			}
			if (!before.equalsIgnoreCase(here) && here.equalsIgnoreCase(next)) {
				start = i;
			}
			if (before.equalsIgnoreCase(here) && !here.equalsIgnoreCase(next)) {
				end = i;

			}
			Sort.quicksort(cars, "model", start, end);
		}
	}

	public static void sortYears(ArrayList<Car> cars) {
		boolean startIsUpdated = false, endIsUpdated = false;
		int start = 0, end = 0;
		for (int j = 0; j < cars.size(); j++) {
			String before = "not set";
			if ((j - 1) >= 0) {
				before = cars.get(j - 1).getModel();
			}

			String here = cars.get(j).getModel();
			String next = null;

			if ((j + 1) < cars.size()) {
				next = cars.get(j + 1).getModel();
			}

			if (!before.equalsIgnoreCase(here) && here.equalsIgnoreCase(next)) {
				start = j;
				startIsUpdated = true;
			}

			if (before.equalsIgnoreCase(here) && !here.equalsIgnoreCase(next)) {
				end = j;
				endIsUpdated = true;
			}

			if (startIsUpdated && endIsUpdated) {
				Sort.quicksort(cars, "year", start, end);
				startIsUpdated = false;
				endIsUpdated = false;
			}
		}
	}

	public static void main(String[] args) {
		try {
			File f = new File("cars.txt");
			Scanner s = new Scanner(f);

			try {
				String make = null;
				String model = null;
				String year = null;

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

				Sort.quicksort(cars, "make"); // sorts all cars by manufacturer
				sortModels(cars);
				sortYears(cars);

				for (Car car : cars) {
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