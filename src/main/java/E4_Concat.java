import javafx.util.Pair;
import lombok.extern.log4j.Log4j2;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.io.IOException;

@Log4j2
public class E4_Concat {

    public static void main(String[] args) throws InterruptedException, IOException {

        Observable concat = Observable.merge(
                Observables.blockingIO(1).subscribeOn(Schedulers.io()),
                Observables.blockingIO(2).subscribeOn(Schedulers.io()),
                Observables.blockingIO(3).subscribeOn(Schedulers.io())
        );

        concat.subscribe(new Subscribers.Printer());

        Utils.keepThreadAlive();
    }

}
