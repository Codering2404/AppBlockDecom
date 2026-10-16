package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableSequenceEqual<T> extends Observable<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ObservableSource f138139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ObservableSource f138140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final BiPredicate f138141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f138142d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = -6178010334400373240L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BiPredicate f138144b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ArrayCompositeDisposable f138145c = new ArrayCompositeDisposable(2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final ObservableSource f138146d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final ObservableSource f138147f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final EqualObserver[] f138148g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f138149h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Object f138150i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f138151j;

        EqualCoordinator(Observer observer, int i3, ObservableSource observableSource, ObservableSource observableSource2, BiPredicate biPredicate) {
            this.f138143a = observer;
            this.f138146d = observableSource;
            this.f138147f = observableSource2;
            this.f138144b = biPredicate;
            this.f138148g = new EqualObserver[]{new EqualObserver(this, 0, i3), new EqualObserver(this, 1, i3)};
        }

        void a(SpscLinkedArrayQueue spscLinkedArrayQueue, SpscLinkedArrayQueue spscLinkedArrayQueue2) {
            this.f138149h = true;
            spscLinkedArrayQueue.clear();
            spscLinkedArrayQueue2.clear();
        }

        void b() {
            Throwable th;
            Throwable th2;
            if (getAndIncrement() != 0) {
                return;
            }
            EqualObserver[] equalObserverArr = this.f138148g;
            EqualObserver equalObserver = equalObserverArr[0];
            SpscLinkedArrayQueue spscLinkedArrayQueue = equalObserver.f138153b;
            EqualObserver equalObserver2 = equalObserverArr[1];
            SpscLinkedArrayQueue spscLinkedArrayQueue2 = equalObserver2.f138153b;
            int iAddAndGet = 1;
            while (!this.f138149h) {
                boolean z2 = equalObserver.f138155d;
                if (z2 && (th2 = equalObserver.f138156f) != null) {
                    a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                    this.f138143a.onError(th2);
                    return;
                }
                boolean z3 = equalObserver2.f138155d;
                if (z3 && (th = equalObserver2.f138156f) != null) {
                    a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                    this.f138143a.onError(th);
                    return;
                }
                if (this.f138150i == null) {
                    this.f138150i = spscLinkedArrayQueue.poll();
                }
                boolean z4 = this.f138150i == null;
                if (this.f138151j == null) {
                    this.f138151j = spscLinkedArrayQueue2.poll();
                }
                Object obj = this.f138151j;
                boolean z5 = obj == null;
                if (z2 && z3 && z4 && z5) {
                    this.f138143a.h(Boolean.TRUE);
                    this.f138143a.onComplete();
                    return;
                }
                if (z2 && z3 && z4 != z5) {
                    a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                    this.f138143a.h(Boolean.FALSE);
                    this.f138143a.onComplete();
                    return;
                }
                if (!z4 && !z5) {
                    try {
                        if (!this.f138144b.test(this.f138150i, obj)) {
                            a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                            this.f138143a.h(Boolean.FALSE);
                            this.f138143a.onComplete();
                            return;
                        }
                        this.f138150i = null;
                        this.f138151j = null;
                    } catch (Throwable th3) {
                        Exceptions.b(th3);
                        a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                        this.f138143a.onError(th3);
                        return;
                    }
                }
                if (z4 || z5) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
            spscLinkedArrayQueue.clear();
            spscLinkedArrayQueue2.clear();
        }

        boolean c(Disposable disposable, int i3) {
            return this.f138145c.a(i3, disposable);
        }

        void d() {
            EqualObserver[] equalObserverArr = this.f138148g;
            this.f138146d.b(equalObserverArr[0]);
            this.f138147f.b(equalObserverArr[1]);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f138149h) {
                return;
            }
            this.f138149h = true;
            this.f138145c.dispose();
            if (getAndIncrement() == 0) {
                EqualObserver[] equalObserverArr = this.f138148g;
                equalObserverArr[0].f138153b.clear();
                equalObserverArr[1].f138153b.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138149h;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class EqualObserver<T> implements Observer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final EqualCoordinator f138152a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SpscLinkedArrayQueue f138153b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f138154c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile boolean f138155d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Throwable f138156f;

        EqualObserver(EqualCoordinator equalCoordinator, int i3, int i4) {
            this.f138152a = equalCoordinator;
            this.f138154c = i3;
            this.f138153b = new SpscLinkedArrayQueue(i4);
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            this.f138152a.c(disposable, this.f138154c);
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f138153b.offer(obj);
            this.f138152a.b();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f138155d = true;
            this.f138152a.b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f138156f = th;
            this.f138155d = true;
            this.f138152a.b();
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(observer, this.f138142d, this.f138139a, this.f138140b, this.f138141c);
        observer.a(equalCoordinator);
        equalCoordinator.d();
    }
}
