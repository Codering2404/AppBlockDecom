package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeOnErrorNext<T> extends AbstractMaybeWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f136953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f136954c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class OnErrorNextMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 2026620218879969836L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f136955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f136956b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f136957c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class NextMaybeObserver<T> implements MaybeObserver<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final MaybeObserver f136958a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final AtomicReference f136959b;

            NextMaybeObserver(MaybeObserver maybeObserver, AtomicReference atomicReference) {
                this.f136958a = maybeObserver;
                this.f136959b = atomicReference;
            }

            @Override // io.reactivex.MaybeObserver
            public void a(Disposable disposable) {
                DisposableHelper.g(this.f136959b, disposable);
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                this.f136958a.onComplete();
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                this.f136958a.onError(th);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(Object obj) {
                this.f136958a.onSuccess(obj);
            }
        }

        OnErrorNextMaybeObserver(MaybeObserver maybeObserver, Function function, boolean z2) {
            this.f136955a = maybeObserver;
            this.f136956b = function;
            this.f136957c = z2;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.g(this, disposable)) {
                this.f136955a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(get());
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f136955a.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            if (!this.f136957c && !(th instanceof Exception)) {
                this.f136955a.onError(th);
                return;
            }
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.d(this.f136956b.apply(th), "The resumeFunction returned a null MaybeSource");
                DisposableHelper.c(this, null);
                maybeSource.b(new NextMaybeObserver(this.f136955a, this));
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f136955a.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            this.f136955a.onSuccess(obj);
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        this.f136730a.b(new OnErrorNextMaybeObserver(maybeObserver, this.f136953b, this.f136954c));
    }
}
