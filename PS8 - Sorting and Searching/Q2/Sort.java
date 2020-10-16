import java.util.ArrayList;
import java.util.Collections;

public class Sort {

    public static void quicksort(ArrayList<Car> data) {
        sortCar(data, 0, (data.size() - 1));
    }

    // HELPER METHODS

    private static void sortCar(ArrayList<Car> data, int start, int end) {
        if (start < end) {
            int pivot = partitionString(data, start, end);
            sortString(data, start, pivot - 1);
            sortString(data, (pivot + 1), end);
        }
        System.out.println("Sorted!");
    }

    private static void sortString(ArrayList<String> data, int start, int end) {
        if (start < end) {
            int pivot = partitionString(data, start, end);
            sortString(data, start, pivot - 1);
            sortString(data, (pivot + 1), end);
        }
        System.out.println("Sorted!");
    }

    private static void sortInt(ArrayList<Integer> data, int start, int end) {
        if (start < end) {
            int pivot = partitionInt(data, start, end);
            sortInt(data, start, pivot - 1);
            sortInt(data, (pivot + 1), end);
        }
        System.out.println("Sorted!");
    }

    // PARTITION METHODS

    // accepts a list of Car objects
    private static int partitionCar(ArrayList<Car> data, int start, int end) {
        int mid = (start + end) / 2;
        Car pivot = data.get(mid);

        Collections.swap(data, start, mid);
        int leftEnd = start;

        for (int i = start + 1; i <= end; i++) {
            System.out.println(data.get(i));
//            if (data.get(i).compareToIgnoreCase(pivot) <= 0) {
//                leftEnd++;
//                System.out.println(data.get(i));
//                Collections.swap(data, leftEnd, i);
//            }
        }
        Collections.swap(data, start, leftEnd);
        return leftEnd;
    }

    // accepts a list of strings
    private static int partitionString(ArrayList<String> data, int start, int end) {
        int mid = (start + end) / 2;
        String pivot = data.get(mid);

        Collections.swap(data, start, mid);
        int leftEnd = start;

        for (int i = start + 1; i <= end; i++) {
            if (data.get(i).compareToIgnoreCase(pivot) <= 0) {
                leftEnd++;
                System.out.println(data.get(i).compareToIgnoreCase(pivot));
                Collections.swap(data, leftEnd, i);
            }
        }
        Collections.swap(data, start, leftEnd);
        return leftEnd;
    }

    // accepts a list of integers
    private static int partitionInt(ArrayList<Integer> data, int start, int end) {
        int mid = (start + end) / 2;
        int pivot = data.get(mid);

        Collections.swap(data, start, mid);
        int leftEnd = start;

        for (int i = start + 1; i <= end; i++) {
            if (data.get(i) <= pivot) {
                leftEnd++;
                Collections.swap(data, leftEnd, i);
            }
        }
        Collections.swap(data, start, leftEnd);
        return leftEnd;
    }
}
