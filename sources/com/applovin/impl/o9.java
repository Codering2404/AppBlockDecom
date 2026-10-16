package com.applovin.impl;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.datastore.preferences.core.SfRj.rnFwbPAQmQTnL;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.a;
import com.applovin.impl.adview.e;
import com.applovin.impl.j2;
import com.applovin.impl.jb;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.h;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.tm;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class o9 implements jb.a, AppLovinBroadcastManager.Receiver, a.b {
    protected boolean A;
    protected AppLovinAdClickListener B;
    protected AppLovinAdDisplayListener C;
    protected AppLovinAdVideoPlaybackListener D;
    protected final jb E;
    protected go F;
    protected go G;
    protected boolean H;
    private final j2 I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.applovin.impl.sdk.ad.b f62202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.applovin.impl.sdk.j f62203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.applovin.impl.sdk.n f62204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Activity f62205d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final p f62207g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final h.a f62208h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected AppLovinAdView f62209i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected com.applovin.impl.adview.k f62210j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected final com.applovin.impl.adview.g f62211k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected final com.applovin.impl.adview.g f62212l;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected long f62217q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f62218r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected boolean f62219s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected int f62220t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected boolean f62221u;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Handler f62206f = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected final long f62213m = SystemClock.elapsedRealtime();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final AtomicBoolean f62214n = new AtomicBoolean();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final AtomicBoolean f62215o = new AtomicBoolean();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected long f62216p = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f62222v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final ArrayList f62223w = new ArrayList();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected int f62224x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    protected int f62225y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected int f62226z = com.applovin.impl.sdk.h.f63311i;
    private boolean J = false;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements AppLovinAdDisplayListener {
        a() {
        }

        @Override // com.applovin.sdk.AppLovinAdDisplayListener
        public void adDisplayed(AppLovinAd appLovinAd) {
            com.applovin.impl.sdk.n nVar = o9.this.f62204c;
            if (com.applovin.impl.sdk.n.a()) {
                o9.this.f62204c.a("AppLovinFullscreenActivity", "Web content rendered");
            }
        }

        @Override // com.applovin.sdk.AppLovinAdDisplayListener
        public void adHidden(AppLovinAd appLovinAd) {
            com.applovin.impl.sdk.n nVar = o9.this.f62204c;
            if (com.applovin.impl.sdk.n.a()) {
                o9.this.f62204c.a("AppLovinFullscreenActivity", "Closing from WebView");
            }
            o9.this.f();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b implements h.a {
        b() {
        }

        @Override // com.applovin.impl.sdk.h.a
        public void a(int i3) {
            o9 o9Var = o9.this;
            if (o9Var.f62226z != com.applovin.impl.sdk.h.f63311i) {
                o9Var.A = true;
            }
            com.applovin.impl.adview.b bVarG = o9Var.f62209i.getController().g();
            if (bVarG == null) {
                com.applovin.impl.sdk.n nVar = o9.this.f62204c;
                if (com.applovin.impl.sdk.n.a()) {
                    o9.this.f62204c.k("AppLovinFullscreenActivity", "Unable to handle ringer mode change: no valid web view.");
                }
            } else if (com.applovin.impl.sdk.h.a(i3) && !com.applovin.impl.sdk.h.a(o9.this.f62226z)) {
                bVarG.a("javascript:al_muteSwitchOn();");
            } else if (i3 == 2) {
                bVarG.a("javascript:al_muteSwitchOff();");
            }
            o9.this.f62226z = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class c extends p {
        c() {
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (!activity.getClass().getName().equals(yp.l(activity.getApplicationContext())) || o9.this.f62215o.get()) {
                return;
            }
            com.applovin.impl.sdk.n.h("AppLovinFullscreenActivity", "Dismissing on-screen ad due to app relaunched via launcher.");
            try {
                o9.this.f();
            } catch (Throwable th) {
                com.applovin.impl.sdk.n.c("AppLovinFullscreenActivity", "Failed to dismiss ad.", th);
                try {
                    o9.this.n();
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface d {
        void a(o9 o9Var);

        void a(String str, Throwable th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class e implements AppLovinAdClickListener, View.OnClickListener {
        private e() {
        }

        @Override // com.applovin.sdk.AppLovinAdClickListener
        public void adClicked(AppLovinAd appLovinAd) {
            com.applovin.impl.sdk.n nVar = o9.this.f62204c;
            if (com.applovin.impl.sdk.n.a()) {
                o9.this.f62204c.a("AppLovinFullscreenActivity", "Clicking through graphic");
            }
            fc.a(o9.this.B, appLovinAd);
            o9.this.f62225y++;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            o9 o9Var = o9.this;
            if (view != o9Var.f62211k || !((Boolean) o9Var.f62203b.a(sj.f63736e2)).booleanValue()) {
                com.applovin.impl.sdk.n nVar = o9.this.f62204c;
                if (com.applovin.impl.sdk.n.a()) {
                    o9.this.f62204c.b("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
                    return;
                }
                return;
            }
            o9.c(o9.this);
            if (o9.this.f62202a.W0()) {
                o9.this.c("javascript:al_onCloseButtonTapped(" + o9.this.f62222v + "," + o9.this.f62224x + "," + o9.this.f62225y + ");");
            }
            List listL = o9.this.f62202a.L();
            com.applovin.impl.sdk.n nVar2 = o9.this.f62204c;
            if (com.applovin.impl.sdk.n.a()) {
                o9.this.f62204c.a("AppLovinFullscreenActivity", "Handling close button tap " + o9.this.f62222v + " with multi close delay: " + listL);
            }
            if (listL == null || listL.size() <= o9.this.f62222v) {
                o9.this.f();
                return;
            }
            o9.this.f62223w.add(Long.valueOf(SystemClock.elapsedRealtime() - o9.this.f62216p));
            List listJ = o9.this.f62202a.J();
            if (listJ != null && listJ.size() > o9.this.f62222v) {
                o9 o9Var2 = o9.this;
                o9Var2.f62211k.a((e.a) listJ.get(o9Var2.f62222v));
            }
            com.applovin.impl.sdk.n nVar3 = o9.this.f62204c;
            if (com.applovin.impl.sdk.n.a()) {
                o9.this.f62204c.a("AppLovinFullscreenActivity", "Scheduling next close button with delay: " + listL.get(o9.this.f62222v));
            }
            o9.this.f62211k.setVisibility(8);
            o9 o9Var3 = o9.this;
            o9Var3.a(o9Var3.f62211k, ((Integer) listL.get(o9Var3.f62222v)).intValue(), new Runnable() { // from class: com.applovin.impl.g00
                @Override // java.lang.Runnable
                public final void run() {
                    this.f59841a.a();
                }
            });
        }

        /* synthetic */ e(o9 o9Var, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            o9.this.f62216p = SystemClock.elapsedRealtime();
        }
    }

    o9(com.applovin.impl.sdk.ad.b bVar, Activity activity, Map map, com.applovin.impl.sdk.j jVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f62202a = bVar;
        this.f62203b = jVar;
        this.f62204c = jVar.I();
        this.f62205d = activity;
        this.B = appLovinAdClickListener;
        this.C = appLovinAdDisplayListener;
        this.D = appLovinAdVideoPlaybackListener;
        jb jbVar = new jb(activity, jVar);
        this.E = jbVar;
        jbVar.a(this);
        this.I = new j2(jVar);
        e eVar = new e(this, null);
        if (((Boolean) jVar.a(sj.A2)).booleanValue()) {
            AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.render_process_gone"));
        }
        if (((Boolean) jVar.a(sj.G2)).booleanValue()) {
            AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.al_onPoststitialShow_evaluation_error"));
        }
        m9 m9Var = new m9(jVar.q0(), AppLovinAdSize.INTERSTITIAL, activity);
        this.f62209i = m9Var;
        m9Var.setAdClickListener(eVar);
        this.f62209i.setAdDisplayListener(new a());
        bVar.e().putString("ad_view_address", zq.a(this.f62209i));
        this.f62209i.getController().a(this);
        da daVar = new da(map, jVar);
        if (daVar.c()) {
            this.f62210j = new com.applovin.impl.adview.k(daVar, activity);
        }
        jVar.j().trackImpression(bVar);
        List listL = bVar.L();
        if (bVar.p() >= 0 || listL != null) {
            com.applovin.impl.adview.g gVar = new com.applovin.impl.adview.g(bVar.n(), activity);
            this.f62211k = gVar;
            gVar.setVisibility(8);
            gVar.setOnClickListener(eVar);
        } else {
            this.f62211k = null;
        }
        com.applovin.impl.adview.g gVar2 = new com.applovin.impl.adview.g(e.a.WHITE_ON_TRANSPARENT, activity);
        this.f62212l = gVar2;
        gVar2.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.c00
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f58800a.b(view);
            }
        });
        if (bVar.Y0()) {
            this.f62208h = new b();
        } else {
            this.f62208h = null;
        }
        this.f62207g = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        if (this.f62202a.H0().getAndSet(true)) {
            return;
        }
        this.f62203b.i0().a((yl) new en(this.f62202a, this.f62203b), tm.b.OTHER);
    }

    private void z() {
        if (this.f62208h != null) {
            this.f62203b.o().a(this.f62208h);
        }
        if (this.f62207g != null) {
            this.f62203b.e().a(this.f62207g);
        }
    }

    public abstract void a(long j3);

    public abstract void a(ViewGroup viewGroup);

    public void i() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.d("AppLovinFullscreenActivity", "Handling render process crash");
        }
        this.f62219s = true;
    }

    public boolean j() {
        return this.f62218r;
    }

    protected boolean k() {
        return AppLovinAdType.INCENTIVIZED == this.f62202a.getType() || AppLovinAdType.AUTO_INCENTIVIZED == this.f62202a.getType();
    }

    protected boolean l() {
        return this.f62205d instanceof AppLovinFullscreenActivity;
    }

    protected void n() {
        if (this.f62215o.compareAndSet(false, true)) {
            fc.b(this.C, this.f62202a);
            this.f62203b.B().b(this.f62202a);
            this.f62203b.D().a(ka.f60959l, this.f62202a);
        }
    }

    protected abstract void o();

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        if ("com.applovin.render_process_gone".equals(intent.getAction()) && !this.f62219s) {
            i();
        } else if ("com.applovin.al_onPoststitialShow_evaluation_error".equals(intent.getAction())) {
            h();
        }
    }

    protected void p() {
        go goVar = this.F;
        if (goVar != null) {
            goVar.d();
        }
    }

    protected void q() {
        go goVar = this.F;
        if (goVar != null) {
            goVar.e();
        }
    }

    protected void r() {
        com.applovin.impl.adview.b bVarG;
        if (this.f62209i == null || !this.f62202a.z0() || (bVarG = this.f62209i.getController().g()) == null) {
            return;
        }
        this.I.a(bVarG, new j2.c() { // from class: com.applovin.impl.d00
            @Override // com.applovin.impl.j2.c
            public final void a(View view) {
                this.f59051a.a(view);
            }
        });
    }

    public void s() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.d("AppLovinFullscreenActivity", "onBackPressed()");
        }
        if (this.J) {
            f();
        }
        if (this.f62202a.W0()) {
            c("javascript:onBackPressed();");
        }
    }

    public void t() {
        AppLovinAdView appLovinAdView = this.f62209i;
        if (appLovinAdView != null) {
            ViewParent parent = appLovinAdView.getParent();
            this.f62209i.destroy();
            this.f62209i = null;
            if ((parent instanceof ViewGroup) && l()) {
                ((ViewGroup) parent).removeAllViews();
            }
        }
        o();
        n();
        this.B = null;
        this.C = null;
        this.D = null;
        this.f62205d = null;
        AppLovinBroadcastManager.unregisterReceiver(this);
    }

    public void u() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.d("AppLovinFullscreenActivity", "onPause()");
        }
        b("javascript:al_onAppPaused();");
        if (this.E.b()) {
            this.E.a();
        }
        p();
    }

    public void v() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.d("AppLovinFullscreenActivity", "onResume()");
        }
        b("javascript:al_onAppResumed();");
        q();
        if (this.E.b()) {
            this.E.a();
        }
    }

    public void w() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.d("AppLovinFullscreenActivity", "onStop()");
        }
    }

    public abstract void x();

    public abstract void y();

    static /* synthetic */ int c(o9 o9Var) {
        int i3 = o9Var.f62222v;
        o9Var.f62222v = i3 + 1;
        return i3;
    }

    public void f() {
        this.f62218r = true;
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.d("AppLovinFullscreenActivity", "dismiss()");
        }
        com.applovin.impl.sdk.ad.b bVar = this.f62202a;
        if (bVar != null) {
            bVar.getAdEventTracker().f();
        }
        this.f62206f.removeCallbacksAndMessages(null);
        a("javascript:al_onPoststitialDismiss();", this.f62202a != null ? r0.C() : 0L);
        n();
        this.I.b();
        if (this.f62208h != null) {
            this.f62203b.o().b(this.f62208h);
        }
        if (this.f62207g != null) {
            this.f62203b.e().b(this.f62207g);
        }
        if (l()) {
            this.f62205d.finish();
            return;
        }
        this.f62203b.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f62203b.I().a("AppLovinFullscreenActivity", "Fullscreen ad shown in container view dismissed, destroying the presenter.");
        }
        t();
    }

    protected int g() {
        int iR = this.f62202a.r();
        return (iR <= 0 && ((Boolean) this.f62203b.a(sj.x2)).booleanValue()) ? this.f62220t + 1 : iR;
    }

    public void h() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.d("AppLovinFullscreenActivity", "Handling al_onPoststitialShow evaluation error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(final com.applovin.impl.adview.g gVar, final Runnable runnable) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.f00
            @Override // java.lang.Runnable
            public final void run() {
                o9.b(gVar, runnable);
            }
        });
    }

    protected boolean a(boolean z2) {
        List listA = yp.a(z2, this.f62202a, this.f62203b, this.f62205d);
        if (listA.isEmpty()) {
            return false;
        }
        if (((Boolean) this.f62203b.a(sj.G5)).booleanValue()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f62204c.b("AppLovinFullscreenActivity", "Dismissing ad due to missing resources: " + listA);
            }
            sb.a(this.f62202a, this.C, "Missing ad resources", null, null);
            f();
            HashMap map = new HashMap();
            CollectionUtils.putStringIfValid("error_message", "Missing ad resources: " + listA, map);
            CollectionUtils.putStringIfValid("details", "Failing ad display", map);
            this.f62203b.D().a(ka.Q, "missingCachedAdResources", (Map) map);
            return ((Boolean) this.f62203b.a(sj.I5)).booleanValue();
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.b("AppLovinFullscreenActivity", "Streaming ad due to missing ad resources: " + listA);
        }
        this.f62202a.N0();
        HashMap map2 = new HashMap();
        CollectionUtils.putStringIfValid("error_message", "Missing ad resources: " + listA, map2);
        CollectionUtils.putStringIfValid("details", "Streaming ad", map2);
        this.f62203b.D().a(ka.Q, "missingCachedAdResources", (Map) map2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(final com.applovin.impl.adview.g gVar, final Runnable runnable) {
        zq.a(gVar, 400L, new Runnable() { // from class: com.applovin.impl.a00
            @Override // java.lang.Runnable
            public final void run() {
                o9.a(gVar, runnable);
            }
        });
    }

    protected void c(String str) {
        a(str, 0L);
    }

    protected void b(String str) {
        if (this.f62202a.D0()) {
            a(str, 0L);
        }
    }

    protected void c(boolean z2) {
        a(z2, ((Long) this.f62203b.a(sj.y2)).longValue());
        fc.a(this.C, this.f62202a);
        this.f62203b.B().a(this.f62202a);
        if (this.f62202a.hasVideoUrl() || k()) {
            fc.a(this.D, this.f62202a);
        }
        new xg(this.f62205d).a(this.f62202a);
        this.f62202a.setHasShown(true);
    }

    public void b(boolean z2) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.d("AppLovinFullscreenActivity", "onWindowFocusChanged(boolean) - " + z2);
        }
        b(rnFwbPAQmQTnL.UjTtbqx + z2 + " );");
        go goVar = this.G;
        if (goVar != null) {
            if (z2) {
                goVar.e();
            } else {
                goVar.d();
            }
        }
    }

    protected void b(long j3) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.a("AppLovinFullscreenActivity", "Scheduling report reward in " + TimeUnit.MILLISECONDS.toSeconds(j3) + " seconds...");
        }
        this.F = go.a(j3, this.f62203b, new Runnable() { // from class: com.applovin.impl.b00
            @Override // java.lang.Runnable
            public final void run() {
                this.f58535a.m();
            }
        });
    }

    public static void a(com.applovin.impl.sdk.ad.b bVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, Map map, com.applovin.impl.sdk.j jVar, Activity activity, d dVar) {
        o9 p9Var;
        com.applovin.impl.sdk.j jVar2;
        com.applovin.impl.sdk.j jVar3;
        boolean zI1 = bVar.i1();
        if (bVar instanceof aq) {
            if (zI1) {
                try {
                    p9Var = new r9(bVar, activity, map, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
                } catch (Throwable th) {
                    jVar.I();
                    if (com.applovin.impl.sdk.n.a()) {
                        jVar.I().d("AppLovinFullscreenActivity", "Failed to create ExoPlayer presenter to show the ad. Falling back to using native media player presenter.", th);
                    }
                    jVar.D().a("AppLovinFullscreenActivity", "createVastVideoAdExoPlayerPresenter", th, la.a(bVar));
                    try {
                        jVar3 = jVar;
                        try {
                            p9Var = new s9(bVar, activity, map, jVar3, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
                        } catch (Throwable th2) {
                            th = th2;
                            Throwable th3 = th;
                            dVar.a("Failed to create FullscreenVastVideoAdPresenter with sdk: " + jVar3 + " and throwable: " + th3.getMessage(), th3);
                            return;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        jVar3 = jVar;
                    }
                }
            } else {
                try {
                    p9Var = new s9(bVar, activity, map, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
                } catch (Throwable th5) {
                    dVar.a("Failed to create FullscreenVastVideoAdPresenter with sdk: " + jVar + " and throwable: " + th5.getMessage(), th5);
                    return;
                }
            }
        } else if (bVar.hasVideoUrl()) {
            if (bVar.M0()) {
                try {
                    p9Var = new w9(bVar, activity, map, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
                } catch (Throwable th6) {
                    dVar.a("Failed to create FullscreenWebVideoAdPresenter with sdk: " + jVar + " and throwable: " + th6.getMessage(), th6);
                    return;
                }
            } else if (zI1) {
                try {
                    p9Var = new t9(bVar, activity, map, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
                } catch (Throwable th7) {
                    jVar.I();
                    if (com.applovin.impl.sdk.n.a()) {
                        jVar.I().d("AppLovinFullscreenActivity", "Failed to create ExoPlayer presenter to show the ad. Falling back to using native media player presenter.", th7);
                    }
                    jVar.D().a("AppLovinFullscreenActivity", "createVideoAdExoPlayerPresenter", th7, la.a(bVar));
                    try {
                        jVar2 = jVar;
                        try {
                            p9Var = new u9(bVar, activity, map, jVar2, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
                        } catch (Throwable th8) {
                            th = th8;
                            Throwable th9 = th;
                            dVar.a("Failed to create FullscreenVideoAdExoPlayerPresenter with sdk: " + jVar2 + " and throwable: " + th9.getMessage(), th9);
                            return;
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        jVar2 = jVar;
                    }
                }
            } else {
                try {
                    p9Var = new u9(bVar, activity, map, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
                } catch (Throwable th11) {
                    dVar.a("Failed to create FullscreenVideoAdPresenter with sdk: " + jVar + " and throwable: " + th11.getMessage(), th11);
                    return;
                }
            }
        } else {
            try {
                p9Var = new p9(bVar, activity, map, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
            } catch (Throwable th12) {
                dVar.a("Failed to create FullscreenGraphicAdPresenter with sdk: " + jVar + " and throwable: " + th12.getMessage(), th12);
                return;
            }
        }
        p9Var.z();
        dVar.a(p9Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        com.applovin.impl.adview.b bVarG;
        AppLovinAdView appLovinAdView = this.f62209i;
        if (appLovinAdView == null || (bVarG = appLovinAdView.getController().g()) == null) {
            return;
        }
        bVarG.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.applovin.impl.adview.g gVar, Runnable runnable) {
        gVar.bringToFront();
        runnable.run();
    }

    protected void a(final String str, long j3) {
        if (j3 < 0 || !StringUtils.isValidString(str)) {
            return;
        }
        a(new Runnable() { // from class: com.applovin.impl.e00
            @Override // java.lang.Runnable
            public final void run() {
                this.f59314a.a(str);
            }
        }, j3);
    }

    protected void a(int i3, boolean z2, boolean z3, long j3) {
        if (this.f62214n.compareAndSet(false, true)) {
            if (this.f62202a.hasVideoUrl() || k()) {
                fc.a(this.D, this.f62202a, i3, z3);
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f62213m;
            this.f62203b.j().trackVideoEnd(this.f62202a, TimeUnit.MILLISECONDS.toSeconds(jElapsedRealtime), i3, z2);
            long jElapsedRealtime2 = this.f62216p != -1 ? SystemClock.elapsedRealtime() - this.f62216p : -1L;
            this.f62203b.j().trackFullScreenAdClosed(this.f62202a, jElapsedRealtime2, this.f62223w, j3, this.A, this.f62226z);
            if (com.applovin.impl.sdk.n.a()) {
                this.f62204c.a("AppLovinFullscreenActivity", "Video ad ended at percent: " + i3 + "%, elapsedTime: " + jElapsedRealtime + "ms, skipTimeMillis: " + j3 + "ms, closeTimeMillis: " + jElapsedRealtime2 + "ms");
            }
        }
    }

    protected void a(boolean z2, long j3) {
        if (this.f62202a.O0()) {
            a(z2 ? "javascript:al_mute();" : "javascript:al_unmute();", j3);
        }
    }

    public void a(int i3, KeyEvent keyEvent) {
        if (this.f62204c == null || !com.applovin.impl.sdk.n.a()) {
            return;
        }
        this.f62204c.d("AppLovinFullscreenActivity", "onKeyDown(int, KeyEvent) -  " + i3 + ", " + keyEvent);
    }

    protected void a(Runnable runnable, long j3) {
        AppLovinSdkUtils.runOnUiThreadDelayed(runnable, j3, this.f62206f);
    }

    protected void a(final com.applovin.impl.adview.g gVar, long j3, final Runnable runnable) {
        if (j3 >= ((Long) this.f62203b.a(sj.f63733d2)).longValue()) {
            return;
        }
        this.G = go.a(TimeUnit.SECONDS.toMillis(j3), this.f62203b, new Runnable() { // from class: com.applovin.impl.zz
            @Override // java.lang.Runnable
            public final void run() {
                o9.c(gVar, runnable);
            }
        });
    }

    public void a(Configuration configuration) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.d("AppLovinFullscreenActivity", "onConfigurationChanged(Configuration) -  " + configuration);
        }
    }

    @Override // com.applovin.impl.adview.a.b
    public void a(com.applovin.impl.adview.a aVar) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.a("AppLovinFullscreenActivity", "Fully watched from ad web view...");
        }
        this.H = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        com.applovin.impl.adview.g gVar;
        if (yp.a(sj.P0, this.f62203b)) {
            this.f62203b.A().c(this.f62202a, com.applovin.impl.sdk.j.m());
        }
        this.f62203b.D().a(ka.P, la.a(this.f62202a, true, this.f62203b));
        if (((Boolean) this.f62203b.a(sj.X5)).booleanValue()) {
            f();
            return;
        }
        this.J = ((Boolean) this.f62203b.a(sj.Y5)).booleanValue();
        if (!((Boolean) this.f62203b.a(sj.Z5)).booleanValue() || (gVar = this.f62211k) == null) {
            return;
        }
        gVar.setVisibility(0);
    }
}
