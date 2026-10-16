package io.reactivex.internal.operators.single;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleFromPublisher<T> extends Single<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Publisher f138872a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ToSingleObserver<T> implements FlowableSubscriber<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f138873a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Subscription f138874b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f138875c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f138876d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile boolean f138877f;

        ToSingleObserver(SingleObserver singleObserver) {
            this.f138873a = singleObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f138877f = true;
            this.f138874b.cancel();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138877f;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f138874b, subscription)) {
                this.f138874b = subscription;
                this.f138873a.a(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f138876d) {
                return;
            }
            if (this.f138875c == null) {
                this.f138875c = obj;
                return;
            }
            this.f138874b.cancel();
            this.f138876d = true;
            this.f138875c = null;
            this.f138873a.onError(new IndexOutOfBoundsException("Too many elements in the Publisher"));
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f138876d) {
                return;
            }
            this.f138876d = true;
            Object obj = this.f138875c;
            this.f138875c = null;
            if (obj == null) {
                this.f138873a.onError(new NoSuchElementException("The source Publisher is empty"));
            } else {
                this.f138873a.onSuccess(obj);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f138876d) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f138876d = true;
            this.f138875c = null;
            this.f138873a.onError(th);
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f138872a.i(new ToSingleObserver(singleObserver));
    }
}
