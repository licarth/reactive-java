import lombok.extern.log4j.Log4j2;
import rx.Observable;

import java.util.concurrent.TimeUnit;

/**
 * Created by thomas on 23/11/14.
 */
@Log4j2
public class Observables {

    public static Observable<String> blockingIO(Integer i) {
        return Observable
                .<String>create(subscriber -> {
                    try {
                        log.info("Blocking operation {} : STARTING.", i);
                        Thread.sleep(1000);
                        log.info("Blocking operation {} : FINISHED.", i);
                    } catch (InterruptedException e) {
                        subscriber.onError(e);
                    }
                    subscriber.onNext(i.toString());
                    subscriber.onCompleted();
                });
    }

    public static Observable<String> expensiveComputation(Integer i, Integer length, TimeUnit timeUnit) {
        return Observable
                .<String>create(subscriber -> {
                    log.info("Expensive computation {} : STARTING.", i);
                    long t1 = System.currentTimeMillis();
                    long t2 = t1 + TimeUnit.MILLISECONDS.convert(length, timeUnit);
                    while (System.currentTimeMillis() < t2){
                    }
                    log.info("Expensive computation {} : FINISHED.", i);
                    subscriber.onNext(i.toString());
                    subscriber.onCompleted();
                });
    }


}
