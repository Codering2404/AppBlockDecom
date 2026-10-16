package io.reactivex.internal.operators.maybe;

import androidx.compose.animation.core.h;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeCache<T> extends Maybe<T> implements MaybeObserver<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final CacheDisposable[] f136737f = new CacheDisposable[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final CacheDisposable[] f136738g = new CacheDisposable[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AtomicReference f136739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference f136740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f136741c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Throwable f136742d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class CacheDisposable<T> extends AtomicReference<MaybeCache<T>> implements Disposable {
        private static final long serialVersionUID = -5791853038359966195L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f136743a;

        CacheDisposable(MaybeObserver maybeObserver, MaybeCache maybeCache) {
            super(maybeCache);
            this.f136743a = maybeObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            MaybeCache<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.e(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return get() == null;
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        CacheDisposable cacheDisposable = new CacheDisposable(maybeObserver, this);
        maybeObserver.a(cacheDisposable);
        if (d(cacheDisposable)) {
            if (cacheDisposable.e()) {
                e(cacheDisposable);
                return;
            }
            MaybeSource maybeSource = (MaybeSource) this.f136739a.getAndSet(null);
            if (maybeSource != null) {
                maybeSource.b(this);
                return;
            }
            return;
        }
        if (cacheDisposable.e()) {
            return;
        }
        Throwable th = this.f136742d;
        if (th != null) {
            maybeObserver.onError(th);
            return;
        }
        Object obj = this.f136741c;
        if (obj != null) {
            maybeObserver.onSuccess(obj);
        } else {
            maybeObserver.onComplete();
        }
    }

    boolean d(CacheDisposable cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f136740b.get();
            if (cacheDisposableArr == f136738g) {
                return false;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[length + 1];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!h.a(this.f136740b, cacheDisposableArr, cacheDisposableArr2));
        return true;
    }

    void e(CacheDisposable cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f136740b.get();
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
                cacheDisposableArr2 = f136737f;
            } else {
                CacheDisposable[] cacheDisposableArr3 = new CacheDisposable[length - 1];
                System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i3);
                System.arraycopy(cacheDisposableArr, i3 + 1, cacheDisposableArr3, i3, (length - i3) - 1);
                cacheDisposableArr2 = cacheDisposableArr3;
            }
        } while (!h.a(this.f136740b, cacheDisposableArr, cacheDisposableArr2));
    }

    @Override // io.reactivex.MaybeObserver
    public void onComplete() {
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f136740b.getAndSet(f136738g)) {
            if (!cacheDisposable.e()) {
                cacheDisposable.f136743a.onComplete();
            }
        }
    }

    @Override // io.reactivex.MaybeObserver
    public void onError(Throwable th) {
        this.f136742d = th;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f136740b.getAndSet(f136738g)) {
            if (!cacheDisposable.e()) {
                cacheDisposable.f136743a.onError(th);
            }
        }
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(Object obj) {
        this.f136741c = obj;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f136740b.getAndSet(f136738g)) {
            if (!cacheDisposable.e()) {
                cacheDisposable.f136743a.onSuccess(obj);
            }
        }
    }

    @Override // io.reactivex.MaybeObserver
    public void a(Disposable disposable) {
    }
}
