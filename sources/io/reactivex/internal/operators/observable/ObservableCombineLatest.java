package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableCombineLatest<T, R> extends Observable<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ObservableSource[] f137450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Iterable f137451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f137452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f137453d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f137454f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class CombinerObserver<T, R> extends AtomicReference<Disposable> implements Observer<T> {
        private static final long serialVersionUID = -4823716997131257941L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final LatestCoordinator f137455a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f137456b;

        CombinerObserver(LatestCoordinator latestCoordinator, int i3) {
            this.f137455a = latestCoordinator;
            this.f137456b = i3;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            DisposableHelper.g(this, disposable);
        }

        public void b() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f137455a.g(this.f137456b, obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137455a.d(this.f137456b);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f137455a.f(this.f137456b, th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class LatestCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 8567835998786448817L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f137458b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final CombinerObserver[] f137459c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object[] f137460d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final SpscLinkedArrayQueue f137461f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final boolean f137462g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f137463h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f137464i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final AtomicThrowable f137465j = new AtomicThrowable();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f137466k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f137467l;

        LatestCoordinator(Observer observer, Function function, int i3, int i4, boolean z2) {
            this.f137457a = observer;
            this.f137458b = function;
            this.f137462g = z2;
            this.f137460d = new Object[i3];
            CombinerObserver[] combinerObserverArr = new CombinerObserver[i3];
            for (int i5 = 0; i5 < i3; i5++) {
                combinerObserverArr[i5] = new CombinerObserver(this, i5);
            }
            this.f137459c = combinerObserverArr;
            this.f137461f = new SpscLinkedArrayQueue(i4);
        }

        void a() {
            for (CombinerObserver combinerObserver : this.f137459c) {
                combinerObserver.b();
            }
        }

        void b(SpscLinkedArrayQueue spscLinkedArrayQueue) {
            synchronized (this) {
                this.f137460d = null;
            }
            spscLinkedArrayQueue.clear();
        }

        void c() {
            if (getAndIncrement() != 0) {
                return;
            }
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f137461f;
            Observer observer = this.f137457a;
            boolean z2 = this.f137462g;
            int iAddAndGet = 1;
            while (!this.f137463h) {
                if (!z2 && this.f137465j.get() != null) {
                    a();
                    b(spscLinkedArrayQueue);
                    observer.onError(this.f137465j.b());
                    return;
                }
                boolean z3 = this.f137464i;
                Object[] objArr = (Object[]) spscLinkedArrayQueue.poll();
                boolean z4 = objArr == null;
                if (z3 && z4) {
                    b(spscLinkedArrayQueue);
                    Throwable thB = this.f137465j.b();
                    if (thB == null) {
                        observer.onComplete();
                        return;
                    } else {
                        observer.onError(thB);
                        return;
                    }
                }
                if (z4) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    try {
                        observer.h(ObjectHelper.d(this.f137458b.apply(objArr), "The combiner returned a null value"));
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f137465j.a(th);
                        a();
                        b(spscLinkedArrayQueue);
                        observer.onError(this.f137465j.b());
                        return;
                    }
                }
            }
            b(spscLinkedArrayQueue);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x001b A[Catch: all -> 0x0007, TryCatch #0 {all -> 0x0007, blocks: (B:3:0x0001, B:5:0x0005, B:9:0x0009, B:14:0x0013, B:17:0x001d, B:16:0x001b), top: B:24:0x0001 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void d(int r4) {
            /*
                r3 = this;
                monitor-enter(r3)
                java.lang.Object[] r0 = r3.f137460d     // Catch: java.lang.Throwable -> L7
                if (r0 != 0) goto L9
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L7
                return
            L7:
                r4 = move-exception
                goto L27
            L9:
                r4 = r0[r4]     // Catch: java.lang.Throwable -> L7
                r1 = 1
                if (r4 != 0) goto L10
                r4 = r1
                goto L11
            L10:
                r4 = 0
            L11:
                if (r4 != 0) goto L1b
                int r2 = r3.f137467l     // Catch: java.lang.Throwable -> L7
                int r2 = r2 + r1
                r3.f137467l = r2     // Catch: java.lang.Throwable -> L7
                int r0 = r0.length     // Catch: java.lang.Throwable -> L7
                if (r2 != r0) goto L1d
            L1b:
                r3.f137464i = r1     // Catch: java.lang.Throwable -> L7
            L1d:
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L7
                if (r4 == 0) goto L23
                r3.a()
            L23:
                r3.c()
                return
            L27:
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L7
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.d(int):void");
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f137463h) {
                return;
            }
            this.f137463h = true;
            a();
            if (getAndIncrement() == 0) {
                b(this.f137461f);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137463h;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0027 A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:7:0x000e, B:9:0x0012, B:13:0x0016, B:18:0x001f, B:21:0x0029, B:20:0x0027), top: B:31:0x000e }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void f(int r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                io.reactivex.internal.util.AtomicThrowable r0 = r2.f137465j
                boolean r0 = r0.a(r4)
                if (r0 == 0) goto L37
                boolean r4 = r2.f137462g
                r0 = 1
                if (r4 == 0) goto L2e
                monitor-enter(r2)
                java.lang.Object[] r4 = r2.f137460d     // Catch: java.lang.Throwable -> L14
                if (r4 != 0) goto L16
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L14
                return
            L14:
                r3 = move-exception
                goto L2c
            L16:
                r3 = r4[r3]     // Catch: java.lang.Throwable -> L14
                if (r3 != 0) goto L1c
                r3 = r0
                goto L1d
            L1c:
                r3 = 0
            L1d:
                if (r3 != 0) goto L27
                int r1 = r2.f137467l     // Catch: java.lang.Throwable -> L14
                int r1 = r1 + r0
                r2.f137467l = r1     // Catch: java.lang.Throwable -> L14
                int r4 = r4.length     // Catch: java.lang.Throwable -> L14
                if (r1 != r4) goto L29
            L27:
                r2.f137464i = r0     // Catch: java.lang.Throwable -> L14
            L29:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L14
                r0 = r3
                goto L2e
            L2c:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L14
                throw r3
            L2e:
                if (r0 == 0) goto L33
                r2.a()
            L33:
                r2.c()
                return
            L37:
                io.reactivex.plugins.RxJavaPlugins.s(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableCombineLatest.LatestCoordinator.f(int, java.lang.Throwable):void");
        }

        void g(int i3, Object obj) {
            boolean z2;
            synchronized (this) {
                try {
                    Object[] objArr = this.f137460d;
                    if (objArr == null) {
                        return;
                    }
                    Object obj2 = objArr[i3];
                    int i4 = this.f137466k;
                    if (obj2 == null) {
                        i4++;
                        this.f137466k = i4;
                    }
                    objArr[i3] = obj;
                    if (i4 == objArr.length) {
                        this.f137461f.offer(objArr.clone());
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void h(ObservableSource[] observableSourceArr) {
            CombinerObserver[] combinerObserverArr = this.f137459c;
            int length = combinerObserverArr.length;
            this.f137457a.a(this);
            for (int i3 = 0; i3 < length && !this.f137464i && !this.f137463h; i3++) {
                observableSourceArr[i3].b(combinerObserverArr[i3]);
            }
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        int length;
        ObservableSource[] observableSourceArr = this.f137450a;
        if (observableSourceArr == null) {
            observableSourceArr = new Observable[8];
            length = 0;
            for (ObservableSource observableSource : this.f137451b) {
                if (length == observableSourceArr.length) {
                    ObservableSource[] observableSourceArr2 = new ObservableSource[(length >> 2) + length];
                    System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, length);
                    observableSourceArr = observableSourceArr2;
                }
                observableSourceArr[length] = observableSource;
                length++;
            }
        } else {
            length = observableSourceArr.length;
        }
        int i3 = length;
        if (i3 == 0) {
            EmptyDisposable.c(observer);
        } else {
            new LatestCoordinator(observer, this.f137452c, i3, this.f137453d, this.f137454f).h(observableSourceArr);
        }
    }
}
