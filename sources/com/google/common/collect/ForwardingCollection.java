package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingCollection<E> extends ForwardingObject implements Collection<E> {
    protected ForwardingCollection() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingObject
    /* JADX INFO: renamed from: I1, reason: merged with bridge method [inline-methods] */
    public abstract Collection k2();

    protected boolean S1(Collection collection) {
        return Iterators.a(this, collection.iterator());
    }

    protected boolean T1(Collection collection) {
        return Collections2.b(this, collection);
    }

    protected boolean V1(Collection collection) {
        return Iterators.J(iterator(), collection);
    }

    public boolean add(Object obj) {
        return k2().add(obj);
    }

    public boolean addAll(Collection collection) {
        return k2().addAll(collection);
    }

    protected Object[] b2() {
        return toArray(new Object[size()]);
    }

    protected Object[] c2(Object[] objArr) {
        return ObjectArrays.i(this, objArr);
    }

    public void clear() {
        k2().clear();
    }

    public boolean contains(Object obj) {
        return k2().contains(obj);
    }

    public boolean containsAll(Collection collection) {
        return k2().containsAll(collection);
    }

    protected String g2() {
        return Collections2.i(this);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return k2().isEmpty();
    }

    public Iterator iterator() {
        return k2().iterator();
    }

    public boolean remove(Object obj) {
        return k2().remove(obj);
    }

    public boolean removeAll(Collection collection) {
        return k2().removeAll(collection);
    }

    public boolean retainAll(Collection collection) {
        return k2().retainAll(collection);
    }

    @Override // java.util.Collection
    public int size() {
        return k2().size();
    }

    public Object[] toArray() {
        return k2().toArray();
    }

    public Object[] toArray(Object[] objArr) {
        return k2().toArray(objArr);
    }
}
