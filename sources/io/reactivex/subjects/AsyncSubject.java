package io.reactivex.subjects;

import androidx.compose.animation.core.h;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class AsyncSubject<T> extends Subject<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final AsyncDisposable[] f139414d = new AsyncDisposable[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final AsyncDisposable[] f139415f = new AsyncDisposable[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AtomicReference f139416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Throwable f139417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f139418c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class AsyncDisposable<T> extends DeferredScalarDisposable<T> {
        private static final long serialVersionUID = 5629876084736248016L;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AsyncSubject f139419c;

        AsyncDisposable(Observer observer, AsyncSubject asyncSubject) {
            super(observer);
            this.f139419c = asyncSubject;
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
        public void dispose() {
            if (super.i()) {
                this.f139419c.C(this);
            }
        }

        void onComplete() {
            if (e()) {
                return;
            }
            this.f134971a.onComplete();
        }

        void onError(Throwable th) {
            if (e()) {
                RxJavaPlugins.s(th);
            } else {
                this.f134971a.onError(th);
            }
        }
    }

    boolean B(AsyncDisposable asyncDisposable) {
        AsyncDisposable[] asyncDisposableArr;
        AsyncDisposable[] asyncDisposableArr2;
        do {
            asyncDisposableArr = (AsyncDisposable[]) this.f139416a.get();
            if (asyncDisposableArr == f139415f) {
                return false;
            }
            int length = asyncDisposableArr.length;
            asyncDisposableArr2 = new AsyncDisposable[length + 1];
            System.arraycopy(asyncDisposableArr, 0, asyncDisposableArr2, 0, length);
            asyncDisposableArr2[length] = asyncDisposable;
        } while (!h.a(this.f139416a, asyncDisposableArr, asyncDisposableArr2));
        return true;
    }

    void C(AsyncDisposable asyncDisposable) {
        AsyncDisposable[] asyncDisposableArr;
        AsyncDisposable[] asyncDisposableArr2;
        do {
            asyncDisposableArr = (AsyncDisposable[]) this.f139416a.get();
            int length = asyncDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    i3 = -1;
                    break;
                } else if (asyncDisposableArr[i3] == asyncDisposable) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 < 0) {
                return;
            }
            if (length == 1) {
                asyncDisposableArr2 = f139414d;
            } else {
                AsyncDisposable[] asyncDisposableArr3 = new AsyncDisposable[length - 1];
                System.arraycopy(asyncDisposableArr, 0, asyncDisposableArr3, 0, i3);
                System.arraycopy(asyncDisposableArr, i3 + 1, asyncDisposableArr3, i3, (length - i3) - 1);
                asyncDisposableArr2 = asyncDisposableArr3;
            }
        } while (!h.a(this.f139416a, asyncDisposableArr, asyncDisposableArr2));
    }

    @Override // io.reactivex.Observer
    public void a(Disposable disposable) {
        if (this.f139416a.get() == f139415f) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observer
    public void h(Object obj) {
        ObjectHelper.d(obj, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f139416a.get() == f139415f) {
            return;
        }
        this.f139418c = obj;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        Object obj = this.f139416a.get();
        Object obj2 = f139415f;
        if (obj == obj2) {
            return;
        }
        Object obj3 = this.f139418c;
        AsyncDisposable[] asyncDisposableArr = (AsyncDisposable[]) this.f139416a.getAndSet(obj2);
        int i3 = 0;
        if (obj3 == null) {
            int length = asyncDisposableArr.length;
            while (i3 < length) {
                asyncDisposableArr[i3].onComplete();
                i3++;
            }
            return;
        }
        int length2 = asyncDisposableArr.length;
        while (i3 < length2) {
            asyncDisposableArr[i3].c(obj3);
            i3++;
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        ObjectHelper.d(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        Object obj = this.f139416a.get();
        Object obj2 = f139415f;
        if (obj == obj2) {
            RxJavaPlugins.s(th);
            return;
        }
        this.f139418c = null;
        this.f139417b = th;
        for (AsyncDisposable asyncDisposable : (AsyncDisposable[]) this.f139416a.getAndSet(obj2)) {
            asyncDisposable.onError(th);
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        AsyncDisposable asyncDisposable = new AsyncDisposable(observer, this);
        observer.a(asyncDisposable);
        if (B(asyncDisposable)) {
            if (asyncDisposable.e()) {
                C(asyncDisposable);
                return;
            }
            return;
        }
        Throwable th = this.f139417b;
        if (th != null) {
            observer.onError(th);
            return;
        }
        Object obj = this.f139418c;
        if (obj != null) {
            asyncDisposable.c(obj);
        } else {
            asyncDisposable.onComplete();
        }
    }
}
