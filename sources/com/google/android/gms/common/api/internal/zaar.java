package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zaar extends com.google.android.gms.signin.internal.zac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference f71666a;

    zaar(zaaw zaawVar) {
        this.f71666a = new WeakReference(zaawVar);
    }

    @Override // com.google.android.gms.signin.internal.zac, com.google.android.gms.signin.internal.zae
    public final void m0(com.google.android.gms.signin.internal.zak zakVar) {
        zaaw zaawVar = (zaaw) this.f71666a.get();
        if (zaawVar == null) {
            return;
        }
        zaawVar.f71669a.o(new zaaq(this, zaawVar, zaawVar, zakVar));
    }
}
