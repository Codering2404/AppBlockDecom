package com.iab.omid.library.applovin.utils;

import android.webkit.WebView;
import androidx.webkit.WebViewCompat;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class i {
    public void a(WebView webView, String str) {
        WebViewCompat.i(webView, str);
    }

    public void a(WebView webView, String str, Set<String> set, WebViewCompat.WebMessageListener webMessageListener) {
        WebViewCompat.b(webView, str, set, webMessageListener);
    }
}
