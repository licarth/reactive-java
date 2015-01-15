import java.util.Iterator;

public class SizedLongIterable implements Iterable<Long> {

    private final SizedLongIterator iterator;

    public SizedLongIterable(long size) {
        this.iterator = new SizedLongIterator(size);
    }

    @Override
    public Iterator<Long> iterator() {
        return iterator;
    }
}
