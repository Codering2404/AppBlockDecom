package com.google.android.gms.ads.rewarded;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbko;
import com.google.android.gms.internal.ads.zzbzy;
import com.google.android.gms.internal.ads.zzcci;
import com.google.android.gms.internal.ads.zzccr;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class RewardedAd {
    @Deprecated
    public static boolean isAdAvailable(Context context, String str) {
        Preconditions.n(context, "Context cannot be null.");
        Preconditions.n(str, "AdUnitId cannot be null.");
        try {
            return com.google.android.gms.ads.zzb.a(context).zzf(str);
        } catch (RemoteException e3) {
            zzo.i("#007 Could not call remote method.", e3);
            return false;
        }
    }

    public static void load(final Context context, final String str, final AdRequest adRequest, final RewardedAdLoadCallback rewardedAdLoadCallback) {
        Preconditions.n(context, "Context cannot be null.");
        Preconditions.n(str, "AdUnitId cannot be null.");
        Preconditions.n(adRequest, "AdRequest cannot be null.");
        Preconditions.n(rewardedAdLoadCallback, "LoadCallback cannot be null.");
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzbiq.zza(context);
        if (((Boolean) zzbko.zzk.zze()).booleanValue()) {
            if (((Boolean) zzba.c().zzd(zzbiq.zzmD)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.f70157b.execute(new Runnable() { // from class: com.google.android.gms.ads.rewarded.zzc
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        RewardedAdLoadCallback rewardedAdLoadCallback2 = rewardedAdLoadCallback;
                        AdRequest adRequest2 = adRequest;
                        Context context2 = context;
                        try {
                            new zzccr(context2, str).zza(adRequest2.a(), rewardedAdLoadCallback2);
                        } catch (IllegalStateException e3) {
                            zzbzy.zza(context2).zzh(e3, "RewardedAd.load");
                        }
                    }
                });
                return;
            }
        }
        zzo.a("Loading on UI thread");
        new zzccr(context, str).zza(adRequest.a(), rewardedAdLoadCallback);
    }

    public abstract ResponseInfo getResponseInfo();

    public abstract void show(Activity activity, OnUserEarnedRewardListener onUserEarnedRewardListener);

    @Deprecated
    public static RewardedAd pollAd(Context context, String str) {
        Preconditions.n(context, SbbqvQlxi.DhMExbeLNDC);
        Preconditions.n(str, "AdUnitId cannot be null.");
        try {
            zzcci zzcciVarZzg = com.google.android.gms.ads.zzb.a(context).zzg(str);
            if (zzcciVarZzg != null) {
                return new zzccr(context, str, zzcciVarZzg);
            }
            zzo.i("Failed to obtain a Rewarded Ad from the preloader.", null);
            return null;
        } catch (RemoteException e3) {
            zzo.i("#007 Could not call remote method.", e3);
            return null;
        }
    }

    public static void load(final Context context, final String str, final AdManagerAdRequest adManagerAdRequest, final RewardedAdLoadCallback rewardedAdLoadCallback) {
        Preconditions.n(context, "Context cannot be null.");
        Preconditions.n(str, "AdUnitId cannot be null.");
        Preconditions.n(adManagerAdRequest, "AdManagerAdRequest cannot be null.");
        Preconditions.n(rewardedAdLoadCallback, "LoadCallback cannot be null.");
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzbiq.zza(context);
        if (((Boolean) zzbko.zzk.zze()).booleanValue()) {
            if (((Boolean) zzba.c().zzd(zzbiq.zzmD)).booleanValue()) {
                zzo.a("Loading on background thread");
                com.google.android.gms.ads.internal.util.client.zzb.f70157b.execute(new Runnable() { // from class: com.google.android.gms.ads.rewarded.zzb
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        RewardedAdLoadCallback rewardedAdLoadCallback2 = rewardedAdLoadCallback;
                        AdManagerAdRequest adManagerAdRequest2 = adManagerAdRequest;
                        Context context2 = context;
                        try {
                            new zzccr(context2, str).zza(adManagerAdRequest2.a(), rewardedAdLoadCallback2);
                        } catch (IllegalStateException e3) {
                            zzbzy.zza(context2).zzh(e3, "RewardedAd.loadAdManager");
                        }
                    }
                });
                return;
            }
        }
        zzo.a("Loading on UI thread");
        new zzccr(context, str).zza(adManagerAdRequest.a(), rewardedAdLoadCallback);
    }
}
