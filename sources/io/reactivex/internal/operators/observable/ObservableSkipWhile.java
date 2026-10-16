package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableSkipWhile<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Predicate f138221b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SkipWhileObserver<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138222a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Predicate f138223b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f138224c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f138225d;

        SkipWhileObserver(Observer observer, Predicate predicate) {
            this.f138222a = observer;
            this.f138223b = predicate;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138224c, disposable)) {
                this.f138224c = disposable;
                this.f138222a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f138224c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138224c.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f138225d) {
                this.f138222a.h(obj);
                return;
            }
            try {
                if (this.f138223b.test(obj)) {
                    return;
                }
                this.f138225d = true;
                this.f138222a.h(obj);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f138224c.dispose();
                this.f138222a.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f138222a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f138222a.onError(th);
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        this.f137267a.b(new SkipWhileObserver(observer, this.f138221b));
    }
}
