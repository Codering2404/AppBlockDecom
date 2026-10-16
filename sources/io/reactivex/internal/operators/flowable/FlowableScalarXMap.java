package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableScalarXMap {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ScalarXMapFlowable<T, R> extends Flowable<R> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f136251b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Function f136252c;

        @Override // io.reactivex.Flowable
        public void x(Subscriber subscriber) {
            try {
                Publisher publisher = (Publisher) ObjectHelper.d(this.f136252c.apply(this.f136251b), "The mapper returned a null Publisher");
                if (!(publisher instanceof Callable)) {
                    publisher.i(subscriber);
                    return;
                }
                try {
                    Object objCall = ((Callable) publisher).call();
                    if (objCall == null) {
                        EmptySubscription.a(subscriber);
                    } else {
                        subscriber.g(new ScalarSubscription(subscriber, objCall));
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    EmptySubscription.b(th, subscriber);
                }
            } catch (Throwable th2) {
                EmptySubscription.b(th2, subscriber);
            }
        }
    }

    public static boolean a(Publisher publisher, Subscriber subscriber, Function function) {
        if (!(publisher instanceof Callable)) {
            return false;
        }
        try {
            Object objCall = ((Callable) publisher).call();
            if (objCall == null) {
                EmptySubscription.a(subscriber);
                return true;
            }
            try {
                Publisher publisher2 = (Publisher) ObjectHelper.d(function.apply(objCall), "The mapper returned a null Publisher");
                if (publisher2 instanceof Callable) {
                    try {
                        Object objCall2 = ((Callable) publisher2).call();
                        if (objCall2 == null) {
                            EmptySubscription.a(subscriber);
                            return true;
                        }
                        subscriber.g(new ScalarSubscription(subscriber, objCall2));
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        EmptySubscription.b(th, subscriber);
                        return true;
                    }
                } else {
                    publisher2.i(subscriber);
                }
                return true;
            } catch (Throwable th2) {
                Exceptions.b(th2);
                EmptySubscription.b(th2, subscriber);
                return true;
            }
        } catch (Throwable th3) {
            Exceptions.b(th3);
            EmptySubscription.b(th3, subscriber);
            return true;
        }
    }
}
