package io.reactivex.internal.operators.single;

import androidx.compose.animation.core.h;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleCache<T> extends Single<T> implements SingleObserver<T> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final CacheDisposable[] f138732g = new CacheDisposable[0];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final CacheDisposable[] f138733h = new CacheDisposable[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SingleSource f138734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicInteger f138735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference f138736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f138737d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Throwable f138738f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class CacheDisposable<T> extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 7514387411091976596L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f138739a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SingleCache f138740b;

        CacheDisposable(SingleObserver singleObserver, SingleCache singleCache) {
            this.f138739a = singleObserver;
            this.f138740b = singleCache;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.f138740b.e(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return get();
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        CacheDisposable cacheDisposable = new CacheDisposable(singleObserver, this);
        singleObserver.a(cacheDisposable);
        if (d(cacheDisposable)) {
            if (cacheDisposable.e()) {
                e(cacheDisposable);
            }
            if (this.f138735b.getAndIncrement() == 0) {
                this.f138734a.b(this);
                return;
            }
            return;
        }
        Throwable th = this.f138738f;
        if (th != null) {
            singleObserver.onError(th);
        } else {
            singleObserver.onSuccess(this.f138737d);
        }
    }

    boolean d(CacheDisposable cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f138736c.get();
            if (cacheDisposableArr == f138733h) {
                return false;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[length + 1];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!h.a(this.f138736c, cacheDisposableArr, cacheDisposableArr2));
        return true;
    }

    void e(CacheDisposable cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f138736c.get();
            int length = cacheDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    i3 = -1;
                    break;
                } else if (cacheDisposableArr[i3] == cacheDisposable) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 < 0) {
                return;
            }
            if (length == 1) {
                cacheDisposableArr2 = f138732g;
            } else {
                CacheDisposable[] cacheDisposableArr3 = new CacheDisposable[length - 1];
                System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i3);
                System.arraycopy(cacheDisposableArr, i3 + 1, cacheDisposableArr3, i3, (length - i3) - 1);
                cacheDisposableArr2 = cacheDisposableArr3;
            }
        } while (!h.a(this.f138736c, cacheDisposableArr, cacheDisposableArr2));
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable th) {
        this.f138738f = th;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f138736c.getAndSet(f138733h)) {
            if (!cacheDisposable.e()) {
                cacheDisposable.f138739a.onError(th);
            }
        }
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(Object obj) {
        this.f138737d = obj;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f138736c.getAndSet(f138733h)) {
            if (!cacheDisposable.e()) {
                cacheDisposable.f138739a.onSuccess(obj);
            }
        }
    }

    @Override // io.reactivex.SingleObserver
    public void a(Disposable disposable) {
    }
}
