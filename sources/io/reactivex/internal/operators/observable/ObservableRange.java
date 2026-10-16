package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableRange extends Observable<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f137979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f137980b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class RangeDisposable extends BasicIntQueueDisposable<Integer> {
        private static final long serialVersionUID = 396518478098735504L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137981a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f137982b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f137983c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f137984d;

        RangeDisposable(Observer observer, long j3, long j4) {
            this.f137981a = observer;
            this.f137983c = j3;
            this.f137982b = j4;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer poll() {
            long j3 = this.f137983c;
            if (j3 != this.f137982b) {
                this.f137983c = 1 + j3;
                return Integer.valueOf((int) j3);
            }
            lazySet(1);
            return null;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.f137983c = this.f137982b;
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
            return this.f137983c == this.f137982b;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int l(int i3) {
            if ((i3 & 1) == 0) {
                return 0;
            }
            this.f137984d = true;
            return 1;
        }

        void run() {
            if (this.f137984d) {
                return;
            }
            Observer observer = this.f137981a;
            long j3 = this.f137982b;
            for (long j4 = this.f137983c; j4 != j3 && get() == 0; j4++) {
                observer.h(Integer.valueOf((int) j4));
            }
            if (get() == 0) {
                lazySet(1);
                observer.onComplete();
            }
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        RangeDisposable rangeDisposable = new RangeDisposable(observer, this.f137979a, this.f137980b);
        observer.a(rangeDisposable);
        rangeDisposable.run();
    }
}
