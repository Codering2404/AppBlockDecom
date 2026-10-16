package com.applovin.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.adview.AppLovinFullscreenAdViewObserver;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.o9;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class sb implements AppLovinInterstitialAdDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.applovin.impl.sdk.j f63012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakReference f63013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f63014c = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile AppLovinAdLoadListener f63015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile AppLovinAdDisplayListener f63016e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile AppLovinAdVideoPlaybackListener f63017f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile AppLovinAdClickListener f63018g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile com.applovin.impl.sdk.ad.b f63019h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements AppLovinAdLoadListener {
        a() {
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void adReceived(AppLovinAd appLovinAd) {
            sb.this.b(appLovinAd);
            sb.this.showAndRender(appLovinAd);
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void failedToReceiveAd(int i3) {
            sb.this.b(i3);
        }
    }

    public sb(AppLovinSdk appLovinSdk, Context context) {
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        this.f63012a = appLovinSdk.a();
        this.f63013b = new WeakReference(context);
    }

    private void i() {
        if (this.f63012a.e().a() == null) {
            this.f63012a.C().c(ba.f58620r);
        }
    }

    public Map h() {
        return this.f63014c;
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.f63018g = appLovinAdClickListener;
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f63016e = appLovinAdDisplayListener;
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f63015d = appLovinAdLoadListener;
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f63017f = appLovinAdVideoPlaybackListener;
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void setExtraInfo(String str, Object obj) {
        if (str == null) {
            throw new IllegalArgumentException("No key specified");
        }
        this.f63014c.put(str, obj);
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void show() {
        a(new a());
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void showAndRender(AppLovinAd appLovinAd) {
        AppLovinAd appLovinAdA = yp.a(appLovinAd, this.f63012a);
        Context contextE = e();
        String strA = a(appLovinAdA, appLovinAd, contextE);
        if (StringUtils.isValidString(strA)) {
            a(appLovinAd, strA);
        } else {
            a((com.applovin.impl.sdk.ad.b) appLovinAdA, contextE);
        }
    }

    public String toString() {
        return "AppLovinInterstitialAdDialog{}";
    }

    private Context e() {
        return (Context) this.f63013b.get();
    }

    private long g() {
        String str = this.f63012a.f0().getExtraParameters().get("fullscreen_ad_display_delay_enabled");
        if (str == null || Boolean.parseBoolean(str)) {
            return Math.max(0L, ((Long) this.f63012a.a(sj.f63729c2)).longValue());
        }
        return 0L;
    }

    public AppLovinAdDisplayListener c() {
        return this.f63016e;
    }

    public AppLovinAdVideoPlaybackListener d() {
        return this.f63017f;
    }

    public com.applovin.impl.sdk.ad.b f() {
        return this.f63019h;
    }

    public AppLovinAdClickListener b() {
        return this.f63018g;
    }

    private void b(Context context) {
        Intent intent = new Intent(context, (Class<?>) AppLovinFullscreenActivity.class);
        intent.putExtra("com.applovin.interstitial.sdk_key", this.f63012a.a0());
        AppLovinFullscreenActivity.parentInterstitialWrapper = this;
        if (this.f63012a.e().a() == null && ((Boolean) this.f63012a.a(sj.B2)).booleanValue()) {
            intent.addFlags(8388608);
        }
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        if (context instanceof Activity) {
            context.startActivity(intent);
            ((Activity) context).overridePendingTransition(0, 0);
        } else {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
    }

    public void a() {
        this.f63018g = null;
        this.f63015d = null;
        this.f63017f = null;
        this.f63016e = null;
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void showAndRender(AppLovinAd appLovinAd, ViewGroup viewGroup, Lifecycle lifecycle) {
        if (viewGroup != null && lifecycle != null) {
            AppLovinAd appLovinAdA = yp.a(appLovinAd, this.f63012a);
            Context contextE = e();
            String strA = a(appLovinAdA, appLovinAd, contextE);
            if (StringUtils.isValidString(strA)) {
                a(appLovinAd, strA);
                return;
            }
            AppLovinFullscreenAdViewObserver appLovinFullscreenAdViewObserver = new AppLovinFullscreenAdViewObserver(lifecycle, this, this.f63012a);
            lifecycle.addObserver(appLovinFullscreenAdViewObserver);
            a((com.applovin.impl.sdk.ad.b) appLovinAdA, viewGroup, appLovinFullscreenAdViewObserver, contextE);
            return;
        }
        com.applovin.impl.sdk.n.h("InterstitialAdDialogWrapper", "Failed to show interstitial: attempting to show ad with null container view or lifecycle object");
        a(appLovinAd, "Failed to show interstitial: attempting to show ad with null container view or lifecycle object");
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b implements o9.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f63021a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppLovinFullscreenAdViewObserver f63022b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ViewGroup f63023c;

        b(Context context, AppLovinFullscreenAdViewObserver appLovinFullscreenAdViewObserver, ViewGroup viewGroup) {
            this.f63021a = context;
            this.f63022b = appLovinFullscreenAdViewObserver;
            this.f63023c = viewGroup;
        }

        @Override // com.applovin.impl.o9.d
        public void a(o9 o9Var) {
            if (r.a((Activity) this.f63021a)) {
                com.applovin.impl.sdk.n.h("InterstitialAdDialogWrapper", "Failed to show interstitial: attempting to show ad when parent activity is finishing");
                sb.a(sb.this.f63019h, sb.this.f63016e, "Failed to show interstitial: attempting to show ad when parent activity is finishing", null, null);
                return;
            }
            this.f63022b.setPresenter(o9Var);
            try {
                o9Var.a(this.f63023c);
            } catch (Throwable th) {
                String str = "Failed to show interstitial: presenter threw exception " + th;
                com.applovin.impl.sdk.n.h("InterstitialAdDialogWrapper", str);
                sb.a(sb.this.f63019h, sb.this.f63016e, str, null, null);
            }
        }

        @Override // com.applovin.impl.o9.d
        public void a(String str, Throwable th) {
            sb.a(sb.this.f63019h, sb.this.f63016e, str, th, null);
        }
    }

    private void a(AppLovinAd appLovinAd, String str) {
        if (this.f63016e != null) {
            if (this.f63016e instanceof pb) {
                ((pb) this.f63016e).onAdDisplayFailed(str);
            } else {
                this.f63016e.adHidden(appLovinAd);
            }
        }
    }

    public static void a(com.applovin.impl.sdk.ad.b bVar, AppLovinAdDisplayListener appLovinAdDisplayListener, String str, Throwable th, AppLovinFullscreenActivity appLovinFullscreenActivity) {
        com.applovin.impl.sdk.n.c("InterstitialAdDialogWrapper", str, th);
        if (appLovinAdDisplayListener instanceof pb) {
            fc.a(appLovinAdDisplayListener, str);
        } else {
            fc.b(appLovinAdDisplayListener, bVar);
        }
        if (appLovinFullscreenActivity != null) {
            appLovinFullscreenActivity.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final AppLovinAd appLovinAd) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.t40
            @Override // java.lang.Runnable
            public final void run() {
                this.f63873a.a(appLovinAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final int i3) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.w40
            @Override // java.lang.Runnable
            public final void run() {
                this.f64573a.a(i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AppLovinAd appLovinAd) {
        if (this.f63015d != null) {
            this.f63015d.adReceived(appLovinAd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i3) {
        if (this.f63015d != null) {
            this.f63015d.failedToReceiveAd(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Context context) {
        this.f63012a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f63012a.I().a("InterstitialAdDialogWrapper", "Presenting ad in a fullscreen activity");
        }
        b(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ViewGroup viewGroup, Context context, AppLovinFullscreenAdViewObserver appLovinFullscreenAdViewObserver) {
        this.f63012a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f63012a.I().a("InterstitialAdDialogWrapper", "Presenting ad in a containerView(" + viewGroup + ")");
        }
        viewGroup.setBackgroundColor(-16777216);
        o9.a(this.f63019h, this.f63018g, this.f63016e, this.f63017f, this.f63014c, this.f63012a, (Activity) context, new b(context, appLovinFullscreenAdViewObserver, viewGroup));
    }

    private void a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f63012a.j().loadNextAd(AppLovinAdSize.INTERSTITIAL, appLovinAdLoadListener);
    }

    private String a(AppLovinAd appLovinAd, AppLovinAd appLovinAd2, Context context) {
        if (context == null) {
            com.applovin.impl.sdk.n.h("InterstitialAdDialogWrapper", "Failed to show interstitial: stale activity reference provided");
            return "Failed to show interstitial: stale activity reference provided";
        }
        if (appLovinAd == null) {
            com.applovin.impl.sdk.n.h("InterstitialAdDialogWrapper", "Unable to retrieve the loaded ad: " + appLovinAd2);
            return "Unable to retrieve the loaded ad";
        }
        if (!((AppLovinAdImpl) appLovinAd).hasShown() || !((Boolean) this.f63012a.a(sj.M1)).booleanValue()) {
            return null;
        }
        com.applovin.impl.sdk.n.h("InterstitialAdDialogWrapper", "Attempting to show ad again: " + appLovinAd);
        return "Attempting to show ad again";
    }

    private void a(com.applovin.impl.sdk.ad.b bVar, Context context, final Runnable runnable) {
        if (TextUtils.isEmpty(bVar.I()) && bVar.e1() && !e4.a(context) && (context instanceof Activity)) {
            AlertDialog alertDialogCreate = new AlertDialog.Builder(context).setTitle(bVar.P()).setMessage(bVar.O()).setPositiveButton(bVar.N(), (DialogInterface.OnClickListener) null).create();
            alertDialogCreate.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.applovin.impl.s40
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    runnable.run();
                }
            });
            alertDialogCreate.show();
            return;
        }
        runnable.run();
    }

    private void a(com.applovin.impl.sdk.ad.b bVar, final Context context) {
        i();
        this.f63012a.f().a(bVar);
        this.f63019h = bVar;
        final long jG = g();
        this.f63012a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f63012a.I().a("InterstitialAdDialogWrapper", "Presenting ad with delay " + jG + "ms...");
        }
        if (((Boolean) this.f63012a.a(sj.Y0)).booleanValue()) {
            this.f63012a.g().a(this.f63019h);
        }
        a(bVar, context, new Runnable() { // from class: com.applovin.impl.v40
            @Override // java.lang.Runnable
            public final void run() {
                this.f64383a.a(context, jG);
            }
        });
    }

    private void a(com.applovin.impl.sdk.ad.b bVar, final ViewGroup viewGroup, final AppLovinFullscreenAdViewObserver appLovinFullscreenAdViewObserver, final Context context) {
        i();
        this.f63012a.f().a(bVar);
        this.f63019h = bVar;
        final long jG = g();
        this.f63012a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f63012a.I().a("InterstitialAdDialogWrapper", "Presenting ad with delay " + jG + "ms...");
        }
        if (((Boolean) this.f63012a.a(sj.Y0)).booleanValue()) {
            this.f63012a.g().a(this.f63019h);
        }
        a(bVar, context, new Runnable() { // from class: com.applovin.impl.r40
            @Override // java.lang.Runnable
            public final void run() {
                this.f62734a.a(context, viewGroup, appLovinFullscreenAdViewObserver, jG);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final Context context, long j3) {
        new Handler(context.getMainLooper()).postDelayed(new Runnable() { // from class: com.applovin.impl.x40
            @Override // java.lang.Runnable
            public final void run() {
                this.f64813a.a(context);
            }
        }, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final Context context, final ViewGroup viewGroup, final AppLovinFullscreenAdViewObserver appLovinFullscreenAdViewObserver, long j3) {
        new Handler(context.getMainLooper()).postDelayed(new Runnable() { // from class: com.applovin.impl.u40
            @Override // java.lang.Runnable
            public final void run() {
                this.f64091a.a(viewGroup, context, appLovinFullscreenAdViewObserver);
            }
        }, j3);
    }
}
