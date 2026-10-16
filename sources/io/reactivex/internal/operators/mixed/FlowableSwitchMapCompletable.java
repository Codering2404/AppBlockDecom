package io.reactivex.internal.operators.mixed;

import androidx.compose.animation.core.h;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableSwitchMapCompletable<T> extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Flowable f137119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f137120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f137121c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SwitchMapCompletableObserver<T> implements FlowableSubscriber<T>, Disposable {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        static final SwitchMapInnerObserver f137122i = new SwitchMapInnerObserver(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompletableObserver f137123a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f137124b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f137125c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicThrowable f137126d = new AtomicThrowable();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicReference f137127f = new AtomicReference();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        volatile boolean f137128g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Subscription f137129h;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class SwitchMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = -8003404460084760287L;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final SwitchMapCompletableObserver f137130a;

            SwitchMapInnerObserver(SwitchMapCompletableObserver switchMapCompletableObserver) {
                this.f137130a = switchMapCompletableObserver;
            }

            @Override // io.reactivex.CompletableObserver
            public void a(Disposable disposable) {
                DisposableHelper.g(this, disposable);
            }

            void b() {
                DisposableHelper.a(this);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                this.f137130a.b(this);
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                this.f137130a.c(this, th);
            }
        }

        SwitchMapCompletableObserver(CompletableObserver completableObserver, Function function, boolean z2) {
            this.f137123a = completableObserver;
            this.f137124b = function;
            this.f137125c = z2;
        }

        void a() {
            AtomicReference atomicReference = this.f137127f;
            SwitchMapInnerObserver switchMapInnerObserver = f137122i;
            SwitchMapInnerObserver switchMapInnerObserver2 = (SwitchMapInnerObserver) atomicReference.getAndSet(switchMapInnerObserver);
            if (switchMapInnerObserver2 == null || switchMapInnerObserver2 == switchMapInnerObserver) {
                return;
            }
            switchMapInnerObserver2.b();
        }

        void b(SwitchMapInnerObserver switchMapInnerObserver) {
            if (h.a(this.f137127f, switchMapInnerObserver, null) && this.f137128g) {
                Throwable thB = this.f137126d.b();
                if (thB == null) {
                    this.f137123a.onComplete();
                } else {
                    this.f137123a.onError(thB);
                }
            }
        }

        void c(SwitchMapInnerObserver switchMapInnerObserver, Throwable th) {
            if (!h.a(this.f137127f, switchMapInnerObserver, null) || !this.f137126d.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (this.f137125c) {
                if (this.f137128g) {
                    this.f137123a.onError(this.f137126d.b());
                    return;
                }
                return;
            }
            dispose();
            Throwable thB = this.f137126d.b();
            if (thB != ExceptionHelper.f139204a) {
                this.f137123a.onError(thB);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137129h.cancel();
            a();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137127f.get() == f137122i;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f137129h, subscription)) {
                this.f137129h = subscription;
                this.f137123a.a(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            SwitchMapInnerObserver switchMapInnerObserver;
            try {
                CompletableSource completableSource = (CompletableSource) ObjectHelper.d(this.f137124b.apply(obj), "The mapper returned a null CompletableSource");
                SwitchMapInnerObserver switchMapInnerObserver2 = new SwitchMapInnerObserver(this);
                do {
                    switchMapInnerObserver = (SwitchMapInnerObserver) this.f137127f.get();
                    if (switchMapInnerObserver == f137122i) {
                        return;
                    }
                } while (!h.a(this.f137127f, switchMapInnerObserver, switchMapInnerObserver2));
                if (switchMapInnerObserver != null) {
                    switchMapInnerObserver.b();
                }
                completableSource.b(switchMapInnerObserver2);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f137129h.cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f137128g = true;
            if (this.f137127f.get() == null) {
                Throwable thB = this.f137126d.b();
                if (thB == null) {
                    this.f137123a.onComplete();
                } else {
                    this.f137123a.onError(thB);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.f137126d.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (this.f137125c) {
                onComplete();
                return;
            }
            a();
            Throwable thB = this.f137126d.b();
            if (thB != ExceptionHelper.f139204a) {
                this.f137123a.onError(thB);
            }
        }
    }

    @Override // io.reactivex.Completable
    protected void c(CompletableObserver completableObserver) {
        this.f137119a.w(new SwitchMapCompletableObserver(completableObserver, this.f137120b, this.f137121c));
    }
}
