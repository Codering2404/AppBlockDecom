package com.applovin.impl;

import com.applovin.impl.e9;
import com.applovin.impl.xl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class yq extends xl {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ah f65252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ah f65253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f65254d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f65255e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f65256f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f65257g;

    public yq(qo qoVar) {
        super(qoVar);
        this.f65252b = new ah(yf.f65192a);
        this.f65253c = new ah(4);
    }

    @Override // com.applovin.impl.xl
    protected boolean a(ah ahVar) throws xl.a {
        int iW = ahVar.w();
        int i3 = (iW >> 4) & 15;
        int i4 = iW & 15;
        if (i4 == 7) {
            this.f65257g = i3;
            return i3 != 5;
        }
        throw new xl.a("Video format not supported: " + i4);
    }

    @Override // com.applovin.impl.xl
    protected boolean b(ah ahVar, long j3) throws ch {
        int iW = ahVar.w();
        long jK = j3 + (((long) ahVar.k()) * 1000);
        if (iW == 0 && !this.f65255e) {
            ah ahVar2 = new ah(new byte[ahVar.a()]);
            ahVar.a(ahVar2.c(), 0, ahVar.a());
            w1 w1VarB = w1.b(ahVar2);
            this.f65254d = w1VarB.f64528b;
            this.f65002a.a(new e9.b().f("video/avc").a(w1VarB.f64532f).q(w1VarB.f64529c).g(w1VarB.f64530d).b(w1VarB.f64531e).a(w1VarB.f64527a).a());
            this.f65255e = true;
            return false;
        }
        if (iW != 1 || !this.f65255e) {
            return false;
        }
        int i3 = this.f65257g == 1 ? 1 : 0;
        if (!this.f65256f && i3 == 0) {
            return false;
        }
        byte[] bArrC = this.f65253c.c();
        bArrC[0] = 0;
        bArrC[1] = 0;
        bArrC[2] = 0;
        int i4 = 4 - this.f65254d;
        int i5 = 0;
        while (ahVar.a() > 0) {
            ahVar.a(this.f65253c.c(), i4, this.f65254d);
            this.f65253c.f(0);
            int iA = this.f65253c.A();
            this.f65252b.f(0);
            this.f65002a.a(this.f65252b, 4);
            this.f65002a.a(ahVar, iA);
            i5 = i5 + 4 + iA;
        }
        this.f65002a.a(jK, i3, i5, 0, null);
        this.f65256f = true;
        return true;
    }
}
