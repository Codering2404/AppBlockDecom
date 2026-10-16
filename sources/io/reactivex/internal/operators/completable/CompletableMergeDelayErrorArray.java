package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableMergeDelayErrorArray extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final CompletableSource[] f135116a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MergeInnerCompletableObserver implements CompletableObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompletableObserver f135117a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final CompositeDisposable f135118b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicThrowable f135119c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicInteger f135120d;

        MergeInnerCompletableObserver(CompletableObserver completableObserver, CompositeDisposable compositeDisposable, AtomicThrowable atomicThrowable, AtomicInteger atomicInteger) {
            this.f135117a = completableObserver;
            this.f135118b = compositeDisposable;
            this.f135119c = atomicThrowable;
            this.f135120d = atomicInteger;
        }

        @Override // io.reactivex.CompletableObserver
        public void a(Disposable disposable) {
            this.f135118b.b(disposable);
        }

        void b() {
            if (this.f135120d.decrementAndGet() == 0) {
                Throwable thB = this.f135119c.b();
                if (thB == null) {
                    this.f135117a.onComplete();
                } else {
                    this.f135117a.onError(thB);
                }
            }
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            b();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            if (this.f135119c.a(th)) {
                b();
            } else {
                RxJavaPlugins.s(th);
            }
        }
    }

    @Override // io.reactivex.Completable
    public void c(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        AtomicInteger atomicInteger = new AtomicInteger(this.f135116a.length + 1);
        AtomicThrowable atomicThrowable = new AtomicThrowable();
        completableObserver.a(compositeDisposable);
        for (CompletableSource completableSource : this.f135116a) {
            if (compositeDisposable.e()) {
                return;
            }
            if (completableSource == null) {
                atomicThrowable.a(new NullPointerException("A completable source is null"));
                atomicInteger.decrementAndGet();
            } else {
                completableSource.b(new MergeInnerCompletableObserver(completableObserver, compositeDisposable, atomicThrowable, atomicInteger));
            }
        }
        if (atomicInteger.decrementAndGet() == 0) {
            Throwable thB = atomicThrowable.b();
            if (thB == null) {
                completableObserver.onComplete();
            } else {
                completableObserver.onError(thB);
            }
        }
    }
}
