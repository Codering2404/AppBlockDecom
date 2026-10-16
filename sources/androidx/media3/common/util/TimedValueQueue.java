package androidx.media3.common.util;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class TimedValueQueue<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long[] f41601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object[] f41602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f41603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f41604d;

    public TimedValueQueue() {
        this(10);
    }

    private void b(long j3, Object obj) {
        int i3 = this.f41603c;
        int i4 = this.f41604d;
        Object[] objArr = this.f41602b;
        int length = (i3 + i4) % objArr.length;
        this.f41601a[length] = j3;
        objArr[length] = obj;
        this.f41604d = i4 + 1;
    }

    private void d(long j3) {
        if (this.f41604d > 0) {
            if (j3 <= this.f41601a[((this.f41603c + r0) - 1) % this.f41602b.length]) {
                c();
            }
        }
    }

    private void e() {
        int length = this.f41602b.length;
        if (this.f41604d < length) {
            return;
        }
        int i3 = length * 2;
        long[] jArr = new long[i3];
        Object[] objArrF = f(i3);
        int i4 = this.f41603c;
        int i5 = length - i4;
        System.arraycopy(this.f41601a, i4, jArr, 0, i5);
        System.arraycopy(this.f41602b, this.f41603c, objArrF, 0, i5);
        int i6 = this.f41603c;
        if (i6 > 0) {
            System.arraycopy(this.f41601a, 0, jArr, i5, i6);
            System.arraycopy(this.f41602b, 0, objArrF, i5, this.f41603c);
        }
        this.f41601a = jArr;
        this.f41602b = objArrF;
        this.f41603c = 0;
    }

    private static Object[] f(int i3) {
        return new Object[i3];
    }

    private Object h(long j3, boolean z2) {
        Object objK = null;
        long j4 = Long.MAX_VALUE;
        while (this.f41604d > 0) {
            long j5 = j3 - this.f41601a[this.f41603c];
            if (j5 < 0 && (z2 || (-j5) >= j4)) {
                break;
            }
            objK = k();
            j4 = j5;
        }
        return objK;
    }

    private Object k() {
        Assertions.g(this.f41604d > 0);
        Object[] objArr = this.f41602b;
        int i3 = this.f41603c;
        Object obj = objArr[i3];
        objArr[i3] = null;
        this.f41603c = (i3 + 1) % objArr.length;
        this.f41604d--;
        return obj;
    }

    public synchronized void a(long j3, Object obj) {
        d(j3);
        e();
        b(j3, obj);
    }

    public synchronized void c() {
        this.f41603c = 0;
        this.f41604d = 0;
        Arrays.fill(this.f41602b, (Object) null);
    }

    public synchronized Object g(long j3) {
        return h(j3, false);
    }

    public synchronized Object i() {
        return this.f41604d == 0 ? null : k();
    }

    public synchronized Object j(long j3) {
        return h(j3, true);
    }

    public synchronized int l() {
        return this.f41604d;
    }

    public TimedValueQueue(int i3) {
        this.f41601a = new long[i3];
        this.f41602b = f(i3);
    }
}
