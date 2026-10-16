package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicFuseableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableDistinct<T, K> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f137594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Callable f137595c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DistinctObserver<T, K> extends BasicFuseableObserver<T, T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Collection f137596g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final Function f137597h;

        DistinctObserver(Observer observer, Function function, Collection collection) {
            super(observer);
            this.f137597h = function;
            this.f137596g = collection;
        }

        @Override // io.reactivex.internal.observers.BasicFuseableObserver, io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.f137596g.clear();
            super.clear();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f134954d) {
                return;
            }
            if (this.f134955f != 0) {
                this.f134951a.h(null);
                return;
            }
            try {
                if (this.f137596g.add(ObjectHelper.d(this.f137597h.apply(obj), "The keySelector returned a null key"))) {
                    this.f134951a.h(obj);
                }
            } catch (Throwable th) {
                g(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int l(int i3) {
            return i(i3);
        }

        @Override // io.reactivex.internal.observers.BasicFuseableObserver, io.reactivex.Observer
        public void onComplete() {
            if (this.f134954d) {
                return;
            }
            this.f134954d = true;
            this.f137596g.clear();
            this.f134951a.onComplete();
        }

        @Override // io.reactivex.internal.observers.BasicFuseableObserver, io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f134954d) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f134954d = true;
            this.f137596g.clear();
            this.f134951a.onError(th);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            Object objPoll;
            do {
                objPoll = this.f134953c.poll();
                if (objPoll == null) {
                    break;
                }
            } while (!this.f137596g.add(ObjectHelper.d(this.f137597h.apply(objPoll), "The keySelector returned a null key")));
            return objPoll;
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        try {
            this.f137267a.b(new DistinctObserver(observer, this.f137594b, (Collection) ObjectHelper.d(this.f137595c.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.i(th, observer);
        }
    }
}
