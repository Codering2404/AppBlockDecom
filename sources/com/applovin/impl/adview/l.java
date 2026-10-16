package com.applovin.impl.adview;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.applovin.impl.j3;
import com.applovin.impl.rr;
import com.applovin.impl.z3;
import com.facebook.internal.instrument.anrreport.jRA.jlWo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class l extends j3 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f58366c;

    public l(String str, com.applovin.impl.sdk.ad.b bVar, rr rrVar, Context context) {
        super(context);
        this.f58366c = str;
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setSupportMultipleWindows(false);
        settings.setJavaScriptEnabled(true);
        if (bVar.P0()) {
            applySettings(bVar);
        } else {
            settings.setAllowFileAccess(true);
            if (z3.e() && bVar.L0()) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
        }
        setWebViewClient(rrVar);
        setWebChromeClient(new WebChromeClient());
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setScrollBarStyle(33554432);
    }

    public void a(String str) {
        loadDataWithBaseURL(this.f58366c, str, "text/html", null, jlWo.idOrVorUx);
    }
}
