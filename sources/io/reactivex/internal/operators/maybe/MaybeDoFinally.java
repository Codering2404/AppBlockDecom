package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeDoFinally<T> extends AbstractMaybeWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Action f136815b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DoFinallyObserver<T> extends AtomicInteger implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 4109457741734051389L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f136816a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Action f136817b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f136818c;

        DoFinallyObserver(MaybeObserver maybeObserver, Action action) {
            this.f136816a = maybeObserver;
            this.f136817b = action;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f136818c, disposable)) {
                this.f136818c = disposable;
                this.f136816a.a(this);
            }
        }

        void b() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f136817b.run();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.s(th);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f136818c.dispose();
            b();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f136818c.e();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f136816a.onComplete();
            b();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f136816a.onError(th);
            b();
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            this.f136816a.onSuccess(obj);
            b();
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        this.f136730a.b(new DoFinallyObserver(maybeObserver, this.f136815b));
    }
}
