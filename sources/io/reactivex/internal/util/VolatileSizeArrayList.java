package io.reactivex.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class VolatileSizeArrayList<T> extends AtomicInteger implements List<T>, RandomAccess {
    private static final long serialVersionUID = 3972397474470203923L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ArrayList f139224a;

    @Override // java.util.List, java.util.Collection
    public boolean add(Object obj) {
        boolean zAdd = this.f139224a.add(obj);
        lazySet(this.f139224a.size());
        return zAdd;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        boolean zAddAll = this.f139224a.addAll(collection);
        lazySet(this.f139224a.size());
        return zAddAll;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.f139224a.clear();
        lazySet(0);
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.f139224a.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.f139224a.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        return obj instanceof VolatileSizeArrayList ? this.f139224a.equals(((VolatileSizeArrayList) obj).f139224a) : this.f139224a.equals(obj);
    }

    @Override // java.util.List
    public Object get(int i3) {
        return this.f139224a.get(i3);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.f139224a.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.f139224a.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return get() == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.f139224a.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.f139224a.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return this.f139224a.listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        boolean zRemove = this.f139224a.remove(obj);
        lazySet(this.f139224a.size());
        return zRemove;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        boolean zRemoveAll = this.f139224a.removeAll(collection);
        lazySet(this.f139224a.size());
        return zRemoveAll;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        boolean zRetainAll = this.f139224a.retainAll(collection);
        lazySet(this.f139224a.size());
        return zRetainAll;
    }

    @Override // java.util.List
    public Object set(int i3, Object obj) {
        return this.f139224a.set(i3, obj);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return get();
    }

    @Override // java.util.List
    public List subList(int i3, int i4) {
        return this.f139224a.subList(i3, i4);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.f139224a.toArray();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public String toString() {
        return this.f139224a.toString();
    }

    @Override // java.util.List
    public ListIterator listIterator(int i3) {
        return this.f139224a.listIterator(i3);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        return this.f139224a.toArray(objArr);
    }

    @Override // java.util.List
    public void add(int i3, Object obj) {
        this.f139224a.add(i3, obj);
        lazySet(this.f139224a.size());
    }

    @Override // java.util.List
    public boolean addAll(int i3, Collection collection) {
        boolean zAddAll = this.f139224a.addAll(i3, collection);
        lazySet(this.f139224a.size());
        return zAddAll;
    }

    @Override // java.util.List
    public Object remove(int i3) {
        Object objRemove = this.f139224a.remove(i3);
        lazySet(this.f139224a.size());
        return objRemove;
    }
}
