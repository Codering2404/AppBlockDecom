package com.singular.sdk.internal;

import android.content.Context;
import android.content.pm.InstallSourceInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.webkit.WebSettings;
import com.facebook.LegacyTokenHelper;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
class DeviceInfo {
    private static final SingularLog T = SingularLog.f(DeviceInfo.class.getSimpleName());
    String A;
    String B;
    String C;
    String D;
    String E;
    String F;
    String G;
    String H;
    String I;
    String J;
    String K;
    String L;
    String M;
    String N;
    String O;
    long P;
    long Q;
    String R;
    String S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f92539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f92540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f92541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f92542d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f92543e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f92544f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f92545g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f92546h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    String f92547i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f92548j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f92549k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    String f92550l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    String f92551m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    String f92552n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    String f92553o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    String f92554p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    String f92555q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    String f92556r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    String f92557s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    String f92558t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    String f92559u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    String f92560v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    String f92561w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    String f92562x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    String f92563y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    Locale f92564z;

    DeviceInfo(Context context, boolean z2, Boolean bool, boolean z3) {
        q(context);
        v(context);
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        Locale localeD = Utils.D(configuration);
        this.f92564z = localeD;
        this.A = localeD.getLanguage();
        this.B = this.f92564z.getCountry();
        int i3 = configuration.screenLayout;
        this.C = n(i3);
        this.D = m(i3);
        this.f92563y = f(i3);
        this.E = l(displayMetrics);
        this.F = i(displayMetrics);
        this.G = h(displayMetrics);
        this.f92545g = Utils.V();
        if (!bool.booleanValue()) {
            a(context);
        }
        if (z2) {
            this.f92542d = OAIDHelper.f(context);
        }
        boolean zQ = Utils.Q(context);
        this.f92548j = zQ;
        if (zQ) {
            this.f92549k = Utils.R(context);
            this.f92547i = Utils.r(context);
        }
        b(context, z3);
        this.L = j(context);
        s(context.getSharedPreferences("singular-pref-session", 0).getString("fcm_device_token_key", ""));
        t(context.getSharedPreferences("singular-pref-session", 0).getString("gcm_device_token_key", ""));
        k(context);
        r(context.getSharedPreferences("singular-pref-session", 0).getString("custom_user_id", ""));
        this.S = g(context);
        p();
    }

    private String c() {
        String[] strArrK = Utils.K();
        if (strArrK != null && strArrK.length != 0) {
            return strArrK[0];
        }
        T.a("SUPPORTED_ABIS is null or empty, falling back to CPU_ABI");
        return Utils.x();
    }

    private String d(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD)).toString();
        } catch (Throwable th) {
            T.a("Failed to get app name: " + Utils.l(th));
            return "unknown";
        }
    }

    private String e(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return TextUtils.isEmpty(packageInfo.versionName) ? "unknown" : packageInfo.versionName;
        } catch (Throwable th) {
            T.c("Failed to get app version: " + Utils.l(th));
            return "unknown";
        }
    }

    private String f(int i3) {
        int i4 = i3 & 15;
        if (i4 == 1 || i4 == 2) {
            return "phone";
        }
        if (i4 == 3 || i4 == 4) {
            return "tablet";
        }
        T.a("Unknown device type for screen size: " + i4);
        return null;
    }

    private String g(Context context) {
        String property = System.getProperty("http.agent", "");
        if (TextUtils.isEmpty(property)) {
            try {
                Class.forName("android.os.AsyncTask");
                return WebSettings.getDefaultUserAgent(context);
            } catch (VerifyError e3) {
                T.a("VerifyError while getting user agent: " + Utils.l(e3));
            } catch (Throwable th) {
                T.a("Failed to get device user agent: " + Utils.l(th));
            }
        }
        return property;
    }

    private String h(DisplayMetrics displayMetrics) {
        return String.valueOf(displayMetrics.heightPixels);
    }

    private String i(DisplayMetrics displayMetrics) {
        return String.valueOf(displayMetrics.widthPixels);
    }

    private String j(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (Build.VERSION.SDK_INT >= 30) {
                InstallSourceInfo installSourceInfo = packageManager.getInstallSourceInfo(context.getPackageName());
                if (installSourceInfo != null) {
                    this.L = installSourceInfo.getInitiatingPackageName();
                }
            } else {
                this.L = packageManager.getInstallerPackageName(context.getPackageName());
            }
            return this.L;
        } catch (Throwable th) {
            SingularLog singularLog = T;
            singularLog.c("Failed to get install source: " + Utils.l(th));
            singularLog.c("getInstallSource: returning null due to error");
            return null;
        }
    }

    private void k(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            this.P = packageInfo.firstInstallTime;
            this.Q = packageInfo.lastUpdateTime;
        } catch (PackageManager.NameNotFoundException e3) {
            T.c("Package not found while getting install timestamps: " + Utils.l(e3));
        } catch (RuntimeException e4) {
            T.d("getInstallDates failed", e4);
        }
    }

    private String l(DisplayMetrics displayMetrics) {
        int i3 = displayMetrics.densityDpi;
        if (i3 != 0) {
            return i3 < 140 ? "low" : i3 > 200 ? "high" : "medium";
        }
        T.a("Screen density is 0, cannot determine density");
        return null;
    }

    private String m(int i3) {
        int i4 = i3 & 48;
        if (i4 == 16) {
            return "normal";
        }
        if (i4 == 32) {
            return LegacyTokenHelper.TYPE_LONG;
        }
        T.a("Unknown screen format value: " + i4);
        return null;
    }

    private String n(int i3) {
        int i4 = i3 & 15;
        if (i4 == 1) {
            return "small";
        }
        if (i4 == 2) {
            return "normal";
        }
        if (i4 == 3) {
            return "large";
        }
        if (i4 == 4) {
            return "xlarge";
        }
        T.a("Unknown screen size value: " + i4);
        return null;
    }

    private void q(Context context) {
        this.f92550l = c();
        this.f92552n = Build.BRAND;
        this.f92553o = Build.DEVICE;
        this.f92554p = context.getPackageName();
        this.f92555q = Build.MANUFACTURER;
        this.f92556r = Build.MODEL;
        this.f92558t = "Android";
        this.f92559u = Build.PRODUCT;
        this.f92561w = Build.VERSION.RELEASE;
        this.H = Build.DISPLAY;
        this.f92560v = Constants.f92523b;
        this.f92557s = d(context);
        this.f92551m = e(context);
        this.f92562x = String.format("%d", Integer.valueOf(Build.VERSION.SDK_INT));
    }

    private void v(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD).metaData;
            this.M = bundle.getString("SINGULAR_PRELOAD_CAMPAIGN");
            this.N = bundle.getString("SINGULAR_PRELOAD_GROUP");
            this.O = bundle.getString("SINGULAR_PRELOAD_SOURCE");
        } catch (Throwable th) {
            T.d("error in setPreloadCampaign()", th);
        }
    }

    void a(Context context) {
        if (context == null) {
            T.a("blockingFetchLimitedAdvertisingIdentifiers: context is null. skipping.");
            return;
        }
        if (Utils.Z()) {
            T.h("blockingFetchLimitedAdvertisingIdentifiers: do not call from main thread. skipping.");
            return;
        }
        if (this.f92545g) {
            this.f92546h = Utils.Y(context);
            this.f92540b = Utils.F(context);
        }
        if (Utils.U(this.f92540b)) {
            this.f92540b = Utils.G(context);
        }
        this.f92539a = Utils.u(context);
        u(Utils.B());
    }

    void b(Context context, boolean z2) {
        if (z2) {
            SingularLog singularLog = T;
            singularLog.a("DeviceInfo: first launch. fetch app set id.");
            String strV = Utils.v(context);
            this.f92543e = strV;
            if (!Utils.U(strV)) {
                singularLog.a("DeviceInfo: first launch fetched app set id is valid, persisting. " + this.f92543e);
                Utils.f0(context, this.f92543e);
            }
        } else if (Utils.e(context)) {
            T.a("DeviceInfo: app set id is singular id.");
            this.f92543e = Utils.I(context).toString();
        } else {
            SingularLog singularLog2 = T;
            singularLog2.a("DeviceInfo: app set id is not singular id. fetch app set id again.");
            this.f92543e = Utils.v(context);
            this.f92544f = Utils.E(context);
            if (Utils.U(this.f92543e)) {
                singularLog2.a("DeviceInfo: using persisted app set id.");
                this.f92543e = this.f92544f;
            } else if (!this.f92543e.equalsIgnoreCase(this.f92544f)) {
                singularLog2.a("DeviceInfo: app set id and persisted app set id are not equal. updating persisted app set id.");
                Utils.f0(context, this.f92543e);
            }
        }
        if (Utils.U(this.f92543e)) {
            T.a("DeviceInfo: app set id is null. resorting to generated asid.");
            this.f92543e = Utils.I(context).toString();
            Utils.i0(context);
        }
    }

    public boolean o() {
        return (Utils.U(this.M) || Utils.U(this.N) || Utils.U(this.O)) ? false : true;
    }

    void p() {
        SingularLog singularLog = T;
        if (singularLog.i()) {
            singularLog.a("DeviceInfo ----> ");
            singularLog.b("\t imei : %s", this.f92541c);
            singularLog.b("\t andi : %s", this.f92539a);
            singularLog.b("\t asid : %s", this.f92543e);
            singularLog.b("\t aifa : %s", this.f92540b);
            singularLog.b("\t isGooglePlayServicesAvailable : %b", Boolean.valueOf(this.f92545g));
            singularLog.b("\t isLimitedTrackingEnabled : %b", Boolean.valueOf(this.f92546h));
            singularLog.b("\t appVersion : %s", this.f92551m);
            singularLog.b("\t sdkVersion : %s", this.f92560v);
            singularLog.b("\t packageName : %s", this.f92554p);
            singularLog.b("\t appName : %s", this.f92557s);
            singularLog.b("\t preloadCampaign : %s", this.M);
            singularLog.b("\t preloadGroup : %s", this.N);
            singularLog.b("\t preloadSource : %s", this.O);
            singularLog.b("\t installSource : %s", this.L);
            singularLog.b("\t abi : %s", this.f92550l);
            singularLog.b("\t deviceBrand : %s", this.f92552n);
            singularLog.b("\t deviceBuild : %s", this.f92553o);
            singularLog.b("\t deviceManufacturer : %s", this.f92555q);
            singularLog.b("\t deviceModel : %s", this.f92556r);
            singularLog.b("\t platform : %s", this.f92558t);
            singularLog.b("\t buildProduct : %s", this.f92559u);
            singularLog.b("\t osVersion : %s", this.f92561w);
            singularLog.b("\t apiLevel : %s", this.f92562x);
            singularLog.b("\t hardwareName : %s", this.H);
            singularLog.b("\t locale : %s", this.f92564z);
            singularLog.b("\t language : %s", this.A);
            singularLog.b("\t country : %s", this.B);
            singularLog.b("\t screenSize : %s", this.C);
            singularLog.b("\t screenFormat : %s", this.D);
            singularLog.b("\t screenDensity : %s", this.E);
            singularLog.b("\t displayWidth : %s", this.F);
            singularLog.b("\t displayHeight : %s", this.G);
            singularLog.b("\t gcmProcessId : %s", this.I);
            singularLog.b("\t gcmRegId : %s", this.J);
            singularLog.b("\t fcmRegId : %s", this.K);
            singularLog.b("\t firstInstallTime : %d", Long.valueOf(this.P));
            singularLog.b("\t lastUpdateTime : %d", Long.valueOf(this.Q));
            singularLog.b("\t deviceType : %s", this.f92563y);
            singularLog.b("\t customUserId : %s", this.R);
            singularLog.b("\t deviceUserAgent: %s", this.S);
        }
    }

    void r(String str) {
        this.R = str;
    }

    void s(String str) {
        this.K = str;
    }

    void t(String str) {
        this.J = str;
    }

    void u(String str) {
        this.f92541c = str;
    }
}
