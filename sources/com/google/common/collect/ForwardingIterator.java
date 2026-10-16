package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingIterator<T> extends ForwardingObject implements Iterator<T> {
    protected ForwardingIterator() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingObject
    /* JADX INFO: renamed from: I1, reason: merged with bridge method [inline-methods] */
    public abstract Iterator k2();

    @Override // java.util.Iterator
    public boolean hasNext() {
        return k2().hasNext();
    }

    public Object next() {
        return k2().next();
    }

    public void remove() {
        k2().remove();
    }
}
