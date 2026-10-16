package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeAmb<T> extends Maybe<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaybeSource[] f136731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Iterable f136732b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class AmbMaybeObserver<T> implements MaybeObserver<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f136733a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicBoolean f136734b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final CompositeDisposable f136735c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Disposable f136736d;

        AmbMaybeObserver(MaybeObserver maybeObserver, CompositeDisposable compositeDisposable, AtomicBoolean atomicBoolean) {
            this.f136733a = maybeObserver;
            this.f136735c = compositeDisposable;
            this.f136734b = atomicBoolean;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            this.f136736d = disposable;
            this.f136735c.b(disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            if (this.f136734b.compareAndSet(false, true)) {
                this.f136735c.c(this.f136736d);
                this.f136735c.dispose();
                this.f136733a.onComplete();
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            if (!this.f136734b.compareAndSet(false, true)) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f136735c.c(this.f136736d);
            this.f136735c.dispose();
            this.f136733a.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            if (this.f136734b.compareAndSet(false, true)) {
                this.f136735c.c(this.f136736d);
                this.f136735c.dispose();
                this.f136733a.onSuccess(obj);
            }
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        int length;
        MaybeSource[] maybeSourceArr = this.f136731a;
        if (maybeSourceArr == null) {
            maybeSourceArr = new MaybeSource[8];
            try {
                length = 0;
                for (MaybeSource maybeSource : this.f136732b) {
                    if (maybeSource == null) {
                        EmptyDisposable.h(new NullPointerException("One of the sources is null"), maybeObserver);
                        return;
                    }
                    if (length == maybeSourceArr.length) {
                        MaybeSource[] maybeSourceArr2 = new MaybeSource[(length >> 2) + length];
                        System.arraycopy(maybeSourceArr, 0, maybeSourceArr2, 0, length);
                        maybeSourceArr = maybeSourceArr2;
                    }
                    int i3 = length + 1;
                    maybeSourceArr[length] = maybeSource;
                    length = i3;
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptyDisposable.h(th, maybeObserver);
                return;
            }
        } else {
            length = maybeSourceArr.length;
        }
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        maybeObserver.a(compositeDisposable);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        for (int i4 = 0; i4 < length; i4++) {
            MaybeSource maybeSource2 = maybeSourceArr[i4];
            if (compositeDisposable.e()) {
                return;
            }
            if (maybeSource2 == null) {
                compositeDisposable.dispose();
                Throwable nullPointerException = new NullPointerException("One of the MaybeSources is null");
                if (atomicBoolean.compareAndSet(false, true)) {
                    maybeObserver.onError(nullPointerException);
                    return;
                } else {
                    RxJavaPlugins.s(nullPointerException);
                    return;
                }
            }
            maybeSource2.b(new AmbMaybeObserver(maybeObserver, compositeDisposable, atomicBoolean));
        }
        if (length == 0) {
            maybeObserver.onComplete();
        }
    }
}
