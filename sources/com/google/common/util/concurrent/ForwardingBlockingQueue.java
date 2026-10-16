package com.google.common.util.concurrent;

import com.google.common.collect.ForwardingQueue;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingBlockingQueue<E> extends ForwardingQueue<E> implements BlockingQueue<E> {
    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection collection, int i3) {
        return o2().drainTo(collection, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingQueue
    /* JADX INFO: renamed from: m2, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public abstract BlockingQueue k2();

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(Object obj, long j3, TimeUnit timeUnit) {
        return o2().offer(obj, j3, timeUnit);
    }

    @Override // java.util.concurrent.BlockingQueue
    public Object poll(long j3, TimeUnit timeUnit) {
        return o2().poll(j3, timeUnit);
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(Object obj) throws InterruptedException {
        o2().put(obj);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return o2().remainingCapacity();
    }

    @Override // java.util.concurrent.BlockingQueue
    public Object take() {
        return o2().take();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection collection) {
        return o2().drainTo(collection);
    }
}
