package com.applovin.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.RandomAccess;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ug implements Set, RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f64225a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashSet f64226b = new HashSet();

    @Override // java.util.Set, java.util.Collection
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean add(Comparable comparable) {
        if (contains(comparable)) {
            return false;
        }
        if (isEmpty() || comparable.compareTo(a()) > 0) {
            this.f64225a.add(comparable);
        } else {
            this.f64225a.add(b(comparable), comparable);
        }
        return this.f64226b.add(comparable);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection collection) {
        Iterator it = collection.iterator();
        while (true) {
            boolean z2 = false;
            while (it.hasNext()) {
                if (add((Comparable) it.next()) || z2) {
                    z2 = true;
                }
            }
            return z2;
        }
    }

    public int b(Comparable comparable) {
        int iBinarySearch = Collections.binarySearch(this.f64225a, comparable);
        if (iBinarySearch < 0) {
            return ~iBinarySearch;
        }
        Comparable comparableA = a(iBinarySearch);
        while (iBinarySearch >= 0 && comparableA == a(iBinarySearch)) {
            iBinarySearch--;
        }
        return iBinarySearch + 1;
    }

    public int c(Comparable comparable) {
        int iBinarySearch = Collections.binarySearch(this.f64225a, comparable);
        if (iBinarySearch < 0) {
            return ~iBinarySearch;
        }
        Comparable comparableA = a(iBinarySearch);
        while (iBinarySearch < size() && comparableA == a(iBinarySearch)) {
            iBinarySearch++;
        }
        return iBinarySearch;
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.f64225a.clear();
        this.f64226b.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return this.f64226b.contains(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.f64226b.containsAll(collection);
    }

    public int d(Comparable comparable) {
        if (comparable == null || !contains(comparable)) {
            return -1;
        }
        return b(comparable);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.f64225a.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.f64225a.iterator();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        int iD = d((Comparable) obj);
        if (iD == -1) {
            return false;
        }
        this.f64225a.remove(iD);
        return this.f64226b.remove(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection collection) {
        while (true) {
            for (Object obj : collection) {
                boolean z2 = z2 || remove(obj);
            }
            return false;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection collection) {
        boolean z2 = false;
        for (int size = size() - 1; size >= 0; size--) {
            Comparable comparable = (Comparable) this.f64225a.get(size);
            if (!collection.contains(comparable)) {
                this.f64225a.remove(size);
                this.f64226b.remove(comparable);
                z2 = true;
            }
        }
        return z2;
    }

    @Override // java.util.Set, java.util.Collection
    public int size() {
        return this.f64225a.size();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return this.f64225a.toArray();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        return this.f64225a.toArray(objArr);
    }

    public Comparable b(int i3) {
        Comparable comparable = (Comparable) this.f64225a.remove(i3);
        this.f64226b.remove(comparable);
        return comparable;
    }

    public Comparable a(int i3) {
        return (Comparable) this.f64225a.get(i3);
    }

    public Comparable a() {
        return (Comparable) this.f64225a.get(size() - 1);
    }

    public void a(int i3, Comparable comparable) {
        this.f64226b.remove((Comparable) this.f64225a.get(i3));
        this.f64225a.set(i3, comparable);
        this.f64226b.add(comparable);
    }
}
