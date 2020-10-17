import java.util.ArrayList;

public class CarSearch {

    public static ArrayList<Car> searchMake(ArrayList<Car> cars, String make) {
        ArrayList<Car> listOfMakes = new ArrayList<>();

        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getMake().equalsIgnoreCase(make)) {
                listOfMakes.add(cars.get(i));
            }
        }
        Sort.sortModels(listOfMakes);
        Sort.sortYears(listOfMakes);
        return listOfMakes;
    }
}
