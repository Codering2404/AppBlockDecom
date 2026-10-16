package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.internal.observers.BasicFuseableObserver;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableDistinctUntilChanged<T, K> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f137598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final BiPredicate f137599c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DistinctUntilChangedObserver<T, K> extends BasicFuseableObserver<T, T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Function f137600g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final BiPredicate f137601h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Object f137602i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f137603j;

        DistinctUntilChangedObserver(Observer observer, Function function, BiPredicate biPredicate) {
            super(observer);
            this.f137600g = function;
            this.f137601h = biPredicate;
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f134954d) {
                return;
            }
            if (this.f134955f != 0) {
                this.f134951a.h(obj);
                return;
            }
            try {
                Object objApply = this.f137600g.apply(obj);
                if (this.f137603j) {
                    boolean zTest = this.f137601h.test(this.f137602i, objApply);
                    this.f137602i = objApply;
                    if (zTest) {
                        return;
                    }
                } else {
                    this.f137603j = true;
                    this.f137602i = objApply;
                }
                this.f134951a.h(obj);
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
            while (true) {
                Object objPoll = this.f134953c.poll();
                if (objPoll == null) {
                    return null;
                }
                Object objApply = this.f137600g.apply(objPoll);
                if (!this.f137603j) {
                    this.f137603j = true;
                    this.f137602i = objApply;
                    return objPoll;
                }
                if (!this.f137601h.test(this.f137602i, objApply)) {
                    this.f137602i = objApply;
                    return objPoll;
                }
                this.f137602i = objApply;
            }
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        this.f137267a.b(new DistinctUntilChangedObserver(observer, this.f137598b, this.f137599c));
    }
}
