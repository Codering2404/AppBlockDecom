package com.applovin.impl;

import android.app.Activity;
import android.os.SystemClock;
import android.view.ViewGroup;
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
public class p9 extends o9 {
    private final q9 K;
    private x1 L;
    private long M;
    private final AtomicBoolean N;

    public p9(com.applovin.impl.sdk.ad.b bVar, Activity activity, Map map, com.applovin.impl.sdk.j jVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(bVar, activity, map, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        this.K = new q9(this.f62202a, this.f62205d, this.f62203b);
        this.N = new AtomicBoolean();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.a("AppLovinFullscreenActivity", "Marking ad as fully watched");
        }
        this.N.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E() {
        this.f62216p = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F() {
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

    private void H() {
        this.K.a(this.f62212l);
        this.f62216p = SystemClock.elapsedRealtime();
        this.N.set(true);
    }

    protected void G() {
        long jW;
        long millis = 0;
        if (this.f62202a.V() >= 0 || this.f62202a.W() >= 0) {
            if (this.f62202a.V() >= 0) {
                jW = this.f62202a.V();
            } else {
                if (this.f62202a.Z0()) {
                    int iN1 = (int) ((com.applovin.impl.sdk.ad.a) this.f62202a).n1();
                    if (iN1 > 0) {
                        millis = TimeUnit.SECONDS.toMillis(iN1);
                    } else {
                        int iP = (int) this.f62202a.p();
                        if (iP > 0) {
                            millis = TimeUnit.SECONDS.toMillis(iP);
                        }
                    }
                }
                jW = (long) (millis * (((double) this.f62202a.W()) / 100.0d));
            }
            b(jW);
        }
    }

    @Override // com.applovin.impl.o9
    public void a(long j3) {
    }

    @Override // com.applovin.impl.o9
    public void f() {
        o();
        x1 x1Var = this.L;
        if (x1Var != null) {
            x1Var.a();
            this.L = null;
        }
        super.f();
    }

    @Override // com.applovin.impl.o9
    public void h() {
        super.h();
        H();
    }

    @Override // com.applovin.impl.o9
    public void i() {
        super.i();
        H();
    }

    @Override // com.applovin.impl.o9
    protected void o() {
        super.a(B(), false, C(), -2L);
    }

    @Override // com.applovin.impl.o9
    public void y() {
        a((ViewGroup) null);
    }

    private long A() {
        com.applovin.impl.sdk.ad.b bVar = this.f62202a;
        if (!(bVar instanceof com.applovin.impl.sdk.ad.a)) {
            return 0L;
        }
        float fN1 = ((com.applovin.impl.sdk.ad.a) bVar).n1();
        if (fN1 <= 0.0f) {
            fN1 = this.f62202a.p();
        }
        return (long) (yp.c(fN1) * (((double) this.f62202a.E()) / 100.0d));
    }

    private int B() {
        x1 x1Var;
        int iMin = 100;
        if (k()) {
            if (!C() && (x1Var = this.L) != null) {
                iMin = (int) Math.min(100.0d, ((this.M - x1Var.b()) / this.M) * 100.0d);
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f62204c.a("AppLovinFullscreenActivity", "Ad engaged at " + iMin + "%");
            }
        }
        return iMin;
    }

    protected boolean C() {
        if (!(this.H && this.f62202a.c1()) && k()) {
            return this.N.get();
        }
        return true;
    }

    @Override // com.applovin.impl.o9
    public void a(ViewGroup viewGroup) {
        this.K.a(this.f62211k, this.f62210j, this.f62209i, viewGroup);
        if (a(false)) {
            return;
        }
        com.applovin.impl.adview.k kVar = this.f62210j;
        if (kVar != null) {
            kVar.b();
        }
        this.f62209i.renderAd(this.f62202a);
        a("javascript:al_onPoststitialShow();", this.f62202a.D());
        if (k()) {
            long jA = A();
            this.M = jA;
            if (jA > 0) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f62204c.a("AppLovinFullscreenActivity", "Scheduling timer for ad fully watched in " + this.M + "ms...");
                }
                this.L = x1.a(this.M, this.f62203b, new Runnable() { // from class: com.applovin.impl.m00
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f61321a.D();
                    }
                });
            }
        }
        if (this.f62211k != null) {
            if (this.f62202a.p() >= 0) {
                a(this.f62211k, this.f62202a.p(), new Runnable() { // from class: com.applovin.impl.n00
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f61952a.E();
                    }
                });
            } else {
                this.f62211k.setVisibility(0);
            }
        }
        G();
        this.f62203b.i0().a(new jn(this.f62203b, "updateMainViewOM", new Runnable() { // from class: com.applovin.impl.o00
            @Override // java.lang.Runnable
            public final void run() {
                this.f62154a.F();
            }
        }), tm.b.OTHER, TimeUnit.SECONDS.toMillis(1L));
        r();
        super.c(yp.e(this.f62203b));
    }

    @Override // com.applovin.impl.jb.a
    public void b() {
    }

    @Override // com.applovin.impl.jb.a
    public void c() {
    }

    @Override // com.applovin.impl.o9
    public void x() {
    }
}
