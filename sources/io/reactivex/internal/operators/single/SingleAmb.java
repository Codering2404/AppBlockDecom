package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleAmb<T> extends Single<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SingleSource[] f138726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Iterable f138727b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class AmbSingleObserver<T> implements SingleObserver<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompositeDisposable f138728a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SingleObserver f138729b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicBoolean f138730c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Disposable f138731d;

        AmbSingleObserver(SingleObserver singleObserver, CompositeDisposable compositeDisposable, AtomicBoolean atomicBoolean) {
            this.f138729b = singleObserver;
            this.f138728a = compositeDisposable;
            this.f138730c = atomicBoolean;
        }

        @Override // io.reactivex.SingleObserver
        public void a(Disposable disposable) {
            this.f138731d = disposable;
            this.f138728a.b(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            if (!this.f138730c.compareAndSet(false, true)) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f138728a.c(this.f138731d);
            this.f138728a.dispose();
            this.f138729b.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            if (this.f138730c.compareAndSet(false, true)) {
                this.f138728a.c(this.f138731d);
                this.f138728a.dispose();
                this.f138729b.onSuccess(obj);
            }
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        int length;
        SingleSource[] singleSourceArr = this.f138726a;
        if (singleSourceArr == null) {
            singleSourceArr = new SingleSource[8];
            try {
                length = 0;
                for (SingleSource singleSource : this.f138727b) {
                    if (singleSource == null) {
                        EmptyDisposable.j(new NullPointerException("One of the sources is null"), singleObserver);
                        return;
                    }
                    if (length == singleSourceArr.length) {
                        SingleSource[] singleSourceArr2 = new SingleSource[(length >> 2) + length];
                        System.arraycopy(singleSourceArr, 0, singleSourceArr2, 0, length);
                        singleSourceArr = singleSourceArr2;
                    }
                    int i3 = length + 1;
                    singleSourceArr[length] = singleSource;
                    length = i3;
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptyDisposable.j(th, singleObserver);
                return;
            }
        } else {
            length = singleSourceArr.length;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        singleObserver.a(compositeDisposable);
        for (int i4 = 0; i4 < length; i4++) {
            SingleSource singleSource2 = singleSourceArr[i4];
            if (compositeDisposable.e()) {
                return;
            }
            if (singleSource2 == null) {
                compositeDisposable.dispose();
                Throwable nullPointerException = new NullPointerException("One of the sources is null");
                if (atomicBoolean.compareAndSet(false, true)) {
                    singleObserver.onError(nullPointerException);
                    return;
                } else {
                    RxJavaPlugins.s(nullPointerException);
                    return;
                }
            }
            singleSource2.b(new AmbSingleObserver(singleObserver, compositeDisposable, atomicBoolean));
        }
    }
}
