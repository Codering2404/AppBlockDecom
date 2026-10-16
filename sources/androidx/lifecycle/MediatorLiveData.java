package androidx.lifecycle;

import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class MediatorLiveData<T> extends MutableLiveData<T> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private SafeIterableMap f40021l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Source<V> implements Observer<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final LiveData f40022a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Observer f40023b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f40024c = -1;

        Source(LiveData liveData, Observer observer) {
            this.f40022a = liveData;
            this.f40023b = observer;
        }

        @Override // androidx.lifecycle.Observer
        public void a(Object obj) {
            if (this.f40024c != this.f40022a.g()) {
                this.f40024c = this.f40022a.g();
                this.f40023b.a(obj);
            }
        }

        void b() {
            this.f40022a.k(this);
        }

        void c() {
            this.f40022a.o(this);
        }
    }

    public MediatorLiveData() {
        this.f40021l = new SafeIterableMap();
    }

    @Override // androidx.lifecycle.LiveData
    protected void l() {
        Iterator it = this.f40021l.iterator();
        while (it.hasNext()) {
            ((Source) ((Map.Entry) it.next()).getValue()).b();
        }
    }

    @Override // androidx.lifecycle.LiveData
    protected void m() {
        Iterator it = this.f40021l.iterator();
        while (it.hasNext()) {
            ((Source) ((Map.Entry) it.next()).getValue()).c();
        }
    }

    public void q(LiveData liveData, Observer observer) {
        if (liveData == null) {
            throw new NullPointerException("source cannot be null");
        }
        Source source = new Source(liveData, observer);
        Source source2 = (Source) this.f40021l.g(liveData, source);
        if (source2 != null && source2.f40023b != observer) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        }
        if (source2 == null && h()) {
            source.b();
        }
    }

    public void r(LiveData liveData) {
        Source source = (Source) this.f40021l.h(liveData);
        if (source != null) {
            source.c();
        }
    }

    public MediatorLiveData(Object obj) {
        super(obj);
        this.f40021l = new SafeIterableMap();
    }
}
