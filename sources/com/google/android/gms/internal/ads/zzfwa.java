package com.google.android.gms.internal.ads;

import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfwa extends WebViewClient {
    final /* synthetic */ zzfwc zza;

    zzfwa(zzfwc zzfwcVar) {
        Objects.requireNonNull(zzfwcVar);
        this.zza = zzfwcVar;
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        String string = renderProcessGoneDetail.toString();
        String strValueOf = String.valueOf(webView);
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 36 + strValueOf.length());
        sb.append("WebView renderer gone: ");
        sb.append(string);
        sb.append(cJfnYMIyomoWf.eNgnsBvmho);
        sb.append(strValueOf);
        Log.w("NativeBridge", sb.toString());
        zzfwc zzfwcVar = this.zza;
        if (zzfwcVar.zzd() == webView) {
            Log.w("NativeBridge", "Deallocating the Native bridge as it is unusable. No further events will be generated for this session.");
            zzfwcVar.zzc(null);
        }
        webView.destroy();
        return true;
    }
}
