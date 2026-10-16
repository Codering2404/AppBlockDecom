package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeEqualSingle<T> extends Single<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final MaybeSource f136824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final MaybeSource f136825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final BiPredicate f136826c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f136827a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final EqualObserver f136828b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final EqualObserver f136829c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final BiPredicate f136830d;

        EqualCoordinator(SingleObserver singleObserver, BiPredicate biPredicate) {
            super(2);
            this.f136827a = singleObserver;
            this.f136830d = biPredicate;
            this.f136828b = new EqualObserver(this);
            this.f136829c = new EqualObserver(this);
        }

        void a() {
            if (decrementAndGet() == 0) {
                Object obj = this.f136828b.f136832b;
                Object obj2 = this.f136829c.f136832b;
                if (obj == null || obj2 == null) {
                    this.f136827a.onSuccess(Boolean.valueOf(obj == null && obj2 == null));
                    return;
                }
                try {
                    this.f136827a.onSuccess(Boolean.valueOf(this.f136830d.test(obj, obj2)));
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f136827a.onError(th);
                }
            }
        }

        void b(EqualObserver equalObserver, Throwable th) {
            if (getAndSet(0) <= 0) {
                RxJavaPlugins.s(th);
                return;
            }
            EqualObserver equalObserver2 = this.f136828b;
            if (equalObserver == equalObserver2) {
                this.f136829c.b();
            } else {
                equalObserver2.b();
            }
            this.f136827a.onError(th);
        }

        void c(MaybeSource maybeSource, MaybeSource maybeSource2) {
            maybeSource.b(this.f136828b);
            maybeSource2.b(this.f136829c);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f136828b.b();
            this.f136829c.b();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(this.f136828b.get());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class EqualObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        private static final long serialVersionUID = -3031974433025990931L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final EqualCoordinator f136831a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f136832b;

        EqualObserver(EqualCoordinator equalCoordinator) {
            this.f136831a = equalCoordinator;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            DisposableHelper.g(this, disposable);
        }

        public void b() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f136831a.a();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f136831a.b(this, th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            this.f136832b = obj;
            this.f136831a.a();
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(singleObserver, this.f136826c);
        singleObserver.a(equalCoordinator);
        equalCoordinator.c(this.f136824a, this.f136825b);
    }
}
