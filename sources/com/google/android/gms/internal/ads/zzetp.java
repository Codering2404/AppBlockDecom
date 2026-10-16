package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzetp {
    private final zzdqd zza;
    private final zzetc zzb;
    private final zzdcu zzc;

    public zzetp(zzdqd zzdqdVar, zzdzl zzdzlVar) {
        this.zza = zzdqdVar;
        final zzetc zzetcVar = new zzetc(zzdzlVar);
        this.zzb = zzetcVar;
        final zzbsk zzbskVarZze = zzdqdVar.zze();
        this.zzc = new zzdcu() { // from class: com.google.android.gms.internal.ads.zzeto
            @Override // com.google.android.gms.internal.ads.zzdcu
            public final /* synthetic */ void zzdJ(com.google.android.gms.ads.internal.client.zze zzeVar) {
                zzetcVar.zzdJ(zzeVar);
                zzbsk zzbskVar = zzbskVarZze;
                if (zzbskVar != null) {
                    try {
                        zzbskVar.zzg(zzeVar);
                    } catch (RemoteException e3) {
                        com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
                    }
                }
                if (zzbskVar != null) {
                    try {
                        zzbskVar.zzf(zzeVar.f69851a);
                    } catch (RemoteException e4) {
                        com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e4);
                    }
                }
            }
        };
    }

    public final void zza(com.google.android.gms.ads.internal.client.zzbh zzbhVar) {
        this.zzb.zzl(zzbhVar);
    }

    public final zzdnx zzb() {
        return new zzdnx(this.zza, this.zzb.zzi());
    }

    public final zzetc zzc() {
        return this.zzb;
    }

    public final zzdef zzd() {
        return this.zzb;
    }

    public final zzdcu zze() {
        return this.zzc;
    }
}
