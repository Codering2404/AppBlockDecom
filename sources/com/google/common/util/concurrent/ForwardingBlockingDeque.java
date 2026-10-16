package com.google.common.util.concurrent;

import com.google.common.collect.ForwardingDeque;
import java.util.Collection;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingBlockingDeque<E> extends ForwardingDeque<E> implements BlockingDeque<E> {
    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection collection) {
        return o2().drainTo(collection);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingDeque
    public abstract BlockingDeque k2();

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public boolean offer(Object obj, long j3, TimeUnit timeUnit) {
        return o2().offer(obj, j3, timeUnit);
    }

    @Override // java.util.concurrent.BlockingDeque
    public boolean offerFirst(Object obj, long j3, TimeUnit timeUnit) {
        return o2().offerFirst(obj, j3, timeUnit);
    }

    @Override // java.util.concurrent.BlockingDeque
    public boolean offerLast(Object obj, long j3, TimeUnit timeUnit) {
        return o2().offerLast(obj, j3, timeUnit);
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public Object poll(long j3, TimeUnit timeUnit) {
        return o2().poll(j3, timeUnit);
    }

    @Override // java.util.concurrent.BlockingDeque
    public Object pollFirst(long j3, TimeUnit timeUnit) {
        return o2().pollFirst(j3, timeUnit);
    }

    @Override // java.util.concurrent.BlockingDeque
    public Object pollLast(long j3, TimeUnit timeUnit) {
        return o2().pollLast(j3, timeUnit);
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public void put(Object obj) throws InterruptedException {
        o2().put(obj);
    }

    @Override // java.util.concurrent.BlockingDeque
    public void putFirst(Object obj) throws InterruptedException {
        o2().putFirst(obj);
    }

    @Override // java.util.concurrent.BlockingDeque
    public void putLast(Object obj) throws InterruptedException {
        o2().putLast(obj);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return o2().remainingCapacity();
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public Object take() {
        return o2().take();
    }

    @Override // java.util.concurrent.BlockingDeque
    public Object takeFirst() {
        return o2().takeFirst();
    }

    @Override // java.util.concurrent.BlockingDeque
    public Object takeLast() {
        return o2().takeLast();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection collection, int i3) {
        return o2().drainTo(collection, i3);
    }
}
