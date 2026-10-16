package com.applovin.impl;

import com.applovin.impl.ae;
import com.applovin.impl.fo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class wc extends b4 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ae f64628j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f64629k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final fo.d f64630l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final fo.b f64631m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private a f64632n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private vc f64633o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f64634p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f64635q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f64636r;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class a extends h9 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final Object f64637g = new Object();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Object f64638d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Object f64639f;

        private a(fo foVar, Object obj, Object obj2) {
            super(foVar);
            this.f64638d = obj;
            this.f64639f = obj2;
        }

        @Override // com.applovin.impl.h9, com.applovin.impl.fo
        public Object b(int i3) {
            Object objB = this.f60153c.b(i3);
            return xp.a(objB, this.f64639f) ? f64637g : objB;
        }

        @Override // com.applovin.impl.h9, com.applovin.impl.fo
        public int a(Object obj) {
            Object obj2;
            fo foVar = this.f60153c;
            if (f64637g.equals(obj) && (obj2 = this.f64639f) != null) {
                obj = obj2;
            }
            return foVar.a(obj);
        }

        @Override // com.applovin.impl.h9, com.applovin.impl.fo
        public fo.b a(int i3, fo.b bVar, boolean z2) {
            this.f60153c.a(i3, bVar, z2);
            if (xp.a(bVar.f59736b, this.f64639f) && z2) {
                bVar.f59736b = f64637g;
            }
            return bVar;
        }

        @Override // com.applovin.impl.h9, com.applovin.impl.fo
        public fo.d a(int i3, fo.d dVar, long j3) {
            this.f60153c.a(i3, dVar, j3);
            if (xp.a(dVar.f59750a, this.f64638d)) {
                dVar.f59750a = fo.d.f59746s;
            }
            return dVar;
        }

        public static a a(sd sdVar) {
            return new a(new b(sdVar), fo.d.f59746s, f64637g);
        }

        public static a a(fo foVar, Object obj, Object obj2) {
            return new a(foVar, obj, obj2);
        }

        public a a(fo foVar) {
            return new a(foVar, this.f64638d, this.f64639f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b extends fo {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final sd f64640c;

        public b(sd sdVar) {
            this.f64640c = sdVar;
        }

        @Override // com.applovin.impl.fo
        public int a() {
            return 1;
        }

        @Override // com.applovin.impl.fo
        public int b() {
            return 1;
        }

        @Override // com.applovin.impl.fo
        public int a(Object obj) {
            return obj == a.f64637g ? 0 : -1;
        }

        @Override // com.applovin.impl.fo
        public Object b(int i3) {
            return a.f64637g;
        }

        @Override // com.applovin.impl.fo
        public fo.b a(int i3, fo.b bVar, boolean z2) {
            bVar.a(z2 ? 0 : null, z2 ? a.f64637g : null, 0, -9223372036854775807L, 0L, u.f64003h, true);
            return bVar;
        }

        @Override // com.applovin.impl.fo
        public fo.d a(int i3, fo.d dVar, long j3) {
            dVar.a(fo.d.f59746s, this.f64640c, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, null, 0L, -9223372036854775807L, 0, 0, 0L);
            dVar.f59761m = true;
            return dVar;
        }
    }

    public wc(ae aeVar, boolean z2) {
        this.f64628j = aeVar;
        this.f64629k = z2 && aeVar.c();
        this.f64630l = new fo.d();
        this.f64631m = new fo.b();
        fo foVarD = aeVar.d();
        if (foVarD == null) {
            this.f64632n = a.a(aeVar.a());
        } else {
            this.f64632n = a.a(foVarD, (Object) null, (Object) null);
            this.f64636r = true;
        }
    }

    @Override // com.applovin.impl.ae
    public void b() {
    }

    @Override // com.applovin.impl.b4, com.applovin.impl.c2
    public void h() {
        this.f64635q = false;
        this.f64634p = false;
        super.h();
    }

    public fo i() {
        return this.f64632n;
    }

    private Object a(Object obj) {
        return (this.f64632n.f64639f == null || !this.f64632n.f64639f.equals(obj)) ? obj : a.f64637g;
    }

    @Override // com.applovin.impl.ae
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public vc a(ae.a aVar, n0 n0Var, long j3) {
        vc vcVar = new vc(aVar, n0Var, j3);
        vcVar.a(this.f64628j);
        if (this.f64635q) {
            vcVar.a(aVar.b(b(aVar.f64962a)));
            return vcVar;
        }
        this.f64633o = vcVar;
        if (!this.f64634p) {
            this.f64634p = true;
            a((Object) null, this.f64628j);
        }
        return vcVar;
    }

    @Override // com.applovin.impl.ae
    public sd a() {
        return this.f64628j.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.applovin.impl.b4
    public ae.a a(Void r12, ae.a aVar) {
        return aVar.b(a(aVar.f64962a));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // com.applovin.impl.b4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.Void r13, com.applovin.impl.ae r14, com.applovin.impl.fo r15) {
        /*
            r12 = this;
            boolean r13 = r12.f64635q
            if (r13 == 0) goto L19
            com.applovin.impl.wc$a r13 = r12.f64632n
            com.applovin.impl.wc$a r13 = r13.a(r15)
            r12.f64632n = r13
            com.applovin.impl.vc r13 = r12.f64633o
            if (r13 == 0) goto Lae
            long r13 = r13.c()
            r12.a(r13)
            goto Lae
        L19:
            boolean r13 = r15.c()
            if (r13 == 0) goto L36
            boolean r13 = r12.f64636r
            if (r13 == 0) goto L2a
            com.applovin.impl.wc$a r13 = r12.f64632n
            com.applovin.impl.wc$a r13 = r13.a(r15)
            goto L32
        L2a:
            java.lang.Object r13 = com.applovin.impl.fo.d.f59746s
            java.lang.Object r14 = com.applovin.impl.wc.a.f64637g
            com.applovin.impl.wc$a r13 = com.applovin.impl.wc.a.a(r15, r13, r14)
        L32:
            r12.f64632n = r13
            goto Lae
        L36:
            com.applovin.impl.fo$d r13 = r12.f64630l
            r14 = 0
            r15.a(r14, r13)
            com.applovin.impl.fo$d r13 = r12.f64630l
            long r0 = r13.c()
            com.applovin.impl.fo$d r13 = r12.f64630l
            java.lang.Object r13 = r13.f59750a
            com.applovin.impl.vc r2 = r12.f64633o
            if (r2 == 0) goto L74
            long r2 = r2.d()
            com.applovin.impl.wc$a r4 = r12.f64632n
            com.applovin.impl.vc r5 = r12.f64633o
            com.applovin.impl.ae$a r5 = r5.f64413a
            java.lang.Object r5 = r5.f64962a
            com.applovin.impl.fo$b r6 = r12.f64631m
            r4.a(r5, r6)
            com.applovin.impl.fo$b r4 = r12.f64631m
            long r4 = r4.e()
            long r4 = r4 + r2
            com.applovin.impl.wc$a r2 = r12.f64632n
            com.applovin.impl.fo$d r3 = r12.f64630l
            com.applovin.impl.fo$d r14 = r2.a(r14, r3)
            long r2 = r14.c()
            int r14 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r14 == 0) goto L74
            r10 = r4
            goto L75
        L74:
            r10 = r0
        L75:
            com.applovin.impl.fo$d r7 = r12.f64630l
            com.applovin.impl.fo$b r8 = r12.f64631m
            r9 = 0
            r6 = r15
            android.util.Pair r14 = r6.a(r7, r8, r9, r10)
            java.lang.Object r15 = r14.first
            java.lang.Object r14 = r14.second
            java.lang.Long r14 = (java.lang.Long) r14
            long r0 = r14.longValue()
            boolean r14 = r12.f64636r
            if (r14 == 0) goto L94
            com.applovin.impl.wc$a r13 = r12.f64632n
            com.applovin.impl.wc$a r13 = r13.a(r6)
            goto L98
        L94:
            com.applovin.impl.wc$a r13 = com.applovin.impl.wc.a.a(r6, r13, r15)
        L98:
            r12.f64632n = r13
            com.applovin.impl.vc r13 = r12.f64633o
            if (r13 == 0) goto Lae
            r12.a(r0)
            com.applovin.impl.ae$a r13 = r13.f64413a
            java.lang.Object r14 = r13.f64962a
            java.lang.Object r14 = r12.b(r14)
            com.applovin.impl.ae$a r13 = r13.b(r14)
            goto Laf
        Lae:
            r13 = 0
        Laf:
            r14 = 1
            r12.f64636r = r14
            r12.f64635q = r14
            com.applovin.impl.wc$a r14 = r12.f64632n
            r12.a(r14)
            if (r13 == 0) goto Lc6
            com.applovin.impl.vc r14 = r12.f64633o
            java.lang.Object r14 = com.applovin.impl.b1.a(r14)
            com.applovin.impl.vc r14 = (com.applovin.impl.vc) r14
            r14.a(r13)
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.wc.a(java.lang.Void, com.applovin.impl.ae, com.applovin.impl.fo):void");
    }

    private Object b(Object obj) {
        return (this.f64632n.f64639f == null || !obj.equals(a.f64637g)) ? obj : this.f64632n.f64639f;
    }

    @Override // com.applovin.impl.b4, com.applovin.impl.c2
    public void a(xo xoVar) {
        super.a(xoVar);
        if (this.f64629k) {
            return;
        }
        this.f64634p = true;
        a((Object) null, this.f64628j);
    }

    @Override // com.applovin.impl.ae
    public void a(vd vdVar) {
        ((vc) vdVar).i();
        if (vdVar == this.f64633o) {
            this.f64633o = null;
        }
    }

    private void a(long j3) {
        vc vcVar = this.f64633o;
        int iA = this.f64632n.a(vcVar.f64413a.f64962a);
        if (iA == -1) {
            return;
        }
        long j4 = this.f64632n.a(iA, this.f64631m).f59738d;
        if (j4 != -9223372036854775807L && j3 >= j4) {
            j3 = Math.max(0L, j4 - 1);
        }
        vcVar.e(j3);
    }
}
