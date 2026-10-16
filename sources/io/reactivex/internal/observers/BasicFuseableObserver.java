package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class BasicFuseableObserver<T, R> implements Observer<T>, QueueDisposable<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Observer f134951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Disposable f134952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected QueueDisposable f134953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f134954d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f134955f;

    public BasicFuseableObserver(Observer observer) {
        this.f134951a = observer;
    }

    @Override // io.reactivex.Observer
    public final void a(Disposable disposable) {
        if (DisposableHelper.i(this.f134952b, disposable)) {
            this.f134952b = disposable;
            if (disposable instanceof QueueDisposable) {
                this.f134953c = (QueueDisposable) disposable;
            }
            if (c()) {
                this.f134951a.a(this);
                b();
            }
        }
    }

    protected boolean c() {
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        this.f134953c.clear();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.f134952b.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean e() {
        return this.f134952b.e();
    }

    protected final void g(Throwable th) {
        Exceptions.b(th);
        this.f134952b.dispose();
        onError(th);
    }

    protected final int i(int i3) {
        QueueDisposable queueDisposable = this.f134953c;
        if (queueDisposable == null || (i3 & 4) != 0) {
            return 0;
        }
        int iL = queueDisposable.l(i3);
        if (iL != 0) {
            this.f134955f = iL;
        }
        return iL;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return this.f134953c.isEmpty();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.f134954d) {
            return;
        }
        this.f134954d = true;
        this.f134951a.onComplete();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (this.f134954d) {
            RxJavaPlugins.s(th);
        } else {
            this.f134954d = true;
            this.f134951a.onError(th);
        }
    }

    protected void b() {
    }
}
