package com.applovin.impl;

import com.applovin.impl.ij;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class i6 implements jg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ig f60350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f60351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f60352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final gl f60353d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f60354e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f60355f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f60356g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f60357h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f60358i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f60359j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f60360k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f60361l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class b implements ij {
        private b() {
        }

        @Override // com.applovin.impl.ij
        public boolean b() {
            return true;
        }

        @Override // com.applovin.impl.ij
        public long d() {
            return i6.this.f60353d.a(i6.this.f60355f);
        }

        @Override // com.applovin.impl.ij
        public ij.a b(long j3) {
            return new ij.a(new kj(j3, xp.b((i6.this.f60351b + ((i6.this.f60353d.b(j3) * (i6.this.f60352c - i6.this.f60351b)) / i6.this.f60355f)) - 30000, i6.this.f60351b, i6.this.f60352c - 1)));
        }
    }

    public i6(gl glVar, long j3, long j4, long j5, long j6, boolean z2) {
        b1.a(j3 >= 0 && j4 > j3);
        this.f60353d = glVar;
        this.f60351b = j3;
        this.f60352c = j4;
        if (j5 == j4 - j3 || z2) {
            this.f60355f = j6;
            this.f60354e = 4;
        } else {
            this.f60354e = 0;
        }
        this.f60350a = new ig();
    }

    private void d(k8 k8Var) throws ch {
        while (true) {
            this.f60350a.a(k8Var);
            this.f60350a.a(k8Var, false);
            ig igVar = this.f60350a;
            if (igVar.f60448c > this.f60357h) {
                k8Var.b();
                return;
            } else {
                k8Var.a(igVar.f60453h + igVar.f60454i);
                this.f60358i = k8Var.f();
                this.f60360k = this.f60350a.f60448c;
            }
        }
    }

    @Override // com.applovin.impl.jg
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b a() {
        if (this.f60355f != 0) {
            return new b();
        }
        return null;
    }

    long c(k8 k8Var) throws ch, EOFException {
        this.f60350a.a();
        if (!this.f60350a.a(k8Var)) {
            throw new EOFException();
        }
        this.f60350a.a(k8Var, false);
        ig igVar = this.f60350a;
        k8Var.a(igVar.f60453h + igVar.f60454i);
        long j3 = this.f60350a.f60448c;
        while (true) {
            ig igVar2 = this.f60350a;
            if ((igVar2.f60447b & 4) == 4 || !igVar2.a(k8Var) || k8Var.f() >= this.f60352c || !this.f60350a.a(k8Var, true)) {
                break;
            }
            ig igVar3 = this.f60350a;
            if (!m8.a(k8Var, igVar3.f60453h + igVar3.f60454i)) {
                break;
            }
            j3 = this.f60350a.f60448c;
        }
        return j3;
    }

    private long b(k8 k8Var) throws IOException {
        if (this.f60358i == this.f60359j) {
            return -1L;
        }
        long jF = k8Var.f();
        if (!this.f60350a.a(k8Var, this.f60359j)) {
            long j3 = this.f60358i;
            if (j3 != jF) {
                return j3;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.f60350a.a(k8Var, false);
        k8Var.b();
        long j4 = this.f60357h;
        ig igVar = this.f60350a;
        long j5 = igVar.f60448c;
        long j6 = j4 - j5;
        int i3 = igVar.f60453h + igVar.f60454i;
        if (0 <= j6 && j6 < 72000) {
            return -1L;
        }
        if (j6 < 0) {
            this.f60359j = jF;
            this.f60361l = j5;
        } else {
            this.f60358i = k8Var.f() + ((long) i3);
            this.f60360k = this.f60350a.f60448c;
        }
        long j7 = this.f60359j;
        long j8 = this.f60358i;
        if (j7 - j8 < 100000) {
            this.f60359j = j8;
            return j8;
        }
        long jF2 = k8Var.f() - (((long) i3) * (j6 <= 0 ? 2L : 1L));
        long j9 = this.f60359j;
        long j10 = this.f60358i;
        return xp.b(jF2 + ((j6 * (j9 - j10)) / (this.f60361l - this.f60360k)), j10, j9 - 1);
    }

    @Override // com.applovin.impl.jg
    public long a(k8 k8Var) throws IOException {
        int i3 = this.f60354e;
        if (i3 == 0) {
            long jF = k8Var.f();
            this.f60356g = jF;
            this.f60354e = 1;
            long j3 = this.f60352c - 65307;
            if (j3 > jF) {
                return j3;
            }
        } else if (i3 != 1) {
            if (i3 == 2) {
                long jB = b(k8Var);
                if (jB != -1) {
                    return jB;
                }
                this.f60354e = 3;
            } else if (i3 != 3) {
                if (i3 == 4) {
                    return -1L;
                }
                throw new IllegalStateException();
            }
            d(k8Var);
            this.f60354e = 4;
            return -(this.f60360k + 2);
        }
        this.f60355f = c(k8Var);
        this.f60354e = 4;
        return this.f60356g;
    }

    @Override // com.applovin.impl.jg
    public void a(long j3) {
        this.f60357h = xp.b(j3, 0L, this.f60355f - 1);
        this.f60354e = 2;
        this.f60358i = this.f60351b;
        this.f60359j = this.f60352c;
        this.f60360k = 0L;
        this.f60361l = this.f60355f;
    }
}
