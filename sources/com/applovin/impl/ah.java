package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Charsets;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f58387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f58388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f58389c;

    public ah() {
        this.f58387a = xp.f65032f;
    }

    public int A() {
        int iJ = j();
        if (iJ >= 0) {
            return iJ;
        }
        throw new IllegalStateException("Top bit not zero: " + iJ);
    }

    public long B() {
        long jS = s();
        if (jS >= 0) {
            return jS;
        }
        throw new IllegalStateException("Top bit not zero: " + jS);
    }

    public int C() {
        byte[] bArr = this.f58387a;
        int i3 = this.f58388b;
        int i4 = i3 + 1;
        int i5 = (bArr[i3] & 255) << 8;
        this.f58388b = i3 + 2;
        return (bArr[i4] & 255) | i5;
    }

    public long D() {
        int i3;
        int i4;
        long j3 = this.f58387a[this.f58388b];
        int i5 = 7;
        while (true) {
            if (i5 < 0) {
                break;
            }
            int i6 = 1 << i5;
            if ((((long) i6) & j3) != 0) {
                i5--;
            } else if (i5 < 6) {
                j3 &= (long) (i6 - 1);
                i4 = 7 - i5;
            } else if (i5 == 7) {
                i4 = 1;
            }
        }
        i4 = 0;
        if (i4 == 0) {
            throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j3);
        }
        for (i3 = 1; i3 < i4; i3++) {
            byte b3 = this.f58387a[this.f58388b + i3];
            if ((b3 & 192) != 128) {
                throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j3);
            }
            j3 = (j3 << 6) | ((long) (b3 & 63));
        }
        this.f58388b += i4;
        return j3;
    }

    public int a() {
        return this.f58389c - this.f58388b;
    }

    public int b() {
        return this.f58387a.length;
    }

    public byte[] c() {
        return this.f58387a;
    }

    public int d() {
        return this.f58388b;
    }

    public int e() {
        return this.f58389c;
    }

    public char f() {
        byte[] bArr = this.f58387a;
        int i3 = this.f58388b;
        return (char) ((bArr[i3 + 1] & 255) | ((bArr[i3] & 255) << 8));
    }

    public int g() {
        return this.f58387a[this.f58388b] & 255;
    }

    public double h() {
        return Double.longBitsToDouble(s());
    }

    public float i() {
        return Float.intBitsToFloat(j());
    }

    public int j() {
        byte[] bArr = this.f58387a;
        int i3 = this.f58388b;
        int i4 = ((bArr[i3 + 1] & 255) << 16) | ((bArr[i3] & 255) << 24);
        int i5 = i3 + 3;
        int i6 = i4 | ((bArr[i3 + 2] & 255) << 8);
        this.f58388b = i3 + 4;
        return (bArr[i5] & 255) | i6;
    }

    public int k() {
        byte[] bArr = this.f58387a;
        int i3 = this.f58388b;
        int i4 = i3 + 2;
        int i5 = ((bArr[i3 + 1] & 255) << 8) | (((bArr[i3] & 255) << 24) >> 8);
        this.f58388b = i3 + 3;
        return (bArr[i4] & 255) | i5;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String l() {
        /*
            r6 = this;
            int r0 = r6.a()
            if (r0 != 0) goto L8
            r0 = 0
            return r0
        L8:
            int r0 = r6.f58388b
        La:
            int r1 = r6.f58389c
            if (r0 >= r1) goto L1b
            byte[] r1 = r6.f58387a
            r1 = r1[r0]
            boolean r1 = com.applovin.impl.xp.h(r1)
            if (r1 != 0) goto L1b
            int r0 = r0 + 1
            goto La
        L1b:
            int r1 = r6.f58388b
            int r2 = r0 - r1
            r3 = 3
            if (r2 < r3) goto L3d
            byte[] r2 = r6.f58387a
            r4 = r2[r1]
            r5 = -17
            if (r4 != r5) goto L3d
            int r4 = r1 + 1
            r4 = r2[r4]
            r5 = -69
            if (r4 != r5) goto L3d
            int r4 = r1 + 2
            r2 = r2[r4]
            r4 = -65
            if (r2 != r4) goto L3d
            int r1 = r1 + r3
            r6.f58388b = r1
        L3d:
            byte[] r1 = r6.f58387a
            int r2 = r6.f58388b
            int r3 = r0 - r2
            java.lang.String r1 = com.applovin.impl.xp.a(r1, r2, r3)
            r6.f58388b = r0
            int r2 = r6.f58389c
            if (r0 != r2) goto L4e
            goto L69
        L4e:
            byte[] r3 = r6.f58387a
            r4 = r3[r0]
            r5 = 13
            if (r4 != r5) goto L5d
            int r0 = r0 + 1
            r6.f58388b = r0
            if (r0 != r2) goto L5d
            goto L69
        L5d:
            int r0 = r6.f58388b
            r2 = r3[r0]
            r3 = 10
            if (r2 != r3) goto L69
            int r0 = r0 + 1
            r6.f58388b = r0
        L69:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.ah.l():java.lang.String");
    }

    public int m() {
        byte[] bArr = this.f58387a;
        int i3 = this.f58388b;
        int i4 = ((bArr[i3 + 1] & 255) << 8) | (bArr[i3] & 255);
        int i5 = i3 + 3;
        int i6 = i4 | ((bArr[i3 + 2] & 255) << 16);
        this.f58388b = i3 + 4;
        return ((bArr[i5] & 255) << 24) | i6;
    }

    public long n() {
        byte[] bArr = this.f58387a;
        int i3 = this.f58388b;
        int i4 = i3 + 7;
        long j3 = (((long) bArr[i3]) & 255) | ((((long) bArr[i3 + 1]) & 255) << 8) | ((((long) bArr[i3 + 2]) & 255) << 16) | ((((long) bArr[i3 + 3]) & 255) << 24) | ((((long) bArr[i3 + 4]) & 255) << 32) | ((((long) bArr[i3 + 5]) & 255) << 40) | ((((long) bArr[i3 + 6]) & 255) << 48);
        this.f58388b = i3 + 8;
        return ((((long) bArr[i4]) & 255) << 56) | j3;
    }

    public short o() {
        byte[] bArr = this.f58387a;
        int i3 = this.f58388b;
        int i4 = i3 + 1;
        int i5 = bArr[i3] & 255;
        this.f58388b = i3 + 2;
        return (short) (((bArr[i4] & 255) << 8) | i5);
    }

    public long p() {
        byte[] bArr = this.f58387a;
        int i3 = this.f58388b;
        int i4 = i3 + 3;
        long j3 = (((long) bArr[i3]) & 255) | ((((long) bArr[i3 + 1]) & 255) << 8) | ((((long) bArr[i3 + 2]) & 255) << 16);
        this.f58388b = i3 + 4;
        return ((((long) bArr[i4]) & 255) << 24) | j3;
    }

    public int q() {
        int iM = m();
        if (iM >= 0) {
            return iM;
        }
        throw new IllegalStateException("Top bit not zero: " + iM);
    }

    public int r() {
        byte[] bArr = this.f58387a;
        int i3 = this.f58388b;
        int i4 = i3 + 1;
        int i5 = bArr[i3] & 255;
        this.f58388b = i3 + 2;
        return ((bArr[i4] & 255) << 8) | i5;
    }

    public long s() {
        byte[] bArr = this.f58387a;
        int i3 = this.f58388b;
        int i4 = i3 + 7;
        long j3 = ((((long) bArr[i3]) & 255) << 56) | ((((long) bArr[i3 + 1]) & 255) << 48) | ((((long) bArr[i3 + 2]) & 255) << 40) | ((((long) bArr[i3 + 3]) & 255) << 32) | ((((long) bArr[i3 + 4]) & 255) << 24) | ((((long) bArr[i3 + 5]) & 255) << 16) | ((((long) bArr[i3 + 6]) & 255) << 8);
        this.f58388b = i3 + 8;
        return (((long) bArr[i4]) & 255) | j3;
    }

    public String t() {
        return a((char) 0);
    }

    public short u() {
        byte[] bArr = this.f58387a;
        int i3 = this.f58388b;
        int i4 = i3 + 1;
        int i5 = (bArr[i3] & 255) << 8;
        this.f58388b = i3 + 2;
        return (short) ((bArr[i4] & 255) | i5);
    }

    public int v() {
        return (w() << 21) | (w() << 14) | (w() << 7) | w();
    }

    public int w() {
        byte[] bArr = this.f58387a;
        int i3 = this.f58388b;
        this.f58388b = i3 + 1;
        return bArr[i3] & 255;
    }

    public int x() {
        byte[] bArr = this.f58387a;
        int i3 = this.f58388b;
        int i4 = (bArr[i3 + 1] & 255) | ((bArr[i3] & 255) << 8);
        this.f58388b = i3 + 4;
        return i4;
    }

    public long y() {
        byte[] bArr = this.f58387a;
        int i3 = this.f58388b;
        int i4 = i3 + 3;
        long j3 = ((((long) bArr[i3]) & 255) << 24) | ((((long) bArr[i3 + 1]) & 255) << 16) | ((((long) bArr[i3 + 2]) & 255) << 8);
        this.f58388b = i3 + 4;
        return (((long) bArr[i4]) & 255) | j3;
    }

    public int z() {
        byte[] bArr = this.f58387a;
        int i3 = this.f58388b;
        int i4 = i3 + 2;
        int i5 = ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3] & 255) << 16);
        this.f58388b = i3 + 3;
        return (bArr[i4] & 255) | i5;
    }

    public void a(int i3) {
        if (i3 > b()) {
            this.f58387a = Arrays.copyOf(this.f58387a, i3);
        }
    }

    public String b(int i3) {
        if (i3 == 0) {
            return "";
        }
        int i4 = this.f58388b;
        int i5 = (i4 + i3) - 1;
        String strA = xp.a(this.f58387a, i4, (i5 >= this.f58389c || this.f58387a[i5] != 0) ? i3 : i3 - 1);
        this.f58388b += i3;
        return strA;
    }

    public String c(int i3) {
        return a(i3, Charsets.UTF_8);
    }

    public void d(int i3) {
        a(b() < i3 ? new byte[i3] : this.f58387a, i3);
    }

    public void e(int i3) {
        b1.a(i3 >= 0 && i3 <= this.f58387a.length);
        this.f58389c = i3;
    }

    public void f(int i3) {
        b1.a(i3 >= 0 && i3 <= this.f58389c);
        this.f58388b = i3;
    }

    public void g(int i3) {
        f(this.f58388b + i3);
    }

    public ah(int i3) {
        this.f58387a = new byte[i3];
        this.f58389c = i3;
    }

    public void a(zg zgVar, int i3) {
        a(zgVar.f65436a, 0, i3);
        zgVar.c(0);
    }

    public ah(byte[] bArr) {
        this.f58387a = bArr;
        this.f58389c = bArr.length;
    }

    public void a(byte[] bArr, int i3, int i4) {
        System.arraycopy(this.f58387a, this.f58388b, bArr, i3, i4);
        this.f58388b += i4;
    }

    public String a(char c3) {
        if (a() == 0) {
            return null;
        }
        int i3 = this.f58388b;
        while (i3 < this.f58389c && this.f58387a[i3] != c3) {
            i3++;
        }
        byte[] bArr = this.f58387a;
        int i4 = this.f58388b;
        String strA = xp.a(bArr, i4, i3 - i4);
        this.f58388b = i3;
        if (i3 < this.f58389c) {
            this.f58388b = i3 + 1;
        }
        return strA;
    }

    public ah(byte[] bArr, int i3) {
        this.f58387a = bArr;
        this.f58389c = i3;
    }

    public void a(byte[] bArr) {
        a(bArr, bArr.length);
    }

    public void a(byte[] bArr, int i3) {
        this.f58387a = bArr;
        this.f58389c = i3;
        this.f58388b = 0;
    }

    public String a(int i3, Charset charset) {
        String str = new String(this.f58387a, this.f58388b, i3, charset);
        this.f58388b += i3;
        return str;
    }
}
