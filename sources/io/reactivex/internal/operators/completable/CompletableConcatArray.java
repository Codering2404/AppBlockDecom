package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableConcatArray extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final CompletableSource[] f135041a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ConcatInnerObserver extends AtomicInteger implements CompletableObserver {
        private static final long serialVersionUID = -7965400327305809232L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompletableObserver f135042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final CompletableSource[] f135043b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f135044c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final SequentialDisposable f135045d = new SequentialDisposable();

        ConcatInnerObserver(CompletableObserver completableObserver, CompletableSource[] completableSourceArr) {
            this.f135042a = completableObserver;
            this.f135043b = completableSourceArr;
        }

        @Override // io.reactivex.CompletableObserver
        public void a(Disposable disposable) {
            this.f135045d.a(disposable);
        }

        void b() {
            if (!this.f135045d.e() && getAndIncrement() == 0) {
                CompletableSource[] completableSourceArr = this.f135043b;
                while (!this.f135045d.e()) {
                    int i3 = this.f135044c;
                    this.f135044c = i3 + 1;
                    if (i3 == completableSourceArr.length) {
                        this.f135042a.onComplete();
                        return;
                    } else {
                        completableSourceArr[i3].b(this);
                        if (decrementAndGet() == 0) {
                            return;
                        }
                    }
                }
            }
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            b();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.f135042a.onError(th);
        }
    }

    @Override // io.reactivex.Completable
    public void c(CompletableObserver completableObserver) {
        ConcatInnerObserver concatInnerObserver = new ConcatInnerObserver(completableObserver, this.f135041a);
        completableObserver.a(concatInnerObserver.f135045d);
        concatInnerObserver.b();
    }
}
