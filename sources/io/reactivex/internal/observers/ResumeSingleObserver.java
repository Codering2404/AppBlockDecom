package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class ResumeSingleObserver<T> implements SingleObserver<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AtomicReference f135003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final SingleObserver f135004b;

    public ResumeSingleObserver(AtomicReference atomicReference, SingleObserver singleObserver) {
        this.f135003a = atomicReference;
        this.f135004b = singleObserver;
    }

    @Override // io.reactivex.SingleObserver
    public void a(Disposable disposable) {
        DisposableHelper.c(this.f135003a, disposable);
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable th) {
        this.f135004b.onError(th);
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(Object obj) {
        this.f135004b.onSuccess(obj);
    }
}
