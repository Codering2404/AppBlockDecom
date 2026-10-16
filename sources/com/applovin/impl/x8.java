package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.impl.gl;
import com.applovin.impl.z8;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class x8 extends gl {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private z8 f64874n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private a f64875o;

    x8() {
    }

    private static boolean a(byte[] bArr) {
        return bArr[0] == -1;
    }

    private int b(ah ahVar) {
        int i3 = (ahVar.c()[2] & 255) >> 4;
        if (i3 == 6 || i3 == 7) {
            ahVar.g(4);
            ahVar.D();
        }
        int iB = v8.b(ahVar, i3);
        ahVar.f(0);
        return iB;
    }

    public static boolean c(ah ahVar) {
        return ahVar.a() >= 5 && ahVar.w() == 127 && ahVar.y() == 1179402563;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class a implements jg {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private z8 f64876a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private z8.a f64877b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f64878c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f64879d = -1;

        public a(z8 z8Var, z8.a aVar) {
            this.f64876a = z8Var;
            this.f64877b = aVar;
        }

        @Override // com.applovin.impl.jg
        public ij a() {
            b1.b(this.f64878c != -1);
            return new y8(this.f64876a, this.f64878c);
        }

        public void b(long j3) {
            this.f64878c = j3;
        }

        @Override // com.applovin.impl.jg
        public long a(k8 k8Var) {
            long j3 = this.f64879d;
            if (j3 < 0) {
                return -1L;
            }
            long j4 = -(j3 + 2);
            this.f64879d = -1L;
            return j4;
        }

        @Override // com.applovin.impl.jg
        public void a(long j3) {
            long[] jArr = this.f64877b.f65400a;
            this.f64879d = jArr[xp.b(jArr, j3, true, true)];
        }
    }

    @Override // com.applovin.impl.gl
    protected long a(ah ahVar) {
        if (a(ahVar.c())) {
            return b(ahVar);
        }
        return -1L;
    }

    @Override // com.applovin.impl.gl
    protected boolean a(ah ahVar, long j3, gl.b bVar) {
        byte[] bArrC = ahVar.c();
        z8 z8Var = this.f64874n;
        if (z8Var == null) {
            z8 z8Var2 = new z8(bArrC, 17);
            this.f64874n = z8Var2;
            bVar.f60010a = z8Var2.a(Arrays.copyOfRange(bArrC, 9, ahVar.e()), (af) null);
            return true;
        }
        if ((bArrC[0] & Ascii.DEL) == 3) {
            z8.a aVarA = w8.a(ahVar);
            z8 z8VarA = z8Var.a(aVarA);
            this.f64874n = z8VarA;
            this.f64875o = new a(z8VarA, aVarA);
            return true;
        }
        if (!a(bArrC)) {
            return true;
        }
        a aVar = this.f64875o;
        if (aVar != null) {
            aVar.b(j3);
            bVar.f60011b = this.f64875o;
        }
        b1.a(bVar.f60010a);
        return false;
    }

    @Override // com.applovin.impl.gl
    protected void a(boolean z2) {
        super.a(z2);
        if (z2) {
            this.f64874n = null;
            this.f64875o = null;
        }
    }
}
