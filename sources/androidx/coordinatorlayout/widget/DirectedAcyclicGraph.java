package androidx.coordinatorlayout.widget;

import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DirectedAcyclicGraph<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Pools.Pool f33483a = new Pools.SimplePool(10);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SimpleArrayMap f33484b = new SimpleArrayMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList f33485c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashSet f33486d = new HashSet();

    private void e(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) this.f33484b.get(obj);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i3 = 0; i3 < size; i3++) {
                e(arrayList2.get(i3), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }

    private ArrayList f() {
        ArrayList arrayList = (ArrayList) this.f33483a.a();
        return arrayList == null ? new ArrayList() : arrayList;
    }

    private void k(ArrayList arrayList) {
        arrayList.clear();
        this.f33483a.b(arrayList);
    }

    public void a(Object obj, Object obj2) {
        if (!this.f33484b.containsKey(obj) || !this.f33484b.containsKey(obj2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList arrayListF = (ArrayList) this.f33484b.get(obj);
        if (arrayListF == null) {
            arrayListF = f();
            this.f33484b.put(obj, arrayListF);
        }
        arrayListF.add(obj2);
    }

    public void b(Object obj) {
        if (this.f33484b.containsKey(obj)) {
            return;
        }
        this.f33484b.put(obj, null);
    }

    public void c() {
        int size = this.f33484b.size();
        for (int i3 = 0; i3 < size; i3++) {
            ArrayList arrayList = (ArrayList) this.f33484b.j(i3);
            if (arrayList != null) {
                k(arrayList);
            }
        }
        this.f33484b.clear();
    }

    public boolean d(Object obj) {
        return this.f33484b.containsKey(obj);
    }

    public List g(Object obj) {
        return (List) this.f33484b.get(obj);
    }

    public List h(Object obj) {
        int size = this.f33484b.size();
        ArrayList arrayList = null;
        for (int i3 = 0; i3 < size; i3++) {
            ArrayList arrayList2 = (ArrayList) this.f33484b.j(i3);
            if (arrayList2 != null && arrayList2.contains(obj)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f33484b.f(i3));
            }
        }
        return arrayList;
    }

    public ArrayList i() {
        this.f33485c.clear();
        this.f33486d.clear();
        int size = this.f33484b.size();
        for (int i3 = 0; i3 < size; i3++) {
            e(this.f33484b.f(i3), this.f33485c, this.f33486d);
        }
        return this.f33485c;
    }

    public boolean j(Object obj) {
        int size = this.f33484b.size();
        for (int i3 = 0; i3 < size; i3++) {
            ArrayList arrayList = (ArrayList) this.f33484b.j(i3);
            if (arrayList != null && arrayList.contains(obj)) {
                return true;
            }
        }
        return false;
    }
}
