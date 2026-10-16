package com.google.zxing.common.reedsolomon;

import com.sun.jna.Function;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class GenericGF {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final GenericGF f91821h = new GenericGF(4201, 4096, 1);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final GenericGF f91822i = new GenericGF(1033, 1024, 1);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final GenericGF f91823j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final GenericGF f91824k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final GenericGF f91825l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final GenericGF f91826m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final GenericGF f91827n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final GenericGF f91828o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f91829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f91830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final GenericGFPoly f91831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final GenericGFPoly f91832d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f91833e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f91834f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f91835g;

    static {
        GenericGF genericGF = new GenericGF(67, 64, 1);
        f91823j = genericGF;
        f91824k = new GenericGF(19, 16, 1);
        f91825l = new GenericGF(285, Function.MAX_NARGS, 0);
        GenericGF genericGF2 = new GenericGF(301, Function.MAX_NARGS, 1);
        f91826m = genericGF2;
        f91827n = genericGF2;
        f91828o = genericGF;
    }

    public GenericGF(int i3, int i4, int i5) {
        this.f91834f = i3;
        this.f91833e = i4;
        this.f91835g = i5;
        this.f91829a = new int[i4];
        this.f91830b = new int[i4];
        int i6 = 1;
        for (int i7 = 0; i7 < i4; i7++) {
            this.f91829a[i7] = i6;
            i6 <<= 1;
            if (i6 >= i4) {
                i6 = (i6 ^ i3) & (i4 - 1);
            }
        }
        for (int i8 = 0; i8 < i4 - 1; i8++) {
            this.f91830b[this.f91829a[i8]] = i8;
        }
        this.f91831c = new GenericGFPoly(this, new int[]{0});
        this.f91832d = new GenericGFPoly(this, new int[]{1});
    }

    static int a(int i3, int i4) {
        return i3 ^ i4;
    }

    GenericGFPoly b(int i3, int i4) {
        if (i3 < 0) {
            throw new IllegalArgumentException();
        }
        if (i4 == 0) {
            return this.f91831c;
        }
        int[] iArr = new int[i3 + 1];
        iArr[0] = i4;
        return new GenericGFPoly(this, iArr);
    }

    int c(int i3) {
        return this.f91829a[i3];
    }

    public int d() {
        return this.f91835g;
    }

    GenericGFPoly e() {
        return this.f91831c;
    }

    int f(int i3) {
        if (i3 != 0) {
            return this.f91829a[(this.f91833e - this.f91830b[i3]) - 1];
        }
        throw new ArithmeticException();
    }

    int g(int i3) {
        if (i3 != 0) {
            return this.f91830b[i3];
        }
        throw new IllegalArgumentException();
    }

    int h(int i3, int i4) {
        if (i3 == 0 || i4 == 0) {
            return 0;
        }
        int[] iArr = this.f91829a;
        int[] iArr2 = this.f91830b;
        return iArr[(iArr2[i3] + iArr2[i4]) % (this.f91833e - 1)];
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f91834f) + ',' + this.f91833e + ')';
    }
}
