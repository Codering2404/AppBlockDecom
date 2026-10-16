package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class ig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f60446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f60447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f60448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f60449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f60450e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f60451f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f60452g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f60453h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f60454i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f60455j = new int[255];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ah f60456k = new ah(255);

    ig() {
    }

    public boolean a(k8 k8Var, boolean z2) throws ch {
        a();
        this.f60456k.d(27);
        if (!m8.a(k8Var, this.f60456k.c(), 0, 27, z2) || this.f60456k.y() != 1332176723) {
            return false;
        }
        int iW = this.f60456k.w();
        this.f60446a = iW;
        if (iW != 0) {
            if (z2) {
                return false;
            }
            throw ch.a("unsupported bit stream revision");
        }
        this.f60447b = this.f60456k.w();
        this.f60448c = this.f60456k.n();
        this.f60449d = this.f60456k.p();
        this.f60450e = this.f60456k.p();
        this.f60451f = this.f60456k.p();
        int iW2 = this.f60456k.w();
        this.f60452g = iW2;
        this.f60453h = iW2 + 27;
        this.f60456k.d(iW2);
        if (!m8.a(k8Var, this.f60456k.c(), 0, this.f60452g, z2)) {
            return false;
        }
        for (int i3 = 0; i3 < this.f60452g; i3++) {
            this.f60455j[i3] = this.f60456k.w();
            this.f60454i += this.f60455j[i3];
        }
        return true;
    }

    public void a() {
        this.f60446a = 0;
        this.f60447b = 0;
        this.f60448c = 0L;
        this.f60449d = 0L;
        this.f60450e = 0L;
        this.f60451f = 0L;
        this.f60452g = 0;
        this.f60453h = 0;
        this.f60454i = 0;
    }

    public boolean a(k8 k8Var) {
        return a(k8Var, -1L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
    
        if (r10 == (-1)) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
    
        if (r9.f() >= r10) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0060, code lost:
    
        if (r9.b(1) == (-1)) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0063, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(com.applovin.impl.k8 r9, long r10) {
        /*
            r8 = this;
            long r0 = r9.f()
            long r2 = r9.d()
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = r2
            goto L11
        L10:
            r0 = r1
        L11:
            com.applovin.impl.b1.a(r0)
            com.applovin.impl.ah r0 = r8.f60456k
            r3 = 4
            r0.d(r3)
        L1a:
            r4 = -1
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 == 0) goto L2b
            long r4 = r9.f()
            r6 = 4
            long r4 = r4 + r6
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 >= 0) goto L51
        L2b:
            com.applovin.impl.ah r4 = r8.f60456k
            byte[] r4 = r4.c()
            boolean r4 = com.applovin.impl.m8.a(r9, r4, r1, r3, r2)
            if (r4 == 0) goto L51
            com.applovin.impl.ah r0 = r8.f60456k
            r0.f(r1)
            com.applovin.impl.ah r0 = r8.f60456k
            long r4 = r0.y()
            r6 = 1332176723(0x4f676753, double:6.58182753E-315)
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L4d
            r9.b()
            return r2
        L4d:
            r9.a(r2)
            goto L1a
        L51:
            if (r0 == 0) goto L5b
            long r3 = r9.f()
            int r3 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r3 >= 0) goto L63
        L5b:
            int r3 = r9.b(r2)
            r4 = -1
            if (r3 == r4) goto L63
            goto L51
        L63:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.ig.a(com.applovin.impl.k8, long):boolean");
    }
}
