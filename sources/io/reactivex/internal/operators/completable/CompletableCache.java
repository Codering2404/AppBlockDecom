package io.reactivex.internal.operators.completable;

import androidx.compose.animation.core.h;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableCache extends Completable implements CompletableObserver {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final InnerCompletableCache[] f135019f = new InnerCompletableCache[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final InnerCompletableCache[] f135020g = new InnerCompletableCache[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final CompletableSource f135021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference f135022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicBoolean f135023c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Throwable f135024d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class InnerCompletableCache extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 8943152917179642732L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompletableObserver f135025a;

        InnerCompletableCache(CompletableObserver completableObserver) {
            this.f135025a = completableObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true)) {
                CompletableCache.this.f(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return get();
        }
    }

    @Override // io.reactivex.Completable
    protected void c(CompletableObserver completableObserver) {
        InnerCompletableCache innerCompletableCache = new InnerCompletableCache(completableObserver);
        completableObserver.a(innerCompletableCache);
        if (e(innerCompletableCache)) {
            if (innerCompletableCache.e()) {
                f(innerCompletableCache);
            }
            if (this.f135023c.compareAndSet(false, true)) {
                this.f135021a.b(this);
                return;
            }
            return;
        }
        Throwable th = this.f135024d;
        if (th != null) {
            completableObserver.onError(th);
        } else {
            completableObserver.onComplete();
        }
    }

    boolean e(InnerCompletableCache innerCompletableCache) {
        InnerCompletableCache[] innerCompletableCacheArr;
        InnerCompletableCache[] innerCompletableCacheArr2;
        do {
            innerCompletableCacheArr = (InnerCompletableCache[]) this.f135022b.get();
            if (innerCompletableCacheArr == f135020g) {
                return false;
            }
            int length = innerCompletableCacheArr.length;
            innerCompletableCacheArr2 = new InnerCompletableCache[length + 1];
            System.arraycopy(innerCompletableCacheArr, 0, innerCompletableCacheArr2, 0, length);
            innerCompletableCacheArr2[length] = innerCompletableCache;
        } while (!h.a(this.f135022b, innerCompletableCacheArr, innerCompletableCacheArr2));
        return true;
    }

    void f(InnerCompletableCache innerCompletableCache) {
        InnerCompletableCache[] innerCompletableCacheArr;
        InnerCompletableCache[] innerCompletableCacheArr2;
        do {
            innerCompletableCacheArr = (InnerCompletableCache[]) this.f135022b.get();
            int length = innerCompletableCacheArr.length;
            if (length == 0) {
                return;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    i3 = -1;
                    break;
                } else if (innerCompletableCacheArr[i3] == innerCompletableCache) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 < 0) {
                return;
            }
            if (length == 1) {
                innerCompletableCacheArr2 = f135019f;
            } else {
                InnerCompletableCache[] innerCompletableCacheArr3 = new InnerCompletableCache[length - 1];
                System.arraycopy(innerCompletableCacheArr, 0, innerCompletableCacheArr3, 0, i3);
                System.arraycopy(innerCompletableCacheArr, i3 + 1, innerCompletableCacheArr3, i3, (length - i3) - 1);
                innerCompletableCacheArr2 = innerCompletableCacheArr3;
            }
        } while (!h.a(this.f135022b, innerCompletableCacheArr, innerCompletableCacheArr2));
    }

    @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onComplete() {
        for (InnerCompletableCache innerCompletableCache : (InnerCompletableCache[]) this.f135022b.getAndSet(f135020g)) {
            if (!innerCompletableCache.get()) {
                innerCompletableCache.f135025a.onComplete();
            }
        }
    }

    @Override // io.reactivex.CompletableObserver
    public void onError(Throwable th) {
        this.f135024d = th;
        for (InnerCompletableCache innerCompletableCache : (InnerCompletableCache[]) this.f135022b.getAndSet(f135020g)) {
            if (!innerCompletableCache.get()) {
                innerCompletableCache.f135025a.onError(th);
            }
        }
    }

    @Override // io.reactivex.CompletableObserver
    public void a(Disposable disposable) {
    }
}
