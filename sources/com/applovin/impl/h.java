package com.applovin.impl;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class h implements tf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient Set f60069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient Collection f60070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient Map f60071c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends AbstractCollection {
        a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return h.this.a(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return h.this.f();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return h.this.size();
        }
    }

    h() {
    }

    @Override // com.applovin.impl.tf
    public Map a() {
        Map map = this.f60071c;
        if (map != null) {
            return map;
        }
        Map mapB = b();
        this.f60071c = mapB;
        return mapB;
    }

    abstract Map b();

    abstract Set c();

    abstract Collection d();

    public Set e() {
        Set set = this.f60069a;
        if (set != null) {
            return set;
        }
        Set setC = c();
        this.f60069a = setC;
        return setC;
    }

    public boolean equals(Object obj) {
        return wf.a(this, obj);
    }

    abstract Iterator f();

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString();
    }

    @Override // com.applovin.impl.tf
    public Collection values() {
        Collection collection = this.f60070b;
        if (collection != null) {
            return collection;
        }
        Collection collectionD = d();
        this.f60070b = collectionD;
        return collectionD;
    }

    public boolean a(Object obj) {
        Iterator it = a().values().iterator();
        while (it.hasNext()) {
            if (((Collection) it.next()).contains(obj)) {
                return true;
            }
        }
        return false;
    }
}
