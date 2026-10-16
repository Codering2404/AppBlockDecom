package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableMergeWithCompletable<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final CompletableSource f137906b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MergeWithObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -4592979584110982903L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReference f137908b = new AtomicReference();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final OtherObserver f137909c = new OtherObserver(this);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicThrowable f137910d = new AtomicThrowable();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile boolean f137911f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        volatile boolean f137912g;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -2935427570954647017L;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final MergeWithObserver f137913a;

            OtherObserver(MergeWithObserver mergeWithObserver) {
                this.f137913a = mergeWithObserver;
            }

            @Override // io.reactivex.CompletableObserver
            public void a(Disposable disposable) {
                DisposableHelper.g(this, disposable);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                this.f137913a.b();
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                this.f137913a.c(th);
            }
        }

        MergeWithObserver(Observer observer) {
            this.f137907a = observer;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            DisposableHelper.g(this.f137908b, disposable);
        }

        void b() {
            this.f137912g = true;
            if (this.f137911f) {
                HalfSerializer.a(this.f137907a, this, this.f137910d);
            }
        }

        void c(Throwable th) {
            DisposableHelper.a(this.f137908b);
            HalfSerializer.c(this.f137907a, th, this, this.f137910d);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this.f137908b);
            DisposableHelper.a(this.f137909c);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b((Disposable) this.f137908b.get());
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            HalfSerializer.e(this.f137907a, obj, this, this.f137910d);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137911f = true;
            if (this.f137912g) {
                HalfSerializer.a(this.f137907a, this, this.f137910d);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            DisposableHelper.a(this.f137908b);
            HalfSerializer.c(this.f137907a, th, this, this.f137910d);
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(observer);
        observer.a(mergeWithObserver);
        this.f137267a.b(mergeWithObserver);
        this.f137906b.b(mergeWithObserver.f137909c);
    }
}
