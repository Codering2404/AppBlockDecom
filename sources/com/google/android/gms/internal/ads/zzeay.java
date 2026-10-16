package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.glance.color.Tq.KqqtdetwHMIO;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeay {
    private final zzbqq zza;

    zzeay(zzbqq zzbqqVar) {
        this.zza = zzbqqVar;
    }

    private final void zzs(zzeax zzeaxVar) throws RemoteException {
        String strZza = zzeaxVar.zza();
        String strConcat = "Dispatching AFMA event on publisher webview: ".concat(strZza);
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.e(strConcat);
        this.zza.zzb(strZza);
    }

    public final void zza() throws RemoteException {
        zzs(new zzeax("initialize", null));
    }

    public final void zzb(long j3) throws RemoteException {
        zzeax zzeaxVar = new zzeax("creation", null);
        zzeaxVar.zzb(Long.valueOf(j3));
        zzeaxVar.zzc("nativeObjectCreated");
        zzs(zzeaxVar);
    }

    public final void zzc(long j3) throws RemoteException {
        zzeax zzeaxVar = new zzeax("creation", null);
        zzeaxVar.zzb(Long.valueOf(j3));
        zzeaxVar.zzc("nativeObjectNotCreated");
        zzs(zzeaxVar);
    }

    public final void zzd(long j3) throws RemoteException {
        zzeax zzeaxVar = new zzeax("interstitial", null);
        zzeaxVar.zzb(Long.valueOf(j3));
        zzeaxVar.zzc("onNativeAdObjectNotAvailable");
        zzs(zzeaxVar);
    }

    public final void zze(long j3) throws RemoteException {
        zzeax zzeaxVar = new zzeax("interstitial", null);
        zzeaxVar.zzb(Long.valueOf(j3));
        zzeaxVar.zzc("onAdLoaded");
        zzs(zzeaxVar);
    }

    public final void zzf(long j3, int i3) throws RemoteException {
        zzeax zzeaxVar = new zzeax("interstitial", null);
        zzeaxVar.zzb(Long.valueOf(j3));
        zzeaxVar.zzc("onAdFailedToLoad");
        zzeaxVar.zzd(Integer.valueOf(i3));
        zzs(zzeaxVar);
    }

    public final void zzg(long j3) throws RemoteException {
        zzeax zzeaxVar = new zzeax("interstitial", null);
        zzeaxVar.zzb(Long.valueOf(j3));
        zzeaxVar.zzc("onAdOpened");
        zzs(zzeaxVar);
    }

    public final void zzh(long j3) throws RemoteException {
        zzeax zzeaxVar = new zzeax("interstitial", null);
        zzeaxVar.zzb(Long.valueOf(j3));
        zzeaxVar.zzc("onAdClicked");
        this.zza.zzb(zzeaxVar.zza());
    }

    public final void zzi(long j3) throws RemoteException {
        zzeax zzeaxVar = new zzeax("interstitial", null);
        zzeaxVar.zzb(Long.valueOf(j3));
        zzeaxVar.zzc("onAdClosed");
        zzs(zzeaxVar);
    }

    public final void zzj(long j3) throws RemoteException {
        zzeax zzeaxVar = new zzeax("rewarded", null);
        zzeaxVar.zzb(Long.valueOf(j3));
        zzeaxVar.zzc("onNativeAdObjectNotAvailable");
        zzs(zzeaxVar);
    }

    public final void zzk(long j3) throws RemoteException {
        zzeax zzeaxVar = new zzeax("rewarded", null);
        zzeaxVar.zzb(Long.valueOf(j3));
        zzeaxVar.zzc("onRewardedAdLoaded");
        zzs(zzeaxVar);
    }

    public final void zzl(long j3, int i3) throws RemoteException {
        zzeax zzeaxVar = new zzeax("rewarded", null);
        zzeaxVar.zzb(Long.valueOf(j3));
        zzeaxVar.zzc("onRewardedAdFailedToLoad");
        zzeaxVar.zzd(Integer.valueOf(i3));
        zzs(zzeaxVar);
    }

    public final void zzn(long j3, int i3) throws RemoteException {
        zzeax zzeaxVar = new zzeax("rewarded", null);
        zzeaxVar.zzb(Long.valueOf(j3));
        zzeaxVar.zzc("onRewardedAdFailedToShow");
        zzeaxVar.zzd(Integer.valueOf(i3));
        zzs(zzeaxVar);
    }

    public final void zzo(long j3) throws RemoteException {
        zzeax zzeaxVar = new zzeax("rewarded", null);
        zzeaxVar.zzb(Long.valueOf(j3));
        zzeaxVar.zzc("onRewardedAdClosed");
        zzs(zzeaxVar);
    }

    public final void zzp(long j3, zzccf zzccfVar) throws RemoteException {
        zzeax zzeaxVar = new zzeax("rewarded", null);
        zzeaxVar.zzb(Long.valueOf(j3));
        zzeaxVar.zzc("onUserEarnedReward");
        zzeaxVar.zze(zzccfVar.zze());
        zzeaxVar.zzf(Integer.valueOf(zzccfVar.zzf()));
        zzs(zzeaxVar);
    }

    public final void zzq(long j3) throws RemoteException {
        zzeax zzeaxVar = new zzeax("rewarded", null);
        zzeaxVar.zzb(Long.valueOf(j3));
        zzeaxVar.zzc("onAdImpression");
        zzs(zzeaxVar);
    }

    public final void zzr(long j3) throws RemoteException {
        zzeax zzeaxVar = new zzeax("rewarded", null);
        zzeaxVar.zzb(Long.valueOf(j3));
        zzeaxVar.zzc("onAdClicked");
        zzs(zzeaxVar);
    }

    public final void zzm(long j3) throws RemoteException {
        zzeax zzeaxVar = new zzeax(KqqtdetwHMIO.StCV, null);
        zzeaxVar.zzb(Long.valueOf(j3));
        zzeaxVar.zzc("onRewardedAdOpened");
        zzs(zzeaxVar);
    }
}
