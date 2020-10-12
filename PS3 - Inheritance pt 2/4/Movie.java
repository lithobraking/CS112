

public class Movie extends Media {
    
    public Movie(String name, int year, String genre) {
        super(name, year, genre);
    } 
    
    
    // Implemented a sort of indexing (is that the right word?)
    // construct to make the output more switch/case-friendly.
    // The getEra() function returns a string to satisfy the
    // requirements of the interface. In a real world situation
    // I would probably just change the data type the interface
    // accepts.
    public String getEra() {
        if (super.getYear() >= 2000) {
            return Integer.toString(1); // millennium era
        } else if (super.getYear() >= 1977) {
            return Integer.toString(2); // modern era
        } else if (super.getYear() >= 1955) {
            return Integer.toString(3); // change era
        } else if (super.getYear() >= 1941) {
            return Integer.toString(4); // golden era
        } else {
            return Integer.toString(5); // pre-golden era
        } // note: year range for silent era was never defined
    }
    
    public boolean wasReleasedAfter(Media other) {
        return (super.getYear() > other.getYear());
    }
    
    public boolean wasReleasedBeforeOrInSameYear(Media other) {
        return (super.getYear() <= other.getYear());
    }
    
    public boolean wasReleasedBefore(Media other) {
        return (super.getYear() < other.getYear());
    }
}