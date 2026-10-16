package com.applovin.impl;

import android.view.View;
import android.webkit.WebView;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdkUtils;
import com.iab.omid.library.applovin.adsession.AdEvents;
import com.iab.omid.library.applovin.adsession.AdSession;
import com.iab.omid.library.applovin.adsession.AdSessionConfiguration;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.ErrorType;
import com.revenuecat.purchases.common.Constants;
import io.reactivex.internal.operators.mixed.yrog.FptyjHFU;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class lg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final AppLovinAdBase f61214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.applovin.impl.sdk.j f61215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.applovin.impl.sdk.n f61216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final String f61217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected boolean f61218e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected AdSession f61219f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected AdEvents f61220g;

    public lg(AppLovinAdBase appLovinAdBase) {
        this.f61214a = appLovinAdBase;
        this.f61215b = appLovinAdBase.getSdk();
        this.f61216c = appLovinAdBase.getSdk().I();
        String str = "AdEventTracker:" + appLovinAdBase.getAdIdNumber();
        if (StringUtils.isValidString(appLovinAdBase.getDspName())) {
            str = str + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + appLovinAdBase.getDspName();
        }
        this.f61217d = str;
    }

    protected abstract AdSessionConfiguration a();

    protected abstract AdSessionContext a(WebView webView);

    public void h() {
        b("track loaded", new Runnable() { // from class: com.applovin.impl.fz
            @Override // java.lang.Runnable
            public final void run() {
                this.f59840a.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(WebView webView) {
        AdSessionContext adSessionContextA;
        if (!this.f61214a.isOpenMeasurementEnabled()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f61216c.d(this.f61217d, "Skip starting session - Open Measurement disabled");
                return;
            }
            return;
        }
        if (this.f61219f != null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f61216c.k(this.f61217d, "Attempting to start session again for ad: " + this.f61214a);
                return;
            }
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f61216c.a(this.f61217d, "Starting session");
        }
        AdSessionConfiguration adSessionConfigurationA = a();
        if (adSessionConfigurationA == null || (adSessionContextA = a(webView)) == null) {
            return;
        }
        try {
            AdSession adSessionCreateAdSession = AdSession.createAdSession(adSessionConfigurationA, adSessionContextA);
            this.f61219f = adSessionCreateAdSession;
            try {
                this.f61220g = AdEvents.createAdEvents(adSessionCreateAdSession);
                a(this.f61219f);
                this.f61219f.start();
                this.f61218e = true;
                if (com.applovin.impl.sdk.n.a()) {
                    this.f61216c.a(this.f61217d, FptyjHFU.dkwG);
                }
            } catch (Throwable th) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f61216c.a(this.f61217d, "Failed to create ad events", th);
                }
            }
        } catch (Throwable th2) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f61216c.a(this.f61217d, "Failed to create session", th2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        this.f61220g.impressionOccurred();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        this.f61220g.loaded();
    }

    protected void a(AdSession adSession) {
    }

    public void e() {
        c((WebView) null);
    }

    public void f() {
        b("stop session", new Runnable() { // from class: com.applovin.impl.hz
            @Override // java.lang.Runnable
            public final void run() {
                this.f60267a.b();
            }
        });
    }

    public void g() {
        b("track impression event", new Runnable() { // from class: com.applovin.impl.iz
            @Override // java.lang.Runnable
            public final void run() {
                this.f60545a.c();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, Runnable runnable) {
        try {
            if (this.f61218e) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f61216c.a(this.f61217d, "Running operation: " + str);
                }
                runnable.run();
            }
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f61216c.a(this.f61217d, "Failed to run operation: " + str, th);
            }
        }
    }

    public void c(final WebView webView) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.kz
            @Override // java.lang.Runnable
            public final void run() {
                this.f61071a.b(webView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        this.f61219f.error(ErrorType.VIDEO, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view, List list) {
        this.f61219f.registerAdView(view);
        this.f61219f.removeAllFriendlyObstructions();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ng ngVar = (ng) it.next();
            if (ngVar.c() != null) {
                try {
                    this.f61219f.addFriendlyObstruction(ngVar.c(), ngVar.b(), ngVar.a());
                } catch (Throwable th) {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f61216c.a(this.f61217d, "Failed to add friendly obstruction (" + ngVar + ")", th);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        this.f61218e = false;
        this.f61219f.finish();
        this.f61219f = null;
        this.f61220g = null;
    }

    public void a(View view) {
        b(view, Collections.EMPTY_LIST);
    }

    protected void b(final String str, final Runnable runnable) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.ez
            @Override // java.lang.Runnable
            public final void run() {
                this.f59561a.a(str, runnable);
            }
        });
    }

    public void b(final String str) {
        b("track error", new Runnable() { // from class: com.applovin.impl.gz
            @Override // java.lang.Runnable
            public final void run() {
                this.f60067a.a(str);
            }
        });
    }

    public void b(final View view, final List list) {
        b("update main view: " + view, new Runnable() { // from class: com.applovin.impl.jz
            @Override // java.lang.Runnable
            public final void run() {
                this.f60827a.a(view, list);
            }
        });
    }
}
