package com.applovin.impl;

import com.applovin.impl.bb;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class fb implements Map, Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final Map.Entry[] f59670d = new Map.Entry[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient hb f59671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient hb f59672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient bb f59673c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Comparator f59674a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object[] f59675b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f59676c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f59677d;

        public a() {
            this(4);
        }

        public fb a() {
            b();
            this.f59677d = true;
            return ni.a(this.f59676c, this.f59675b);
        }

        void b() {
            int i3;
            if (this.f59674a != null) {
                if (this.f59677d) {
                    this.f59675b = Arrays.copyOf(this.f59675b, this.f59676c * 2);
                }
                Map.Entry[] entryArr = new Map.Entry[this.f59676c];
                int i4 = 0;
                while (true) {
                    i3 = this.f59676c;
                    if (i4 >= i3) {
                        break;
                    }
                    Object[] objArr = this.f59675b;
                    int i5 = i4 * 2;
                    entryArr[i4] = new AbstractMap.SimpleImmutableEntry(objArr[i5], objArr[i5 + 1]);
                    i4++;
                }
                Arrays.sort(entryArr, 0, i3, vg.a(this.f59674a).a(uc.c()));
                for (int i6 = 0; i6 < this.f59676c; i6++) {
                    int i7 = i6 * 2;
                    this.f59675b[i7] = entryArr[i6].getKey();
                    this.f59675b[i7 + 1] = entryArr[i6].getValue();
                }
            }
        }

        a(int i3) {
            this.f59675b = new Object[i3 * 2];
            this.f59676c = 0;
            this.f59677d = false;
        }

        private void a(int i3) {
            int i4 = i3 * 2;
            Object[] objArr = this.f59675b;
            if (i4 > objArr.length) {
                this.f59675b = Arrays.copyOf(objArr, bb.b.a(objArr.length, i4));
                this.f59677d = false;
            }
        }

        public a a(Object obj, Object obj2) {
            a(this.f59676c + 1);
            p3.a(obj, obj2);
            Object[] objArr = this.f59675b;
            int i3 = this.f59676c;
            int i4 = i3 * 2;
            objArr[i4] = obj;
            objArr[i4 + 1] = obj2;
            this.f59676c = i3 + 1;
            return this;
        }

        public a a(Map.Entry entry) {
            return a(entry.getKey(), entry.getValue());
        }

        public a a(Iterable iterable) {
            if (iterable instanceof Collection) {
                a(this.f59676c + ((Collection) iterable).size());
            }
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                a((Map.Entry) it.next());
            }
            return this;
        }
    }

    fb() {
    }

    public static fb a(Iterable iterable) {
        a aVar = new a(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        aVar.a(iterable);
        return aVar.a();
    }

    public static fb h() {
        return ni.f62051i;
    }

    abstract hb b();

    abstract hb c();

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    abstract bb d();

    @Override // java.util.Map
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public hb entrySet() {
        hb hbVar = this.f59671a;
        if (hbVar != null) {
            return hbVar;
        }
        hb hbVarB = b();
        this.f59671a = hbVarB;
        return hbVarB;
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return uc.a((Map) this, obj);
    }

    abstract boolean f();

    @Override // java.util.Map
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public hb keySet() {
        hb hbVar = this.f59672b;
        if (hbVar != null) {
            return hbVar;
        }
        hb hbVarC = c();
        this.f59672b = hbVarC;
        return hbVarC;
    }

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public int hashCode() {
        return rj.a(entrySet());
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public bb values() {
        bb bbVar = this.f59673c;
        if (bbVar != null) {
            return bbVar;
        }
        bb bbVarD = d();
        this.f59673c = bbVarD;
        return bbVarD;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return uc.a(this);
    }

    public static fb a(Map map) {
        if ((map instanceof fb) && !(map instanceof SortedMap)) {
            fb fbVar = (fb) map;
            if (!fbVar.f()) {
                return fbVar;
            }
        }
        return a(map.entrySet());
    }

    public static a a() {
        return new a();
    }
}
