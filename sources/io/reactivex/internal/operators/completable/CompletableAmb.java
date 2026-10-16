package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableAmb extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CompletableSource[] f135007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Iterable f135008b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Amb implements CompletableObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicBoolean f135009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final CompositeDisposable f135010b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final CompletableObserver f135011c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Disposable f135012d;

        Amb(AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, CompletableObserver completableObserver) {
            this.f135009a = atomicBoolean;
            this.f135010b = compositeDisposable;
            this.f135011c = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver
        public void a(Disposable disposable) {
            this.f135012d = disposable;
            this.f135010b.b(disposable);
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            if (this.f135009a.compareAndSet(false, true)) {
                this.f135010b.c(this.f135012d);
                this.f135010b.dispose();
                this.f135011c.onComplete();
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            if (!this.f135009a.compareAndSet(false, true)) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f135010b.c(this.f135012d);
            this.f135010b.dispose();
            this.f135011c.onError(th);
        }
    }

    @Override // io.reactivex.Completable
    public void c(CompletableObserver completableObserver) {
        int length;
        CompletableSource[] completableSourceArr = this.f135007a;
        if (completableSourceArr == null) {
            completableSourceArr = new CompletableSource[8];
            try {
                length = 0;
                for (CompletableSource completableSource : this.f135008b) {
                    if (completableSource == null) {
                        EmptyDisposable.g(new NullPointerException("One of the sources is null"), completableObserver);
                        return;
                    }
                    if (length == completableSourceArr.length) {
                        CompletableSource[] completableSourceArr2 = new CompletableSource[(length >> 2) + length];
                        System.arraycopy(completableSourceArr, 0, completableSourceArr2, 0, length);
                        completableSourceArr = completableSourceArr2;
                    }
                    int i3 = length + 1;
                    completableSourceArr[length] = completableSource;
                    length = i3;
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptyDisposable.g(th, completableObserver);
                return;
            }
        } else {
            length = completableSourceArr.length;
        }
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.a(compositeDisposable);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        for (int i4 = 0; i4 < length; i4++) {
            CompletableSource completableSource2 = completableSourceArr[i4];
            if (compositeDisposable.e()) {
                return;
            }
            if (completableSource2 == null) {
                Throwable nullPointerException = new NullPointerException("One of the sources is null");
                if (!atomicBoolean.compareAndSet(false, true)) {
                    RxJavaPlugins.s(nullPointerException);
                    return;
                } else {
                    compositeDisposable.dispose();
                    completableObserver.onError(nullPointerException);
                    return;
                }
            }
            completableSource2.b(new Amb(atomicBoolean, compositeDisposable, completableObserver));
        }
        if (length == 0) {
            completableObserver.onComplete();
        }
    }
}
