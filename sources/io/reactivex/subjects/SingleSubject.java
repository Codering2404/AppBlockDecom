package io.reactivex.subjects;

import androidx.compose.animation.core.h;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleSubject<T> extends Single<T> implements SingleObserver<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final SingleDisposable[] f139489f = new SingleDisposable[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final SingleDisposable[] f139490g = new SingleDisposable[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AtomicReference f139491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicBoolean f139492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f139493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Throwable f139494d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SingleDisposable<T> extends AtomicReference<SingleSubject<T>> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f139495a;

        SingleDisposable(SingleObserver singleObserver, SingleSubject singleSubject) {
            this.f139495a = singleObserver;
            lazySet(singleSubject);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SingleSubject<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.e(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return get() == null;
        }
    }

    @Override // io.reactivex.SingleObserver
    public void a(Disposable disposable) {
        if (this.f139491a.get() == f139490g) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        SingleDisposable singleDisposable = new SingleDisposable(singleObserver, this);
        singleObserver.a(singleDisposable);
        if (d(singleDisposable)) {
            if (singleDisposable.e()) {
                e(singleDisposable);
            }
        } else {
            Throwable th = this.f139494d;
            if (th != null) {
                singleObserver.onError(th);
            } else {
                singleObserver.onSuccess(this.f139493c);
            }
        }
    }

    boolean d(SingleDisposable singleDisposable) {
        SingleDisposable[] singleDisposableArr;
        SingleDisposable[] singleDisposableArr2;
        do {
            singleDisposableArr = (SingleDisposable[]) this.f139491a.get();
            if (singleDisposableArr == f139490g) {
                return false;
            }
            int length = singleDisposableArr.length;
            singleDisposableArr2 = new SingleDisposable[length + 1];
            System.arraycopy(singleDisposableArr, 0, singleDisposableArr2, 0, length);
            singleDisposableArr2[length] = singleDisposable;
        } while (!h.a(this.f139491a, singleDisposableArr, singleDisposableArr2));
        return true;
    }

    void e(SingleDisposable singleDisposable) {
        SingleDisposable[] singleDisposableArr;
        SingleDisposable[] singleDisposableArr2;
        do {
            singleDisposableArr = (SingleDisposable[]) this.f139491a.get();
            int length = singleDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    i3 = -1;
                    break;
                } else if (singleDisposableArr[i3] == singleDisposable) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 < 0) {
                return;
            }
            if (length == 1) {
                singleDisposableArr2 = f139489f;
            } else {
                SingleDisposable[] singleDisposableArr3 = new SingleDisposable[length - 1];
                System.arraycopy(singleDisposableArr, 0, singleDisposableArr3, 0, i3);
                System.arraycopy(singleDisposableArr, i3 + 1, singleDisposableArr3, i3, (length - i3) - 1);
                singleDisposableArr2 = singleDisposableArr3;
            }
        } while (!h.a(this.f139491a, singleDisposableArr, singleDisposableArr2));
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable th) {
        ObjectHelper.d(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f139492b.compareAndSet(false, true)) {
            RxJavaPlugins.s(th);
            return;
        }
        this.f139494d = th;
        for (SingleDisposable singleDisposable : (SingleDisposable[]) this.f139491a.getAndSet(f139490g)) {
            singleDisposable.f139495a.onError(th);
        }
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(Object obj) {
        ObjectHelper.d(obj, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f139492b.compareAndSet(false, true)) {
            this.f139493c = obj;
            for (SingleDisposable singleDisposable : (SingleDisposable[]) this.f139491a.getAndSet(f139490g)) {
                singleDisposable.f139495a.onSuccess(obj);
            }
        }
    }
}
