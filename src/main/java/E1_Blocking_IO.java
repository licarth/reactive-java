import lombok.extern.log4j.Log4j2;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.io.IOException;

@Log4j2
public class E1_Blocking_IO {

    public static void main(String[] args) throws InterruptedException, IOException {
        Observable
                .just(1, 2, 3)
                .flatMap(i -> Observables.blockingIO(i)
                                .subscribeOn(Schedulers.io())
                )
                .subscribeOn(Schedulers.immediate())
                .subscribe(new Subscribers.Printer());
        log.info("Main thread is not blocked.");
        System.in.read();
    }

}
