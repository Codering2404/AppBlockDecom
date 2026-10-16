package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.EndConsumerHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class DefaultObserver<T> implements Observer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Disposable f139241a;

    @Override // io.reactivex.Observer
    public final void a(Disposable disposable) {
        if (EndConsumerHelper.e(this.f139241a, disposable, getClass())) {
            this.f139241a = disposable;
            b();
        }
    }

    protected void b() {
    }
}
