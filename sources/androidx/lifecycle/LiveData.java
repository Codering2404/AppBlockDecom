package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class LiveData<T> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final Object f39993k = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Object f39994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SafeIterableMap f39995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f39996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f39997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile Object f39998e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    volatile Object f39999f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f40000g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f40001h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f40002i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Runnable f40003j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class AlwaysActiveObserver extends LiveData<T>.ObserverWrapper {
        AlwaysActiveObserver(Observer observer) {
            super(observer);
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        boolean e() {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class LifecycleBoundObserver extends LiveData<T>.ObserverWrapper implements LifecycleEventObserver {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final LifecycleOwner f40006f;

        LifecycleBoundObserver(LifecycleOwner lifecycleOwner, Observer observer) {
            super(observer);
            this.f40006f = lifecycleOwner;
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        void c() {
            this.f40006f.getLifecycle().removeObserver(this);
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        boolean d(LifecycleOwner lifecycleOwner) {
            return this.f40006f == lifecycleOwner;
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        boolean e() {
            return this.f40006f.getLifecycle().getCurrentState().b(Lifecycle.State.f39950d);
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void j(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Lifecycle.State currentState = this.f40006f.getLifecycle().getCurrentState();
            if (currentState == Lifecycle.State.f39947a) {
                LiveData.this.o(this.f40008a);
                return;
            }
            Lifecycle.State state = null;
            while (state != currentState) {
                a(e());
                state = currentState;
                currentState = this.f40006f.getLifecycle().getCurrentState();
            }
        }
    }

    public LiveData(Object obj) {
        this.f39994a = new Object();
        this.f39995b = new SafeIterableMap();
        this.f39996c = 0;
        this.f39999f = f39993k;
        this.f40003j = new Runnable() { // from class: androidx.lifecycle.LiveData.1
            @Override // java.lang.Runnable
            public void run() {
                Object obj2;
                synchronized (LiveData.this.f39994a) {
                    obj2 = LiveData.this.f39999f;
                    LiveData.this.f39999f = LiveData.f39993k;
                }
                LiveData.this.p(obj2);
            }
        };
        this.f39998e = obj;
        this.f40000g = 0;
    }

    static void b(String str) {
        if (ArchTaskExecutor.h().c()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    private void d(ObserverWrapper observerWrapper) {
        if (observerWrapper.f40009b) {
            if (!observerWrapper.e()) {
                observerWrapper.a(false);
                return;
            }
            int i3 = observerWrapper.f40010c;
            int i4 = this.f40000g;
            if (i3 >= i4) {
                return;
            }
            observerWrapper.f40010c = i4;
            observerWrapper.f40008a.a(this.f39998e);
        }
    }

    void c(int i3) {
        int i4 = this.f39996c;
        this.f39996c = i3 + i4;
        if (this.f39997d) {
            return;
        }
        this.f39997d = true;
        while (true) {
            try {
                int i5 = this.f39996c;
                if (i4 == i5) {
                    this.f39997d = false;
                    return;
                }
                boolean z2 = i4 == 0 && i5 > 0;
                boolean z3 = i4 > 0 && i5 == 0;
                if (z2) {
                    l();
                } else if (z3) {
                    m();
                }
                i4 = i5;
            } catch (Throwable th) {
                this.f39997d = false;
                throw th;
            }
        }
    }

    void e(ObserverWrapper observerWrapper) {
        if (this.f40001h) {
            this.f40002i = true;
            return;
        }
        this.f40001h = true;
        do {
            this.f40002i = false;
            if (observerWrapper != null) {
                d(observerWrapper);
                observerWrapper = null;
            } else {
                SafeIterableMap.IteratorWithAdditions iteratorWithAdditionsD = this.f39995b.d();
                while (iteratorWithAdditionsD.hasNext()) {
                    d((ObserverWrapper) iteratorWithAdditionsD.next().getValue());
                    if (this.f40002i) {
                        break;
                    }
                }
            }
        } while (this.f40002i);
        this.f40001h = false;
    }

    public Object f() {
        Object obj = this.f39998e;
        if (obj != f39993k) {
            return obj;
        }
        return null;
    }

    int g() {
        return this.f40000g;
    }

    public boolean h() {
        return this.f39996c > 0;
    }

    public boolean i() {
        return this.f39998e != f39993k;
    }

    public void j(LifecycleOwner lifecycleOwner, Observer observer) {
        b("observe");
        if (lifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.f39947a) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(lifecycleOwner, observer);
        ObserverWrapper observerWrapper = (ObserverWrapper) this.f39995b.g(observer, lifecycleBoundObserver);
        if (observerWrapper != null && !observerWrapper.d(lifecycleOwner)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (observerWrapper != null) {
            return;
        }
        lifecycleOwner.getLifecycle().addObserver(lifecycleBoundObserver);
    }

    public void k(Observer observer) {
        b("observeForever");
        AlwaysActiveObserver alwaysActiveObserver = new AlwaysActiveObserver(observer);
        ObserverWrapper observerWrapper = (ObserverWrapper) this.f39995b.g(observer, alwaysActiveObserver);
        if (observerWrapper instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (observerWrapper != null) {
            return;
        }
        alwaysActiveObserver.a(true);
    }

    protected void n(Object obj) {
        boolean z2;
        synchronized (this.f39994a) {
            z2 = this.f39999f == f39993k;
            this.f39999f = obj;
        }
        if (z2) {
            ArchTaskExecutor.h().d(this.f40003j);
        }
    }

    public void o(Observer observer) {
        b("removeObserver");
        ObserverWrapper observerWrapper = (ObserverWrapper) this.f39995b.h(observer);
        if (observerWrapper == null) {
            return;
        }
        observerWrapper.c();
        observerWrapper.a(false);
    }

    protected void p(Object obj) {
        b("setValue");
        this.f40000g++;
        this.f39998e = obj;
        e(null);
    }

    public LiveData() {
        this.f39994a = new Object();
        this.f39995b = new SafeIterableMap();
        this.f39996c = 0;
        Object obj = f39993k;
        this.f39999f = obj;
        this.f40003j = new Runnable() { // from class: androidx.lifecycle.LiveData.1
            @Override // java.lang.Runnable
            public void run() {
                Object obj2;
                synchronized (LiveData.this.f39994a) {
                    obj2 = LiveData.this.f39999f;
                    LiveData.this.f39999f = LiveData.f39993k;
                }
                LiveData.this.p(obj2);
            }
        };
        this.f39998e = obj;
        this.f40000g = -1;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private abstract class ObserverWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f40008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f40009b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f40010c = -1;

        ObserverWrapper(Observer observer) {
            this.f40008a = observer;
        }

        void a(boolean z2) {
            if (z2 == this.f40009b) {
                return;
            }
            this.f40009b = z2;
            LiveData.this.c(z2 ? 1 : -1);
            if (this.f40009b) {
                LiveData.this.e(this);
            }
        }

        boolean d(LifecycleOwner lifecycleOwner) {
            return false;
        }

        abstract boolean e();

        void c() {
        }
    }

    protected void l() {
    }

    protected void m() {
    }
}
