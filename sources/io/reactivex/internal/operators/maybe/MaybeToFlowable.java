package io.reactivex.internal.operators.maybe;

import io.reactivex.Flowable;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeToFlowable<T> extends Flowable<T> implements HasUpstreamMaybeSource<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final MaybeSource f137017b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MaybeToFlowableSubscriber<T> extends DeferredScalarSubscription<T> implements MaybeObserver<T> {
        private static final long serialVersionUID = 7603343402964826922L;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f137018c;

        MaybeToFlowableSubscriber(Subscriber subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137018c, disposable)) {
                this.f137018c = disposable;
                this.f139174a.g(this);
            }
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.f137018c.dispose();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f139174a.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f139174a.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            e(obj);
        }
    }

    public MaybeToFlowable(MaybeSource maybeSource) {
        this.f137017b = maybeSource;
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f137017b.b(new MaybeToFlowableSubscriber(subscriber));
    }
}
