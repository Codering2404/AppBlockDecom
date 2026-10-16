package io.reactivex.subjects;

import androidx.compose.animation.core.h;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableSubject extends Completable implements CompletableObserver {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final CompletableDisposable[] f139437d = new CompletableDisposable[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final CompletableDisposable[] f139438f = new CompletableDisposable[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AtomicReference f139439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicBoolean f139440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Throwable f139441c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class CompletableDisposable extends AtomicReference<CompletableSubject> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompletableObserver f139442a;

        CompletableDisposable(CompletableObserver completableObserver, CompletableSubject completableSubject) {
            this.f139442a = completableObserver;
            lazySet(completableSubject);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            CompletableSubject andSet = getAndSet(null);
            if (andSet != null) {
                andSet.f(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return get() == null;
        }
    }

    @Override // io.reactivex.CompletableObserver
    public void a(Disposable disposable) {
        if (this.f139439a.get() == f139438f) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Completable
    protected void c(CompletableObserver completableObserver) {
        CompletableDisposable completableDisposable = new CompletableDisposable(completableObserver, this);
        completableObserver.a(completableDisposable);
        if (e(completableDisposable)) {
            if (completableDisposable.e()) {
                f(completableDisposable);
            }
        } else {
            Throwable th = this.f139441c;
            if (th != null) {
                completableObserver.onError(th);
            } else {
                completableObserver.onComplete();
            }
        }
    }

    boolean e(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = (CompletableDisposable[]) this.f139439a.get();
            if (completableDisposableArr == f139438f) {
                return false;
            }
            int length = completableDisposableArr.length;
            completableDisposableArr2 = new CompletableDisposable[length + 1];
            System.arraycopy(completableDisposableArr, 0, completableDisposableArr2, 0, length);
            completableDisposableArr2[length] = completableDisposable;
        } while (!h.a(this.f139439a, completableDisposableArr, completableDisposableArr2));
        return true;
    }

    void f(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = (CompletableDisposable[]) this.f139439a.get();
            int length = completableDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    i3 = -1;
                    break;
                } else if (completableDisposableArr[i3] == completableDisposable) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 < 0) {
                return;
            }
            if (length == 1) {
                completableDisposableArr2 = f139437d;
            } else {
                CompletableDisposable[] completableDisposableArr3 = new CompletableDisposable[length - 1];
                System.arraycopy(completableDisposableArr, 0, completableDisposableArr3, 0, i3);
                System.arraycopy(completableDisposableArr, i3 + 1, completableDisposableArr3, i3, (length - i3) - 1);
                completableDisposableArr2 = completableDisposableArr3;
            }
        } while (!h.a(this.f139439a, completableDisposableArr, completableDisposableArr2));
    }

    @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onComplete() {
        if (this.f139440b.compareAndSet(false, true)) {
            for (CompletableDisposable completableDisposable : (CompletableDisposable[]) this.f139439a.getAndSet(f139438f)) {
                completableDisposable.f139442a.onComplete();
            }
        }
    }

    @Override // io.reactivex.CompletableObserver
    public void onError(Throwable th) {
        ObjectHelper.d(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f139440b.compareAndSet(false, true)) {
            RxJavaPlugins.s(th);
            return;
        }
        this.f139441c = th;
        for (CompletableDisposable completableDisposable : (CompletableDisposable[]) this.f139439a.getAndSet(f139438f)) {
            completableDisposable.f139442a.onError(th);
        }
    }
}
