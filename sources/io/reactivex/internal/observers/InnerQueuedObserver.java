package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.util.QueueDrainHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class InnerQueuedObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private static final long serialVersionUID = -5417183359794346637L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final InnerQueuedObserverSupport f134988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f134989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    SimpleQueue f134990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    volatile boolean f134991d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f134992f;

    public InnerQueuedObserver(InnerQueuedObserverSupport innerQueuedObserverSupport, int i3) {
        this.f134988a = innerQueuedObserverSupport;
        this.f134989b = i3;
    }

    @Override // io.reactivex.Observer
    public void a(Disposable disposable) {
        if (DisposableHelper.g(this, disposable)) {
            if (disposable instanceof QueueDisposable) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int iL = queueDisposable.l(3);
                if (iL == 1) {
                    this.f134992f = iL;
                    this.f134990c = queueDisposable;
                    this.f134991d = true;
                    this.f134988a.f(this);
                    return;
                }
                if (iL == 2) {
                    this.f134992f = iL;
                    this.f134990c = queueDisposable;
                    return;
                }
            }
            this.f134990c = QueueDrainHelper.c(-this.f134989b);
        }
    }

    public boolean b() {
        return this.f134991d;
    }

    public SimpleQueue c() {
        return this.f134990c;
    }

    public void d() {
        this.f134991d = true;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.a(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean e() {
        return DisposableHelper.b(get());
    }

    @Override // io.reactivex.Observer
    public void h(Object obj) {
        if (this.f134992f == 0) {
            this.f134988a.g(this, obj);
        } else {
            this.f134988a.c();
        }
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.f134988a.f(this);
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        this.f134988a.d(this, th);
    }
}
