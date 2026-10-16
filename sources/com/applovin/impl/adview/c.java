package com.applovin.impl.adview;

import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.MotionEvent;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.aq;
import com.applovin.impl.dq;
import com.applovin.impl.ka;
import com.applovin.impl.la;
import com.applovin.impl.mq;
import com.applovin.impl.pi;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sj;
import com.applovin.impl.yp;
import com.applovin.impl.z3;
import com.applovin.sdk.AppLovinAdSize;
import com.facebook.GraphResponse;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class c extends pi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f58327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f58328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f58329c;

    public c(a aVar, com.applovin.impl.sdk.j jVar) {
        this.f58327a = jVar;
        this.f58328b = jVar.I();
        this.f58329c = aVar;
    }

    private void a(aq aqVar, b bVar) {
        a(aqVar, bVar, (Bundle) null);
    }

    private void b() {
        this.f58329c.a();
    }

    protected a c() {
        return this.f58329c;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
        if (com.applovin.impl.sdk.n.a()) {
            this.f58328b.d("AdWebView", "Loaded resource: " + str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (com.applovin.impl.sdk.n.a()) {
            this.f58328b.d("AdWebView", "Loaded URL: " + str);
        }
        a aVar = this.f58329c;
        if (aVar != null) {
            aVar.a(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        onReceivedError(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        a aVar = this.f58329c;
        if (aVar != null) {
            com.applovin.impl.sdk.ad.b bVarI = aVar.i();
            if (com.applovin.impl.sdk.n.a()) {
                this.f58328b.b("AdWebView", "Received HTTP error: " + webResourceResponse + "for url: " + webResourceRequest.getUrl() + " and ad: " + bVarI);
            }
        }
        if (yp.a(webResourceRequest.getUrl().toString(), this.f58327a)) {
            this.f58327a.D().a("adWebViewReceivedHttpError", webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode());
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        a aVar = this.f58329c;
        if (aVar != null) {
            com.applovin.impl.sdk.ad.b bVarI = aVar.i();
            String str = "Received SSL error: " + sslError;
            if (com.applovin.impl.sdk.n.a()) {
                this.f58328b.b("AdWebView", str + " for ad: " + bVarI);
            }
        }
    }

    @Override // com.applovin.impl.pi, android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.render_process_gone"), null);
        if (this.f58329c == null) {
            return true;
        }
        com.applovin.impl.sdk.n.h("AdWebView", "Render process gone for ad: " + this.f58329c.i() + ". Process did crash: " + renderProcessGoneDetail.didCrash());
        com.applovin.impl.sdk.ad.b bVarI = this.f58329c.i();
        if (bVarI != null) {
            Map mapA = la.a(bVarI);
            CollectionUtils.putStringIfValid("top_main_method", "onRenderProcessGone", mapA);
            if (z3.i()) {
                mapA.put("source", renderProcessGoneDetail.didCrash() ? "crash" : "non_crash");
            }
            this.f58327a.D().a(ka.f60951d0, mapA);
        }
        if (((Boolean) this.f58327a.a(sj.E5)).booleanValue()) {
            if (renderProcessGoneDetail.didCrash() && ((Boolean) this.f58327a.a(sj.J5)).booleanValue()) {
                throw new RuntimeException("Render process crashed. This is likely caused by a crash in an AppLovin ad with ID: " + (bVarI != null ? String.valueOf(bVarI.getAdIdNumber()) : "null"));
            }
            if (webView != null && webView.equals(this.f58329c.g())) {
                this.f58329c.b();
                AppLovinAdSize appLovinAdSizeM = this.f58329c.m();
                if (yp.a(appLovinAdSizeM)) {
                    this.f58329c.a(appLovinAdSizeM);
                    this.f58329c.H();
                }
            }
        }
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Uri url = webResourceRequest.getUrl();
        if (url != null) {
            return a(webView, url.toString());
        }
        if (!com.applovin.impl.sdk.n.a()) {
            return false;
        }
        this.f58328b.b("AdWebView", "No url found for request");
        return false;
    }

    private void a(aq aqVar, b bVar, Bundle bundle) {
        dq dqVarL1 = aqVar.l1();
        if (dqVarL1 != null) {
            mq.a(dqVarL1.b(), this.f58329c.l());
            a(bVar, dqVarL1.c(), bundle);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i3, String str, String str2) {
        super.onReceivedError(webView, i3, str, str2);
        a aVar = this.f58329c;
        if (aVar != null) {
            com.applovin.impl.sdk.ad.b bVarI = aVar.i();
            String str3 = "Received error with error code: " + i3 + " with description \\'" + str + "\\' for URL: " + str2;
            if (com.applovin.impl.sdk.n.a()) {
                this.f58328b.b("AdWebView", str3 + " for ad: " + bVarI);
            }
        }
        if (yp.a(str2, this.f58327a)) {
            this.f58327a.D().a("adWebViewReceivedError", str2, i3);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return a(webView, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0188  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean a(android.webkit.WebView r12, java.lang.String r13) {
        /*
            Method dump skipped, instruction units count: 799
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.c.a(android.webkit.WebView, java.lang.String):boolean");
    }

    private boolean a(boolean z2, com.applovin.impl.sdk.ad.b bVar, Uri uri) {
        if (z2) {
            return false;
        }
        if (bVar.b1()) {
            return true;
        }
        if (bVar.h1()) {
            this.f58327a.D().a(ka.O, a(bVar, uri));
        }
        return false;
    }

    private static Map a(com.applovin.impl.sdk.ad.b bVar, Uri uri) {
        Map mapA = la.a(bVar);
        CollectionUtils.putStringIfValid("url", uri.toString(), mapA);
        return mapA;
    }

    private void a() {
        this.f58329c.z();
    }

    private void a(MotionEvent motionEvent) {
        this.f58329c.a(motionEvent);
    }

    private void a(b bVar, Uri uri) {
        a(bVar, uri, (Bundle) null);
    }

    private void a(b bVar, Uri uri, Bundle bundle) {
        com.applovin.impl.sdk.ad.b currentAd = bVar.getCurrentAd();
        AppLovinAdView appLovinAdViewK = this.f58329c.k();
        if (appLovinAdViewK != null && currentAd != null) {
            if (currentAd instanceof aq) {
                ((aq) currentAd).getAdEventTracker().v();
            }
            this.f58329c.a(currentAd, appLovinAdViewK, uri, bVar.getAndClearLastClickEvent(), bundle);
        } else if (com.applovin.impl.sdk.n.a()) {
            this.f58328b.b("AdWebView", "Attempting to track click that is null or not an ApplovinAdView instance for clickedUri = " + uri);
        }
    }

    private void a(Uri uri) {
        String str;
        boolean booleanQueryParameter = uri.getBooleanQueryParameter(GraphResponse.SUCCESS_KEY, false);
        String queryParameter = uri.getQueryParameter("type");
        if (booleanQueryParameter) {
            str = "Tracked event: " + queryParameter;
        } else {
            str = "Failed to track event: " + queryParameter;
        }
        yp.a(str, com.applovin.impl.sdk.j.m());
    }
}
