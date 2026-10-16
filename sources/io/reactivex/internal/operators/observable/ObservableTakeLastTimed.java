package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableTakeLastTimed<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f138268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f138269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f138270d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Scheduler f138271f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final int f138272g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final boolean f138273h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TakeLastTimedObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -5677354903406201275L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138274a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f138275b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f138276c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final TimeUnit f138277d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Scheduler f138278f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final SpscLinkedArrayQueue f138279g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final boolean f138280h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Disposable f138281i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile boolean f138282j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Throwable f138283k;

        TakeLastTimedObserver(Observer observer, long j3, long j4, TimeUnit timeUnit, Scheduler scheduler, int i3, boolean z2) {
            this.f138274a = observer;
            this.f138275b = j3;
            this.f138276c = j4;
            this.f138277d = timeUnit;
            this.f138278f = scheduler;
            this.f138279g = new SpscLinkedArrayQueue(i3);
            this.f138280h = z2;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138281i, disposable)) {
                this.f138281i = disposable;
                this.f138274a.a(this);
            }
        }

        void b() {
            Throwable th;
            if (compareAndSet(false, true)) {
                Observer observer = this.f138274a;
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.f138279g;
                boolean z2 = this.f138280h;
                while (!this.f138282j) {
                    if (!z2 && (th = this.f138283k) != null) {
                        spscLinkedArrayQueue.clear();
                        observer.onError(th);
                        return;
                    }
                    Object objPoll = spscLinkedArrayQueue.poll();
                    if (objPoll == null) {
                        Throwable th2 = this.f138283k;
                        if (th2 != null) {
                            observer.onError(th2);
                            return;
                        } else {
                            observer.onComplete();
                            return;
                        }
                    }
                    Object objPoll2 = spscLinkedArrayQueue.poll();
                    if (((Long) objPoll).longValue() >= this.f138278f.c(this.f138277d) - this.f138276c) {
                        observer.h(objPoll2);
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f138282j) {
                return;
            }
            this.f138282j = true;
            this.f138281i.dispose();
            if (compareAndSet(false, true)) {
                this.f138279g.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138282j;
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f138279g;
            long jC = this.f138278f.c(this.f138277d);
            long j3 = this.f138276c;
            long j4 = this.f138275b;
            boolean z2 = j4 == Long.MAX_VALUE;
            spscLinkedArrayQueue.p(Long.valueOf(jC), obj);
            while (!spscLinkedArrayQueue.isEmpty()) {
                if (((Long) spscLinkedArrayQueue.peek()).longValue() > jC - j3 && (z2 || (spscLinkedArrayQueue.r() >> 1) <= j4)) {
                    return;
                }
                spscLinkedArrayQueue.poll();
                spscLinkedArrayQueue.poll();
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f138283k = th;
            b();
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        this.f137267a.b(new TakeLastTimedObserver(observer, this.f138268b, this.f138269c, this.f138270d, this.f138271f, this.f138272g, this.f138273h));
    }
}
