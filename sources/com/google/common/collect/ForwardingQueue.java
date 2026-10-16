package com.google.common.collect;

import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingQueue<E> extends ForwardingCollection<E> implements Queue<E> {
    protected ForwardingQueue() {
    }

    @Override // java.util.Queue
    public Object element() {
        return k2().element();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingCollection
    public abstract Queue o2();

    public boolean offer(Object obj) {
        return k2().offer(obj);
    }

    @Override // java.util.Queue
    public Object peek() {
        return k2().peek();
    }

    @Override // java.util.Queue
    public Object poll() {
        return k2().poll();
    }

    @Override // java.util.Queue
    public Object remove() {
        return k2().remove();
    }
}
