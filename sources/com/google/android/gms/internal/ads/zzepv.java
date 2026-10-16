package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzepv extends zzeqw {
    private final zzdlh zza;

    public zzepv(zzdcp zzdcpVar, zzdkw zzdkwVar, zzddj zzddjVar, zzddy zzddyVar, zzded zzdedVar, zzdde zzddeVar, zzdhv zzdhvVar, zzdlu zzdluVar, zzdfc zzdfcVar, zzdlh zzdlhVar, zzdhr zzdhrVar) {
        super(zzdcpVar, zzdkwVar, zzddjVar, zzddyVar, zzdedVar, zzdhvVar, zzdfcVar, zzdluVar, zzdhrVar, zzddeVar);
        this.zza = zzdlhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqw, com.google.android.gms.internal.ads.zzbvi
    public final void zzn() {
        this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzeqw, com.google.android.gms.internal.ads.zzbvi
    public final void zzo() {
        this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeqw, com.google.android.gms.internal.ads.zzbvi
    public final void zzp(zzccb zzccbVar) {
        this.zza.zzb(zzccbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqw, com.google.android.gms.internal.ads.zzbvi
    public final void zzr(zzccf zzccfVar) throws RemoteException {
        this.zza.zzb(new zzccb(zzccfVar.zze(), zzccfVar.zzf()));
    }

    @Override // com.google.android.gms.internal.ads.zzeqw, com.google.android.gms.internal.ads.zzbvi
    public final void zzt() throws RemoteException {
        this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzeqw, com.google.android.gms.internal.ads.zzbvi
    public final void zzz() throws RemoteException {
        this.zza.zzb(null);
    }
}
