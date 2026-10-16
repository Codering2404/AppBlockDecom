package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class bp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f58752a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f58755d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f58756e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f58757f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ho f58753b = new ho(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f58758g = -9223372036854775807L;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f58759h = -9223372036854775807L;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f58760i = -9223372036854775807L;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ah f58754c = new ah();

    bp(int i3) {
        this.f58752a = i3;
    }

    private int a(k8 k8Var) {
        this.f58754c.a(xp.f65032f);
        this.f58755d = true;
        k8Var.b();
        return 0;
    }

    public ho b() {
        return this.f58753b;
    }

    public boolean c() {
        return this.f58755d;
    }

    private int b(k8 k8Var, th thVar, int i3) {
        int iMin = (int) Math.min(this.f58752a, k8Var.a());
        long j3 = 0;
        if (k8Var.f() != j3) {
            thVar.f63943a = j3;
            return 1;
        }
        this.f58754c.d(iMin);
        k8Var.b();
        k8Var.c(this.f58754c.c(), 0, iMin);
        this.f58758g = a(this.f58754c, i3);
        this.f58756e = true;
        return 0;
    }

    private int c(k8 k8Var, th thVar, int i3) {
        long jA = k8Var.a();
        int iMin = (int) Math.min(this.f58752a, jA);
        long j3 = jA - ((long) iMin);
        if (k8Var.f() != j3) {
            thVar.f63943a = j3;
            return 1;
        }
        this.f58754c.d(iMin);
        k8Var.b();
        k8Var.c(this.f58754c.c(), 0, iMin);
        this.f58759h = b(this.f58754c, i3);
        this.f58757f = true;
        return 0;
    }

    public long a() {
        return this.f58760i;
    }

    public int a(k8 k8Var, th thVar, int i3) {
        if (i3 <= 0) {
            return a(k8Var);
        }
        if (!this.f58757f) {
            return c(k8Var, thVar, i3);
        }
        if (this.f58759h == -9223372036854775807L) {
            return a(k8Var);
        }
        if (!this.f58756e) {
            return b(k8Var, thVar, i3);
        }
        long j3 = this.f58758g;
        if (j3 == -9223372036854775807L) {
            return a(k8Var);
        }
        long jB = this.f58753b.b(this.f58759h) - this.f58753b.b(j3);
        this.f58760i = jB;
        if (jB < 0) {
            oc.d("TsDurationReader", "Invalid duration: " + this.f58760i + ". Using TIME_UNSET instead.");
            this.f58760i = -9223372036854775807L;
        }
        return a(k8Var);
    }

    private long b(ah ahVar, int i3) {
        int iD = ahVar.d();
        int iE = ahVar.e();
        for (int i4 = iE - 188; i4 >= iD; i4--) {
            if (ep.a(ahVar.c(), iD, iE, i4)) {
                long jA = ep.a(ahVar, i4, i3);
                if (jA != -9223372036854775807L) {
                    return jA;
                }
            }
        }
        return -9223372036854775807L;
    }

    private long a(ah ahVar, int i3) {
        int iE = ahVar.e();
        for (int iD = ahVar.d(); iD < iE; iD++) {
            if (ahVar.c()[iD] == 71) {
                long jA = ep.a(ahVar, iD, i3);
                if (jA != -9223372036854775807L) {
                    return jA;
                }
            }
        }
        return -9223372036854775807L;
    }
}
