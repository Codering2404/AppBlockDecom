package com.applovin.impl;

import com.applovin.impl.dp;
import com.applovin.impl.e9;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class za implements p7 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private qo f65409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f65410c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f65412e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f65413f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ah f65408a = new ah(10);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f65411d = -9223372036854775807L;

    @Override // com.applovin.impl.p7
    public void a(ah ahVar) {
        b1.b(this.f65409b);
        if (this.f65410c) {
            int iA = ahVar.a();
            int i3 = this.f65413f;
            if (i3 < 10) {
                int iMin = Math.min(iA, 10 - i3);
                System.arraycopy(ahVar.c(), ahVar.d(), this.f65408a.c(), this.f65413f, iMin);
                if (this.f65413f + iMin == 10) {
                    this.f65408a.f(0);
                    if (73 != this.f65408a.w() || 68 != this.f65408a.w() || 51 != this.f65408a.w()) {
                        oc.d("Id3Reader", "Discarding invalid ID3 tag");
                        this.f65410c = false;
                        return;
                    } else {
                        this.f65408a.g(3);
                        this.f65412e = this.f65408a.v() + 10;
                    }
                }
            }
            int iMin2 = Math.min(iA, this.f65412e - this.f65413f);
            this.f65409b.a(ahVar, iMin2);
            this.f65413f += iMin2;
        }
    }

    @Override // com.applovin.impl.p7
    public void b() {
        int i3;
        b1.b(this.f65409b);
        if (this.f65410c && (i3 = this.f65412e) != 0 && this.f65413f == i3) {
            long j3 = this.f65411d;
            if (j3 != -9223372036854775807L) {
                this.f65409b.a(j3, 1, i3, 0, null);
            }
            this.f65410c = false;
        }
    }

    @Override // com.applovin.impl.p7
    public void a(l8 l8Var, dp.d dVar) {
        dVar.a();
        qo qoVarA = l8Var.a(dVar.c(), 5);
        this.f65409b = qoVarA;
        qoVarA.a(new e9.b().c(dVar.b()).f("application/id3").a());
    }

    @Override // com.applovin.impl.p7
    public void a(long j3, int i3) {
        if ((i3 & 4) == 0) {
            return;
        }
        this.f65410c = true;
        if (j3 != -9223372036854775807L) {
            this.f65411d = j3;
        }
        this.f65412e = 0;
        this.f65413f = 0;
    }

    @Override // com.applovin.impl.p7
    public void a() {
        this.f65410c = false;
        this.f65411d = -9223372036854775807L;
    }
}
