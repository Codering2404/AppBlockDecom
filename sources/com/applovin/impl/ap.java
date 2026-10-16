package com.applovin.impl;

import com.applovin.impl.i2;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class ap extends i2 {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class a implements i2.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ho f58468a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ah f58469b = new ah();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f58470c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f58471d;

        public a(int i3, ho hoVar, int i4) {
            this.f58470c = i3;
            this.f58468a = hoVar;
            this.f58471d = i4;
        }

        @Override // com.applovin.impl.i2.f
        public void a() {
            this.f58469b.a(xp.f65032f);
        }

        private i2.e a(ah ahVar, long j3, long j4) {
            int iA;
            int iA2;
            int iE = ahVar.e();
            long j5 = -1;
            long j6 = -1;
            long j7 = -9223372036854775807L;
            while (ahVar.a() >= 188 && (iA2 = (iA = ep.a(ahVar.c(), ahVar.d(), iE)) + 188) <= iE) {
                long jA = ep.a(ahVar, iA, this.f58470c);
                if (jA != -9223372036854775807L) {
                    long jB = this.f58468a.b(jA);
                    if (jB > j3) {
                        return j7 == -9223372036854775807L ? i2.e.a(jB, j4) : i2.e.a(j4 + j6);
                    }
                    if (100000 + jB > j3) {
                        return i2.e.a(j4 + ((long) iA));
                    }
                    j6 = iA;
                    j7 = jB;
                }
                ahVar.f(iA2);
                j5 = iA2;
            }
            return j7 != -9223372036854775807L ? i2.e.b(j7, j4 + j5) : i2.e.f60325d;
        }

        @Override // com.applovin.impl.i2.f
        public i2.e a(k8 k8Var, long j3) {
            long jF = k8Var.f();
            int iMin = (int) Math.min(this.f58471d, k8Var.a() - jF);
            this.f58469b.d(iMin);
            k8Var.c(this.f58469b.c(), 0, iMin);
            return a(this.f58469b, j3, jF);
        }
    }

    public ap(ho hoVar, long j3, long j4, int i3, int i4) {
        super(new i2.b(), new a(i3, hoVar, i4), j3, 0L, j3 + 1, 0L, j4, 188L, 940);
    }
}
