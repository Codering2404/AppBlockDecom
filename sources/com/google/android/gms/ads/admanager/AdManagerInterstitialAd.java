package com.google.android.gms.ads.admanager;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbko;
import com.google.android.gms.internal.ads.zzbsl;
import com.google.android.gms.internal.ads.zzbzy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AdManagerInterstitialAd extends InterstitialAd {
    public static void load(final Context context, final String str, final AdManagerAdRequest adManagerAdRequest, final AdManagerInterstitialAdLoadCallback adManagerInterstitialAdLoadCallback) {
        Preconditions.n(context, "Context cannot be null.");
        Preconditions.n(str, "AdUnitId cannot be null.");
        Preconditions.n(adManagerAdRequest, "AdManagerAdRequest cannot be null.");
        Preconditions.n(adManagerInterstitialAdLoadCallback, "LoadCallback cannot be null.");
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzbiq.zza(context);
        if (((Boolean) zzbko.zzi.zze()).booleanValue()) {
            if (((Boolean) zzba.c().zzd(zzbiq.zzmD)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.f70157b.execute(new Runnable() { // from class: com.google.android.gms.ads.admanager.zzb
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        AdManagerInterstitialAdLoadCallback adManagerInterstitialAdLoadCallback2 = adManagerInterstitialAdLoadCallback;
                        AdManagerAdRequest adManagerAdRequest2 = adManagerAdRequest;
                        Context context2 = context;
                        try {
                            new zzbsl(context2, str).zza(adManagerAdRequest2.a(), adManagerInterstitialAdLoadCallback2);
                        } catch (IllegalStateException e3) {
                            zzbzy.zza(context2).zzh(e3, "AdManagerInterstitialAd.load");
                        }
                    }
                });
                return;
            }
        }
        new zzbsl(context, str).zza(adManagerAdRequest.a(), adManagerInterstitialAdLoadCallback);
    }
}
