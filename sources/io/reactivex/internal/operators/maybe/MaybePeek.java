package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybePeek<T> extends AbstractMaybeWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Consumer f136964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Consumer f136965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Consumer f136966d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Action f136967f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Action f136968g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Action f136969h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MaybePeekObserver<T> implements MaybeObserver<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f136970a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final MaybePeek f136971b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f136972c;

        MaybePeekObserver(MaybeObserver maybeObserver, MaybePeek maybePeek) {
            this.f136970a = maybeObserver;
            this.f136971b = maybePeek;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f136972c, disposable)) {
                try {
                    this.f136971b.f136964b.accept(disposable);
                    this.f136972c = disposable;
                    this.f136970a.a(this);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    disposable.dispose();
                    this.f136972c = DisposableHelper.DISPOSED;
                    EmptyDisposable.h(th, this.f136970a);
                }
            }
        }

        void b() {
            try {
                this.f136971b.f136968g.run();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(th);
            }
        }

        void c(Throwable th) {
            try {
                this.f136971b.f136966d.accept(th);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                th = new CompositeException(th, th2);
            }
            this.f136972c = DisposableHelper.DISPOSED;
            this.f136970a.onError(th);
            b();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            try {
                this.f136971b.f136969h.run();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(th);
            }
            this.f136972c.dispose();
            this.f136972c = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f136972c.e();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            Disposable disposable = this.f136972c;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable == disposableHelper) {
                return;
            }
            try {
                this.f136971b.f136967f.run();
                this.f136972c = disposableHelper;
                this.f136970a.onComplete();
                b();
            } catch (Throwable th) {
                Exceptions.b(th);
                c(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            if (this.f136972c == DisposableHelper.DISPOSED) {
                RxJavaPlugins.s(th);
            } else {
                c(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            Disposable disposable = this.f136972c;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable == disposableHelper) {
                return;
            }
            try {
                this.f136971b.f136965c.accept(obj);
                this.f136972c = disposableHelper;
                this.f136970a.onSuccess(obj);
                b();
            } catch (Throwable th) {
                Exceptions.b(th);
                c(th);
            }
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        this.f136730a.b(new MaybePeekObserver(maybeObserver, this));
    }
}
