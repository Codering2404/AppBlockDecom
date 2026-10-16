package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.observers.BasicFuseableObserver;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableDoAfterNext<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Consumer f137604b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DoAfterObserver<T> extends BasicFuseableObserver<T, T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Consumer f137605g;

        DoAfterObserver(Observer observer, Consumer consumer) {
            super(observer);
            this.f137605g = consumer;
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f134951a.h(obj);
            if (this.f134955f == 0) {
                try {
                    this.f137605g.accept(obj);
                } catch (Throwable th) {
                    g(th);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int l(int i3) {
            return i(i3);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            Object objPoll = this.f134953c.poll();
            if (objPoll != null) {
                this.f137605g.accept(objPoll);
            }
            return objPoll;
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        this.f137267a.b(new DoAfterObserver(observer, this.f137604b));
    }
}
