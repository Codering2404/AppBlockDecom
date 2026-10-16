package com.applovin.impl;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class bh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f58646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f58647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f58648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f58649d;

    public bh(byte[] bArr, int i3, int i4) {
        a(bArr, i3, i4);
    }

    private void a() {
        int i3;
        int i4 = this.f58648c;
        b1.b(i4 >= 0 && (i4 < (i3 = this.f58647b) || (i4 == i3 && this.f58649d == 0)));
    }

    private int d() {
        int i3 = 0;
        while (!c()) {
            i3++;
        }
        return ((1 << i3) - 1) + (i3 > 0 ? b(i3) : 0);
    }

    public boolean b() {
        int i3 = this.f58648c;
        int i4 = this.f58649d;
        int i5 = 0;
        while (this.f58648c < this.f58647b && !c()) {
            i5++;
        }
        boolean z2 = this.f58648c == this.f58647b;
        this.f58648c = i3;
        this.f58649d = i4;
        return !z2 && a((i5 * 2) + 1);
    }

    public boolean c() {
        boolean z2 = (this.f58646a[this.f58648c] & (ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD >> this.f58649d)) != 0;
        g();
        return z2;
    }

    public int e() {
        int iD = d();
        return (iD % 2 == 0 ? -1 : 1) * ((iD + 1) / 2);
    }

    public int f() {
        return d();
    }

    public void g() {
        int i3 = this.f58649d + 1;
        this.f58649d = i3;
        if (i3 == 8) {
            this.f58649d = 0;
            int i4 = this.f58648c;
            this.f58648c = i4 + (c(i4 + 1) ? 2 : 1);
        }
        a();
    }

    public boolean a(int i3) {
        int i4 = this.f58648c;
        int i5 = i3 / 8;
        int i6 = i4 + i5;
        int i7 = (this.f58649d + i3) - (i5 * 8);
        if (i7 > 7) {
            i6++;
            i7 -= 8;
        }
        while (true) {
            int i8 = i4 + 1;
            if (i8 > i6 || i6 >= this.f58647b) {
                break;
            }
            if (c(i8)) {
                i6++;
                i4 += 3;
            } else {
                i4 = i8;
            }
        }
        int i9 = this.f58647b;
        if (i6 >= i9) {
            return i6 == i9 && i7 == 0;
        }
        return true;
    }

    private boolean c(int i3) {
        if (2 > i3 || i3 >= this.f58647b) {
            return false;
        }
        byte[] bArr = this.f58646a;
        return bArr[i3] == 3 && bArr[i3 + (-2)] == 0 && bArr[i3 - 1] == 0;
    }

    public void d(int i3) {
        int i4 = this.f58648c;
        int i5 = i3 / 8;
        int i6 = i4 + i5;
        this.f58648c = i6;
        int i7 = this.f58649d + (i3 - (i5 * 8));
        this.f58649d = i7;
        if (i7 > 7) {
            this.f58648c = i6 + 1;
            this.f58649d = i7 - 8;
        }
        while (true) {
            i4++;
            if (i4 <= this.f58648c) {
                if (c(i4)) {
                    this.f58648c++;
                    i4 += 2;
                }
            } else {
                a();
                return;
            }
        }
    }

    public void a(byte[] bArr, int i3, int i4) {
        this.f58646a = bArr;
        this.f58648c = i3;
        this.f58647b = i4;
        this.f58649d = 0;
        a();
    }

    public int b(int i3) {
        int i4;
        this.f58649d += i3;
        int i5 = 0;
        while (true) {
            i4 = this.f58649d;
            if (i4 <= 8) {
                break;
            }
            int i6 = i4 - 8;
            this.f58649d = i6;
            byte[] bArr = this.f58646a;
            int i7 = this.f58648c;
            i5 |= (bArr[i7] & 255) << i6;
            if (!c(i7 + 1)) {
                i = 1;
            }
            this.f58648c = i7 + i;
        }
        byte[] bArr2 = this.f58646a;
        int i8 = this.f58648c;
        int i9 = ((-1) >>> (32 - i3)) & (i5 | ((bArr2[i8] & 255) >> (8 - i4)));
        if (i4 == 8) {
            this.f58649d = 0;
            this.f58648c = i8 + (c(i8 + 1) ? 2 : 1);
        }
        a();
        return i9;
    }
}
