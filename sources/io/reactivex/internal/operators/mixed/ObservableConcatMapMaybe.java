package io.reactivex.internal.operators.mixed;

import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableConcatMapMaybe<T, R> extends Observable<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Observable f137191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f137192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ErrorMode f137193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f137194d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ConcatMapMaybeMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -9140123220065488293L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137195a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f137196b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicThrowable f137197c = new AtomicThrowable();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final ConcatMapMaybeObserver f137198d = new ConcatMapMaybeObserver(this);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final SimplePlainQueue f137199f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final ErrorMode f137200g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Disposable f137201h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f137202i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile boolean f137203j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f137204k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        volatile int f137205l;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class ConcatMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            private static final long serialVersionUID = -3051469169682093892L;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final ConcatMapMaybeMainObserver f137206a;

            ConcatMapMaybeObserver(ConcatMapMaybeMainObserver concatMapMaybeMainObserver) {
                this.f137206a = concatMapMaybeMainObserver;
            }

            @Override // io.reactivex.MaybeObserver
            public void a(Disposable disposable) {
                DisposableHelper.c(this, disposable);
            }

            void b() {
                DisposableHelper.a(this);
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                this.f137206a.c();
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                this.f137206a.d(th);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(Object obj) {
                this.f137206a.f(obj);
            }
        }

        ConcatMapMaybeMainObserver(Observer observer, Function function, int i3, ErrorMode errorMode) {
            this.f137195a = observer;
            this.f137196b = function;
            this.f137200g = errorMode;
            this.f137199f = new SpscLinkedArrayQueue(i3);
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137201h, disposable)) {
                this.f137201h = disposable;
                this.f137195a.a(this);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
        
            r2.clear();
            r10.f137204k = null;
            r0.onError(r3.b());
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x003c, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void b() {
            /*
                r10 = this;
                int r0 = r10.getAndIncrement()
                if (r0 == 0) goto L8
                goto La0
            L8:
                io.reactivex.Observer r0 = r10.f137195a
                io.reactivex.internal.util.ErrorMode r1 = r10.f137200g
                io.reactivex.internal.fuseable.SimplePlainQueue r2 = r10.f137199f
                io.reactivex.internal.util.AtomicThrowable r3 = r10.f137197c
                r4 = 1
                r5 = r4
            L12:
                boolean r6 = r10.f137203j
                r7 = 0
                if (r6 == 0) goto L1e
                r2.clear()
                r10.f137204k = r7
                goto L99
            L1e:
                int r6 = r10.f137205l
                java.lang.Object r8 = r3.get()
                if (r8 == 0) goto L3d
                io.reactivex.internal.util.ErrorMode r8 = io.reactivex.internal.util.ErrorMode.IMMEDIATE
                if (r1 == r8) goto L30
                io.reactivex.internal.util.ErrorMode r8 = io.reactivex.internal.util.ErrorMode.BOUNDARY
                if (r1 != r8) goto L3d
                if (r6 != 0) goto L3d
            L30:
                r2.clear()
                r10.f137204k = r7
                java.lang.Throwable r1 = r3.b()
                r0.onError(r1)
                return
            L3d:
                r8 = 0
                if (r6 != 0) goto L8b
                boolean r6 = r10.f137202i
                java.lang.Object r7 = r2.poll()
                if (r7 != 0) goto L49
                r8 = r4
            L49:
                if (r6 == 0) goto L5b
                if (r8 == 0) goto L5b
                java.lang.Throwable r1 = r3.b()
                if (r1 != 0) goto L57
                r0.onComplete()
                return
            L57:
                r0.onError(r1)
                return
            L5b:
                if (r8 == 0) goto L5e
                goto L99
            L5e:
                io.reactivex.functions.Function r6 = r10.f137196b     // Catch: java.lang.Throwable -> L74
                java.lang.Object r6 = r6.apply(r7)     // Catch: java.lang.Throwable -> L74
                java.lang.String r7 = "The mapper returned a null MaybeSource"
                java.lang.Object r6 = io.reactivex.internal.functions.ObjectHelper.d(r6, r7)     // Catch: java.lang.Throwable -> L74
                io.reactivex.MaybeSource r6 = (io.reactivex.MaybeSource) r6     // Catch: java.lang.Throwable -> L74
                r10.f137205l = r4
                io.reactivex.internal.operators.mixed.ObservableConcatMapMaybe$ConcatMapMaybeMainObserver$ConcatMapMaybeObserver r7 = r10.f137198d
                r6.b(r7)
                goto L99
            L74:
                r1 = move-exception
                io.reactivex.exceptions.Exceptions.b(r1)
                io.reactivex.disposables.Disposable r4 = r10.f137201h
                r4.dispose()
                r2.clear()
                r3.a(r1)
                java.lang.Throwable r1 = r3.b()
                r0.onError(r1)
                return
            L8b:
                r9 = 2
                if (r6 != r9) goto L99
                java.lang.Object r6 = r10.f137204k
                r10.f137204k = r7
                r0.h(r6)
                r10.f137205l = r8
                goto L12
            L99:
                int r5 = -r5
                int r5 = r10.addAndGet(r5)
                if (r5 != 0) goto L12
            La0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.mixed.ObservableConcatMapMaybe.ConcatMapMaybeMainObserver.b():void");
        }

        void c() {
            this.f137205l = 0;
            b();
        }

        void d(Throwable th) {
            if (!this.f137197c.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (this.f137200g != ErrorMode.END) {
                this.f137201h.dispose();
            }
            this.f137205l = 0;
            b();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137203j = true;
            this.f137201h.dispose();
            this.f137198d.b();
            if (getAndIncrement() == 0) {
                this.f137199f.clear();
                this.f137204k = null;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137203j;
        }

        void f(Object obj) {
            this.f137204k = obj;
            this.f137205l = 2;
            b();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f137199f.offer(obj);
            b();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137202i = true;
            b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.f137197c.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (this.f137200g == ErrorMode.IMMEDIATE) {
                this.f137198d.b();
            }
            this.f137202i = true;
            b();
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        if (ScalarXMapZHelper.b(this.f137191a, this.f137192b, observer)) {
            return;
        }
        this.f137191a.b(new ConcatMapMaybeMainObserver(observer, this.f137192b, this.f137194d, this.f137193c));
    }
}
