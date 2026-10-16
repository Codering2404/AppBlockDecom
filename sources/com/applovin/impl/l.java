package com.applovin.impl;

import com.applovin.impl.dp;
import com.applovin.impl.ij;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class l implements j8 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n8 f61073d = new n8() { // from class: com.applovin.impl.sy
        @Override // com.applovin.impl.n8
        public final j8[] a() {
            return l.b();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f61074a = new m();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ah f61075b = new ah(16384);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f61076c;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ j8[] b() {
        return new j8[]{new l()};
    }

    @Override // com.applovin.impl.j8
    public void a() {
    }

    @Override // com.applovin.impl.j8
    public void a(l8 l8Var) {
        this.f61074a.a(l8Var, new dp.d(0, 1));
        l8Var.c();
        l8Var.a(new ij.b(-9223372036854775807L));
    }

    @Override // com.applovin.impl.j8
    public int a(k8 k8Var, th thVar) {
        int iA = k8Var.a(this.f61075b.c(), 0, 16384);
        if (iA == -1) {
            return -1;
        }
        this.f61075b.f(0);
        this.f61075b.e(iA);
        if (!this.f61076c) {
            this.f61074a.a(0L, 4);
            this.f61076c = true;
        }
        this.f61074a.a(this.f61075b);
        return 0;
    }

    @Override // com.applovin.impl.j8
    public void a(long j3, long j4) {
        this.f61076c = false;
        this.f61074a.a();
    }

    @Override // com.applovin.impl.j8
    public boolean a(k8 k8Var) {
        ah ahVar = new ah(10);
        int i3 = 0;
        while (true) {
            k8Var.c(ahVar.c(), 0, 10);
            ahVar.f(0);
            if (ahVar.z() != 4801587) {
                break;
            }
            ahVar.g(3);
            int iV = ahVar.v();
            i3 += iV + 10;
            k8Var.c(iV);
        }
        k8Var.b();
        k8Var.c(i3);
        int i4 = 0;
        int i5 = i3;
        while (true) {
            k8Var.c(ahVar.c(), 0, 7);
            ahVar.f(0);
            int iC = ahVar.C();
            if (iC == 44096 || iC == 44097) {
                i4++;
                if (i4 >= 4) {
                    return true;
                }
                int iA = n.a(ahVar.c(), iC);
                if (iA == -1) {
                    return false;
                }
                k8Var.c(iA - 7);
            } else {
                k8Var.b();
                i5++;
                if (i5 - i3 >= 8192) {
                    return false;
                }
                k8Var.c(i5);
                i4 = 0;
            }
        }
    }
}
