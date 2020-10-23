import java.lang.reflect.Array;
import java.util.ArrayList;

public class CarSearch {

    public static ArrayList<Car> searchMake(ArrayList<Car> cars, String make) {
        ArrayList<Car> listOfMakes = new ArrayList<>();

        for (Car car : cars) {
            if (car.getMake().equalsIgnoreCase(make)) {
                listOfMakes.add(car);
            }
        }
        Sort.sortModels(listOfMakes);
        Sort.sortYears(listOfMakes);
        return listOfMakes;
    }

    public static ArrayList<Car> searchMakeUnsorted(ArrayList<Car> cars, String make) {
        ArrayList<Car> listOfMakes = new ArrayList<>();

        for (Car car : cars) {
            if (car.getMake().equalsIgnoreCase(make)) {
                listOfMakes.add(car);
            }
        }
        return listOfMakes;
    }

    public static String searchOldestMake(ArrayList<Car> cars) {
        int min = -1;
        String current = null;

        for (Car car : cars) {
            if (min == -1) {
                min = Integer.parseInt(car.getYear());
                current = car.toString();
            }
            if (Integer.parseInt(car.getYear()) < min) {
                min = Integer.parseInt(car.getYear());
                current = car.toString();
            }
        }
        return current;
    }

    public static String searchNewestMake(ArrayList<Car> cars) {
        int max = -1;
        String current = null;
        Car newest = null;

        for (Car car : cars) {
            if (max == -1) {
                max = Integer.parseInt(car.getYear());
                current = car.toString();
                newest = car;
            }
            if (Integer.parseInt(car.getYear()) > max) {
                max = Integer.parseInt(car.getYear());
                current = car.toString();
                newest = car;
            }
            if (Integer.parseInt(car.getYear()) == max) {
                int vin1 = Integer.parseInt(car.getVin().substring((car.getVin().length() - 6)));
                int vin2 = Integer.parseInt(newest.getVin().substring((newest.getVin().length() - 6)));
                if (vin1 > vin2) {
                    max = Integer.parseInt(car.getYear());
                }
                current = car.toString();
            }
        }
        return current;
    }
}
