package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableMerge extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Publisher f135102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f135103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f135104c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class CompletableMergeSubscriber extends AtomicInteger implements FlowableSubscriber<CompletableSource>, Disposable {
        private static final long serialVersionUID = -2108443387387077490L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompletableObserver f135105a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f135106b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f135107c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Subscription f135110g;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final CompositeDisposable f135109f = new CompositeDisposable();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicThrowable f135108d = new AtomicThrowable();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class MergeInnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            private static final long serialVersionUID = 251330541679988317L;

            MergeInnerObserver() {
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
                CompletableMergeSubscriber.this.a(this);
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                CompletableMergeSubscriber.this.b(this, th);
            }
        }

        CompletableMergeSubscriber(CompletableObserver completableObserver, int i3, boolean z2) {
            this.f135105a = completableObserver;
            this.f135106b = i3;
            this.f135107c = z2;
            lazySet(1);
        }

        void a(MergeInnerObserver mergeInnerObserver) {
            this.f135109f.c(mergeInnerObserver);
            if (decrementAndGet() != 0) {
                if (this.f135106b != Integer.MAX_VALUE) {
                    this.f135110g.y(1L);
                }
            } else {
                Throwable th = this.f135108d.get();
                if (th != null) {
                    this.f135105a.onError(th);
                } else {
                    this.f135105a.onComplete();
                }
            }
        }

        void b(MergeInnerObserver mergeInnerObserver, Throwable th) {
            this.f135109f.c(mergeInnerObserver);
            if (!this.f135107c) {
                this.f135110g.cancel();
                this.f135109f.dispose();
                if (!this.f135108d.a(th)) {
                    RxJavaPlugins.s(th);
                    return;
                } else {
                    if (getAndSet(0) > 0) {
                        this.f135105a.onError(this.f135108d.b());
                        return;
                    }
                    return;
                }
            }
            if (!this.f135108d.a(th)) {
                RxJavaPlugins.s(th);
            } else if (decrementAndGet() == 0) {
                this.f135105a.onError(this.f135108d.b());
            } else if (this.f135106b != Integer.MAX_VALUE) {
                this.f135110g.y(1L);
            }
        }

        @Override // org.reactivestreams.Subscriber
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void h(CompletableSource completableSource) {
            getAndIncrement();
            MergeInnerObserver mergeInnerObserver = new MergeInnerObserver();
            this.f135109f.b(mergeInnerObserver);
            completableSource.b(mergeInnerObserver);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f135110g.cancel();
            this.f135109f.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f135109f.e();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135110g, subscription)) {
                this.f135110g = subscription;
                this.f135105a.a(this);
                int i3 = this.f135106b;
                if (i3 == Integer.MAX_VALUE) {
                    subscription.y(Long.MAX_VALUE);
                } else {
                    subscription.y(i3);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (decrementAndGet() == 0) {
                if (this.f135108d.get() != null) {
                    this.f135105a.onError(this.f135108d.b());
                } else {
                    this.f135105a.onComplete();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f135107c) {
                if (!this.f135108d.a(th)) {
                    RxJavaPlugins.s(th);
                    return;
                } else {
                    if (decrementAndGet() == 0) {
                        this.f135105a.onError(this.f135108d.b());
                        return;
                    }
                    return;
                }
            }
            this.f135109f.dispose();
            if (!this.f135108d.a(th)) {
                RxJavaPlugins.s(th);
            } else if (getAndSet(0) > 0) {
                this.f135105a.onError(this.f135108d.b());
            }
        }
    }

    @Override // io.reactivex.Completable
    public void c(CompletableObserver completableObserver) {
        this.f135102a.i(new CompletableMergeSubscriber(completableObserver, this.f135103b, this.f135104c));
    }
}
