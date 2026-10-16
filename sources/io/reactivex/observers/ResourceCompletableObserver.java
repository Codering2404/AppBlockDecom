package io.reactivex.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class ResourceCompletableObserver implements CompletableObserver, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference f139246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ListCompositeDisposable f139247b;

    @Override // io.reactivex.CompletableObserver
    public final void a(Disposable disposable) {
        if (EndConsumerHelper.c(this.f139246a, disposable, getClass())) {
            b();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (DisposableHelper.a(this.f139246a)) {
            this.f139247b.dispose();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean e() {
        return DisposableHelper.b((Disposable) this.f139246a.get());
    }

    protected void b() {
    }
}
