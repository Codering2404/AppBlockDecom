package com.applovin.impl.adview;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.browser.customtabs.CustomTabsSession;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.adview.k;
import com.applovin.impl.ba;
import com.applovin.impl.da;
import com.applovin.impl.fc;
import com.applovin.impl.jn;
import com.applovin.impl.ka;
import com.applovin.impl.lg;
import com.applovin.impl.ng;
import com.applovin.impl.pb;
import com.applovin.impl.pc;
import com.applovin.impl.pi;
import com.applovin.impl.s6;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.ad.b;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sj;
import com.applovin.impl.tm;
import com.applovin.impl.tr;
import com.applovin.impl.ub;
import com.applovin.impl.yp;
import com.applovin.impl.zq;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.stetho.common.Utf8Charset;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class a implements AppLovinCommunicatorSubscriber {
    private static final AtomicReference H = new AtomicReference();
    private volatile AppLovinAdLoadListener C;
    private volatile AppLovinAdDisplayListener D;
    private volatile AppLovinAdViewEventListener E;
    private volatile AppLovinAdClickListener F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f58267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ViewGroup f58268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.applovin.impl.sdk.j f58269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AppLovinAdServiceImpl f58270d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.applovin.impl.sdk.n f58271f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AppLovinCommunicator f58272g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private b f58273h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private AppLovinAdSize f58275j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f58276k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private CustomTabsSession f58277l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private com.applovin.impl.adview.c f58278m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private e f58279n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private com.applovin.impl.adview.b f58280o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private WebView f58281p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private k f58282q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Runnable f58283r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Runnable f58284s;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map f58274i = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private volatile com.applovin.impl.sdk.ad.b f58285t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private volatile AppLovinAd f58286u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private f f58287v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private f f58288w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final AtomicReference f58289x = new AtomicReference();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final AtomicBoolean f58290y = new AtomicBoolean();

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private volatile boolean f58291z = false;
    private volatile boolean A = false;
    private volatile boolean B = false;
    private volatile com.applovin.impl.g0 G = null;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface b {
        void a(a aVar);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class c implements Runnable {
        private c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f58280o != null) {
                a.this.f58280o.setVisibility(8);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class d implements Runnable {

        /* JADX INFO: renamed from: com.applovin.impl.adview.a$d$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class C0099a implements k.a {
            C0099a() {
            }

            @Override // com.applovin.impl.adview.k.a
            public void a() {
                a.this.f58280o.addView(a.this.f58282q, new ViewGroup.LayoutParams(-1, -1));
            }

            @Override // com.applovin.impl.adview.k.a
            public void onFailure() {
                com.applovin.impl.sdk.n unused = a.this.f58271f;
                if (com.applovin.impl.sdk.n.a()) {
                    a.this.f58271f.b("AppLovinAdView", "Watermark failed to render.");
                }
            }
        }

        private d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f58285t != null) {
                if (a.this.f58280o == null) {
                    com.applovin.impl.sdk.n.h("AppLovinAdView", "Unable to render advertisement for ad #" + a.this.f58285t.getAdIdNumber() + ". Please make sure you are not calling AppLovinAdView.destroy() prematurely.");
                    fc.a(a.this.E, a.this.f58285t, (AppLovinAdView) null, AppLovinAdViewDisplayErrorCode.WEBVIEW_NOT_FOUND);
                    return;
                }
                a.this.w();
                com.applovin.impl.sdk.n unused = a.this.f58271f;
                if (com.applovin.impl.sdk.n.a()) {
                    a.this.f58271f.a("AppLovinAdView", "Rendering advertisement ad for #" + a.this.f58285t.getAdIdNumber() + "...");
                }
                a.b(a.this.f58280o, a.this.f58285t.getSize());
                if (a.this.f58282q != null) {
                    zq.c(a.this.f58282q);
                    a.this.f58282q = null;
                }
                da daVar = new da(a.this.f58274i, a.this.f58269c);
                if (daVar.c()) {
                    a.this.f58282q = new k(daVar, a.this.f58267a);
                    a.this.f58282q.a(new C0099a());
                }
                a.this.f58280o.setAdHtmlLoaded(false);
                a.this.f58280o.a(a.this.f58285t);
                if (a.this.f58285t.getSize() == AppLovinAdSize.INTERSTITIAL || a.this.A) {
                    return;
                }
                a.this.f58285t.setHasShown(true);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class e implements AppLovinAdLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f58295a;

        e(a aVar, com.applovin.impl.sdk.j jVar) {
            if (aVar == null) {
                throw new IllegalArgumentException("No view specified");
            }
            if (jVar == null) {
                throw new IllegalArgumentException("No sdk specified");
            }
            this.f58295a = aVar;
        }

        private a a() {
            return this.f58295a;
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void adReceived(AppLovinAd appLovinAd) {
            a aVarA = a();
            if (aVarA != null) {
                aVarA.b(appLovinAd);
            } else {
                com.applovin.impl.sdk.n.h("AppLovinAdView", "Ad view has been garbage collected by the time an ad was received");
            }
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void failedToReceiveAd(int i3) {
            a aVarA = a();
            if (aVarA != null) {
                aVarA.b(i3);
            }
        }
    }

    private void G() {
        com.applovin.impl.adview.b bVar;
        if (this.f58271f != null && com.applovin.impl.sdk.n.a() && com.applovin.impl.sdk.n.a()) {
            this.f58271f.a("AppLovinAdView", "Destroying...");
        }
        if (!((Boolean) this.f58269c.a(sj.f63796u1)).booleanValue() || (bVar = this.f58280o) == null) {
            tr.d(this.f58280o);
        } else {
            tr.a(bVar);
            f().a(this.f58280o, new ub.b() { // from class: com.applovin.impl.adview.r
                @Override // com.applovin.impl.ub.b
                public final void a(Object obj) {
                    tr.d((b) obj);
                }
            });
        }
        this.f58280o = null;
        tr.d(this.f58281p);
        this.f58281p = null;
        this.f58277l = null;
        this.C = null;
        this.D = null;
        this.F = null;
        this.E = null;
        this.A = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        com.applovin.impl.sdk.ad.b bVar = this.f58285t;
        pc pcVar = new pc();
        pcVar.a().a(bVar).a(k());
        if (!yp.a(bVar.getSize())) {
            pcVar.a().a("Fullscreen Ad Properties").b(bVar);
        }
        pcVar.a(this.f58269c);
        pcVar.a();
        if (com.applovin.impl.sdk.n.a()) {
            this.f58271f.a("AppLovinAdView", pcVar.toString());
        }
    }

    private void y() {
        if (this.f58285t.X0()) {
            int iA = this.f58269c.o().a();
            if (com.applovin.impl.sdk.h.a(iA)) {
                this.f58280o.a("javascript:al_muteSwitchOn();");
            } else if (iA == 2) {
                this.f58280o.a("javascript:al_muteSwitchOff();");
            }
        }
    }

    public void A() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f58271f.a("AppLovinAdView", "AdView fully watched...");
        }
        b bVar = this.f58273h;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public void B() {
        if (com.applovin.impl.e0.a(this.f58280o)) {
            this.f58269c.C().c(ba.f58620r);
        }
    }

    public void C() {
        if (this.f58291z) {
            fc.b(this.D, this.f58285t);
            if (this.f58285t != null && this.f58285t.isOpenMeasurementEnabled() && yp.a(this.f58285t.getSize())) {
                this.f58285t.getAdEventTracker().f();
            }
            if (this.f58280o == null || this.f58287v == null) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f58271f.a("AppLovinAdView", "onDetachedFromWindowCalled without an expanded ad present");
                }
            } else {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f58271f.a("AppLovinAdView", "onDetachedFromWindowCalled with expanded ad present");
                }
                c();
            }
        }
    }

    public void D() {
        this.B = true;
    }

    public void E() {
        this.B = false;
    }

    public void F() {
        if (!this.f58291z || this.A) {
            return;
        }
        this.A = true;
    }

    public void H() {
        if (this.f58291z) {
            AppLovinAd appLovinAd = (AppLovinAd) this.f58289x.getAndSet(null);
            if (appLovinAd != null) {
                c(appLovinAd);
            }
            this.A = false;
        }
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return a.class.getSimpleName();
    }

    public com.applovin.impl.g0 h() {
        return this.G;
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("crash_applovin_ad_webview".equals(appLovinCommunicatorMessage.getTopic())) {
            a(new Runnable() { // from class: com.applovin.impl.adview.z
                @Override // java.lang.Runnable
                public final void run() {
                    this.f58384a.u();
                }
            });
        }
    }

    public void x() {
        if ((this.f58267a instanceof s6) && this.f58285t != null && this.f58285t.S() == b.EnumC0122b.DISMISS) {
            ((s6) this.f58267a).dismiss();
        }
    }

    public void z() {
        if (this.f58287v != null || this.f58288w != null) {
            a();
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f58271f.a("AppLovinAdView", "Ad: " + this.f58285t + " closed.");
        }
        a(this.f58284s);
        fc.b(this.D, this.f58285t);
        this.f58285t = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(View view, AppLovinAdSize appLovinAdSize) {
        if (view == null) {
            return;
        }
        DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
        String label = appLovinAdSize.getLabel();
        AppLovinAdSize appLovinAdSize2 = AppLovinAdSize.INTERSTITIAL;
        int iApplyDimension = label.equals(appLovinAdSize2.getLabel()) ? -1 : appLovinAdSize.getWidth() == -1 ? displayMetrics.widthPixels : (int) TypedValue.applyDimension(1, appLovinAdSize.getWidth(), displayMetrics);
        int iApplyDimension2 = appLovinAdSize.getLabel().equals(appLovinAdSize2.getLabel()) ? -1 : appLovinAdSize.getHeight() == -1 ? displayMetrics.heightPixels : (int) TypedValue.applyDimension(1, appLovinAdSize.getHeight(), displayMetrics);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        layoutParams.width = iApplyDimension;
        layoutParams.height = iApplyDimension2;
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(13);
        }
        view.setLayoutParams(layoutParams);
    }

    private void c() {
        a(new Runnable() { // from class: com.applovin.impl.adview.w
            @Override // java.lang.Runnable
            public final void run() {
                this.f58380a.s();
            }
        });
    }

    public static ub f() {
        AtomicReference atomicReference = H;
        Object dVar = atomicReference.get();
        if (dVar == null) {
            synchronized (atomicReference) {
                try {
                    dVar = atomicReference.get();
                    if (dVar == null) {
                        dVar = new ub.d();
                        atomicReference.set(dVar);
                    }
                } finally {
                }
            }
        }
        if (dVar == atomicReference) {
            dVar = null;
        }
        return (ub) dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ com.applovin.impl.adview.b o() {
        return new com.applovin.impl.adview.b(this.f58269c, this.f58267a.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p() {
        this.f58280o.loadDataWithBaseURL("/", "<html></html>", "text/html", null, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q() {
        com.applovin.impl.adview.b bVar;
        d();
        if (this.f58268b == null || (bVar = this.f58280o) == null || bVar.getParent() != null) {
            return;
        }
        this.f58268b.addView(this.f58280o);
        b(this.f58280o, this.f58285t.getSize());
        if (this.f58285t.isOpenMeasurementEnabled()) {
            this.f58285t.getAdEventTracker().a((View) this.f58280o);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r() {
        if (this.f58280o != null && this.f58287v != null) {
            a();
        }
        G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s() {
        if (this.f58287v != null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f58271f.a("AppLovinAdView", "Detaching expanded ad: " + this.f58287v.b());
            }
            this.f58288w = this.f58287v;
            this.f58287v = null;
            a(this.f58275j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t() {
        com.applovin.impl.sdk.ad.a aVarB;
        f fVar = this.f58288w;
        if (fVar == null && this.f58287v == null) {
            return;
        }
        if (fVar != null) {
            aVarB = fVar.b();
            this.f58288w.dismiss();
            this.f58288w = null;
        } else {
            aVarB = this.f58287v.b();
            this.f58287v.dismiss();
            this.f58287v = null;
        }
        fc.a(this.E, aVarB, (AppLovinAdView) this.f58268b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u() {
        g().loadUrl("chrome://crash");
    }

    public void a(com.applovin.impl.g0 g0Var) {
        this.G = g0Var;
    }

    public AppLovinAdViewEventListener e() {
        return this.E;
    }

    public com.applovin.impl.adview.b g() {
        return this.f58280o;
    }

    public com.applovin.impl.sdk.ad.b i() {
        return this.f58285t;
    }

    public CustomTabsSession j() {
        return this.f58277l;
    }

    public AppLovinAdView k() {
        return (AppLovinAdView) this.f58268b;
    }

    public com.applovin.impl.sdk.j l() {
        return this.f58269c;
    }

    public AppLovinAdSize m() {
        return this.f58275j;
    }

    public String n() {
        return this.f58276k;
    }

    public void v() {
        if (this.f58269c == null || this.f58279n == null || this.f58267a == null || !this.f58291z) {
            com.applovin.impl.sdk.n.i("AppLovinAdView", "Unable to load next ad: AppLovinAdView is not initialized.");
        } else {
            this.f58270d.loadNextAd(this.f58276k, this.f58275j, this.f58279n);
        }
    }

    private void d() {
        a(new Runnable() { // from class: com.applovin.impl.adview.s
            @Override // java.lang.Runnable
            public final void run() {
                this.f58374a.t();
            }
        });
    }

    public void c(AppLovinAd appLovinAd) {
        a(appLovinAd, (String) null);
    }

    public void c(WebView webView) {
        a(webView, (String) null);
    }

    public void a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.C = appLovinAdLoadListener;
    }

    public void a(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.D = appLovinAdDisplayListener;
    }

    public void a(AppLovinAdViewEventListener appLovinAdViewEventListener) {
        this.E = appLovinAdViewEventListener;
    }

    public void a(AppLovinAdClickListener appLovinAdClickListener) {
        this.F = appLovinAdClickListener;
    }

    private void a(AppLovinAdView appLovinAdView, com.applovin.impl.sdk.j jVar, AppLovinAdSize appLovinAdSize, String str, Context context) {
        if (appLovinAdView == null) {
            throw new IllegalArgumentException("No parent view specified");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (appLovinAdSize != null) {
            this.f58269c = jVar;
            this.f58270d = jVar.j();
            this.f58271f = jVar.I();
            this.f58272g = AppLovinCommunicator.getInstance(context);
            this.f58275j = appLovinAdSize;
            this.f58276k = str;
            if (!(context instanceof AppLovinFullscreenActivity)) {
                context = context.getApplicationContext();
            }
            this.f58267a = context;
            this.f58268b = appLovinAdView;
            this.f58278m = new com.applovin.impl.adview.c(this, jVar);
            this.f58284s = new c();
            this.f58283r = new d();
            this.f58279n = new e(this, jVar);
            a(appLovinAdSize);
            return;
        }
        throw new IllegalArgumentException("No ad size specified");
    }

    public void b() {
        a(new Runnable() { // from class: com.applovin.impl.adview.x
            @Override // java.lang.Runnable
            public final void run() {
                this.f58381a.r();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(WebView webView) {
        this.f58285t.getAdEventTracker().c(webView);
        k kVar = this.f58282q;
        if (kVar != null && kVar.a()) {
            lg adEventTracker = this.f58285t.getAdEventTracker();
            k kVar2 = this.f58282q;
            adEventTracker.b(webView, Collections.singletonList(new ng(kVar2, FriendlyObstructionPurpose.NOT_VISIBLE, kVar2.getIdentifier())));
        } else {
            this.f58285t.getAdEventTracker().a((View) webView);
        }
        this.f58285t.getAdEventTracker().h();
        this.f58285t.getAdEventTracker().g();
    }

    protected void a(AppLovinAdSize appLovinAdSize) {
        try {
            if (((Boolean) this.f58269c.a(sj.f63796u1)).booleanValue()) {
                this.f58280o = (com.applovin.impl.adview.b) f().a(new ub.a() { // from class: com.applovin.impl.adview.c0
                    @Override // com.applovin.impl.ub.a
                    public final Object a() {
                        return this.f58330a.o();
                    }
                });
            } else {
                this.f58280o = new com.applovin.impl.adview.b(this.f58269c, this.f58267a);
            }
            this.f58280o.a(this.f58278m);
            this.f58280o.setBackgroundColor(0);
            this.f58280o.setWillNotCacheDrawing(false);
            this.f58268b.setBackgroundColor(0);
            this.f58268b.addView(this.f58280o);
            b(this.f58280o, appLovinAdSize);
            if (!this.f58291z) {
                a(this.f58284s);
            }
            a(new Runnable() { // from class: com.applovin.impl.adview.d0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f58334a.p();
                }
            });
            this.f58291z = true;
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("AppLovinAdView", "Failed to initialize AdWebView", th);
            this.f58269c.D().a("AppLovinAdView", "initAdWebView", th);
            this.f58290y.set(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(MotionEvent motionEvent) {
        a aVar;
        if (this.f58287v == null && (this.f58285t instanceof com.applovin.impl.sdk.ad.a) && this.f58280o != null) {
            com.applovin.impl.sdk.ad.a aVar2 = (com.applovin.impl.sdk.ad.a) this.f58285t;
            Context context = this.f58267a;
            Activity activityA = context instanceof Activity ? (Activity) context : zq.a(this.f58280o, this.f58269c);
            if (activityA != null && !activityA.isFinishing()) {
                ViewGroup viewGroup = this.f58268b;
                if (viewGroup != null) {
                    viewGroup.removeView(this.f58280o);
                }
                f fVar = new f(aVar2, this.f58280o, activityA, this.f58269c);
                this.f58287v = fVar;
                fVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.applovin.impl.adview.b0
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.f58326a.a(dialogInterface);
                    }
                });
                this.f58287v.show();
                fc.c(this.E, this.f58285t, (AppLovinAdView) this.f58268b);
                if (this.f58285t.isOpenMeasurementEnabled()) {
                    this.f58285t.getAdEventTracker().a((View) this.f58287v.c());
                    return;
                }
                return;
            }
            com.applovin.impl.sdk.n.h("AppLovinAdView", "Unable to expand ad. No Activity found.");
            Uri uriJ = aVar2.j();
            if (uriJ != null) {
                aVar = this;
                this.f58270d.trackAndLaunchClick(aVar2, k(), aVar, uriJ, motionEvent, this.B, null);
            } else {
                aVar = this;
            }
            aVar.f58280o.a("javascript:al_onFailedExpand();");
        }
    }

    public void a(AppLovinAdView appLovinAdView, Context context, AppLovinAdSize appLovinAdSize, String str, AppLovinSdk appLovinSdk, AttributeSet attributeSet) {
        if (appLovinAdView == null) {
            throw new IllegalArgumentException("No parent view specified");
        }
        if (context == null) {
            com.applovin.impl.sdk.n.h("AppLovinAdView", "Unable to build AppLovinAdView: no context provided. Please use a different constructor for this view.");
            return;
        }
        if (appLovinAdSize == null && (appLovinAdSize = com.applovin.impl.e0.a(attributeSet)) == null) {
            appLovinAdSize = AppLovinAdSize.BANNER;
        }
        AppLovinAdSize appLovinAdSize2 = appLovinAdSize;
        if (appLovinSdk == null) {
            appLovinSdk = AppLovinSdk.getInstance(context);
        }
        if (appLovinSdk != null) {
            a(appLovinAdView, appLovinSdk.a(), appLovinAdSize2, str, context);
            if (com.applovin.impl.e0.b(attributeSet)) {
                v();
            }
        }
    }

    void b(final AppLovinAd appLovinAd) {
        if (appLovinAd != null) {
            if (!this.A) {
                c(appLovinAd);
            } else {
                this.f58289x.set(appLovinAd);
                if (com.applovin.impl.sdk.n.a()) {
                    this.f58271f.a("AppLovinAdView", "Ad view has paused when an ad was received, ad saved for later");
                }
            }
            a(new Runnable() { // from class: com.applovin.impl.adview.q
                @Override // java.lang.Runnable
                public final void run() {
                    this.f58372a.a(appLovinAd);
                }
            });
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f58271f.b("AppLovinAdView", "No provided when to the view controller");
        }
        b(-1);
    }

    public void a(String str, Object obj) {
        this.f58274i.put(str, obj);
    }

    public void a(AppLovinAd appLovinAd, String str) {
        if (appLovinAd != null) {
            yp.b(appLovinAd, this.f58269c);
            if (this.f58291z) {
                com.applovin.impl.sdk.ad.b bVar = (com.applovin.impl.sdk.ad.b) yp.a(appLovinAd, this.f58269c);
                if (bVar == null) {
                    com.applovin.impl.sdk.n.h("AppLovinAdView", "Unable to retrieve the loaded ad: " + appLovinAd);
                    fc.a(this.D, "Unable to retrieve the loaded ad");
                    return;
                }
                if (bVar == this.f58285t) {
                    com.applovin.impl.sdk.n.h("AppLovinAdView", "Attempting to show ad again: " + bVar);
                    if (((Boolean) this.f58269c.a(sj.M1)).booleanValue()) {
                        if (this.D instanceof pb) {
                            fc.a(this.D, "Attempting to show ad again");
                            return;
                        }
                        throw new IllegalStateException("Attempting to show ad again");
                    }
                    return;
                }
                if (com.applovin.impl.sdk.n.a()) {
                    this.f58271f.a("AppLovinAdView", "Rendering ad #" + bVar.getAdIdNumber() + " (" + bVar.getSize() + ")");
                }
                fc.b(this.D, this.f58285t);
                if (this.f58285t != null && this.f58285t.isOpenMeasurementEnabled()) {
                    this.f58285t.getAdEventTracker().f();
                }
                this.f58289x.set(null);
                this.f58286u = null;
                this.f58285t = bVar;
                if (this.f58285t.C0()) {
                    this.f58277l = this.f58269c.w().a(this);
                    this.f58269c.w().b(this.f58285t.A(), this.f58277l);
                }
                if (!this.A && yp.a(this.f58275j)) {
                    this.f58269c.j().trackImpression(bVar);
                }
                if (this.f58287v != null) {
                    c();
                }
                a(this.f58283r);
                return;
            }
            com.applovin.impl.sdk.n.i("AppLovinAdView", "Unable to render ad: AppLovinAdView is not initialized.");
            return;
        }
        throw new IllegalArgumentException("No ad specified");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final int i3) {
        if (!this.A) {
            a(this.f58284s);
        }
        a(new Runnable() { // from class: com.applovin.impl.adview.y
            @Override // java.lang.Runnable
            public final void run() {
                this.f58382a.a(i3);
            }
        });
    }

    public void b(Uri uri) {
        if (this.f58285t != null && this.f58285t.E0() && this.f58281p == null) {
            String queryParameter = uri.getQueryParameter("tracking_id");
            if (TextUtils.isEmpty(queryParameter)) {
                this.f58269c.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f58269c.I().b("AppLovinAdView", "Invalid tracking id. Cannot initialize GA");
                    return;
                }
                return;
            }
            WebView webView = new WebView(this.f58267a);
            this.f58281p = webView;
            webView.setWebViewClient(new pi());
            this.f58281p.getSettings().setJavaScriptEnabled(true);
            this.f58281p.loadDataWithBaseURL((String) this.f58269c.a(sj.A6), "<html><head><link rel=\"icon\" href=\"data:,\"><G-SCRIPT_TAG></head><body></body></html>".replace("<G-SCRIPT_TAG>", "<script src='https://www.googletagmanager.com/gtag/js?id=<G-TRACKING_ID>'></script><script>window.dataLayer = window.dataLayer || [];function gtag(){dataLayer.push(arguments);}gtag('js', new Date());gtag('config', '<G-TRACKING_ID>')</script>".replace("<G-TRACKING_ID>", queryParameter)), "text/html", Utf8Charset.NAME, null);
        }
    }

    public void a(final WebView webView, String str) {
        if (this.f58285t == null) {
            return;
        }
        a(new Runnable() { // from class: com.applovin.impl.adview.p
            @Override // java.lang.Runnable
            public final void run() {
                webView.setVisibility(0);
            }
        });
        if (!((Boolean) this.f58269c.a(sj.e6)).booleanValue() || (str != null && str.startsWith(this.f58285t.h()))) {
            try {
                if (this.f58285t != this.f58286u) {
                    this.f58286u = this.f58285t;
                    y();
                    this.f58280o.setAdHtmlLoaded(true);
                    if (this.D != null) {
                        this.f58269c.v().d(this.f58285t);
                        this.f58269c.D().a(ka.f60958k, this.f58285t);
                        fc.a(this.D, this.f58285t);
                        this.f58280o.a("javascript:al_onAdViewRendered();");
                    }
                    if ((this.f58285t instanceof com.applovin.impl.sdk.ad.a) && this.f58285t.isOpenMeasurementEnabled()) {
                        this.f58269c.i0().a(new jn(this.f58269c, "StartOMSDK", new Runnable() { // from class: com.applovin.impl.adview.v
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f58378a.b(webView);
                            }
                        }), tm.b.OTHER, 500L);
                    }
                }
            } catch (Throwable th) {
                com.applovin.impl.sdk.n.c("AppLovinAdView", "Exception while notifying ad display listener", th);
                com.applovin.impl.sdk.j jVar = this.f58269c;
                if (jVar != null) {
                    jVar.D().a("AppLovinAdView", "onAdHtmlLoaded", th);
                }
            }
        }
    }

    public void a(final MotionEvent motionEvent) {
        a(new Runnable() { // from class: com.applovin.impl.adview.u
            @Override // java.lang.Runnable
            public final void run() {
                this.f58376a.b(motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        a();
    }

    public void a() {
        a(new Runnable() { // from class: com.applovin.impl.adview.t
            @Override // java.lang.Runnable
            public final void run() {
                this.f58375a.q();
            }
        });
    }

    public void a(com.applovin.impl.sdk.ad.b bVar, AppLovinAdView appLovinAdView, Uri uri, MotionEvent motionEvent, Bundle bundle) {
        a aVar;
        com.applovin.impl.sdk.ad.b bVar2;
        if (appLovinAdView != null) {
            aVar = this;
            bVar2 = bVar;
            this.f58270d.trackAndLaunchClick(bVar2, appLovinAdView, aVar, uri, motionEvent, this.B, bundle);
        } else {
            aVar = this;
            bVar2 = bVar;
            if (com.applovin.impl.sdk.n.a()) {
                aVar.f58271f.b("AppLovinAdView", "Unable to process ad click - AppLovinAdView destroyed prematurely");
            }
        }
        fc.a(aVar.F, bVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AppLovinAd appLovinAd) {
        if (this.f58290y.compareAndSet(true, false)) {
            a(this.f58275j);
        }
        try {
            if (this.C != null) {
                this.C.adReceived(appLovinAd);
            }
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.h("AppLovinAdView", "Exception while running ad load callback: " + th.getMessage());
            com.applovin.impl.sdk.j jVar = this.f58269c;
            if (jVar != null) {
                jVar.D().a("AppLovinAdView", "notifyAdLoaded", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i3) {
        try {
            if (this.C != null) {
                this.C.failedToReceiveAd(i3);
            }
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("AppLovinAdView", "Exception while running app load callback", th);
            com.applovin.impl.sdk.j jVar = this.f58269c;
            if (jVar != null) {
                jVar.D().a("AppLovinAdView", "notifyAdLoadFailed", th);
            }
        }
    }

    private void a(Runnable runnable) {
        AppLovinSdkUtils.runOnUiThread(runnable);
    }

    public void a(b bVar) {
        this.f58273h = bVar;
    }

    public void a(Uri uri) {
        if (this.f58285t == null || !this.f58285t.E0()) {
            return;
        }
        if (this.f58281p == null) {
            this.f58269c.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f58269c.I().a("AppLovinAdView", "GA is not initialized. Cannot fire GA event");
                return;
            }
            return;
        }
        final String queryParameter = uri.getQueryParameter("event_name");
        final String queryParameter2 = uri.getQueryParameter("event_params_json");
        if (TextUtils.isEmpty(queryParameter)) {
            this.f58269c.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f58269c.I().a("AppLovinAdView", "Invalid GA event name. Cannot fire GA event");
                return;
            }
            return;
        }
        a(new Runnable() { // from class: com.applovin.impl.adview.a0
            @Override // java.lang.Runnable
            public final void run() {
                this.f58296a.a(queryParameter2, queryParameter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2) {
        String str3;
        if (StringUtils.isValidString(str)) {
            str3 = "gtag('event', '" + str2 + "', " + str + ");";
        } else {
            str3 = "gtag('event', '" + str2 + "')";
        }
        tr.a(this.f58281p, str3);
    }
}
