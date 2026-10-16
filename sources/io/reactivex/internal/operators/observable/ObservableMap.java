package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicFuseableObserver;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableMap<T, U> extends AbstractObservableWithUpstream<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f137894b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MapObserver<T, U> extends BasicFuseableObserver<T, U> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Function f137895g;

        MapObserver(Observer observer, Function function) {
            super(observer);
            this.f137895g = function;
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
                this.f134951a.h(ObjectHelper.d(this.f137895g.apply(obj), "The mapper function returned a null value."));
            } catch (Throwable th) {
                g(th);
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
                return ObjectHelper.d(this.f137895g.apply(objPoll), "The mapper function returned a null value.");
            }
            return null;
        }
    }

    public ObservableMap(ObservableSource observableSource, Function function) {
        super(observableSource);
        this.f137894b = function;
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        this.f137267a.b(new MapObserver(observer, this.f137894b));
    }
}
