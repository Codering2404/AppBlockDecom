package com.applovin.impl;

import com.applovin.impl.i2;
import com.applovin.impl.v8;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class t8 extends i2 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t8(final z8 z8Var, int i3, long j3, long j4) {
        super(new i2.d() { // from class: com.applovin.impl.h50
            @Override // com.applovin.impl.i2.d
            public final long a(long j5) {
                return z8Var.a(j5);
            }
        }, new b(z8Var, i3), z8Var.b(), 0L, z8Var.f65397j, j3, j4, z8Var.a(), Math.max(6, z8Var.f65390c));
        Objects.requireNonNull(z8Var);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class b implements i2.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final z8 f63890a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f63891b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final v8.a f63892c;

        private b(z8 z8Var, int i3) {
            this.f63890a = z8Var;
            this.f63891b = i3;
            this.f63892c = new v8.a();
        }

        private long a(k8 k8Var) {
            while (k8Var.d() < k8Var.a() - 6 && !v8.a(k8Var, this.f63890a, this.f63891b, this.f63892c)) {
                k8Var.c(1);
            }
            if (k8Var.d() < k8Var.a() - 6) {
                return this.f63892c.f64409a;
            }
            k8Var.c((int) (k8Var.a() - k8Var.d()));
            return this.f63890a.f65397j;
        }

        @Override // com.applovin.impl.i2.f
        public i2.e a(k8 k8Var, long j3) {
            long jF = k8Var.f();
            long jA = a(k8Var);
            long jD = k8Var.d();
            k8Var.c(Math.max(6, this.f63890a.f65390c));
            long jA2 = a(k8Var);
            long jD2 = k8Var.d();
            if (jA <= j3 && jA2 > j3) {
                return i2.e.a(jD);
            }
            if (jA2 <= j3) {
                return i2.e.b(jA2, jD2);
            }
            return i2.e.a(jA, jF);
        }
    }
}
