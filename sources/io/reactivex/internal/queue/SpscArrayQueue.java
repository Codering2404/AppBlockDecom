package io.reactivex.internal.queue;

import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.Pow2;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements SimplePlainQueue<E> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Integer f138972g = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    private static final long serialVersionUID = -1296597691183856449L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f138973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicLong f138974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f138975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final AtomicLong f138976d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f138977f;

    public SpscArrayQueue(int i3) {
        super(Pow2.a(i3));
        this.f138973a = length() - 1;
        this.f138974b = new AtomicLong();
        this.f138976d = new AtomicLong();
        this.f138977f = Math.min(i3 / 4, f138972g.intValue());
    }

    int a(long j3) {
        return ((int) j3) & this.f138973a;
    }

    int b(long j3, int i3) {
        return ((int) j3) & i3;
    }

    Object c(int i3) {
        return get(i3);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    void e(long j3) {
        this.f138976d.lazySet(j3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void g(int i3, Object obj) {
        lazySet(i3, obj);
    }

    void h(long j3) {
        this.f138974b.lazySet(j3);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return this.f138974b.get() == this.f138976d.get();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        int i3 = this.f138973a;
        long j3 = this.f138974b.get();
        int iB = b(j3, i3);
        if (j3 >= this.f138975c) {
            long j4 = ((long) this.f138977f) + j3;
            if (c(b(j4, i3)) == null) {
                this.f138975c = j4;
            } else if (c(iB) != null) {
                return false;
            }
        }
        g(iB, obj);
        h(j3 + 1);
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.internal.fuseable.SimpleQueue
    public Object poll() {
        long j3 = this.f138976d.get();
        int iA = a(j3);
        Object objC = c(iA);
        if (objC == null) {
            return null;
        }
        e(j3 + 1);
        g(iA, null);
        return objC;
    }
}
