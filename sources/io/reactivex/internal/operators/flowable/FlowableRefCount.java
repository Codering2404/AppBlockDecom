package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableRefCount<T> extends Flowable<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ConnectableFlowable f136132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f136133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final long f136134d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final TimeUnit f136135f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Scheduler f136136g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    RefConnection f136137h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class RefConnection extends AtomicReference<Disposable> implements Runnable, Consumer<Disposable> {
        private static final long serialVersionUID = -4552101107598366241L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final FlowableRefCount f136138a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Disposable f136139b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f136140c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f136141d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f136142f;

        RefConnection(FlowableRefCount flowableRefCount) {
            this.f136138a = flowableRefCount;
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Disposable disposable) {
            DisposableHelper.c(this, disposable);
            synchronized (this.f136138a) {
                try {
                    if (this.f136142f) {
                        ((ResettableConnectable) this.f136138a.f136132b).c(disposable);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f136138a.C(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class RefCountSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -7419642935409022375L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final FlowableRefCount f136144b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final RefConnection f136145c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Subscription f136146d;

        RefCountSubscriber(Subscriber subscriber, FlowableRefCount flowableRefCount, RefConnection refConnection) {
            this.f136143a = subscriber;
            this.f136144b = flowableRefCount;
            this.f136145c = refConnection;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f136146d.cancel();
            if (compareAndSet(false, true)) {
                this.f136144b.A(this.f136145c);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136146d, subscription)) {
                this.f136146d = subscription;
                this.f136143a.g(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f136143a.h(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.f136144b.B(this.f136145c);
                this.f136143a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!compareAndSet(false, true)) {
                RxJavaPlugins.s(th);
            } else {
                this.f136144b.B(this.f136145c);
                this.f136143a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            this.f136146d.y(j3);
        }
    }

    void A(RefConnection refConnection) {
        synchronized (this) {
            try {
                RefConnection refConnection2 = this.f136137h;
                if (refConnection2 != null && refConnection2 == refConnection) {
                    long j3 = refConnection.f136140c - 1;
                    refConnection.f136140c = j3;
                    if (j3 == 0 && refConnection.f136141d) {
                        if (this.f136134d == 0) {
                            C(refConnection);
                            return;
                        }
                        SequentialDisposable sequentialDisposable = new SequentialDisposable();
                        refConnection.f136139b = sequentialDisposable;
                        sequentialDisposable.a(this.f136136g.f(refConnection, this.f136134d, this.f136135f));
                    }
                }
            } finally {
            }
        }
    }

    void B(RefConnection refConnection) {
        synchronized (this) {
            try {
                RefConnection refConnection2 = this.f136137h;
                if (refConnection2 != null && refConnection2 == refConnection) {
                    this.f136137h = null;
                    Disposable disposable = refConnection.f136139b;
                    if (disposable != null) {
                        disposable.dispose();
                    }
                }
                long j3 = refConnection.f136140c - 1;
                refConnection.f136140c = j3;
                if (j3 == 0) {
                    Publisher publisher = this.f136132b;
                    if (publisher instanceof Disposable) {
                        ((Disposable) publisher).dispose();
                    } else if (publisher instanceof ResettableConnectable) {
                        ((ResettableConnectable) publisher).c(refConnection.get());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    void C(RefConnection refConnection) {
        synchronized (this) {
            try {
                if (refConnection.f136140c == 0 && refConnection == this.f136137h) {
                    this.f136137h = null;
                    Disposable disposable = refConnection.get();
                    DisposableHelper.a(refConnection);
                    Publisher publisher = this.f136132b;
                    if (publisher instanceof Disposable) {
                        ((Disposable) publisher).dispose();
                    } else if (publisher instanceof ResettableConnectable) {
                        if (disposable == null) {
                            refConnection.f136142f = true;
                        } else {
                            ((ResettableConnectable) publisher).c(disposable);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        RefConnection refConnection;
        boolean z2;
        Disposable disposable;
        synchronized (this) {
            try {
                refConnection = this.f136137h;
                if (refConnection == null) {
                    refConnection = new RefConnection(this);
                    this.f136137h = refConnection;
                }
                long j3 = refConnection.f136140c;
                if (j3 == 0 && (disposable = refConnection.f136139b) != null) {
                    disposable.dispose();
                }
                long j4 = j3 + 1;
                refConnection.f136140c = j4;
                if (refConnection.f136141d || j4 != this.f136133c) {
                    z2 = false;
                } else {
                    z2 = true;
                    refConnection.f136141d = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f136132b.w(new RefCountSubscriber(subscriber, this, refConnection));
        if (z2) {
            this.f136132b.A(refConnection);
        }
    }
}
