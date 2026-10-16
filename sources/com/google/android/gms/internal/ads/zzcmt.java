package com.google.android.gms.internal.ads;

import android.webkit.WebView;
import androidx.webkit.Profile;
import androidx.webkit.ProfileStore;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcmt {
    private Profile zza = null;

    zzcmt() {
    }

    public final void zza(WebView webView) {
        if (this.zza != null) {
            try {
                WebViewCompat.k(webView, "GMA_WEBVIEW_PROFILE");
                com.google.android.gms.ads.internal.util.zze.k("WebViewCompat Profile is defined");
            } catch (IllegalStateException e3) {
                String strConcat = "WebViewCompat error: ".concat(e3.toString());
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.f(strConcat);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpy)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzt.l().zzg(e3, "WebViewCompat.setProfile");
                }
            }
        }
    }

    final void zzb(zzcmx zzcmxVar) {
        ProfileStore profileStore;
        if (!WebViewFeature.a("MULTI_PROFILE")) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.a("WebViewFeature.MULTI_PROFILE is not supported");
            return;
        }
        try {
            profileStore = (ProfileStore) zzgar.zza("androidx.webkit.ProfileStore", "getInstance", new zzgaq[0]);
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalStateException | NoSuchMethodException | InvocationTargetException e3) {
            String strValueOf = String.valueOf(e3.getMessage());
            int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.a("Unable to get ProfileStore instance: ".concat(strValueOf));
            try {
                profileStore = (ProfileStore) zzgar.zza("androidx.webkit.ProfileStore$-CC", "getInstance", new zzgaq[0]);
            } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalStateException | NoSuchMethodException | InvocationTargetException e4) {
                com.google.android.gms.ads.internal.util.client.zzo.a("Unable to get ProfileStore instance: ".concat(String.valueOf(e4.getMessage())));
                profileStore = null;
            }
        }
        if (profileStore != null) {
            this.zza = profileStore.getOrCreateProfile("GMA_WEBVIEW_PROFILE");
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpx)).booleanValue()) {
                long jA = com.google.android.gms.ads.internal.zzt.o().a() - zzcmxVar.zza;
                zzdzk zzdzkVarZza = zzcmxVar.zzb.zzd().zza();
                zzdzkVarZza.zzc("action", "webview_p_l");
                zzdzkVarZza.zzc("webview_p_l", Long.toString(jA));
                zzdzkVarZza.zzd();
                return;
            }
            return;
        }
        int i5 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.f("WebViewCompat failure: No instance");
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpx)).booleanValue()) {
            zzdzk zzdzkVarZza2 = zzcmxVar.zzb.zzd().zza();
            zzdzkVarZza2.zzc("action", "webview_p_f");
            zzdzkVarZza2.zzc("webview_p_f", "No instance");
            zzdzkVarZza2.zzd();
        }
    }
}
