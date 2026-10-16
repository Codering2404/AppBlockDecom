package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeMap<T, R> extends AbstractMaybeWithUpstream<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f136924b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MapMaybeObserver<T, R> implements MaybeObserver<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f136925a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f136926b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f136927c;

        MapMaybeObserver(MaybeObserver maybeObserver, Function function) {
            this.f136925a = maybeObserver;
            this.f136926b = function;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f136927c, disposable)) {
                this.f136927c = disposable;
                this.f136925a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Disposable disposable = this.f136927c;
            this.f136927c = DisposableHelper.DISPOSED;
            disposable.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f136927c.e();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f136925a.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f136925a.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            try {
                this.f136925a.onSuccess(ObjectHelper.d(this.f136926b.apply(obj), "The mapper returned a null item"));
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f136925a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        this.f136730a.b(new MapMaybeObserver(maybeObserver, this.f136924b));
    }
}
