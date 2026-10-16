package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class cr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f59018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f59019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f59020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f59021d;

    public cr(byte[] bArr) {
        this.f59018a = bArr;
        this.f59019b = bArr.length;
    }

    private void a() {
        int i3;
        int i4 = this.f59020c;
        b1.b(i4 >= 0 && (i4 < (i3 = this.f59019b) || (i4 == i3 && this.f59021d == 0)));
    }

    public int b() {
        return (this.f59020c * 8) + this.f59021d;
    }

    public boolean c() {
        boolean z2 = (((this.f59018a[this.f59020c] & 255) >> this.f59021d) & 1) == 1;
        b(1);
        return z2;
    }

    public int a(int i3) {
        int i4 = this.f59020c;
        int iMin = Math.min(i3, 8 - this.f59021d);
        int i5 = i4 + 1;
        int i6 = ((this.f59018a[i4] & 255) >> this.f59021d) & (255 >> (8 - iMin));
        while (iMin < i3) {
            i6 |= (this.f59018a[i5] & 255) << iMin;
            iMin += 8;
            i5++;
        }
        int i7 = i6 & ((-1) >>> (32 - i3));
        b(i3);
        return i7;
    }

    public void b(int i3) {
        int i4 = i3 / 8;
        int i5 = this.f59020c + i4;
        this.f59020c = i5;
        int i6 = this.f59021d + (i3 - (i4 * 8));
        this.f59021d = i6;
        if (i6 > 7) {
            this.f59020c = i5 + 1;
            this.f59021d = i6 - 8;
        }
        a();
    }
}
