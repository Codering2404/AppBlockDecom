package io.reactivex.internal.util;

import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public interface QueueDrain<T, U> {
    long a();

    int b(int i3);

    boolean c();

    boolean d();

    boolean f(Subscriber subscriber, Object obj);

    long i(long j3);

    Throwable p();
}
