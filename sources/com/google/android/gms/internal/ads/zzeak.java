package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.admanager.AppEventListener;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeak implements AppEventListener, zzdfx, com.google.android.gms.ads.internal.client.zza, zzdcr, zzddl, zzddm, zzdef, zzdcu, zzfpl {
    private final List zza;
    private final zzdzy zzb;
    private long zzc;

    public zzeak(zzdzy zzdzyVar, zzcnj zzcnjVar) {
        this.zzb = zzdzyVar;
        this.zza = Collections.singletonList(zzcnjVar);
    }

    private final void zzi(Class cls, String str, Object... objArr) {
        this.zzb.zza(this.zza, "Event-".concat(cls.getSimpleName()), str, objArr);
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        zzi(com.google.android.gms.ads.internal.client.zza.class, "onAdClicked", new Object[0]);
    }

    @Override // com.google.android.gms.ads.admanager.AppEventListener
    public final void onAppEvent(String str, String str2) {
        zzi(AppEventListener.class, "onAppEvent", str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzddm
    public final void zza(Context context) {
        zzi(zzddm.class, "onPause", context);
    }

    @Override // com.google.android.gms.internal.ads.zzddm
    public final void zzb(Context context) {
        zzi(zzddm.class, "onResume", context);
    }

    @Override // com.google.android.gms.internal.ads.zzddm
    public final void zzc(Context context) {
        zzi(zzddm.class, "onDestroy", context);
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    @ParametersAreNonnullByDefault
    public final void zzd(zzcbp zzcbpVar, String str, String str2) {
        zzi(zzdcr.class, "onRewarded", zzcbpVar, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzdcu
    public final void zzdJ(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzi(zzdcu.class, "onAdFailedToLoad", Integer.valueOf(zzeVar.f69851a), zzeVar.f69852b, zzeVar.f69853c);
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzdK() {
        zzi(zzdcr.class, "onAdLeftApplication", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzfpl
    public final void zzdL(zzfpe zzfpeVar, String str) {
        zzi(zzfpd.class, "onTaskCreated", str);
    }

    @Override // com.google.android.gms.internal.ads.zzfpl
    public final void zzdM(zzfpe zzfpeVar, String str) {
        zzi(zzfpd.class, "onTaskStarted", str);
    }

    @Override // com.google.android.gms.internal.ads.zzfpl
    public final void zzdN(zzfpe zzfpeVar, String str, Throwable th) {
        zzi(zzfpd.class, "onTaskFailed", str, th.getClass().getSimpleName());
    }

    @Override // com.google.android.gms.internal.ads.zzfpl
    public final void zzdO(zzfpe zzfpeVar, String str) {
        zzi(zzfpd.class, "onTaskSucceeded", str);
    }

    @Override // com.google.android.gms.internal.ads.zzdfx
    public final void zzdP(zzcbd zzcbdVar) {
        this.zzc = com.google.android.gms.ads.internal.zzt.o().a();
        zzi(zzdfx.class, "onAdRequest", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzddl
    public final void zzdr() {
        zzi(zzddl.class, "onAdImpression", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzds() {
        zzi(zzdcr.class, "onAdClosed", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzdt() {
        zzi(zzdcr.class, "onAdOpened", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zze() {
        zzi(zzdcr.class, "onRewardedVideoStarted", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzdcr
    public final void zzf() {
        zzi(zzdcr.class, "onRewardedVideoCompleted", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzdef
    public final void zzg() {
        long jA = com.google.android.gms.ads.internal.zzt.o().a() - this.zzc;
        StringBuilder sb = new StringBuilder(String.valueOf(jA).length() + 21);
        sb.append("Ad Request Latency : ");
        sb.append(jA);
        com.google.android.gms.ads.internal.util.zze.k(sb.toString());
        zzi(zzdef.class, "onAdLoaded", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzdfx
    public final void zzdQ(zzfkq zzfkqVar) {
    }
}
