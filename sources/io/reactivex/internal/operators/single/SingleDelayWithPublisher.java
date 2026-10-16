package io.reactivex.internal.operators.single;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.ResumeSingleObserver;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleDelayWithPublisher<T, U> extends Single<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SingleSource f138770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Publisher f138771b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class OtherSubscriber<T, U> extends AtomicReference<Disposable> implements FlowableSubscriber<U>, Disposable {
        private static final long serialVersionUID = -8565274649390031272L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f138772a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SingleSource f138773b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f138774c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Subscription f138775d;

        OtherSubscriber(SingleObserver singleObserver, SingleSource singleSource) {
            this.f138772a = singleObserver;
            this.f138773b = singleSource;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f138775d.cancel();
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(get());
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f138775d, subscription)) {
                this.f138775d = subscription;
                this.f138772a.a(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f138775d.cancel();
            onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f138774c) {
                return;
            }
            this.f138774c = true;
            this.f138773b.b(new ResumeSingleObserver(this, this.f138772a));
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f138774c) {
                RxJavaPlugins.s(th);
            } else {
                this.f138774c = true;
                this.f138772a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f138771b.i(new OtherSubscriber(singleObserver, this.f138770a));
    }
}
