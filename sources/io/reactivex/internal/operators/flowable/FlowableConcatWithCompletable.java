package io.reactivex.internal.operators.flowable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableConcatWithCompletable<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final CompletableSource f135476c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ConcatWithSubscriber<T> extends AtomicReference<Disposable> implements FlowableSubscriber<T>, CompletableObserver, Subscription {
        private static final long serialVersionUID = -7346385463600070225L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Subscription f135478b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        CompletableSource f135479c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f135480d;

        ConcatWithSubscriber(Subscriber subscriber, CompletableSource completableSource) {
            this.f135477a = subscriber;
            this.f135479c = completableSource;
        }

        @Override // io.reactivex.CompletableObserver
        public void a(Disposable disposable) {
            DisposableHelper.g(this, disposable);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f135478b.cancel();
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135478b, subscription)) {
                this.f135478b = subscription;
                this.f135477a.g(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f135477a.h(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f135480d) {
                this.f135477a.onComplete();
                return;
            }
            this.f135480d = true;
            this.f135478b = SubscriptionHelper.CANCELLED;
            CompletableSource completableSource = this.f135479c;
            this.f135479c = null;
            completableSource.b(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f135477a.onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            this.f135478b.y(j3);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new ConcatWithSubscriber(subscriber, this.f135476c));
    }
}
