package io.reactivex.internal.operators.flowable;

import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableConcatWithSingle<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final SingleSource f135485c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ConcatWithSubscriber<T> extends SinglePostCompleteSubscriber<T, T> implements SingleObserver<T> {
        private static final long serialVersionUID = -7346385463600070225L;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicReference f135486f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        SingleSource f135487g;

        ConcatWithSubscriber(Subscriber subscriber, SingleSource singleSource) {
            super(subscriber);
            this.f135487g = singleSource;
            this.f135486f = new AtomicReference();
        }

        @Override // io.reactivex.SingleObserver
        public void a(Disposable disposable) {
            DisposableHelper.g(this.f135486f, disposable);
        }

        @Override // io.reactivex.internal.subscribers.SinglePostCompleteSubscriber, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            DisposableHelper.a(this.f135486f);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f139163d++;
            this.f139160a.h(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f139161b = SubscriptionHelper.CANCELLED;
            SingleSource singleSource = this.f135487g;
            this.f135487g = null;
            singleSource.b(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f139160a.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            b(obj);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new ConcatWithSubscriber(subscriber, this.f135485c));
    }
}
