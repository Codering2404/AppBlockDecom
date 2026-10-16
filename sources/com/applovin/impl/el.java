package com.applovin.impl;

import com.applovin.impl.ij;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class el implements l8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f59520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l8 f59521b;

    public el(long j3, l8 l8Var) {
        this.f59520a = j3;
        this.f59521b = l8Var;
    }

    @Override // com.applovin.impl.l8
    public void c() {
        this.f59521b.c();
    }

    @Override // com.applovin.impl.l8
    public void a(ij ijVar) {
        this.f59521b.a(new a(ijVar));
    }

    @Override // com.applovin.impl.l8
    public qo a(int i3, int i4) {
        return this.f59521b.a(i3, i4);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements ij {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ij f59522a;

        a(ij ijVar) {
            this.f59522a = ijVar;
        }

        @Override // com.applovin.impl.ij
        public ij.a b(long j3) {
            ij.a aVarB = this.f59522a.b(j3);
            kj kjVar = aVarB.f60489a;
            kj kjVar2 = new kj(kjVar.f61038a, kjVar.f61039b + el.this.f59520a);
            kj kjVar3 = aVarB.f60490b;
            return new ij.a(kjVar2, new kj(kjVar3.f61038a, kjVar3.f61039b + el.this.f59520a));
        }

        @Override // com.applovin.impl.ij
        public long d() {
            return this.f59522a.d();
        }

        @Override // com.applovin.impl.ij
        public boolean b() {
            return this.f59522a.b();
        }
    }
}
