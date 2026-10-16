package com.applovin.impl;

import com.applovin.impl.wa;
import java.io.EOFException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ya {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ah f65176a = new ah(10);

    public af a(k8 k8Var, wa.a aVar) throws Throwable {
        af afVarA = null;
        int i3 = 0;
        while (true) {
            try {
                k8Var.c(this.f65176a.c(), 0, 10);
                this.f65176a.f(0);
                if (this.f65176a.z() != 4801587) {
                    break;
                }
                this.f65176a.g(3);
                int iV = this.f65176a.v();
                int i4 = iV + 10;
                if (afVarA == null) {
                    byte[] bArr = new byte[i4];
                    System.arraycopy(this.f65176a.c(), 0, bArr, 0, 10);
                    k8Var.c(bArr, 10, iV);
                    afVarA = new wa(aVar).a(bArr, i4);
                } else {
                    k8Var.c(iV);
                }
                i3 += i4;
            } catch (EOFException unused) {
            }
        }
        k8Var.b();
        k8Var.c(i3);
        return afVarA;
    }
}
