package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableReduceMaybe<T> extends Maybe<T> implements HasUpstreamPublisher<T>, FuseToFlowable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Flowable f136115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final BiFunction f136116b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ReduceSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f136117a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BiFunction f136118b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f136119c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Subscription f136120d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f136121f;

        ReduceSubscriber(MaybeObserver maybeObserver, BiFunction biFunction) {
            this.f136117a = maybeObserver;
            this.f136118b = biFunction;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f136120d.cancel();
            this.f136121f = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f136121f;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136120d, subscription)) {
                this.f136120d = subscription;
                this.f136117a.a(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f136121f) {
                return;
            }
            Object obj2 = this.f136119c;
            if (obj2 == null) {
                this.f136119c = obj;
                return;
            }
            try {
                this.f136119c = ObjectHelper.d(this.f136118b.apply(obj2, obj), "The reducer returned a null value");
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f136120d.cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f136121f) {
                return;
            }
            this.f136121f = true;
            Object obj = this.f136119c;
            if (obj != null) {
                this.f136117a.onSuccess(obj);
            } else {
                this.f136117a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f136121f) {
                RxJavaPlugins.s(th);
            } else {
                this.f136121f = true;
                this.f136117a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        this.f136115a.w(new ReduceSubscriber(maybeObserver, this.f136116b));
    }
}
