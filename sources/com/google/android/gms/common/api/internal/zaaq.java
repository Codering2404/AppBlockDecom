package com.google.android.gms.common.api.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zaaq extends zabg {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zaaw f71664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.signin.internal.zak f71665c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zaaq(zaar zaarVar, zabf zabfVar, zaaw zaawVar, com.google.android.gms.signin.internal.zak zakVar) {
        super(zabfVar);
        this.f71664b = zaawVar;
        this.f71665c = zakVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabg
    public final void a() {
        zaaw.B(this.f71664b, this.f71665c);
    }
}
