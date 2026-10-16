package io.reactivex.observers;

import androidx.compose.animation.core.h;
import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class TestObserver<T> extends BaseTestConsumer<T, TestObserver<T>> implements Observer<T>, Disposable, MaybeObserver<T>, SingleObserver<T>, CompletableObserver {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Observer f139263j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AtomicReference f139264k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private QueueDisposable f139265l;

    @Override // io.reactivex.Observer
    public void a(Disposable disposable) {
        this.f139230f = Thread.currentThread();
        if (disposable == null) {
            this.f139228c.add(new NullPointerException("onSubscribe received a null Subscription"));
            return;
        }
        if (!h.a(this.f139264k, null, disposable)) {
            disposable.dispose();
            if (this.f139264k.get() != DisposableHelper.DISPOSED) {
                this.f139228c.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + disposable));
                return;
            }
            return;
        }
        int i3 = this.f139232h;
        if (i3 != 0 && (disposable instanceof QueueDisposable)) {
            QueueDisposable queueDisposable = (QueueDisposable) disposable;
            this.f139265l = queueDisposable;
            int iL = queueDisposable.l(i3);
            this.f139233i = iL;
            if (iL == 1) {
                this.f139231g = true;
                this.f139230f = Thread.currentThread();
                while (true) {
                    try {
                        Object objPoll = this.f139265l.poll();
                        if (objPoll == null) {
                            this.f139229d++;
                            this.f139264k.lazySet(DisposableHelper.DISPOSED);
                            return;
                        }
                        this.f139227b.add(objPoll);
                    } catch (Throwable th) {
                        this.f139228c.add(th);
                        return;
                    }
                }
            }
        }
        this.f139263j.a(disposable);
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        DisposableHelper.a(this.f139264k);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean e() {
        return DisposableHelper.b((Disposable) this.f139264k.get());
    }

    @Override // io.reactivex.Observer
    public void h(Object obj) {
        if (!this.f139231g) {
            this.f139231g = true;
            if (this.f139264k.get() == null) {
                this.f139228c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.f139230f = Thread.currentThread();
        if (this.f139233i != 2) {
            this.f139227b.add(obj);
            if (obj == null) {
                this.f139228c.add(new NullPointerException("onNext received a null value"));
            }
            this.f139263j.h(obj);
            return;
        }
        while (true) {
            try {
                Object objPoll = this.f139265l.poll();
                if (objPoll == null) {
                    return;
                } else {
                    this.f139227b.add(objPoll);
                }
            } catch (Throwable th) {
                this.f139228c.add(th);
                this.f139265l.dispose();
                return;
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (!this.f139231g) {
            this.f139231g = true;
            if (this.f139264k.get() == null) {
                this.f139228c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f139230f = Thread.currentThread();
            this.f139229d++;
            this.f139263j.onComplete();
        } finally {
            this.f139226a.countDown();
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (!this.f139231g) {
            this.f139231g = true;
            if (this.f139264k.get() == null) {
                this.f139228c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f139230f = Thread.currentThread();
            if (th == null) {
                this.f139228c.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.f139228c.add(th);
            }
            this.f139263j.onError(th);
            this.f139226a.countDown();
        } catch (Throwable th2) {
            this.f139226a.countDown();
            throw th2;
        }
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(Object obj) {
        h(obj);
        onComplete();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum EmptyObserver implements Observer<Object> {
        INSTANCE;

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
        }
    }
}
