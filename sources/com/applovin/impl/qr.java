package com.applovin.impl;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.stetho.common.Utf8Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class qr extends pi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f62674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f62675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WebView f62676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f62677d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set f62678e = Collections.synchronizedSet(new HashSet());

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends WebViewClient {
        a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            com.applovin.impl.sdk.n unused = qr.this.f62675b;
            if (com.applovin.impl.sdk.n.a()) {
                qr.this.f62675b.a("WebTrackerManager", "Successfully initialized web view for postbacks");
            }
            qr.this.f62677d = true;
        }
    }

    public qr(com.applovin.impl.sdk.j jVar) {
        this.f62674a = jVar;
        this.f62675b = jVar.I();
    }

    @Override // com.applovin.impl.pi, android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (webView == this.f62676c) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.j10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f60576a.a();
                }
            });
        } else {
            b(webView);
        }
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str) {
        final WebView webViewA = a(str);
        if (webViewA != null) {
            this.f62678e.add(webViewA);
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.m10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61328a.b(webViewA);
                }
            }, ((Integer) this.f62674a.a(sj.N2)).intValue());
        } else if (com.applovin.impl.sdk.n.a()) {
            this.f62675b.b("WebTrackerManager", "Failed to fire tracker since web view could not be created");
        }
    }

    private boolean d() {
        return ((Boolean) this.f62674a.a(sj.S2)).booleanValue();
    }

    public void b(final String str) {
        if (!AppLovinSdkUtils.isValidString(str)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f62675b.b("WebTrackerManager", "Failed to fire tracker due to empty script string");
            }
        } else if (str.startsWith("<script")) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.l10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61101a.c(str);
                }
            });
        } else if (com.applovin.impl.sdk.n.a()) {
            this.f62675b.b("WebTrackerManager", "Failed to fire tracker due to improperly formatted script tag");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(final WebView webView) {
        if (webView == null || !this.f62678e.remove(webView)) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.n10
            @Override // java.lang.Runnable
            public final void run() {
                webView.destroy();
            }
        });
    }

    private WebView a(String str) {
        return a(str, false);
    }

    public void a(final com.applovin.impl.sdk.network.e eVar, final AppLovinPostbackListener appLovinPostbackListener) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.k10
            @Override // java.lang.Runnable
            public final void run() {
                this.f60889a.b(eVar, appLovinPostbackListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        this.f62676c.destroy();
        this.f62676c = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(com.applovin.impl.sdk.network.e eVar, AppLovinPostbackListener appLovinPostbackListener) {
        String strAppendQueryParameters = StringUtils.appendQueryParameters(eVar.f(), eVar.i(), ((Boolean) this.f62674a.a(sj.k3)).booleanValue());
        if (this.f62676c == null) {
            WebView webViewA = a("<script>window.al_firePostback = function(url) {\n    setTimeout(function() {\n        var img = new Image();\n        img.src = url;\n    }, 100);\n}\n</script>", true);
            this.f62676c = webViewA;
            if (webViewA == null) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f62675b.b("WebTrackerManager", "Failed to fire postback since web view could not be created");
                }
                appLovinPostbackListener.onPostbackFailure(strAppendQueryParameters, -1);
                return;
            }
        }
        if (d() && !this.f62677d) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f62675b.b("WebTrackerManager", "Failed to fire postback since web view was not initialized in time");
            }
            HashMap<String, String> mapHashMap = CollectionUtils.hashMap("top_main_method", "firePostback");
            mapHashMap.put("url", strAppendQueryParameters);
            this.f62674a.D().a(ka.f60951d0, (Map) mapHashMap);
            appLovinPostbackListener.onPostbackFailure(strAppendQueryParameters, -1);
            return;
        }
        tr.a(this.f62676c, "al_firePostback('" + strAppendQueryParameters + "')");
        appLovinPostbackListener.onPostbackSuccess(strAppendQueryParameters);
    }

    public void c() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.i10
            @Override // java.lang.Runnable
            public final void run() {
                this.f60305a.b();
            }
        });
    }

    private WebView a(String str, boolean z2) {
        yp.b();
        WebView webViewB = yp.b(com.applovin.impl.sdk.j.m(), "web tracker");
        if (webViewB == null) {
            return null;
        }
        webViewB.getSettings().setJavaScriptEnabled(true);
        webViewB.setWebViewClient(this);
        if (z2 && d()) {
            webViewB.setWebViewClient(new a());
        }
        webViewB.loadData("<html><head><link rel=\"icon\" href=\"data:,\">" + str + "</head><body></body></html>", "text/html", Utf8Charset.NAME);
        return webViewB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        WebView webViewA = a("<script>window.al_firePostback = function(url) {\n    setTimeout(function() {\n        var img = new Image();\n        img.src = url;\n    }, 100);\n}\n</script>", true);
        this.f62676c = webViewA;
        if (webViewA == null && com.applovin.impl.sdk.n.a()) {
            this.f62675b.b("WebTrackerManager", "Failed to preload postback web view");
        }
    }
}
