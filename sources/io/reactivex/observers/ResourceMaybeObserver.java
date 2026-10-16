package io.reactivex.observers;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class ResourceMaybeObserver<T> implements MaybeObserver<T>, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference f139248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ListCompositeDisposable f139249b;

    @Override // io.reactivex.MaybeObserver
    public final void a(Disposable disposable) {
        if (EndConsumerHelper.c(this.f139248a, disposable, getClass())) {
            b();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (DisposableHelper.a(this.f139248a)) {
            this.f139249b.dispose();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean e() {
        return DisposableHelper.b((Disposable) this.f139248a.get());
    }

    protected void b() {
    }
}
