package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfkc extends zzcbr {
    private final zzfjs zza;
    private final zzfjj zzb;
    private final zzfkr zzc;
    private zzdvm zzd;
    private boolean zze = false;

    public zzfkc(zzfjs zzfjsVar, zzfjj zzfjjVar, zzfkr zzfkrVar) {
        this.zza = zzfjsVar;
        this.zzb = zzfjjVar;
        this.zzc = zzfkrVar;
    }

    private final synchronized boolean zzy() {
        zzdvm zzdvmVar = this.zzd;
        if (zzdvmVar != null) {
            if (!zzdvmVar.zze()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(com.google.android.gms.internal.ads.zzbiq.zzgy)).booleanValue() == false) goto L18;
     */
    @Override // com.google.android.gms.internal.ads.zzcbs
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void zzb(com.google.android.gms.internal.ads.zzcbw r5) throws android.os.RemoteException {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.f(r0)     // Catch: java.lang.Throwable -> L20
            java.lang.String r0 = r5.zzb     // Catch: java.lang.Throwable -> L20
            com.google.android.gms.internal.ads.zzbih r1 = com.google.android.gms.internal.ads.zzbiq.zzgw     // Catch: java.lang.Throwable -> L20
            com.google.android.gms.internal.ads.zzbio r2 = com.google.android.gms.ads.internal.client.zzba.c()     // Catch: java.lang.Throwable -> L20
            java.lang.Object r1 = r2.zzd(r1)     // Catch: java.lang.Throwable -> L20
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L2c
            if (r0 != 0) goto L19
            goto L2c
        L19:
            boolean r0 = java.util.regex.Pattern.matches(r1, r0)     // Catch: java.lang.Throwable -> L20 java.lang.RuntimeException -> L22
            if (r0 == 0) goto L2c
            goto L44
        L20:
            r5 = move-exception
            goto L62
        L22:
            r0 = move-exception
            java.lang.String r1 = "NonagonUtil.isPatternMatched"
            com.google.android.gms.internal.ads.zzcfd r2 = com.google.android.gms.ads.internal.zzt.l()     // Catch: java.lang.Throwable -> L20
            r2.zzg(r0, r1)     // Catch: java.lang.Throwable -> L20
        L2c:
            boolean r0 = r4.zzy()     // Catch: java.lang.Throwable -> L20
            if (r0 == 0) goto L46
            com.google.android.gms.internal.ads.zzbih r0 = com.google.android.gms.internal.ads.zzbiq.zzgy     // Catch: java.lang.Throwable -> L20
            com.google.android.gms.internal.ads.zzbio r1 = com.google.android.gms.ads.internal.client.zzba.c()     // Catch: java.lang.Throwable -> L20
            java.lang.Object r0 = r1.zzd(r0)     // Catch: java.lang.Throwable -> L20
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L20
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L20
            if (r0 != 0) goto L46
        L44:
            monitor-exit(r4)
            return
        L46:
            com.google.android.gms.internal.ads.zzfjl r0 = new com.google.android.gms.internal.ads.zzfjl     // Catch: java.lang.Throwable -> L20
            r1 = 0
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L20
            r4.zzd = r1     // Catch: java.lang.Throwable -> L20
            com.google.android.gms.internal.ads.zzfjs r1 = r4.zza     // Catch: java.lang.Throwable -> L20
            r2 = 1
            r1.zzj(r2)     // Catch: java.lang.Throwable -> L20
            com.google.android.gms.ads.internal.client.zzm r2 = r5.zza     // Catch: java.lang.Throwable -> L20
            java.lang.String r5 = r5.zzb     // Catch: java.lang.Throwable -> L20
            com.google.android.gms.internal.ads.zzfka r3 = new com.google.android.gms.internal.ads.zzfka     // Catch: java.lang.Throwable -> L20
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L20
            r1.zza(r2, r5, r0, r3)     // Catch: java.lang.Throwable -> L20
            monitor-exit(r4)
            return
        L62:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L20
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfkc.zzb(com.google.android.gms.internal.ads.zzcbw):void");
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final synchronized void zzc() throws RemoteException {
        zzp(null);
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final void zzd(zzcbv zzcbvVar) throws RemoteException {
        Preconditions.f("setRewardedVideoAdListener can only be called from the UI thread.");
        this.zzb.zzn(zzcbvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final boolean zze() throws RemoteException {
        Preconditions.f("isLoaded must be called on the main UI thread.");
        return zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final void zzf() {
        zzi(null);
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final void zzg() {
        zzj(null);
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final void zzh() throws RemoteException {
        zzk(null);
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final synchronized void zzi(IObjectWrapper iObjectWrapper) {
        Preconditions.f("pause must be called on the main UI thread.");
        if (this.zzd != null) {
            this.zzd.zzl().zza(iObjectWrapper == null ? null : (Context) ObjectWrapper.h5(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final synchronized void zzj(IObjectWrapper iObjectWrapper) {
        Preconditions.f("resume must be called on the main UI thread.");
        if (this.zzd != null) {
            this.zzd.zzl().zzb(iObjectWrapper == null ? null : (Context) ObjectWrapper.h5(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final synchronized void zzk(IObjectWrapper iObjectWrapper) {
        Preconditions.f("destroy must be called on the main UI thread.");
        Context context = null;
        this.zzb.zzk(null);
        if (this.zzd != null) {
            if (iObjectWrapper != null) {
                context = (Context) ObjectWrapper.h5(iObjectWrapper);
            }
            this.zzd.zzl().zzc(context);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final synchronized String zzl() throws RemoteException {
        zzdvm zzdvmVar = this.zzd;
        if (zzdvmVar == null || zzdvmVar.zzn() == null) {
            return null;
        }
        return zzdvmVar.zzn().zze();
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final synchronized void zzm(String str) throws RemoteException {
        Preconditions.f("setUserId must be called on the main UI thread.");
        this.zzc.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final void zzn(com.google.android.gms.ads.internal.client.zzby zzbyVar) {
        Preconditions.f("setAdMetadataListener can only be called from the UI thread.");
        if (zzbyVar == null) {
            this.zzb.zzk(null);
        } else {
            this.zzb.zzk(new zzfkb(this, zzbyVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final Bundle zzo() {
        Preconditions.f("getAdMetadata can only be called from the UI thread.");
        zzdvm zzdvmVar = this.zzd;
        return zzdvmVar != null ? zzdvmVar.zzg() : new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final synchronized void zzp(IObjectWrapper iObjectWrapper) throws RemoteException {
        try {
            Preconditions.f("showAd must be called on the main UI thread.");
            if (this.zzd != null) {
                Activity activity = null;
                if (iObjectWrapper != null) {
                    Object objH5 = ObjectWrapper.h5(iObjectWrapper);
                    if (objH5 instanceof Activity) {
                        activity = (Activity) objH5;
                    }
                }
                this.zzd.zza(this.zze, activity);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final synchronized void zzq(String str) throws RemoteException {
        Preconditions.f("#008 Must be called on the main UI thread.: setCustomData");
        this.zzc.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final synchronized void zzr(boolean z2) {
        Preconditions.f("setImmersiveMode must be called on the main UI thread.");
        this.zze = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final boolean zzs() {
        zzdvm zzdvmVar = this.zzd;
        return zzdvmVar != null && zzdvmVar.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final synchronized com.google.android.gms.ads.internal.client.zzdx zzt() throws RemoteException {
        zzdvm zzdvmVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhI)).booleanValue() && (zzdvmVar = this.zzd) != null) {
            return zzdvmVar.zzn();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final void zzu(zzcbq zzcbqVar) {
        Preconditions.f("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
        this.zzb.zzq(zzcbqVar);
    }

    final /* synthetic */ zzfkr zzv() {
        return this.zzc;
    }

    final /* synthetic */ zzdvm zzw() {
        return this.zzd;
    }

    final /* synthetic */ void zzx(zzdvm zzdvmVar) {
        this.zzd = zzdvmVar;
    }
}
