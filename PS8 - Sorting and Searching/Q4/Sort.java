import java.util.ArrayList;
import java.util.Collections;

public class Sort {
    public static void quicksortAll(ArrayList<Car> data) {
        quicksort(data, "make");
        sortModels(data);
        sortYears(data);
    }

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

    // -- SORTING METHODS --

    // Makes recursive partition calls depending on which bootstrap
    // method was called

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
