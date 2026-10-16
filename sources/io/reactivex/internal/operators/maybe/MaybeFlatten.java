package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeFlatten<T, R> extends AbstractMaybeWithUpstream<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f136893b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 4375739915521278546L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f136894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f136895b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f136896c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class InnerObserver implements MaybeObserver<R> {
            InnerObserver() {
            }

            @Override // io.reactivex.MaybeObserver
            public void a(Disposable disposable) {
                DisposableHelper.g(FlatMapMaybeObserver.this, disposable);
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                FlatMapMaybeObserver.this.f136894a.onComplete();
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                FlatMapMaybeObserver.this.f136894a.onError(th);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(Object obj) {
                FlatMapMaybeObserver.this.f136894a.onSuccess(obj);
            }
        }

        FlatMapMaybeObserver(MaybeObserver maybeObserver, Function function) {
            this.f136894a = maybeObserver;
            this.f136895b = function;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f136896c, disposable)) {
                this.f136896c = disposable;
                this.f136894a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
            this.f136896c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(get());
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f136894a.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f136894a.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.d(this.f136895b.apply(obj), "The mapper returned a null MaybeSource");
                if (e()) {
                    return;
                }
                maybeSource.b(new InnerObserver());
            } catch (Exception e3) {
                Exceptions.b(e3);
                this.f136894a.onError(e3);
            }
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        this.f136730a.b(new FlatMapMaybeObserver(maybeObserver, this.f136893b));
    }
}
