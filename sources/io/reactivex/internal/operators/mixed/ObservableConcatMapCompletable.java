package io.reactivex.internal.operators.mixed;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableConcatMapCompletable<T> extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Observable f137175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f137176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ErrorMode f137177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f137178d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ConcatMapCompletableObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 3610901111000061034L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompletableObserver f137179a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f137180b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ErrorMode f137181c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicThrowable f137182d = new AtomicThrowable();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final ConcatMapInnerObserver f137183f = new ConcatMapInnerObserver(this);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final int f137184g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        SimpleQueue f137185h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Disposable f137186i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile boolean f137187j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        volatile boolean f137188k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        volatile boolean f137189l;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class ConcatMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = 5638352172918776687L;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final ConcatMapCompletableObserver f137190a;

            ConcatMapInnerObserver(ConcatMapCompletableObserver concatMapCompletableObserver) {
                this.f137190a = concatMapCompletableObserver;
            }

            @Override // io.reactivex.CompletableObserver
            public void a(Disposable disposable) {
                DisposableHelper.c(this, disposable);
            }

            void b() {
                DisposableHelper.a(this);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                this.f137190a.c();
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                this.f137190a.d(th);
            }
        }

        ConcatMapCompletableObserver(CompletableObserver completableObserver, Function function, ErrorMode errorMode, int i3) {
            this.f137179a = completableObserver;
            this.f137180b = function;
            this.f137181c = errorMode;
            this.f137184g = i3;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137186i, disposable)) {
                this.f137186i = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int iL = queueDisposable.l(3);
                    if (iL == 1) {
                        this.f137185h = queueDisposable;
                        this.f137188k = true;
                        this.f137179a.a(this);
                        b();
                        return;
                    }
                    if (iL == 2) {
                        this.f137185h = queueDisposable;
                        this.f137179a.a(this);
                        return;
                    }
                }
                this.f137185h = new SpscLinkedArrayQueue(this.f137184g);
                this.f137179a.a(this);
            }
        }

        void b() {
            CompletableSource completableSource;
            boolean z2;
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicThrowable atomicThrowable = this.f137182d;
            ErrorMode errorMode = this.f137181c;
            while (!this.f137189l) {
                if (!this.f137187j) {
                    if (errorMode == ErrorMode.BOUNDARY && atomicThrowable.get() != null) {
                        this.f137189l = true;
                        this.f137185h.clear();
                        this.f137179a.onError(atomicThrowable.b());
                        return;
                    }
                    boolean z3 = this.f137188k;
                    try {
                        Object objPoll = this.f137185h.poll();
                        if (objPoll != null) {
                            completableSource = (CompletableSource) ObjectHelper.d(this.f137180b.apply(objPoll), "The mapper returned a null CompletableSource");
                            z2 = false;
                        } else {
                            completableSource = null;
                            z2 = true;
                        }
                        if (z3 && z2) {
                            this.f137189l = true;
                            Throwable thB = atomicThrowable.b();
                            if (thB != null) {
                                this.f137179a.onError(thB);
                                return;
                            } else {
                                this.f137179a.onComplete();
                                return;
                            }
                        }
                        if (!z2) {
                            this.f137187j = true;
                            completableSource.b(this.f137183f);
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f137189l = true;
                        this.f137185h.clear();
                        this.f137186i.dispose();
                        atomicThrowable.a(th);
                        this.f137179a.onError(atomicThrowable.b());
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.f137185h.clear();
        }

        void c() {
            this.f137187j = false;
            b();
        }

        void d(Throwable th) {
            if (!this.f137182d.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (this.f137181c != ErrorMode.IMMEDIATE) {
                this.f137187j = false;
                b();
                return;
            }
            this.f137189l = true;
            this.f137186i.dispose();
            Throwable thB = this.f137182d.b();
            if (thB != ExceptionHelper.f139204a) {
                this.f137179a.onError(thB);
            }
            if (getAndIncrement() == 0) {
                this.f137185h.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137189l = true;
            this.f137186i.dispose();
            this.f137183f.b();
            if (getAndIncrement() == 0) {
                this.f137185h.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137189l;
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (obj != null) {
                this.f137185h.offer(obj);
            }
            b();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137188k = true;
            b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.f137182d.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (this.f137181c != ErrorMode.IMMEDIATE) {
                this.f137188k = true;
                b();
                return;
            }
            this.f137189l = true;
            this.f137183f.b();
            Throwable thB = this.f137182d.b();
            if (thB != ExceptionHelper.f139204a) {
                this.f137179a.onError(thB);
            }
            if (getAndIncrement() == 0) {
                this.f137185h.clear();
            }
        }
    }

    @Override // io.reactivex.Completable
    protected void c(CompletableObserver completableObserver) {
        if (ScalarXMapZHelper.a(this.f137175a, this.f137176b, completableObserver)) {
            return;
        }
        this.f137175a.b(new ConcatMapCompletableObserver(completableObserver, this.f137176b, this.f137177c, this.f137178d));
    }
}
