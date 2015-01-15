import lombok.extern.log4j.Log4j2;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import java.io.IOException;

@Log4j2
public class E5_ExceptionOK {

    public static void main(String[] args) throws InterruptedException, IOException {

        Observable
                .just(1,2)
                .flatMap(new Func1<Integer, Observable<Void>>() {
                    @Override
                    public Observable<Void> call(Integer i) {
                        return doSomethingWithException().subscribeOn(Schedulers.computation());
                    }
                }).subscribe(new Subscribers.Printer());

        Utils.keepThreadAlive();
    }


    static public Observable<Void> doSomethingWithException(){
        return Observable.create(new Observable.OnSubscribe<Void>() {
            @Override
            public void call(Subscriber<? super Void> subscriber) {
                try {
                    throwException();
                } catch (Exception e){
                    subscriber.onError(e);
                }
            }
        });
    }


    static public void throwException() throws Exception{
        throw new Exception("Exception thrown.");
    }


}
