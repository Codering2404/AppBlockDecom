package com.applovin.impl;

import com.applovin.impl.ij;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class i2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final a f60306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final f f60307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected c f60308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f60309d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class a implements ij {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f60310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f60311b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f60312c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f60313d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long f60314e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final long f60315f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final long f60316g;

        public a(d dVar, long j3, long j4, long j5, long j6, long j7, long j8) {
            this.f60310a = dVar;
            this.f60311b = j3;
            this.f60312c = j4;
            this.f60313d = j5;
            this.f60314e = j6;
            this.f60315f = j7;
            this.f60316g = j8;
        }

        @Override // com.applovin.impl.ij
        public boolean b() {
            return true;
        }

        public long c(long j3) {
            return this.f60310a.a(j3);
        }

        @Override // com.applovin.impl.ij
        public long d() {
            return this.f60311b;
        }

        @Override // com.applovin.impl.ij
        public ij.a b(long j3) {
            return new ij.a(new kj(j3, c.a(this.f60310a.a(j3), this.f60312c, this.f60313d, this.f60314e, this.f60315f, this.f60316g)));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f60317a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f60318b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f60319c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f60320d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f60321e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f60322f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f60323g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f60324h;

        protected c(long j3, long j4, long j5, long j6, long j7, long j8, long j9) {
            this.f60317a = j3;
            this.f60318b = j4;
            this.f60320d = j5;
            this.f60321e = j6;
            this.f60322f = j7;
            this.f60323g = j8;
            this.f60319c = j9;
            this.f60324h = a(j4, j5, j6, j7, j8, j9);
        }

        private void f() {
            this.f60324h = a(this.f60318b, this.f60320d, this.f60321e, this.f60322f, this.f60323g, this.f60319c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long c() {
            return this.f60324h;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long d() {
            return this.f60317a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long e() {
            return this.f60318b;
        }

        protected static long a(long j3, long j4, long j5, long j6, long j7, long j8) {
            if (j6 + 1 >= j7 || j4 + 1 >= j5) {
                return j6;
            }
            long j9 = (long) ((j3 - j4) * ((j7 - j6) / (j5 - j4)));
            return xp.b(((j9 + j6) - j8) - (j9 / 20), j6, j7 - 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long b() {
            return this.f60322f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(long j3, long j4) {
            this.f60320d = j3;
            this.f60322f = j4;
            f();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long a() {
            return this.f60323g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(long j3, long j4) {
            this.f60321e = j3;
            this.f60323g = j4;
            f();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected interface d {
        long a(long j3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class e {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final e f60325d = new e(-3, -9223372036854775807L, -1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f60326a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f60327b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f60328c;

        private e(int i3, long j3, long j4) {
            this.f60326a = i3;
            this.f60327b = j3;
            this.f60328c = j4;
        }

        public static e a(long j3, long j4) {
            return new e(-1, j3, j4);
        }

        public static e b(long j3, long j4) {
            return new e(-2, j3, j4);
        }

        public static e a(long j3) {
            return new e(0, -9223372036854775807L, j3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    protected interface f {
        e a(k8 k8Var, long j3);

        default void a() {
        }
    }

    protected i2(d dVar, f fVar, long j3, long j4, long j5, long j6, long j7, long j8, int i3) {
        this.f60307b = fVar;
        this.f60309d = i3;
        this.f60306a = new a(dVar, j3, j4, j5, j6, j7, j8);
    }

    public final ij a() {
        return this.f60306a;
    }

    protected void b(boolean z2, long j3) {
    }

    public int a(k8 k8Var, th thVar) {
        while (true) {
            c cVar = (c) b1.b(this.f60308c);
            long jB = cVar.b();
            long jA = cVar.a();
            long jC = cVar.c();
            if (jA - jB <= this.f60309d) {
                a(false, jB);
                return a(k8Var, jB, thVar);
            }
            if (!a(k8Var, jC)) {
                return a(k8Var, jC, thVar);
            }
            k8Var.b();
            e eVarA = this.f60307b.a(k8Var, cVar.e());
            int i3 = eVarA.f60326a;
            if (i3 == -3) {
                a(false, jC);
                return a(k8Var, jC, thVar);
            }
            if (i3 == -2) {
                cVar.b(eVarA.f60327b, eVarA.f60328c);
            } else {
                if (i3 != -1) {
                    if (i3 != 0) {
                        throw new IllegalStateException("Invalid case");
                    }
                    a(k8Var, eVarA.f60328c);
                    a(true, eVarA.f60328c);
                    return a(k8Var, eVarA.f60328c, thVar);
                }
                cVar.a(eVarA.f60327b, eVarA.f60328c);
            }
        }
    }

    public final boolean b() {
        return this.f60308c != null;
    }

    public final void b(long j3) {
        c cVar = this.f60308c;
        if (cVar == null || cVar.d() != j3) {
            this.f60308c = a(j3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b implements d {
        @Override // com.applovin.impl.i2.d
        public long a(long j3) {
            return j3;
        }
    }

    protected final void a(boolean z2, long j3) {
        this.f60308c = null;
        this.f60307b.a();
        b(z2, j3);
    }

    protected final int a(k8 k8Var, long j3, th thVar) {
        if (j3 == k8Var.f()) {
            return 0;
        }
        thVar.f63943a = j3;
        return 1;
    }

    protected final boolean a(k8 k8Var, long j3) {
        long jF = j3 - k8Var.f();
        if (jF < 0 || jF > 262144) {
            return false;
        }
        k8Var.a((int) jF);
        return true;
    }

    protected c a(long j3) {
        return new c(j3, this.f60306a.c(j3), this.f60306a.f60312c, this.f60306a.f60313d, this.f60306a.f60314e, this.f60306a.f60315f, this.f60306a.f60316g);
    }
}
