package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbph extends zzbqd {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbnp f76599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzbmg f76600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzbpj f76601d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbph(zzbpj zzbpjVar, zzcev zzcevVar, zzbnp zzbnpVar, zzbmg zzbmgVar) {
        super(zzbpjVar.f76605c.l());
        this.f76599b = zzbnpVar;
        this.f76600c = zzbmgVar;
        Objects.requireNonNull(zzbpjVar);
        this.f76601d = zzbpjVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbqd
    public final void a() {
        int i3 = zzcew.f77735a;
        zzbpj zzbpjVar = this.f76601d;
        zzbpjVar.f76605c.m().b();
        zzbnp zzbnpVarF = this.f76599b;
        zzbmg zzbmgVar = this.f76600c;
        if (zzbpjVar.f() != null) {
            zzbnpVarF = zzbpjVar.f();
            zzbmgVar = new zzbmg();
        }
        try {
            zzbpk.q(zzbpjVar.e(), zzbnpVarF, zzbmgVar);
        } finally {
            this.f76601d.f76605c.k().b(zzbnpVarF.j());
        }
    }
}
