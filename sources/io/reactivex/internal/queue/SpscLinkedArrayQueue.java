package io.reactivex.internal.queue;

import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.Pow2;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SpscLinkedArrayQueue<T> implements SimplePlainQueue<T> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final int f138978j = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Object f138979k = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f138981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f138982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f138983d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    AtomicReferenceArray f138984f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final int f138985g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    AtomicReferenceArray f138986h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AtomicLong f138980a = new AtomicLong();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final AtomicLong f138987i = new AtomicLong();

    public SpscLinkedArrayQueue(int i3) {
        int iA = Pow2.a(Math.max(8, i3));
        int i4 = iA - 1;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(iA + 1);
        this.f138984f = atomicReferenceArray;
        this.f138983d = i4;
        a(iA);
        this.f138986h = atomicReferenceArray;
        this.f138985g = i4;
        this.f138982c = iA - 2;
        v(0L);
    }

    private void a(int i3) {
        this.f138981b = Math.min(i3 / 4, f138978j);
    }

    private static int c(long j3, int i3) {
        return b(((int) j3) & i3);
    }

    private long e() {
        return this.f138987i.get();
    }

    private long g() {
        return this.f138980a.get();
    }

    private long h() {
        return this.f138987i.get();
    }

    private static Object i(AtomicReferenceArray atomicReferenceArray, int i3) {
        return atomicReferenceArray.get(i3);
    }

    private AtomicReferenceArray j(AtomicReferenceArray atomicReferenceArray, int i3) {
        int iB = b(i3);
        AtomicReferenceArray atomicReferenceArray2 = (AtomicReferenceArray) i(atomicReferenceArray, iB);
        t(atomicReferenceArray, iB, null);
        return atomicReferenceArray2;
    }

    private long k() {
        return this.f138980a.get();
    }

    private Object m(AtomicReferenceArray atomicReferenceArray, long j3, int i3) {
        this.f138986h = atomicReferenceArray;
        return i(atomicReferenceArray, c(j3, i3));
    }

    private Object o(AtomicReferenceArray atomicReferenceArray, long j3, int i3) {
        this.f138986h = atomicReferenceArray;
        int iC = c(j3, i3);
        Object objI = i(atomicReferenceArray, iC);
        if (objI != null) {
            t(atomicReferenceArray, iC, null);
            s(j3 + 1);
        }
        return objI;
    }

    private void q(AtomicReferenceArray atomicReferenceArray, long j3, int i3, Object obj, long j4) {
        AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
        this.f138984f = atomicReferenceArray2;
        this.f138982c = (j4 + j3) - 1;
        t(atomicReferenceArray2, i3, obj);
        u(atomicReferenceArray, atomicReferenceArray2);
        t(atomicReferenceArray, i3, f138979k);
        v(j3 + 1);
    }

    private void s(long j3) {
        this.f138987i.lazySet(j3);
    }

    private static void t(AtomicReferenceArray atomicReferenceArray, int i3, Object obj) {
        atomicReferenceArray.lazySet(i3, obj);
    }

    private void u(AtomicReferenceArray atomicReferenceArray, AtomicReferenceArray atomicReferenceArray2) {
        t(atomicReferenceArray, b(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private void v(long j3) {
        this.f138980a.lazySet(j3);
    }

    private boolean w(AtomicReferenceArray atomicReferenceArray, Object obj, long j3, int i3) {
        t(atomicReferenceArray, i3, obj);
        v(j3 + 1);
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return k() == h();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray atomicReferenceArray = this.f138984f;
        long jG = g();
        int i3 = this.f138983d;
        int iC = c(jG, i3);
        if (jG < this.f138982c) {
            return w(atomicReferenceArray, obj, jG, iC);
        }
        long j3 = ((long) this.f138981b) + jG;
        if (i(atomicReferenceArray, c(j3, i3)) == null) {
            this.f138982c = j3 - 1;
            return w(atomicReferenceArray, obj, jG, iC);
        }
        if (i(atomicReferenceArray, c(jG + 1, i3)) == null) {
            return w(atomicReferenceArray, obj, jG, iC);
        }
        q(atomicReferenceArray, jG, iC, obj, i3);
        return true;
    }

    public boolean p(Object obj, Object obj2) {
        AtomicReferenceArray atomicReferenceArray = this.f138984f;
        long jK = k();
        int i3 = this.f138983d;
        long j3 = 2 + jK;
        if (i(atomicReferenceArray, c(j3, i3)) == null) {
            int iC = c(jK, i3);
            t(atomicReferenceArray, iC + 1, obj2);
            t(atomicReferenceArray, iC, obj);
            v(j3);
            return true;
        }
        AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
        this.f138984f = atomicReferenceArray2;
        int iC2 = c(jK, i3);
        t(atomicReferenceArray2, iC2 + 1, obj2);
        t(atomicReferenceArray2, iC2, obj);
        u(atomicReferenceArray, atomicReferenceArray2);
        t(atomicReferenceArray, iC2, f138979k);
        v(j3);
        return true;
    }

    public Object peek() {
        AtomicReferenceArray atomicReferenceArray = this.f138986h;
        long jE = e();
        int i3 = this.f138985g;
        Object objI = i(atomicReferenceArray, c(jE, i3));
        return objI == f138979k ? m(j(atomicReferenceArray, i3 + 1), jE, i3) : objI;
    }

    @Override // io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.internal.fuseable.SimpleQueue
    public Object poll() {
        AtomicReferenceArray atomicReferenceArray = this.f138986h;
        long jE = e();
        int i3 = this.f138985g;
        int iC = c(jE, i3);
        Object objI = i(atomicReferenceArray, iC);
        boolean z2 = objI == f138979k;
        if (objI == null || z2) {
            if (z2) {
                return o(j(atomicReferenceArray, i3 + 1), jE, i3);
            }
            return null;
        }
        t(atomicReferenceArray, iC, null);
        s(jE + 1);
        return objI;
    }

    public int r() {
        long jH = h();
        while (true) {
            long jK = k();
            long jH2 = h();
            if (jH == jH2) {
                return (int) (jK - jH2);
            }
            jH = jH2;
        }
    }

    private static int b(int i3) {
        return i3;
    }
}
