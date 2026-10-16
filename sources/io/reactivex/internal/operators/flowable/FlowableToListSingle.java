package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableToListSingle<T, U extends Collection<? super T>> extends Single<U> implements FuseToFlowable<U> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Flowable f136529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable f136530b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ToListSubscriber<T, U extends Collection<? super T>> implements FlowableSubscriber<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f136531a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Subscription f136532b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Collection f136533c;

        ToListSubscriber(SingleObserver singleObserver, Collection collection) {
            this.f136531a = singleObserver;
            this.f136533c = collection;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f136532b.cancel();
            this.f136532b = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f136532b == SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136532b, subscription)) {
                this.f136532b = subscription;
                this.f136531a.a(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f136533c.add(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f136532b = SubscriptionHelper.CANCELLED;
            this.f136531a.onSuccess(this.f136533c);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f136533c = null;
            this.f136532b = SubscriptionHelper.CANCELLED;
            this.f136531a.onError(th);
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        try {
            this.f136529a.w(new ToListSubscriber(singleObserver, (Collection) ObjectHelper.d(this.f136530b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.j(th, singleObserver);
        }
    }
}
