package io.reactivex.internal.operators.maybe;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeDelayOtherPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Publisher f136791b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DelayMaybeObserver<T, U> implements MaybeObserver<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OtherSubscriber f136792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Publisher f136793b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f136794c;

        DelayMaybeObserver(MaybeObserver maybeObserver, Publisher publisher) {
            this.f136792a = new OtherSubscriber(maybeObserver);
            this.f136793b = publisher;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f136794c, disposable)) {
                this.f136794c = disposable;
                this.f136792a.f136795a.a(this);
            }
        }

        void b() {
            this.f136793b.i(this.f136792a);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f136794c.dispose();
            this.f136794c = DisposableHelper.DISPOSED;
            SubscriptionHelper.a(this.f136792a);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f136792a.get() == SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f136794c = DisposableHelper.DISPOSED;
            b();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f136794c = DisposableHelper.DISPOSED;
            this.f136792a.f136797c = th;
            b();
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            this.f136794c = DisposableHelper.DISPOSED;
            this.f136792a.f136796b = obj;
            b();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class OtherSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        private static final long serialVersionUID = -1215060610805418006L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f136795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f136796b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Throwable f136797c;

        OtherSubscriber(MaybeObserver maybeObserver) {
            this.f136795a = maybeObserver;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            SubscriptionHelper.g(this, subscription, Long.MAX_VALUE);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            Subscription subscription = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                lazySet(subscriptionHelper);
                subscription.cancel();
                onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Throwable th = this.f136797c;
            if (th != null) {
                this.f136795a.onError(th);
                return;
            }
            Object obj = this.f136796b;
            if (obj != null) {
                this.f136795a.onSuccess(obj);
            } else {
                this.f136795a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Throwable th2 = this.f136797c;
            if (th2 == null) {
                this.f136795a.onError(th);
            } else {
                this.f136795a.onError(new CompositeException(th2, th));
            }
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        this.f136730a.b(new DelayMaybeObserver(maybeObserver, this.f136791b));
    }
}
