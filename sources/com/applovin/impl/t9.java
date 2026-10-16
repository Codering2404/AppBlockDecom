package com.applovin.impl;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.applovin.adview.AppLovinAdView;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.exoplayer2.ui.d;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.bi;
import com.applovin.impl.ck;
import com.applovin.impl.qh;
import com.applovin.impl.rr;
import com.applovin.impl.sdk.utils.ImageViewUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.tm;
import com.applovin.impl.u4;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.share.HKJ.pnxuebdT;
import com.google.ads.mediation.applovin.AppLovinMediationAdapter;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class t9 extends o9 implements AppLovinCommunicatorSubscriber {
    private final v9 K;
    protected final com.applovin.exoplayer2.ui.e L;
    protected final ck M;
    protected final o N;
    protected final com.applovin.impl.adview.g O;
    protected h3 P;
    protected final ImageView Q;
    protected com.applovin.impl.adview.l R;
    protected final ProgressBar S;
    protected ProgressBar T;
    private final d U;
    private final Handler V;
    private final Handler W;
    protected final u4 X;
    protected final u4 Y;
    private final boolean Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    protected boolean f63895a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    protected long f63896b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    protected int f63897c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    protected boolean f63898d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    protected boolean f63899e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private long f63900f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private final AtomicBoolean f63901g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private final AtomicBoolean f63902h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private long f63903i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private long f63904j0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements u4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f63905a;

        a(int i3) {
            this.f63905a = i3;
        }

        @Override // com.applovin.impl.u4.b
        public void a() {
            t9 t9Var = t9.this;
            if (t9Var.P != null) {
                long seconds = ((long) this.f63905a) - TimeUnit.MILLISECONDS.toSeconds(t9Var.L.getPlayer().getCurrentPosition());
                if (seconds <= 0) {
                    t9.this.f62221u = true;
                } else if (t9.this.P()) {
                    t9.this.P.setProgress((int) seconds);
                }
            }
        }

        @Override // com.applovin.impl.u4.b
        public boolean b() {
            return t9.this.P();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b implements u4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Integer f63907a;

        b(Integer num) {
            this.f63907a = num;
        }

        @Override // com.applovin.impl.u4.b
        public void a() {
            t9 t9Var = t9.this;
            if (t9Var.f63898d0) {
                t9Var.S.setVisibility(8);
            } else {
                t9.this.S.setProgress((int) ((t9Var.M.getCurrentPosition() / t9.this.f63896b0) * this.f63907a.intValue()));
            }
        }

        @Override // com.applovin.impl.u4.b
        public boolean b() {
            return !t9.this.f63898d0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class c implements u4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f63909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Integer f63910b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Long f63911c;

        c(long j3, Integer num, Long l3) {
            this.f63909a = j3;
            this.f63910b = num;
            this.f63911c = l3;
        }

        @Override // com.applovin.impl.u4.b
        public void a() {
            t9.this.T.setProgress((int) ((t9.this.f62217q / this.f63909a) * this.f63910b.intValue()));
            t9.this.f62217q += this.f63911c.longValue();
        }

        @Override // com.applovin.impl.u4.b
        public boolean b() {
            return t9.this.f62217q < this.f63909a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class d implements rr.a {
        private d() {
        }

        @Override // com.applovin.impl.rr.a
        public void a(com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.n nVar = t9.this.f62204c;
            if (com.applovin.impl.sdk.n.a()) {
                t9.this.f62204c.a("AppLovinFullscreenActivity", "Closing ad from video button...");
            }
            t9.this.f();
        }

        @Override // com.applovin.impl.rr.a
        public void b(com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.n nVar = t9.this.f62204c;
            if (com.applovin.impl.sdk.n.a()) {
                t9.this.f62204c.a("AppLovinFullscreenActivity", "Clicking through from video button...");
            }
            t9.this.a(lVar.getAndClearLastClickEvent(), (Bundle) null);
        }

        @Override // com.applovin.impl.rr.a
        public void c(com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.n nVar = t9.this.f62204c;
            if (com.applovin.impl.sdk.n.a()) {
                t9.this.f62204c.a("AppLovinFullscreenActivity", "Fully Watched from video button...");
            }
            t9.this.H = true;
        }

        @Override // com.applovin.impl.rr.a
        public void d(com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.n nVar = t9.this.f62204c;
            if (com.applovin.impl.sdk.n.a()) {
                t9.this.f62204c.a("AppLovinFullscreenActivity", "Skipping video from video button...");
            }
            t9.this.U();
        }

        /* synthetic */ d(t9 t9Var, a aVar) {
            this();
        }

        @Override // com.applovin.impl.rr.a
        public void a(com.applovin.impl.adview.l lVar, Bundle bundle) {
            com.applovin.impl.sdk.n nVar = t9.this.f62204c;
            if (com.applovin.impl.sdk.n.a()) {
                t9.this.f62204c.a("AppLovinFullscreenActivity", "Attempting to launch Direct Download from video button...");
            }
            t9.this.a(lVar.getAndClearLastClickEvent(), bundle);
        }

        @Override // com.applovin.impl.rr.a
        public void b(Uri uri, com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.n nVar = t9.this.f62204c;
            if (com.applovin.impl.sdk.n.a()) {
                t9.this.f62204c.a("AppLovinFullscreenActivity", "Attempting to report a template error from video button...");
            }
            tp.b(uri, t9.this.f62209i.getController().i(), t9.this.f62203b);
        }

        @Override // com.applovin.impl.rr.a
        public void a(Uri uri, com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.n nVar = t9.this.f62204c;
            if (com.applovin.impl.sdk.n.a()) {
                t9.this.f62204c.a("AppLovinFullscreenActivity", "Attempting to load a url from video button...");
            }
            tp.a(uri, t9.this.f62209i.getController(), t9.this.f62203b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class e implements qh.c, d.e, AppLovinTouchToClickListener.OnClickListener {
        private e() {
        }

        @Override // com.applovin.impl.qh.c
        public void a(nh nhVar) {
            t9.this.d("Video view error (" + yp.a(nhVar) + ")");
            t9.this.f();
        }

        @Override // com.applovin.impl.qh.c
        public void b(int i3) {
            com.applovin.impl.sdk.n nVar = t9.this.f62204c;
            if (com.applovin.impl.sdk.n.a()) {
                t9.this.f62204c.a("AppLovinFullscreenActivity", "Player state changed to state " + i3 + " and will play when ready: " + t9.this.M.l());
            }
            if (i3 == 2) {
                t9.this.S();
                return;
            }
            if (i3 != 3) {
                if (i3 == 4) {
                    com.applovin.impl.sdk.n nVar2 = t9.this.f62204c;
                    if (com.applovin.impl.sdk.n.a()) {
                        t9.this.f62204c.a("AppLovinFullscreenActivity", "Video completed");
                    }
                    t9 t9Var = t9.this;
                    t9Var.f63899e0 = true;
                    if (!t9Var.f62219s) {
                        t9Var.T();
                        return;
                    } else {
                        if (t9Var.k()) {
                            t9.this.R();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            t9 t9Var2 = t9.this;
            t9Var2.M.a(!t9Var2.f63895a0 ? 1 : 0);
            t9 t9Var3 = t9.this;
            t9Var3.f62220t = (int) TimeUnit.MILLISECONDS.toSeconds(t9Var3.M.getDuration());
            t9 t9Var4 = t9.this;
            t9Var4.c(t9Var4.M.getDuration());
            t9.this.M();
            com.applovin.impl.sdk.n nVar3 = t9.this.f62204c;
            if (com.applovin.impl.sdk.n.a()) {
                t9.this.f62204c.a("AppLovinFullscreenActivity", "MediaPlayer prepared: " + t9.this.M);
            }
            t9.this.X.b();
            t9 t9Var5 = t9.this;
            if (t9Var5.O != null) {
                t9Var5.N();
            }
            t9.this.C();
            if (t9.this.E.b()) {
                t9.this.x();
            }
        }

        @Override // com.applovin.exoplayer2.ui.d.e
        public void d(int i3) {
            if (i3 == 0) {
                t9.this.L.c();
            }
        }

        @Override // com.applovin.impl.adview.AppLovinTouchToClickListener.OnClickListener
        public void onClick(View view, MotionEvent motionEvent) {
            t9.this.a(motionEvent, (Bundle) null);
        }

        /* synthetic */ e(t9 t9Var, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class f implements View.OnClickListener {
        private f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            t9 t9Var = t9.this;
            if (view == t9Var.O) {
                t9Var.U();
                return;
            }
            if (view == t9Var.Q) {
                t9Var.W();
                return;
            }
            if (com.applovin.impl.sdk.n.a()) {
                t9.this.f62204c.b("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
            }
        }

        /* synthetic */ f(t9 t9Var, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H() {
        a(250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I() {
        o oVar = this.N;
        if (oVar != null) {
            oVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J() {
        this.f62216p = SystemClock.elapsedRealtime();
    }

    private void K() {
        com.applovin.impl.adview.l lVar;
        qq qqVarK0 = this.f62202a.k0();
        if (qqVarK0 == null || !qqVarK0.j() || this.f63898d0 || (lVar = this.R) == null) {
            return;
        }
        final boolean z2 = lVar.getVisibility() == 4;
        final long jH = qqVarK0.h();
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.q50
            @Override // java.lang.Runnable
            public final void run() {
                this.f62573a.b(z2, jH);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        this.K.a(this.f62212l);
        this.f62216p = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(boolean z2, long j3) {
        if (z2) {
            zq.a(this.R, j3, (Runnable) null);
        } else {
            zq.b(this.R, j3, null);
        }
    }

    protected void L() {
        if (this.f63898d0) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f62204c.k("AppLovinFullscreenActivity", "Skip video resume - postitial shown");
                return;
            }
            return;
        }
        if (this.f62203b.e0().isApplicationPaused()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f62204c.k("AppLovinFullscreenActivity", "Skip video resume - app paused");
                return;
            }
            return;
        }
        long j3 = this.f63900f0;
        if (j3 < 0) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f62204c.a("AppLovinFullscreenActivity", "Invalid last video position, isVideoPlaying=" + this.M.isPlaying());
                return;
            }
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.a("AppLovinFullscreenActivity", "Resuming video at position " + j3 + "ms for MediaPlayer: " + this.M);
        }
        this.M.a(true);
        this.X.b();
        this.f63900f0 = -1L;
        if (this.M.isPlaying()) {
            return;
        }
        S();
    }

    protected void M() {
        long jW;
        long millis;
        if (this.f62202a.V() >= 0 || this.f62202a.W() >= 0) {
            if (this.f62202a.V() >= 0) {
                jW = this.f62202a.V();
            } else {
                com.applovin.impl.sdk.ad.a aVar = (com.applovin.impl.sdk.ad.a) this.f62202a;
                long j3 = this.f63896b0;
                long j4 = j3 > 0 ? j3 : 0L;
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
                    j4 += millis;
                }
                jW = (long) (j4 * (((double) this.f62202a.W()) / 100.0d));
            }
            b(jW);
        }
    }

    protected void N() {
        if (this.f63902h0.compareAndSet(false, true)) {
            a(this.O, this.f62202a.m0(), new Runnable() { // from class: com.applovin.impl.j50
                @Override // java.lang.Runnable
                public final void run() {
                    this.f60609a.G();
                }
            });
        }
    }

    protected void O() {
        if (a(!this.Z)) {
            return;
        }
        Activity activity = this.f62205d;
        bi biVarA = new bi.b(new v5(activity, xp.a((Context) activity, AppLovinMediationAdapter.APPLOVIN_SDK_ERROR_DOMAIN))).a(sd.a(this.f62202a.u0()));
        this.M.a(!this.f63895a0 ? 1 : 0);
        this.M.a((ae) biVarA);
        this.M.b();
        this.M.a(false);
    }

    protected boolean P() {
        return (this.f62221u || this.f63898d0 || !this.L.getPlayer().isPlaying()) ? false : true;
    }

    protected boolean Q() {
        return k() && !D();
    }

    protected void S() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.o50
            @Override // java.lang.Runnable
            public final void run() {
                this.f62191a.I();
            }
        });
    }

    public void T() {
        t9 t9Var;
        V();
        long jU = this.f62202a.U();
        if (jU > 0) {
            this.f62217q = 0L;
            Long l3 = (Long) this.f62203b.a(sj.C2);
            Integer num = (Integer) this.f62203b.a(sj.F2);
            ProgressBar progressBar = new ProgressBar(this.f62205d, null, R.attr.progressBarStyleHorizontal);
            this.T = progressBar;
            a(progressBar, this.f62202a.T(), num.intValue());
            t9Var = this;
            this.Y.a("POSTITIAL_PROGRESS_BAR", l3.longValue(), t9Var.new c(jU, num, l3));
            t9Var.Y.b();
        } else {
            t9Var = this;
        }
        t9Var.K.a(t9Var.f62211k, t9Var.f62210j, t9Var.f62209i, t9Var.T);
        a("javascript:al_onPoststitialShow(" + t9Var.f62224x + "," + t9Var.f62225y + ");", t9Var.f62202a.D());
        if (t9Var.f62211k != null) {
            if (t9Var.f62202a.p() >= 0) {
                a(t9Var.f62211k, t9Var.f62202a.p(), new Runnable() { // from class: com.applovin.impl.p50
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f62416a.J();
                    }
                });
            } else {
                t9Var.f62211k.setVisibility(0);
            }
        }
        ArrayList arrayList = new ArrayList();
        com.applovin.impl.adview.g gVar = t9Var.f62211k;
        if (gVar != null) {
            arrayList.add(new ng(gVar, FriendlyObstructionPurpose.CLOSE_AD, "close button"));
        }
        com.applovin.impl.adview.k kVar = t9Var.f62210j;
        if (kVar != null && kVar.a()) {
            com.applovin.impl.adview.k kVar2 = t9Var.f62210j;
            arrayList.add(new ng(kVar2, FriendlyObstructionPurpose.NOT_VISIBLE, kVar2.getIdentifier()));
        }
        ProgressBar progressBar2 = t9Var.T;
        if (progressBar2 != null) {
            arrayList.add(new ng(progressBar2, FriendlyObstructionPurpose.OTHER, "postitial progress bar"));
        }
        t9Var.f62202a.getAdEventTracker().b(t9Var.f62209i, arrayList);
        r();
        t9Var.f63898d0 = true;
    }

    public void U() {
        this.f63903i0 = SystemClock.elapsedRealtime() - this.f63904j0;
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.a("AppLovinFullscreenActivity", "Attempting to skip video with skip time: " + this.f63903i0 + "ms");
        }
        if (!Q()) {
            B();
            return;
        }
        x();
        p();
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.a("AppLovinFullscreenActivity", "Prompting incentivized ad close warning");
        }
        this.E.e();
    }

    protected void V() {
        this.f63897c0 = A();
        this.M.a(false);
    }

    protected void W() {
        boolean z2 = this.f63895a0;
        this.f63895a0 = !z2;
        this.M.a(z2 ? 1.0f : 0.0f);
        d(this.f63895a0);
        a(this.f63895a0, 0L);
    }

    protected void c(long j3) {
        this.f63896b0 = j3;
    }

    protected void d(String str) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.b("AppLovinFullscreenActivity", "Encountered media error: " + str + " for ad: " + this.f62202a);
        }
        if (StringUtils.containsAtLeastOneSubstring(str, this.f62203b.c(sj.H2))) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f62204c.a("AppLovinFullscreenActivity", "Ignoring media error: " + str);
                return;
            }
            return;
        }
        if (this.f63901g0.compareAndSet(false, true)) {
            if (yp.a(sj.O0, this.f62203b)) {
                this.f62203b.A().d(this.f62202a, com.applovin.impl.sdk.j.m());
            }
            AppLovinAdDisplayListener appLovinAdDisplayListener = this.C;
            if (appLovinAdDisplayListener instanceof pb) {
                ((pb) appLovinAdDisplayListener).onAdDisplayFailed(str);
            }
            this.f62203b.D().a(this.f62202a instanceof aq ? "handleVastExoPlayerError" : "handleExoPlayerError", str, this.f62202a);
            f();
        }
    }

    @Override // com.applovin.impl.o9
    public void f() {
        this.X.a();
        this.Y.a();
        this.V.removeCallbacksAndMessages(null);
        this.W.removeCallbacksAndMessages(null);
        o();
        super.f();
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "FullscreenVideoAdExoPlayerPresenter";
    }

    @Override // com.applovin.impl.o9
    public void h() {
        super.h();
        R();
    }

    @Override // com.applovin.impl.o9
    public void i() {
        super.i();
        this.K.a(this.R);
        this.K.a((View) this.O);
        if (!k() || this.f63898d0) {
            R();
        }
    }

    @Override // com.applovin.impl.o9
    protected void o() {
        super.a(A(), this.Z, D(), this.f63903i0);
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("video_caching_failed".equals(appLovinCommunicatorMessage.getTopic())) {
            Bundle messageData = appLovinCommunicatorMessage.getMessageData();
            if (messageData.getLong("ad_id") == this.f62202a.getAdIdNumber() && this.Z) {
                int i3 = messageData.getInt("load_response_code");
                String string = messageData.getString("load_exception_message");
                if ((string == null && i3 >= 200 && i3 < 300) || this.f63899e0 || this.M.isPlaying()) {
                    return;
                }
                d("Video cache error during stream. ResponseCode=" + i3 + ", exception=" + string);
            }
        }
    }

    @Override // com.applovin.impl.o9
    public void t() {
        if (((Boolean) this.f62203b.a(sj.b6)).booleanValue()) {
            tr.d(this.R);
            this.R = null;
        }
        this.M.V();
        if (this.Z) {
            AppLovinCommunicator.getInstance(this.f62205d).unsubscribe(this, "video_caching_failed");
        }
        super.t();
    }

    @Override // com.applovin.impl.o9
    public void x() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.a("AppLovinFullscreenActivity", "Pausing video");
        }
        if (!this.M.isPlaying()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f62204c.a("AppLovinFullscreenActivity", "Nothing to pause");
                return;
            }
            return;
        }
        this.f63900f0 = this.M.getCurrentPosition();
        this.M.a(false);
        this.X.c();
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.a("AppLovinFullscreenActivity", "Paused video at position " + this.f63900f0 + "ms");
        }
    }

    @Override // com.applovin.impl.o9
    public void y() {
        a((ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F() {
        o oVar = this.N;
        if (oVar != null) {
            oVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G() {
        this.f63903i0 = -1L;
        this.f63904j0 = SystemClock.elapsedRealtime();
    }

    protected int A() {
        ck ckVar = this.M;
        if (ckVar == null) {
            return 0;
        }
        long currentPosition = ckVar.getCurrentPosition();
        if (this.f63899e0) {
            return 100;
        }
        return currentPosition > 0 ? (int) ((currentPosition / this.f63896b0) * 100.0f) : this.f63897c0;
    }

    public void B() {
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
            T();
        }
    }

    protected void C() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.k50
            @Override // java.lang.Runnable
            public final void run() {
                this.f60933a.F();
            }
        });
    }

    protected boolean D() {
        com.applovin.impl.sdk.ad.b bVar = this.f62202a;
        if (bVar == null) {
            return false;
        }
        if (this.H && bVar.c1()) {
            return true;
        }
        return E();
    }

    protected boolean E() {
        return A() >= this.f62202a.o0();
    }

    protected void a(MotionEvent motionEvent, Bundle bundle) {
        Context context;
        if (!this.f62202a.J0()) {
            K();
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.a("AppLovinFullscreenActivity", "Clicking through video");
        }
        Uri uriL0 = this.f62202a.l0();
        if (uriL0 != null) {
            if (!((Boolean) this.f62203b.a(sj.B)).booleanValue() || (context = this.f62205d) == null) {
                AppLovinAdView appLovinAdView = this.f62209i;
                context = appLovinAdView != null ? appLovinAdView.getContext() : com.applovin.impl.sdk.j.m();
            }
            this.f62203b.j().trackAndLaunchVideoClick(this.f62202a, uriL0, motionEvent, bundle, this, context);
            fc.a(this.B, this.f62202a);
            this.f62225y++;
        }
    }

    @Override // com.applovin.impl.jb.a
    public void c() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.a("AppLovinFullscreenActivity", "Continue video from prompt - will resume in onWindowFocusChanged(true) when alert dismisses");
        }
    }

    public t9(com.applovin.impl.sdk.ad.b bVar, Activity activity, Map map, com.applovin.impl.sdk.j jVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(bVar, activity, map, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        this.K = new v9(this.f62202a, this.f62205d, this.f62203b);
        a aVar = null;
        d dVar = new d(this, aVar);
        this.U = dVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.V = handler;
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.W = handler2;
        u4 u4Var = new u4(handler, this.f62203b);
        this.X = u4Var;
        this.Y = new u4(handler2, this.f62203b);
        boolean zK0 = this.f62202a.K0();
        this.Z = zK0;
        this.f63895a0 = yp.e(this.f62203b);
        this.f63900f0 = -1L;
        this.f63901g0 = new AtomicBoolean();
        this.f63902h0 = new AtomicBoolean();
        this.f63903i0 = -2L;
        this.f63904j0 = 0L;
        if (bVar.hasVideoUrl()) {
            f fVar = new f(this, aVar);
            if (bVar.m0() >= 0) {
                com.applovin.impl.adview.g gVar = new com.applovin.impl.adview.g(bVar.d0(), activity);
                this.O = gVar;
                gVar.setVisibility(8);
                gVar.setOnClickListener(fVar);
            } else {
                this.O = null;
            }
            if (a(this.f63895a0, jVar)) {
                ImageView imageView = new ImageView(activity);
                this.Q = imageView;
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setClickable(true);
                imageView.setOnClickListener(fVar);
                d(this.f63895a0);
            } else {
                this.Q = null;
            }
            String strI0 = bVar.i0();
            if (StringUtils.isValidString(strI0)) {
                rr rrVar = new rr(jVar);
                rrVar.a(new WeakReference(dVar));
                com.applovin.impl.adview.l lVar = new com.applovin.impl.adview.l(bVar.h0(), bVar, rrVar, activity);
                this.R = lVar;
                lVar.a(strI0);
            } else {
                this.R = null;
            }
            if (zK0) {
                o oVar = new o(activity, ((Integer) jVar.a(sj.w2)).intValue(), R.attr.progressBarStyleLarge);
                this.N = oVar;
                oVar.setColor(Color.parseColor(pnxuebdT.ikhxx));
                oVar.setBackgroundColor(Color.parseColor("#00000000"));
                oVar.setVisibility(8);
                AppLovinCommunicator.getInstance(activity).subscribe(this, "video_caching_failed");
            } else {
                this.N = null;
            }
            int iG = g();
            boolean z2 = ((Boolean) jVar.a(sj.f63725b2)).booleanValue() && iG > 0;
            if (this.P == null && z2) {
                this.P = new h3(activity);
                int iQ = bVar.q();
                this.P.setTextColor(iQ);
                this.P.setTextSize(((Integer) jVar.a(sj.f63722a2)).intValue());
                this.P.setFinishedStrokeColor(iQ);
                this.P.setFinishedStrokeWidth(((Integer) jVar.a(sj.Z1)).intValue());
                this.P.setMax(iG);
                this.P.setProgress(iG);
                u4Var.a("COUNTDOWN_CLOCK", TimeUnit.SECONDS.toMillis(1L), new a(iG));
            }
            if (bVar.t0()) {
                Long l3 = (Long) jVar.a(sj.t2);
                Integer num = (Integer) jVar.a(sj.u2);
                ProgressBar progressBar = new ProgressBar(activity, null, R.attr.progressBarStyleHorizontal);
                this.S = progressBar;
                a(progressBar, bVar.s0(), num.intValue());
                u4Var.a("PROGRESS_BAR", l3.longValue(), new b(num));
            } else {
                this.S = null;
            }
            ck ckVarA = new ck.b(activity).a();
            this.M = ckVarA;
            e eVar = new e(this, aVar);
            ckVarA.a((qh.c) eVar);
            ckVarA.a(0);
            com.applovin.exoplayer2.ui.e eVar2 = new com.applovin.exoplayer2.ui.e(activity);
            this.L = eVar2;
            eVar2.c();
            eVar2.setControllerVisibilityListener(eVar);
            eVar2.setPlayer(ckVarA);
            eVar2.setOnTouchListener(new AppLovinTouchToClickListener(jVar, sj.f63754j0, activity, eVar));
            bVar.e().putString("video_view_address", zq.a(eVar2));
            O();
            return;
        }
        throw new IllegalStateException("Attempting to use fullscreen video ad presenter for non-video ad");
    }

    @Override // com.applovin.impl.o9
    public void b(boolean z2) {
        super.b(z2);
        if (z2) {
            a(0L);
            if (this.f63898d0) {
                this.Y.b();
                return;
            }
            return;
        }
        if (this.f63898d0) {
            this.Y.c();
        } else {
            x();
        }
    }

    @Override // com.applovin.impl.jb.a
    public void b() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.a("AppLovinFullscreenActivity", "Skipping video from prompt");
        }
        B();
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

    protected void d(boolean z2) {
        if (z3.f()) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) this.f62205d.getDrawable(z2 ? com.applovin.sdk.R.drawable.applovin_ic_unmute_to_mute : com.applovin.sdk.R.drawable.applovin_ic_mute_to_unmute);
            if (animatedVectorDrawable != null) {
                this.Q.setScaleType(ImageView.ScaleType.FIT_XY);
                this.Q.setImageDrawable(animatedVectorDrawable);
                animatedVectorDrawable.start();
                return;
            }
        }
        ImageViewUtils.setImageUri(this.Q, z2 ? this.f62202a.M() : this.f62202a.g0(), this.f62203b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        tr.a(this.R, str, "AppLovinFullscreenActivity", this.f62203b);
    }

    @Override // com.applovin.impl.o9
    protected void a(final String str, long j3) {
        super.a(str, j3);
        if (this.R == null || j3 < 0 || !StringUtils.isValidString(str)) {
            return;
        }
        a(new Runnable() { // from class: com.applovin.impl.n50
            @Override // java.lang.Runnable
            public final void run() {
                this.f61982a.a(str);
            }
        }, j3);
    }

    private void a(ProgressBar progressBar, int i3, int i4) {
        progressBar.setMax(i4);
        progressBar.setPadding(0, 0, 0, 0);
        if (z3.f()) {
            progressBar.setProgressTintList(ColorStateList.valueOf(i3));
        }
    }

    @Override // com.applovin.impl.o9
    public void a(ViewGroup viewGroup) {
        this.K.a(this.Q, this.O, this.R, this.N, this.S, this.P, this.L, this.f62209i, this.f62210j, null, viewGroup);
        com.applovin.impl.adview.k kVar = this.f62210j;
        if (kVar != null) {
            kVar.b();
        }
        this.M.a(true);
        if (this.f62202a.f1()) {
            this.E.b(this.f62202a, new Runnable() { // from class: com.applovin.impl.l50
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61112a.H();
                }
            });
        }
        if (this.Z) {
            S();
        }
        this.f62209i.renderAd(this.f62202a);
        if (this.O != null) {
            this.f62203b.i0().a(new jn(this.f62203b, "scheduleSkipButton", new Runnable() { // from class: com.applovin.impl.m50
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61379a.N();
                }
            }), tm.b.TIMEOUT, this.f62202a.n0(), true);
        }
        super.c(this.f63895a0);
    }

    @Override // com.applovin.impl.o9
    public void a(long j3) {
        a(new Runnable() { // from class: com.applovin.impl.i50
            @Override // java.lang.Runnable
            public final void run() {
                this.f60349a.L();
            }
        }, j3);
    }
}
