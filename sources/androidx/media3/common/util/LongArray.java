package androidx.media3.common.util;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class LongArray {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f41558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long[] f41559b;

    public LongArray() {
        this(32);
    }

    public void a(long j3) {
        int i3 = this.f41558a;
        long[] jArr = this.f41559b;
        if (i3 == jArr.length) {
            this.f41559b = Arrays.copyOf(jArr, i3 * 2);
        }
        long[] jArr2 = this.f41559b;
        int i4 = this.f41558a;
        this.f41558a = i4 + 1;
        jArr2[i4] = j3;
    }

    public void b(long[] jArr) {
        int length = this.f41558a + jArr.length;
        long[] jArr2 = this.f41559b;
        if (length > jArr2.length) {
            this.f41559b = Arrays.copyOf(jArr2, Math.max(jArr2.length * 2, length));
        }
        System.arraycopy(jArr, 0, this.f41559b, this.f41558a, jArr.length);
        this.f41558a = length;
    }

    public long c(int i3) {
        if (i3 >= 0 && i3 < this.f41558a) {
            return this.f41559b[i3];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i3 + ", size is " + this.f41558a);
    }

    public int d() {
        return this.f41558a;
    }

    public long[] e() {
        return Arrays.copyOf(this.f41559b, this.f41558a);
    }

    public LongArray(int i3) {
        this.f41559b = new long[i3];
    }
}
