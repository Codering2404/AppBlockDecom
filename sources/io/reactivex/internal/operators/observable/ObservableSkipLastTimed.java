package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableSkipLastTimed<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f138195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f138196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Scheduler f138197d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f138198f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final boolean f138199g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SkipLastTimedObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -5677354903406201275L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138200a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f138201b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final TimeUnit f138202c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Scheduler f138203d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final SpscLinkedArrayQueue f138204f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final boolean f138205g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Disposable f138206h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f138207i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile boolean f138208j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Throwable f138209k;

        SkipLastTimedObserver(Observer observer, long j3, TimeUnit timeUnit, Scheduler scheduler, int i3, boolean z2) {
            this.f138200a = observer;
            this.f138201b = j3;
            this.f138202c = timeUnit;
            this.f138203d = scheduler;
            this.f138204f = new SpscLinkedArrayQueue(i3);
            this.f138205g = z2;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138206h, disposable)) {
                this.f138206h = disposable;
                this.f138200a.a(this);
            }
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            Observer observer = this.f138200a;
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f138204f;
            boolean z2 = this.f138205g;
            TimeUnit timeUnit = this.f138202c;
            Scheduler scheduler = this.f138203d;
            long j3 = this.f138201b;
            int iAddAndGet = 1;
            while (!this.f138207i) {
                boolean z3 = this.f138208j;
                Long l3 = (Long) spscLinkedArrayQueue.peek();
                boolean z4 = l3 == null;
                long jC = scheduler.c(timeUnit);
                if (!z4 && l3.longValue() > jC - j3) {
                    z4 = true;
                }
                if (z3) {
                    if (!z2) {
                        Throwable th = this.f138209k;
                        if (th != null) {
                            this.f138204f.clear();
                            observer.onError(th);
                            return;
                        } else if (z4) {
                            observer.onComplete();
                            return;
                        }
                    } else if (z4) {
                        Throwable th2 = this.f138209k;
                        if (th2 != null) {
                            observer.onError(th2);
                            return;
                        } else {
                            observer.onComplete();
                            return;
                        }
                    }
                }
                if (z4) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    spscLinkedArrayQueue.poll();
                    observer.h(spscLinkedArrayQueue.poll());
                }
            }
            this.f138204f.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f138207i) {
                return;
            }
            this.f138207i = true;
            this.f138206h.dispose();
            if (getAndIncrement() == 0) {
                this.f138204f.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138207i;
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f138204f.p(Long.valueOf(this.f138203d.c(this.f138202c)), obj);
            b();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f138208j = true;
            b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f138209k = th;
            this.f138208j = true;
            b();
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        this.f137267a.b(new SkipLastTimedObserver(observer, this.f138195b, this.f138196c, this.f138197d, this.f138198f, this.f138199g));
    }
}
