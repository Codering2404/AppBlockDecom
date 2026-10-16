package com.applovin.impl;

import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class z5 implements o7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f65362a = new byte[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayDeque f65363b = new ArrayDeque();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zp f65364c = new zp();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private n7 f65365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f65366e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f65367f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f65368g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f65369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f65370b;

        private b(int i3, long j3) {
            this.f65369a = i3;
            this.f65370b = j3;
        }
    }

    private long b(k8 k8Var) {
        k8Var.b();
        while (true) {
            k8Var.c(this.f65362a, 0, 4);
            int iA = zp.a(this.f65362a[0]);
            if (iA != -1 && iA <= 4) {
                int iA2 = (int) zp.a(this.f65362a, iA, false);
                if (this.f65365d.c(iA2)) {
                    k8Var.a(iA);
                    return iA2;
                }
            }
            k8Var.a(1);
        }
    }

    private static String c(k8 k8Var, int i3) {
        if (i3 == 0) {
            return "";
        }
        byte[] bArr = new byte[i3];
        k8Var.d(bArr, 0, i3);
        while (i3 > 0 && bArr[i3 - 1] == 0) {
            i3--;
        }
        return new String(bArr, 0, i3);
    }

    @Override // com.applovin.impl.o7
    public void a(n7 n7Var) {
        this.f65365d = n7Var;
    }

    @Override // com.applovin.impl.o7
    public void reset() {
        this.f65366e = 0;
        this.f65363b.clear();
        this.f65364c.b();
    }

    @Override // com.applovin.impl.o7
    public boolean a(k8 k8Var) throws ch {
        b1.b(this.f65365d);
        while (true) {
            b bVar = (b) this.f65363b.peek();
            if (bVar != null && k8Var.f() >= bVar.f65370b) {
                this.f65365d.a(((b) this.f65363b.pop()).f65369a);
                return true;
            }
            if (this.f65366e == 0) {
                long jA = this.f65364c.a(k8Var, true, false, 4);
                if (jA == -2) {
                    jA = b(k8Var);
                }
                if (jA == -1) {
                    return false;
                }
                this.f65367f = (int) jA;
                this.f65366e = 1;
            }
            if (this.f65366e == 1) {
                this.f65368g = this.f65364c.a(k8Var, false, true, 8);
                this.f65366e = 2;
            }
            int iB = this.f65365d.b(this.f65367f);
            if (iB != 0) {
                if (iB == 1) {
                    long jF = k8Var.f();
                    this.f65363b.push(new b(this.f65367f, this.f65368g + jF));
                    this.f65365d.a(this.f65367f, jF, this.f65368g);
                    this.f65366e = 0;
                    return true;
                }
                if (iB == 2) {
                    long j3 = this.f65368g;
                    if (j3 <= 8) {
                        this.f65365d.a(this.f65367f, b(k8Var, (int) j3));
                        this.f65366e = 0;
                        return true;
                    }
                    throw ch.a("Invalid integer size: " + this.f65368g, null);
                }
                if (iB == 3) {
                    long j4 = this.f65368g;
                    if (j4 <= 2147483647L) {
                        this.f65365d.a(this.f65367f, c(k8Var, (int) j4));
                        this.f65366e = 0;
                        return true;
                    }
                    throw ch.a("String element size: " + this.f65368g, null);
                }
                if (iB == 4) {
                    this.f65365d.a(this.f65367f, (int) this.f65368g, k8Var);
                    this.f65366e = 0;
                    return true;
                }
                if (iB != 5) {
                    throw ch.a("Invalid element type " + iB, null);
                }
                long j5 = this.f65368g;
                if (j5 == 4 || j5 == 8) {
                    this.f65365d.a(this.f65367f, a(k8Var, (int) j5));
                    this.f65366e = 0;
                    return true;
                }
                throw ch.a("Invalid float size: " + this.f65368g, null);
            }
            k8Var.a((int) this.f65368g);
            this.f65366e = 0;
        }
    }

    private long b(k8 k8Var, int i3) {
        k8Var.d(this.f65362a, 0, i3);
        long j3 = 0;
        for (int i4 = 0; i4 < i3; i4++) {
            j3 = (j3 << 8) | ((long) (this.f65362a[i4] & 255));
        }
        return j3;
    }

    private double a(k8 k8Var, int i3) {
        long jB = b(k8Var, i3);
        if (i3 == 4) {
            return Float.intBitsToFloat((int) jB);
        }
        return Double.longBitsToDouble(jB);
    }
}
