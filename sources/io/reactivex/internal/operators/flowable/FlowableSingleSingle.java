package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableSingleSingle<T> extends Single<T> implements FuseToFlowable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Flowable f136313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object f136314b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SingleElementSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f136315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f136316b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Subscription f136317c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f136318d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f136319f;

        SingleElementSubscriber(SingleObserver singleObserver, Object obj) {
            this.f136315a = singleObserver;
            this.f136316b = obj;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f136317c.cancel();
            this.f136317c = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f136317c == SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136317c, subscription)) {
                this.f136317c = subscription;
                this.f136315a.a(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f136318d) {
                return;
            }
            if (this.f136319f == null) {
                this.f136319f = obj;
                return;
            }
            this.f136318d = true;
            this.f136317c.cancel();
            this.f136317c = SubscriptionHelper.CANCELLED;
            this.f136315a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f136318d) {
                return;
            }
            this.f136318d = true;
            this.f136317c = SubscriptionHelper.CANCELLED;
            Object obj = this.f136319f;
            this.f136319f = null;
            if (obj == null) {
                obj = this.f136316b;
            }
            if (obj != null) {
                this.f136315a.onSuccess(obj);
            } else {
                this.f136315a.onError(new NoSuchElementException());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f136318d) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f136318d = true;
            this.f136317c = SubscriptionHelper.CANCELLED;
            this.f136315a.onError(th);
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f136313a.w(new SingleElementSubscriber(singleObserver, this.f136314b));
    }
}
