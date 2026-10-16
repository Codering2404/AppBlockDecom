package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractObservableWithUpstream<TLeft, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ObservableSource f137861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f137862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Function f137863d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final BiFunction f137864f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class JoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Disposable, ObservableGroupJoin.JoinSupport {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        static final Integer f137865o = 1;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        static final Integer f137866p = 2;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        static final Integer f137867q = 3;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        static final Integer f137868r = 4;
        private static final long serialVersionUID = -6071216598687999801L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137869a;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final Function f137875h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final Function f137876i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final BiFunction f137877j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f137879l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f137880m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        volatile boolean f137881n;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final CompositeDisposable f137871c = new CompositeDisposable();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SpscLinkedArrayQueue f137870b = new SpscLinkedArrayQueue(Observable.d());

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Map f137872d = new LinkedHashMap();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Map f137873f = new LinkedHashMap();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicReference f137874g = new AtomicReference();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final AtomicInteger f137878k = new AtomicInteger(2);

        JoinDisposable(Observer observer, Function function, Function function2, BiFunction biFunction) {
            this.f137869a = observer;
            this.f137875h = function;
            this.f137876i = function2;
            this.f137877j = biFunction;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void a(boolean z2, Object obj) {
            synchronized (this) {
                try {
                    this.f137870b.p(z2 ? f137865o : f137866p, obj);
                } catch (Throwable th) {
                    throw th;
                }
            }
            h();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void b(Throwable th) {
            if (!ExceptionHelper.a(this.f137874g, th)) {
                RxJavaPlugins.s(th);
            } else {
                this.f137878k.decrementAndGet();
                h();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void c(Throwable th) {
            if (ExceptionHelper.a(this.f137874g, th)) {
                h();
            } else {
                RxJavaPlugins.s(th);
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void d(boolean z2, ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver) {
            synchronized (this) {
                try {
                    this.f137870b.p(z2 ? f137867q : f137868r, leftRightEndObserver);
                } catch (Throwable th) {
                    throw th;
                }
            }
            h();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f137881n) {
                return;
            }
            this.f137881n = true;
            g();
            if (getAndIncrement() == 0) {
                this.f137870b.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137881n;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.JoinSupport
        public void f(ObservableGroupJoin.LeftRightObserver leftRightObserver) {
            this.f137871c.c(leftRightObserver);
            this.f137878k.decrementAndGet();
            h();
        }

        void g() {
            this.f137871c.dispose();
        }

        void h() {
            if (getAndIncrement() != 0) {
                return;
            }
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f137870b;
            Observer observer = this.f137869a;
            int iAddAndGet = 1;
            while (!this.f137881n) {
                if (((Throwable) this.f137874g.get()) != null) {
                    spscLinkedArrayQueue.clear();
                    g();
                    i(observer);
                    return;
                }
                boolean z2 = this.f137878k.get() == 0;
                Integer num = (Integer) spscLinkedArrayQueue.poll();
                boolean z3 = num == null;
                if (z2 && z3) {
                    this.f137872d.clear();
                    this.f137873f.clear();
                    this.f137871c.dispose();
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
                    if (num == f137865o) {
                        int i3 = this.f137879l;
                        this.f137879l = i3 + 1;
                        this.f137872d.put(Integer.valueOf(i3), objPoll);
                        try {
                            ObservableSource observableSource = (ObservableSource) ObjectHelper.d(this.f137875h.apply(objPoll), "The leftEnd returned a null ObservableSource");
                            ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver = new ObservableGroupJoin.LeftRightEndObserver(this, true, i3);
                            this.f137871c.b(leftRightEndObserver);
                            observableSource.b(leftRightEndObserver);
                            if (((Throwable) this.f137874g.get()) != null) {
                                spscLinkedArrayQueue.clear();
                                g();
                                i(observer);
                                return;
                            } else {
                                Iterator it = this.f137873f.values().iterator();
                                while (it.hasNext()) {
                                    try {
                                        observer.h(ObjectHelper.d(this.f137877j.apply(objPoll, it.next()), "The resultSelector returned a null value"));
                                    } catch (Throwable th) {
                                        j(th, observer, spscLinkedArrayQueue);
                                        return;
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            j(th2, observer, spscLinkedArrayQueue);
                            return;
                        }
                    } else if (num == f137866p) {
                        int i4 = this.f137880m;
                        this.f137880m = i4 + 1;
                        this.f137873f.put(Integer.valueOf(i4), objPoll);
                        try {
                            ObservableSource observableSource2 = (ObservableSource) ObjectHelper.d(this.f137876i.apply(objPoll), "The rightEnd returned a null ObservableSource");
                            ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver2 = new ObservableGroupJoin.LeftRightEndObserver(this, false, i4);
                            this.f137871c.b(leftRightEndObserver2);
                            observableSource2.b(leftRightEndObserver2);
                            if (((Throwable) this.f137874g.get()) != null) {
                                spscLinkedArrayQueue.clear();
                                g();
                                i(observer);
                                return;
                            } else {
                                Iterator it2 = this.f137872d.values().iterator();
                                while (it2.hasNext()) {
                                    try {
                                        observer.h(ObjectHelper.d(this.f137877j.apply(it2.next(), objPoll), "The resultSelector returned a null value"));
                                    } catch (Throwable th3) {
                                        j(th3, observer, spscLinkedArrayQueue);
                                        return;
                                    }
                                }
                            }
                        } catch (Throwable th4) {
                            j(th4, observer, spscLinkedArrayQueue);
                            return;
                        }
                    } else if (num == f137867q) {
                        ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver3 = (ObservableGroupJoin.LeftRightEndObserver) objPoll;
                        this.f137872d.remove(Integer.valueOf(leftRightEndObserver3.f137808c));
                        this.f137871c.a(leftRightEndObserver3);
                    } else {
                        ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver4 = (ObservableGroupJoin.LeftRightEndObserver) objPoll;
                        this.f137873f.remove(Integer.valueOf(leftRightEndObserver4.f137808c));
                        this.f137871c.a(leftRightEndObserver4);
                    }
                }
            }
            spscLinkedArrayQueue.clear();
        }

        void i(Observer observer) {
            Throwable thB = ExceptionHelper.b(this.f137874g);
            this.f137872d.clear();
            this.f137873f.clear();
            observer.onError(thB);
        }

        void j(Throwable th, Observer observer, SpscLinkedArrayQueue spscLinkedArrayQueue) {
            Exceptions.b(th);
            ExceptionHelper.a(this.f137874g, th);
            spscLinkedArrayQueue.clear();
            g();
            i(observer);
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        JoinDisposable joinDisposable = new JoinDisposable(observer, this.f137862c, this.f137863d, this.f137864f);
        observer.a(joinDisposable);
        ObservableGroupJoin.LeftRightObserver leftRightObserver = new ObservableGroupJoin.LeftRightObserver(joinDisposable, true);
        joinDisposable.f137871c.b(leftRightObserver);
        ObservableGroupJoin.LeftRightObserver leftRightObserver2 = new ObservableGroupJoin.LeftRightObserver(joinDisposable, false);
        joinDisposable.f137871c.b(leftRightObserver2);
        this.f137267a.b(leftRightObserver);
        this.f137861b.b(leftRightObserver2);
    }
}
