import java.util.ArrayList;
import java.util.Collections;

public class Sort {

    public static void quicksort(ArrayList<Car> data, String param) {
        if (param.equalsIgnoreCase("make")) {
            sortMake(data, 0, (data.size() - 1));
        }

        if (param.equalsIgnoreCase("model")) {
            sortModel(data, 0, (data.size() - 1));
        }

        if (param.equalsIgnoreCase("year")) {
            sortYear(data, 0, (data.size() -1));
        }
    }

    public static void quicksort(ArrayList<Car> data, String param, int startIndex, int endIndex) {
        if (param.equalsIgnoreCase("make")) {
            sortMake(data, 0, (data.size() - 1));
        }

        if (param.equalsIgnoreCase("model")) {
            sortModel(data, startIndex, endIndex);
        }

        if (param.equalsIgnoreCase("year")) {
            sortYear(data, startIndex, endIndex);
        }
    }

    // HELPER METHODS

    private static void sortMake(ArrayList<Car> data, int start, int end) {
        if (start < end) {
            int pivot = partitionMake(data, start, end);
            sortMake(data, start, pivot - 1);
            sortMake(data, (pivot + 1), end);
        }
    }

    private static void sortModel(ArrayList<Car> data, int start, int end) {
        if (start < end) {
            int pivot = partitionModel(data, start, end);
            sortModel(data, start, pivot - 1);
            sortModel(data, (pivot + 1), end);
        }
    }

    private static void sortYear(ArrayList<Car> data, int start, int end) {
        if ((end - start) == 1) {
            if (Integer.parseInt(data.get(start).getYear()) > Integer.parseInt(data.get(end).getYear())) {
                Collections.swap(data, start, end);

            }
        } else if (start < end && (end - start) > 1) {
            int pivot = partitionYear(data, start, end);
            sortYear(data, start, pivot - 1);
            sortYear(data, (pivot + 1), end);
        }
    }

    // -- PARTITION METHODS --

    // make
    private static int partitionMake(ArrayList<Car> data, int start, int end) {
        int mid = (start + end) / 2;
        String pivot = data.get(mid).getMake();

        Collections.swap(data, start, mid);
        int leftEnd = start;

        for (int i = start + 1; i <= end; i++) {
            if (data.get(i).getMake().compareToIgnoreCase(pivot) <= 0) {
                leftEnd++;
                Collections.swap(data, leftEnd, i);
            }
        }
        Collections.swap(data, start, leftEnd);
        return leftEnd;
    }

    // model
    private static int partitionModel(ArrayList<Car> data, int start, int end) {
        int mid = (start + end) / 2;
        String pivot = data.get(mid).getModel();

        Collections.swap(data, start, mid);
        int leftEnd = start;

        for (int i = start + 1; i <= end; i++) {
            if (data.get(i).getModel().compareToIgnoreCase(pivot) <= 0) {
                leftEnd++;
                Collections.swap(data, leftEnd, i);
            }
        }
        Collections.swap(data, start, leftEnd);
        return leftEnd;
    }

    // year
    private static int partitionYear(ArrayList<Car> data, int start, int end) {
        int mid = (start + end) / 2;
        int pivot = Integer.parseInt(data.get(mid).getYear());

        Collections.swap(data, start, mid);
        int leftEnd = start;

        for (int i = start + 1; i <= end; i++) {
            if (Integer.parseInt(data.get(i).getYear()) <= pivot) {
                leftEnd++;
                Collections.swap(data, leftEnd, i);
            }
        }
        Collections.swap(data, start, leftEnd);
        return leftEnd;
    }
}
