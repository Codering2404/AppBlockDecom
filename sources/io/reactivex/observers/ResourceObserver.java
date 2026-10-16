package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class ResourceObserver<T> implements Observer<T>, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference f139250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ListCompositeDisposable f139251b;

    @Override // io.reactivex.Observer
    public final void a(Disposable disposable) {
        if (EndConsumerHelper.c(this.f139250a, disposable, getClass())) {
            b();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (DisposableHelper.a(this.f139250a)) {
            this.f139251b.dispose();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean e() {
        return DisposableHelper.b((Disposable) this.f139250a.get());
    }

    protected void b() {
    }
}
