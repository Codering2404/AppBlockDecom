package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public interface zzeli {
    boolean zza(Context context);

    String zzb(Context context);

    zzeln zzc(String str, WebView webView, String str2, String str3, String str4, zzelk zzelkVar, zzelj zzeljVar, String str5);

    zzeln zzd(String str, WebView webView, String str2, String str3, String str4, String str5, zzelk zzelkVar, zzelj zzeljVar, String str6);

    void zze(zzfuk zzfukVar);

    void zzf(zzfuk zzfukVar);

    void zzg(zzfuk zzfukVar, View view);

    void zzh(zzfuk zzfukVar, View view);

    zzfuw zzi(VersionInfoParcel versionInfoParcel, WebView webView, boolean z2);

    void zzj(zzfuw zzfuwVar, zzfuv zzfuvVar);

    void zzk(zzfuw zzfuwVar, View view);
}
