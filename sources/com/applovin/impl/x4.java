package com.applovin.impl;

import android.R;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.applovin.creative.MaxCreativeDebuggerActivity;
import com.applovin.creative.MaxCreativeDebuggerDisplayedAdActivity;
import com.applovin.impl.r;
import com.applovin.impl.r6;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class x4 implements r6.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static WeakReference f64796m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final AtomicBoolean f64797n = new AtomicBoolean();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f64798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f64799b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final w4 f64802e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private r6 f64804g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private go f64805h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f64806i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f64807j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f64808k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f64809l;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f64800c = new ArrayList(10);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f64801d = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private WeakReference f64803f = new WeakReference(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends p {
        a() {
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof MaxCreativeDebuggerActivity) {
                com.applovin.impl.sdk.n.g("AppLovinSdk", "Started Creative Debugger");
                if (!x4.this.h() || x4.f64796m.get() != activity) {
                    MaxCreativeDebuggerActivity maxCreativeDebuggerActivity = (MaxCreativeDebuggerActivity) activity;
                    WeakReference unused = x4.f64796m = new WeakReference(maxCreativeDebuggerActivity);
                    maxCreativeDebuggerActivity.a(x4.this.f64802e, x4.this.f64798a.e());
                }
                x4.f64797n.set(false);
            }
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (activity instanceof MaxCreativeDebuggerActivity) {
                com.applovin.impl.sdk.n.g("AppLovinSdk", "Creative Debugger destroyed");
                WeakReference unused = x4.f64796m = null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b implements r.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f64811a;

        b(Object obj) {
            this.f64811a = obj;
        }

        @Override // com.applovin.impl.r.b
        public void a(MaxCreativeDebuggerDisplayedAdActivity maxCreativeDebuggerDisplayedAdActivity) {
            maxCreativeDebuggerDisplayedAdActivity.a(new v6(this.f64811a, x4.this.f64798a.B().b()), x4.this.f64798a);
            x4.f64797n.set(false);
        }
    }

    public x4(com.applovin.impl.sdk.j jVar) {
        this.f64798a = jVar;
        Context contextM = com.applovin.impl.sdk.j.m();
        this.f64799b = contextM;
        this.f64802e = new w4(contextM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        this.f64806i = 0;
    }

    private void m() {
        this.f64798a.e().a(new a());
    }

    public void k() {
        r6 r6Var = this.f64804g;
        if (r6Var != null) {
            r6Var.b();
        }
    }

    public void l() {
        if (g()) {
            this.f64807j = ((Boolean) this.f64798a.a(sj.f63790s1)).booleanValue();
            if (this.f64804g == null) {
                this.f64804g = new r6(this.f64798a, this);
            }
            this.f64804g.a();
        }
    }

    public void n() {
        ArrayList arrayList;
        if (h() || !f64797n.compareAndSet(false, true)) {
            com.applovin.impl.sdk.n.h("AppLovinSdk", "Creative Debugger is already showing");
            return;
        }
        Object objA = this.f64798a.B().a();
        if (objA != null) {
            e(objA);
            return;
        }
        synchronized (this.f64801d) {
            arrayList = new ArrayList(this.f64800c);
        }
        this.f64802e.a(arrayList, this.f64798a);
        if (!this.f64809l) {
            m();
            this.f64809l = true;
        }
        com.applovin.impl.sdk.n.g("AppLovinSdk", "Starting Creative Debugger...");
        r.a(this.f64799b, MaxCreativeDebuggerActivity.class);
    }

    private boolean c(Object obj) {
        MaxAdFormat maxAdFormatD = obj instanceof com.applovin.impl.sdk.ad.b ? ((com.applovin.impl.sdk.ad.b) obj).getAdZone().d() : obj instanceof fe ? ((fe) obj).getFormat() : null;
        return maxAdFormatD != null && maxAdFormatD.isFullscreenAd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (g() && this.f64803f.get() == null && !h()) {
            Activity activityB = this.f64798a.e().b();
            if (activityB == null) {
                this.f64798a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f64798a.I().b("AppLovinSdk", "Failed to display Creative Debugger button");
                }
            } else {
                View viewFindViewById = activityB.findViewById(R.id.content);
                if (viewFindViewById instanceof FrameLayout) {
                    final FrameLayout frameLayout = (FrameLayout) viewFindViewById;
                    final View viewA = a(frameLayout, activityB);
                    frameLayout.addView(viewA);
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(150L);
                    viewA.startAnimation(alphaAnimation);
                    final ViewTreeObserver viewTreeObserver = viewFindViewById.getViewTreeObserver();
                    final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.applovin.impl.h80
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public final void onGlobalLayout() {
                            this.f60150a.a(viewA, frameLayout);
                        }
                    };
                    viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
                    AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.i80
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f60368a.a(viewA, frameLayout, viewTreeObserver, onGlobalLayoutListener);
                        }
                    }, TimeUnit.SECONDS.toMillis(5L));
                    this.f64803f = new WeakReference(viewA);
                }
            }
        }
    }

    private Drawable f() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.rgb(5, 131, 170));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(1);
        gradientDrawable2.setColor(Color.rgb(2, 98, 127));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        WeakReference weakReference = f64796m;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        long seconds = TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime() - this.f64808k);
        if (this.f64808k == 0 || seconds < 10) {
            return;
        }
        this.f64798a.D().a(ka.f60950d, "showingMediationDebuggerFromHoldingCreativeDebuggerButton");
        this.f64798a.T0();
    }

    public String b(Object obj) {
        JSONObject jSONObjectA;
        if (obj instanceof com.applovin.impl.sdk.ad.b) {
            return ((com.applovin.impl.sdk.ad.b) obj).getOriginalFullResponse().toString();
        }
        if (!(obj instanceof fe)) {
            return null;
        }
        String strD = ((fe) obj).D();
        return (!ze.b(obj) || (jSONObjectA = new w(strD, this.f64798a).a()) == null) ? strD : jSONObjectA.toString();
    }

    public void d(Object obj) {
        if (g() && obj != null) {
            if (!ze.a(obj) || c(obj)) {
                if (ze.b(obj) && c(obj)) {
                    return;
                }
                synchronized (this.f64801d) {
                    try {
                        this.f64800c.add(0, new v6(obj, System.currentTimeMillis()));
                        if (this.f64800c.size() > 10) {
                            this.f64800c.remove(r6.size() - 1);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    public boolean g() {
        return ((Boolean) this.f64798a.a(sj.f63787r1)).booleanValue() && this.f64798a.f0().isCreativeDebuggerEnabled();
    }

    private View a(final FrameLayout frameLayout, Activity activity) {
        View view;
        int iDpToPx = AppLovinSdkUtils.dpToPx(activity, 40);
        int i3 = iDpToPx / 10;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iDpToPx, iDpToPx, 8388629);
        layoutParams.setMargins(i3, i3, i3, i3);
        try {
            ImageButton imageButton = new ImageButton(activity);
            imageButton.setImageDrawable(activity.getResources().getDrawable(com.applovin.sdk.R.drawable.applovin_ic_white_small));
            imageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageButton.setPadding(i3, i3, i3, i3 * 2);
            view = imageButton;
        } catch (Throwable unused) {
            Button button = new Button(activity);
            button.setText("ⓘ");
            button.setTextColor(-1);
            button.setAllCaps(false);
            button.setTextSize(2, 20.0f);
            button.setPadding(0, 0, 0, 0);
            view = button;
        }
        view.setLayoutParams(layoutParams);
        view.setBackground(f());
        if (this.f64807j) {
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.applovin.impl.j80
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    return this.f60679a.a(frameLayout, view2, motionEvent);
                }
            });
        } else {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.k80
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f60941a.a(view2);
                }
            });
        }
        if (z3.f()) {
            view.setElevation(AppLovinSdkUtils.dpToPx(activity, 5));
        }
        return view;
    }

    @Override // com.applovin.impl.r6.a
    public void b() {
        if (this.f64806i == 0) {
            this.f64805h = go.a(TimeUnit.SECONDS.toMillis(3L), this.f64798a, new Runnable() { // from class: com.applovin.impl.l80
                @Override // java.lang.Runnable
                public final void run() {
                    this.f61167a.j();
                }
            });
        }
        int i3 = this.f64806i;
        if (i3 % 2 == 0) {
            this.f64806i = i3 + 1;
        }
    }

    private void b(View view, FrameLayout frameLayout) {
        if (this.f64807j) {
            view.setOnTouchListener(null);
            this.f64808k = 0L;
        }
        frameLayout.removeView(view);
        this.f64803f = new WeakReference(null);
    }

    private void e(Object obj) {
        com.applovin.impl.sdk.n.g("AppLovinSdk", "Starting Creative Debugger for current fullscreen ad...");
        r.a(this.f64799b, MaxCreativeDebuggerDisplayedAdActivity.class, this.f64798a.e(), new b(obj));
    }

    public void a(v6 v6Var, Context context, boolean z2) {
        Object objA = v6Var.a();
        String strA = a(v6Var);
        pc pcVar = new pc();
        if (z2) {
            pcVar.b("Please describe the issue you had with this ad:\n\n\n\n");
        }
        pcVar.b(strA);
        String strB = this.f64798a.v().b(objA);
        if (strB != null) {
            pcVar.a("\nBid Response:\n");
            pcVar.a(strB);
        }
        Intent intentCreateChooser = Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.SUBJECT", objA instanceof com.applovin.impl.sdk.ad.b ? "AppLovin Ad Report" : "MAX Ad Report").putExtra("android.intent.extra.TEXT", pcVar.toString()).setPackage(null), "Share Ad Report");
        if (z2) {
            try {
                context.startActivity(new Intent("android.intent.action.SENDTO", Uri.parse("mailto:")).putExtra("android.intent.extra.SUBJECT", objA instanceof com.applovin.impl.sdk.ad.b ? "AppLovin Ad Report" : "MAX Ad Report").putExtra("android.intent.extra.TEXT", pcVar.toString()).setPackage("com.google.android.gm"));
                return;
            } catch (ActivityNotFoundException unused) {
                context.startActivity(intentCreateChooser);
                return;
            }
        }
        context.startActivity(intentCreateChooser);
    }

    public String a(v6 v6Var) {
        Object objA = v6Var.a();
        pc pcVar = new pc();
        pcVar.b("Ad Info:\n");
        if (objA instanceof com.applovin.impl.sdk.ad.b) {
            com.applovin.impl.sdk.ad.b bVar = (com.applovin.impl.sdk.ad.b) objA;
            pcVar.a("Network", "APPLOVIN").a(bVar).b(bVar);
        } else if (objA instanceof fe) {
            pcVar.a((fe) objA);
        }
        pcVar.a(this.f64798a);
        pcVar.a("Epoch Timestamp (ms)", Long.valueOf(v6Var.b()));
        pcVar.a("\nDebug Info:\n").a("Platform", "fireos".equals(this.f64798a.x().w()) ? "Fire OS" : "Android").a("AppLovin SDK Version", AppLovinSdk.VERSION).a("Plugin Version", this.f64798a.a(sj.K3)).a("App Package Name", this.f64799b.getPackageName()).a("Device", String.format("%s %s (%s)", Build.BRAND, Build.MODEL, Build.DEVICE)).a("OS Version", Build.VERSION.RELEASE).a("AppLovin Random Token", this.f64798a.Z()).a("Ad Review Version", v.b()).a(a(objA)).a("User ID", this.f64798a.o0().c() != null ? this.f64798a.o0().c() : "None").a("MD", this.f64798a.a(sj.f63797v));
        return pcVar.toString();
    }

    private Bundle a(Object obj) {
        this.f64798a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f64798a.I().a("CreativeDebuggerService", "Retrieving Ad Review info for ad: " + obj);
        }
        String strA = yp.a(obj);
        Bundle bundleA = this.f64798a.i().a(strA);
        this.f64798a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f64798a.I().a("CreativeDebuggerService", "Serve id: " + strA);
        }
        this.f64798a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f64798a.I().a("CreativeDebuggerService", "Public data: " + bundleA);
        }
        if (bundleA == null) {
            return null;
        }
        for (String str : bundleA.keySet()) {
            Object obj2 = bundleA.get(str);
            bundleA.remove(str);
            BundleUtils.put(StringUtils.toHumanReadableString(str), obj2, bundleA);
        }
        return bundleA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view, FrameLayout frameLayout) {
        if (view.getParent() != null || this.f64803f.get() == null) {
            return;
        }
        frameLayout.addView(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view, FrameLayout frameLayout, ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (this.f64808k > 0 && this.f64807j) {
            view.setVisibility(4);
        } else {
            b(view, frameLayout);
        }
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(FrameLayout frameLayout, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f64808k = SystemClock.elapsedRealtime();
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.f80
                @Override // java.lang.Runnable
                public final void run() {
                    this.f59639a.i();
                }
            }, TimeUnit.SECONDS.toMillis(10L));
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (view.getVisibility() == 0) {
                this.f64808k = 0L;
                n();
            } else {
                b(view, frameLayout);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        n();
    }

    @Override // com.applovin.impl.r6.a
    public void a() {
        int i3 = this.f64806i;
        if (i3 % 2 == 1) {
            this.f64806i = i3 + 1;
        }
        if (this.f64806i / 2 == 2) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.g80
                @Override // java.lang.Runnable
                public final void run() {
                    this.f59891a.e();
                }
            });
            this.f64806i = 0;
            this.f64805h.a();
        }
    }
}
