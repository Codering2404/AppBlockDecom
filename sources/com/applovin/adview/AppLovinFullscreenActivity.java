package com.applovin.adview;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.window.OnBackInvokedCallback;
import com.applovin.impl.adview.activity.FullscreenAdService;
import com.applovin.impl.la;
import com.applovin.impl.o9;
import com.applovin.impl.r;
import com.applovin.impl.s;
import com.applovin.impl.s6;
import com.applovin.impl.sb;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sj;
import com.applovin.impl.t9;
import com.applovin.impl.uj;
import com.applovin.impl.x1;
import com.applovin.impl.yp;
import com.applovin.impl.z3;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AppLovinFullscreenActivity extends Activity implements s6 {
    public static sb parentInterstitialWrapper;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private j f57860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private o9 f57861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f57862c = new AtomicBoolean(true);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.applovin.impl.adview.activity.a f57863d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f57864f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f57865g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private x1 f57866h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f57867i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class b implements OnBackInvokedCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Runnable f57869a;

        protected b(Runnable runnable) {
            this.f57869a = runnable;
        }

        public void onBackInvoked() {
            this.f57869a.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        o9 o9Var = this.f57861b;
        if (o9Var != null) {
            o9Var.s();
        }
        if (yp.e(getApplicationContext())) {
            super.onBackPressed();
        }
    }

    @Override // com.applovin.impl.s6
    public void dismiss() {
        if (z3.l() && this.f57864f != null) {
            getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.f57864f);
            this.f57864f = null;
        }
        o9 o9Var = this.f57861b;
        if (o9Var != null) {
            o9Var.f();
        } else {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        c();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        o9 o9Var = this.f57861b;
        if (o9Var != null) {
            o9Var.a(configuration);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null && parentInterstitialWrapper == null) {
            n.j("AppLovinFullscreenActivity", "Dismissing ad. Activity was destroyed while in background.");
            dismiss();
            return;
        }
        try {
            requestWindowFeature(1);
        } catch (Throwable th) {
            n.c("AppLovinFullscreenActivity", "Failed to request window feature", th);
        }
        getWindow().setFlags(1024, 1024);
        getWindow().addFlags(16777216);
        getWindow().addFlags(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
        View viewFindViewById = findViewById(R.id.content);
        viewFindViewById.setBackgroundColor(-16777216);
        String stringExtra = getIntent().getStringExtra("com.applovin.interstitial.sdk_key");
        if (TextUtils.isEmpty(stringExtra)) {
            sb sbVar = parentInterstitialWrapper;
            if (sbVar != null && sbVar.f() != null) {
                sb.a(parentInterstitialWrapper.f(), parentInterstitialWrapper.c(), "Empty SDK key", null, this);
            }
            finish();
            return;
        }
        j jVarA = AppLovinSdk.getInstance(stringExtra, new AppLovinSdkSettings(this), this).a();
        this.f57860a = jVarA;
        this.f57865g = ((Boolean) jVarA.a(sj.z2)).booleanValue();
        viewFindViewById.setFitsSystemWindows(true);
        r.a(this.f57865g, this);
        if (z3.l() && ((Boolean) this.f57860a.a(sj.Q5)).booleanValue()) {
            this.f57864f = new b(new Runnable() { // from class: com.applovin.adview.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f57875a.c();
                }
            });
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, this.f57864f);
        }
        a();
        b();
        sb sbVar2 = parentInterstitialWrapper;
        if (sbVar2 != null) {
            o9.a(sbVar2.f(), parentInterstitialWrapper.b(), parentInterstitialWrapper.c(), parentInterstitialWrapper.d(), parentInterstitialWrapper.h(), this.f57860a, this, new a());
            return;
        }
        Intent intent = new Intent(this, (Class<?>) FullscreenAdService.class);
        com.applovin.impl.adview.activity.a aVar = new com.applovin.impl.adview.activity.a(this, this.f57860a);
        this.f57863d = aVar;
        bindService(intent, aVar, 1);
        if (z3.j()) {
            String str = this.f57860a.f0().getExtraParameters().get("disable_set_data_dir_suffix");
            if (StringUtils.isValidString(str) && Boolean.parseBoolean(str)) {
                return;
            }
            try {
                WebView.setDataDirectorySuffix(String.valueOf(Process.myPid()));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        j jVar = this.f57860a;
        if (jVar != null && ((Boolean) jVar.a(sj.f63744g2)).booleanValue()) {
            this.f57860a.h0().b(uj.M);
            this.f57860a.h0().b(uj.O);
            this.f57860a.h0().b(uj.P);
        }
        if (this.f57866h != null) {
            this.f57860a.h0().b(uj.N);
            this.f57866h.a();
            this.f57866h = null;
        }
        com.applovin.impl.adview.activity.a aVar = this.f57863d;
        if (aVar != null) {
            try {
                unbindService(aVar);
            } catch (Throwable unused) {
            }
        }
        o9 o9Var = this.f57861b;
        if (o9Var != null) {
            if (!o9Var.j()) {
                this.f57861b.f();
            }
            this.f57861b.t();
        }
        parentInterstitialWrapper = null;
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        o9 o9Var = this.f57861b;
        if (o9Var != null) {
            o9Var.a(i3, keyEvent);
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        o9 o9Var = this.f57861b;
        if (o9Var != null) {
            o9Var.u();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        o9 o9Var;
        try {
            super.onResume();
            if (this.f57862c.get() || (o9Var = this.f57861b) == null) {
                return;
            }
            o9Var.v();
        } catch (IllegalArgumentException e3) {
            this.f57860a.I();
            if (n.a()) {
                this.f57860a.I().a("AppLovinFullscreenActivity", "Error was encountered in onResume().", e3);
            }
            this.f57860a.D().a("AppLovinFullscreenActivity", "onResume", e3);
            dismiss();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        o9 o9Var = this.f57861b;
        if (o9Var != null) {
            o9Var.w();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z2) {
        if (this.f57861b != null) {
            if (!this.f57862c.getAndSet(false) || (this.f57861b instanceof t9)) {
                this.f57861b.b(z2);
            }
            if (z2) {
                r.a(this.f57865g, this);
            }
        }
        super.onWindowFocusChanged(z2);
    }

    public void setPresenter(o9 o9Var) {
        this.f57861b = o9Var;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements o9.d {
        a() {
        }

        @Override // com.applovin.impl.o9.d
        public void a(o9 o9Var) {
            AppLovinFullscreenActivity.this.f57861b = o9Var;
            o9Var.y();
        }

        @Override // com.applovin.impl.o9.d
        public void a(String str, Throwable th) {
            sb.a(AppLovinFullscreenActivity.parentInterstitialWrapper.f(), AppLovinFullscreenActivity.parentInterstitialWrapper.c(), str, th, AppLovinFullscreenActivity.this);
        }
    }

    private void b() {
        j jVar = this.f57860a;
        if (jVar == null || !((Boolean) jVar.a(sj.f63748h2)).booleanValue()) {
            return;
        }
        final Long l3 = (Long) this.f57860a.a(sj.f63752i2);
        this.f57866h = x1.a(l3.longValue(), true, this.f57860a, new Runnable() { // from class: com.applovin.adview.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f57876a.a(l3);
            }
        });
    }

    private void a() {
        sb sbVar;
        j jVar = this.f57860a;
        if (jVar == null || !((Boolean) jVar.a(sj.f63744g2)).booleanValue() || (sbVar = parentInterstitialWrapper) == null || sbVar.f() == null) {
            return;
        }
        com.applovin.impl.sdk.ad.b bVarF = parentInterstitialWrapper.f();
        List listG = bVarF.g();
        if (CollectionUtils.isEmpty(listG)) {
            return;
        }
        s sVar = (s) listG.get(0);
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putStringIfValid(jSONObject, "app_killed_postback_url", sVar.c());
        JsonUtils.putStringIfValid(jSONObject, "app_killed_postback_backup_url", sVar.a());
        this.f57860a.h0().b(uj.O, jSONObject.toString());
        this.f57860a.h0().b(uj.M, Long.valueOf(System.currentTimeMillis()));
        this.f57860a.h0().b(uj.P, CollectionUtils.toJsonString(la.a(bVarF), JsonUtils.EMPTY_JSON));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Long l3) {
        this.f57867i += l3.longValue();
        this.f57860a.h0().b(uj.N, Long.valueOf(this.f57867i));
    }
}
