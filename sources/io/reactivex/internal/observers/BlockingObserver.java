package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class BlockingObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f134965b = new Object();
    private static final long serialVersionUID = -4875965440900746268L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Queue f134966a;

    @Override // io.reactivex.Observer
    public void a(Disposable disposable) {
        DisposableHelper.g(this, disposable);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (DisposableHelper.a(this)) {
            this.f134966a.offer(f134965b);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean e() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.Observer
    public void h(Object obj) {
        this.f134966a.offer(NotificationLite.l(obj));
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.f134966a.offer(NotificationLite.e());
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        this.f134966a.offer(NotificationLite.g(th));
    }
}
