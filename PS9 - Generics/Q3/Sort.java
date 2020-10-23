import java.util.ArrayList;

public class ToolBox implements GenericTools {
    //swap the elements at p1 and p2
    public <T> void swap(ArrayList<T> data, int p1, int p2) {
        T temp = data.get(p1);
        data.set(p1, data.get(p2));
        data.set(p2, temp);
    }

    //performs an insertion sort
    public <T extends Comparable<T>> void insertionSort(ArrayList<T> data) {
        for (int i = 0; i < data.size(); i++) {
            T item = data.get(i);
            int previous = i - 1;

            while (previous >= 0 && (item.compareTo(data.get(previous)) < 0)) {
                swap(data, previous, (previous + 1));
                --previous;
            }
            data.set(previous +1, item);
        }
    }


    // placeholder
    @Override
    public <T extends Comparable<T>> ArrayList<T> insertionSort(ArrayList<T> data, int start, int end) {
        insertionSort(data);

        ArrayList<T> sortedList = new ArrayList<>();
        for (int i = start; i < end; i++) {
            sortedList.add(data.get(i));
        }
        return sortedList;
    }


}


    //performs an insertion sort but only returns the section of the list
    //from "start" to "end - 1"
//    public <T extends Comparable<T>> ArrayList<T> insertionSort(ArrayList<T> data, int start, int end) {
//        ArrayList<T> sortedData = new ArrayList<>();
//
//        for (int i = 0; i < data.size(); i++) {
//            T item = data.get(i);
//            int position = i;
//
//            while (position > 0 && (item.compareTo(data.get(position - 1)) <= 0)) {
//                item = data.get(position);
//                position = (position - 1);
//            }
//
//            data.set(position, item);
//
//
//        }
//    }
//}