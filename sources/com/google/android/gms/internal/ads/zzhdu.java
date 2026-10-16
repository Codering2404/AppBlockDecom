package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhdu {
    private boolean zza;

    @Nullable
    private final zzheh zzc;
    private final zzhds zzb = zzhds.zza;
    private zzhdv zzd = null;

    @Nullable
    private zzhdw zze = null;

    /* synthetic */ zzhdu(zzheh zzhehVar, byte[] bArr) {
        this.zzc = zzhehVar;
    }

    public final zzhdu zza() {
        zzhdw zzhdwVar = this.zze;
        if (zzhdwVar != null) {
            zzhdwVar.zzc();
        }
        this.zza = true;
        return this;
    }

    public final zzhdu zzb() {
        this.zzd = zzhdv.zza;
        return this;
    }

    final /* synthetic */ boolean zzc() {
        return this.zza;
    }

    final /* synthetic */ void zzd(boolean z2) {
        this.zza = false;
    }

    final /* synthetic */ zzhds zze() {
        return this.zzb;
    }

    final /* synthetic */ zzheh zzf() {
        return this.zzc;
    }

    final /* synthetic */ zzhdv zzg() {
        return this.zzd;
    }

    final /* synthetic */ zzhdw zzh() {
        return this.zze;
    }

    final /* synthetic */ void zzi(zzhdw zzhdwVar) {
        this.zze = zzhdwVar;
    }
}
