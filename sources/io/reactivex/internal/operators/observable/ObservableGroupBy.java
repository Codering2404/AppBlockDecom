package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.observables.GroupedObservable;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableGroupBy<T, K, V> extends AbstractObservableWithUpstream<T, GroupedObservable<K, V>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f137762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f137763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f137764d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f137765f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class GroupByObserver<T, K, V> extends AtomicInteger implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        static final Object f137766j = new Object();
        private static final long serialVersionUID = -3688291656102519502L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137767a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f137768b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Function f137769c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f137770d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final boolean f137771f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Disposable f137773h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final AtomicBoolean f137774i = new AtomicBoolean();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Map f137772g = new ConcurrentHashMap();

        public GroupByObserver(Observer observer, Function function, Function function2, int i3, boolean z2) {
            this.f137767a = observer;
            this.f137768b = function;
            this.f137769c = function2;
            this.f137770d = i3;
            this.f137771f = z2;
            lazySet(1);
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137773h, disposable)) {
                this.f137773h = disposable;
                this.f137767a.a(this);
            }
        }

        public void b(Object obj) {
            if (obj == null) {
                obj = f137766j;
            }
            this.f137772g.remove(obj);
            if (decrementAndGet() == 0) {
                this.f137773h.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f137774i.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.f137773h.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137774i.get();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.Observer
        public void h(Object obj) {
            try {
                Object objApply = this.f137768b.apply(obj);
                Object obj2 = objApply != null ? objApply : f137766j;
                GroupedUnicast groupedUnicastA = (GroupedUnicast) this.f137772g.get(obj2);
                if (groupedUnicastA == null) {
                    if (this.f137774i.get()) {
                        return;
                    }
                    groupedUnicastA = GroupedUnicast.A(objApply, this.f137770d, this, this.f137771f);
                    this.f137772g.put(obj2, groupedUnicastA);
                    getAndIncrement();
                    this.f137767a.h(groupedUnicastA);
                }
                try {
                    groupedUnicastA.h(ObjectHelper.d(this.f137769c.apply(obj), "The value supplied is null"));
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f137773h.dispose();
                    onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f137773h.dispose();
                onError(th2);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            ArrayList arrayList = new ArrayList(this.f137772g.values());
            this.f137772g.clear();
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                ((GroupedUnicast) obj).onComplete();
            }
            this.f137767a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            ArrayList arrayList = new ArrayList(this.f137772g.values());
            this.f137772g.clear();
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                ((GroupedUnicast) obj).onError(th);
            }
            this.f137767a.onError(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class GroupedUnicast<K, T> extends GroupedObservable<K, T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final State f137775b;

        protected GroupedUnicast(Object obj, State state) {
            super(obj);
            this.f137775b = state;
        }

        public static GroupedUnicast A(Object obj, int i3, GroupByObserver groupByObserver, boolean z2) {
            return new GroupedUnicast(obj, new State(i3, groupByObserver, obj, z2));
        }

        public void h(Object obj) {
            this.f137775b.g(obj);
        }

        public void onComplete() {
            this.f137775b.d();
        }

        public void onError(Throwable th) {
            this.f137775b.f(th);
        }

        @Override // io.reactivex.Observable
        protected void u(Observer observer) {
            this.f137775b.b(observer);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class State<T, K> extends AtomicInteger implements Disposable, ObservableSource<T> {
        private static final long serialVersionUID = -3852313036005250360L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f137776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SpscLinkedArrayQueue f137777b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final GroupByObserver f137778c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f137779d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile boolean f137780f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Throwable f137781g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final AtomicBoolean f137782h = new AtomicBoolean();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final AtomicBoolean f137783i = new AtomicBoolean();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final AtomicReference f137784j = new AtomicReference();

        State(int i3, GroupByObserver groupByObserver, Object obj, boolean z2) {
            this.f137777b = new SpscLinkedArrayQueue(i3);
            this.f137778c = groupByObserver;
            this.f137776a = obj;
            this.f137779d = z2;
        }

        boolean a(boolean z2, boolean z3, Observer observer, boolean z4) {
            if (this.f137782h.get()) {
                this.f137777b.clear();
                this.f137778c.b(this.f137776a);
                this.f137784j.lazySet(null);
                return true;
            }
            if (!z2) {
                return false;
            }
            if (z4) {
                if (!z3) {
                    return false;
                }
                Throwable th = this.f137781g;
                this.f137784j.lazySet(null);
                if (th != null) {
                    observer.onError(th);
                } else {
                    observer.onComplete();
                }
                return true;
            }
            Throwable th2 = this.f137781g;
            if (th2 != null) {
                this.f137777b.clear();
                this.f137784j.lazySet(null);
                observer.onError(th2);
                return true;
            }
            if (!z3) {
                return false;
            }
            this.f137784j.lazySet(null);
            observer.onComplete();
            return true;
        }

        @Override // io.reactivex.ObservableSource
        public void b(Observer observer) {
            if (!this.f137783i.compareAndSet(false, true)) {
                EmptyDisposable.i(new IllegalStateException("Only one Observer allowed!"), observer);
                return;
            }
            observer.a(this);
            this.f137784j.lazySet(observer);
            if (this.f137782h.get()) {
                this.f137784j.lazySet(null);
            } else {
                c();
            }
        }

        void c() {
            if (getAndIncrement() != 0) {
                return;
            }
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f137777b;
            boolean z2 = this.f137779d;
            Observer observer = (Observer) this.f137784j.get();
            int iAddAndGet = 1;
            while (true) {
                if (observer != null) {
                    while (true) {
                        boolean z3 = this.f137780f;
                        Object objPoll = spscLinkedArrayQueue.poll();
                        boolean z4 = objPoll == null;
                        if (a(z3, z4, observer, z2)) {
                            return;
                        }
                        if (z4) {
                            break;
                        } else {
                            observer.h(objPoll);
                        }
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
                if (observer == null) {
                    observer = (Observer) this.f137784j.get();
                }
            }
        }

        public void d() {
            this.f137780f = true;
            c();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f137782h.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.f137784j.lazySet(null);
                this.f137778c.b(this.f137776a);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137782h.get();
        }

        public void f(Throwable th) {
            this.f137781g = th;
            this.f137780f = true;
            c();
        }

        public void g(Object obj) {
            this.f137777b.offer(obj);
            c();
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        this.f137267a.b(new GroupByObserver(observer, this.f137762b, this.f137763c, this.f137764d, this.f137765f));
    }
}
