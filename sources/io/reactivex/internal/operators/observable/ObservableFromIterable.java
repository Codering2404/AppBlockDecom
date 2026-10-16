package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableFromIterable<T> extends Observable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Iterable f137741a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FromIterableDisposable<T> extends BasicQueueDisposable<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Iterator f137743b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile boolean f137744c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f137745d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f137746f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f137747g;

        FromIterableDisposable(Observer observer, Iterator it) {
            this.f137742a = observer;
            this.f137743b = it;
        }

        void b() {
            while (!e()) {
                try {
                    this.f137742a.h(ObjectHelper.d(this.f137743b.next(), "The iterator returned a null value"));
                    if (e()) {
                        return;
                    }
                    try {
                        if (!this.f137743b.hasNext()) {
                            if (e()) {
                                return;
                            }
                            this.f137742a.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f137742a.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    this.f137742a.onError(th2);
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.f137746f = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137744c = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137744c;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.f137746f;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int l(int i3) {
            if ((i3 & 1) == 0) {
                return 0;
            }
            this.f137745d = true;
            return 1;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            if (this.f137746f) {
                return null;
            }
            if (!this.f137747g) {
                this.f137747g = true;
            } else if (!this.f137743b.hasNext()) {
                this.f137746f = true;
                return null;
            }
            return ObjectHelper.d(this.f137743b.next(), "The iterator returned a null value");
        }
    }

    public ObservableFromIterable(Iterable iterable) {
        this.f137741a = iterable;
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        try {
            Iterator<T> it = this.f137741a.iterator();
            try {
                if (!it.hasNext()) {
                    EmptyDisposable.c(observer);
                    return;
                }
                FromIterableDisposable fromIterableDisposable = new FromIterableDisposable(observer, it);
                observer.a(fromIterableDisposable);
                if (fromIterableDisposable.f137745d) {
                    return;
                }
                fromIterableDisposable.b();
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptyDisposable.i(th, observer);
            }
        } catch (Throwable th2) {
            Exceptions.b(th2);
            EmptyDisposable.i(th2, observer);
        }
    }
}
