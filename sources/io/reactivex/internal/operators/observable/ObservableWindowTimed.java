package io.reactivex.internal.operators.observable;

import androidx.compose.animation.core.h;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.subjects.UnicastSubject;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableWindowTimed<T> extends AbstractObservableWithUpstream<T, Observable<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f138466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f138467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f138468d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Scheduler f138469f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final long f138470g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final int f138471h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final boolean f138472i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WindowExactBoundedObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final long f138473h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final TimeUnit f138474i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final Scheduler f138475j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final int f138476k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final boolean f138477l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final long f138478m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final Scheduler.Worker f138479n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        long f138480o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        long f138481p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        Disposable f138482q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        UnicastSubject f138483r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        volatile boolean f138484s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final AtomicReference f138485t;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class ConsumerIndexHolder implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final long f138486a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final WindowExactBoundedObserver f138487b;

            ConsumerIndexHolder(long j3, WindowExactBoundedObserver windowExactBoundedObserver) {
                this.f138486a = j3;
                this.f138487b = windowExactBoundedObserver;
            }

            @Override // java.lang.Runnable
            public void run() {
                WindowExactBoundedObserver windowExactBoundedObserver = this.f138487b;
                if (((QueueDrainObserver) windowExactBoundedObserver).f134999d) {
                    windowExactBoundedObserver.f138484s = true;
                    windowExactBoundedObserver.n();
                } else {
                    ((QueueDrainObserver) windowExactBoundedObserver).f134998c.offer(this);
                }
                if (windowExactBoundedObserver.g()) {
                    windowExactBoundedObserver.o();
                }
            }
        }

        WindowExactBoundedObserver(Observer observer, long j3, TimeUnit timeUnit, Scheduler scheduler, int i3, long j4, boolean z2) {
            super(observer, new MpscLinkedQueue());
            this.f138485t = new AtomicReference();
            this.f138473h = j3;
            this.f138474i = timeUnit;
            this.f138475j = scheduler;
            this.f138476k = i3;
            this.f138478m = j4;
            this.f138477l = z2;
            if (z2) {
                this.f138479n = scheduler.b();
            } else {
                this.f138479n = null;
            }
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            Disposable disposableG;
            if (DisposableHelper.i(this.f138482q, disposable)) {
                this.f138482q = disposable;
                Observer observer = this.f134997b;
                observer.a(this);
                if (this.f134999d) {
                    return;
                }
                UnicastSubject unicastSubjectC = UnicastSubject.C(this.f138476k);
                this.f138483r = unicastSubjectC;
                observer.h(unicastSubjectC);
                ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.f138481p, this);
                if (this.f138477l) {
                    Scheduler.Worker worker = this.f138479n;
                    long j3 = this.f138473h;
                    disposableG = worker.d(consumerIndexHolder, j3, j3, this.f138474i);
                } else {
                    Scheduler scheduler = this.f138475j;
                    long j4 = this.f138473h;
                    disposableG = scheduler.g(consumerIndexHolder, j4, j4, this.f138474i);
                }
                DisposableHelper.c(this.f138485t, disposableG);
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
            if (this.f138484s) {
                return;
            }
            if (i()) {
                UnicastSubject unicastSubject = this.f138483r;
                unicastSubject.h(obj);
                long j3 = this.f138480o + 1;
                if (j3 >= this.f138478m) {
                    this.f138481p++;
                    this.f138480o = 0L;
                    unicastSubject.onComplete();
                    UnicastSubject unicastSubjectC = UnicastSubject.C(this.f138476k);
                    this.f138483r = unicastSubjectC;
                    this.f134997b.h(unicastSubjectC);
                    if (this.f138477l) {
                        ((Disposable) this.f138485t.get()).dispose();
                        Scheduler.Worker worker = this.f138479n;
                        ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.f138481p, this);
                        long j4 = this.f138473h;
                        DisposableHelper.c(this.f138485t, worker.d(consumerIndexHolder, j4, j4, this.f138474i));
                    }
                } else {
                    this.f138480o = j3;
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
            o();
        }

        void n() {
            DisposableHelper.a(this.f138485t);
            Scheduler.Worker worker = this.f138479n;
            if (worker != null) {
                worker.dispose();
            }
        }

        void o() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.f134998c;
            Observer observer = this.f134997b;
            UnicastSubject unicastSubjectC = this.f138483r;
            int iB = 1;
            while (!this.f138484s) {
                boolean z2 = this.f135000f;
                Object objPoll = mpscLinkedQueue.poll();
                boolean z3 = objPoll == null;
                boolean z4 = objPoll instanceof ConsumerIndexHolder;
                if (z2 && (z3 || z4)) {
                    this.f138483r = null;
                    mpscLinkedQueue.clear();
                    n();
                    Throwable th = this.f135001g;
                    if (th != null) {
                        unicastSubjectC.onError(th);
                        return;
                    } else {
                        unicastSubjectC.onComplete();
                        return;
                    }
                }
                if (z3) {
                    iB = b(-iB);
                    if (iB == 0) {
                        return;
                    }
                } else if (z4) {
                    ConsumerIndexHolder consumerIndexHolder = (ConsumerIndexHolder) objPoll;
                    if (this.f138477l || this.f138481p == consumerIndexHolder.f138486a) {
                        unicastSubjectC.onComplete();
                        this.f138480o = 0L;
                        unicastSubjectC = UnicastSubject.C(this.f138476k);
                        this.f138483r = unicastSubjectC;
                        observer.h(unicastSubjectC);
                    }
                } else {
                    unicastSubjectC.h(NotificationLite.i(objPoll));
                    long j3 = this.f138480o + 1;
                    if (j3 >= this.f138478m) {
                        this.f138481p++;
                        this.f138480o = 0L;
                        unicastSubjectC.onComplete();
                        unicastSubjectC = UnicastSubject.C(this.f138476k);
                        this.f138483r = unicastSubjectC;
                        this.f134997b.h(unicastSubjectC);
                        if (this.f138477l) {
                            Disposable disposable = (Disposable) this.f138485t.get();
                            disposable.dispose();
                            Scheduler.Worker worker = this.f138479n;
                            ConsumerIndexHolder consumerIndexHolder2 = new ConsumerIndexHolder(this.f138481p, this);
                            long j4 = this.f138473h;
                            Disposable disposableD = worker.d(consumerIndexHolder2, j4, j4, this.f138474i);
                            if (!h.a(this.f138485t, disposable, disposableD)) {
                                disposableD.dispose();
                            }
                        }
                    } else {
                        this.f138480o = j3;
                    }
                }
            }
            this.f138482q.dispose();
            mpscLinkedQueue.clear();
            n();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f135000f = true;
            if (g()) {
                o();
            }
            this.f134997b.onComplete();
            n();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f135001g = th;
            this.f135000f = true;
            if (g()) {
                o();
            }
            this.f134997b.onError(th);
            n();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WindowExactUnboundedObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Observer<T>, Disposable, Runnable {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        static final Object f138488p = new Object();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final long f138489h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final TimeUnit f138490i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final Scheduler f138491j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final int f138492k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Disposable f138493l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        UnicastSubject f138494m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final AtomicReference f138495n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        volatile boolean f138496o;

        WindowExactUnboundedObserver(Observer observer, long j3, TimeUnit timeUnit, Scheduler scheduler, int i3) {
            super(observer, new MpscLinkedQueue());
            this.f138495n = new AtomicReference();
            this.f138489h = j3;
            this.f138490i = timeUnit;
            this.f138491j = scheduler;
            this.f138492k = i3;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138493l, disposable)) {
                this.f138493l = disposable;
                this.f138494m = UnicastSubject.C(this.f138492k);
                Observer observer = this.f134997b;
                observer.a(this);
                observer.h(this.f138494m);
                if (!this.f134999d) {
                    Scheduler scheduler = this.f138491j;
                    long j3 = this.f138489h;
                    DisposableHelper.c(this.f138495n, scheduler.g(this, j3, j3, this.f138490i));
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
            if (this.f138496o) {
                return;
            }
            if (i()) {
                this.f138494m.h(obj);
                if (b(-1) == 0) {
                    return;
                }
            } else {
                this.f134998c.offer(NotificationLite.l(obj));
                if (!g()) {
                    return;
                }
            }
            m();
        }

        void l() {
            DisposableHelper.a(this.f138495n);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
        
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
        
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        
            r7.f138494m = null;
            r0.clear();
            l();
            r0 = r7.f135001g;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
        
            if (r0 == null) goto L12;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void m() {
            /*
                r7 = this;
                io.reactivex.internal.fuseable.SimplePlainQueue r0 = r7.f134998c
                io.reactivex.internal.queue.MpscLinkedQueue r0 = (io.reactivex.internal.queue.MpscLinkedQueue) r0
                io.reactivex.Observer r1 = r7.f134997b
                io.reactivex.subjects.UnicastSubject r2 = r7.f138494m
                r3 = 1
            L9:
                boolean r4 = r7.f138496o
                boolean r5 = r7.f135000f
                java.lang.Object r6 = r0.poll()
                if (r5 == 0) goto L2e
                if (r6 == 0) goto L19
                java.lang.Object r5 = io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactUnboundedObserver.f138488p
                if (r6 != r5) goto L2e
            L19:
                r1 = 0
                r7.f138494m = r1
                r0.clear()
                r7.l()
                java.lang.Throwable r0 = r7.f135001g
                if (r0 == 0) goto L2a
                r2.onError(r0)
                return
            L2a:
                r2.onComplete()
                return
            L2e:
                if (r6 != 0) goto L38
                int r3 = -r3
                int r3 = r7.b(r3)
                if (r3 != 0) goto L9
                return
            L38:
                java.lang.Object r5 = io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactUnboundedObserver.f138488p
                if (r6 != r5) goto L53
                r2.onComplete()
                if (r4 != 0) goto L4d
                int r2 = r7.f138492k
                io.reactivex.subjects.UnicastSubject r2 = io.reactivex.subjects.UnicastSubject.C(r2)
                r7.f138494m = r2
                r1.h(r2)
                goto L9
            L4d:
                io.reactivex.disposables.Disposable r4 = r7.f138493l
                r4.dispose()
                goto L9
            L53:
                java.lang.Object r4 = io.reactivex.internal.util.NotificationLite.i(r6)
                r2.h(r4)
                goto L9
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableWindowTimed.WindowExactUnboundedObserver.m():void");
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f135000f = true;
            if (g()) {
                m();
            }
            l();
            this.f134997b.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f135001g = th;
            this.f135000f = true;
            if (g()) {
                m();
            }
            l();
            this.f134997b.onError(th);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f134999d) {
                this.f138496o = true;
                l();
            }
            this.f134998c.offer(f138488p);
            if (g()) {
                m();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WindowSkipObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable, Runnable {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final long f138497h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final long f138498i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final TimeUnit f138499j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final Scheduler.Worker f138500k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final int f138501l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final List f138502m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        Disposable f138503n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        volatile boolean f138504o;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class CompletionTask implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final UnicastSubject f138505a;

            CompletionTask(UnicastSubject unicastSubject) {
                this.f138505a = unicastSubject;
            }

            @Override // java.lang.Runnable
            public void run() {
                WindowSkipObserver.this.l(this.f138505a);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class SubjectWork<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final UnicastSubject f138507a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final boolean f138508b;

            SubjectWork(UnicastSubject unicastSubject, boolean z2) {
                this.f138507a = unicastSubject;
                this.f138508b = z2;
            }
        }

        WindowSkipObserver(Observer observer, long j3, long j4, TimeUnit timeUnit, Scheduler.Worker worker, int i3) {
            super(observer, new MpscLinkedQueue());
            this.f138497h = j3;
            this.f138498i = j4;
            this.f138499j = timeUnit;
            this.f138500k = worker;
            this.f138501l = i3;
            this.f138502m = new LinkedList();
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138503n, disposable)) {
                this.f138503n = disposable;
                this.f134997b.a(this);
                if (this.f134999d) {
                    return;
                }
                UnicastSubject unicastSubjectC = UnicastSubject.C(this.f138501l);
                this.f138502m.add(unicastSubjectC);
                this.f134997b.h(unicastSubjectC);
                this.f138500k.c(new CompletionTask(unicastSubjectC), this.f138497h, this.f138499j);
                Scheduler.Worker worker = this.f138500k;
                long j3 = this.f138498i;
                worker.d(this, j3, j3, this.f138499j);
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
                Iterator it = this.f138502m.iterator();
                while (it.hasNext()) {
                    ((UnicastSubject) it.next()).h(obj);
                }
                if (b(-1) == 0) {
                    return;
                }
            } else {
                this.f134998c.offer(obj);
                if (!g()) {
                    return;
                }
            }
            n();
        }

        void l(UnicastSubject unicastSubject) {
            this.f134998c.offer(new SubjectWork(unicastSubject, false));
            if (g()) {
                n();
            }
        }

        void m() {
            this.f138500k.dispose();
        }

        void n() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.f134998c;
            Observer observer = this.f134997b;
            List list = this.f138502m;
            int iB = 1;
            while (!this.f138504o) {
                boolean z2 = this.f135000f;
                Object objPoll = mpscLinkedQueue.poll();
                boolean z3 = objPoll == null;
                boolean z4 = objPoll instanceof SubjectWork;
                if (z2 && (z3 || z4)) {
                    mpscLinkedQueue.clear();
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
                    m();
                    list.clear();
                    return;
                }
                if (z3) {
                    iB = b(-iB);
                    if (iB == 0) {
                        return;
                    }
                } else if (z4) {
                    SubjectWork subjectWork = (SubjectWork) objPoll;
                    if (!subjectWork.f138508b) {
                        list.remove(subjectWork.f138507a);
                        subjectWork.f138507a.onComplete();
                        if (list.isEmpty() && this.f134999d) {
                            this.f138504o = true;
                        }
                    } else if (!this.f134999d) {
                        UnicastSubject unicastSubjectC = UnicastSubject.C(this.f138501l);
                        list.add(unicastSubjectC);
                        observer.h(unicastSubjectC);
                        this.f138500k.c(new CompletionTask(unicastSubjectC), this.f138497h, this.f138499j);
                    }
                } else {
                    Iterator it3 = list.iterator();
                    while (it3.hasNext()) {
                        ((UnicastSubject) it3.next()).h(objPoll);
                    }
                }
            }
            this.f138503n.dispose();
            m();
            mpscLinkedQueue.clear();
            list.clear();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f135000f = true;
            if (g()) {
                n();
            }
            this.f134997b.onComplete();
            m();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f135001g = th;
            this.f135000f = true;
            if (g()) {
                n();
            }
            this.f134997b.onError(th);
            m();
        }

        @Override // java.lang.Runnable
        public void run() {
            SubjectWork subjectWork = new SubjectWork(UnicastSubject.C(this.f138501l), true);
            if (!this.f134999d) {
                this.f134998c.offer(subjectWork);
            }
            if (g()) {
                n();
            }
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        long j3 = this.f138466b;
        long j4 = this.f138467c;
        if (j3 != j4) {
            this.f137267a.b(new WindowSkipObserver(serializedObserver, j3, j4, this.f138468d, this.f138469f.b(), this.f138471h));
            return;
        }
        long j5 = this.f138470g;
        if (j5 == Long.MAX_VALUE) {
            this.f137267a.b(new WindowExactUnboundedObserver(serializedObserver, this.f138466b, this.f138468d, this.f138469f, this.f138471h));
        } else {
            this.f137267a.b(new WindowExactBoundedObserver(serializedObserver, j3, this.f138468d, this.f138469f, this.f138471h, j5, this.f138472i));
        }
    }
}
