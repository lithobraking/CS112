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
        ArrayList<T> sortedData = new ArrayList<>();
        
        for (int i = 0; i < data.size(); i++) {
            T item = data.get(i);
            int position = i;
            
            while (position > 0 && (item.compareToIgnoreCase(data.get(position - 1)) <= 0)) {
                item = item.get(position);
                position = (position - 1);
            }
            
            data.get(position) = item;

            
        }
    }


    //performs an insertion sort but only returns the section of the list
    //from "start" to "end - 1"
    public <T extends Comparable<T>> ArrayList<T> insertionSort(ArrayList<T> data, int start, int end) {
        ArrayList<T> sortedData = new ArrayList<>();
        
        for (int i = 0; i < data.size(); i++) {
            T item = data.get(i);
            int position = i;
            
            while (position > 0 && (item.compareToIgnoreCase(data.get(position - 1)) <= 0)) {
                item = item.get(position);
                position = (position - 1);
            }
            
            data.get(position) = item;

            
        }
    }
}