package com.applovin.impl.adview;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.applovin.impl.adview.e;
import com.applovin.impl.s6;
import com.applovin.impl.sj;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class f extends Dialog implements s6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f58343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f58344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f58345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f58346d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.applovin.impl.sdk.ad.a f58347f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private RelativeLayout f58348g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private e f58349h;

    f(com.applovin.impl.sdk.ad.a aVar, b bVar, Activity activity, com.applovin.impl.sdk.j jVar) {
        super(activity, R.style.Theme.Translucent.NoTitleBar);
        if (aVar == null) {
            throw new IllegalArgumentException("No ad specified");
        }
        if (bVar == null) {
            throw new IllegalArgumentException("No main view specified");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        }
        this.f58344b = jVar;
        this.f58345c = jVar.I();
        this.f58343a = activity;
        this.f58346d = bVar;
        this.f58347f = aVar;
        requestWindowFeature(1);
        setCancelable(false);
    }

    private void g() {
        this.f58343a.runOnUiThread(new Runnable() { // from class: com.applovin.impl.adview.j0
            @Override // java.lang.Runnable
            public final void run() {
                this.f58362a.f();
            }
        });
    }

    @Override // android.app.Dialog, android.content.DialogInterface, com.applovin.impl.s6
    public void dismiss() {
        this.f58343a.runOnUiThread(new Runnable() { // from class: com.applovin.impl.adview.k0
            @Override // java.lang.Runnable
            public final void run() {
                this.f58365a.e();
            }
        });
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        this.f58346d.a("javascript:al_onBackPressed();");
        dismiss();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d();
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        try {
            Window window = getWindow();
            if (window != null) {
                window.setFlags(this.f58343a.getWindow().getAttributes().flags, this.f58343a.getWindow().getAttributes().flags);
                window.addFlags(16777216);
            } else if (com.applovin.impl.sdk.n.a()) {
                this.f58345c.b("ExpandedAdDialog", "Unable to turn on hardware acceleration - window is null");
            }
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f58345c.a("ExpandedAdDialog", "Setting window flags failed.", th);
            }
        }
    }

    private void a() {
        this.f58346d.a("javascript:al_onCloseTapped();");
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        if (this.f58349h.isClickable()) {
            this.f58349h.performClick();
        }
    }

    private void d() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.f58346d.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(this.f58343a);
        this.f58348g = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f58348g.setBackgroundColor(-1157627904);
        this.f58348g.addView(this.f58346d);
        if (!this.f58347f.r1()) {
            a(this.f58347f.k1());
            g();
        }
        setContentView(this.f58348g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.f58348g.removeView(this.f58346d);
        super.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        try {
            if (this.f58349h == null) {
                a();
            }
            this.f58349h.setVisibility(0);
            this.f58349h.bringToFront();
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setAnimationListener(new a());
            this.f58349h.startAnimation(alphaAnimation);
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f58345c.a("ExpandedAdDialog", "Unable to fade in close button", th);
            }
            a();
        }
    }

    public b c() {
        return this.f58346d;
    }

    private void a(e.a aVar) {
        if (this.f58349h != null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f58345c.k("ExpandedAdDialog", "Attempting to create duplicate close button");
                return;
            }
            return;
        }
        e eVarA = e.a(aVar, this.f58343a);
        this.f58349h = eVarA;
        eVarA.setVisibility(8);
        this.f58349h.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.adview.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f58354a.a(view);
            }
        });
        this.f58349h.setClickable(false);
        int iA = a(((Integer) this.f58344b.a(sj.H1)).intValue());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA, iA);
        layoutParams.addRule(10);
        com.applovin.impl.sdk.j jVar = this.f58344b;
        sj sjVar = sj.K1;
        layoutParams.addRule(((Boolean) jVar.a(sjVar)).booleanValue() ? 9 : 11);
        this.f58349h.a(iA);
        int iA2 = a(((Integer) this.f58344b.a(sj.J1)).intValue());
        int iA3 = a(((Integer) this.f58344b.a(sj.I1)).intValue());
        layoutParams.setMargins(iA3, iA2, iA3, 0);
        this.f58348g.addView(this.f58349h, layoutParams);
        this.f58349h.bringToFront();
        int iA4 = a(((Integer) this.f58344b.a(sj.L1)).intValue());
        View view = new View(this.f58343a);
        view.setBackgroundColor(0);
        int i3 = iA + iA4;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i3, i3);
        layoutParams2.addRule(10);
        layoutParams2.addRule(((Boolean) this.f58344b.a(sjVar)).booleanValue() ? 9 : 11);
        layoutParams2.setMargins(iA3 - a(5), iA2 - a(5), iA3 - a(5), 0);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.adview.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f58357a.b(view2);
            }
        });
        this.f58348g.addView(view, layoutParams2);
        view.bringToFront();
    }

    public com.applovin.impl.sdk.ad.a b() {
        return this.f58347f;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            f.this.f58349h.setClickable(true);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a();
    }

    private int a(int i3) {
        return AppLovinSdkUtils.dpToPx(this.f58343a, i3);
    }
}
