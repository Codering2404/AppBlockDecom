package androidx.media3.common.util;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class LongArrayQueue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f41560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f41561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f41562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long[] f41563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f41564e;

    public LongArrayQueue() {
        this(16);
    }

    private void c() {
        long[] jArr = this.f41563d;
        int length = jArr.length << 1;
        if (length < 0) {
            throw new IllegalStateException();
        }
        long[] jArr2 = new long[length];
        int length2 = jArr.length;
        int i3 = this.f41560a;
        int i4 = length2 - i3;
        System.arraycopy(jArr, i3, jArr2, 0, i4);
        System.arraycopy(this.f41563d, 0, jArr2, i4, i3);
        this.f41560a = 0;
        this.f41561b = this.f41562c - 1;
        this.f41563d = jArr2;
        this.f41564e = jArr2.length - 1;
    }

    public void a(long j3) {
        if (this.f41562c == this.f41563d.length) {
            c();
        }
        int i3 = (this.f41561b + 1) & this.f41564e;
        this.f41561b = i3;
        this.f41563d[i3] = j3;
        this.f41562c++;
    }

    public void b() {
        this.f41560a = 0;
        this.f41561b = -1;
        this.f41562c = 0;
    }

    public long d() {
        if (this.f41562c != 0) {
            return this.f41563d[this.f41560a];
        }
        throw new NoSuchElementException();
    }

    public boolean e() {
        return this.f41562c == 0;
    }

    public long f() {
        int i3 = this.f41562c;
        if (i3 == 0) {
            throw new NoSuchElementException();
        }
        long[] jArr = this.f41563d;
        int i4 = this.f41560a;
        long j3 = jArr[i4];
        this.f41560a = this.f41564e & (i4 + 1);
        this.f41562c = i3 - 1;
        return j3;
    }

    public LongArrayQueue(int i3) {
        Assertions.a(i3 >= 0 && i3 <= 1073741824);
        i3 = i3 == 0 ? 1 : i3;
        i3 = Integer.bitCount(i3) != 1 ? Integer.highestOneBit(i3 - 1) << 1 : i3;
        this.f41560a = 0;
        this.f41561b = -1;
        this.f41562c = 0;
        long[] jArr = new long[i3];
        this.f41563d = jArr;
        this.f41564e = jArr.length - 1;
    }
}
