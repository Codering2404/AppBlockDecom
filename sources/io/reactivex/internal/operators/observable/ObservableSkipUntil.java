package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableSkipUntil<T, U> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ObservableSource f138210b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class SkipUntil implements Observer<U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ArrayCompositeDisposable f138211a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SkipUntilObserver f138212b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final SerializedObserver f138213c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Disposable f138214d;

        SkipUntil(ArrayCompositeDisposable arrayCompositeDisposable, SkipUntilObserver skipUntilObserver, SerializedObserver serializedObserver) {
            this.f138211a = arrayCompositeDisposable;
            this.f138212b = skipUntilObserver;
            this.f138213c = serializedObserver;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138214d, disposable)) {
                this.f138214d = disposable;
                this.f138211a.a(1, disposable);
            }
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f138214d.dispose();
            this.f138212b.f138219d = true;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f138212b.f138219d = true;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f138211a.dispose();
            this.f138213c.onError(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SkipUntilObserver<T> implements Observer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ArrayCompositeDisposable f138217b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f138218c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile boolean f138219d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f138220f;

        SkipUntilObserver(Observer observer, ArrayCompositeDisposable arrayCompositeDisposable) {
            this.f138216a = observer;
            this.f138217b = arrayCompositeDisposable;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138218c, disposable)) {
                this.f138218c = disposable;
                this.f138217b.a(0, disposable);
            }
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f138220f) {
                this.f138216a.h(obj);
            } else if (this.f138219d) {
                this.f138220f = true;
                this.f138216a.h(obj);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f138217b.dispose();
            this.f138216a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f138217b.dispose();
            this.f138216a.onError(th);
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        ArrayCompositeDisposable arrayCompositeDisposable = new ArrayCompositeDisposable(2);
        serializedObserver.a(arrayCompositeDisposable);
        SkipUntilObserver skipUntilObserver = new SkipUntilObserver(serializedObserver, arrayCompositeDisposable);
        this.f138210b.b(new SkipUntil(arrayCompositeDisposable, skipUntilObserver, serializedObserver));
        this.f137267a.b(skipUntilObserver);
    }
}
