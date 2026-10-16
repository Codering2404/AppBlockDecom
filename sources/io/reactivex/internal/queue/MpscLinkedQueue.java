package io.reactivex.internal.queue;

import io.reactivex.internal.fuseable.SimplePlainQueue;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MpscLinkedQueue<T> implements SimplePlainQueue<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference f138969a = new AtomicReference();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicReference f138970b = new AtomicReference();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
        private static final long serialVersionUID = 2404266111789071508L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Object f138971a;

        LinkedQueueNode() {
        }

        public Object a() {
            Object objB = b();
            e(null);
            return objB;
        }

        public Object b() {
            return this.f138971a;
        }

        public LinkedQueueNode c() {
            return get();
        }

        public void d(LinkedQueueNode linkedQueueNode) {
            lazySet(linkedQueueNode);
        }

        public void e(Object obj) {
            this.f138971a = obj;
        }

        LinkedQueueNode(Object obj) {
            e(obj);
        }
    }

    public MpscLinkedQueue() {
        LinkedQueueNode linkedQueueNode = new LinkedQueueNode();
        e(linkedQueueNode);
        g(linkedQueueNode);
    }

    LinkedQueueNode a() {
        return (LinkedQueueNode) this.f138970b.get();
    }

    LinkedQueueNode b() {
        return (LinkedQueueNode) this.f138970b.get();
    }

    LinkedQueueNode c() {
        return (LinkedQueueNode) this.f138969a.get();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    void e(LinkedQueueNode linkedQueueNode) {
        this.f138970b.lazySet(linkedQueueNode);
    }

    LinkedQueueNode g(LinkedQueueNode linkedQueueNode) {
        return (LinkedQueueNode) this.f138969a.getAndSet(linkedQueueNode);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return b() == c();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        LinkedQueueNode linkedQueueNode = new LinkedQueueNode(obj);
        g(linkedQueueNode).d(linkedQueueNode);
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.internal.fuseable.SimpleQueue
    public Object poll() {
        LinkedQueueNode linkedQueueNodeC;
        LinkedQueueNode linkedQueueNodeA = a();
        LinkedQueueNode linkedQueueNodeC2 = linkedQueueNodeA.c();
        if (linkedQueueNodeC2 != null) {
            Object objA = linkedQueueNodeC2.a();
            e(linkedQueueNodeC2);
            return objA;
        }
        if (linkedQueueNodeA == c()) {
            return null;
        }
        do {
            linkedQueueNodeC = linkedQueueNodeA.c();
        } while (linkedQueueNodeC == null);
        Object objA2 = linkedQueueNodeC.a();
        e(linkedQueueNodeC);
        return objA2;
    }
}
