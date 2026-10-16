package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Notification;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaterializeSingleObserver<T> implements SingleObserver<T>, MaybeObserver<T>, CompletableObserver, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SingleObserver f137163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Disposable f137164b;

    public MaterializeSingleObserver(SingleObserver singleObserver) {
        this.f137163a = singleObserver;
    }

    @Override // io.reactivex.SingleObserver
    public void a(Disposable disposable) {
        if (DisposableHelper.i(this.f137164b, disposable)) {
            this.f137164b = disposable;
            this.f137163a.a(this);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.f137164b.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean e() {
        return this.f137164b.e();
    }

    @Override // io.reactivex.MaybeObserver
    public void onComplete() {
        this.f137163a.onSuccess(Notification.a());
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable th) {
        this.f137163a.onSuccess(Notification.b(th));
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(Object obj) {
        this.f137163a.onSuccess(Notification.c(obj));
    }
}
