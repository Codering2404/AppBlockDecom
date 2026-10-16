package io.reactivex.parallel;

import io.reactivex.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class ParallelFlowable<T> {
    public abstract int a();

    public abstract void b(Subscriber[] subscriberArr);

    protected final boolean c(Subscriber[] subscriberArr) {
        int iA = a();
        if (subscriberArr.length == iA) {
            return true;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("parallelism = " + iA + ", subscribers = " + subscriberArr.length);
        int length = subscriberArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            EmptySubscription.b(illegalArgumentException, subscriberArr[i3]);
        }
        return false;
    }
}
