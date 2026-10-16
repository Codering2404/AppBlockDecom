package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbpf extends zzbqd {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbmg f76595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzbpj f76596c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbpf(zzbpj zzbpjVar, zzcev zzcevVar, zzbmg zzbmgVar) {
        super(zzbpjVar.f76605c.l());
        this.f76595b = zzbmgVar;
        Objects.requireNonNull(zzbpjVar);
        this.f76596c = zzbpjVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbqd
    public final void a() {
        int i3 = zzcew.f77735a;
        zzbpj zzbpjVar = this.f76596c;
        if (zzbpjVar.f() != null) {
            return;
        }
        try {
            zzbpjVar.e().a(this.f76595b);
        } catch (Throwable th) {
            this.f76596c.d(zzbnp.f76489f.d(th).e("Failed to read headers"));
        }
    }
}
