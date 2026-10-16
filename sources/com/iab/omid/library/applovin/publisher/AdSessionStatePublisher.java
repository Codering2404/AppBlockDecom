package com.iab.omid.library.applovin.publisher;

import android.webkit.WebView;
import com.iab.omid.library.applovin.adsession.AdEvents;
import com.iab.omid.library.applovin.adsession.AdSessionConfiguration;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.ErrorType;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import com.iab.omid.library.applovin.adsession.media.MediaEvents;
import com.iab.omid.library.applovin.internal.g;
import com.iab.omid.library.applovin.internal.h;
import com.iab.omid.library.applovin.utils.c;
import com.iab.omid.library.applovin.utils.f;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AdSessionStatePublisher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f92168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.iab.omid.library.applovin.weakreference.b f92169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AdEvents f92170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MediaEvents f92171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f92172e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f92173f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public AdSessionStatePublisher(String str) {
        a();
        this.f92168a = str;
        this.f92169b = new com.iab.omid.library.applovin.weakreference.b(null);
    }

    public void a() {
        this.f92173f = f.b();
        this.f92172e = a.AD_STATE_IDLE;
    }

    public void b() {
        this.f92169b.clear();
    }

    public AdEvents c() {
        return this.f92170c;
    }

    public MediaEvents d() {
        return this.f92171d;
    }

    public boolean e() {
        return this.f92169b.get() != null;
    }

    public void f() {
        h.a().a(getWebView(), this.f92168a);
    }

    public void g() {
        h.a().b(getWebView(), this.f92168a);
    }

    public WebView getWebView() {
        return this.f92169b.get();
    }

    public void h() {
        a((JSONObject) null);
    }

    public void a(float f3) {
        h.a().a(getWebView(), this.f92168a, f3);
    }

    public void b(String str, long j3) {
        if (j3 >= this.f92173f) {
            this.f92172e = a.AD_STATE_VISIBLE;
            h.a().a(getWebView(), this.f92168a, str);
        }
    }

    void a(WebView webView) {
        this.f92169b = new com.iab.omid.library.applovin.weakreference.b(webView);
    }

    public void a(AdEvents adEvents) {
        this.f92170c = adEvents;
    }

    public void a(AdSessionConfiguration adSessionConfiguration) {
        h.a().a(getWebView(), this.f92168a, adSessionConfiguration.toJsonObject());
    }

    public void a(ErrorType errorType, String str) {
        h.a().a(getWebView(), this.f92168a, errorType, str);
    }

    public void a(com.iab.omid.library.applovin.adsession.a aVar, AdSessionContext adSessionContext) {
        a(aVar, adSessionContext, null);
    }

    protected void a(com.iab.omid.library.applovin.adsession.a aVar, AdSessionContext adSessionContext, JSONObject jSONObject) {
        String adSessionId = aVar.getAdSessionId();
        JSONObject jSONObject2 = new JSONObject();
        c.a(jSONObject2, "environment", "app");
        c.a(jSONObject2, "adSessionType", adSessionContext.getAdSessionContextType());
        c.a(jSONObject2, "deviceInfo", com.iab.omid.library.applovin.utils.b.d());
        c.a(jSONObject2, "deviceCategory", com.iab.omid.library.applovin.utils.a.a().toString());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        c.a(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        c.a(jSONObject3, "partnerName", adSessionContext.getPartner().getName());
        c.a(jSONObject3, "partnerVersion", adSessionContext.getPartner().getVersion());
        c.a(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        c.a(jSONObject4, "libraryVersion", "1.4.12-Applovin");
        c.a(jSONObject4, "appId", g.b().a().getApplicationContext().getPackageName());
        c.a(jSONObject2, "app", jSONObject4);
        if (adSessionContext.getContentUrl() != null) {
            c.a(jSONObject2, "contentUrl", adSessionContext.getContentUrl());
        }
        if (adSessionContext.getCustomReferenceData() != null) {
            c.a(jSONObject2, "customReferenceData", adSessionContext.getCustomReferenceData());
        }
        JSONObject jSONObject5 = new JSONObject();
        for (VerificationScriptResource verificationScriptResource : adSessionContext.getVerificationScriptResources()) {
            c.a(jSONObject5, verificationScriptResource.getVendorKey(), verificationScriptResource.getVerificationParameters());
        }
        h.a().a(getWebView(), adSessionId, jSONObject2, jSONObject5, jSONObject);
    }

    public void a(MediaEvents mediaEvents) {
        this.f92171d = mediaEvents;
    }

    public void a(String str) {
        a(str, (JSONObject) null);
    }

    public void a(String str, long j3) {
        if (j3 >= this.f92173f) {
            a aVar = this.f92172e;
            a aVar2 = a.AD_STATE_NOTVISIBLE;
            if (aVar != aVar2) {
                this.f92172e = aVar2;
                h.a().a(getWebView(), this.f92168a, str);
            }
        }
    }

    public void a(String str, JSONObject jSONObject) {
        h.a().a(getWebView(), this.f92168a, str, jSONObject);
    }

    public void a(Date date) {
        if (date == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        c.a(jSONObject, "timestamp", Long.valueOf(date.getTime()));
        h.a().a(getWebView(), jSONObject);
    }

    public void a(JSONObject jSONObject) {
        h.a().b(getWebView(), this.f92168a, jSONObject);
    }

    public void i() {
    }

    public void a(boolean z2) {
        if (e()) {
            h.a().b(getWebView(), this.f92168a, z2 ? "foregrounded" : "backgrounded");
        }
    }
}
