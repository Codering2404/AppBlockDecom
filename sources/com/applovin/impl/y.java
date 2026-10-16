package com.applovin.impl;

import android.content.Context;
import android.text.SpannedString;
import android.text.TextUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class y extends dc {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final z f65081f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a0 f65082g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ir f65083h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f65084i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List f65085j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f65086k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final List f65087l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum a {
        INFO,
        BIDDERS,
        WATERFALL,
        COUNT
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b extends bg {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private final ir f65093p;

        b(ir irVar, String str, boolean z2) {
            super(irVar.b().d(), y.this.f59200a);
            this.f65093p = irVar;
            this.f58864c = StringUtils.createSpannedString(irVar.b().a(), -16777216, 18, 1);
            this.f58865d = !TextUtils.isEmpty(str) ? new SpannedString(str) : null;
            this.f58863b = z2;
        }

        @Override // com.applovin.impl.cc
        public int g() {
            return -12303292;
        }

        @Override // com.applovin.impl.bg, com.applovin.impl.cc
        public boolean o() {
            return this.f58863b;
        }

        public ir v() {
            return this.f65093p;
        }
    }

    y(z zVar, a0 a0Var, ir irVar, Context context) {
        super(context);
        this.f65081f = zVar;
        this.f65083h = irVar;
        this.f65082g = a0Var != null ? a0Var : zVar.f();
        this.f65084i = a0Var != null ? a0Var.c() : zVar.d();
        this.f65085j = h();
        this.f65086k = e();
        this.f65087l = l();
        notifyDataSetChanged();
    }

    private List e() {
        ir irVar = this.f65083h;
        if (irVar != null && !irVar.d()) {
            return new ArrayList();
        }
        List<ir> listA = this.f65082g.a();
        ArrayList arrayList = new ArrayList(listA.size());
        for (ir irVar2 : listA) {
            ir irVar3 = this.f65083h;
            if (irVar3 == null || irVar3.b().c().equals(irVar2.b().c())) {
                arrayList.add(new b(irVar2, irVar2.a() != null ? irVar2.a().a() : "", this.f65083h == null));
            }
        }
        return arrayList;
    }

    private cc f() {
        return cc.a().d("AB Test Experiment Name").c(j().b()).a();
    }

    private cc g() {
        return cc.a().d("ID").c(this.f65081f.c()).a();
    }

    private List h() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(g());
        arrayList.add(d());
        if (this.f65082g.b() != null) {
            arrayList.add(f());
        }
        if (this.f65083h != null) {
            arrayList.add(i());
        }
        return arrayList;
    }

    private cc i() {
        return cc.a().d("Selected Network").c(this.f65083h.b().a()).a();
    }

    private List l() {
        ir irVar = this.f65083h;
        if (irVar != null && irVar.d()) {
            return new ArrayList();
        }
        List<ir> listE = this.f65082g.e();
        ArrayList arrayList = new ArrayList(listE.size());
        for (ir irVar2 : listE) {
            ir irVar3 = this.f65083h;
            if (irVar3 == null || irVar3.b().c().equals(irVar2.b().c())) {
                arrayList.add(new b(irVar2, null, this.f65083h == null));
                for (cg cgVar : irVar2.c()) {
                    arrayList.add(cc.a().d(cgVar.a()).c(cgVar.b()).b(true).a());
                }
            }
        }
        return arrayList;
    }

    @Override // com.applovin.impl.dc
    protected int b() {
        return a.COUNT.ordinal();
    }

    @Override // com.applovin.impl.dc
    protected List c(int i3) {
        return i3 == a.INFO.ordinal() ? this.f65085j : i3 == a.BIDDERS.ordinal() ? this.f65086k : this.f65087l;
    }

    @Override // com.applovin.impl.dc
    protected int d(int i3) {
        return i3 == a.INFO.ordinal() ? this.f65085j.size() : i3 == a.BIDDERS.ordinal() ? this.f65086k.size() : this.f65087l.size();
    }

    public a0 j() {
        return this.f65082g;
    }

    public String k() {
        return this.f65084i;
    }

    private cc d() {
        return cc.a().d("Ad Format").c(this.f65081f.b()).a();
    }

    @Override // com.applovin.impl.dc
    protected cc e(int i3) {
        if (i3 == a.INFO.ordinal()) {
            return new fj("INFO");
        }
        if (i3 == a.BIDDERS.ordinal()) {
            return new fj("BIDDERS");
        }
        return new fj("WATERFALL");
    }
}
