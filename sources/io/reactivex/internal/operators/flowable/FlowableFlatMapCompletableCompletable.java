package io.reactivex.internal.operators.flowable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableFlatMapCompletableCompletable<T> extends Completable implements FuseToFlowable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Flowable f135686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f135687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f135688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f135689d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FlatMapCompletableMainSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        private static final long serialVersionUID = 8443155186132538303L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompletableObserver f135690a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Function f135692c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f135693d;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final int f135695g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Subscription f135696h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f135697i;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicThrowable f135691b = new AtomicThrowable();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final CompositeDisposable f135694f = new CompositeDisposable();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class InnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            private static final long serialVersionUID = 8606673141535671828L;

            InnerObserver() {
            }

            @Override // io.reactivex.CompletableObserver
            public void a(Disposable disposable) {
                DisposableHelper.g(this, disposable);
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                DisposableHelper.a(this);
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean e() {
                return DisposableHelper.b(get());
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                FlatMapCompletableMainSubscriber.this.a(this);
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                FlatMapCompletableMainSubscriber.this.b(this, th);
            }
        }

        FlatMapCompletableMainSubscriber(CompletableObserver completableObserver, Function function, boolean z2, int i3) {
            this.f135690a = completableObserver;
            this.f135692c = function;
            this.f135693d = z2;
            this.f135695g = i3;
            lazySet(1);
        }

        void a(InnerObserver innerObserver) {
            this.f135694f.c(innerObserver);
            onComplete();
        }

        void b(InnerObserver innerObserver, Throwable th) {
            this.f135694f.c(innerObserver);
            onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f135697i = true;
            this.f135696h.cancel();
            this.f135694f.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f135694f.e();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135696h, subscription)) {
                this.f135696h = subscription;
                this.f135690a.a(this);
                int i3 = this.f135695g;
                if (i3 == Integer.MAX_VALUE) {
                    subscription.y(Long.MAX_VALUE);
                } else {
                    subscription.y(i3);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.d(this.f135692c.apply(obj), "The mapper returned a null CompletableSource");
                getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (this.f135697i || !this.f135694f.b(innerObserver)) {
                    return;
                }
                completableSource.b(innerObserver);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f135696h.cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (decrementAndGet() != 0) {
                if (this.f135695g != Integer.MAX_VALUE) {
                    this.f135696h.y(1L);
                }
            } else {
                Throwable thB = this.f135691b.b();
                if (thB != null) {
                    this.f135690a.onError(thB);
                } else {
                    this.f135690a.onComplete();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.f135691b.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (!this.f135693d) {
                dispose();
                if (getAndSet(0) > 0) {
                    this.f135690a.onError(this.f135691b.b());
                    return;
                }
                return;
            }
            if (decrementAndGet() == 0) {
                this.f135690a.onError(this.f135691b.b());
            } else if (this.f135695g != Integer.MAX_VALUE) {
                this.f135696h.y(1L);
            }
        }
    }

    @Override // io.reactivex.Completable
    protected void c(CompletableObserver completableObserver) {
        this.f135686a.w(new FlatMapCompletableMainSubscriber(completableObserver, this.f135687b, this.f135689d, this.f135688c));
    }
}
