package io.reactivex.subjects;

import androidx.compose.animation.core.h;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class UnicastSubject<T> extends Subject<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SpscLinkedArrayQueue f139496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference f139497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference f139498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f139499d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    volatile boolean f139500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    volatile boolean f139501g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Throwable f139502h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final AtomicBoolean f139503i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final BasicIntQueueDisposable f139504j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f139505k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        private static final long serialVersionUID = 7926949470189395511L;

        UnicastQueueDisposable() {
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            UnicastSubject.this.f139496a.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (UnicastSubject.this.f139500f) {
                return;
            }
            UnicastSubject.this.f139500f = true;
            UnicastSubject.this.E();
            UnicastSubject.this.f139497b.lazySet(null);
            if (UnicastSubject.this.f139504j.getAndIncrement() == 0) {
                UnicastSubject.this.f139497b.lazySet(null);
                UnicastSubject.this.f139496a.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return UnicastSubject.this.f139500f;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return UnicastSubject.this.f139496a.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int l(int i3) {
            if ((i3 & 2) == 0) {
                return 0;
            }
            UnicastSubject.this.f139505k = true;
            return 2;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            return UnicastSubject.this.f139496a.poll();
        }
    }

    UnicastSubject(int i3, boolean z2) {
        this.f139496a = new SpscLinkedArrayQueue(ObjectHelper.e(i3, "capacityHint"));
        this.f139498c = new AtomicReference();
        this.f139499d = z2;
        this.f139497b = new AtomicReference();
        this.f139503i = new AtomicBoolean();
        this.f139504j = new UnicastQueueDisposable();
    }

    public static UnicastSubject B() {
        return new UnicastSubject(Observable.d(), true);
    }

    public static UnicastSubject C(int i3) {
        return new UnicastSubject(i3, true);
    }

    public static UnicastSubject D(int i3, Runnable runnable) {
        return new UnicastSubject(i3, runnable, true);
    }

    void E() {
        Runnable runnable = (Runnable) this.f139498c.get();
        if (runnable == null || !h.a(this.f139498c, runnable, null)) {
            return;
        }
        runnable.run();
    }

    void F() {
        if (this.f139504j.getAndIncrement() != 0) {
            return;
        }
        Observer observer = (Observer) this.f139497b.get();
        int iAddAndGet = 1;
        while (observer == null) {
            iAddAndGet = this.f139504j.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            } else {
                observer = (Observer) this.f139497b.get();
            }
        }
        if (this.f139505k) {
            G(observer);
        } else {
            H(observer);
        }
    }

    void G(Observer observer) {
        SpscLinkedArrayQueue spscLinkedArrayQueue = this.f139496a;
        boolean z2 = this.f139499d;
        int iAddAndGet = 1;
        while (!this.f139500f) {
            boolean z3 = this.f139501g;
            if (!z2 && z3 && J(spscLinkedArrayQueue, observer)) {
                return;
            }
            observer.h(null);
            if (z3) {
                I(observer);
                return;
            } else {
                iAddAndGet = this.f139504j.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }
        this.f139497b.lazySet(null);
        spscLinkedArrayQueue.clear();
    }

    void H(Observer observer) {
        SpscLinkedArrayQueue spscLinkedArrayQueue = this.f139496a;
        boolean z2 = this.f139499d;
        boolean z3 = true;
        int iAddAndGet = 1;
        while (!this.f139500f) {
            boolean z4 = this.f139501g;
            Object objPoll = this.f139496a.poll();
            boolean z5 = objPoll == null;
            if (z4) {
                if (!z2 && z3) {
                    if (J(spscLinkedArrayQueue, observer)) {
                        return;
                    } else {
                        z3 = false;
                    }
                }
                if (z5) {
                    I(observer);
                    return;
                }
            }
            if (z5) {
                iAddAndGet = this.f139504j.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                observer.h(objPoll);
            }
        }
        this.f139497b.lazySet(null);
        spscLinkedArrayQueue.clear();
    }

    void I(Observer observer) {
        this.f139497b.lazySet(null);
        Throwable th = this.f139502h;
        if (th != null) {
            observer.onError(th);
        } else {
            observer.onComplete();
        }
    }

    boolean J(SimpleQueue simpleQueue, Observer observer) {
        Throwable th = this.f139502h;
        if (th == null) {
            return false;
        }
        this.f139497b.lazySet(null);
        simpleQueue.clear();
        observer.onError(th);
        return true;
    }

    @Override // io.reactivex.Observer
    public void a(Disposable disposable) {
        if (this.f139501g || this.f139500f) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observer
    public void h(Object obj) {
        ObjectHelper.d(obj, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f139501g || this.f139500f) {
            return;
        }
        this.f139496a.offer(obj);
        F();
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.f139501g || this.f139500f) {
            return;
        }
        this.f139501g = true;
        E();
        F();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        ObjectHelper.d(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f139501g || this.f139500f) {
            RxJavaPlugins.s(th);
            return;
        }
        this.f139502h = th;
        this.f139501g = true;
        E();
        F();
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        if (this.f139503i.get() || !this.f139503i.compareAndSet(false, true)) {
            EmptyDisposable.i(new IllegalStateException("Only a single observer allowed."), observer);
            return;
        }
        observer.a(this.f139504j);
        this.f139497b.lazySet(observer);
        if (this.f139500f) {
            this.f139497b.lazySet(null);
        } else {
            F();
        }
    }

    UnicastSubject(int i3, Runnable runnable, boolean z2) {
        this.f139496a = new SpscLinkedArrayQueue(ObjectHelper.e(i3, "capacityHint"));
        this.f139498c = new AtomicReference(ObjectHelper.d(runnable, "onTerminate"));
        this.f139499d = z2;
        this.f139497b = new AtomicReference();
        this.f139503i = new AtomicBoolean();
        this.f139504j = new UnicastQueueDisposable();
    }
}
