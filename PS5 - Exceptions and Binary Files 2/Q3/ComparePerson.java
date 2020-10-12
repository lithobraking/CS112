import java.util.Comparator;

public class ComparePerson implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        return person1.name.compareTo(person2.name);
    }
}
