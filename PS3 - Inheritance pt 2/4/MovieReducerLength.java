import java.util.ArrayList;

public class MovieReducerLength implements MediaReducer {

	private StringBuilder output;

	public String reduce(ArrayList<Media> list, String length) {
//		System.out.println("Order received!");
		matchStringLength(list, Integer.parseInt(length));
		//System.out.println(appendedCount + " items added to string.");
		return output.toString();
	}

	public void matchStringLength(ArrayList<Media> list, int length) {
		output = new StringBuilder(length);
		for (Media media : list) {
			//System.out.println("String is: " + media.getName());
			//System.out.println("String length is: " + media.getName().length());
			if (media.getName().length() == length) {
				output.append(media);
				output.append("\n");
				//System.out.println("String appended!");

			}
		}
	}
}