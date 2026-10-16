package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableBuffer<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f137329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f137330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Callable f137331d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BufferExactObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f137333b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Callable f137334c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Collection f137335d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f137336f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Disposable f137337g;

        BufferExactObserver(Observer observer, int i3, Callable callable) {
            this.f137332a = observer;
            this.f137333b = i3;
            this.f137334c = callable;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137337g, disposable)) {
                this.f137337g = disposable;
                this.f137332a.a(this);
            }
        }

        boolean b() {
            try {
                this.f137335d = (Collection) ObjectHelper.d(this.f137334c.call(), "Empty buffer supplied");
                return true;
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f137335d = null;
                Disposable disposable = this.f137337g;
                if (disposable == null) {
                    EmptyDisposable.i(th, this.f137332a);
                    return false;
                }
                disposable.dispose();
                this.f137332a.onError(th);
                return false;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137337g.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137337g.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            Collection collection = this.f137335d;
            if (collection != null) {
                collection.add(obj);
                int i3 = this.f137336f + 1;
                this.f137336f = i3;
                if (i3 >= this.f137333b) {
                    this.f137332a.h(collection);
                    this.f137336f = 0;
                    b();
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Collection collection = this.f137335d;
            if (collection != null) {
                this.f137335d = null;
                if (!collection.isEmpty()) {
                    this.f137332a.h(collection);
                }
                this.f137332a.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f137335d = null;
            this.f137332a.onError(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BufferSkipObserver<T, U extends Collection<? super T>> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -8223395059921494546L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137338a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f137339b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f137340c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Callable f137341d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Disposable f137342f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final ArrayDeque f137343g = new ArrayDeque();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        long f137344h;

        BufferSkipObserver(Observer observer, int i3, int i4, Callable callable) {
            this.f137338a = observer;
            this.f137339b = i3;
            this.f137340c = i4;
            this.f137341d = callable;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137342f, disposable)) {
                this.f137342f = disposable;
                this.f137338a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137342f.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137342f.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            long j3 = this.f137344h;
            this.f137344h = 1 + j3;
            if (j3 % ((long) this.f137340c) == 0) {
                try {
                    this.f137343g.offer((Collection) ObjectHelper.d(this.f137341d.call(), "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources."));
                } catch (Throwable th) {
                    this.f137343g.clear();
                    this.f137342f.dispose();
                    this.f137338a.onError(th);
                    return;
                }
            }
            Iterator it = this.f137343g.iterator();
            while (it.hasNext()) {
                Collection collection = (Collection) it.next();
                collection.add(obj);
                if (this.f137339b <= collection.size()) {
                    it.remove();
                    this.f137338a.h(collection);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            while (!this.f137343g.isEmpty()) {
                this.f137338a.h(this.f137343g.poll());
            }
            this.f137338a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f137343g.clear();
            this.f137338a.onError(th);
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        int i3 = this.f137330c;
        int i4 = this.f137329b;
        if (i3 != i4) {
            this.f137267a.b(new BufferSkipObserver(observer, this.f137329b, this.f137330c, this.f137331d));
            return;
        }
        BufferExactObserver bufferExactObserver = new BufferExactObserver(observer, i4, this.f137331d);
        if (bufferExactObserver.b()) {
            this.f137267a.b(bufferExactObserver);
        }
    }
}
