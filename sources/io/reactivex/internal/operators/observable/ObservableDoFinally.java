package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableDoFinally<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Action f137606b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DoFinallyObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T> {
        private static final long serialVersionUID = 4109457741734051389L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137607a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Action f137608b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f137609c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        QueueDisposable f137610d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f137611f;

        DoFinallyObserver(Observer observer, Action action) {
            this.f137607a = observer;
            this.f137608b = action;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137609c, disposable)) {
                this.f137609c = disposable;
                if (disposable instanceof QueueDisposable) {
                    this.f137610d = (QueueDisposable) disposable;
                }
                this.f137607a.a(this);
            }
        }

        void b() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f137608b.run();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.s(th);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.f137610d.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137609c.dispose();
            b();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137609c.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f137607a.h(obj);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.f137610d.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int l(int i3) {
            QueueDisposable queueDisposable = this.f137610d;
            if (queueDisposable == null || (i3 & 4) != 0) {
                return 0;
            }
            int iL = queueDisposable.l(i3);
            if (iL != 0) {
                this.f137611f = iL == 1;
            }
            return iL;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137607a.onComplete();
            b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f137607a.onError(th);
            b();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            Object objPoll = this.f137610d.poll();
            if (objPoll == null && this.f137611f) {
                b();
            }
            return objPoll;
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        this.f137267a.b(new DoFinallyObserver(observer, this.f137606b));
    }
}
