package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableReduceSeedSingle<T, R> extends Single<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Publisher f136122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object f136123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final BiFunction f136124c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ReduceSeedObserver<T, R> implements FlowableSubscriber<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f136125a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BiFunction f136126b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f136127c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Subscription f136128d;

        ReduceSeedObserver(SingleObserver singleObserver, BiFunction biFunction, Object obj) {
            this.f136125a = singleObserver;
            this.f136127c = obj;
            this.f136126b = biFunction;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f136128d.cancel();
            this.f136128d = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f136128d == SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136128d, subscription)) {
                this.f136128d = subscription;
                this.f136125a.a(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            Object obj2 = this.f136127c;
            if (obj2 != null) {
                try {
                    this.f136127c = ObjectHelper.d(this.f136126b.apply(obj2, obj), "The reducer returned a null value");
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f136128d.cancel();
                    onError(th);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Object obj = this.f136127c;
            if (obj != null) {
                this.f136127c = null;
                this.f136128d = SubscriptionHelper.CANCELLED;
                this.f136125a.onSuccess(obj);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f136127c == null) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f136127c = null;
            this.f136128d = SubscriptionHelper.CANCELLED;
            this.f136125a.onError(th);
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f136122a.i(new ReduceSeedObserver(singleObserver, this.f136124c, this.f136123b));
    }
}
