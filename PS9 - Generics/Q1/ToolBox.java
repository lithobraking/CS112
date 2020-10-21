import java.util.ArrayList;

public class ToolBox implements GenericTools {
    //swap the elements at p1 and p2
    public <T> void swap(ArrayList<T> data, int p1, int p2) {
        T temp = data[p1];
        data[p1] = data [p2];
        data[p2] = temp;
    }

    //performs an insertion sort
    public <T extends Comparable<T>> void insertionSort(ArrayList<T> data) {
        for (int i = 1; i < data.size(); i++) {
            T item = data[i];
            T frontItem = data[i - 1];

            
        }
    }


    //performs an insertion sort but only returns the section of the list
    //from "start" to "end - 1"
    public <T extends Comparable<T>> ArrayList<T> insertionSort(ArrayList<T> data, int start, int end);
}