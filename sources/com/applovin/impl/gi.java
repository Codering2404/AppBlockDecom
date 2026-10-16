package com.applovin.impl;

import com.applovin.impl.i2;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class gi extends i2 {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class b implements i2.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ho f59980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ah f59981b;

        private b(ho hoVar) {
            this.f59980a = hoVar;
            this.f59981b = new ah();
        }

        @Override // com.applovin.impl.i2.f
        public void a() {
            this.f59981b.a(xp.f65032f);
        }

        private i2.e a(ah ahVar, long j3, long j4) {
            int iD = -1;
            int iD2 = -1;
            long j5 = -9223372036854775807L;
            while (ahVar.a() >= 4) {
                if (gi.b(ahVar.c(), ahVar.d()) != 442) {
                    ahVar.g(1);
                } else {
                    ahVar.g(4);
                    long jC = hi.c(ahVar);
                    if (jC != -9223372036854775807L) {
                        long jB = this.f59980a.b(jC);
                        if (jB > j3) {
                            return j5 == -9223372036854775807L ? i2.e.a(jB, j4) : i2.e.a(j4 + ((long) iD2));
                        }
                        if (100000 + jB > j3) {
                            return i2.e.a(j4 + ((long) ahVar.d()));
                        }
                        iD2 = ahVar.d();
                        j5 = jB;
                    }
                    a(ahVar);
                    iD = ahVar.d();
                }
            }
            return j5 != -9223372036854775807L ? i2.e.b(j5, j4 + ((long) iD)) : i2.e.f60325d;
        }

        @Override // com.applovin.impl.i2.f
        public i2.e a(k8 k8Var, long j3) {
            long jF = k8Var.f();
            int iMin = (int) Math.min(20000L, k8Var.a() - jF);
            this.f59981b.d(iMin);
            k8Var.c(this.f59981b.c(), 0, iMin);
            return a(this.f59981b, j3, jF);
        }

        private static void a(ah ahVar) {
            int iB;
            int iE = ahVar.e();
            if (ahVar.a() < 10) {
                ahVar.f(iE);
                return;
            }
            ahVar.g(9);
            int iW = ahVar.w() & 7;
            if (ahVar.a() < iW) {
                ahVar.f(iE);
                return;
            }
            ahVar.g(iW);
            if (ahVar.a() >= 4) {
                if (gi.b(ahVar.c(), ahVar.d()) == 443) {
                    ahVar.g(4);
                    int iC = ahVar.C();
                    if (ahVar.a() < iC) {
                        ahVar.f(iE);
                        return;
                    }
                    ahVar.g(iC);
                }
                while (ahVar.a() >= 4 && (iB = gi.b(ahVar.c(), ahVar.d())) != 442 && iB != 441 && (iB >>> 8) == 1) {
                    ahVar.g(4);
                    if (ahVar.a() < 2) {
                        ahVar.f(iE);
                        return;
                    }
                    ahVar.f(Math.min(ahVar.e(), ahVar.d() + ahVar.C()));
                }
                return;
            }
            ahVar.f(iE);
        }
    }

    public gi(ho hoVar, long j3, long j4) {
        super(new i2.b(), new b(hoVar), j3, 0L, j3 + 1, 0L, j4, 188L, 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(byte[] bArr, int i3) {
        return (bArr[i3 + 3] & 255) | ((bArr[i3] & 255) << 24) | ((bArr[i3 + 1] & 255) << 16) | ((bArr[i3 + 2] & 255) << 8);
    }
}
