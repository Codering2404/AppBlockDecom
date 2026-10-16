package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractObservableWithUpstream<TLeft, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ObservableSource f137785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f137786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Function f137787d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final BiFunction f137788f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class GroupJoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Disposable, JoinSupport {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        static final Integer f137789o = 1;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        static final Integer f137790p = 2;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        static final Integer f137791q = 3;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        static final Integer f137792r = 4;
        private static final long serialVersionUID = -6071216598687999801L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137793a;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final Function f137799h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final Function f137800i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final BiFunction f137801j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f137803l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f137804m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        volatile boolean f137805n;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final CompositeDisposable f137795c = new CompositeDisposable();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SpscLinkedArrayQueue f137794b = new SpscLinkedArrayQueue(Observable.d());

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Map f137796d = new LinkedHashMap();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Map f137797f = new LinkedHashMap();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicReference f137798g = new AtomicReference();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final AtomicInteger f137802k = new AtomicInteger(2);

        GroupJoinDisposable(Observer observer, Function function, Function function2, BiFunction biFunction) {
            this.f137793a = observer;
            this.f137799h = function;
            this.f137800i = function2;
            this.f137801j = biFunction;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void a(boolean z2, Object obj) {
            synchronized (this) {
                try {
                    this.f137794b.p(z2 ? f137789o : f137790p, obj);
                } catch (Throwable th) {
                    throw th;
                }
            }
            h();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void b(Throwable th) {
            if (!ExceptionHelper.a(this.f137798g, th)) {
                RxJavaPlugins.s(th);
            } else {
                this.f137802k.decrementAndGet();
                h();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void c(Throwable th) {
            if (ExceptionHelper.a(this.f137798g, th)) {
                h();
            } else {
                RxJavaPlugins.s(th);
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void d(boolean z2, LeftRightEndObserver leftRightEndObserver) {
            synchronized (this) {
                try {
                    this.f137794b.p(z2 ? f137791q : f137792r, leftRightEndObserver);
                } catch (Throwable th) {
                    throw th;
                }
            }
            h();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f137805n) {
                return;
            }
            this.f137805n = true;
            g();
            if (getAndIncrement() == 0) {
                this.f137794b.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137805n;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void f(LeftRightObserver leftRightObserver) {
            this.f137795c.c(leftRightObserver);
            this.f137802k.decrementAndGet();
            h();
        }

        void g() {
            this.f137795c.dispose();
        }

        void h() {
            if (getAndIncrement() != 0) {
                return;
            }
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f137794b;
            Observer observer = this.f137793a;
            int iAddAndGet = 1;
            while (!this.f137805n) {
                if (((Throwable) this.f137798g.get()) != null) {
                    spscLinkedArrayQueue.clear();
                    g();
                    i(observer);
                    return;
                }
                boolean z2 = this.f137802k.get() == 0;
                Integer num = (Integer) spscLinkedArrayQueue.poll();
                boolean z3 = num == null;
                if (z2 && z3) {
                    Iterator it = this.f137796d.values().iterator();
                    while (it.hasNext()) {
                        ((UnicastSubject) it.next()).onComplete();
                    }
                    this.f137796d.clear();
                    this.f137797f.clear();
                    this.f137795c.dispose();
                    observer.onComplete();
                    return;
                }
                if (z3) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    Object objPoll = spscLinkedArrayQueue.poll();
                    if (num == f137789o) {
                        UnicastSubject unicastSubjectB = UnicastSubject.B();
                        int i3 = this.f137803l;
                        this.f137803l = i3 + 1;
                        this.f137796d.put(Integer.valueOf(i3), unicastSubjectB);
                        try {
                            ObservableSource observableSource = (ObservableSource) ObjectHelper.d(this.f137799h.apply(objPoll), "The leftEnd returned a null ObservableSource");
                            LeftRightEndObserver leftRightEndObserver = new LeftRightEndObserver(this, true, i3);
                            this.f137795c.b(leftRightEndObserver);
                            observableSource.b(leftRightEndObserver);
                            if (((Throwable) this.f137798g.get()) != null) {
                                spscLinkedArrayQueue.clear();
                                g();
                                i(observer);
                                return;
                            } else {
                                try {
                                    observer.h(ObjectHelper.d(this.f137801j.apply(objPoll, unicastSubjectB), "The resultSelector returned a null value"));
                                    Iterator it2 = this.f137797f.values().iterator();
                                    while (it2.hasNext()) {
                                        unicastSubjectB.h(it2.next());
                                    }
                                } catch (Throwable th) {
                                    j(th, observer, spscLinkedArrayQueue);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            j(th2, observer, spscLinkedArrayQueue);
                            return;
                        }
                    } else if (num == f137790p) {
                        int i4 = this.f137804m;
                        this.f137804m = i4 + 1;
                        this.f137797f.put(Integer.valueOf(i4), objPoll);
                        try {
                            ObservableSource observableSource2 = (ObservableSource) ObjectHelper.d(this.f137800i.apply(objPoll), "The rightEnd returned a null ObservableSource");
                            LeftRightEndObserver leftRightEndObserver2 = new LeftRightEndObserver(this, false, i4);
                            this.f137795c.b(leftRightEndObserver2);
                            observableSource2.b(leftRightEndObserver2);
                            if (((Throwable) this.f137798g.get()) != null) {
                                spscLinkedArrayQueue.clear();
                                g();
                                i(observer);
                                return;
                            } else {
                                Iterator it3 = this.f137796d.values().iterator();
                                while (it3.hasNext()) {
                                    ((UnicastSubject) it3.next()).h(objPoll);
                                }
                            }
                        } catch (Throwable th3) {
                            j(th3, observer, spscLinkedArrayQueue);
                            return;
                        }
                    } else if (num == f137791q) {
                        LeftRightEndObserver leftRightEndObserver3 = (LeftRightEndObserver) objPoll;
                        UnicastSubject unicastSubject = (UnicastSubject) this.f137796d.remove(Integer.valueOf(leftRightEndObserver3.f137808c));
                        this.f137795c.a(leftRightEndObserver3);
                        if (unicastSubject != null) {
                            unicastSubject.onComplete();
                        }
                    } else if (num == f137792r) {
                        LeftRightEndObserver leftRightEndObserver4 = (LeftRightEndObserver) objPoll;
                        this.f137797f.remove(Integer.valueOf(leftRightEndObserver4.f137808c));
                        this.f137795c.a(leftRightEndObserver4);
                    }
                }
            }
            spscLinkedArrayQueue.clear();
        }

        void i(Observer observer) {
            Throwable thB = ExceptionHelper.b(this.f137798g);
            Iterator it = this.f137796d.values().iterator();
            while (it.hasNext()) {
                ((UnicastSubject) it.next()).onError(thB);
            }
            this.f137796d.clear();
            this.f137797f.clear();
            observer.onError(thB);
        }

        void j(Throwable th, Observer observer, SpscLinkedArrayQueue spscLinkedArrayQueue) {
            Exceptions.b(th);
            ExceptionHelper.a(this.f137798g, th);
            spscLinkedArrayQueue.clear();
            g();
            i(observer);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface JoinSupport {
        void a(boolean z2, Object obj);

        void b(Throwable th);

        void c(Throwable th);

        void d(boolean z2, LeftRightEndObserver leftRightEndObserver);

        void f(LeftRightObserver leftRightObserver);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class LeftRightEndObserver extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        private static final long serialVersionUID = 1883890389173668373L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final JoinSupport f137806a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f137807b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f137808c;

        LeftRightEndObserver(JoinSupport joinSupport, boolean z2, int i3) {
            this.f137806a = joinSupport;
            this.f137807b = z2;
            this.f137808c = i3;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            DisposableHelper.g(this, disposable);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(get());
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (DisposableHelper.a(this)) {
                this.f137806a.d(this.f137807b, this);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137806a.d(this.f137807b, this);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f137806a.c(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class LeftRightObserver extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        private static final long serialVersionUID = 1883890389173668373L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final JoinSupport f137809a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f137810b;

        LeftRightObserver(JoinSupport joinSupport, boolean z2) {
            this.f137809a = joinSupport;
            this.f137810b = z2;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            DisposableHelper.g(this, disposable);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(get());
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f137809a.a(this.f137810b, obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137809a.f(this);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f137809a.b(th);
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        GroupJoinDisposable groupJoinDisposable = new GroupJoinDisposable(observer, this.f137786c, this.f137787d, this.f137788f);
        observer.a(groupJoinDisposable);
        LeftRightObserver leftRightObserver = new LeftRightObserver(groupJoinDisposable, true);
        groupJoinDisposable.f137795c.b(leftRightObserver);
        LeftRightObserver leftRightObserver2 = new LeftRightObserver(groupJoinDisposable, false);
        groupJoinDisposable.f137795c.b(leftRightObserver2);
        this.f137267a.b(leftRightObserver);
        this.f137785b.b(leftRightObserver2);
    }
}
