import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Car {
	String make;
	String model;
	String year;

	public Car(String make, String model, String year) {
		this.make = make;
		this.model = model;
		this.year = year;
	}
}

public class DisplayCars {
	public static void main(String[] args) {
		try {
//			 BufferedReader b = new BufferedReader(new FileReader(new File("cars.txt")));
			File f = new File("cars.txt");
			Scanner s = new Scanner(f);

			try {
				String make = null;
				String model = null;
				String year = null;

				ArrayList<Car> cars = new ArrayList<>(80);
				for (int i = 0; s.hasNextLine(); i++) {
					String[] splitString = s.nextLine().split("\t");
					make = splitString[0];
					model = splitString[1];
					year = splitString[2];
					cars.add(new Car(make, model, year));
				}

				for (int i = 1; i < cars.size(); i++) {
					System.out.format("%15s%25s%5s%n", cars.get(i).make, cars.get(i).model, cars.get(i).year);
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