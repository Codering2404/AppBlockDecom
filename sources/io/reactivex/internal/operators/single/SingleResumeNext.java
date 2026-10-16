package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.ResumeSingleObserver;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleResumeNext<T> extends Single<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SingleSource f138910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f138911b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ResumeMainSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = -5314538511045349925L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f138912a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f138913b;

        ResumeMainSingleObserver(SingleObserver singleObserver, Function function) {
            this.f138912a = singleObserver;
            this.f138913b = function;
        }

        @Override // io.reactivex.SingleObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.g(this, disposable)) {
                this.f138912a.a(this);
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

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            try {
                ((SingleSource) ObjectHelper.d(this.f138913b.apply(th), "The nextFunction returned a null SingleSource.")).b(new ResumeSingleObserver(this, this.f138912a));
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f138912a.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            this.f138912a.onSuccess(obj);
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f138910a.b(new ResumeMainSingleObserver(singleObserver, this.f138911b));
    }
}
