package io.reactivex.internal.operators.maybe;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeDelaySubscriptionOtherPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Publisher f136798b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DelayMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        private static final long serialVersionUID = 706635022205076709L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f136799a;

        DelayMaybeObserver(MaybeObserver maybeObserver) {
            this.f136799a = maybeObserver;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            DisposableHelper.g(this, disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f136799a.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f136799a.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            this.f136799a.onSuccess(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class OtherSubscriber<T> implements FlowableSubscriber<Object>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final DelayMaybeObserver f136800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        MaybeSource f136801b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Subscription f136802c;

        OtherSubscriber(MaybeObserver maybeObserver, MaybeSource maybeSource) {
            this.f136800a = new DelayMaybeObserver(maybeObserver);
            this.f136801b = maybeSource;
        }

        void a() {
            MaybeSource maybeSource = this.f136801b;
            this.f136801b = null;
            maybeSource.b(this.f136800a);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f136802c.cancel();
            this.f136802c = SubscriptionHelper.CANCELLED;
            DisposableHelper.a(this.f136800a);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(this.f136800a.get());
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136802c, subscription)) {
                this.f136802c = subscription;
                this.f136800a.f136799a.a(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            Subscription subscription = this.f136802c;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                subscription.cancel();
                this.f136802c = subscriptionHelper;
                a();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Subscription subscription = this.f136802c;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                this.f136802c = subscriptionHelper;
                a();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Subscription subscription = this.f136802c;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription == subscriptionHelper) {
                RxJavaPlugins.s(th);
            } else {
                this.f136802c = subscriptionHelper;
                this.f136800a.f136799a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        this.f136798b.i(new OtherSubscriber(maybeObserver, this.f136730a));
    }
}
