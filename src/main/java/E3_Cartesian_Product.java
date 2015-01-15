import javafx.util.Pair;
import lombok.extern.log4j.Log4j2;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.io.IOException;
import java.util.AbstractCollection;
import java.util.Iterator;

@Log4j2
public class E3_Cartesian_Product {

    public static void main(String[] args) throws InterruptedException, IOException {

        Iterable<Long> it1 = new SizedLongIterable(10000);
//        Iterable<Long> it2 = new SizedLongIterable(100);

        Observable<Long> numbers1 = Observable.from(it1);
//        Observable<Long> numbers2 = Observable.from(it2);

        Observable cartesian = numbers1
                .observeOn(Schedulers.io())
                .flatMap(
                (n) -> Observable.from(new SizedLongIterable(10000)).map(
                        (l) -> new Pair(n, l)
                ).observeOn(Schedulers.io())
        );

        cartesian.subscribe(new Subscribers.Printer());

        Utils.keepThreadAlive();
    }

}
