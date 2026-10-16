package io.reactivex.internal.operators.observable;

import androidx.compose.animation.core.h;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableCache<T> extends AbstractObservableWithUpstream<T, T> implements Observer<T> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final CacheDisposable[] f137416l = new CacheDisposable[0];

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final CacheDisposable[] f137417m = new CacheDisposable[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicBoolean f137418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f137419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final AtomicReference f137420d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    volatile long f137421f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Node f137422g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Node f137423h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f137424i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Throwable f137425j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    volatile boolean f137426k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class CacheDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 6770240836423125754L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137427a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ObservableCache f137428b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Node f137429c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f137430d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f137431f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        volatile boolean f137432g;

        CacheDisposable(Observer observer, ObservableCache observableCache) {
            this.f137427a = observer;
            this.f137428b = observableCache;
            this.f137429c = observableCache.f137422g;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f137432g) {
                return;
            }
            this.f137432g = true;
            this.f137428b.B(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137432g;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Node<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object[] f137433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile Node f137434b;

        Node(int i3) {
            this.f137433a = new Object[i3];
        }
    }

    void A(CacheDisposable cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f137420d.get();
            if (cacheDisposableArr == f137417m) {
                return;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[length + 1];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!h.a(this.f137420d, cacheDisposableArr, cacheDisposableArr2));
    }

    void B(CacheDisposable cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f137420d.get();
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
                cacheDisposableArr2 = f137416l;
            } else {
                CacheDisposable[] cacheDisposableArr3 = new CacheDisposable[length - 1];
                System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i3);
                System.arraycopy(cacheDisposableArr, i3 + 1, cacheDisposableArr3, i3, (length - i3) - 1);
                cacheDisposableArr2 = cacheDisposableArr3;
            }
        } while (!h.a(this.f137420d, cacheDisposableArr, cacheDisposableArr2));
    }

    void C(CacheDisposable cacheDisposable) {
        if (cacheDisposable.getAndIncrement() != 0) {
            return;
        }
        long j3 = cacheDisposable.f137431f;
        int i3 = cacheDisposable.f137430d;
        Node node = cacheDisposable.f137429c;
        Observer observer = cacheDisposable.f137427a;
        int i4 = this.f137419c;
        int iAddAndGet = 1;
        while (!cacheDisposable.f137432g) {
            boolean z2 = this.f137426k;
            boolean z3 = this.f137421f == j3;
            if (z2 && z3) {
                cacheDisposable.f137429c = null;
                Throwable th = this.f137425j;
                if (th != null) {
                    observer.onError(th);
                    return;
                } else {
                    observer.onComplete();
                    return;
                }
            }
            if (z3) {
                cacheDisposable.f137431f = j3;
                cacheDisposable.f137430d = i3;
                cacheDisposable.f137429c = node;
                iAddAndGet = cacheDisposable.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                if (i3 == i4) {
                    node = node.f137434b;
                    i3 = 0;
                }
                observer.h(node.f137433a[i3]);
                i3++;
                j3++;
            }
        }
        cacheDisposable.f137429c = null;
    }

    @Override // io.reactivex.Observer
    public void h(Object obj) {
        int i3 = this.f137424i;
        if (i3 == this.f137419c) {
            Node node = new Node(i3);
            node.f137433a[0] = obj;
            this.f137424i = 1;
            this.f137423h.f137434b = node;
            this.f137423h = node;
        } else {
            this.f137423h.f137433a[i3] = obj;
            this.f137424i = i3 + 1;
        }
        this.f137421f++;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f137420d.get()) {
            C(cacheDisposable);
        }
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.f137426k = true;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f137420d.getAndSet(f137417m)) {
            C(cacheDisposable);
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        this.f137425j = th;
        this.f137426k = true;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f137420d.getAndSet(f137417m)) {
            C(cacheDisposable);
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        CacheDisposable cacheDisposable = new CacheDisposable(observer, this);
        observer.a(cacheDisposable);
        A(cacheDisposable);
        if (this.f137418b.get() || !this.f137418b.compareAndSet(false, true)) {
            C(cacheDisposable);
        } else {
            this.f137267a.b(this);
        }
    }

    @Override // io.reactivex.Observer
    public void a(Disposable disposable) {
    }
}
