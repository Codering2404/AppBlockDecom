package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableObserveOn<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Scheduler f137937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f137938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f137939d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Scheduler.Worker f137941b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f137942c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f137943d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        SimpleQueue f137944f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Disposable f137945g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Throwable f137946h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f137947i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile boolean f137948j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f137949k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        boolean f137950l;

        ObserveOnObserver(Observer observer, Scheduler.Worker worker, boolean z2, int i3) {
            this.f137940a = observer;
            this.f137941b = worker;
            this.f137942c = z2;
            this.f137943d = i3;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137945g, disposable)) {
                this.f137945g = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int iL = queueDisposable.l(7);
                    if (iL == 1) {
                        this.f137949k = iL;
                        this.f137944f = queueDisposable;
                        this.f137947i = true;
                        this.f137940a.a(this);
                        i();
                        return;
                    }
                    if (iL == 2) {
                        this.f137949k = iL;
                        this.f137944f = queueDisposable;
                        this.f137940a.a(this);
                        return;
                    }
                }
                this.f137944f = new SpscLinkedArrayQueue(this.f137943d);
                this.f137940a.a(this);
            }
        }

        boolean b(boolean z2, boolean z3, Observer observer) {
            if (this.f137948j) {
                this.f137944f.clear();
                return true;
            }
            if (!z2) {
                return false;
            }
            Throwable th = this.f137946h;
            if (this.f137942c) {
                if (!z3) {
                    return false;
                }
                this.f137948j = true;
                if (th != null) {
                    observer.onError(th);
                } else {
                    observer.onComplete();
                }
                this.f137941b.dispose();
                return true;
            }
            if (th != null) {
                this.f137948j = true;
                this.f137944f.clear();
                observer.onError(th);
                this.f137941b.dispose();
                return true;
            }
            if (!z3) {
                return false;
            }
            this.f137948j = true;
            observer.onComplete();
            this.f137941b.dispose();
            return true;
        }

        void c() {
            int iAddAndGet = 1;
            while (!this.f137948j) {
                boolean z2 = this.f137947i;
                Throwable th = this.f137946h;
                if (!this.f137942c && z2 && th != null) {
                    this.f137948j = true;
                    this.f137940a.onError(this.f137946h);
                    this.f137941b.dispose();
                    return;
                }
                this.f137940a.h(null);
                if (z2) {
                    this.f137948j = true;
                    Throwable th2 = this.f137946h;
                    if (th2 != null) {
                        this.f137940a.onError(th2);
                    } else {
                        this.f137940a.onComplete();
                    }
                    this.f137941b.dispose();
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.f137944f.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f137948j) {
                return;
            }
            this.f137948j = true;
            this.f137945g.dispose();
            this.f137941b.dispose();
            if (getAndIncrement() == 0) {
                this.f137944f.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137948j;
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
        
            r3 = addAndGet(-r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
        
            if (r3 != 0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void g() {
            /*
                r7 = this;
                io.reactivex.internal.fuseable.SimpleQueue r0 = r7.f137944f
                io.reactivex.Observer r1 = r7.f137940a
                r2 = 1
                r3 = r2
            L6:
                boolean r4 = r7.f137947i
                boolean r5 = r0.isEmpty()
                boolean r4 = r7.b(r4, r5, r1)
                if (r4 == 0) goto L13
                goto L2e
            L13:
                boolean r4 = r7.f137947i
                java.lang.Object r5 = r0.poll()     // Catch: java.lang.Throwable -> L33
                if (r5 != 0) goto L1d
                r6 = r2
                goto L1e
            L1d:
                r6 = 0
            L1e:
                boolean r4 = r7.b(r4, r6, r1)
                if (r4 == 0) goto L25
                goto L2e
            L25:
                if (r6 == 0) goto L2f
                int r3 = -r3
                int r3 = r7.addAndGet(r3)
                if (r3 != 0) goto L6
            L2e:
                return
            L2f:
                r1.h(r5)
                goto L13
            L33:
                r3 = move-exception
                io.reactivex.exceptions.Exceptions.b(r3)
                r7.f137948j = r2
                io.reactivex.disposables.Disposable r2 = r7.f137945g
                r2.dispose()
                r0.clear()
                r1.onError(r3)
                io.reactivex.Scheduler$Worker r0 = r7.f137941b
                r0.dispose()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableObserveOn.ObserveOnObserver.g():void");
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f137947i) {
                return;
            }
            if (this.f137949k != 2) {
                this.f137944f.offer(obj);
            }
            i();
        }

        void i() {
            if (getAndIncrement() == 0) {
                this.f137941b.b(this);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.f137944f.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int l(int i3) {
            if ((i3 & 2) == 0) {
                return 0;
            }
            this.f137950l = true;
            return 2;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f137947i) {
                return;
            }
            this.f137947i = true;
            i();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f137947i) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f137946h = th;
            this.f137947i = true;
            i();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            return this.f137944f.poll();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f137950l) {
                c();
            } else {
                g();
            }
        }
    }

    public ObservableObserveOn(ObservableSource observableSource, Scheduler scheduler, boolean z2, int i3) {
        super(observableSource);
        this.f137937b = scheduler;
        this.f137938c = z2;
        this.f137939d = i3;
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        Scheduler scheduler = this.f137937b;
        if (scheduler instanceof TrampolineScheduler) {
            this.f137267a.b(observer);
        } else {
            this.f137267a.b(new ObserveOnObserver(observer, scheduler.b(), this.f137938c, this.f137939d));
        }
    }
}
