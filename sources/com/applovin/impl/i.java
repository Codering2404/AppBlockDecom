package com.applovin.impl;

import com.applovin.impl.dp;
import com.applovin.impl.ij;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class i implements j8 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final n8 f60268d = new n8() { // from class: com.applovin.impl.vx
        @Override // com.applovin.impl.n8
        public final j8[] a() {
            return i.b();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f60269a = new j();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ah f60270b = new ah(2786);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f60271c;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ j8[] b() {
        return new j8[]{new i()};
    }

    @Override // com.applovin.impl.j8
    public void a() {
    }

    @Override // com.applovin.impl.j8
    public void a(l8 l8Var) {
        this.f60269a.a(l8Var, new dp.d(0, 1));
        l8Var.c();
        l8Var.a(new ij.b(-9223372036854775807L));
    }

    @Override // com.applovin.impl.j8
    public int a(k8 k8Var, th thVar) {
        int iA = k8Var.a(this.f60270b.c(), 0, 2786);
        if (iA == -1) {
            return -1;
        }
        this.f60270b.f(0);
        this.f60270b.e(iA);
        if (!this.f60271c) {
            this.f60269a.a(0L, 4);
            this.f60271c = true;
        }
        this.f60269a.a(this.f60270b);
        return 0;
    }

    @Override // com.applovin.impl.j8
    public void a(long j3, long j4) {
        this.f60271c = false;
        this.f60269a.a();
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
            k8Var.c(ahVar.c(), 0, 6);
            ahVar.f(0);
            if (ahVar.C() != 2935) {
                k8Var.b();
                i5++;
                if (i5 - i3 >= 8192) {
                    return false;
                }
                k8Var.c(i5);
                i4 = 0;
            } else {
                i4++;
                if (i4 >= 4) {
                    return true;
                }
                int iA = k.a(ahVar.c());
                if (iA == -1) {
                    return false;
                }
                k8Var.c(iA - 6);
            }
        }
    }
}
