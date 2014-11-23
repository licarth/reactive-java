import lombok.extern.log4j.Log4j2;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

@Log4j2
public class E2_Expensive_Computation {

    public static void main(String[] args) throws InterruptedException, IOException {
        Observable
                .just(1, 2, 3)
                .flatMap(i -> Observables.expensiveComputation(i, 2, SECONDS)
                                .subscribeOn(Schedulers.computation())
                )
                .doOnCompleted(() -> log.info("OBSERVABLE COMPLETE."))
                .subscribeOn(Schedulers.immediate())
                .subscribe(E2_Expensive_Computation::collectData);
        log.info("Main thread is not blocked.");
        Utils.keepThreadAlive();
    }

    public static String collectData(String input) {
        String output = input + " collected.";
        log.info(Thread.currentThread().getName() + " : " + output);
        return output;
    }

}
