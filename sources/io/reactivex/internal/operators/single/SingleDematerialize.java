package io.reactivex.internal.operators.single;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Notification;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleDematerialize<T, R> extends Maybe<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Single f138780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f138781b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DematerializeObserver<T, R> implements SingleObserver<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f138782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f138783b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f138784c;

        DematerializeObserver(MaybeObserver maybeObserver, Function function) {
            this.f138782a = maybeObserver;
            this.f138783b = function;
        }

        @Override // io.reactivex.SingleObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138784c, disposable)) {
                this.f138784c = disposable;
                this.f138782a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f138784c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138784c.e();
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.f138782a.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            try {
                Notification notification = (Notification) ObjectHelper.d(this.f138783b.apply(obj), "The selector returned a null Notification");
                if (notification.h()) {
                    this.f138782a.onSuccess(notification.e());
                } else if (notification.f()) {
                    this.f138782a.onComplete();
                } else {
                    this.f138782a.onError(notification.d());
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f138782a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        this.f138780a.b(new DematerializeObserver(maybeObserver, this.f138781b));
    }
}
