package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableSingleMaybe<T> extends Maybe<T> implements FuseToFlowable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Flowable f136308a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SingleElementSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f136309a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Subscription f136310b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f136311c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f136312d;

        SingleElementSubscriber(MaybeObserver maybeObserver) {
            this.f136309a = maybeObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f136310b.cancel();
            this.f136310b = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f136310b == SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136310b, subscription)) {
                this.f136310b = subscription;
                this.f136309a.a(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f136311c) {
                return;
            }
            if (this.f136312d == null) {
                this.f136312d = obj;
                return;
            }
            this.f136311c = true;
            this.f136310b.cancel();
            this.f136310b = SubscriptionHelper.CANCELLED;
            this.f136309a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f136311c) {
                return;
            }
            this.f136311c = true;
            this.f136310b = SubscriptionHelper.CANCELLED;
            Object obj = this.f136312d;
            this.f136312d = null;
            if (obj == null) {
                this.f136309a.onComplete();
            } else {
                this.f136309a.onSuccess(obj);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f136311c) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f136311c = true;
            this.f136310b = SubscriptionHelper.CANCELLED;
            this.f136309a.onError(th);
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        this.f136308a.w(new SingleElementSubscriber(maybeObserver));
    }
}
