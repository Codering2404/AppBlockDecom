package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.webkit.WebView;
import androidx.webkit.JavaScriptReplyProxy;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebViewCompat;
import com.facebook.GraphRequest;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfuu implements WebViewCompat.WebMessageListener {
    final /* synthetic */ zzfuw zza;

    zzfuu(zzfuw zzfuwVar) {
        Objects.requireNonNull(zzfuwVar);
        this.zza = zzfuwVar;
    }

    @Override // androidx.webkit.WebViewCompat.WebMessageListener
    public final void onPostMessage(WebView webView, WebMessageCompat webMessageCompat, Uri uri, boolean z2, JavaScriptReplyProxy javaScriptReplyProxy) {
        try {
            JSONObject jSONObject = new JSONObject(webMessageCompat.c());
            String string = jSONObject.getString(GraphRequest.BATCH_METHOD_PARAM);
            String string2 = jSONObject.getJSONObject("data").getString("adSessionId");
            if (string.equals("startSession")) {
                this.zza.zzf(string2);
            } else if (string.equals("finishSession")) {
                this.zza.zzg(string2);
            } else {
                zzfuh.zza.getClass();
            }
        } catch (JSONException e3) {
            zzfwf.zza("Error parsing JS message in JavaScriptSessionService.", e3);
        }
    }
}
