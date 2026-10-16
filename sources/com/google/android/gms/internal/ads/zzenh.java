package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzenh extends zzbvh implements zzdeb {
    private zzbvi zza;
    private zzdea zzb;

    @Override // com.google.android.gms.internal.ads.zzdeb
    public final synchronized void zza(zzdea zzdeaVar) {
        this.zzb = zzdeaVar;
    }

    public final synchronized void zzc(zzbvi zzbviVar) {
        this.zza = zzbviVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zze() throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzf() throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzg(int i3) throws RemoteException {
        zzdea zzdeaVar = this.zzb;
        if (zzdeaVar != null) {
            zzdeaVar.zzb(i3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzh() throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzi() throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzi();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzj() throws RemoteException {
        try {
            zzbvi zzbviVar = this.zza;
            if (zzbviVar != null) {
                zzbviVar.zzj();
            }
            zzdea zzdeaVar = this.zzb;
            if (zzdeaVar != null) {
                zzdeaVar.zza();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzk() throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzk();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzl(String str, String str2) throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzl(str, str2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzm(zzbmv zzbmvVar, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzn() throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzn();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzo() throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzo();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzp(zzccb zzccbVar) throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzp(zzccbVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzq() throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzq();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzr(zzccf zzccfVar) throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzr(zzccfVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzs(int i3) throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzs(i3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzt() throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzt();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzu() throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzu();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzv(String str) throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzv(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzw(int i3, String str) throws RemoteException {
        zzdea zzdeaVar = this.zzb;
        if (zzdeaVar != null) {
            zzdeaVar.zzc(i3, str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzx(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        zzdea zzdeaVar = this.zzb;
        if (zzdeaVar != null) {
            zzdeaVar.zzd(zzeVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzy(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzy(zzeVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzz() throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzz();
        }
    }
}
