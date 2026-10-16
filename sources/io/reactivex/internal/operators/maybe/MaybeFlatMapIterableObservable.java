package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeFlatMapIterableObservable<T, R> extends Observable<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final MaybeSource f136864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f136865b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FlatMapIterableObserver<T, R> extends BasicQueueDisposable<R> implements MaybeObserver<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f136866a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f136867b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f136868c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile Iterator f136869d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile boolean f136870f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f136871g;

        FlatMapIterableObserver(Observer observer, Function function) {
            this.f136866a = observer;
            this.f136867b = function;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f136868c, disposable)) {
                this.f136868c = disposable;
                this.f136866a.a(this);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.f136869d = null;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f136870f = true;
            this.f136868c.dispose();
            this.f136868c = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f136870f;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.f136869d == null;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int l(int i3) {
            if ((i3 & 2) == 0) {
                return 0;
            }
            this.f136871g = true;
            return 2;
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f136866a.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f136868c = DisposableHelper.DISPOSED;
            this.f136866a.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            Observer observer = this.f136866a;
            try {
                Iterator<T> it = ((Iterable) this.f136867b.apply(obj)).iterator();
                if (!it.hasNext()) {
                    observer.onComplete();
                    return;
                }
                this.f136869d = it;
                if (this.f136871g) {
                    observer.h(null);
                    observer.onComplete();
                    return;
                }
                while (!this.f136870f) {
                    try {
                        observer.h(it.next());
                        if (this.f136870f) {
                            return;
                        }
                        try {
                            if (!it.hasNext()) {
                                observer.onComplete();
                                return;
                            }
                        } catch (Throwable th) {
                            Exceptions.b(th);
                            observer.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.b(th2);
                        observer.onError(th2);
                        return;
                    }
                }
            } catch (Throwable th3) {
                Exceptions.b(th3);
                observer.onError(th3);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            Iterator it = this.f136869d;
            if (it == null) {
                return null;
            }
            Object objD = ObjectHelper.d(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f136869d = null;
            }
            return objD;
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        this.f136864a.b(new FlatMapIterableObserver(observer, this.f136865b));
    }
}
