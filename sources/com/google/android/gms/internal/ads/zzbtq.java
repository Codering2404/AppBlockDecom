package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbtq implements zzcfy {
    final /* synthetic */ zzbto zza;

    zzbtq(zzbtt zzbttVar, zzbto zzbtoVar) {
        this.zza = zzbtoVar;
        Objects.requireNonNull(zzbttVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcfy
    public final void zza() {
        com.google.android.gms.ads.internal.util.zze.k("Rejecting reference for JS Engine.");
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zziF)).booleanValue()) {
            this.zza.zzh(new IllegalStateException("Unable to create JS engine reference."), "SdkJavascriptFactory.createNewReference.FailureCallback");
        } else {
            this.zza.zzg();
        }
    }
}
