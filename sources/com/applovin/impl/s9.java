package com.applovin.impl;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;
import com.applovin.impl.aq;
import com.applovin.impl.u4;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class s9 extends u9 {

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private final aq f63004m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private final Set f63005n0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements u4.b {
        a() {
        }

        @Override // com.applovin.impl.u4.b
        public void a() {
            long seconds = TimeUnit.MILLISECONDS.toSeconds(s9.this.f64138d0 - ((long) (s9.this.M.getDuration() - s9.this.M.getCurrentPosition())));
            int iA = s9.this.A();
            HashSet hashSet = new HashSet();
            for (kq kqVar : new HashSet(s9.this.f63005n0)) {
                if (kqVar.a(seconds, iA)) {
                    hashSet.add(kqVar);
                    s9.this.f63005n0.remove(kqVar);
                }
            }
            s9.this.a(hashSet);
            if (iA >= 25 && iA < 50) {
                s9.this.f63004m0.getAdEventTracker().x();
                return;
            }
            if (iA >= 50 && iA < 75) {
                s9.this.f63004m0.getAdEventTracker().y();
            } else if (iA >= 75) {
                s9.this.f63004m0.getAdEventTracker().C();
            }
        }

        @Override // com.applovin.impl.u4.b
        public boolean b() {
            return !s9.this.f64141g0;
        }
    }

    public s9(com.applovin.impl.sdk.ad.b bVar, final Activity activity, Map map, final com.applovin.impl.sdk.j jVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(bVar, activity, map, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        HashSet hashSet = new HashSet();
        this.f63005n0 = hashSet;
        aq aqVar = (aq) bVar;
        this.f63004m0 = aqVar;
        if (aqVar.x1()) {
            ImageView imageViewA = gq.a(aqVar.r1().e(), activity, jVar);
            this.U = imageViewA;
            imageViewA.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.q40
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f62562a.a(activity, jVar, view);
                }
            });
        }
        aq.d dVar = aq.d.VIDEO;
        hashSet.addAll(aqVar.a(dVar, lq.f61267a));
        a(aq.d.IMPRESSION);
        a(dVar, "creativeView");
        aqVar.getAdEventTracker().g();
    }

    private void X() {
        if (!E() || this.f63005n0.isEmpty()) {
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.k("AppLovinFullscreenActivity", "Firing " + this.f63005n0.size() + " un-fired video progress trackers when video was completed.");
        }
        a(this.f63005n0);
    }

    @Override // com.applovin.impl.u9
    public void B() {
        a(aq.d.VIDEO, "skip");
        this.f63004m0.getAdEventTracker().B();
        super.B();
    }

    @Override // com.applovin.impl.u9
    protected void C() {
        super.C();
        aq aqVar = this.f63004m0;
        if (aqVar != null) {
            aqVar.getAdEventTracker().i();
        }
    }

    @Override // com.applovin.impl.u9
    protected void N() {
        long jW;
        int iP;
        long millis = 0;
        if (this.f63004m0.V() >= 0 || this.f63004m0.W() >= 0) {
            if (this.f63004m0.V() >= 0) {
                jW = this.f63004m0.V();
            } else {
                aq aqVar = this.f63004m0;
                nq nqVarV1 = aqVar.v1();
                if (nqVarV1 == null || nqVarV1.d() <= 0) {
                    long j3 = this.f64138d0;
                    if (j3 > 0) {
                        millis = j3;
                    }
                } else {
                    millis = TimeUnit.SECONDS.toMillis(nqVarV1.d());
                }
                if (aqVar.Z0() && (iP = (int) aqVar.p()) > 0) {
                    millis += TimeUnit.SECONDS.toMillis(iP);
                }
                jW = (long) (millis * (((double) this.f63004m0.W()) / 100.0d));
            }
            b(jW);
        }
    }

    @Override // com.applovin.impl.u9
    protected void S() {
        super.S();
        aq aqVar = this.f63004m0;
        if (aqVar != null) {
            aqVar.getAdEventTracker().j();
        }
    }

    @Override // com.applovin.impl.u9
    public void T() {
        X();
        if (!mq.a(this.f63004m0)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f62204c.a("AppLovinFullscreenActivity", "VAST ad does not have valid companion ad - dismissing...");
            }
            f();
        } else {
            if (this.f64141g0) {
                return;
            }
            a(aq.d.COMPANION, "creativeView");
            this.f63004m0.getAdEventTracker().w();
            super.T();
        }
    }

    @Override // com.applovin.impl.u9
    public void V() {
        super.V();
        a(aq.d.VIDEO, this.f64137c0 ? "mute" : "unmute");
        this.f63004m0.getAdEventTracker().b(this.f64137c0);
    }

    @Override // com.applovin.impl.u9
    protected void c(long j3) {
        super.c(j3);
        this.f63004m0.getAdEventTracker().b(TimeUnit.MILLISECONDS.toSeconds(j3), yp.e(this.f62203b));
    }

    @Override // com.applovin.impl.u9
    public void d(String str) {
        a(aq.d.ERROR, fq.MEDIA_FILE_ERROR);
        this.f63004m0.getAdEventTracker().b(str);
        super.d(str);
    }

    @Override // com.applovin.impl.u9, com.applovin.impl.o9
    public void f() {
        if (this.f63004m0 != null) {
            a(aq.d.VIDEO, "close");
            a(aq.d.COMPANION, "close");
        }
        super.f();
    }

    @Override // com.applovin.impl.o9
    public void u() {
        super.u();
        a(this.f64141g0 ? aq.d.COMPANION : aq.d.VIDEO, "pause");
        this.f63004m0.getAdEventTracker().z();
    }

    @Override // com.applovin.impl.o9
    public void v() {
        super.v();
        a(this.f64141g0 ? aq.d.COMPANION : aq.d.VIDEO, "resume");
        this.f63004m0.getAdEventTracker().A();
    }

    @Override // com.applovin.impl.u9, com.applovin.impl.o9
    public void x() {
        this.Z.c();
        super.x();
    }

    @Override // com.applovin.impl.u9, com.applovin.impl.o9
    public void y() {
        a((ViewGroup) null);
    }

    private boolean W() {
        return this.U != null && this.f63004m0.x1();
    }

    @Override // com.applovin.impl.u9
    public void a(MotionEvent motionEvent, Bundle bundle) {
        a(aq.d.VIDEO_CLICK);
        this.f63004m0.getAdEventTracker().v();
        super.a(motionEvent, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Activity activity, com.applovin.impl.sdk.j jVar, View view) {
        Uri uriC = this.f63004m0.r1().c();
        if (uriC != null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f62204c.a("AppLovinFullscreenActivity", "Industry Icon clicked, opening URL: " + uriC);
            }
            a(aq.d.INDUSTRY_ICON_CLICK);
            tp.a(uriC, activity, jVar);
        }
    }

    private void a(aq.d dVar) {
        a(dVar, fq.UNSPECIFIED);
    }

    private void a(aq.d dVar, fq fqVar) {
        a(dVar, "", fqVar);
    }

    private void a(aq.d dVar, String str) {
        a(dVar, str, fq.UNSPECIFIED);
    }

    private void a(aq.d dVar, String str, fq fqVar) {
        a(this.f63004m0.a(dVar, str), fqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Set set) {
        a(set, fq.UNSPECIFIED);
    }

    private void a(Set set, fq fqVar) {
        if (set == null || set.isEmpty()) {
            return;
        }
        long seconds = TimeUnit.MILLISECONDS.toSeconds(this.M.getCurrentPosition());
        oq oqVarW1 = this.f63004m0.w1();
        Uri uriD = oqVarW1 != null ? oqVarW1.d() : null;
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.a(CbYNFSEGaQj.ExPZPalOAJlmUB, "Firing " + set.size() + " tracker(s): " + set);
        }
        mq.a(set, seconds, uriD, fqVar, this.f62203b);
    }

    @Override // com.applovin.impl.u9, com.applovin.impl.o9
    public void a(ViewGroup viewGroup) {
        super.a(viewGroup);
        if (W()) {
            a(aq.d.INDUSTRY_ICON_IMPRESSION);
            this.U.setVisibility(0);
        }
        this.Z.a("PROGRESS_TRACKING", TimeUnit.SECONDS.toMillis(1L), new a());
        ArrayList arrayList = new ArrayList();
        o oVar = this.N;
        if (oVar != null) {
            arrayList.add(new ng(oVar, FriendlyObstructionPurpose.OTHER, "video stream buffering indicator"));
        }
        com.applovin.impl.adview.g gVar = this.O;
        if (gVar != null) {
            arrayList.add(new ng(gVar, FriendlyObstructionPurpose.CLOSE_AD, "skip button"));
        }
        h3 h3Var = this.P;
        if (h3Var != null) {
            arrayList.add(new ng(h3Var, FriendlyObstructionPurpose.OTHER, "countdown clock"));
        }
        ProgressBar progressBar = this.S;
        if (progressBar != null) {
            arrayList.add(new ng(progressBar, FriendlyObstructionPurpose.OTHER, "progress bar"));
        }
        ProgressBar progressBar2 = this.T;
        if (progressBar2 != null) {
            arrayList.add(new ng(progressBar2, FriendlyObstructionPurpose.OTHER, "postitial progress bar"));
        }
        ImageView imageView = this.Q;
        if (imageView != null) {
            arrayList.add(new ng(imageView, FriendlyObstructionPurpose.VIDEO_CONTROLS, "mute button"));
        }
        com.applovin.impl.adview.l lVar = this.R;
        if (lVar != null) {
            arrayList.add(new ng(lVar, FriendlyObstructionPurpose.VIDEO_CONTROLS, "generic webview overlay containing HTML controls"));
        }
        com.applovin.impl.adview.k kVar = this.f62210j;
        if (kVar != null && kVar.a()) {
            com.applovin.impl.adview.k kVar2 = this.f62210j;
            arrayList.add(new ng(kVar2, FriendlyObstructionPurpose.NOT_VISIBLE, kVar2.getIdentifier()));
        }
        this.f63004m0.getAdEventTracker().b(this.M, arrayList);
    }
}
