package com.applovin.impl;

import com.applovin.impl.ub;
import java.lang.ref.WeakReference;
import java.util.Stack;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface ub {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface a {
        Object a();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface b {
        void a(Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class c implements ub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f64164a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Stack f64165b;

        public c() {
            this(3);
        }

        @Override // com.applovin.impl.ub
        public synchronized Object a(a aVar) {
            try {
            } catch (Throwable th) {
                throw th;
            }
            return this.f64165b.isEmpty() ? aVar.a() : this.f64165b.pop();
        }

        public c(int i3) {
            this.f64165b = new Stack();
            this.f64164a = i3;
        }

        @Override // com.applovin.impl.ub
        public synchronized void a(Object obj, b bVar) {
            if (this.f64165b.size() < this.f64164a) {
                this.f64165b.push(obj);
            } else {
                try {
                    bVar.a(obj);
                } catch (RuntimeException e3) {
                    p6.a((Throwable) e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class d implements ub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f64166a = new c();

        @Override // com.applovin.impl.ub
        public Object a(final a aVar) {
            Object obj;
            do {
                obj = ((WeakReference) this.f64166a.a(new a() { // from class: com.applovin.impl.q60
                    @Override // com.applovin.impl.ub.a
                    public final Object a() {
                        return ub.d.b(aVar);
                    }
                })).get();
            } while (obj == null);
            return obj;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ WeakReference b(a aVar) {
            return new WeakReference(aVar.a());
        }

        @Override // com.applovin.impl.ub
        public void a(final Object obj, final b bVar) {
            p6.a(obj);
            this.f64166a.a(new WeakReference(obj), new b() { // from class: com.applovin.impl.p60
                @Override // com.applovin.impl.ub.b
                public final void a(Object obj2) {
                    bVar.a(obj);
                }
            });
        }
    }

    Object a(a aVar);

    void a(Object obj, b bVar);
}
