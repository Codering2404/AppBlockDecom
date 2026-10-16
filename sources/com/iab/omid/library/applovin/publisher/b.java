package com.iab.omid.library.applovin.publisher;

import android.os.Handler;
import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import com.iab.omid.library.applovin.internal.g;
import com.iab.omid.library.applovin.internal.h;
import com.iab.omid.library.applovin.utils.c;
import com.iab.omid.library.applovin.utils.f;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class b extends AdSessionStatePublisher {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private WebView f92178g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Long f92179h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<String, VerificationScriptResource> f92180i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f92181j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends WebViewClient {
        a() {
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Log.w("NativeBridge", "WebView renderer gone: " + renderProcessGoneDetail.toString() + "for WebView: " + webView);
            if (b.this.getWebView() == webView) {
                Log.w("NativeBridge", "Deallocating the Native bridge as it is unusable. No further events will be generated for this session.");
                b.this.a((WebView) null);
            }
            webView.destroy();
            return true;
        }
    }

    /* JADX INFO: renamed from: com.iab.omid.library.applovin.publisher.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class RunnableC0170b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WebView f92183a;

        RunnableC0170b() {
            this.f92183a = b.this.f92178g;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f92183a.destroy();
        }
    }

    public b(String str, Map<String, VerificationScriptResource> map, String str2) {
        super(str);
        this.f92179h = null;
        this.f92180i = map;
        this.f92181j = str2;
    }

    @Override // com.iab.omid.library.applovin.publisher.AdSessionStatePublisher
    public void b() {
        super.b();
        new Handler().postDelayed(new RunnableC0170b(), Math.max(4000 - (this.f92179h == null ? 4000L : TimeUnit.MILLISECONDS.convert(f.b() - this.f92179h.longValue(), TimeUnit.NANOSECONDS)), 2000L));
        this.f92178g = null;
    }

    @Override // com.iab.omid.library.applovin.publisher.AdSessionStatePublisher
    public void i() {
        super.i();
        j();
    }

    void j() {
        WebView webView = new WebView(g.b().a());
        this.f92178g = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.f92178g.getSettings().setAllowContentAccess(false);
        this.f92178g.getSettings().setAllowFileAccess(false);
        this.f92178g.setWebViewClient(new a());
        a(this.f92178g);
        h.a().c(this.f92178g, this.f92181j);
        for (String str : this.f92180i.keySet()) {
            h.a().c(this.f92178g, this.f92180i.get(str).getResourceUrl().toExternalForm(), str);
        }
        this.f92179h = Long.valueOf(f.b());
    }

    @Override // com.iab.omid.library.applovin.publisher.AdSessionStatePublisher
    public void a(com.iab.omid.library.applovin.adsession.a aVar, AdSessionContext adSessionContext) {
        JSONObject jSONObject = new JSONObject();
        Map<String, VerificationScriptResource> injectedResourcesMap = adSessionContext.getInjectedResourcesMap();
        for (String str : injectedResourcesMap.keySet()) {
            c.a(jSONObject, str, injectedResourcesMap.get(str).toJsonObject());
        }
        a(aVar, adSessionContext, jSONObject);
    }
}
