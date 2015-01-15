import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;

public class SizedLongIterator implements Iterator<Long> {

    private AtomicLong i = new AtomicLong(0);
    private final long size;

    public SizedLongIterator(long size) {
        this.size = size;
    }

    @Override
    public boolean hasNext() {
        return i.get() < size;
    }

    @Override
    public Long next() {
        return i.incrementAndGet();
    }
}
