package io.reactivex.internal.operators.flowable;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableConcatWithMaybe<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final MaybeSource f135481c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ConcatWithSubscriber<T> extends SinglePostCompleteSubscriber<T, T> implements MaybeObserver<T> {
        private static final long serialVersionUID = -7346385463600070225L;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicReference f135482f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        MaybeSource f135483g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f135484h;

        ConcatWithSubscriber(Subscriber subscriber, MaybeSource maybeSource) {
            super(subscriber);
            this.f135483g = maybeSource;
            this.f135482f = new AtomicReference();
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            DisposableHelper.g(this.f135482f, disposable);
        }

        @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            DisposableHelper.a(this.f135482f);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f139163d++;
            this.f139160a.h(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f135484h) {
                this.f139160a.onComplete();
                return;
            }
            this.f135484h = true;
            this.f139161b = SubscriptionHelper.CANCELLED;
            MaybeSource maybeSource = this.f135483g;
            this.f135483g = null;
            maybeSource.b(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f139160a.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            b(obj);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new ConcatWithSubscriber(subscriber, this.f135481c));
    }
}
