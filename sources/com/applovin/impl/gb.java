package com.applovin.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class gb extends b2 implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final transient fb f59944d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final transient int f59945f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends pp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Iterator f59946a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Iterator f59947b = wb.a();

        a() {
            this.f59946a = gb.this.f59944d.values().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f59947b.hasNext() || this.f59946a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!this.f59947b.hasNext()) {
                this.f59947b = ((bb) this.f59946a.next()).iterator();
            }
            return this.f59947b.next();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class c extends bb {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final transient gb f59952b;

        c(gb gbVar) {
            this.f59952b = gbVar;
        }

        @Override // com.applovin.impl.bb
        int a(Object[] objArr, int i3) {
            pp it = this.f59952b.f59944d.values().iterator();
            while (it.hasNext()) {
                i3 = ((bb) it.next()).a(objArr, i3);
            }
            return i3;
        }

        @Override // com.applovin.impl.bb, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.f59952b.a(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public pp iterator() {
            return this.f59952b.f();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f59952b.size();
        }
    }

    gb(fb fbVar, int i3) {
        this.f59944d = fbVar;
        this.f59945f = i3;
    }

    @Override // com.applovin.impl.h
    Map b() {
        throw new AssertionError("should never be called");
    }

    @Override // com.applovin.impl.h
    Set c() {
        throw new AssertionError("unreachable");
    }

    @Override // com.applovin.impl.tf
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.applovin.impl.h
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.applovin.impl.h, com.applovin.impl.tf
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public fb a() {
        return this.f59944d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.applovin.impl.h
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public bb d() {
        return new c(this);
    }

    @Override // com.applovin.impl.h
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.applovin.impl.h
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public pp f() {
        return new a();
    }

    @Override // com.applovin.impl.h, com.applovin.impl.tf
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public bb values() {
        return (bb) super.values();
    }

    @Override // com.applovin.impl.tf
    public boolean put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.applovin.impl.tf
    public int size() {
        return this.f59945f;
    }

    @Override // com.applovin.impl.h
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.applovin.impl.h
    public boolean a(Object obj) {
        return obj != null && super.a(obj);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Map f59949a = mh.a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Comparator f59950b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Comparator f59951c;

        public gb a() {
            Collection collectionEntrySet = this.f59949a.entrySet();
            Comparator comparator = this.f59950b;
            if (comparator != null) {
                collectionEntrySet = vg.a(comparator).b().a(collectionEntrySet);
            }
            return eb.a(collectionEntrySet, this.f59951c);
        }

        Collection b() {
            return new ArrayList();
        }

        public b a(Object obj, Iterable iterable) {
            if (obj != null) {
                Collection collection = (Collection) this.f59949a.get(obj);
                if (collection != null) {
                    for (Object obj2 : iterable) {
                        p3.a(obj, obj2);
                        collection.add(obj2);
                    }
                } else {
                    Iterator it = iterable.iterator();
                    if (it.hasNext()) {
                        Collection collectionB = b();
                        while (it.hasNext()) {
                            Object next = it.next();
                            p3.a(obj, next);
                            collectionB.add(next);
                        }
                        this.f59949a.put(obj, collectionB);
                        return this;
                    }
                }
                return this;
            }
            throw new NullPointerException("null key in entry: null=" + vb.d(iterable));
        }

        public b a(Object obj, Object... objArr) {
            return a(obj, Arrays.asList(objArr));
        }
    }
}
