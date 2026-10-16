package com.google.android.gms.ads.appopen;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdLoadCallback;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbgf;
import com.google.android.gms.internal.ads.zzbgj;
import com.google.android.gms.internal.ads.zzbgr;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbko;
import com.google.android.gms.internal.ads.zzbzy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AppOpenAd {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class AppOpenAdLoadCallback extends AdLoadCallback<AppOpenAd> {
    }

    @Deprecated
    public static boolean isAdAvailable(Context context, String str) {
        try {
            return zzb.a(context).zzh(str);
        } catch (RemoteException e3) {
            zzo.i("#007 Could not call remote method.", e3);
            return false;
        }
    }

    public static void load(final Context context, final String str, final AdRequest adRequest, final AppOpenAdLoadCallback appOpenAdLoadCallback) {
        Preconditions.n(context, "Context cannot be null.");
        Preconditions.n(str, "adUnitId cannot be null.");
        Preconditions.n(adRequest, "AdRequest cannot be null.");
        Preconditions.f("#008 Must be called on the main UI thread.");
        zzbiq.zza(context);
        if (((Boolean) zzbko.zzd.zze()).booleanValue()) {
            if (((Boolean) zzba.c().zzd(zzbiq.zzmD)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.f70157b.execute(new Runnable() { // from class: com.google.android.gms.ads.appopen.zza
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback2 = appOpenAdLoadCallback;
                        AdRequest adRequest2 = adRequest;
                        Context context2 = context;
                        try {
                            new zzbgr(context2, str, adRequest2.a(), appOpenAdLoadCallback2).zza();
                        } catch (IllegalStateException e3) {
                            zzbzy.zza(context2).zzh(e3, "AppOpenAd.load");
                        }
                    }
                });
                return;
            }
        }
        new zzbgr(context, str, adRequest.a(), appOpenAdLoadCallback).zza();
    }

    @Deprecated
    public static AppOpenAd pollAd(Context context, String str) {
        try {
            zzbgj zzbgjVarZzi = zzb.a(context).zzi(str);
            if (zzbgjVarZzi != null) {
                return new zzbgf(zzbgjVarZzi, str);
            }
            zzo.i("Failed to obtain an App Open ad from the preloader.", null);
            return null;
        } catch (RemoteException e3) {
            zzo.i("#007 Could not call remote method.", e3);
            return null;
        }
    }

    public abstract ResponseInfo getResponseInfo();

    public abstract void show(Activity activity);
}
