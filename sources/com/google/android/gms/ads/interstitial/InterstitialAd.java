package com.google.android.gms.ads.interstitial;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbko;
import com.google.android.gms.internal.ads.zzbsl;
import com.google.android.gms.internal.ads.zzbzy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class InterstitialAd {
    @Deprecated
    public static boolean isAdAvailable(Context context, String str) {
        try {
            return zzb.a(context).zzj(str);
        } catch (RemoteException e3) {
            zzo.i("#007 Could not call remote method.", e3);
            return false;
        }
    }

    public static void load(final Context context, final String str, final AdRequest adRequest, final InterstitialAdLoadCallback interstitialAdLoadCallback) {
        Preconditions.n(context, "Context cannot be null.");
        Preconditions.n(str, "AdUnitId cannot be null.");
        Preconditions.n(adRequest, "AdRequest cannot be null.");
        Preconditions.n(interstitialAdLoadCallback, "LoadCallback cannot be null.");
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzbiq.zza(context);
        if (((Boolean) zzbko.zzi.zze()).booleanValue()) {
            if (((Boolean) zzba.c().zzd(zzbiq.zzmD)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.f70157b.execute(new Runnable() { // from class: com.google.android.gms.ads.interstitial.zza
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        InterstitialAdLoadCallback interstitialAdLoadCallback2 = interstitialAdLoadCallback;
                        AdRequest adRequest2 = adRequest;
                        Context context2 = context;
                        try {
                            new zzbsl(context2, str).zza(adRequest2.a(), interstitialAdLoadCallback2);
                        } catch (IllegalStateException e3) {
                            zzbzy.zza(context2).zzh(e3, "InterstitialAd.load");
                        }
                    }
                });
                return;
            }
        }
        new zzbsl(context, str).zza(adRequest.a(), interstitialAdLoadCallback);
    }

    @Deprecated
    public static InterstitialAd pollAd(Context context, String str) {
        try {
            zzbu zzbuVarZzk = zzb.a(context).zzk(str);
            if (zzbuVarZzk != null) {
                return new zzbsl(context, str, zzbuVarZzk);
            }
            zzo.i("Failed to obtain an Interstitial Ad from the preloader.", null);
            return null;
        } catch (RemoteException e3) {
            zzo.i("#007 Could not call remote method.", e3);
            return null;
        }
    }

    public abstract ResponseInfo getResponseInfo();

    public abstract void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback);

    public abstract void setImmersiveMode(boolean z2);

    public abstract void show(Activity activity);
}
