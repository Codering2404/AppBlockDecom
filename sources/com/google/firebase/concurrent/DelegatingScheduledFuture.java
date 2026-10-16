package com.google.firebase.concurrent;

import androidx.concurrent.futures.AbstractResolvableFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class DelegatingScheduledFuture<V> extends AbstractResolvableFuture<V> implements ScheduledFuture<V> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ScheduledFuture f88174i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface Completer<T> {
        void a(Throwable th);

        void set(Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface Resolver<T> {
        ScheduledFuture a(Completer completer);
    }

    DelegatingScheduledFuture(Resolver resolver) {
        this.f88174i = resolver.a(new Completer<V>() { // from class: com.google.firebase.concurrent.DelegatingScheduledFuture.1
            @Override // com.google.firebase.concurrent.DelegatingScheduledFuture.Completer
            public void a(Throwable th) {
                DelegatingScheduledFuture.this.p(th);
            }

            @Override // com.google.firebase.concurrent.DelegatingScheduledFuture.Completer
            public void set(Object obj) {
                DelegatingScheduledFuture.this.o(obj);
            }
        });
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    protected void b() {
        this.f88174i.cancel(r());
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        return this.f88174i.getDelay(timeUnit);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public int compareTo(Delayed delayed) {
        return this.f88174i.compareTo(delayed);
    }
}
