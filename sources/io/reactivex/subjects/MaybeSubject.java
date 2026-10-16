package io.reactivex.subjects;

import androidx.compose.animation.core.h;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeSubject<T> extends Maybe<T> implements MaybeObserver<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final MaybeDisposable[] f139443f = new MaybeDisposable[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final MaybeDisposable[] f139444g = new MaybeDisposable[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AtomicReference f139445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicBoolean f139446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f139447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Throwable f139448d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MaybeDisposable<T> extends AtomicReference<MaybeSubject<T>> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f139449a;

        MaybeDisposable(MaybeObserver maybeObserver, MaybeSubject maybeSubject) {
            this.f139449a = maybeObserver;
            lazySet(maybeSubject);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            MaybeSubject<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.e(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return get() == null;
        }
    }

    @Override // io.reactivex.MaybeObserver
    public void a(Disposable disposable) {
        if (this.f139445a.get() == f139444g) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        MaybeDisposable maybeDisposable = new MaybeDisposable(maybeObserver, this);
        maybeObserver.a(maybeDisposable);
        if (d(maybeDisposable)) {
            if (maybeDisposable.e()) {
                e(maybeDisposable);
                return;
            }
            return;
        }
        Throwable th = this.f139448d;
        if (th != null) {
            maybeObserver.onError(th);
            return;
        }
        Object obj = this.f139447c;
        if (obj == null) {
            maybeObserver.onComplete();
        } else {
            maybeObserver.onSuccess(obj);
        }
    }

    boolean d(MaybeDisposable maybeDisposable) {
        MaybeDisposable[] maybeDisposableArr;
        MaybeDisposable[] maybeDisposableArr2;
        do {
            maybeDisposableArr = (MaybeDisposable[]) this.f139445a.get();
            if (maybeDisposableArr == f139444g) {
                return false;
            }
            int length = maybeDisposableArr.length;
            maybeDisposableArr2 = new MaybeDisposable[length + 1];
            System.arraycopy(maybeDisposableArr, 0, maybeDisposableArr2, 0, length);
            maybeDisposableArr2[length] = maybeDisposable;
        } while (!h.a(this.f139445a, maybeDisposableArr, maybeDisposableArr2));
        return true;
    }

    void e(MaybeDisposable maybeDisposable) {
        MaybeDisposable[] maybeDisposableArr;
        MaybeDisposable[] maybeDisposableArr2;
        do {
            maybeDisposableArr = (MaybeDisposable[]) this.f139445a.get();
            int length = maybeDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    i3 = -1;
                    break;
                } else if (maybeDisposableArr[i3] == maybeDisposable) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 < 0) {
                return;
            }
            if (length == 1) {
                maybeDisposableArr2 = f139443f;
            } else {
                MaybeDisposable[] maybeDisposableArr3 = new MaybeDisposable[length - 1];
                System.arraycopy(maybeDisposableArr, 0, maybeDisposableArr3, 0, i3);
                System.arraycopy(maybeDisposableArr, i3 + 1, maybeDisposableArr3, i3, (length - i3) - 1);
                maybeDisposableArr2 = maybeDisposableArr3;
            }
        } while (!h.a(this.f139445a, maybeDisposableArr, maybeDisposableArr2));
    }

    @Override // io.reactivex.MaybeObserver
    public void onComplete() {
        if (this.f139446b.compareAndSet(false, true)) {
            for (MaybeDisposable maybeDisposable : (MaybeDisposable[]) this.f139445a.getAndSet(f139444g)) {
                maybeDisposable.f139449a.onComplete();
            }
        }
    }

    @Override // io.reactivex.MaybeObserver
    public void onError(Throwable th) {
        ObjectHelper.d(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f139446b.compareAndSet(false, true)) {
            RxJavaPlugins.s(th);
            return;
        }
        this.f139448d = th;
        for (MaybeDisposable maybeDisposable : (MaybeDisposable[]) this.f139445a.getAndSet(f139444g)) {
            maybeDisposable.f139449a.onError(th);
        }
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(Object obj) {
        ObjectHelper.d(obj, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f139446b.compareAndSet(false, true)) {
            this.f139447c = obj;
            for (MaybeDisposable maybeDisposable : (MaybeDisposable[]) this.f139445a.getAndSet(f139444g)) {
                maybeDisposable.f139449a.onSuccess(obj);
            }
        }
    }
}
