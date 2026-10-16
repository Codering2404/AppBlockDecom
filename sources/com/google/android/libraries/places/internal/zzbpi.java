package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbpi extends zzbqd {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbpj f76602b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbpi(zzbpj zzbpjVar, zzcev zzcevVar) {
        super(zzbpjVar.f76605c.l());
        Objects.requireNonNull(zzbpjVar);
        this.f76602b = zzbpjVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbqd
    public final void a() {
        int i3 = zzcew.f77735a;
        zzbpj zzbpjVar = this.f76602b;
        if (zzbpjVar.f() != null) {
            return;
        }
        try {
            zzbpjVar.e().d();
        } catch (Throwable th) {
            this.f76602b.d(zzbnp.f76489f.d(th).e("Failed to call onReady."));
        }
    }
}
