package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeFlatMapIterableFlowable<T, R> extends Flowable<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final MaybeSource f136855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f136856c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FlatMapIterableObserver<T, R> extends BasicIntQueueSubscription<R> implements MaybeObserver<T> {
        private static final long serialVersionUID = -8938804753851907758L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f136858b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicLong f136859c = new AtomicLong();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Disposable f136860d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile Iterator f136861f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        volatile boolean f136862g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f136863h;

        FlatMapIterableObserver(Subscriber subscriber, Function function) {
            this.f136857a = subscriber;
            this.f136858b = function;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f136860d, disposable)) {
                this.f136860d = disposable;
                this.f136857a.g(this);
            }
        }

        void c() {
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber subscriber = this.f136857a;
            Iterator it = this.f136861f;
            if (this.f136863h && it != null) {
                subscriber.h(null);
                subscriber.onComplete();
                return;
            }
            int iAddAndGet = 1;
            while (true) {
                if (it != null) {
                    long j3 = this.f136859c.get();
                    if (j3 == Long.MAX_VALUE) {
                        e(subscriber, it);
                        return;
                    }
                    long j4 = 0;
                    while (j4 != j3) {
                        if (this.f136862g) {
                            return;
                        }
                        try {
                            subscriber.h(ObjectHelper.d(it.next(), "The iterator returned a null value"));
                            if (this.f136862g) {
                                return;
                            }
                            j4++;
                            try {
                                if (!it.hasNext()) {
                                    subscriber.onComplete();
                                    return;
                                }
                            } catch (Throwable th) {
                                Exceptions.b(th);
                                subscriber.onError(th);
                                return;
                            }
                        } catch (Throwable th2) {
                            Exceptions.b(th2);
                            subscriber.onError(th2);
                            return;
                        }
                    }
                    if (j4 != 0) {
                        BackpressureHelper.e(this.f136859c, j4);
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
                if (it == null) {
                    it = this.f136861f;
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f136862g = true;
            this.f136860d.dispose();
            this.f136860d = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.f136861f = null;
        }

        void e(Subscriber subscriber, Iterator it) {
            while (!this.f136862g) {
                try {
                    subscriber.h(it.next());
                    if (this.f136862g) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            subscriber.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        subscriber.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    subscriber.onError(th2);
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.f136861f == null;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int l(int i3) {
            if ((i3 & 2) == 0) {
                return 0;
            }
            this.f136863h = true;
            return 2;
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f136857a.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f136860d = DisposableHelper.DISPOSED;
            this.f136857a.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            try {
                Iterator<T> it = ((Iterable) this.f136858b.apply(obj)).iterator();
                if (!it.hasNext()) {
                    this.f136857a.onComplete();
                } else {
                    this.f136861f = it;
                    c();
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f136857a.onError(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            Iterator it = this.f136861f;
            if (it == null) {
                return null;
            }
            Object objD = ObjectHelper.d(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f136861f = null;
            }
            return objD;
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this.f136859c, j3);
                c();
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f136855b.b(new FlatMapIterableObserver(subscriber, this.f136856c));
    }
}
