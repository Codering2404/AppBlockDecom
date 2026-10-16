package com.google.common.collect;

import java.util.Deque;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingDeque<E> extends ForwardingQueue<E> implements Deque<E> {
    @Override // java.util.Deque
    public void addFirst(Object obj) {
        k2().addFirst(obj);
    }

    @Override // java.util.Deque
    public void addLast(Object obj) {
        k2().addLast(obj);
    }

    @Override // java.util.Deque
    public Iterator descendingIterator() {
        return k2().descendingIterator();
    }

    @Override // java.util.Deque
    public Object getFirst() {
        return k2().getFirst();
    }

    @Override // java.util.Deque
    public Object getLast() {
        return k2().getLast();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingQueue
    /* JADX INFO: renamed from: m2, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public abstract Deque k2();

    @Override // java.util.Deque
    public boolean offerFirst(Object obj) {
        return k2().offerFirst(obj);
    }

    @Override // java.util.Deque
    public boolean offerLast(Object obj) {
        return k2().offerLast(obj);
    }

    @Override // java.util.Deque
    public Object peekFirst() {
        return k2().peekFirst();
    }

    @Override // java.util.Deque
    public Object peekLast() {
        return k2().peekLast();
    }

    @Override // java.util.Deque
    public Object pollFirst() {
        return k2().pollFirst();
    }

    @Override // java.util.Deque
    public Object pollLast() {
        return k2().pollLast();
    }

    @Override // java.util.Deque
    public Object pop() {
        return k2().pop();
    }

    @Override // java.util.Deque
    public void push(Object obj) {
        k2().push(obj);
    }

    @Override // java.util.Deque
    public Object removeFirst() {
        return k2().removeFirst();
    }

    @Override // java.util.Deque
    public boolean removeFirstOccurrence(Object obj) {
        return k2().removeFirstOccurrence(obj);
    }

    @Override // java.util.Deque
    public Object removeLast() {
        return k2().removeLast();
    }

    @Override // java.util.Deque
    public boolean removeLastOccurrence(Object obj) {
        return k2().removeLastOccurrence(obj);
    }
}
