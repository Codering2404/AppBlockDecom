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
public final class FlowableElementAtSingle<T> extends Single<T> implements FuseToFlowable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Flowable f135629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f135630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Object f135631c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ElementAtSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f135632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f135633b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Object f135634c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Subscription f135635d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f135636f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f135637g;

        ElementAtSubscriber(SingleObserver singleObserver, long j3, Object obj) {
            this.f135632a = singleObserver;
            this.f135633b = j3;
            this.f135634c = obj;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f135635d.cancel();
            this.f135635d = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f135635d == SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135635d, subscription)) {
                this.f135635d = subscription;
                this.f135632a.a(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f135637g) {
                return;
            }
            long j3 = this.f135636f;
            if (j3 != this.f135633b) {
                this.f135636f = j3 + 1;
                return;
            }
            this.f135637g = true;
            this.f135635d.cancel();
            this.f135635d = SubscriptionHelper.CANCELLED;
            this.f135632a.onSuccess(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f135635d = SubscriptionHelper.CANCELLED;
            if (this.f135637g) {
                return;
            }
            this.f135637g = true;
            Object obj = this.f135634c;
            if (obj != null) {
                this.f135632a.onSuccess(obj);
            } else {
                this.f135632a.onError(new NoSuchElementException());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f135637g) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f135637g = true;
            this.f135635d = SubscriptionHelper.CANCELLED;
            this.f135632a.onError(th);
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f135629a.w(new ElementAtSubscriber(singleObserver, this.f135630b, this.f135631c));
    }
}
