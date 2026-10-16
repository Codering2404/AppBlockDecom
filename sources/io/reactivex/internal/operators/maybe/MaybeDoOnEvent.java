package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeDoOnEvent<T> extends AbstractMaybeWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final BiConsumer f136819b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DoOnEventMaybeObserver<T> implements MaybeObserver<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f136820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BiConsumer f136821b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f136822c;

        DoOnEventMaybeObserver(MaybeObserver maybeObserver, BiConsumer biConsumer) {
            this.f136820a = maybeObserver;
            this.f136821b = biConsumer;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f136822c, disposable)) {
                this.f136822c = disposable;
                this.f136820a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f136822c.dispose();
            this.f136822c = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f136822c.e();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f136822c = DisposableHelper.DISPOSED;
            try {
                this.f136821b.accept(null, null);
                this.f136820a.onComplete();
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f136820a.onError(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f136822c = DisposableHelper.DISPOSED;
            try {
                this.f136821b.accept(null, th);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                th = new CompositeException(th, th2);
            }
            this.f136820a.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            this.f136822c = DisposableHelper.DISPOSED;
            try {
                this.f136821b.accept(obj, null);
                this.f136820a.onSuccess(obj);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f136820a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        this.f136730a.b(new DoOnEventMaybeObserver(maybeObserver, this.f136819b));
    }
}
