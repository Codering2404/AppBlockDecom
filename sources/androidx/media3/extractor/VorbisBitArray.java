package androidx.media3.extractor;

import androidx.media3.common.util.Assertions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class VorbisBitArray {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f46238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f46239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f46240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f46241d;

    public VorbisBitArray(byte[] bArr) {
        this.f46238a = bArr;
        this.f46239b = bArr.length;
    }

    private void a() {
        int i3;
        int i4 = this.f46240c;
        Assertions.g(i4 >= 0 && (i4 < (i3 = this.f46239b) || (i4 == i3 && this.f46241d == 0)));
    }

    public int b() {
        return (this.f46240c * 8) + this.f46241d;
    }

    public boolean c() {
        boolean z2 = (((this.f46238a[this.f46240c] & 255) >> this.f46241d) & 1) == 1;
        e(1);
        return z2;
    }

    public int d(int i3) {
        int i4 = this.f46240c;
        int iMin = Math.min(i3, 8 - this.f46241d);
        int i5 = i4 + 1;
        int i6 = ((this.f46238a[i4] & 255) >> this.f46241d) & (255 >> (8 - iMin));
        while (iMin < i3) {
            i6 |= (this.f46238a[i5] & 255) << iMin;
            iMin += 8;
            i5++;
        }
        int i7 = i6 & ((-1) >>> (32 - i3));
        e(i3);
        return i7;
    }

    public void e(int i3) {
        int i4 = i3 / 8;
        int i5 = this.f46240c + i4;
        this.f46240c = i5;
        int i6 = this.f46241d + (i3 - (i4 * 8));
        this.f46241d = i6;
        if (i6 > 7) {
            this.f46240c = i5 + 1;
            this.f46241d = i6 - 8;
        }
        a();
    }
}
