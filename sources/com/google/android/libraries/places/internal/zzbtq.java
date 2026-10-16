package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbtq extends zzbsm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbpn f76864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbtr f76865b;

    zzbtq(zzbtr zzbtrVar, zzbpn zzbpnVar) {
        this.f76864a = zzbpnVar;
        Objects.requireNonNull(zzbtrVar);
        this.f76865b = zzbtrVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbsm, com.google.android.libraries.places.internal.zzbpn
    public final void b(zzbnp zzbnpVar, zzbpm zzbpmVar, zzbmg zzbmgVar) {
        this.f76865b.f76867b.f().b(zzbnpVar.j());
        this.f76864a.b(zzbnpVar, zzbpmVar, zzbmgVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbsm
    protected final zzbpn d() {
        return this.f76864a;
    }
}
