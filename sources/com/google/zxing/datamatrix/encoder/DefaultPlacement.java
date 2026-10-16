package com.google.zxing.datamatrix.encoder;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class DefaultPlacement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CharSequence f91870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f91871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f91872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f91873d;

    public DefaultPlacement(CharSequence charSequence, int i3, int i4) {
        this.f91870a = charSequence;
        this.f91872c = i3;
        this.f91871b = i4;
        byte[] bArr = new byte[i3 * i4];
        this.f91873d = bArr;
        Arrays.fill(bArr, (byte) -1);
    }

    private void a(int i3) {
        g(this.f91871b - 1, 0, i3, 1);
        g(this.f91871b - 1, 1, i3, 2);
        g(this.f91871b - 1, 2, i3, 3);
        g(0, this.f91872c - 2, i3, 4);
        g(0, this.f91872c - 1, i3, 5);
        g(1, this.f91872c - 1, i3, 6);
        g(2, this.f91872c - 1, i3, 7);
        g(3, this.f91872c - 1, i3, 8);
    }

    private void b(int i3) {
        g(this.f91871b - 3, 0, i3, 1);
        g(this.f91871b - 2, 0, i3, 2);
        g(this.f91871b - 1, 0, i3, 3);
        g(0, this.f91872c - 4, i3, 4);
        g(0, this.f91872c - 3, i3, 5);
        g(0, this.f91872c - 2, i3, 6);
        g(0, this.f91872c - 1, i3, 7);
        g(1, this.f91872c - 1, i3, 8);
    }

    private void c(int i3) {
        g(this.f91871b - 3, 0, i3, 1);
        g(this.f91871b - 2, 0, i3, 2);
        g(this.f91871b - 1, 0, i3, 3);
        g(0, this.f91872c - 2, i3, 4);
        g(0, this.f91872c - 1, i3, 5);
        g(1, this.f91872c - 1, i3, 6);
        g(2, this.f91872c - 1, i3, 7);
        g(3, this.f91872c - 1, i3, 8);
    }

    private void d(int i3) {
        g(this.f91871b - 1, 0, i3, 1);
        g(this.f91871b - 1, this.f91872c - 1, i3, 2);
        g(0, this.f91872c - 3, i3, 3);
        g(0, this.f91872c - 2, i3, 4);
        g(0, this.f91872c - 1, i3, 5);
        g(1, this.f91872c - 3, i3, 6);
        g(1, this.f91872c - 2, i3, 7);
        g(1, this.f91872c - 1, i3, 8);
    }

    private boolean f(int i3, int i4) {
        return this.f91873d[(i4 * this.f91872c) + i3] >= 0;
    }

    private void g(int i3, int i4, int i5, int i6) {
        if (i3 < 0) {
            int i7 = this.f91871b;
            i3 += i7;
            i4 += 4 - ((i7 + 4) % 8);
        }
        if (i4 < 0) {
            int i8 = this.f91872c;
            i4 += i8;
            i3 += 4 - ((i8 + 4) % 8);
        }
        i(i4, i3, (this.f91870a.charAt(i5) & (1 << (8 - i6))) != 0);
    }

    private void i(int i3, int i4, boolean z2) {
        this.f91873d[(i4 * this.f91872c) + i3] = z2 ? (byte) 1 : (byte) 0;
    }

    private void j(int i3, int i4, int i5) {
        int i6 = i3 - 2;
        int i7 = i4 - 2;
        g(i6, i7, i5, 1);
        int i8 = i4 - 1;
        g(i6, i8, i5, 2);
        int i9 = i3 - 1;
        g(i9, i7, i5, 3);
        g(i9, i8, i5, 4);
        g(i9, i4, i5, 5);
        g(i3, i7, i5, 6);
        g(i3, i8, i5, 7);
        g(i3, i4, i5, 8);
    }

    public final boolean e(int i3, int i4) {
        return this.f91873d[(i4 * this.f91872c) + i3] == 1;
    }

    public final void h() {
        int i3;
        int i4;
        int i5 = 0;
        int i6 = 0;
        int i7 = 4;
        while (true) {
            if (i7 == this.f91871b && i5 == 0) {
                a(i6);
                i6++;
            }
            if (i7 == this.f91871b - 2 && i5 == 0 && this.f91872c % 4 != 0) {
                b(i6);
                i6++;
            }
            if (i7 == this.f91871b - 2 && i5 == 0 && this.f91872c % 8 == 4) {
                c(i6);
                i6++;
            }
            if (i7 == this.f91871b + 4 && i5 == 2 && this.f91872c % 8 == 0) {
                d(i6);
                i6++;
            }
            while (true) {
                if (i7 < this.f91871b && i5 >= 0 && !f(i5, i7)) {
                    j(i7, i5, i6);
                    i6++;
                }
                int i8 = i7 - 2;
                int i9 = i5 + 2;
                if (i8 < 0 || i9 >= this.f91872c) {
                    break;
                }
                i7 = i8;
                i5 = i9;
            }
            int i10 = i7 - 1;
            int i11 = i5 + 5;
            while (true) {
                if (i10 >= 0 && i11 < this.f91872c && !f(i11, i10)) {
                    j(i10, i11, i6);
                    i6++;
                }
                int i12 = i10 + 2;
                int i13 = i11 - 2;
                i3 = this.f91871b;
                if (i12 >= i3 || i13 < 0) {
                    break;
                }
                i10 = i12;
                i11 = i13;
            }
            i7 = i10 + 5;
            i5 = i11 - 1;
            if (i7 >= i3 && i5 >= (i4 = this.f91872c)) {
                break;
            }
        }
        if (f(i4 - 1, i3 - 1)) {
            return;
        }
        i(this.f91872c - 1, this.f91871b - 1, true);
        i(this.f91872c - 2, this.f91871b - 2, true);
    }
}
