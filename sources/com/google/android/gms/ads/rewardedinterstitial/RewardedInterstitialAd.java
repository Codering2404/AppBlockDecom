package com.google.android.gms.ads.rewardedinterstitial;

import android.app.Activity;
import android.content.Context;
import coil.target.Yb.oUcQRqOVfOC;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbko;
import com.google.android.gms.internal.ads.zzbzy;
import com.google.android.gms.internal.ads.zzcdc;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class RewardedInterstitialAd {
    public static void load(final Context context, final String str, final AdRequest adRequest, final RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback) {
        Preconditions.n(context, "Context cannot be null.");
        Preconditions.n(str, "AdUnitId cannot be null.");
        Preconditions.n(adRequest, "AdRequest cannot be null.");
        Preconditions.n(rewardedInterstitialAdLoadCallback, "LoadCallback cannot be null.");
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzbiq.zza(context);
        if (((Boolean) zzbko.zzk.zze()).booleanValue()) {
            if (((Boolean) zzba.c().zzd(zzbiq.zzmD)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.f70157b.execute(new Runnable() { // from class: com.google.android.gms.ads.rewardedinterstitial.zzb
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback2 = rewardedInterstitialAdLoadCallback;
                        AdRequest adRequest2 = adRequest;
                        Context context2 = context;
                        try {
                            new zzcdc(context2, str).zza(adRequest2.a(), rewardedInterstitialAdLoadCallback2);
                        } catch (IllegalStateException e3) {
                            zzbzy.zza(context2).zzh(e3, oUcQRqOVfOC.DekEzZHLMIhCV);
                        }
                    }
                });
                return;
            }
        }
        new zzcdc(context, str).zza(adRequest.a(), rewardedInterstitialAdLoadCallback);
    }

    public abstract ResponseInfo getResponseInfo();

    public abstract void show(Activity activity, OnUserEarnedRewardListener onUserEarnedRewardListener);

    public static void load(final Context context, final String str, final AdManagerAdRequest adManagerAdRequest, final RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback) {
        Preconditions.n(context, "Context cannot be null.");
        Preconditions.n(str, "AdUnitId cannot be null.");
        Preconditions.n(adManagerAdRequest, "AdManagerAdRequest cannot be null.");
        Preconditions.n(rewardedInterstitialAdLoadCallback, "LoadCallback cannot be null.");
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzbiq.zza(context);
        if (((Boolean) zzbko.zzk.zze()).booleanValue()) {
            if (((Boolean) zzba.c().zzd(zzbiq.zzmD)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.f70157b.execute(new Runnable() { // from class: com.google.android.gms.ads.rewardedinterstitial.zza
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback2 = rewardedInterstitialAdLoadCallback;
                        AdManagerAdRequest adManagerAdRequest2 = adManagerAdRequest;
                        Context context2 = context;
                        try {
                            new zzcdc(context2, str).zza(adManagerAdRequest2.a(), rewardedInterstitialAdLoadCallback2);
                        } catch (IllegalStateException e3) {
                            zzbzy.zza(context2).zzh(e3, "RewardedInterstitialAdManager.load");
                        }
                    }
                });
                return;
            }
        }
        new zzcdc(context, str).zza(adManagerAdRequest.a(), rewardedInterstitialAdLoadCallback);
    }
}
