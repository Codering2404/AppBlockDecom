package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableCollectSingle<T, U> extends Single<U> implements FuseToFlowable<U> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Flowable f135385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable f135386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final BiConsumer f135387c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class CollectSubscriber<T, U> implements FlowableSubscriber<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f135388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BiConsumer f135389b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Object f135390c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Subscription f135391d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f135392f;

        CollectSubscriber(SingleObserver singleObserver, Object obj, BiConsumer biConsumer) {
            this.f135388a = singleObserver;
            this.f135389b = biConsumer;
            this.f135390c = obj;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f135391d.cancel();
            this.f135391d = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f135391d == SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135391d, subscription)) {
                this.f135391d = subscription;
                this.f135388a.a(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f135392f) {
                return;
            }
            try {
                this.f135389b.accept(this.f135390c, obj);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f135391d.cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f135392f) {
                return;
            }
            this.f135392f = true;
            this.f135391d = SubscriptionHelper.CANCELLED;
            this.f135388a.onSuccess(this.f135390c);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f135392f) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f135392f = true;
            this.f135391d = SubscriptionHelper.CANCELLED;
            this.f135388a.onError(th);
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        try {
            this.f135385a.w(new CollectSubscriber(singleObserver, ObjectHelper.d(this.f135386b.call(), "The initialSupplier returned a null value"), this.f135387c));
        } catch (Throwable th) {
            EmptyDisposable.j(th, singleObserver);
        }
    }
}
