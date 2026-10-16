package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.observers.BasicFuseableObserver;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableFilter<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Predicate f137653b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FilterObserver<T> extends BasicFuseableObserver<T, T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Predicate f137654g;

        FilterObserver(Observer observer, Predicate predicate) {
            super(observer);
            this.f137654g = predicate;
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f134955f != 0) {
                this.f134951a.h(null);
                return;
            }
            try {
                if (this.f137654g.test(obj)) {
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

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            Object objPoll;
            do {
                objPoll = this.f134953c.poll();
                if (objPoll == null) {
                    break;
                }
            } while (!this.f137654g.test(objPoll));
            return objPoll;
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        this.f137267a.b(new FilterObserver(observer, this.f137653b));
    }
}
