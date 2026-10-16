package com.applovin.impl.adview;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import com.applovin.impl.aq;
import com.applovin.impl.dq;
import com.applovin.impl.iq;
import com.applovin.impl.j3;
import com.applovin.impl.pi;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sj;
import com.applovin.impl.tr;
import com.applovin.impl.yp;
import com.applovin.impl.z3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class b extends j3 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f58319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f58320d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.applovin.impl.sdk.ad.b f58321f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f58322g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f58323h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f58324i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Object f58325j;

    public b(com.applovin.impl.sdk.j jVar, Context context) {
        super(context);
        this.f58324i = new ArrayList();
        this.f58325j = new Object();
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        this.f58320d = jVar;
        this.f58319c = jVar.I();
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setSupportMultipleWindows(false);
        settings.setJavaScriptEnabled(true);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setScrollBarStyle(33554432);
        if (z3.k() && ((Boolean) jVar.a(sj.K5)).booleanValue()) {
            setWebViewRenderProcessClient(new d(jVar).a());
        }
        setOnTouchListener(new View.OnTouchListener() { // from class: com.applovin.impl.adview.f0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return b.a(view, motionEvent);
            }
        });
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.applovin.impl.adview.g0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f58353a.a(view);
            }
        });
    }

    private void a(String str, String str2, String str3, com.applovin.impl.sdk.j jVar, aq aqVar) {
        String strA = a(str3, str);
        if (StringUtils.isValidString(strA)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f58319c.a("AdWebView", "Rendering webview for VAST ad with resourceContents : " + strA);
            }
            loadDataWithBaseURL(str2, strA, "text/html", null, "");
            return;
        }
        String strA2 = a((String) jVar.a(sj.E4), str);
        if (!StringUtils.isValidString(strA2)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f58319c.a("AdWebView", "Rendering webview for VAST ad with resourceURL : " + str);
            }
            loadUrl(str);
            return;
        }
        if (aqVar.D1() && aqVar.isOpenMeasurementEnabled()) {
            strA2 = jVar.V().a(strA2);
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f58319c.a("AdWebView", "Rendering webview for VAST ad with resourceContents : " + strA2);
        }
        loadDataWithBaseURL(str2, strA2, "text/html", null, "");
    }

    @Override // android.webkit.WebView
    public void destroy() {
        this.f58322g = true;
        this.f58323h = false;
        super.destroy();
    }

    com.applovin.impl.sdk.ad.b getCurrentAd() {
        return this.f58321f;
    }

    public void setAdHtmlLoaded(boolean z2) {
        this.f58323h = z2;
        if (z2 && ((Boolean) this.f58320d.a(sj.e6)).booleanValue()) {
            b();
        }
    }

    private void b() {
        synchronized (this.f58325j) {
            try {
                Iterator it = this.f58324i.iterator();
                while (it.hasNext()) {
                    tr.a(this, (String) it.next(), "AdWebView", this.f58320d);
                }
                this.f58324i.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        if (view.hasFocus()) {
            return false;
        }
        view.requestFocus();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(View view) {
        if (!com.applovin.impl.sdk.n.a()) {
            return true;
        }
        this.f58319c.a("AdWebView", "Received a LongClick event.");
        return true;
    }

    public void a(c cVar) {
        if (((Boolean) this.f58320d.a(sj.f63793t1)).booleanValue()) {
            loadUrl("about:blank");
            clearView();
        }
        setWebViewClient(cVar != null ? cVar : new pi());
        setWebChromeClient(new com.applovin.impl.f0(cVar != null ? cVar.c() : null, this.f58320d));
        synchronized (this.f58324i) {
            this.f58324i.clear();
        }
        onResume();
    }

    @Override // android.webkit.WebView, android.view.View
    public void computeScroll() {
    }

    public void a(com.applovin.impl.sdk.ad.b bVar) {
        String string;
        if (!this.f58322g) {
            this.f58321f = bVar;
            try {
                applySettings(bVar);
                if (yp.a(bVar.getSize())) {
                    setVisibility(0);
                }
                try {
                    if (bVar instanceof com.applovin.impl.sdk.ad.a) {
                        try {
                            loadDataWithBaseURL(bVar.h(), ((com.applovin.impl.sdk.ad.a) bVar).l1(), "text/html", null, "");
                            if (com.applovin.impl.sdk.n.a()) {
                                this.f58319c.a("AdWebView", "AppLovinAd rendered");
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            th = th;
                        }
                    } else {
                        if (bVar instanceof aq) {
                            aq aqVar = (aq) bVar;
                            dq dqVarL1 = aqVar.l1();
                            if (dqVarL1 != null) {
                                iq iqVarE = dqVarL1.e();
                                Uri uriC = iqVarE.c();
                                if (uriC != null) {
                                    string = uriC.toString();
                                } else {
                                    string = "";
                                }
                                String str = string;
                                String strB = iqVarE.b();
                                String strN1 = aqVar.n1();
                                if (!StringUtils.isValidString(str) && !StringUtils.isValidString(strB)) {
                                    if (com.applovin.impl.sdk.n.a()) {
                                        this.f58319c.b("AdWebView", "Unable to load companion ad. No resources provided.");
                                        return;
                                    }
                                    return;
                                }
                                if (iqVarE.d() == iq.a.STATIC) {
                                    if (com.applovin.impl.sdk.n.a()) {
                                        this.f58319c.a("AdWebView", "Rendering WebView for static VAST ad");
                                    }
                                    String strA = a((String) this.f58320d.a(sj.D4), str);
                                    if (aqVar.D1() && aqVar.isOpenMeasurementEnabled() && aqVar.E1()) {
                                        strA = this.f58320d.V().a(strA);
                                    }
                                    loadDataWithBaseURL(bVar.h(), strA, "text/html", null, "");
                                    return;
                                }
                                if (iqVarE.d() == iq.a.HTML) {
                                    if (StringUtils.isValidString(strB)) {
                                        String strA2 = a(strN1, strB);
                                        String str2 = StringUtils.isValidString(strA2) ? strA2 : strB;
                                        if (com.applovin.impl.sdk.n.a()) {
                                            this.f58319c.a("AdWebView", "Rendering WebView for HTML VAST ad with resourceContents: " + str2);
                                        }
                                        loadDataWithBaseURL(bVar.h(), str2, "text/html", null, "");
                                        return;
                                    }
                                    if (StringUtils.isValidString(str)) {
                                        if (com.applovin.impl.sdk.n.a()) {
                                            this.f58319c.a("AdWebView", "Preparing to load HTML VAST ad resourceUri");
                                        }
                                        a(str, bVar.h(), strN1, this.f58320d, aqVar);
                                        return;
                                    }
                                    return;
                                }
                                if (iqVarE.d() == iq.a.IFRAME) {
                                    if (StringUtils.isValidString(str)) {
                                        if (com.applovin.impl.sdk.n.a()) {
                                            this.f58319c.a("AdWebView", "Preparing to load iFrame VAST ad resourceUri");
                                        }
                                        a(str, bVar.h(), strN1, this.f58320d, aqVar);
                                        return;
                                    } else {
                                        if (StringUtils.isValidString(strB)) {
                                            String strA3 = a(strN1, strB);
                                            String str3 = StringUtils.isValidString(strA3) ? strA3 : strB;
                                            if (com.applovin.impl.sdk.n.a()) {
                                                this.f58319c.a("AdWebView", "Rendering WebView for iFrame VAST ad with resourceContents: " + str3);
                                            }
                                            loadDataWithBaseURL(bVar.h(), str3, "text/html", null, "");
                                            return;
                                        }
                                        return;
                                    }
                                }
                                if (com.applovin.impl.sdk.n.a()) {
                                    this.f58319c.b("AdWebView", "Failed to render VAST companion ad of invalid type");
                                    return;
                                }
                                return;
                            }
                            if (com.applovin.impl.sdk.n.a()) {
                                this.f58319c.a("AdWebView", "No companion ad provided.");
                                return;
                            }
                            return;
                        }
                        return;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
            throw new RuntimeException("Unable to render AppLovin ad (" + (bVar != null ? String.valueOf(bVar.getAdIdNumber()) : "null") + ") - " + th);
        }
        com.applovin.impl.sdk.n.h("AdWebView", "Ad can not be loaded in a destroyed webview");
    }

    @Override // android.view.View
    public void scrollTo(int i3, int i4) {
    }

    public void a(String str) {
        if (((Boolean) this.f58320d.a(sj.e6)).booleanValue()) {
            if (this.f58323h) {
                tr.a(this, str, "AdWebView", this.f58320d);
                return;
            }
            synchronized (this.f58324i) {
                this.f58324i.add(str);
            }
            return;
        }
        tr.a(this, str, "AdWebView", this.f58320d);
    }

    private String a(String str, String str2) {
        if (StringUtils.isValidString(str)) {
            return str.replace("{SOURCE}", str2);
        }
        return null;
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i3, int i4, int i5, int i6) {
    }
}
