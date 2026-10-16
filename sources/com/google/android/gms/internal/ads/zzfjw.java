package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfjw extends zzcch {
    private final zzfjs zza;
    private final zzfjj zzb;
    private final String zzc;
    private final zzfkr zzd;
    private final Context zze;
    private final VersionInfoParcel zzf;
    private final zzbap zzg;
    private final zzdzl zzh;
    private zzdvm zzi;
    private boolean zzj;

    public zzfjw(String str, zzfjs zzfjsVar, Context context, zzfjj zzfjjVar, zzfkr zzfkrVar, VersionInfoParcel versionInfoParcel, zzbap zzbapVar, zzdzl zzdzlVar) {
        this.zzc = str;
        this.zza = zzfjsVar;
        this.zzb = zzfjjVar;
        this.zzd = zzfkrVar;
        this.zze = context;
        this.zzf = versionInfoParcel;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbp)).booleanValue() || Build.VERSION.SDK_INT < 35) {
            this.zzj = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbo)).booleanValue();
        } else {
            this.zzj = true;
        }
        this.zzg = zzbapVar;
        this.zzh = zzdzlVar;
    }

    private final synchronized void zzy(com.google.android.gms.ads.internal.client.zzm zzmVar, zzccp zzccpVar, int i3) throws RemoteException {
        try {
            if (!zzmVar.N()) {
                boolean z2 = false;
                if (((Boolean) zzbko.zzk.zze()).booleanValue()) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzmD)).booleanValue()) {
                        z2 = true;
                    }
                }
                if (this.zzf.f70151c < ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzmE)).intValue() || !z2) {
                    Preconditions.f("#008 Must be called on the main UI thread.");
                }
            }
            zzfjj zzfjjVar = this.zzb;
            zzfjjVar.zzh(zzccpVar);
            com.google.android.gms.ads.internal.zzt.g();
            if (com.google.android.gms.ads.internal.util.zzs.k(this.zze) && zzmVar.f69982t == null) {
                int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.c("Failed to load the ad because app ID is missing.");
                zzfjjVar.zzdJ(zzfma.zzd(4, null, null));
            } else {
                if (this.zzi != null) {
                    return;
                }
                zzfjl zzfjlVar = new zzfjl(null);
                zzfjs zzfjsVar = this.zza;
                zzfjsVar.zzj(i3);
                zzfjsVar.zza(zzmVar, this.zzc, zzfjlVar, new zzfjv(this));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final synchronized void zzb(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzk(iObjectWrapper, this.zzj);
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final synchronized void zzc(com.google.android.gms.ads.internal.client.zzm zzmVar, zzccp zzccpVar) throws RemoteException {
        zzy(zzmVar, zzccpVar, 2);
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final synchronized void zzd(com.google.android.gms.ads.internal.client.zzm zzmVar, zzccp zzccpVar) throws RemoteException {
        zzy(zzmVar, zzccpVar, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final void zze(zzccl zzcclVar) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        this.zzb.zzi(zzcclVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final void zzf(com.google.android.gms.ads.internal.client.zzdn zzdnVar) {
        if (zzdnVar == null) {
            this.zzb.zzk(null);
        } else {
            this.zzb.zzk(new zzfju(this, zzdnVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final Bundle zzg() {
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzdvm zzdvmVar = this.zzi;
        return zzdvmVar != null ? zzdvmVar.zzg() : new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final synchronized void zzh(zzccw zzccwVar) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzfkr zzfkrVar = this.zzd;
        zzfkrVar.zza = zzccwVar.zza;
        zzfkrVar.zzb = zzccwVar.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final boolean zzi() {
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzdvm zzdvmVar = this.zzi;
        return (zzdvmVar == null || zzdvmVar.zzb()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final synchronized String zzj() throws RemoteException {
        zzdvm zzdvmVar = this.zzi;
        if (zzdvmVar == null || zzdvmVar.zzn() == null) {
            return null;
        }
        return zzdvmVar.zzn().zze();
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final synchronized void zzk(IObjectWrapper iObjectWrapper, boolean z2) throws RemoteException {
        Preconditions.f("#008 Must be called on the main UI thread.");
        if (this.zzi == null) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Rewarded can not be shown before loaded");
            this.zzb.zzj(zzfma.zzd(9, null, null));
        } else {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzdG)).booleanValue()) {
                this.zzg.zzb().zzi(new Throwable().getStackTrace());
            }
            this.zzi.zza(z2, (Activity) ObjectWrapper.h5(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final zzccf zzl() {
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzdvm zzdvmVar = this.zzi;
        if (zzdvmVar != null) {
            return zzdvmVar.zzc();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final com.google.android.gms.ads.internal.client.zzdx zzm() {
        zzdvm zzdvmVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhI)).booleanValue() && (zzdvmVar = this.zzi) != null) {
            return zzdvmVar.zzn();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final String zzn() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final void zzo(com.google.android.gms.ads.internal.client.zzdq zzdqVar) {
        Preconditions.f("setOnPaidEventListener must be called on the main UI thread.");
        try {
            if (!zzdqVar.zzf()) {
                this.zzh.zzb();
            }
        } catch (RemoteException e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.b("Error in making CSI ping for reporting paid event callback", e3);
        }
        this.zzb.zzl(zzdqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final synchronized void zzp(boolean z2) {
        Preconditions.f("setImmersiveMode must be called on the main UI thread.");
        this.zzj = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final synchronized long zzq() {
        zzdvm zzdvmVar = this.zzi;
        if (zzdvmVar == null || zzdvmVar.zzo() == null) {
            return 0L;
        }
        return zzdvmVar.zzo().zza();
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final synchronized void zzr(long j3) {
        zzdvm zzdvmVar = this.zzi;
        if (zzdvmVar == null || zzdvmVar.zzo() == null) {
            return;
        }
        zzdvmVar.zzo().zzb(j3);
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    public final void zzs(zzccq zzccqVar) {
        Preconditions.f("#008 Must be called on the main UI thread.");
        this.zzb.zzp(zzccqVar);
    }

    public final void zzu(zzfsy zzfsyVar) {
        this.zzb.zzo(zzfsyVar);
    }

    final /* synthetic */ zzfkr zzv() {
        return this.zzd;
    }

    final /* synthetic */ zzdvm zzw() {
        return this.zzi;
    }

    final /* synthetic */ void zzx(zzdvm zzdvmVar) {
        this.zzi = zzdvmVar;
    }
}
