package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbxu implements MediationInterstitialAdapter {
    private Activity zza;
    private MediationInterstitialListener zzb;
    private Uri zzc;

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void onDestroy() {
        com.google.android.gms.ads.internal.util.client.zzo.a("Destroying AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void onPause() {
        com.google.android.gms.ads.internal.util.client.zzo.a("Pausing AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void onResume() {
        com.google.android.gms.ads.internal.util.client.zzo.a("Resuming AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzb = mediationInterstitialListener;
        if (mediationInterstitialListener == null) {
            com.google.android.gms.ads.internal.util.client.zzo.f("Listener not set for mediation. Returning.");
            return;
        }
        if (!(context instanceof Activity)) {
            com.google.android.gms.ads.internal.util.client.zzo.f("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.zzb.onAdFailedToLoad(this, 0);
            return;
        }
        if (!zzbjr.zza(context)) {
            com.google.android.gms.ads.internal.util.client.zzo.f("Default browser does not support custom tabs. Bailing out.");
            this.zzb.onAdFailedToLoad(this, 0);
            return;
        }
        String string = bundle.getString("tab_url");
        if (TextUtils.isEmpty(string)) {
            com.google.android.gms.ads.internal.util.client.zzo.f("The tab_url retrieved from mediation metadata is empty. Bailing out.");
            this.zzb.onAdFailedToLoad(this, 0);
        } else {
            this.zza = (Activity) context;
            this.zzc = Uri.parse(string);
            this.zzb.onAdLoaded(this);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void showInterstitial() {
        CustomTabsIntent customTabsIntentA = new CustomTabsIntent.Builder().a();
        customTabsIntentA.f2637a.setData(this.zzc);
        com.google.android.gms.ads.internal.util.zzs.f70374l.post(new zzbxt(this, new AdOverlayInfoParcel(new com.google.android.gms.ads.internal.overlay.zzc(customTabsIntentA.f2637a, null), null, new zzbxs(this), null, new VersionInfoParcel(0, 0, false), null, null, "")));
        com.google.android.gms.ads.internal.zzt.l().zzd();
    }

    final /* synthetic */ Activity zza() {
        return this.zza;
    }

    final /* synthetic */ MediationInterstitialListener zzb() {
        return this.zzb;
    }
}
