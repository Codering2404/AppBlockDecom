package io.reactivex.internal.operators.observable;

import io.reactivex.Emitter;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableGenerate<T, S> extends Observable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Callable f137752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final BiFunction f137753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Consumer f137754c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class GeneratorDisposable<T, S> implements Emitter<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137755a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BiFunction f137756b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Consumer f137757c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f137758d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile boolean f137759f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f137760g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f137761h;

        GeneratorDisposable(Observer observer, BiFunction biFunction, Consumer consumer, Object obj) {
            this.f137755a = observer;
            this.f137756b = biFunction;
            this.f137757c = consumer;
            this.f137758d = obj;
        }

        private void a(Object obj) {
            try {
                this.f137757c.accept(obj);
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(th);
            }
        }

        public void b(Throwable th) {
            if (this.f137760g) {
                RxJavaPlugins.s(th);
                return;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.f137760g = true;
            this.f137755a.onError(th);
        }

        public void c() {
            Object objApply = this.f137758d;
            if (this.f137759f) {
                this.f137758d = null;
                a(objApply);
                return;
            }
            BiFunction biFunction = this.f137756b;
            while (!this.f137759f) {
                this.f137761h = false;
                try {
                    objApply = biFunction.apply(objApply, this);
                    if (this.f137760g) {
                        this.f137759f = true;
                        this.f137758d = null;
                        a(objApply);
                        return;
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f137758d = null;
                    this.f137759f = true;
                    b(th);
                    a(objApply);
                    return;
                }
            }
            this.f137758d = null;
            a(objApply);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137759f = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137759f;
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        try {
            GeneratorDisposable generatorDisposable = new GeneratorDisposable(observer, this.f137753b, this.f137754c, this.f137752a.call());
            observer.a(generatorDisposable);
            generatorDisposable.c();
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.i(th, observer);
        }
    }
}
