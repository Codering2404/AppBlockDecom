package com.google.common.collect;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingList<E> extends ForwardingCollection<E> implements List<E> {
    protected ForwardingList() {
    }

    public void add(int i3, Object obj) {
        k2().add(i3, obj);
    }

    public boolean addAll(int i3, Collection collection) {
        return k2().addAll(i3, collection);
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return obj == this || k2().equals(obj);
    }

    @Override // java.util.List
    public Object get(int i3) {
        return k2().get(i3);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return k2().hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return k2().indexOf(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingCollection
    public abstract List k2();

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return k2().lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return k2().listIterator();
    }

    @Override // java.util.List
    public Object remove(int i3) {
        return k2().remove(i3);
    }

    @Override // java.util.List
    public Object set(int i3, Object obj) {
        return k2().set(i3, obj);
    }

    @Override // java.util.List
    public List subList(int i3, int i4) {
        return k2().subList(i3, i4);
    }

    @Override // java.util.List
    public ListIterator listIterator(int i3) {
        return k2().listIterator(i3);
    }
}
