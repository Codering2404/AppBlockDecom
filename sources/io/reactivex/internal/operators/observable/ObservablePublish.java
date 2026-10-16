package io.reactivex.internal.operators.observable;

import androidx.compose.animation.core.h;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservablePublish<T> extends ConnectableObservable<T> implements HasUpstreamObservableSource<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ObservableSource f137963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference f137964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ObservableSource f137965c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class InnerDisposable<T> extends AtomicReference<Object> implements Disposable {
        private static final long serialVersionUID = -1100270633763673112L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137966a;

        InnerDisposable(Observer observer) {
            this.f137966a = observer;
        }

        void a(PublishObserver publishObserver) {
            if (compareAndSet(null, publishObserver)) {
                return;
            }
            publishObserver.c(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Object andSet = getAndSet(this);
            if (andSet == null || andSet == this) {
                return;
            }
            ((PublishObserver) andSet).c(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return get() == this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class PublishObserver<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final InnerDisposable[] f137967f = new InnerDisposable[0];

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        static final InnerDisposable[] f137968g = new InnerDisposable[0];

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicReference f137969a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReference f137972d = new AtomicReference();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReference f137970b = new AtomicReference(f137967f);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicBoolean f137971c = new AtomicBoolean();

        PublishObserver(AtomicReference atomicReference) {
            this.f137969a = atomicReference;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            DisposableHelper.g(this.f137972d, disposable);
        }

        boolean b(InnerDisposable innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = (InnerDisposable[]) this.f137970b.get();
                if (innerDisposableArr == f137968g) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[length + 1];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!h.a(this.f137970b, innerDisposableArr, innerDisposableArr2));
            return true;
        }

        void c(InnerDisposable innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = (InnerDisposable[]) this.f137970b.get();
                int length = innerDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        i3 = -1;
                        break;
                    } else if (innerDisposableArr[i3].equals(innerDisposable)) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i3 < 0) {
                    return;
                }
                if (length == 1) {
                    innerDisposableArr2 = f137967f;
                } else {
                    InnerDisposable[] innerDisposableArr3 = new InnerDisposable[length - 1];
                    System.arraycopy(innerDisposableArr, 0, innerDisposableArr3, 0, i3);
                    System.arraycopy(innerDisposableArr, i3 + 1, innerDisposableArr3, i3, (length - i3) - 1);
                    innerDisposableArr2 = innerDisposableArr3;
                }
            } while (!h.a(this.f137970b, innerDisposableArr, innerDisposableArr2));
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            AtomicReference atomicReference = this.f137970b;
            InnerDisposable[] innerDisposableArr = f137968g;
            if (((InnerDisposable[]) atomicReference.getAndSet(innerDisposableArr)) != innerDisposableArr) {
                h.a(this.f137969a, this, null);
                DisposableHelper.a(this.f137972d);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137970b.get() == f137968g;
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            for (InnerDisposable innerDisposable : (InnerDisposable[]) this.f137970b.get()) {
                innerDisposable.f137966a.h(obj);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            h.a(this.f137969a, this, null);
            for (InnerDisposable innerDisposable : (InnerDisposable[]) this.f137970b.getAndSet(f137968g)) {
                innerDisposable.f137966a.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            h.a(this.f137969a, this, null);
            InnerDisposable[] innerDisposableArr = (InnerDisposable[]) this.f137970b.getAndSet(f137968g);
            if (innerDisposableArr.length == 0) {
                RxJavaPlugins.s(th);
                return;
            }
            for (InnerDisposable innerDisposable : innerDisposableArr) {
                innerDisposable.f137966a.onError(th);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class PublishSource<T> implements ObservableSource<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicReference f137973a;

        @Override // io.reactivex.ObservableSource
        public void b(Observer observer) {
            InnerDisposable innerDisposable = new InnerDisposable(observer);
            observer.a(innerDisposable);
            while (true) {
                PublishObserver publishObserver = (PublishObserver) this.f137973a.get();
                if (publishObserver == null || publishObserver.e()) {
                    PublishObserver publishObserver2 = new PublishObserver(this.f137973a);
                    if (h.a(this.f137973a, publishObserver, publishObserver2)) {
                        publishObserver = publishObserver2;
                    } else {
                        continue;
                    }
                }
                if (publishObserver.b(innerDisposable)) {
                    innerDisposable.a(publishObserver);
                    return;
                }
            }
        }
    }

    @Override // io.reactivex.observables.ConnectableObservable
    public void A(Consumer consumer) {
        PublishObserver publishObserver;
        while (true) {
            publishObserver = (PublishObserver) this.f137964b.get();
            if (publishObserver != null && !publishObserver.e()) {
                break;
            }
            PublishObserver publishObserver2 = new PublishObserver(this.f137964b);
            if (h.a(this.f137964b, publishObserver, publishObserver2)) {
                publishObserver = publishObserver2;
                break;
            }
        }
        boolean z2 = false;
        if (!publishObserver.f137971c.get() && publishObserver.f137971c.compareAndSet(false, true)) {
            z2 = true;
        }
        try {
            consumer.accept(publishObserver);
            if (z2) {
                this.f137963a.b(publishObserver);
            }
        } catch (Throwable th) {
            Exceptions.b(th);
            throw ExceptionHelper.e(th);
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        this.f137965c.b(observer);
    }
}
