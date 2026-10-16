package io.reactivex.internal.operators.observable;

import com.google.android.material.bottomsheet.lKiE.YznnJpHcAmeoW;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableSingleSingle<T> extends Single<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ObservableSource f138180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object f138181b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SingleElementObserver<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f138182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f138183b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f138184c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f138185d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f138186f;

        SingleElementObserver(SingleObserver singleObserver, Object obj) {
            this.f138182a = singleObserver;
            this.f138183b = obj;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138184c, disposable)) {
                this.f138184c = disposable;
                this.f138182a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f138184c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138184c.e();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f138186f) {
                return;
            }
            this.f138186f = true;
            Object obj = this.f138185d;
            this.f138185d = null;
            if (obj == null) {
                obj = this.f138183b;
            }
            if (obj != null) {
                this.f138182a.onSuccess(obj);
            } else {
                this.f138182a.onError(new NoSuchElementException());
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f138186f) {
                RxJavaPlugins.s(th);
            } else {
                this.f138186f = true;
                this.f138182a.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f138186f) {
                return;
            }
            if (this.f138185d == null) {
                this.f138185d = obj;
                return;
            }
            this.f138186f = true;
            this.f138184c.dispose();
            this.f138182a.onError(new IllegalArgumentException(YznnJpHcAmeoW.YLWpk));
        }
    }

    public ObservableSingleSingle(ObservableSource observableSource, Object obj) {
        this.f138180a = observableSource;
        this.f138181b = obj;
    }

    @Override // io.reactivex.Single
    public void c(SingleObserver singleObserver) {
        this.f138180a.b(new SingleElementObserver(singleObserver, this.f138181b));
    }
}
