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
public final class FlowableElementAtMaybe<T> extends Maybe<T> implements FuseToFlowable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Flowable f135622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f135623b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ElementAtSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f135624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f135625b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Subscription f135626c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f135627d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f135628f;

        ElementAtSubscriber(MaybeObserver maybeObserver, long j3) {
            this.f135624a = maybeObserver;
            this.f135625b = j3;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f135626c.cancel();
            this.f135626c = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f135626c == SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135626c, subscription)) {
                this.f135626c = subscription;
                this.f135624a.a(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f135628f) {
                return;
            }
            long j3 = this.f135627d;
            if (j3 != this.f135625b) {
                this.f135627d = j3 + 1;
                return;
            }
            this.f135628f = true;
            this.f135626c.cancel();
            this.f135626c = SubscriptionHelper.CANCELLED;
            this.f135624a.onSuccess(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f135626c = SubscriptionHelper.CANCELLED;
            if (this.f135628f) {
                return;
            }
            this.f135628f = true;
            this.f135624a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f135628f) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f135628f = true;
            this.f135626c = SubscriptionHelper.CANCELLED;
            this.f135624a.onError(th);
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        this.f135622a.w(new ElementAtSubscriber(maybeObserver, this.f135623b));
    }
}
