import rx.Observable;
import rx.functions.Func1;

import java.io.IOException;

public class E7_TakeLast {
    public static void main(String[] args) throws InterruptedException, IOException {

        Observable
                .just(2)
                .flatMap(new Func1<Integer, Observable<Integer>>() {
                    @Override
                    public Observable<Integer> call(Integer i) {
                        if (i == 2) {
                            return Observable.empty();
                        } else {
                            return Observable.just(i);
                        }
                    }
                })
                .last()
//                .takeLast(1)
                .subscribe(new Subscribers.Printer());

        Utils.keepThreadAlive();

    }
}
