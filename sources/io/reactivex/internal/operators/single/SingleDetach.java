package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleDetach<T> extends Single<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SingleSource f138785a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DetachSingleObserver<T> implements SingleObserver<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        SingleObserver f138786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Disposable f138787b;

        DetachSingleObserver(SingleObserver singleObserver) {
            this.f138786a = singleObserver;
        }

        @Override // io.reactivex.SingleObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138787b, disposable)) {
                this.f138787b = disposable;
                this.f138786a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f138786a = null;
            this.f138787b.dispose();
            this.f138787b = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138787b.e();
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.f138787b = DisposableHelper.DISPOSED;
            SingleObserver singleObserver = this.f138786a;
            if (singleObserver != null) {
                this.f138786a = null;
                singleObserver.onError(th);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            this.f138787b = DisposableHelper.DISPOSED;
            SingleObserver singleObserver = this.f138786a;
            if (singleObserver != null) {
                this.f138786a = null;
                singleObserver.onSuccess(obj);
            }
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f138785a.b(new DetachSingleObserver(singleObserver));
    }
}
