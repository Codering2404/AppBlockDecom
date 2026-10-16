package com.applovin.impl;

import com.applovin.impl.ae;
import com.applovin.impl.ai;
import com.applovin.impl.bi;
import com.applovin.impl.fo;
import com.applovin.impl.h5;
import com.applovin.impl.sd;
import com.applovin.impl.zh;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class bi extends c2 implements ai.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final sd f58650g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final sd.g f58651h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final h5.a f58652i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zh.a f58653j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final a7 f58654k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final lc f58655l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f58656m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f58657n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f58658o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f58659p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f58660q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private xo f58661r;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b implements ce {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final h5.a f58663a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private zh.a f58664b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private b7 f58665c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private lc f58666d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f58667e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f58668f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Object f58669g;

        public b(h5.a aVar) {
            this(aVar, new b6());
        }

        public bi a(sd sdVar) {
            b1.a(sdVar.f63036b);
            sd.g gVar = sdVar.f63036b;
            boolean z2 = false;
            boolean z3 = gVar.f63095g == null && this.f58669g != null;
            if (gVar.f63093e == null && this.f58668f != null) {
                z2 = true;
            }
            if (z3 && z2) {
                sdVar = sdVar.a().a(this.f58669g).a(this.f58668f).a();
            } else if (z3) {
                sdVar = sdVar.a().a(this.f58669g).a();
            } else if (z2) {
                sdVar = sdVar.a().a(this.f58668f).a();
            }
            sd sdVar2 = sdVar;
            return new bi(sdVar2, this.f58663a, this.f58664b, this.f58665c.a(sdVar2), this.f58666d, this.f58667e, null);
        }

        public b(h5.a aVar, final n8 n8Var) {
            this(aVar, new zh.a() { // from class: com.applovin.impl.yt
                @Override // com.applovin.impl.zh.a
                public final zh a() {
                    return bi.b.a(n8Var);
                }
            });
        }

        public b(h5.a aVar, zh.a aVar2) {
            this.f58663a = aVar;
            this.f58664b = aVar2;
            this.f58665c = new y5();
            this.f58666d = new f6();
            this.f58667e = 1048576;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ zh a(n8 n8Var) {
            return new q2(n8Var);
        }
    }

    private bi(sd sdVar, h5.a aVar, zh.a aVar2, a7 a7Var, lc lcVar, int i3) {
        this.f58651h = (sd.g) b1.a(sdVar.f63036b);
        this.f58650g = sdVar;
        this.f58652i = aVar;
        this.f58653j = aVar2;
        this.f58654k = a7Var;
        this.f58655l = lcVar;
        this.f58656m = i3;
        this.f58657n = true;
        this.f58658o = -9223372036854775807L;
    }

    private void i() {
        fo gkVar = new gk(this.f58658o, this.f58659p, false, this.f58660q, null, this.f58650g);
        if (this.f58657n) {
            gkVar = new a(gkVar);
        }
        a(gkVar);
    }

    @Override // com.applovin.impl.ae
    public vd a(ae.a aVar, n0 n0Var, long j3) {
        h5 h5VarA = this.f58652i.a();
        xo xoVar = this.f58661r;
        if (xoVar != null) {
            h5VarA.a(xoVar);
        }
        return new ai(this.f58651h.f63089a, h5VarA, this.f58653j.a(), this.f58654k, a(aVar), this.f58655l, b(aVar), this, n0Var, this.f58651h.f63093e, this.f58656m);
    }

    @Override // com.applovin.impl.c2
    protected void h() {
        this.f58654k.a();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends h9 {
        a(fo foVar) {
            super(foVar);
        }

        @Override // com.applovin.impl.h9, com.applovin.impl.fo
        public fo.b a(int i3, fo.b bVar, boolean z2) {
            super.a(i3, bVar, z2);
            bVar.f59740g = true;
            return bVar;
        }

        @Override // com.applovin.impl.h9, com.applovin.impl.fo
        public fo.d a(int i3, fo.d dVar, long j3) {
            super.a(i3, dVar, j3);
            dVar.f59761m = true;
            return dVar;
        }
    }

    @Override // com.applovin.impl.ae
    public sd a() {
        return this.f58650g;
    }

    @Override // com.applovin.impl.ai.b
    public void a(long j3, boolean z2, boolean z3) {
        if (j3 == -9223372036854775807L) {
            j3 = this.f58658o;
        }
        if (!this.f58657n && this.f58658o == j3 && this.f58659p == z2 && this.f58660q == z3) {
            return;
        }
        this.f58658o = j3;
        this.f58659p = z2;
        this.f58660q = z3;
        this.f58657n = false;
        i();
    }

    /* synthetic */ bi(sd sdVar, h5.a aVar, zh.a aVar2, a7 a7Var, lc lcVar, int i3, a aVar3) {
        this(sdVar, aVar, aVar2, a7Var, lcVar, i3);
    }

    @Override // com.applovin.impl.c2
    protected void a(xo xoVar) {
        this.f58661r = xoVar;
        this.f58654k.b();
        i();
    }

    @Override // com.applovin.impl.ae
    public void b() {
    }

    @Override // com.applovin.impl.ae
    public void a(vd vdVar) {
        ((ai) vdVar).t();
    }
}
