package com.google.android.gms.ads.nonagon.signalgeneration;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbkv;
import com.google.android.gms.internal.ads.zzbqm;
import com.google.android.gms.internal.ads.zzcfr;
import com.google.android.gms.internal.ads.zzhcg;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zze extends zzbqm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zza f70728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f70729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f70730c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Future f70731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WebViewClient f70732e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private WebView f70733f;

    public zze(WebView webView, zza zzaVar, zzhcg zzhcgVar) {
        this.f70733f = webView;
        this.f70728a = zzaVar;
        this.f70729b = zzhcgVar;
    }

    private final void c() {
        synchronized (this.f70730c) {
            try {
                WebView webView = this.f70733f;
                if (webView == null) {
                    return;
                }
                webView.evaluateJavascript(String.format(Locale.getDefault(), (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzli), this.f70728a.b()), null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final boolean d() {
        if (!((Boolean) zzbkv.zza.zze()).booleanValue()) {
            return false;
        }
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces == null || !allStackTraces.containsKey(Thread.currentThread())) {
            return true;
        }
        boolean z2 = false;
        boolean z3 = false;
        for (StackTraceElement stackTraceElement : allStackTraces.get(Thread.currentThread())) {
            if (stackTraceElement.getClassName().contains(zze.class.getName())) {
                if (z2 && z3) {
                    return true;
                }
                z2 = true;
            } else if (z2) {
                z3 = true;
            }
        }
        return false;
    }

    public final void a() {
        this.f70729b.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzc
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f70726a.b();
            }
        });
    }

    final /* synthetic */ void b() {
        synchronized (this.f70730c) {
            WebView webView = this.f70733f;
            if (webView == null) {
                return;
            }
            try {
                com.google.android.gms.ads.internal.zzt.g();
                WebViewClient webViewClient = webView.getWebViewClient();
                if (webViewClient == this) {
                    return;
                }
                if (webViewClient != null) {
                    this.f70732e = webViewClient;
                }
                webView.setWebViewClient(this);
                c();
            } catch (IllegalStateException unused) {
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbqm, android.webkit.WebViewClient
    public final void doUpdateVisitedHistory(WebView webView, String str, boolean z2) {
        if (d()) {
            return;
        }
        super.doUpdateVisitedHistory(webView, str, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzbqm
    protected final WebViewClient getDelegate() {
        return this.f70732e;
    }

    @Override // com.google.android.gms.internal.ads.zzbqm, android.webkit.WebViewClient
    public final void onFormResubmission(WebView webView, Message message, Message message2) {
        if (d()) {
            return;
        }
        super.onFormResubmission(webView, message, message2);
    }

    @Override // com.google.android.gms.internal.ads.zzbqm, android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        if (d()) {
            return;
        }
        super.onLoadResource(webView, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbqm, android.webkit.WebViewClient
    public final void onPageCommitVisible(WebView webView, String str) {
        if (d()) {
            return;
        }
        super.onPageCommitVisible(webView, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbqm, android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        if (d()) {
            return;
        }
        c();
        super.onPageFinished(webView, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbqm, android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (d()) {
            return;
        }
        c();
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // com.google.android.gms.internal.ads.zzbqm, android.webkit.WebViewClient
    public final void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        if (d()) {
            return;
        }
        super.onReceivedClientCertRequest(webView, clientCertRequest);
    }

    @Override // com.google.android.gms.internal.ads.zzbqm, android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i3, String str, String str2) {
        if (d()) {
            return;
        }
        super.onReceivedError(webView, i3, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbqm, android.webkit.WebViewClient
    public final void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        if (d()) {
            return;
        }
        super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbqm, android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        if (d()) {
            return;
        }
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }

    @Override // com.google.android.gms.internal.ads.zzbqm, android.webkit.WebViewClient
    public final void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        if (d()) {
            return;
        }
        super.onReceivedLoginRequest(webView, str, str2, str3);
    }

    @Override // com.google.android.gms.internal.ads.zzbqm, android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (d()) {
            return;
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @Override // com.google.android.gms.internal.ads.zzbqm, android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (!d()) {
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
        synchronized (this.f70730c) {
            try {
                WebView webView2 = this.f70733f;
                if (webView2 != null) {
                    webView2.setWebViewClient(new WebViewClient());
                    this.f70733f = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Future future = this.f70731d;
        if (future == null) {
            return true;
        }
        future.cancel(false);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbqm, android.webkit.WebViewClient
    public final void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i3, SafeBrowsingResponse safeBrowsingResponse) {
        if (d()) {
            return;
        }
        super.onSafeBrowsingHit(webView, webResourceRequest, i3, safeBrowsingResponse);
    }

    @Override // com.google.android.gms.internal.ads.zzbqm, android.webkit.WebViewClient
    public final void onScaleChanged(WebView webView, float f3, float f4) {
        if (d()) {
            return;
        }
        super.onScaleChanged(webView, f3, f4);
    }

    @Override // com.google.android.gms.internal.ads.zzbqm, android.webkit.WebViewClient
    public final void onTooManyRedirects(WebView webView, Message message, Message message2) {
        if (d()) {
            return;
        }
        super.onTooManyRedirects(webView, message, message2);
    }

    @Override // com.google.android.gms.internal.ads.zzbqm, android.webkit.WebViewClient
    public final void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        if (d()) {
            return;
        }
        super.onUnhandledKeyEvent(webView, keyEvent);
    }

    @Override // com.google.android.gms.internal.ads.zzbqm, android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (d()) {
            return null;
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // com.google.android.gms.internal.ads.zzbqm, android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        if (d()) {
            return false;
        }
        return super.shouldOverrideKeyEvent(webView, keyEvent);
    }

    @Override // com.google.android.gms.internal.ads.zzbqm, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (d()) {
            return false;
        }
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    public final void zza() {
        this.f70731d = zzcfr.zzd.scheduleWithFixedDelay(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzd
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f70727a.a();
            }
        }, 0L, ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzlh)).intValue(), TimeUnit.MILLISECONDS);
    }

    @Override // com.google.android.gms.internal.ads.zzbqm, android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (d()) {
            return;
        }
        super.onReceivedError(webView, webResourceRequest, webResourceError);
    }

    @Override // com.google.android.gms.internal.ads.zzbqm, android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (d()) {
            return null;
        }
        return super.shouldInterceptRequest(webView, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbqm, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (d()) {
            return false;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
