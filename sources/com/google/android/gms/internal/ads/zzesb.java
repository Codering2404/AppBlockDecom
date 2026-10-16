package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzesb extends com.google.android.gms.ads.internal.client.zzbt {
    private final Context zza;
    private final com.google.android.gms.ads.internal.client.zzbh zzb;
    private final zzfky zzc;
    private final zzcvl zzd;
    private final ViewGroup zze;
    private final zzdzl zzf;

    public zzesb(Context context, com.google.android.gms.ads.internal.client.zzbh zzbhVar, zzfky zzfkyVar, zzcvl zzcvlVar, zzdzl zzdzlVar) {
        this.zza = context;
        this.zzb = zzbhVar;
        this.zzc = zzfkyVar;
        this.zzd = zzcvlVar;
        this.zzf = zzdzlVar;
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.removeAllViews();
        View viewZza = zzcvlVar.zza();
        com.google.android.gms.ads.internal.zzt.g();
        frameLayout.addView(viewZza, new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setMinimumHeight(zzn().f70006c);
        frameLayout.setMinimumWidth(zzn().f70009g);
        this.zze = frameLayout;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final boolean zzA() throws RemoteException {
        zzcvl zzcvlVar = this.zzd;
        return zzcvlVar != null && zzcvlVar.zzs();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final boolean zzB() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final com.google.android.gms.ads.internal.client.zzea zzF() throws RemoteException {
        return this.zzd.zzc();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzG(com.google.android.gms.ads.internal.client.zzfw zzfwVar) throws RemoteException {
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.e("setVideoOptions is not supported in Ad Manager AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzP(com.google.android.gms.ads.internal.client.zzdq zzdqVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzmZ)).booleanValue()) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.e("setOnPaidEventListener is not supported in Ad Manager AdView returned by AdLoader.");
            return;
        }
        zzetc zzetcVar = this.zzc.zzc;
        if (zzetcVar != null) {
            try {
                if (!zzdqVar.zzf()) {
                    this.zzf.zzb();
                }
            } catch (RemoteException e3) {
                int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.b("Error in making CSI ping for reporting paid event callback", e3);
            }
            zzetcVar.zzp(zzdqVar);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzT(long j3) {
        zzcvl zzcvlVar = this.zzd;
        if (zzcvlVar.zzo() != null) {
            zzcvlVar.zzo().zzb(j3);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final long zzU() {
        zzcvl zzcvlVar = this.zzd;
        if (zzcvlVar == null || zzcvlVar.zzo() == null) {
            return 0L;
        }
        return zzcvlVar.zzo().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzY(com.google.android.gms.ads.internal.client.zzcp zzcpVar) throws RemoteException {
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.e("setCorrelationIdProvider is not supported in Ad Manager AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final IObjectWrapper zzb() throws RemoteException {
        return ObjectWrapper.i5(this.zze);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzc() throws RemoteException {
        Preconditions.f("destroy must be called on the main UI thread.");
        this.zzd.zzd();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final boolean zzd() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzdS(com.google.android.gms.ads.internal.client.zzbh zzbhVar) throws RemoteException {
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.e("setAdListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final boolean zze(com.google.android.gms.ads.internal.client.zzm zzmVar) throws RemoteException {
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.e("loadAd is not supported for an Ad Manager AdView returned from AdLoader.");
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzf() throws RemoteException {
        Preconditions.f("destroy must be called on the main UI thread.");
        this.zzd.zzl().zza(null);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzg() throws RemoteException {
        Preconditions.f("destroy must be called on the main UI thread.");
        this.zzd.zzl().zzb(null);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzi(com.google.android.gms.ads.internal.client.zzcl zzclVar) throws RemoteException {
        zzetc zzetcVar = this.zzc.zzc;
        if (zzetcVar != null) {
            zzetcVar.zzo(zzclVar);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzj(com.google.android.gms.ads.internal.client.zzby zzbyVar) throws RemoteException {
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.e("setAdMetadataListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final Bundle zzk() throws RemoteException {
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.e("getAdMetadata is not supported in Ad Manager AdView returned by AdLoader.");
        return new Bundle();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzm() throws RemoteException {
        this.zzd.zzi();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final com.google.android.gms.ads.internal.client.zzr zzn() {
        Preconditions.f("getAdSize must be called on the main UI thread.");
        return zzfle.zza(this.zza, Collections.singletonList(this.zzd.zze()));
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzo(com.google.android.gms.ads.internal.client.zzr zzrVar) throws RemoteException {
        Preconditions.f("setAdSize must be called on the main UI thread.");
        zzcvl zzcvlVar = this.zzd;
        if (zzcvlVar != null) {
            zzcvlVar.zzb(this.zze, zzrVar);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final String zzr() throws RemoteException {
        zzcvl zzcvlVar = this.zzd;
        if (zzcvlVar.zzn() != null) {
            return zzcvlVar.zzn().zze();
        }
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final String zzs() throws RemoteException {
        zzcvl zzcvlVar = this.zzd;
        if (zzcvlVar.zzn() != null) {
            return zzcvlVar.zzn().zze();
        }
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final com.google.android.gms.ads.internal.client.zzdx zzt() {
        return this.zzd.zzn();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final String zzu() throws RemoteException {
        return this.zzc.zzg;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final com.google.android.gms.ads.internal.client.zzcl zzv() throws RemoteException {
        return this.zzc.zzo;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final com.google.android.gms.ads.internal.client.zzbh zzw() throws RemoteException {
        return this.zzb;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzx(zzbjl zzbjlVar) throws RemoteException {
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.e("setOnCustomRenderedAdLoadedListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzy(com.google.android.gms.ads.internal.client.zzbe zzbeVar) throws RemoteException {
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.e("setAdClickListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzz(boolean z2) throws RemoteException {
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.e("setManualImpressionsEnabled is not supported in Ad Manager AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzl() throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzC(zzcbv zzcbvVar) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzD(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzE(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzH(com.google.android.gms.ads.internal.client.zzee zzeeVar) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzI(com.google.android.gms.ads.internal.client.zzx zzxVar) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzJ(zzbgm zzbgmVar) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzK(boolean z2) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzR(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzS(com.google.android.gms.ads.internal.client.zzcs zzcsVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzp(zzbzk zzbzkVar) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzQ(com.google.android.gms.ads.internal.client.zzm zzmVar, com.google.android.gms.ads.internal.client.zzbk zzbkVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzq(zzbzn zzbznVar, String str) throws RemoteException {
    }
}
