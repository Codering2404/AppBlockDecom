package com.applovin.impl;

import com.applovin.impl.dp;
import com.applovin.impl.e9;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class nj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f62065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final qo[] f62066b;

    public nj(List list) {
        this.f62065a = list;
        this.f62066b = new qo[list.size()];
    }

    public void a(long j3, ah ahVar) {
        c3.a(j3, ahVar, this.f62066b);
    }

    public void a(l8 l8Var, dp.d dVar) {
        for (int i3 = 0; i3 < this.f62066b.length; i3++) {
            dVar.a();
            qo qoVarA = l8Var.a(dVar.c(), 3);
            e9 e9Var = (e9) this.f62065a.get(i3);
            String str = e9Var.f59394m;
            b1.a("application/cea-608".equals(str) || "application/cea-708".equals(str), "Invalid closed caption mime type provided: " + str);
            String strB = e9Var.f59383a;
            if (strB == null) {
                strB = dVar.b();
            }
            qoVarA.a(new e9.b().c(strB).f(str).o(e9Var.f59386d).e(e9Var.f59385c).a(e9Var.E).a(e9Var.f59396o).a());
            this.f62066b[i3] = qoVarA;
        }
    }
}
