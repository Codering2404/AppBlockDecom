package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzegb extends zzcat {
    private final zzcfw zza;
    private final zzcbd zzb;

    zzegb(zzcfw zzcfwVar, zzcbd zzcbdVar) {
        this.zza = zzcfwVar;
        this.zzb = zzcbdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcau
    public final void zze(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza.zzc(new zzegs(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor), this.zzb));
    }

    @Override // com.google.android.gms.internal.ads.zzcau
    public final void zzf(com.google.android.gms.ads.internal.util.zzba zzbaVar) {
        this.zza.zzd(zzbaVar.N());
    }

    @Override // com.google.android.gms.internal.ads.zzcau
    public final void zzg(ParcelFileDescriptor parcelFileDescriptor, zzcbd zzcbdVar) {
        this.zza.zzc(new zzegs(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor), zzcbdVar));
    }
}
