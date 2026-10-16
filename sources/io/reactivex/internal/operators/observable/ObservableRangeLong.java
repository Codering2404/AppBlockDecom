package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableRangeLong extends Observable<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f137985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f137986b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class RangeDisposable extends BasicIntQueueDisposable<Long> {
        private static final long serialVersionUID = 396518478098735504L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f137988b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f137989c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f137990d;

        RangeDisposable(Observer observer, long j3, long j4) {
            this.f137987a = observer;
            this.f137989c = j3;
            this.f137988b = j4;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Long poll() {
            long j3 = this.f137989c;
            if (j3 != this.f137988b) {
                this.f137989c = 1 + j3;
                return Long.valueOf(j3);
            }
            lazySet(1);
            return null;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.f137989c = this.f137988b;
            lazySet(1);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            set(1);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return get() != 0;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.f137989c == this.f137988b;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int l(int i3) {
            if ((i3 & 1) == 0) {
                return 0;
            }
            this.f137990d = true;
            return 1;
        }

        void run() {
            if (this.f137990d) {
                return;
            }
            Observer observer = this.f137987a;
            long j3 = this.f137988b;
            for (long j4 = this.f137989c; j4 != j3 && get() == 0; j4++) {
                observer.h(Long.valueOf(j4));
            }
            if (get() == 0) {
                lazySet(1);
                observer.onComplete();
            }
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        long j3 = this.f137985a;
        RangeDisposable rangeDisposable = new RangeDisposable(observer, j3, this.f137986b + j3);
        observer.a(rangeDisposable);
        rangeDisposable.run();
    }
}
