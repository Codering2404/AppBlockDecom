package com.applovin.impl;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
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
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.adview.AppLovinVideoView;
import com.applovin.impl.rr;
import com.applovin.impl.sdk.utils.ImageViewUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.tm;
import com.applovin.impl.u4;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class u9 extends o9 implements AppLovinCommunicatorSubscriber {
    private final v9 K;
    private MediaPlayer L;
    protected final AppLovinVideoView M;
    protected final o N;
    protected final com.applovin.impl.adview.g O;
    protected h3 P;
    protected final ImageView Q;
    protected com.applovin.impl.adview.l R;
    protected final ProgressBar S;
    protected ProgressBar T;
    protected ImageView U;
    private final e V;
    private final d W;
    private final Handler X;
    private final Handler Y;
    protected final u4 Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    protected final u4 f64135a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private final boolean f64136b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    protected boolean f64137c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    protected long f64138d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private int f64139e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private int f64140f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    protected boolean f64141g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private boolean f64142h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private final AtomicBoolean f64143i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private final AtomicBoolean f64144j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private long f64145k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private long f64146l0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements u4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f64147a;

        a(int i3) {
            this.f64147a = i3;
        }

        @Override // com.applovin.impl.u4.b
        public void a() {
            if (u9.this.P != null) {
                long seconds = ((long) this.f64147a) - TimeUnit.MILLISECONDS.toSeconds(r0.M.getCurrentPosition());
                if (seconds <= 0) {
                    u9.this.f62221u = true;
                } else if (u9.this.P()) {
                    u9.this.P.setProgress((int) seconds);
                }
            }
        }

        @Override // com.applovin.impl.u4.b
        public boolean b() {
            return u9.this.P();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b implements u4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Integer f64149a;

        b(Integer num) {
            this.f64149a = num;
        }

        @Override // com.applovin.impl.u4.b
        public void a() {
            u9 u9Var = u9.this;
            if (u9Var.f64141g0) {
                u9Var.S.setVisibility(8);
            } else {
                u9.this.S.setProgress((int) ((u9Var.M.getCurrentPosition() / u9.this.f64138d0) * this.f64149a.intValue()));
            }
        }

        @Override // com.applovin.impl.u4.b
        public boolean b() {
            return !u9.this.f64141g0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class c implements u4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f64151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Integer f64152b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Long f64153c;

        c(long j3, Integer num, Long l3) {
            this.f64151a = j3;
            this.f64152b = num;
            this.f64153c = l3;
        }

        @Override // com.applovin.impl.u4.b
        public void a() {
            u9.this.T.setProgress((int) ((u9.this.f62217q / this.f64151a) * this.f64152b.intValue()));
            u9.this.f62217q += this.f64153c.longValue();
        }

        @Override // com.applovin.impl.u4.b
        public boolean b() {
            return u9.this.f62217q < this.f64151a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class d implements rr.a {
        private d() {
        }

        @Override // com.applovin.impl.rr.a
        public void a(com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.n nVar = u9.this.f62204c;
            if (com.applovin.impl.sdk.n.a()) {
                u9.this.f62204c.a("AppLovinFullscreenActivity", "Closing ad from video button...");
            }
            u9.this.f();
        }

        @Override // com.applovin.impl.rr.a
        public void b(com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.n nVar = u9.this.f62204c;
            if (com.applovin.impl.sdk.n.a()) {
                u9.this.f62204c.a("AppLovinFullscreenActivity", "Clicking through from video button...");
            }
            u9.this.a(lVar.getAndClearLastClickEvent(), (Bundle) null);
        }

        @Override // com.applovin.impl.rr.a
        public void c(com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.n nVar = u9.this.f62204c;
            if (com.applovin.impl.sdk.n.a()) {
                u9.this.f62204c.a("AppLovinFullscreenActivity", "Fully Watched from video button...");
            }
            u9.this.H = true;
        }

        @Override // com.applovin.impl.rr.a
        public void d(com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.n nVar = u9.this.f62204c;
            if (com.applovin.impl.sdk.n.a()) {
                u9.this.f62204c.a("AppLovinFullscreenActivity", "Skipping video from video button...");
            }
            u9.this.U();
        }

        /* synthetic */ d(u9 u9Var, a aVar) {
            this();
        }

        @Override // com.applovin.impl.rr.a
        public void a(com.applovin.impl.adview.l lVar, Bundle bundle) {
            com.applovin.impl.sdk.n nVar = u9.this.f62204c;
            if (com.applovin.impl.sdk.n.a()) {
                u9.this.f62204c.a("AppLovinFullscreenActivity", "Attempting to launch Direct Download from video button...");
            }
            u9.this.a(lVar.getAndClearLastClickEvent(), bundle);
        }

        @Override // com.applovin.impl.rr.a
        public void b(Uri uri, com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.n nVar = u9.this.f62204c;
            if (com.applovin.impl.sdk.n.a()) {
                u9.this.f62204c.a("AppLovinFullscreenActivity", "Attempting to report a template error from video button...");
            }
            tp.b(uri, u9.this.f62209i.getController().i(), u9.this.f62203b);
        }

        @Override // com.applovin.impl.rr.a
        public void a(Uri uri, com.applovin.impl.adview.l lVar) {
            com.applovin.impl.sdk.n nVar = u9.this.f62204c;
            if (com.applovin.impl.sdk.n.a()) {
                u9.this.f62204c.a("AppLovinFullscreenActivity", "Attempting to load a url from video button...");
            }
            tp.a(uri, u9.this.f62209i.getController(), u9.this.f62203b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class e implements MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnCompletionListener, AppLovinTouchToClickListener.OnClickListener {
        private e() {
        }

        @Override // com.applovin.impl.adview.AppLovinTouchToClickListener.OnClickListener
        public void onClick(View view, MotionEvent motionEvent) {
            u9.this.a(motionEvent, (Bundle) null);
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            com.applovin.impl.sdk.n nVar = u9.this.f62204c;
            if (com.applovin.impl.sdk.n.a()) {
                u9.this.f62204c.a("AppLovinFullscreenActivity", "Video completed");
            }
            u9.this.f64142h0 = true;
            u9 u9Var = u9.this;
            if (!u9Var.f62219s) {
                u9Var.T();
            } else if (u9Var.k()) {
                u9.this.R();
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i3, int i4) {
            u9.this.d("Video view error (" + i3 + "," + i4 + ")");
            u9.this.M.start();
            return true;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i3, int i4) {
            com.applovin.impl.sdk.n nVar = u9.this.f62204c;
            if (com.applovin.impl.sdk.n.a()) {
                u9.this.f62204c.a("AppLovinFullscreenActivity", "MediaPlayer Info: (" + i3 + ", " + i4 + ")");
            }
            if (i3 == 701) {
                u9.this.S();
                return false;
            }
            if (i3 != 3) {
                if (i3 != 702) {
                    return false;
                }
                u9.this.C();
                return false;
            }
            u9.this.Z.b();
            u9 u9Var = u9.this;
            if (u9Var.O != null) {
                u9Var.O();
            }
            u9.this.C();
            if (!u9.this.E.b()) {
                return false;
            }
            u9.this.x();
            return false;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            u9.this.L = mediaPlayer;
            mediaPlayer.setOnInfoListener(u9.this.V);
            mediaPlayer.setOnErrorListener(u9.this.V);
            float f3 = !u9.this.f64137c0 ? 1 : 0;
            mediaPlayer.setVolume(f3, f3);
            u9.this.f62220t = (int) TimeUnit.MILLISECONDS.toSeconds(mediaPlayer.getDuration());
            u9.this.c(mediaPlayer.getDuration());
            u9.this.N();
            com.applovin.impl.sdk.n nVar = u9.this.f62204c;
            if (com.applovin.impl.sdk.n.a()) {
                u9.this.f62204c.a("AppLovinFullscreenActivity", "MediaPlayer prepared: " + u9.this.L);
            }
        }

        /* synthetic */ e(u9 u9Var, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class f implements View.OnClickListener {
        private f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            u9 u9Var = u9.this;
            if (view == u9Var.O) {
                u9Var.U();
                return;
            }
            if (view == u9Var.Q) {
                u9Var.V();
                return;
            }
            if (com.applovin.impl.sdk.n.a()) {
                u9.this.f62204c.b("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
            }
        }

        /* synthetic */ f(u9 u9Var, a aVar) {
            this();
        }
    }

    public u9(com.applovin.impl.sdk.ad.b bVar, Activity activity, Map map, com.applovin.impl.sdk.j jVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(bVar, activity, map, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        this.K = new v9(this.f62202a, this.f62205d, this.f62203b);
        a aVar = null;
        this.U = null;
        e eVar = new e(this, aVar);
        this.V = eVar;
        d dVar = new d(this, aVar);
        this.W = dVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.X = handler;
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.Y = handler2;
        u4 u4Var = new u4(handler, this.f62203b);
        this.Z = u4Var;
        this.f64135a0 = new u4(handler2, this.f62203b);
        boolean zK0 = this.f62202a.K0();
        this.f64136b0 = zK0;
        this.f64137c0 = yp.e(this.f62203b);
        this.f64140f0 = -1;
        this.f64143i0 = new AtomicBoolean();
        this.f64144j0 = new AtomicBoolean();
        this.f64145k0 = -2L;
        this.f64146l0 = 0L;
        if (!bVar.hasVideoUrl()) {
            throw new IllegalStateException("Attempting to use fullscreen video ad presenter for non-video ad");
        }
        AppLovinVideoView appLovinVideoView = new AppLovinVideoView(activity);
        this.M = appLovinVideoView;
        appLovinVideoView.setOnPreparedListener(eVar);
        appLovinVideoView.setOnCompletionListener(eVar);
        appLovinVideoView.setOnErrorListener(eVar);
        appLovinVideoView.setOnTouchListener(new AppLovinTouchToClickListener(jVar, sj.f63754j0, activity, eVar));
        bVar.e().putString("video_view_address", zq.a(appLovinVideoView));
        f fVar = new f(this, aVar);
        if (bVar.m0() >= 0) {
            com.applovin.impl.adview.g gVar = new com.applovin.impl.adview.g(bVar.d0(), activity);
            this.O = gVar;
            gVar.setVisibility(8);
            gVar.setOnClickListener(fVar);
        } else {
            this.O = null;
        }
        if (a(this.f64137c0, jVar)) {
            ImageView imageView = new ImageView(activity);
            this.Q = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setClickable(true);
            imageView.setOnClickListener(fVar);
            d(this.f64137c0);
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
            oVar.setColor(Color.parseColor("#75FFFFFF"));
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
        if (!bVar.t0()) {
            this.S = null;
            return;
        }
        Long l3 = (Long) jVar.a(sj.t2);
        Integer num = (Integer) jVar.a(sj.u2);
        ProgressBar progressBar = new ProgressBar(activity, null, R.attr.progressBarStyleHorizontal);
        this.S = progressBar;
        a(progressBar, bVar.s0(), num.intValue());
        u4Var.a("PROGRESS_BAR", l3.longValue(), new b(num));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K() {
        this.f62216p = SystemClock.elapsedRealtime();
    }

    private void L() {
        com.applovin.impl.adview.l lVar;
        qq qqVarK0 = this.f62202a.k0();
        if (qqVarK0 == null || !qqVarK0.j() || this.f64141g0 || (lVar = this.R) == null) {
            return;
        }
        final boolean z2 = lVar.getVisibility() == 4;
        final long jH = qqVarK0.h();
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.i60
            @Override // java.lang.Runnable
            public final void run() {
                this.f60363a.b(z2, jH);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        if (this.f64141g0) {
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
        if (this.f64140f0 < 0) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f62204c.a("AppLovinFullscreenActivity", "Invalid last video position");
                return;
            }
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.a("AppLovinFullscreenActivity", "Resuming video at position " + this.f64140f0 + "ms for MediaPlayer: " + this.L);
        }
        this.M.seekTo(this.f64140f0);
        this.M.start();
        this.Z.b();
        this.f64140f0 = -1;
        a(new Runnable() { // from class: com.applovin.impl.l60
            @Override // java.lang.Runnable
            public final void run() {
                this.f61158a.G();
            }
        }, 250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        if (this.f64144j0.compareAndSet(false, true)) {
            a(this.O, this.f62202a.m0(), new Runnable() { // from class: com.applovin.impl.k60
                @Override // java.lang.Runnable
                public final void run() {
                    this.f60938a.H();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        this.K.a(this.f62212l);
        this.f62216p = SystemClock.elapsedRealtime();
    }

    private void e(boolean z2) {
        this.f64139e0 = A();
        if (z2) {
            this.M.pause();
        } else {
            this.M.stopPlayback();
        }
    }

    protected void N() {
        long jW;
        long millis;
        if (this.f62202a.V() >= 0 || this.f62202a.W() >= 0) {
            if (this.f62202a.V() >= 0) {
                jW = this.f62202a.V();
            } else {
                com.applovin.impl.sdk.ad.a aVar = (com.applovin.impl.sdk.ad.a) this.f62202a;
                long j3 = this.f64138d0;
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

    protected boolean P() {
        return (this.f62221u || this.f64141g0 || !this.M.isPlaying()) ? false : true;
    }

    protected boolean Q() {
        return k() && !D();
    }

    protected void S() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.m60
            @Override // java.lang.Runnable
            public final void run() {
                this.f61382a.J();
            }
        });
    }

    public void T() {
        u9 u9Var;
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.a("AppLovinFullscreenActivity", "Showing postitial...");
        }
        e(this.f62202a.j1());
        long jU = this.f62202a.U();
        if (jU > 0) {
            this.f62217q = 0L;
            Long l3 = (Long) this.f62203b.a(sj.C2);
            Integer num = (Integer) this.f62203b.a(sj.F2);
            ProgressBar progressBar = new ProgressBar(this.f62205d, null, R.attr.progressBarStyleHorizontal);
            this.T = progressBar;
            a(progressBar, this.f62202a.T(), num.intValue());
            u9Var = this;
            this.f64135a0.a("POSTITIAL_PROGRESS_BAR", l3.longValue(), u9Var.new c(jU, num, l3));
            u9Var.f64135a0.b();
        } else {
            u9Var = this;
        }
        u9Var.K.a(u9Var.f62211k, u9Var.f62210j, u9Var.f62209i, u9Var.T);
        a("javascript:al_onPoststitialShow(" + u9Var.f62224x + "," + u9Var.f62225y + ");", u9Var.f62202a.D());
        if (u9Var.f62211k != null) {
            if (u9Var.f62202a.p() >= 0) {
                a(u9Var.f62211k, u9Var.f62202a.p(), new Runnable() { // from class: com.applovin.impl.j60
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f60621a.K();
                    }
                });
            } else {
                u9Var.f62211k.setVisibility(0);
            }
        }
        ArrayList arrayList = new ArrayList();
        com.applovin.impl.adview.g gVar = u9Var.f62211k;
        if (gVar != null) {
            arrayList.add(new ng(gVar, FriendlyObstructionPurpose.CLOSE_AD, "close button"));
        }
        com.applovin.impl.adview.k kVar = u9Var.f62210j;
        if (kVar != null && kVar.a()) {
            com.applovin.impl.adview.k kVar2 = u9Var.f62210j;
            arrayList.add(new ng(kVar2, FriendlyObstructionPurpose.NOT_VISIBLE, kVar2.getIdentifier()));
        }
        ProgressBar progressBar2 = u9Var.T;
        if (progressBar2 != null) {
            arrayList.add(new ng(progressBar2, FriendlyObstructionPurpose.OTHER, "postitial progress bar"));
        }
        u9Var.f62202a.getAdEventTracker().b(u9Var.f62209i, arrayList);
        r();
        u9Var.f64141g0 = true;
    }

    public void U() {
        this.f64145k0 = SystemClock.elapsedRealtime() - this.f64146l0;
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.a("AppLovinFullscreenActivity", "Attempting to skip video with skip time: " + this.f64145k0 + "ms");
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
        MediaPlayer mediaPlayer = this.L;
        if (mediaPlayer == null) {
            return;
        }
        try {
            float f3 = this.f64137c0 ? 1.0f : 0.0f;
            mediaPlayer.setVolume(f3, f3);
            boolean z2 = !this.f64137c0;
            this.f64137c0 = z2;
            d(z2);
            a(this.f64137c0, 0L);
        } catch (Throwable unused) {
        }
    }

    @Override // com.applovin.impl.o9
    public void f() {
        this.Z.a();
        this.f64135a0.a();
        this.X.removeCallbacksAndMessages(null);
        this.Y.removeCallbacksAndMessages(null);
        o();
        super.f();
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorEntity
    public String getCommunicatorId() {
        return "FullscreenVideoAdPresenter";
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
        if (!k() || this.f64141g0) {
            R();
        }
    }

    @Override // com.applovin.impl.o9
    protected void o() {
        super.a(A(), this.f64136b0, D(), this.f64145k0);
    }

    @Override // com.applovin.communicator.AppLovinCommunicatorSubscriber
    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("video_caching_failed".equals(appLovinCommunicatorMessage.getTopic())) {
            Bundle messageData = appLovinCommunicatorMessage.getMessageData();
            if (messageData.getLong("ad_id") == this.f62202a.getAdIdNumber() && this.f64136b0) {
                int i3 = messageData.getInt("load_response_code");
                String string = messageData.getString("load_exception_message");
                if ((string == null && i3 >= 200 && i3 < 300) || this.f64142h0 || this.M.isPlaying()) {
                    return;
                }
                d("Video cache error during stream. ResponseCode=" + i3 + ", exception=" + string);
            }
        }
    }

    @Override // com.applovin.impl.o9
    public void t() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.d("AppLovinFullscreenActivity", "Destroying video components");
        }
        try {
            if (((Boolean) this.f62203b.a(sj.b6)).booleanValue()) {
                tr.d(this.R);
                this.R = null;
            }
            if (this.f64136b0) {
                AppLovinCommunicator.getInstance(this.f62205d).unsubscribe(this, "video_caching_failed");
            }
            AppLovinVideoView appLovinVideoView = this.M;
            if (appLovinVideoView != null) {
                appLovinVideoView.pause();
                this.M.stopPlayback();
            }
            MediaPlayer mediaPlayer = this.L;
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("AppLovinFullscreenActivity", "Unable to destroy presenter", th);
        }
        super.t();
    }

    @Override // com.applovin.impl.o9
    public void x() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.a("AppLovinFullscreenActivity", "Pausing video");
        }
        this.f64140f0 = this.M.getCurrentPosition();
        this.M.pause();
        this.Z.c();
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.a("AppLovinFullscreenActivity", "Paused video at position " + this.f64140f0 + "ms");
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
        o oVar = this.N;
        if (oVar != null) {
            oVar.a();
            final o oVar2 = this.N;
            Objects.requireNonNull(oVar2);
            a(new Runnable() { // from class: com.applovin.impl.g60
                @Override // java.lang.Runnable
                public final void run() {
                    oVar2.b();
                }
            }, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H() {
        this.f64145k0 = -1L;
        this.f64146l0 = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I() {
        a(250L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J() {
        o oVar = this.N;
        if (oVar != null) {
            oVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(boolean z2, long j3) {
        if (z2) {
            zq.a(this.R, j3, (Runnable) null);
        } else {
            zq.b(this.R, j3, null);
        }
    }

    protected int A() {
        long currentPosition = this.M.getCurrentPosition();
        if (this.f64142h0) {
            return 100;
        }
        return currentPosition > 0 ? (int) ((currentPosition / this.f64138d0) * 100.0f) : this.f64139e0;
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
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.n60
            @Override // java.lang.Runnable
            public final void run() {
                this.f61984a.F();
            }
        });
    }

    protected boolean D() {
        if (this.H && this.f62202a.c1()) {
            return true;
        }
        return E();
    }

    protected boolean E() {
        return A() >= this.f62202a.o0();
    }

    protected void c(long j3) {
        this.f64138d0 = j3;
    }

    protected void d(String str) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.b("AppLovinFullscreenActivity", "Encountered media error: " + str + " for ad: " + this.f62202a);
        }
        if (this.f64143i0.compareAndSet(false, true)) {
            if (yp.a(sj.O0, this.f62203b)) {
                this.f62203b.A().d(this.f62202a, com.applovin.impl.sdk.j.m());
            }
            AppLovinAdDisplayListener appLovinAdDisplayListener = this.C;
            if (appLovinAdDisplayListener instanceof pb) {
                ((pb) appLovinAdDisplayListener).onAdDisplayFailed(str);
            }
            this.f62203b.D().a(this.f62202a instanceof aq ? "handleVastVideoError" : "handleVideoError", str, this.f62202a);
            f();
        }
    }

    @Override // com.applovin.impl.jb.a
    public void c() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f62204c.a(MrGIhy.dvkduij, "Continue video from prompt - will resume in onWindowFocusChanged(true) when alert dismisses");
        }
    }

    protected void a(MotionEvent motionEvent, Bundle bundle) {
        Context context;
        if (this.f62202a.J0()) {
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
                return;
            }
            return;
        }
        L();
    }

    @Override // com.applovin.impl.o9
    public void b(boolean z2) {
        super.b(z2);
        if (z2) {
            a(0L);
            if (this.f64141g0) {
                this.f64135a0.b();
                return;
            }
            return;
        }
        if (this.f64141g0) {
            this.f64135a0.c();
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

    private void d(boolean z2) {
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

    private static boolean a(boolean z2, com.applovin.impl.sdk.j jVar) {
        if (!((Boolean) jVar.a(sj.f63764l2)).booleanValue()) {
            return false;
        }
        if (!((Boolean) jVar.a(sj.f63768m2)).booleanValue() || z2) {
            return true;
        }
        return ((Boolean) jVar.a(sj.f63776o2)).booleanValue();
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
        a(new Runnable() { // from class: com.applovin.impl.h60
            @Override // java.lang.Runnable
            public final void run() {
                this.f60139a.a(str);
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
        String str;
        this.K.a(this.Q, this.O, this.R, this.N, this.S, this.P, this.M, this.f62209i, this.f62210j, this.U, viewGroup);
        if (z3.i() && (str = this.f62203b.f0().getExtraParameters().get("audio_focus_request")) != null) {
            this.M.setAudioFocusRequest(Integer.parseInt(str));
        }
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        if (a(!this.f64136b0)) {
            return;
        }
        this.M.setVideoURI(this.f62202a.u0());
        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        if (this.f62202a.f1()) {
            this.E.b(this.f62202a, new Runnable() { // from class: com.applovin.impl.o60
                @Override // java.lang.Runnable
                public final void run() {
                    this.f62195a.I();
                }
            });
        }
        com.applovin.impl.adview.k kVar = this.f62210j;
        if (kVar != null) {
            kVar.b();
        }
        this.M.start();
        if (this.f64136b0) {
            S();
        }
        this.f62209i.renderAd(this.f62202a);
        if (this.O != null) {
            this.f62203b.i0().a(new jn(this.f62203b, "scheduleSkipButton", new Runnable() { // from class: com.applovin.impl.f60
                @Override // java.lang.Runnable
                public final void run() {
                    this.f59637a.O();
                }
            }), tm.b.TIMEOUT, this.f62202a.n0(), true);
        }
        super.c(this.f64137c0);
    }

    @Override // com.applovin.impl.o9
    public void a(long j3) {
        a(new Runnable() { // from class: com.applovin.impl.e60
            @Override // java.lang.Runnable
            public final void run() {
                this.f59372a.M();
            }
        }, j3);
    }
}
