package com.applovin.impl;

import android.R;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.applovin.impl.sdk.utils.ImageViewUtils;
import com.applovin.impl.tm;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class w9 extends o9 implements g0 {
    private final x9 K;
    private final com.applovin.impl.adview.g L;
    private final ImageView M;
    private final o N;
    private final boolean O;
    private double P;
    private double Q;
    private final AtomicBoolean R;
    private final AtomicBoolean S;
    private boolean T;
    private long U;
    private long V;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class b implements View.OnClickListener {
        private b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == w9.this.L) {
                w9.this.K();
                return;
            }
            if (view == w9.this.M) {
                w9.this.L();
                return;
            }
            com.applovin.impl.sdk.n nVar = w9.this.f62204c;
            if (com.applovin.impl.sdk.n.a()) {
                w9.this.f62204c.b("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
            }
        }
    }

    public w9(com.applovin.impl.sdk.ad.b bVar, Activity activity, Map map, com.applovin.impl.sdk.j jVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(bVar, activity, map, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        this.K = new x9(this.f62202a, this.f62205d, this.f62203b);
        boolean zK0 = this.f62202a.K0();
        this.O = zK0;
        this.R = new AtomicBoolean();
        this.S = new AtomicBoolean();
        this.T = yp.e(this.f62203b);
        this.U = -2L;
        this.V = 0L;
        b bVar2 = new b();
        if (bVar.m0() >= 0) {
            com.applovin.impl.adview.g gVar = new com.applovin.impl.adview.g(bVar.d0(), activity);
            this.L = gVar;
            gVar.setVisibility(8);
            gVar.setOnClickListener(bVar2);
        } else {
            this.L = null;
        }
        if (a(this.T, jVar)) {
            ImageView imageView = new ImageView(activity);
            this.M = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setClickable(true);
            imageView.setOnClickListener(bVar2);
            d(this.T);
        } else {
            this.M = null;
        }
        if (!zK0) {
            this.N = null;
            return;
        }
        o oVar = new o(activity, ((Integer) jVar.a(sj.w2)).intValue(), R.attr.progressBarStyleLarge);
        this.N = oVar;
        oVar.setColor(Color.parseColor("#75FFFFFF"));
        oVar.setBackgroundColor(Color.parseColor("#00000000"));
        oVar.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E() {
        this.f62216p = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        if (this.S.compareAndSet(false, true)) {
            a(this.L, this.f62202a.m0(), new Runnable() { // from class: com.applovin.impl.i70
                @Override // java.lang.Runnable
                public final void run() {
                    this.f60367a.C();
                }
            });
        }
    }

    private void I() {
        this.K.a(this.f62212l);
        this.f62216p = SystemClock.elapsedRealtime();
        this.P = 100.0d;
    }

    protected void F() {
        long jW;
        long millis;
        if (this.f62202a.V() >= 0 || this.f62202a.W() >= 0) {
            if (this.f62202a.V() >= 0) {
                jW = this.f62202a.V();
            } else {
                com.applovin.impl.sdk.ad.a aVar = (com.applovin.impl.sdk.ad.a) this.f62202a;
                double d3 = this.Q;
                long millis2 = d3 > 0.0d ? TimeUnit.SECONDS.toMillis((long) d3) : 0L;
                if (aVar.Z0()) {
                    int iN1 = (int) ((com.applovin.impl.sdk.ad.a) this.f62202a).n1();
                    if (iN1 > 0) {
                        millis = TimeUnit.SECONDS.toMillis(iN1);
                    } else {
                        int iP = (int) aVar.p();
                        if (iP > 0) {
                            millis = TimeUnit.SECONDS.toMillis(iP);
                        }
                    }
                    millis2 += millis;
                }
                jW = (long) (millis2 * (((double) this.f62202a.W()) / 100.0d));
            }
            b(jW);
        }
    }

    protected boolean H() {
        return k() && !B();
    }

    public void J() {
        if (this.R.compareAndSet(false, true)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f62204c.a("AppLovinFullscreenActivity", "Showing postitial...");
            }
            c("javascript:al_showPostitial();");
            com.applovin.impl.adview.g gVar = this.L;
            if (gVar != null) {
                gVar.setVisibility(8);
            }
            ImageView imageView = this.M;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            o oVar = this.N;
            if (oVar != null) {
                oVar.b();
            }
            if (this.f62211k != null) {
                if (this.f62202a.p() >= 0) {
                    a(this.f62211k, this.f62202a.p(), new Runnable() { // from class: com.applovin.impl.l70
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f61165a.E();
                        }
                    });
                } else {
                    this.f62211k.setVisibility(0);
                }
            }
            this.f62209i.getController().E();
            r();
        }
    }

    public void K() {
        this.U = SystemClock.elapsedRealtime() - this.V;
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.a("AppLovinFullscreenActivity", "Attempting to skip video with skip time: " + this.U + "ms");
        }
        if (!H()) {
            A();
            return;
        }
        p();
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.a("AppLovinFullscreenActivity", "Prompting incentivized ad close warning");
        }
        this.E.e();
    }

    protected void L() {
        this.T = !this.T;
        c("javascript:al_setVideoMuted(" + this.T + ");");
        d(this.T);
        a(this.T, 0L);
    }

    @Override // com.applovin.impl.o9
    public void a(long j3) {
    }

    @Override // com.applovin.impl.jb.a
    public void c() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.a("AppLovinFullscreenActivity", "Continue video from prompt - will resume in onWindowFocusChanged(true) when alert dismisses");
        }
    }

    @Override // com.applovin.impl.g0
    public void d() {
        o oVar = this.N;
        if (oVar != null) {
            oVar.b();
        }
    }

    @Override // com.applovin.impl.g0
    public void e() {
        J();
    }

    @Override // com.applovin.impl.o9
    public void f() {
        o();
        super.f();
    }

    @Override // com.applovin.impl.o9
    public void h() {
        super.h();
        I();
    }

    @Override // com.applovin.impl.o9
    public void i() {
        super.i();
        I();
    }

    @Override // com.applovin.impl.o9
    protected void o() {
        super.a((int) this.P, this.O, B(), this.U);
    }

    @Override // com.applovin.impl.o9
    public void y() {
        a((ViewGroup) null);
    }

    private void A() {
        this.f62224x++;
        if (this.f62202a.B()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f62204c.a("AppLovinFullscreenActivity", "Dismissing ad on video skip...");
            }
            f();
        } else {
            if (com.applovin.impl.sdk.n.a()) {
                this.f62204c.a("AppLovinFullscreenActivity", "Skipping video...");
            }
            J();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C() {
        this.U = -1L;
        this.V = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D() {
        ArrayList arrayList = new ArrayList();
        com.applovin.impl.adview.g gVar = this.f62211k;
        if (gVar != null) {
            arrayList.add(new ng(gVar, FriendlyObstructionPurpose.CLOSE_AD, "close button"));
        }
        com.applovin.impl.adview.k kVar = this.f62210j;
        if (kVar != null && kVar.a()) {
            com.applovin.impl.adview.k kVar2 = this.f62210j;
            arrayList.add(new ng(kVar2, FriendlyObstructionPurpose.NOT_VISIBLE, kVar2.getIdentifier()));
        }
        this.f62202a.getAdEventTracker().b(this.f62209i, arrayList);
    }

    protected boolean B() {
        return (this.H && this.f62202a.c1()) || this.P >= ((double) this.f62202a.o0());
    }

    @Override // com.applovin.impl.g0
    public void b(double d3) {
        c("javascript:al_setVideoMuted(" + this.T + ");");
        o oVar = this.N;
        if (oVar != null) {
            oVar.b();
        }
        if (this.L != null) {
            G();
        }
        this.f62209i.getController().D();
        this.Q = d3;
        F();
        if (this.f62202a.f1()) {
            this.E.b(this.f62202a, (Runnable) null);
        }
    }

    private static boolean a(boolean z2, com.applovin.impl.sdk.j jVar) {
        if (!((Boolean) jVar.a(sj.f63764l2)).booleanValue()) {
            return false;
        }
        if (!((Boolean) jVar.a(sj.f63768m2)).booleanValue() || z2) {
            return true;
        }
        return ((Boolean) jVar.a(sj.f63776o2)).booleanValue();
    }

    private void d(boolean z2) {
        if (z3.f()) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) this.f62205d.getDrawable(z2 ? com.applovin.sdk.R.drawable.applovin_ic_unmute_to_mute : com.applovin.sdk.R.drawable.applovin_ic_mute_to_unmute);
            if (animatedVectorDrawable != null) {
                this.M.setScaleType(ImageView.ScaleType.FIT_XY);
                this.M.setImageDrawable(animatedVectorDrawable);
                animatedVectorDrawable.start();
                return;
            }
        }
        ImageViewUtils.setImageUri(this.M, z2 ? this.f62202a.M() : this.f62202a.g0(), this.f62203b);
    }

    @Override // com.applovin.impl.o9
    public void a(ViewGroup viewGroup) {
        this.K.a(this.M, this.L, this.f62211k, this.N, this.f62210j, this.f62209i, viewGroup);
        this.f62209i.getController().a((g0) this);
        if (a(false)) {
            return;
        }
        o oVar = this.N;
        if (oVar != null) {
            oVar.a();
        }
        com.applovin.impl.adview.k kVar = this.f62210j;
        if (kVar != null) {
            kVar.b();
        }
        this.f62209i.renderAd(this.f62202a);
        if (this.L != null) {
            this.f62203b.i0().a(new jn(this.f62203b, "scheduleSkipButton", new Runnable() { // from class: com.applovin.impl.j70
                @Override // java.lang.Runnable
                public final void run() {
                    this.f60678a.G();
                }
            }), tm.b.TIMEOUT, this.f62202a.n0(), true);
        }
        this.f62203b.i0().a(new jn(this.f62203b, "updateMainViewOM", new Runnable() { // from class: com.applovin.impl.k70
            @Override // java.lang.Runnable
            public final void run() {
                this.f60940a.D();
            }
        }), tm.b.OTHER, 500L);
        super.c(this.T);
    }

    @Override // com.applovin.impl.jb.a
    public void b() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.a("AppLovinFullscreenActivity", "Skipping video from prompt");
        }
        A();
    }

    @Override // com.applovin.impl.o9
    public void x() {
    }

    @Override // com.applovin.impl.g0
    public void a(double d3) {
        this.P = d3;
    }

    @Override // com.applovin.impl.g0
    public void a() {
        o oVar = this.N;
        if (oVar != null) {
            oVar.a();
        }
    }
}
