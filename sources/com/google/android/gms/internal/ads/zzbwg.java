package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbwg extends zzbvh {
    private final Adapter zza;
    private final zzcca zzb;

    zzbwg(Adapter adapter, zzcca zzccaVar) {
        this.zza = adapter;
        this.zzb = zzccaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zze() throws RemoteException {
        zzcca zzccaVar = this.zzb;
        if (zzccaVar != null) {
            zzccaVar.zzl(ObjectWrapper.i5(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzf() throws RemoteException {
        zzcca zzccaVar = this.zzb;
        if (zzccaVar != null) {
            zzccaVar.zzj(ObjectWrapper.i5(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzg(int i3) throws RemoteException {
        zzcca zzccaVar = this.zzb;
        if (zzccaVar != null) {
            zzccaVar.zzm(ObjectWrapper.i5(this.zza), i3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzi() throws RemoteException {
        zzcca zzccaVar = this.zzb;
        if (zzccaVar != null) {
            zzccaVar.zzh(ObjectWrapper.i5(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzj() throws RemoteException {
        zzcca zzccaVar = this.zzb;
        if (zzccaVar != null) {
            zzccaVar.zzg(ObjectWrapper.i5(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzo() throws RemoteException {
        zzcca zzccaVar = this.zzb;
        if (zzccaVar != null) {
            zzccaVar.zzi(ObjectWrapper.i5(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzr(zzccf zzccfVar) throws RemoteException {
        zzcca zzccaVar = this.zzb;
        if (zzccaVar != null) {
            zzccaVar.zzk(ObjectWrapper.i5(this.zza), new zzccb(zzccfVar.zze(), zzccfVar.zzf()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzt() throws RemoteException {
        zzcca zzccaVar = this.zzb;
        if (zzccaVar != null) {
            zzccaVar.zzo(ObjectWrapper.i5(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzz() throws RemoteException {
        zzcca zzccaVar = this.zzb;
        if (zzccaVar != null) {
            zzccaVar.zzp(ObjectWrapper.i5(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzh() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzk() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzn() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzq() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzu() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzp(zzccb zzccbVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzs(int i3) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzv(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzx(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzy(com.google.android.gms.ads.internal.client.zze zzeVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzl(String str, String str2) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzm(zzbmv zzbmvVar, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzw(int i3, String str) throws RemoteException {
    }
}
