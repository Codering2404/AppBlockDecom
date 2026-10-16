package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableElementAt<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f137625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Object f137626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f137627d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ElementAtObserver<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f137629b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Object f137630c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f137631d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Disposable f137632f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        long f137633g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f137634h;

        ElementAtObserver(Observer observer, long j3, Object obj, boolean z2) {
            this.f137628a = observer;
            this.f137629b = j3;
            this.f137630c = obj;
            this.f137631d = z2;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137632f, disposable)) {
                this.f137632f = disposable;
                this.f137628a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137632f.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137632f.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f137634h) {
                return;
            }
            long j3 = this.f137633g;
            if (j3 != this.f137629b) {
                this.f137633g = j3 + 1;
                return;
            }
            this.f137634h = true;
            this.f137632f.dispose();
            this.f137628a.h(obj);
            this.f137628a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f137634h) {
                return;
            }
            this.f137634h = true;
            Object obj = this.f137630c;
            if (obj == null && this.f137631d) {
                this.f137628a.onError(new NoSuchElementException());
                return;
            }
            if (obj != null) {
                this.f137628a.h(obj);
            }
            this.f137628a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f137634h) {
                RxJavaPlugins.s(th);
            } else {
                this.f137634h = true;
                this.f137628a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        this.f137267a.b(new ElementAtObserver(observer, this.f137625b, this.f137626c, this.f137627d));
    }
}
