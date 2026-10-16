package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbfo implements Runnable {
    final ValueCallback zza;
    final /* synthetic */ zzbfg zzb;
    final /* synthetic */ WebView zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzbfq zze;

    zzbfo(zzbfq zzbfqVar, final zzbfg zzbfgVar, final WebView webView, final boolean z2) {
        this.zzb = zzbfgVar;
        this.zzc = webView;
        this.zzd = z2;
        Objects.requireNonNull(zzbfqVar);
        this.zze = zzbfqVar;
        this.zza = new ValueCallback() { // from class: com.google.android.gms.internal.ads.zzbfn
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(Object obj) {
                this.zza.zze.zzd(zzbfgVar, webView, (String) obj, z2);
            }
        };
    }

    @Override // java.lang.Runnable
    public final void run() {
        WebView webView = this.zzc;
        if (webView.getSettings().getJavaScriptEnabled()) {
            try {
                webView.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zza);
            } catch (Throwable unused) {
                this.zza.onReceiveValue("");
            }
        }
    }
}
