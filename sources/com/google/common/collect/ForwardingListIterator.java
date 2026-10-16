package com.google.common.collect;

import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingListIterator<E> extends ForwardingIterator<E> implements ListIterator<E> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingIterator
    /* JADX INFO: renamed from: S1, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public abstract ListIterator k2();

    @Override // java.util.ListIterator
    public void add(Object obj) {
        o2().add(obj);
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return o2().hasPrevious();
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return o2().nextIndex();
    }

    @Override // java.util.ListIterator
    public Object previous() {
        return o2().previous();
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return o2().previousIndex();
    }

    @Override // java.util.ListIterator
    public void set(Object obj) {
        o2().set(obj);
    }
}
