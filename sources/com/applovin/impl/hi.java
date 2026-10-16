package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class hi {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f60202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f60203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f60204e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ho f60200a = new ho(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f60205f = -9223372036854775807L;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f60206g = -9223372036854775807L;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f60207h = -9223372036854775807L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ah f60201b = new ah();

    hi() {
    }

    private static boolean a(byte[] bArr) {
        return (bArr[0] & 196) == 68 && (bArr[2] & 4) == 4 && (bArr[4] & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3;
    }

    public ho b() {
        return this.f60200a;
    }

    public boolean c() {
        return this.f60202c;
    }

    private int b(k8 k8Var, th thVar) {
        int iMin = (int) Math.min(20000L, k8Var.a());
        long j3 = 0;
        if (k8Var.f() != j3) {
            thVar.f63943a = j3;
            return 1;
        }
        this.f60201b.d(iMin);
        k8Var.b();
        k8Var.c(this.f60201b.c(), 0, iMin);
        this.f60205f = a(this.f60201b);
        this.f60203d = true;
        return 0;
    }

    private int c(k8 k8Var, th thVar) {
        long jA = k8Var.a();
        int iMin = (int) Math.min(20000L, jA);
        long j3 = jA - ((long) iMin);
        if (k8Var.f() != j3) {
            thVar.f63943a = j3;
            return 1;
        }
        this.f60201b.d(iMin);
        k8Var.b();
        k8Var.c(this.f60201b.c(), 0, iMin);
        this.f60206g = b(this.f60201b);
        this.f60204e = true;
        return 0;
    }

    private int a(k8 k8Var) {
        this.f60201b.a(xp.f65032f);
        this.f60202c = true;
        k8Var.b();
        return 0;
    }

    public long a() {
        return this.f60207h;
    }

    private int a(byte[] bArr, int i3) {
        return (bArr[i3 + 3] & 255) | ((bArr[i3] & 255) << 24) | ((bArr[i3 + 1] & 255) << 16) | ((bArr[i3 + 2] & 255) << 8);
    }

    private long b(ah ahVar) {
        int iD = ahVar.d();
        for (int iE = ahVar.e() - 4; iE >= iD; iE--) {
            if (a(ahVar.c(), iE) == 442) {
                ahVar.f(iE + 4);
                long jC = c(ahVar);
                if (jC != -9223372036854775807L) {
                    return jC;
                }
            }
        }
        return -9223372036854775807L;
    }

    public static long c(ah ahVar) {
        int iD = ahVar.d();
        if (ahVar.a() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        ahVar.a(bArr, 0, 9);
        ahVar.f(iD);
        if (a(bArr)) {
            return b(bArr);
        }
        return -9223372036854775807L;
    }

    public int a(k8 k8Var, th thVar) {
        if (!this.f60204e) {
            return c(k8Var, thVar);
        }
        if (this.f60206g == -9223372036854775807L) {
            return a(k8Var);
        }
        if (!this.f60203d) {
            return b(k8Var, thVar);
        }
        long j3 = this.f60205f;
        if (j3 == -9223372036854775807L) {
            return a(k8Var);
        }
        long jB = this.f60200a.b(this.f60206g) - this.f60200a.b(j3);
        this.f60207h = jB;
        if (jB < 0) {
            oc.d("PsDurationReader", "Invalid duration: " + this.f60207h + ". Using TIME_UNSET instead.");
            this.f60207h = -9223372036854775807L;
        }
        return a(k8Var);
    }

    private static long b(byte[] bArr) {
        long j3 = bArr[0];
        long j4 = ((j3 & 3) << 28) | (((56 & j3) >> 3) << 30) | ((((long) bArr[1]) & 255) << 20);
        long j5 = bArr[2];
        return j4 | (((j5 & 248) >> 3) << 15) | ((j5 & 3) << 13) | ((((long) bArr[3]) & 255) << 5) | ((((long) bArr[4]) & 248) >> 3);
    }

    private long a(ah ahVar) {
        int iE = ahVar.e();
        for (int iD = ahVar.d(); iD < iE - 3; iD++) {
            if (a(ahVar.c(), iD) == 442) {
                ahVar.f(iD + 4);
                long jC = c(ahVar);
                if (jC != -9223372036854775807L) {
                    return jC;
                }
            }
        }
        return -9223372036854775807L;
    }
}
