package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableDoOnEach<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Consumer f137612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Consumer f137613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Action f137614d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Action f137615f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DoOnEachObserver<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Consumer f137617b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Consumer f137618c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Action f137619d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Action f137620f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Disposable f137621g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f137622h;

        DoOnEachObserver(Observer observer, Consumer consumer, Consumer consumer2, Action action, Action action2) {
            this.f137616a = observer;
            this.f137617b = consumer;
            this.f137618c = consumer2;
            this.f137619d = action;
            this.f137620f = action2;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137621g, disposable)) {
                this.f137621g = disposable;
                this.f137616a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137621g.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137621g.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f137622h) {
                return;
            }
            try {
                this.f137617b.accept(obj);
                this.f137616a.h(obj);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f137621g.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f137622h) {
                return;
            }
            try {
                this.f137619d.run();
                this.f137622h = true;
                this.f137616a.onComplete();
                try {
                    this.f137620f.run();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.s(th);
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                onError(th2);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f137622h) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f137622h = true;
            try {
                this.f137618c.accept(th);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                th = new CompositeException(th, th2);
            }
            this.f137616a.onError(th);
            try {
                this.f137620f.run();
            } catch (Throwable th3) {
                Exceptions.b(th3);
                RxJavaPlugins.s(th3);
            }
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        this.f137267a.b(new DoOnEachObserver(observer, this.f137612b, this.f137613c, this.f137614d, this.f137615f));
    }
}
