package io.reactivex.internal.operators.maybe;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeTimeoutPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Publisher f137005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final MaybeSource f137006c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimeoutFallbackMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        private static final long serialVersionUID = 8663801314800248617L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f137007a;

        TimeoutFallbackMaybeObserver(MaybeObserver maybeObserver) {
            this.f137007a = maybeObserver;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            DisposableHelper.g(this, disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f137007a.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f137007a.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            this.f137007a.onSuccess(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimeoutMainMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -5955289211445418871L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f137008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final TimeoutOtherMaybeObserver f137009b = new TimeoutOtherMaybeObserver(this);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final MaybeSource f137010c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final TimeoutFallbackMaybeObserver f137011d;

        TimeoutMainMaybeObserver(MaybeObserver maybeObserver, MaybeSource maybeSource) {
            this.f137008a = maybeObserver;
            this.f137010c = maybeSource;
            this.f137011d = maybeSource != null ? new TimeoutFallbackMaybeObserver(maybeObserver) : null;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            DisposableHelper.g(this, disposable);
        }

        public void b() {
            if (DisposableHelper.a(this)) {
                MaybeSource maybeSource = this.f137010c;
                if (maybeSource == null) {
                    this.f137008a.onError(new TimeoutException());
                } else {
                    maybeSource.b(this.f137011d);
                }
            }
        }

        public void c(Throwable th) {
            if (DisposableHelper.a(this)) {
                this.f137008a.onError(th);
            } else {
                RxJavaPlugins.s(th);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
            SubscriptionHelper.a(this.f137009b);
            TimeoutFallbackMaybeObserver timeoutFallbackMaybeObserver = this.f137011d;
            if (timeoutFallbackMaybeObserver != null) {
                DisposableHelper.a(timeoutFallbackMaybeObserver);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(get());
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            SubscriptionHelper.a(this.f137009b);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f137008a.onComplete();
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            SubscriptionHelper.a(this.f137009b);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f137008a.onError(th);
            } else {
                RxJavaPlugins.s(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            SubscriptionHelper.a(this.f137009b);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f137008a.onSuccess(obj);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimeoutOtherMaybeObserver<T, U> extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        private static final long serialVersionUID = 8663801314800248617L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final TimeoutMainMaybeObserver f137012a;

        TimeoutOtherMaybeObserver(TimeoutMainMaybeObserver timeoutMainMaybeObserver) {
            this.f137012a = timeoutMainMaybeObserver;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            SubscriptionHelper.g(this, subscription, Long.MAX_VALUE);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            get().cancel();
            this.f137012a.b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f137012a.b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f137012a.c(th);
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        TimeoutMainMaybeObserver timeoutMainMaybeObserver = new TimeoutMainMaybeObserver(maybeObserver, this.f137006c);
        maybeObserver.a(timeoutMainMaybeObserver);
        this.f137005b.i(timeoutMainMaybeObserver.f137009b);
        this.f136730a.b(timeoutMainMaybeObserver);
    }
}
