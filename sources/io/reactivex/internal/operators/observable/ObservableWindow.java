package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableWindow<T> extends AbstractObservableWithUpstream<T, Observable<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f138397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f138398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f138399d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WindowExactObserver<T> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = -7481782523886138128L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f138401b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f138402c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f138403d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Disposable f138404f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        UnicastSubject f138405g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f138406h;

        WindowExactObserver(Observer observer, long j3, int i3) {
            this.f138400a = observer;
            this.f138401b = j3;
            this.f138402c = i3;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138404f, disposable)) {
                this.f138404f = disposable;
                this.f138400a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f138406h = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138406h;
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            UnicastSubject unicastSubjectD = this.f138405g;
            if (unicastSubjectD == null && !this.f138406h) {
                unicastSubjectD = UnicastSubject.D(this.f138402c, this);
                this.f138405g = unicastSubjectD;
                this.f138400a.h(unicastSubjectD);
            }
            if (unicastSubjectD != null) {
                unicastSubjectD.h(obj);
                long j3 = this.f138403d + 1;
                this.f138403d = j3;
                if (j3 >= this.f138401b) {
                    this.f138403d = 0L;
                    this.f138405g = null;
                    unicastSubjectD.onComplete();
                    if (this.f138406h) {
                        this.f138404f.dispose();
                    }
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            UnicastSubject unicastSubject = this.f138405g;
            if (unicastSubject != null) {
                this.f138405g = null;
                unicastSubject.onComplete();
            }
            this.f138400a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            UnicastSubject unicastSubject = this.f138405g;
            if (unicastSubject != null) {
                this.f138405g = null;
                unicastSubject.onError(th);
            }
            this.f138400a.onError(th);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f138406h) {
                this.f138404f.dispose();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WindowSkipObserver<T> extends AtomicBoolean implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = 3366976432059579510L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138407a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f138408b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f138409c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f138410d;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        long f138412g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f138413h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        long f138414i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Disposable f138415j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final AtomicInteger f138416k = new AtomicInteger();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final ArrayDeque f138411f = new ArrayDeque();

        WindowSkipObserver(Observer observer, long j3, long j4, int i3) {
            this.f138407a = observer;
            this.f138408b = j3;
            this.f138409c = j4;
            this.f138410d = i3;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138415j, disposable)) {
                this.f138415j = disposable;
                this.f138407a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f138413h = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138413h;
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            ArrayDeque arrayDeque = this.f138411f;
            long j3 = this.f138412g;
            long j4 = this.f138409c;
            if (j3 % j4 == 0 && !this.f138413h) {
                this.f138416k.getAndIncrement();
                UnicastSubject unicastSubjectD = UnicastSubject.D(this.f138410d, this);
                arrayDeque.offer(unicastSubjectD);
                this.f138407a.h(unicastSubjectD);
            }
            long j5 = this.f138414i + 1;
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                ((UnicastSubject) it.next()).h(obj);
            }
            if (j5 >= this.f138408b) {
                ((UnicastSubject) arrayDeque.poll()).onComplete();
                if (arrayDeque.isEmpty() && this.f138413h) {
                    this.f138415j.dispose();
                    return;
                }
                this.f138414i = j5 - j4;
            } else {
                this.f138414i = j5;
            }
            this.f138412g = j3 + 1;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            ArrayDeque arrayDeque = this.f138411f;
            while (!arrayDeque.isEmpty()) {
                ((UnicastSubject) arrayDeque.poll()).onComplete();
            }
            this.f138407a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            ArrayDeque arrayDeque = this.f138411f;
            while (!arrayDeque.isEmpty()) {
                ((UnicastSubject) arrayDeque.poll()).onError(th);
            }
            this.f138407a.onError(th);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f138416k.decrementAndGet() == 0 && this.f138413h) {
                this.f138415j.dispose();
            }
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        if (this.f138397b == this.f138398c) {
            this.f137267a.b(new WindowExactObserver(observer, this.f138397b, this.f138399d));
        } else {
            this.f137267a.b(new WindowSkipObserver(observer, this.f138397b, this.f138398c, this.f138399d));
        }
    }
}
