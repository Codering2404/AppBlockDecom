package com.applovin.impl;

import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.nio.ShortBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class nk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f62067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f62068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f62069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f62070d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f62071e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f62072f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f62073g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f62074h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final short[] f62075i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private short[] f62076j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f62077k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private short[] f62078l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f62079m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private short[] f62080n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f62081o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f62082p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f62083q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f62084r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f62085s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f62086t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f62087u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f62088v;

    public nk(int i3, int i4, float f3, float f4, int i5) {
        this.f62067a = i3;
        this.f62068b = i4;
        this.f62069c = f3;
        this.f62070d = f4;
        this.f62071e = i3 / i5;
        this.f62072f = i3 / RCHTTPStatusCodes.BAD_REQUEST;
        int i6 = i3 / 65;
        this.f62073g = i6;
        int i7 = i6 * 2;
        this.f62074h = i7;
        this.f62075i = new short[i7];
        int i8 = i7 * i4;
        this.f62076j = new short[i8];
        this.f62078l = new short[i8];
        this.f62080n = new short[i8];
    }

    private void a(float f3, int i3) {
        int i4;
        int i5;
        if (this.f62079m == i3) {
            return;
        }
        int i6 = this.f62067a;
        int i7 = (int) (i6 / f3);
        while (true) {
            if (i7 <= 16384 && i6 <= 16384) {
                break;
            }
            i7 /= 2;
            i6 /= 2;
        }
        b(i3);
        int i8 = 0;
        while (true) {
            int i9 = this.f62081o - 1;
            if (i8 >= i9) {
                c(i9);
                return;
            }
            while (true) {
                i4 = this.f62082p + 1;
                int i10 = i4 * i7;
                i5 = this.f62083q;
                if (i10 <= i5 * i6) {
                    break;
                }
                this.f62078l = c(this.f62078l, this.f62079m, 1);
                int i11 = 0;
                while (true) {
                    int i12 = this.f62068b;
                    if (i11 < i12) {
                        this.f62078l[(this.f62079m * i12) + i11] = b(this.f62080n, (i12 * i8) + i11, i6, i7);
                        i11++;
                    }
                }
                this.f62083q++;
                this.f62079m++;
            }
            this.f62082p = i4;
            if (i4 == i6) {
                this.f62082p = 0;
                b1.b(i5 == i7);
                this.f62083q = 0;
            }
            i8++;
        }
    }

    private void b(short[] sArr, int i3, int i4) {
        int i5 = this.f62074h / i4;
        int i6 = this.f62068b;
        int i7 = i4 * i6;
        int i8 = i3 * i6;
        for (int i9 = 0; i9 < i5; i9++) {
            int i10 = 0;
            for (int i11 = 0; i11 < i7; i11++) {
                i10 += sArr[(i9 * i7) + i8 + i11];
            }
            this.f62075i[i9] = (short) (i10 / i7);
        }
    }

    private short[] c(short[] sArr, int i3, int i4) {
        int length = sArr.length;
        int i5 = this.f62068b;
        int i6 = length / i5;
        return i3 + i4 <= i6 ? sArr : Arrays.copyOf(sArr, (((i6 * 3) / 2) + i4) * i5);
    }

    private void d() {
        int i3 = this.f62079m;
        float f3 = this.f62069c;
        float f4 = this.f62070d;
        float f5 = f3 / f4;
        float f6 = this.f62071e * f4;
        double d3 = f5;
        if (d3 > 1.00001d || d3 < 0.99999d) {
            a(f5);
        } else {
            a(this.f62076j, 0, this.f62077k);
            this.f62077k = 0;
        }
        if (f6 != 1.0f) {
            a(f6, i3);
        }
    }

    public void e() {
        int i3;
        int i4 = this.f62077k;
        float f3 = this.f62069c;
        float f4 = this.f62070d;
        int i5 = this.f62079m + ((int) ((((i4 / (f3 / f4)) + this.f62081o) / (this.f62071e * f4)) + 0.5f));
        this.f62076j = c(this.f62076j, i4, (this.f62074h * 2) + i4);
        int i6 = 0;
        while (true) {
            i3 = this.f62074h * 2;
            int i7 = this.f62068b;
            if (i6 >= i3 * i7) {
                break;
            }
            this.f62076j[(i7 * i4) + i6] = 0;
            i6++;
        }
        this.f62077k += i3;
        d();
        if (this.f62079m > i5) {
            this.f62079m = i5;
        }
        this.f62077k = 0;
        this.f62084r = 0;
        this.f62081o = 0;
    }

    public int c() {
        return this.f62077k * this.f62068b * 2;
    }

    private void c(int i3) {
        if (i3 == 0) {
            return;
        }
        short[] sArr = this.f62080n;
        int i4 = this.f62068b;
        System.arraycopy(sArr, i3 * i4, sArr, 0, (this.f62081o - i3) * i4);
        this.f62081o -= i3;
    }

    public int b() {
        return this.f62079m * this.f62068b * 2;
    }

    private short b(short[] sArr, int i3, int i4, int i5) {
        short s2 = sArr[i3];
        short s3 = sArr[i3 + this.f62068b];
        int i6 = this.f62083q * i4;
        int i7 = this.f62082p;
        int i8 = i7 * i5;
        int i9 = (i7 + 1) * i5;
        int i10 = i9 - i6;
        int i11 = i9 - i8;
        return (short) (((s2 * i10) + ((i11 - i10) * s3)) / i11);
    }

    private void d(int i3) {
        int i4 = this.f62077k - i3;
        short[] sArr = this.f62076j;
        int i5 = this.f62068b;
        System.arraycopy(sArr, i3 * i5, sArr, 0, i5 * i4);
        this.f62077k = i4;
    }

    private void b(int i3) {
        int i4 = this.f62079m - i3;
        short[] sArrC = c(this.f62080n, this.f62081o, i4);
        this.f62080n = sArrC;
        short[] sArr = this.f62078l;
        int i5 = this.f62068b;
        System.arraycopy(sArr, i3 * i5, sArrC, this.f62081o * i5, i5 * i4);
        this.f62079m = i3;
        this.f62081o += i4;
    }

    public void b(ShortBuffer shortBuffer) {
        int iRemaining = shortBuffer.remaining();
        int i3 = this.f62068b;
        int i4 = iRemaining / i3;
        short[] sArrC = c(this.f62076j, this.f62077k, i4);
        this.f62076j = sArrC;
        shortBuffer.get(sArrC, this.f62077k * this.f62068b, ((i3 * i4) * 2) / 2);
        this.f62077k += i4;
        d();
    }

    private void a(float f3) {
        int iA;
        int i3 = this.f62077k;
        if (i3 < this.f62074h) {
            return;
        }
        int i4 = 0;
        do {
            if (this.f62084r > 0) {
                iA = a(i4);
            } else {
                int iA2 = a(this.f62076j, i4);
                if (f3 > 1.0d) {
                    iA = iA2 + b(this.f62076j, i4, f3, iA2);
                } else {
                    iA = a(this.f62076j, i4, f3, iA2);
                }
            }
            i4 += iA;
        } while (this.f62074h + i4 <= i3);
        d(i4);
    }

    private int b(short[] sArr, int i3, float f3, int i4) {
        int i5;
        if (f3 >= 2.0f) {
            i5 = (int) (i4 / (f3 - 1.0f));
        } else {
            this.f62084r = (int) ((i4 * (2.0f - f3)) / (f3 - 1.0f));
            i5 = i4;
        }
        short[] sArrC = c(this.f62078l, this.f62079m, i5);
        this.f62078l = sArrC;
        a(i5, this.f62068b, sArrC, this.f62079m, sArr, i3, sArr, i3 + i4);
        this.f62079m += i5;
        return i5;
    }

    private int a(int i3) {
        int iMin = Math.min(this.f62074h, this.f62084r);
        a(this.f62076j, i3, iMin);
        this.f62084r -= iMin;
        return iMin;
    }

    private void a(short[] sArr, int i3, int i4) {
        short[] sArrC = c(this.f62078l, this.f62079m, i4);
        this.f62078l = sArrC;
        int i5 = this.f62068b;
        System.arraycopy(sArr, i3 * i5, sArrC, this.f62079m * i5, i5 * i4);
        this.f62079m += i4;
    }

    private int a(short[] sArr, int i3) {
        int iA;
        int i4 = this.f62067a;
        int i5 = i4 > 4000 ? i4 / 4000 : 1;
        if (this.f62068b == 1 && i5 == 1) {
            iA = a(sArr, i3, this.f62072f, this.f62073g);
        } else {
            b(sArr, i3, i5);
            int iA2 = a(this.f62075i, 0, this.f62072f / i5, this.f62073g / i5);
            if (i5 != 1) {
                int i6 = iA2 * i5;
                int i7 = i5 * 4;
                int i8 = i6 - i7;
                int i9 = i6 + i7;
                int i10 = this.f62072f;
                if (i8 < i10) {
                    i8 = i10;
                }
                int i11 = this.f62073g;
                if (i9 > i11) {
                    i9 = i11;
                }
                if (this.f62068b == 1) {
                    iA = a(sArr, i3, i8, i9);
                } else {
                    b(sArr, i3, 1);
                    iA = a(this.f62075i, 0, i8, i9);
                }
            } else {
                iA = iA2;
            }
        }
        int i12 = a(this.f62087u, this.f62088v) ? this.f62085s : iA;
        this.f62086t = this.f62087u;
        this.f62085s = iA;
        return i12;
    }

    private int a(short[] sArr, int i3, int i4, int i5) {
        int i6 = i3 * this.f62068b;
        int i7 = 255;
        int i8 = 1;
        int i9 = 0;
        int i10 = 0;
        while (i4 <= i5) {
            int iAbs = 0;
            for (int i11 = 0; i11 < i4; i11++) {
                iAbs += Math.abs(sArr[i6 + i11] - sArr[(i6 + i4) + i11]);
            }
            if (iAbs * i9 < i8 * i4) {
                i9 = i4;
                i8 = iAbs;
            }
            if (iAbs * i7 > i10 * i4) {
                i7 = i4;
                i10 = iAbs;
            }
            i4++;
        }
        this.f62087u = i8 / i9;
        this.f62088v = i10 / i7;
        return i9;
    }

    public void a() {
        this.f62077k = 0;
        this.f62079m = 0;
        this.f62081o = 0;
        this.f62082p = 0;
        this.f62083q = 0;
        this.f62084r = 0;
        this.f62085s = 0;
        this.f62086t = 0;
        this.f62087u = 0;
        this.f62088v = 0;
    }

    public void a(ShortBuffer shortBuffer) {
        int iMin = Math.min(shortBuffer.remaining() / this.f62068b, this.f62079m);
        shortBuffer.put(this.f62078l, 0, this.f62068b * iMin);
        int i3 = this.f62079m - iMin;
        this.f62079m = i3;
        short[] sArr = this.f62078l;
        int i4 = this.f62068b;
        System.arraycopy(sArr, iMin * i4, sArr, 0, i3 * i4);
    }

    private int a(short[] sArr, int i3, float f3, int i4) {
        int i5;
        if (f3 < 0.5f) {
            i5 = (int) ((i4 * f3) / (1.0f - f3));
        } else {
            this.f62084r = (int) ((i4 * ((2.0f * f3) - 1.0f)) / (1.0f - f3));
            i5 = i4;
        }
        int i6 = i4 + i5;
        short[] sArrC = c(this.f62078l, this.f62079m, i6);
        this.f62078l = sArrC;
        int i7 = this.f62068b;
        System.arraycopy(sArr, i3 * i7, sArrC, this.f62079m * i7, i7 * i4);
        a(i5, this.f62068b, this.f62078l, this.f62079m + i4, sArr, i3 + i4, sArr, i3);
        this.f62079m += i6;
        return i5;
    }

    private static void a(int i3, int i4, short[] sArr, int i5, short[] sArr2, int i6, short[] sArr3, int i7) {
        for (int i8 = 0; i8 < i4; i8++) {
            int i9 = (i5 * i4) + i8;
            int i10 = (i7 * i4) + i8;
            int i11 = (i6 * i4) + i8;
            for (int i12 = 0; i12 < i3; i12++) {
                sArr[i9] = (short) (((sArr2[i11] * (i3 - i12)) + (sArr3[i10] * i12)) / i3);
                i9 += i4;
                i11 += i4;
                i10 += i4;
            }
        }
    }

    private boolean a(int i3, int i4) {
        return i3 != 0 && this.f62085s != 0 && i4 <= i3 * 3 && i3 * 2 > this.f62086t * 3;
    }
}
