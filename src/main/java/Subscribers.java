import lombok.extern.log4j.Log4j2;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by thomas on 23/11/14.
 */
@Log4j2
public class Subscribers {

    public static class Printer extends Subscriber<Object>{
        @Override
        public void onCompleted() {
            log.info("Subscriber onCompleted()");
        }

        @Override
        public void onError(Throwable throwable) {
            log.error("Subscriber onError() : {}", throwable);

        }

        @Override
        public void onNext(Object o) {
            log.info("Subscriber onNext() : {}",o);
        }
    }
}
