import java.util.Comparator;

/**
 * BookComparator
 */

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        if (o1.equals(o2)) {
            return 1;
        } else {
            return 0;
        }
    }
}
