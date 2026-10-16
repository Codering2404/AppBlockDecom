package com.applovin.impl;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f65436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f65437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f65438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f65439d;

    public zg() {
        this.f65436a = xp.f65032f;
    }

    private void a() {
        int i3;
        int i4 = this.f65437b;
        b1.b(i4 >= 0 && (i4 < (i3 = this.f65439d) || (i4 == i3 && this.f65438c == 0)));
    }

    public int b() {
        return ((this.f65439d - this.f65437b) * 8) - this.f65438c;
    }

    public void c() {
        if (this.f65438c == 0) {
            return;
        }
        this.f65438c = 0;
        this.f65437b++;
        a();
    }

    public int d() {
        b1.b(this.f65438c == 0);
        return this.f65437b;
    }

    public int e() {
        return (this.f65437b * 8) + this.f65438c;
    }

    public boolean f() {
        boolean z2 = (this.f65436a[this.f65437b] & (ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD >> this.f65438c)) != 0;
        g();
        return z2;
    }

    public void g() {
        int i3 = this.f65438c + 1;
        this.f65438c = i3;
        if (i3 == 8) {
            this.f65438c = 0;
            this.f65437b++;
        }
        a();
    }

    public void a(int i3, int i4) {
        if (i4 < 32) {
            i3 &= (1 << i4) - 1;
        }
        int iMin = Math.min(8 - this.f65438c, i4);
        int i5 = this.f65438c;
        int i6 = (8 - i5) - iMin;
        byte[] bArr = this.f65436a;
        int i7 = this.f65437b;
        byte b3 = (byte) (((65280 >> i5) | ((1 << i6) - 1)) & bArr[i7]);
        bArr[i7] = b3;
        int i8 = i4 - iMin;
        bArr[i7] = (byte) (b3 | ((i3 >>> i8) << i6));
        int i9 = i7 + 1;
        while (i8 > 8) {
            this.f65436a[i9] = (byte) (i3 >>> (i8 - 8));
            i8 -= 8;
            i9++;
        }
        int i10 = 8 - i8;
        byte[] bArr2 = this.f65436a;
        byte b4 = (byte) (bArr2[i9] & ((1 << i10) - 1));
        bArr2[i9] = b4;
        bArr2[i9] = (byte) (((i3 & ((1 << i8) - 1)) << i10) | b4);
        d(i4);
        a();
    }

    public long b(int i3) {
        return i3 <= 32 ? xp.i(a(i3)) : xp.c(a(i3 - 32), a(32));
    }

    public void e(int i3) {
        b1.b(this.f65438c == 0);
        this.f65437b += i3;
        a();
    }

    public zg(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public void d(int i3) {
        int i4 = i3 / 8;
        int i5 = this.f65437b + i4;
        this.f65437b = i5;
        int i6 = this.f65438c + (i3 - (i4 * 8));
        this.f65438c = i6;
        if (i6 > 7) {
            this.f65437b = i5 + 1;
            this.f65438c = i6 - 8;
        }
        a();
    }

    public zg(byte[] bArr, int i3) {
        this.f65436a = bArr;
        this.f65439d = i3;
    }

    public void b(byte[] bArr, int i3, int i4) {
        b1.b(this.f65438c == 0);
        System.arraycopy(this.f65436a, this.f65437b, bArr, i3, i4);
        this.f65437b += i4;
        a();
    }

    public void c(int i3) {
        int i4 = i3 / 8;
        this.f65437b = i4;
        this.f65438c = i3 - (i4 * 8);
        a();
    }

    public int a(int i3) {
        int i4;
        if (i3 == 0) {
            return 0;
        }
        this.f65438c += i3;
        int i5 = 0;
        while (true) {
            i4 = this.f65438c;
            if (i4 <= 8) {
                break;
            }
            int i6 = i4 - 8;
            this.f65438c = i6;
            byte[] bArr = this.f65436a;
            int i7 = this.f65437b;
            this.f65437b = i7 + 1;
            i5 |= (bArr[i7] & 255) << i6;
        }
        byte[] bArr2 = this.f65436a;
        int i8 = this.f65437b;
        int i9 = ((-1) >>> (32 - i3)) & (i5 | ((bArr2[i8] & 255) >> (8 - i4)));
        if (i4 == 8) {
            this.f65438c = 0;
            this.f65437b = i8 + 1;
        }
        a();
        return i9;
    }

    public void a(byte[] bArr, int i3, int i4) {
        int i5 = (i4 >> 3) + i3;
        while (i3 < i5) {
            byte[] bArr2 = this.f65436a;
            int i6 = this.f65437b;
            int i7 = i6 + 1;
            this.f65437b = i7;
            byte b3 = bArr2[i6];
            int i8 = this.f65438c;
            byte b4 = (byte) (b3 << i8);
            bArr[i3] = b4;
            bArr[i3] = (byte) (((255 & bArr2[i7]) >> (8 - i8)) | b4);
            i3++;
        }
        int i9 = i4 & 7;
        if (i9 == 0) {
            return;
        }
        byte b5 = (byte) (bArr[i5] & (255 >> i9));
        bArr[i5] = b5;
        int i10 = this.f65438c;
        if (i10 + i9 > 8) {
            byte[] bArr3 = this.f65436a;
            int i11 = this.f65437b;
            this.f65437b = i11 + 1;
            bArr[i5] = (byte) (b5 | ((bArr3[i11] & 255) << i10));
            this.f65438c = i10 - 8;
        }
        int i12 = this.f65438c + i9;
        this.f65438c = i12;
        byte[] bArr4 = this.f65436a;
        int i13 = this.f65437b;
        bArr[i5] = (byte) (((byte) (((255 & bArr4[i13]) >> (8 - i12)) << (8 - i9))) | bArr[i5]);
        if (i12 == 8) {
            this.f65438c = 0;
            this.f65437b = i13 + 1;
        }
        a();
    }

    public String a(int i3, Charset charset) {
        byte[] bArr = new byte[i3];
        b(bArr, 0, i3);
        return new String(bArr, charset);
    }

    public void a(ah ahVar) {
        a(ahVar.c(), ahVar.e());
        c(ahVar.d() * 8);
    }

    public void a(byte[] bArr) {
        a(bArr, bArr.length);
    }

    public void a(byte[] bArr, int i3) {
        this.f65436a = bArr;
        this.f65437b = 0;
        this.f65438c = 0;
        this.f65439d = i3;
    }
}
