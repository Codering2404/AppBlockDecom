package com.applovin.impl;

import android.content.Intent;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class f0 extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f59598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f59599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.applovin.impl.adview.a f59600c;

    public f0(com.applovin.impl.adview.a aVar, com.applovin.impl.sdk.j jVar) {
        this.f59598a = jVar;
        this.f59599b = jVar.I();
        this.f59600c = aVar;
    }

    private void a(ConsoleMessage consoleMessage) {
        AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.al_onPoststitialShow_evaluation_error"), null);
        com.applovin.impl.sdk.ad.b bVarI = this.f59600c.i();
        if (bVarI != null) {
            String str = consoleMessage.messageLevel() + ": " + consoleMessage.sourceId() + ": " + consoleMessage.lineNumber();
            Map mapA = la.a(bVarI);
            mapA.put("source", "AdWebView:onPoststitialShowEvaluationError");
            mapA.put("top_main_method", str);
            mapA.put("error_message", consoleMessage.message());
            this.f59598a.D().a(ka.f60947b0, mapA);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String str = consoleMessage.messageLevel() + ": " + consoleMessage.sourceId() + ": " + consoleMessage.lineNumber() + ": " + consoleMessage.message();
        if (com.applovin.impl.sdk.n.a()) {
            this.f59599b.a("AdWebView", str);
        }
        if (consoleMessage.messageLevel() != ConsoleMessage.MessageLevel.ERROR) {
            return true;
        }
        if (!consoleMessage.message().contains("al_onPoststitialShow") && !consoleMessage.message().contains("al_showPostitial")) {
            return true;
        }
        a(consoleMessage);
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (!com.applovin.impl.sdk.n.a()) {
            return true;
        }
        this.f59599b.k("AdWebView", "Alert attempted: " + str2);
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        if (!com.applovin.impl.sdk.n.a()) {
            return true;
        }
        this.f59599b.k("AdWebView", "JS onBeforeUnload attempted: " + str2);
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        if (!com.applovin.impl.sdk.n.a()) {
            return true;
        }
        this.f59599b.k("AdWebView", "JS confirm attempted: " + str2);
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i3) {
        com.applovin.impl.adview.a aVar;
        if (i3 != 100 || (aVar = this.f59600c) == null) {
            return;
        }
        aVar.c(webView);
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String str, int i3, String str2) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f59599b.k("AdWebView", "console.log[" + i3 + "] :" + str);
        }
    }
}
