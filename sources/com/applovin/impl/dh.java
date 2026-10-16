package com.applovin.impl;

import com.applovin.impl.dp;
import com.applovin.impl.e9;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class dh implements gj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e9 f59241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ho f59242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private qo f59243c;

    public dh(String str) {
        this.f59241a = new e9.b().f(str).a();
    }

    private void a() {
        b1.b(this.f59242b);
        xp.a(this.f59243c);
    }

    @Override // com.applovin.impl.gj
    public void a(ah ahVar) {
        a();
        long jB = this.f59242b.b();
        long jC = this.f59242b.c();
        if (jB == -9223372036854775807L || jC == -9223372036854775807L) {
            return;
        }
        e9 e9Var = this.f59241a;
        if (jC != e9Var.f59398q) {
            e9 e9VarA = e9Var.a().a(jC).a();
            this.f59241a = e9VarA;
            this.f59243c.a(e9VarA);
        }
        int iA = ahVar.a();
        this.f59243c.a(ahVar, iA);
        this.f59243c.a(jB, 1, iA, 0, null);
    }

    @Override // com.applovin.impl.gj
    public void a(ho hoVar, l8 l8Var, dp.d dVar) {
        this.f59242b = hoVar;
        dVar.a();
        qo qoVarA = l8Var.a(dVar.c(), 5);
        this.f59243c = qoVarA;
        qoVarA.a(this.f59241a);
    }
}
