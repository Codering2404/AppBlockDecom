package io.reactivex.internal.operators.single;

import io.reactivex.Flowable;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleToFlowable<T> extends Flowable<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final SingleSource f138940b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SingleToFlowableObserver<T> extends DeferredScalarSubscription<T> implements SingleObserver<T> {
        private static final long serialVersionUID = 187782011903685568L;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f138941c;

        SingleToFlowableObserver(Subscriber subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.SingleObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138941c, disposable)) {
                this.f138941c = disposable;
                this.f139174a.g(this);
            }
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.f138941c.dispose();
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.f139174a.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            e(obj);
        }
    }

    public SingleToFlowable(SingleSource singleSource) {
        this.f138940b = singleSource;
    }

    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        this.f138940b.b(new SingleToFlowableObserver(subscriber));
    }
}
