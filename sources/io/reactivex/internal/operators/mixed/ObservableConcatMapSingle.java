package io.reactivex.internal.operators.mixed;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
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
public final class ObservableConcatMapSingle<T, R> extends Observable<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Observable f137207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f137208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ErrorMode f137209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f137210d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ConcatMapSingleMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -9140123220065488293L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137211a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f137212b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicThrowable f137213c = new AtomicThrowable();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final ConcatMapSingleObserver f137214d = new ConcatMapSingleObserver(this);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final SimplePlainQueue f137215f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final ErrorMode f137216g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Disposable f137217h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f137218i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile boolean f137219j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f137220k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        volatile int f137221l;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class ConcatMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
            private static final long serialVersionUID = -3051469169682093892L;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final ConcatMapSingleMainObserver f137222a;

            ConcatMapSingleObserver(ConcatMapSingleMainObserver concatMapSingleMainObserver) {
                this.f137222a = concatMapSingleMainObserver;
            }

            @Override // io.reactivex.SingleObserver
            public void a(Disposable disposable) {
                DisposableHelper.c(this, disposable);
            }

            void b() {
                DisposableHelper.a(this);
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable th) {
                this.f137222a.c(th);
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(Object obj) {
                this.f137222a.d(obj);
            }
        }

        ConcatMapSingleMainObserver(Observer observer, Function function, int i3, ErrorMode errorMode) {
            this.f137211a = observer;
            this.f137212b = function;
            this.f137216g = errorMode;
            this.f137215f = new SpscLinkedArrayQueue(i3);
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137217h, disposable)) {
                this.f137217h = disposable;
                this.f137211a.a(this);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
        
            r2.clear();
            r10.f137220k = null;
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
                io.reactivex.Observer r0 = r10.f137211a
                io.reactivex.internal.util.ErrorMode r1 = r10.f137216g
                io.reactivex.internal.fuseable.SimplePlainQueue r2 = r10.f137215f
                io.reactivex.internal.util.AtomicThrowable r3 = r10.f137213c
                r4 = 1
                r5 = r4
            L12:
                boolean r6 = r10.f137219j
                r7 = 0
                if (r6 == 0) goto L1e
                r2.clear()
                r10.f137220k = r7
                goto L99
            L1e:
                int r6 = r10.f137221l
                java.lang.Object r8 = r3.get()
                if (r8 == 0) goto L3d
                io.reactivex.internal.util.ErrorMode r8 = io.reactivex.internal.util.ErrorMode.IMMEDIATE
                if (r1 == r8) goto L30
                io.reactivex.internal.util.ErrorMode r8 = io.reactivex.internal.util.ErrorMode.BOUNDARY
                if (r1 != r8) goto L3d
                if (r6 != 0) goto L3d
            L30:
                r2.clear()
                r10.f137220k = r7
                java.lang.Throwable r1 = r3.b()
                r0.onError(r1)
                return
            L3d:
                r8 = 0
                if (r6 != 0) goto L8b
                boolean r6 = r10.f137218i
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
                io.reactivex.functions.Function r6 = r10.f137212b     // Catch: java.lang.Throwable -> L74
                java.lang.Object r6 = r6.apply(r7)     // Catch: java.lang.Throwable -> L74
                java.lang.String r7 = "The mapper returned a null SingleSource"
                java.lang.Object r6 = io.reactivex.internal.functions.ObjectHelper.d(r6, r7)     // Catch: java.lang.Throwable -> L74
                io.reactivex.SingleSource r6 = (io.reactivex.SingleSource) r6     // Catch: java.lang.Throwable -> L74
                r10.f137221l = r4
                io.reactivex.internal.operators.mixed.ObservableConcatMapSingle$ConcatMapSingleMainObserver$ConcatMapSingleObserver r7 = r10.f137214d
                r6.b(r7)
                goto L99
            L74:
                r1 = move-exception
                io.reactivex.exceptions.Exceptions.b(r1)
                io.reactivex.disposables.Disposable r4 = r10.f137217h
                r4.dispose()
                r2.clear()
                r3.a(r1)
                java.lang.Throwable r1 = r3.b()
                r0.onError(r1)
                return
            L8b:
                r9 = 2
                if (r6 != r9) goto L99
                java.lang.Object r6 = r10.f137220k
                r10.f137220k = r7
                r0.h(r6)
                r10.f137221l = r8
                goto L12
            L99:
                int r5 = -r5
                int r5 = r10.addAndGet(r5)
                if (r5 != 0) goto L12
            La0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.mixed.ObservableConcatMapSingle.ConcatMapSingleMainObserver.b():void");
        }

        void c(Throwable th) {
            if (!this.f137213c.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (this.f137216g != ErrorMode.END) {
                this.f137217h.dispose();
            }
            this.f137221l = 0;
            b();
        }

        void d(Object obj) {
            this.f137220k = obj;
            this.f137221l = 2;
            b();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137219j = true;
            this.f137217h.dispose();
            this.f137214d.b();
            if (getAndIncrement() == 0) {
                this.f137215f.clear();
                this.f137220k = null;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137219j;
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f137215f.offer(obj);
            b();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137218i = true;
            b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.f137213c.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (this.f137216g == ErrorMode.IMMEDIATE) {
                this.f137214d.b();
            }
            this.f137218i = true;
            b();
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        if (ScalarXMapZHelper.c(this.f137207a, this.f137208b, observer)) {
            return;
        }
        this.f137207a.b(new ConcatMapSingleMainObserver(observer, this.f137208b, this.f137210d, this.f137209c));
    }
}
