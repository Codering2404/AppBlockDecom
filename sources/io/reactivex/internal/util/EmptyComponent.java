package io.reactivex.internal.util;

import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public enum EmptyComponent implements FlowableSubscriber<Object>, Observer<Object>, MaybeObserver<Object>, SingleObserver<Object>, CompletableObserver, Subscription, Disposable {
    INSTANCE;

    public static Observer b() {
        return INSTANCE;
    }

    public static Subscriber c() {
        return INSTANCE;
    }

    @Override // io.reactivex.Observer
    public void a(Disposable disposable) {
        disposable.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean e() {
        return true;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void g(Subscription subscription) {
        subscription.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        RxJavaPlugins.s(th);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
    }

    @Override // org.reactivestreams.Subscriber
    public void h(Object obj) {
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(Object obj) {
    }

    @Override // org.reactivestreams.Subscription
    public void y(long j3) {
    }
}
