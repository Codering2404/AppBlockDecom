package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableSequenceEqualSingle<T> extends Single<Boolean> implements FuseToObservable<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ObservableSource f138157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ObservableSource f138158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final BiPredicate f138159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f138160d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = -6178010334400373240L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f138161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BiPredicate f138162b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ArrayCompositeDisposable f138163c = new ArrayCompositeDisposable(2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final ObservableSource f138164d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final ObservableSource f138165f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final EqualObserver[] f138166g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f138167h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Object f138168i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f138169j;

        EqualCoordinator(SingleObserver singleObserver, int i3, ObservableSource observableSource, ObservableSource observableSource2, BiPredicate biPredicate) {
            this.f138161a = singleObserver;
            this.f138164d = observableSource;
            this.f138165f = observableSource2;
            this.f138162b = biPredicate;
            this.f138166g = new EqualObserver[]{new EqualObserver(this, 0, i3), new EqualObserver(this, 1, i3)};
        }

        void a(SpscLinkedArrayQueue spscLinkedArrayQueue, SpscLinkedArrayQueue spscLinkedArrayQueue2) {
            this.f138167h = true;
            spscLinkedArrayQueue.clear();
            spscLinkedArrayQueue2.clear();
        }

        void b() {
            Throwable th;
            Throwable th2;
            if (getAndIncrement() != 0) {
                return;
            }
            EqualObserver[] equalObserverArr = this.f138166g;
            EqualObserver equalObserver = equalObserverArr[0];
            SpscLinkedArrayQueue spscLinkedArrayQueue = equalObserver.f138171b;
            EqualObserver equalObserver2 = equalObserverArr[1];
            SpscLinkedArrayQueue spscLinkedArrayQueue2 = equalObserver2.f138171b;
            int iAddAndGet = 1;
            while (!this.f138167h) {
                boolean z2 = equalObserver.f138173d;
                if (z2 && (th2 = equalObserver.f138174f) != null) {
                    a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                    this.f138161a.onError(th2);
                    return;
                }
                boolean z3 = equalObserver2.f138173d;
                if (z3 && (th = equalObserver2.f138174f) != null) {
                    a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                    this.f138161a.onError(th);
                    return;
                }
                if (this.f138168i == null) {
                    this.f138168i = spscLinkedArrayQueue.poll();
                }
                boolean z4 = this.f138168i == null;
                if (this.f138169j == null) {
                    this.f138169j = spscLinkedArrayQueue2.poll();
                }
                Object obj = this.f138169j;
                boolean z5 = obj == null;
                if (z2 && z3 && z4 && z5) {
                    this.f138161a.onSuccess(Boolean.TRUE);
                    return;
                }
                if (z2 && z3 && z4 != z5) {
                    a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                    this.f138161a.onSuccess(Boolean.FALSE);
                    return;
                }
                if (!z4 && !z5) {
                    try {
                        if (!this.f138162b.test(this.f138168i, obj)) {
                            a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                            this.f138161a.onSuccess(Boolean.FALSE);
                            return;
                        } else {
                            this.f138168i = null;
                            this.f138169j = null;
                        }
                    } catch (Throwable th3) {
                        Exceptions.b(th3);
                        a(spscLinkedArrayQueue, spscLinkedArrayQueue2);
                        this.f138161a.onError(th3);
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
            return this.f138163c.a(i3, disposable);
        }

        void d() {
            EqualObserver[] equalObserverArr = this.f138166g;
            this.f138164d.b(equalObserverArr[0]);
            this.f138165f.b(equalObserverArr[1]);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f138167h) {
                return;
            }
            this.f138167h = true;
            this.f138163c.dispose();
            if (getAndIncrement() == 0) {
                EqualObserver[] equalObserverArr = this.f138166g;
                equalObserverArr[0].f138171b.clear();
                equalObserverArr[1].f138171b.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138167h;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class EqualObserver<T> implements Observer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final EqualCoordinator f138170a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SpscLinkedArrayQueue f138171b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f138172c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile boolean f138173d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Throwable f138174f;

        EqualObserver(EqualCoordinator equalCoordinator, int i3, int i4) {
            this.f138170a = equalCoordinator;
            this.f138172c = i3;
            this.f138171b = new SpscLinkedArrayQueue(i4);
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            this.f138170a.c(disposable, this.f138172c);
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f138171b.offer(obj);
            this.f138170a.b();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f138173d = true;
            this.f138170a.b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f138174f = th;
            this.f138173d = true;
            this.f138170a.b();
        }
    }

    @Override // io.reactivex.Single
    public void c(SingleObserver singleObserver) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(singleObserver, this.f138160d, this.f138157a, this.f138158b, this.f138159c);
        singleObserver.a(equalCoordinator);
        equalCoordinator.d();
    }
}
