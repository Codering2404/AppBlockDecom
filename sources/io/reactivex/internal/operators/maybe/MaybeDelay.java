package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeDelay<T> extends AbstractMaybeWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f136782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f136783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Scheduler f136784d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DelayMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable, Runnable {
        private static final long serialVersionUID = 5566860102500855068L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f136785a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f136786b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final TimeUnit f136787c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Scheduler f136788d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f136789f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Throwable f136790g;

        DelayMaybeObserver(MaybeObserver maybeObserver, long j3, TimeUnit timeUnit, Scheduler scheduler) {
            this.f136785a = maybeObserver;
            this.f136786b = j3;
            this.f136787c = timeUnit;
            this.f136788d = scheduler;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.g(this, disposable)) {
                this.f136785a.a(this);
            }
        }

        void b() {
            DisposableHelper.c(this, this.f136788d.f(this, this.f136786b, this.f136787c));
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(get());
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            b();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f136790g = th;
            b();
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            this.f136789f = obj;
            b();
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.f136790g;
            if (th != null) {
                this.f136785a.onError(th);
                return;
            }
            Object obj = this.f136789f;
            if (obj != null) {
                this.f136785a.onSuccess(obj);
            } else {
                this.f136785a.onComplete();
            }
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        this.f136730a.b(new DelayMaybeObserver(maybeObserver, this.f136782b, this.f136783c, this.f136784d));
    }
}
