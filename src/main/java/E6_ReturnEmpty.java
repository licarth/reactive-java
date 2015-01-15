import lombok.extern.log4j.Log4j2;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import java.io.IOException;

@Log4j2
public class E6_ReturnEmpty {

    public static void main(String[] args) throws InterruptedException, IOException {

        Observable
                .just(1,2, 3)
                .flatMap(new Func1<Integer, Observable<Integer>>() {
                    @Override
                    public Observable<Integer> call(Integer i) {
                        if (i == 2){
                            return Observable.empty();
                        } else {
                            return Observable.just(i);
                        }
                    }
                }).subscribe(new Subscribers.Printer());

        Utils.keepThreadAlive();
    }

}
