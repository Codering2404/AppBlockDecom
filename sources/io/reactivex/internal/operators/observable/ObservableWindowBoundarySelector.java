package io.reactivex.internal.operators.observable;

import androidx.compose.animation.core.h;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableWindowBoundarySelector<T, B, V> extends AbstractObservableWithUpstream<T, Observable<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ObservableSource f138432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f138433c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f138434d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class OperatorWindowBoundaryCloseObserver<T, V> extends DisposableObserver<V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final WindowBoundaryMainObserver f138435b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final UnicastSubject f138436c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f138437d;

        OperatorWindowBoundaryCloseObserver(WindowBoundaryMainObserver windowBoundaryMainObserver, UnicastSubject unicastSubject) {
            this.f138435b = windowBoundaryMainObserver;
            this.f138436c = unicastSubject;
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            dispose();
            onComplete();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f138437d) {
                return;
            }
            this.f138437d = true;
            this.f138435b.l(this);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f138437d) {
                RxJavaPlugins.s(th);
            } else {
                this.f138437d = true;
                this.f138435b.o(th);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class OperatorWindowBoundaryOpenObserver<T, B> extends DisposableObserver<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final WindowBoundaryMainObserver f138438b;

        OperatorWindowBoundaryOpenObserver(WindowBoundaryMainObserver windowBoundaryMainObserver) {
            this.f138438b = windowBoundaryMainObserver;
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f138438b.q(obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f138438b.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f138438b.o(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WindowOperation<T, B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final UnicastSubject f138447a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f138448b;

        WindowOperation(UnicastSubject unicastSubject, Object obj) {
            this.f138447a = unicastSubject;
            this.f138448b = obj;
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        this.f137267a.b(new WindowBoundaryMainObserver(new SerializedObserver(observer), this.f138432b, this.f138433c, this.f138434d));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WindowBoundaryMainObserver<T, B, V> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final ObservableSource f138439h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final Function f138440i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final int f138441j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final CompositeDisposable f138442k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Disposable f138443l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final AtomicReference f138444m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final List f138445n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final AtomicLong f138446o;

        WindowBoundaryMainObserver(Observer observer, ObservableSource observableSource, Function function, int i3) {
            super(observer, new MpscLinkedQueue());
            this.f138444m = new AtomicReference();
            AtomicLong atomicLong = new AtomicLong();
            this.f138446o = atomicLong;
            this.f138439h = observableSource;
            this.f138440i = function;
            this.f138441j = i3;
            this.f138442k = new CompositeDisposable();
            this.f138445n = new ArrayList();
            atomicLong.lazySet(1L);
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138443l, disposable)) {
                this.f138443l = disposable;
                this.f134997b.a(this);
                if (this.f134999d) {
                    return;
                }
                OperatorWindowBoundaryOpenObserver operatorWindowBoundaryOpenObserver = new OperatorWindowBoundaryOpenObserver(this);
                if (h.a(this.f138444m, null, operatorWindowBoundaryOpenObserver)) {
                    this.f138446o.getAndIncrement();
                    this.f138439h.b(operatorWindowBoundaryOpenObserver);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f134999d = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f134999d;
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (i()) {
                Iterator it = this.f138445n.iterator();
                while (it.hasNext()) {
                    ((UnicastSubject) it.next()).h(obj);
                }
                if (b(-1) == 0) {
                    return;
                }
            } else {
                this.f134998c.offer(NotificationLite.l(obj));
                if (!g()) {
                    return;
                }
            }
            n();
        }

        void l(OperatorWindowBoundaryCloseObserver operatorWindowBoundaryCloseObserver) {
            this.f138442k.c(operatorWindowBoundaryCloseObserver);
            this.f134998c.offer(new WindowOperation(operatorWindowBoundaryCloseObserver.f138436c, null));
            if (g()) {
                n();
            }
        }

        void m() {
            this.f138442k.dispose();
            DisposableHelper.a(this.f138444m);
        }

        void n() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.f134998c;
            Observer observer = this.f134997b;
            List list = this.f138445n;
            int iB = 1;
            while (true) {
                boolean z2 = this.f135000f;
                Object objPoll = mpscLinkedQueue.poll();
                boolean z3 = objPoll == null;
                if (z2 && z3) {
                    m();
                    Throwable th = this.f135001g;
                    if (th != null) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            ((UnicastSubject) it.next()).onError(th);
                        }
                    } else {
                        Iterator it2 = list.iterator();
                        while (it2.hasNext()) {
                            ((UnicastSubject) it2.next()).onComplete();
                        }
                    }
                    list.clear();
                    return;
                }
                if (z3) {
                    iB = b(-iB);
                    if (iB == 0) {
                        return;
                    }
                } else if (objPoll instanceof WindowOperation) {
                    WindowOperation windowOperation = (WindowOperation) objPoll;
                    UnicastSubject unicastSubject = windowOperation.f138447a;
                    if (unicastSubject != null) {
                        if (list.remove(unicastSubject)) {
                            windowOperation.f138447a.onComplete();
                            if (this.f138446o.decrementAndGet() == 0) {
                                m();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.f134999d) {
                        UnicastSubject unicastSubjectC = UnicastSubject.C(this.f138441j);
                        list.add(unicastSubjectC);
                        observer.h(unicastSubjectC);
                        try {
                            ObservableSource observableSource = (ObservableSource) ObjectHelper.d(this.f138440i.apply(windowOperation.f138448b), "The ObservableSource supplied is null");
                            OperatorWindowBoundaryCloseObserver operatorWindowBoundaryCloseObserver = new OperatorWindowBoundaryCloseObserver(this, unicastSubjectC);
                            if (this.f138442k.b(operatorWindowBoundaryCloseObserver)) {
                                this.f138446o.getAndIncrement();
                                observableSource.b(operatorWindowBoundaryCloseObserver);
                            }
                        } catch (Throwable th2) {
                            Exceptions.b(th2);
                            this.f134999d = true;
                            observer.onError(th2);
                        }
                    }
                } else {
                    Iterator it3 = list.iterator();
                    while (it3.hasNext()) {
                        ((UnicastSubject) it3.next()).h(NotificationLite.i(objPoll));
                    }
                }
            }
        }

        void o(Throwable th) {
            this.f138443l.dispose();
            this.f138442k.dispose();
            onError(th);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f135000f) {
                return;
            }
            this.f135000f = true;
            if (g()) {
                n();
            }
            if (this.f138446o.decrementAndGet() == 0) {
                this.f138442k.dispose();
            }
            this.f134997b.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f135000f) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f135001g = th;
            this.f135000f = true;
            if (g()) {
                n();
            }
            if (this.f138446o.decrementAndGet() == 0) {
                this.f138442k.dispose();
            }
            this.f134997b.onError(th);
        }

        void q(Object obj) {
            this.f134998c.offer(new WindowOperation(null, obj));
            if (g()) {
                n();
            }
        }

        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        public void f(Observer observer, Object obj) {
        }
    }
}
