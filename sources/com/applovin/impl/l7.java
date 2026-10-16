package com.applovin.impl;

import com.applovin.impl.dp;
import com.applovin.impl.e9;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class l7 implements p7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f61159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final qo[] f61160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f61161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f61162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f61163e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f61164f = -9223372036854775807L;

    public l7(List list) {
        this.f61159a = list;
        this.f61160b = new qo[list.size()];
    }

    private boolean a(ah ahVar, int i3) {
        if (ahVar.a() == 0) {
            return false;
        }
        if (ahVar.w() != i3) {
            this.f61161c = false;
        }
        this.f61162d--;
        return this.f61161c;
    }

    @Override // com.applovin.impl.p7
    public void b() {
        if (this.f61161c) {
            if (this.f61164f != -9223372036854775807L) {
                for (qo qoVar : this.f61160b) {
                    qoVar.a(this.f61164f, 1, this.f61163e, 0, null);
                }
            }
            this.f61161c = false;
        }
    }

    @Override // com.applovin.impl.p7
    public void a(ah ahVar) {
        if (this.f61161c) {
            if (this.f61162d != 2 || a(ahVar, 32)) {
                if (this.f61162d != 1 || a(ahVar, 0)) {
                    int iD = ahVar.d();
                    int iA = ahVar.a();
                    for (qo qoVar : this.f61160b) {
                        ahVar.f(iD);
                        qoVar.a(ahVar, iA);
                    }
                    this.f61163e += iA;
                }
            }
        }
    }

    @Override // com.applovin.impl.p7
    public void a(l8 l8Var, dp.d dVar) {
        for (int i3 = 0; i3 < this.f61160b.length; i3++) {
            dp.a aVar = (dp.a) this.f61159a.get(i3);
            dVar.a();
            qo qoVarA = l8Var.a(dVar.c(), 3);
            qoVarA.a(new e9.b().c(dVar.b()).f("application/dvbsubs").a(Collections.singletonList(aVar.f59280c)).e(aVar.f59278a).a());
            this.f61160b[i3] = qoVarA;
        }
    }

    @Override // com.applovin.impl.p7
    public void a(long j3, int i3) {
        if ((i3 & 4) == 0) {
            return;
        }
        this.f61161c = true;
        if (j3 != -9223372036854775807L) {
            this.f61164f = j3;
        }
        this.f61163e = 0;
        this.f61162d = 2;
    }

    @Override // com.applovin.impl.p7
    public void a() {
        this.f61161c = false;
        this.f61164f = -9223372036854775807L;
    }
}
