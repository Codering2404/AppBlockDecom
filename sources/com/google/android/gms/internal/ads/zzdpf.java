package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdpf implements zzhbt {
    final /* synthetic */ View zza;
    final /* synthetic */ zzdpo zzb;

    zzdpf(zzdpo zzdpoVar, View view) {
        this.zza = view;
        Objects.requireNonNull(zzdpoVar);
        this.zzb = zzdpoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgs)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.l().zzh(th, "omid native display exp");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzb.zzY(this.zza, (zzeln) obj);
    }
}
