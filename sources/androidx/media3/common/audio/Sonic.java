package androidx.media3.common.audio;

import androidx.media3.common.util.Assertions;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.ShortBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class Sonic {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f41306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f41307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f41308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f41309d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f41310e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f41311f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f41312g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f41313h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final short[] f41314i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private short[] f41315j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f41316k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private short[] f41317l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f41318m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private short[] f41319n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f41320o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f41321p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f41322q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f41323r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f41324s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f41325t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f41326u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f41327v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private double f41328w;

    public Sonic(int i3, int i4, float f3, float f4, int i5) {
        this.f41306a = i3;
        this.f41307b = i4;
        this.f41308c = f3;
        this.f41309d = f4;
        this.f41310e = i3 / i5;
        this.f41311f = i3 / RCHTTPStatusCodes.BAD_REQUEST;
        int i6 = i3 / 65;
        this.f41312g = i6;
        int i7 = i6 * 2;
        this.f41313h = i7;
        this.f41314i = new short[i7];
        this.f41315j = new short[i7 * i4];
        this.f41317l = new short[i7 * i4];
        this.f41319n = new short[i7 * i4];
    }

    private void a(float f3, int i3) {
        int i4;
        int i5;
        if (this.f41318m == i3) {
            return;
        }
        int i6 = this.f41306a;
        long j3 = (long) (i6 / f3);
        long j4 = i6;
        while (j3 != 0 && j4 != 0 && j3 % 2 == 0 && j4 % 2 == 0) {
            j3 /= 2;
            j4 /= 2;
        }
        q(i3);
        int i7 = 0;
        while (true) {
            int i8 = this.f41320o;
            if (i7 >= i8 - 1) {
                w(i8 - 1);
                return;
            }
            while (true) {
                i4 = this.f41321p;
                long j5 = ((long) (i4 + 1)) * j3;
                i5 = this.f41322q;
                if (j5 <= ((long) i5) * j4) {
                    break;
                }
                this.f41317l = g(this.f41317l, this.f41318m, 1);
                int i9 = 0;
                while (true) {
                    int i10 = this.f41307b;
                    if (i9 < i10) {
                        this.f41317l[(this.f41318m * i10) + i9] = p(this.f41319n, (i10 * i7) + i9, j4, j3);
                        i9++;
                    }
                }
                this.f41322q++;
                this.f41318m++;
            }
            int i11 = i4 + 1;
            this.f41321p = i11;
            if (i11 == j4) {
                this.f41321p = 0;
                Assertions.g(((long) i5) == j3);
                this.f41322q = 0;
            }
            i7++;
        }
    }

    static long b(BigDecimal bigDecimal, BigDecimal bigDecimal2, BigDecimal bigDecimal3) {
        RoundingMode roundingMode = RoundingMode.HALF_EVEN;
        BigDecimal bigDecimalDivide = bigDecimal.divide(bigDecimal2, 20, roundingMode);
        BigDecimal bigDecimalDivide2 = bigDecimal2.divide(bigDecimal3, 20, roundingMode);
        RoundingMode roundingMode2 = RoundingMode.FLOOR;
        return bigDecimalDivide.multiply(bigDecimalDivide2.subtract(bigDecimalDivide2.setScale(0, roundingMode2))).setScale(0, roundingMode2).longValueExact();
    }

    private void c(double d3) {
        Sonic sonic;
        double d4;
        int i3 = this.f41316k;
        if (i3 < this.f41313h) {
            return;
        }
        int iO = 0;
        while (true) {
            if (this.f41323r > 0) {
                iO += d(iO);
                sonic = this;
                d4 = d3;
            } else {
                int iH = h(this.f41315j, iO);
                if (d3 > 1.0d) {
                    sonic = this;
                    d4 = d3;
                    iO += iH + sonic.y(this.f41315j, iO, d4, iH);
                } else {
                    sonic = this;
                    d4 = d3;
                    iO += sonic.o(sonic.f41315j, iO, d4, iH);
                }
            }
            if (sonic.f41313h + iO > i3) {
                x(iO);
                return;
            }
            d3 = d4;
        }
    }

    private int d(int i3) {
        int iMin = Math.min(this.f41313h, this.f41323r);
        e(this.f41315j, i3, iMin);
        this.f41323r -= iMin;
        return iMin;
    }

    private void e(short[] sArr, int i3, int i4) {
        short[] sArrG = g(this.f41317l, this.f41318m, i4);
        this.f41317l = sArrG;
        int i5 = this.f41307b;
        System.arraycopy(sArr, i3 * i5, sArrG, this.f41318m * i5, i5 * i4);
        this.f41318m += i4;
    }

    private void f(short[] sArr, int i3, int i4) {
        int i5 = this.f41313h / i4;
        int i6 = this.f41307b;
        int i7 = i4 * i6;
        int i8 = i3 * i6;
        for (int i9 = 0; i9 < i5; i9++) {
            int i10 = 0;
            for (int i11 = 0; i11 < i7; i11++) {
                i10 += sArr[(i9 * i7) + i8 + i11];
            }
            this.f41314i[i9] = (short) (i10 / i7);
        }
    }

    private short[] g(short[] sArr, int i3, int i4) {
        int length = sArr.length;
        int i5 = this.f41307b;
        int i6 = length / i5;
        return i3 + i4 <= i6 ? sArr : Arrays.copyOf(sArr, (((i6 * 3) / 2) + i4) * i5);
    }

    private int h(short[] sArr, int i3) {
        int i4;
        int i5 = this.f41306a;
        int i6 = i5 > 4000 ? i5 / 4000 : 1;
        if (this.f41307b == 1 && i6 == 1) {
            i4 = i(sArr, i3, this.f41311f, this.f41312g);
        } else {
            f(sArr, i3, i6);
            int i7 = i(this.f41314i, 0, this.f41311f / i6, this.f41312g / i6);
            if (i6 != 1) {
                int i8 = i7 * i6;
                int i9 = i6 * 4;
                int i10 = i8 - i9;
                int i11 = i8 + i9;
                int i12 = this.f41311f;
                if (i10 < i12) {
                    i10 = i12;
                }
                int i13 = this.f41312g;
                if (i11 > i13) {
                    i11 = i13;
                }
                if (this.f41307b == 1) {
                    i4 = i(sArr, i3, i10, i11);
                } else {
                    f(sArr, i3, 1);
                    i4 = i(this.f41314i, 0, i10, i11);
                }
            } else {
                i4 = i7;
            }
        }
        int i14 = s(this.f41326u, this.f41327v) ? this.f41324s : i4;
        this.f41325t = this.f41326u;
        this.f41324s = i4;
        return i14;
    }

    private int i(short[] sArr, int i3, int i4, int i5) {
        int i6 = i3 * this.f41307b;
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
        this.f41326u = i8 / i9;
        this.f41327v = i10 / i7;
        return i9;
    }

    public static long k(int i3, int i4, float f3, float f4, long j3) {
        float f5 = (i3 / i4) * f4;
        double d3 = f3 / f4;
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(f5));
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(j3);
        if (d3 > 1.0000100135803223d || d3 < 0.9999899864196777d) {
            bigDecimalValueOf = bigDecimalValueOf.divide(BigDecimal.valueOf(d3), RoundingMode.HALF_EVEN);
        }
        return f5 == 1.0f ? bigDecimalValueOf.longValueExact() : bigDecimalValueOf.divide(bigDecimal, RoundingMode.HALF_EVEN).longValueExact() - b(bigDecimalValueOf, BigDecimal.valueOf(i3), bigDecimal);
    }

    private int o(short[] sArr, int i3, double d3, int i4) {
        int i5;
        if (d3 < 0.5d) {
            double d4 = ((((double) i4) * d3) / (1.0d - d3)) + this.f41328w;
            int iRound = (int) Math.round(d4);
            this.f41328w = d4 - ((double) iRound);
            i5 = iRound;
        } else {
            double d5 = ((((double) i4) * ((2.0d * d3) - 1.0d)) / (1.0d - d3)) + this.f41328w;
            int iRound2 = (int) Math.round(d5);
            this.f41323r = iRound2;
            this.f41328w = d5 - ((double) iRound2);
            i5 = i4;
        }
        int i6 = i4 + i5;
        short[] sArrG = g(this.f41317l, this.f41318m, i6);
        this.f41317l = sArrG;
        int i7 = this.f41307b;
        System.arraycopy(sArr, i3 * i7, sArrG, this.f41318m * i7, i7 * i4);
        r(i5, this.f41307b, this.f41317l, this.f41318m + i4, sArr, i3 + i4, sArr, i3);
        this.f41318m += i6;
        return i5;
    }

    private short p(short[] sArr, int i3, long j3, long j4) {
        short s2 = sArr[i3];
        short s3 = sArr[i3 + this.f41307b];
        long j5 = ((long) this.f41322q) * j3;
        int i4 = this.f41321p;
        long j6 = ((long) i4) * j4;
        long j7 = ((long) (i4 + 1)) * j4;
        long j8 = j7 - j5;
        long j9 = j7 - j6;
        return (short) (((((long) s2) * j8) + ((j9 - j8) * ((long) s3))) / j9);
    }

    private void q(int i3) {
        int i4 = this.f41318m - i3;
        short[] sArrG = g(this.f41319n, this.f41320o, i4);
        this.f41319n = sArrG;
        short[] sArr = this.f41317l;
        int i5 = this.f41307b;
        System.arraycopy(sArr, i3 * i5, sArrG, this.f41320o * i5, i5 * i4);
        this.f41318m = i3;
        this.f41320o += i4;
    }

    private static void r(int i3, int i4, short[] sArr, int i5, short[] sArr2, int i6, short[] sArr3, int i7) {
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

    private boolean s(int i3, int i4) {
        return i3 != 0 && this.f41324s != 0 && i4 <= i3 * 3 && i3 * 2 > this.f41325t * 3;
    }

    private void t() {
        int i3 = this.f41318m;
        float f3 = this.f41308c;
        float f4 = this.f41309d;
        double d3 = f3 / f4;
        float f5 = this.f41310e * f4;
        if (d3 > 1.0000100135803223d || d3 < 0.9999899864196777d) {
            c(d3);
        } else {
            e(this.f41315j, 0, this.f41316k);
            this.f41316k = 0;
        }
        if (f5 != 1.0f) {
            a(f5, i3);
        }
    }

    private void w(int i3) {
        if (i3 == 0) {
            return;
        }
        short[] sArr = this.f41319n;
        int i4 = this.f41307b;
        System.arraycopy(sArr, i3 * i4, sArr, 0, (this.f41320o - i3) * i4);
        this.f41320o -= i3;
    }

    private void x(int i3) {
        int i4 = this.f41316k - i3;
        short[] sArr = this.f41315j;
        int i5 = this.f41307b;
        System.arraycopy(sArr, i3 * i5, sArr, 0, i5 * i4);
        this.f41316k = i4;
    }

    private int y(short[] sArr, int i3, double d3, int i4) {
        int i5;
        if (d3 >= 2.0d) {
            double d4 = (((double) i4) / (d3 - 1.0d)) + this.f41328w;
            int iRound = (int) Math.round(d4);
            this.f41328w = d4 - ((double) iRound);
            i5 = iRound;
        } else {
            double d5 = ((((double) i4) * (2.0d - d3)) / (d3 - 1.0d)) + this.f41328w;
            int iRound2 = (int) Math.round(d5);
            this.f41323r = iRound2;
            this.f41328w = d5 - ((double) iRound2);
            i5 = i4;
        }
        short[] sArrG = g(this.f41317l, this.f41318m, i5);
        this.f41317l = sArrG;
        r(i5, this.f41307b, sArrG, this.f41318m, sArr, i3, sArr, i3 + i4);
        this.f41318m += i5;
        return i5;
    }

    public void j() {
        this.f41316k = 0;
        this.f41318m = 0;
        this.f41320o = 0;
        this.f41321p = 0;
        this.f41322q = 0;
        this.f41323r = 0;
        this.f41324s = 0;
        this.f41325t = 0;
        this.f41326u = 0;
        this.f41327v = 0;
        this.f41328w = 0.0d;
    }

    public void l(ShortBuffer shortBuffer) {
        Assertions.g(this.f41318m >= 0);
        int iMin = Math.min(shortBuffer.remaining() / this.f41307b, this.f41318m);
        shortBuffer.put(this.f41317l, 0, this.f41307b * iMin);
        int i3 = this.f41318m - iMin;
        this.f41318m = i3;
        short[] sArr = this.f41317l;
        int i4 = this.f41307b;
        System.arraycopy(sArr, iMin * i4, sArr, 0, i3 * i4);
    }

    public int m() {
        Assertions.g(this.f41318m >= 0);
        return this.f41318m * this.f41307b * 2;
    }

    public int n() {
        return this.f41316k * this.f41307b * 2;
    }

    public void u() {
        int i3;
        int i4 = this.f41316k;
        float f3 = this.f41308c;
        float f4 = this.f41309d;
        double d3 = f3 / f4;
        double d4 = this.f41310e * f4;
        int i5 = this.f41323r;
        int i6 = this.f41318m + ((int) ((((((((double) (i4 - i5)) / d3) + ((double) i5)) + this.f41328w) + ((double) this.f41320o)) / d4) + 0.5d));
        this.f41328w = 0.0d;
        this.f41315j = g(this.f41315j, i4, (this.f41313h * 2) + i4);
        int i7 = 0;
        while (true) {
            i3 = this.f41313h;
            int i8 = this.f41307b;
            if (i7 >= i3 * 2 * i8) {
                break;
            }
            this.f41315j[(i8 * i4) + i7] = 0;
            i7++;
        }
        this.f41316k += i3 * 2;
        t();
        if (this.f41318m > i6) {
            this.f41318m = Math.max(i6, 0);
        }
        this.f41316k = 0;
        this.f41323r = 0;
        this.f41320o = 0;
    }

    public void v(ShortBuffer shortBuffer) {
        int iRemaining = shortBuffer.remaining();
        int i3 = this.f41307b;
        int i4 = iRemaining / i3;
        short[] sArrG = g(this.f41315j, this.f41316k, i4);
        this.f41315j = sArrG;
        shortBuffer.get(sArrG, this.f41316k * this.f41307b, ((i3 * i4) * 2) / 2);
        this.f41316k += i4;
        t();
    }
}
