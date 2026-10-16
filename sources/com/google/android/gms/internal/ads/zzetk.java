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
import com.google.android.material.bottomsheet.lKiE.YznnJpHcAmeoW;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzetk extends com.google.android.gms.ads.internal.client.zzbt {
    private final com.google.android.gms.ads.internal.client.zzr zza;
    private final Context zzb;
    private final zzfii zzc;
    private final String zzd;
    private final VersionInfoParcel zze;
    private final zzetc zzf;
    private final zzfjj zzg;
    private final zzbap zzh;
    private final zzdzl zzi;
    private zzdlz zzj;
    private boolean zzk;

    public zzetk(Context context, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, zzfii zzfiiVar, zzetc zzetcVar, zzfjj zzfjjVar, VersionInfoParcel versionInfoParcel, zzbap zzbapVar, zzdzl zzdzlVar) {
        this.zza = zzrVar;
        this.zzd = str;
        this.zzb = context;
        this.zzc = zzfiiVar;
        this.zzf = zzetcVar;
        this.zzg = zzfjjVar;
        this.zze = versionInfoParcel;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbp)).booleanValue() || Build.VERSION.SDK_INT < 35) {
            this.zzk = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbo)).booleanValue();
        } else {
            this.zzk = true;
        }
        this.zzh = zzbapVar;
        this.zzi = zzdzlVar;
    }

    private final synchronized boolean zzO() {
        zzdlz zzdlzVar = this.zzj;
        if (zzdlzVar != null) {
            if (!zzdlzVar.zzb()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized boolean zzA() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized boolean zzB() {
        return this.zzc.zzb();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzC(zzcbv zzcbvVar) {
        this.zzg.zzn(zzcbvVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzD(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzE(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final com.google.android.gms.ads.internal.client.zzea zzF() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzG(com.google.android.gms.ads.internal.client.zzfw zzfwVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzH(com.google.android.gms.ads.internal.client.zzee zzeeVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzI(com.google.android.gms.ads.internal.client.zzx zzxVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzJ(zzbgm zzbgmVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzK(boolean z2) {
        Preconditions.f("setImmersiveMode must be called on the main UI thread.");
        this.zzk = z2;
    }

    public final void zzL(zzfsy zzfsyVar) {
        this.zzf.zzn(zzfsyVar);
    }

    final /* synthetic */ zzdlz zzM() {
        return this.zzj;
    }

    final /* synthetic */ void zzN(zzdlz zzdlzVar) {
        this.zzj = zzdlzVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzP(com.google.android.gms.ads.internal.client.zzdq zzdqVar) {
        Preconditions.f("setPaidEventListener must be called on the main UI thread.");
        try {
            if (!zzdqVar.zzf()) {
                this.zzi.zzb();
            }
        } catch (RemoteException e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.b("Error in making CSI ping for reporting paid event callback", e3);
        }
        this.zzf.zzp(zzdqVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzQ(com.google.android.gms.ads.internal.client.zzm zzmVar, com.google.android.gms.ads.internal.client.zzbk zzbkVar) throws RemoteException {
        this.zzf.zzq(zzbkVar);
        zze(zzmVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzR(IObjectWrapper iObjectWrapper) {
        if (this.zzj == null) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Interstitial can not be shown before loaded.");
            this.zzf.zzj(zzfma.zzd(9, null, null));
        } else {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzdG)).booleanValue()) {
                this.zzh.zzb().zzi(new Throwable().getStackTrace());
            }
            this.zzj.zza(this.zzk, (Activity) ObjectWrapper.h5(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzS(com.google.android.gms.ads.internal.client.zzcs zzcsVar) {
        this.zzf.zzr(zzcsVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzT(long j3) {
        zzdlz zzdlzVar = this.zzj;
        if (zzdlzVar == null || zzdlzVar.zzo() == null) {
            return;
        }
        zzdlzVar.zzo().zzb(j3);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized long zzU() {
        zzdlz zzdlzVar = this.zzj;
        if (zzdlzVar == null || zzdlzVar.zzo() == null) {
            return 0L;
        }
        return zzdlzVar.zzo().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzY(com.google.android.gms.ads.internal.client.zzcp zzcpVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final IObjectWrapper zzb() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzc() {
        Preconditions.f("destroy must be called on the main UI thread.");
        zzdlz zzdlzVar = this.zzj;
        if (zzdlzVar != null) {
            zzdlzVar.zzl().zzc(null);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized boolean zzd() {
        Preconditions.f("isLoaded must be called on the main UI thread.");
        return zzO();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzdS(com.google.android.gms.ads.internal.client.zzbh zzbhVar) {
        Preconditions.f("setAdListener must be called on the main UI thread.");
        this.zzf.zzl(zzbhVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    @Override // com.google.android.gms.ads.internal.client.zzbu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized boolean zze(com.google.android.gms.ads.internal.client.zzm r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r6.N()     // Catch: java.lang.Throwable -> L2d
            r1 = 0
            if (r0 == 0) goto L9
            goto L4c
        L9:
            com.google.android.gms.internal.ads.zzbka r0 = com.google.android.gms.internal.ads.zzbko.zzi     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r0 = r0.zze()     // Catch: java.lang.Throwable -> L2d
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L2d
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L2d
            if (r0 == 0) goto L2b
            com.google.android.gms.internal.ads.zzbih r0 = com.google.android.gms.internal.ads.zzbiq.zzmD     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.internal.ads.zzbio r2 = com.google.android.gms.ads.internal.client.zzba.c()     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r0 = r2.zzd(r0)     // Catch: java.lang.Throwable -> L2d
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L2d
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L2d
            if (r0 == 0) goto L2b
            r0 = 1
            goto L2f
        L2b:
            r0 = r1
            goto L2f
        L2d:
            r6 = move-exception
            goto L95
        L2f:
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r2 = r5.zze     // Catch: java.lang.Throwable -> L2d
            int r2 = r2.f70151c     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.internal.ads.zzbih r3 = com.google.android.gms.internal.ads.zzbiq.zzmE     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.internal.ads.zzbio r4 = com.google.android.gms.ads.internal.client.zzba.c()     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r3 = r4.zzd(r3)     // Catch: java.lang.Throwable -> L2d
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.Throwable -> L2d
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L2d
            if (r2 < r3) goto L47
            if (r0 != 0) goto L4c
        L47:
            java.lang.String r0 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.f(r0)     // Catch: java.lang.Throwable -> L2d
        L4c:
            com.google.android.gms.ads.internal.zzt.g()     // Catch: java.lang.Throwable -> L2d
            android.content.Context r0 = r5.zzb     // Catch: java.lang.Throwable -> L2d
            boolean r2 = com.google.android.gms.ads.internal.util.zzs.k(r0)     // Catch: java.lang.Throwable -> L2d
            r3 = 0
            if (r2 == 0) goto L70
            com.google.android.gms.ads.internal.client.zzc r2 = r6.f69982t     // Catch: java.lang.Throwable -> L2d
            if (r2 != 0) goto L70
            int r6 = com.google.android.gms.ads.internal.util.zze.f70328b     // Catch: java.lang.Throwable -> L2d
            java.lang.String r6 = "Failed to load the ad because app ID is missing."
            com.google.android.gms.ads.internal.util.client.zzo.c(r6)     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.internal.ads.zzetc r6 = r5.zzf     // Catch: java.lang.Throwable -> L2d
            if (r6 == 0) goto L93
            r0 = 4
            com.google.android.gms.ads.internal.client.zze r0 = com.google.android.gms.internal.ads.zzfma.zzd(r0, r3, r3)     // Catch: java.lang.Throwable -> L2d
            r6.zzdJ(r0)     // Catch: java.lang.Throwable -> L2d
            goto L93
        L70:
            boolean r2 = r5.zzO()     // Catch: java.lang.Throwable -> L2d
            if (r2 != 0) goto L93
            boolean r1 = r6.f69969g     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.internal.ads.zzflv.zzb(r0, r1)     // Catch: java.lang.Throwable -> L2d
            r5.zzj = r3     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.internal.ads.zzfii r0 = r5.zzc     // Catch: java.lang.Throwable -> L2d
            java.lang.String r1 = r5.zzd     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.ads.internal.client.zzr r2 = r5.zza     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.internal.ads.zzfib r3 = new com.google.android.gms.internal.ads.zzfib     // Catch: java.lang.Throwable -> L2d
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.internal.ads.zzetj r2 = new com.google.android.gms.internal.ads.zzetj     // Catch: java.lang.Throwable -> L2d
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L2d
            boolean r6 = r0.zza(r6, r1, r3, r2)     // Catch: java.lang.Throwable -> L2d
            monitor-exit(r5)
            return r6
        L93:
            monitor-exit(r5)
            return r1
        L95:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L2d
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzetk.zze(com.google.android.gms.ads.internal.client.zzm):boolean");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzf() {
        Preconditions.f(YznnJpHcAmeoW.KabMANRxbFZNVoj);
        zzdlz zzdlzVar = this.zzj;
        if (zzdlzVar != null) {
            zzdlzVar.zzl().zza(null);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzg() {
        Preconditions.f("resume must be called on the main UI thread.");
        zzdlz zzdlzVar = this.zzj;
        if (zzdlzVar != null) {
            zzdlzVar.zzl().zzb(null);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzi(com.google.android.gms.ads.internal.client.zzcl zzclVar) {
        Preconditions.f("setAppEventListener must be called on the main UI thread.");
        this.zzf.zzo(zzclVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzj(com.google.android.gms.ads.internal.client.zzby zzbyVar) {
        Preconditions.f("setAdMetadataListener must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final Bundle zzk() {
        Preconditions.f("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzl() {
        Preconditions.f("showInterstitial must be called on the main UI thread.");
        if (this.zzj == null) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Interstitial can not be shown before loaded.");
            this.zzf.zzj(zzfma.zzd(9, null, null));
        } else {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzdG)).booleanValue()) {
                this.zzh.zzb().zzi(new Throwable().getStackTrace());
            }
            this.zzj.zza(this.zzk, null);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzm() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final com.google.android.gms.ads.internal.client.zzr zzn() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzo(com.google.android.gms.ads.internal.client.zzr zzrVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzp(zzbzk zzbzkVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzq(zzbzn zzbznVar, String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized String zzr() {
        zzdlz zzdlzVar = this.zzj;
        if (zzdlzVar == null || zzdlzVar.zzn() == null) {
            return null;
        }
        return zzdlzVar.zzn().zze();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized String zzs() {
        zzdlz zzdlzVar = this.zzj;
        if (zzdlzVar == null || zzdlzVar.zzn() == null) {
            return null;
        }
        return zzdlzVar.zzn().zze();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized com.google.android.gms.ads.internal.client.zzdx zzt() {
        zzdlz zzdlzVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhI)).booleanValue() && (zzdlzVar = this.zzj) != null) {
            return zzdlzVar.zzn();
        }
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized String zzu() {
        return this.zzd;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final com.google.android.gms.ads.internal.client.zzcl zzv() {
        return this.zzf.zzk();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final com.google.android.gms.ads.internal.client.zzbh zzw() {
        return this.zzf.zzi();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzx(zzbjl zzbjlVar) {
        Preconditions.f("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzc.zzc(zzbjlVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzy(com.google.android.gms.ads.internal.client.zzbe zzbeVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzz(boolean z2) {
    }
}
