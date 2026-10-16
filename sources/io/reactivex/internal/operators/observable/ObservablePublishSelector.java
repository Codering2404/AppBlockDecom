package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservablePublishSelector<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f137974b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SourceObserver<T, R> implements Observer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final PublishSubject f137975a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReference f137976b;

        SourceObserver(PublishSubject publishSubject, AtomicReference atomicReference) {
            this.f137975a = publishSubject;
            this.f137976b = atomicReference;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            DisposableHelper.g(this.f137976b, disposable);
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f137975a.h(obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137975a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f137975a.onError(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TargetObserver<T, R> extends AtomicReference<Disposable> implements Observer<R>, Disposable {
        private static final long serialVersionUID = 854110278590336484L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Disposable f137978b;

        TargetObserver(Observer observer) {
            this.f137977a = observer;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137978b, disposable)) {
                this.f137978b = disposable;
                this.f137977a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137978b.dispose();
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137978b.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f137977a.h(obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            DisposableHelper.a(this);
            this.f137977a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            DisposableHelper.a(this);
            this.f137977a.onError(th);
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        PublishSubject publishSubjectC = PublishSubject.C();
        try {
            ObservableSource observableSource = (ObservableSource) ObjectHelper.d(this.f137974b.apply(publishSubjectC), "The selector returned a null ObservableSource");
            TargetObserver targetObserver = new TargetObserver(observer);
            observableSource.b(targetObserver);
            this.f137267a.b(new SourceObserver(publishSubjectC, targetObserver));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.i(th, observer);
        }
    }
}
