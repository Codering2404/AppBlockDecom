package com.google.android.gms.measurement.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzal extends zzje {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Boolean f73398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f73399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzak f73400d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Boolean f73401e;

    zzal(zzic zzicVar) {
        super(zzicVar);
        this.f73400d = zzaj.f73397a;
    }

    public static final long n() {
        return ((Long) zzfy.f73631e.b(null)).longValue();
    }

    public static final int o() {
        return Math.max(0, ((Integer) zzfy.f73646j.b(null)).intValue());
    }

    public static final long p() {
        return ((Integer) zzfy.f73652l.b(null)).intValue();
    }

    public static final long q() {
        return ((Long) zzfy.S.b(null)).longValue();
    }

    public static final long r() {
        return ((Long) zzfy.N.b(null)).longValue();
    }

    private final String s(String str, String str2) {
        try {
            String str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, "");
            Preconditions.m(str3);
            return str3;
        } catch (ClassNotFoundException e3) {
            this.f73997a.a().o().b("Could not find SystemProperties class", e3);
            return "";
        } catch (IllegalAccessException e4) {
            this.f73997a.a().o().b("Could not access SystemProperties.get()", e4);
            return "";
        } catch (NoSuchMethodException e5) {
            this.f73997a.a().o().b("Could not find SystemProperties.get() method", e5);
            return "";
        } catch (InvocationTargetException e6) {
            this.f73997a.a().o().b("SystemProperties.get() threw an exception", e6);
            return "";
        }
    }

    public final long A() {
        this.f73997a.c();
        return 133005L;
    }

    public final boolean B() {
        if (this.f73401e == null) {
            synchronized (this) {
                try {
                    if (this.f73401e == null) {
                        zzic zzicVar = this.f73997a;
                        ApplicationInfo applicationInfo = zzicVar.d().getApplicationInfo();
                        String strA = ProcessUtils.a();
                        if (applicationInfo != null) {
                            String str = applicationInfo.processName;
                            boolean z2 = false;
                            if (str != null && str.equals(strA)) {
                                z2 = true;
                            }
                            this.f73401e = Boolean.valueOf(z2);
                        }
                        if (this.f73401e == null) {
                            this.f73401e = Boolean.TRUE;
                            zzicVar.a().o().a("My process not in the list of running processes");
                        }
                    }
                } finally {
                }
            }
        }
        return this.f73401e.booleanValue();
    }

    public final String C(String str, zzfx zzfxVar) {
        return TextUtils.isEmpty(str) ? (String) zzfxVar.b(null) : (String) zzfxVar.b(this.f73400d.f(str, zzfxVar.a()));
    }

    public final long D(String str, zzfx zzfxVar) {
        if (TextUtils.isEmpty(str)) {
            return ((Long) zzfxVar.b(null)).longValue();
        }
        String strF = this.f73400d.f(str, zzfxVar.a());
        if (TextUtils.isEmpty(strF)) {
            return ((Long) zzfxVar.b(null)).longValue();
        }
        try {
            return ((Long) zzfxVar.b(Long.valueOf(Long.parseLong(strF)))).longValue();
        } catch (NumberFormatException unused) {
            return ((Long) zzfxVar.b(null)).longValue();
        }
    }

    public final int E(String str, zzfx zzfxVar) {
        if (TextUtils.isEmpty(str)) {
            return ((Integer) zzfxVar.b(null)).intValue();
        }
        String strF = this.f73400d.f(str, zzfxVar.a());
        if (TextUtils.isEmpty(strF)) {
            return ((Integer) zzfxVar.b(null)).intValue();
        }
        try {
            return ((Integer) zzfxVar.b(Integer.valueOf(Integer.parseInt(strF)))).intValue();
        } catch (NumberFormatException unused) {
            return ((Integer) zzfxVar.b(null)).intValue();
        }
    }

    public final int F(String str, zzfx zzfxVar, int i3, int i4) {
        return Math.max(Math.min(E(str, zzfxVar), i4), i3);
    }

    public final double G(String str, zzfx zzfxVar) {
        if (TextUtils.isEmpty(str)) {
            return ((Double) zzfxVar.b(null)).doubleValue();
        }
        String strF = this.f73400d.f(str, zzfxVar.a());
        if (TextUtils.isEmpty(strF)) {
            return ((Double) zzfxVar.b(null)).doubleValue();
        }
        try {
            return ((Double) zzfxVar.b(Double.valueOf(Double.parseDouble(strF)))).doubleValue();
        } catch (NumberFormatException unused) {
            return ((Double) zzfxVar.b(null)).doubleValue();
        }
    }

    public final boolean H(String str, zzfx zzfxVar) {
        if (TextUtils.isEmpty(str)) {
            return ((Boolean) zzfxVar.b(null)).booleanValue();
        }
        String strF = this.f73400d.f(str, zzfxVar.a());
        return TextUtils.isEmpty(strF) ? ((Boolean) zzfxVar.b(null)).booleanValue() : ((Boolean) zzfxVar.b(Boolean.valueOf(AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(strF)))).booleanValue();
    }

    final Bundle I() {
        try {
            zzic zzicVar = this.f73997a;
            if (zzicVar.d().getPackageManager() == null) {
                zzicVar.a().o().a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfoC = Wrappers.a(zzicVar.d()).c(zzicVar.d().getPackageName(), ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
            if (applicationInfoC != null) {
                return applicationInfoC.metaData;
            }
            zzicVar.a().o().a("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e3) {
            this.f73997a.a().o().b("Failed to load metadata: Package name not found", e3);
            return null;
        }
    }

    final Boolean J(String str) {
        Preconditions.g(str);
        Bundle bundleI = I();
        if (bundleI == null) {
            this.f73997a.a().o().a("Failed to load metadata: Metadata bundle is null");
            return null;
        }
        if (bundleI.containsKey(str)) {
            return Boolean.valueOf(bundleI.getBoolean(str));
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final java.util.List K(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r4 = "analytics.safelisted_events"
            com.google.android.gms.common.internal.Preconditions.g(r4)
            android.os.Bundle r0 = r3.I()
            r1 = 0
            if (r0 != 0) goto L1d
            com.google.android.gms.measurement.internal.zzic r4 = r3.f73997a
            com.google.android.gms.measurement.internal.zzgu r4 = r4.a()
            com.google.android.gms.measurement.internal.zzgs r4 = r4.o()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.a(r0)
        L1b:
            r4 = r1
            goto L2c
        L1d:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L24
            goto L1b
        L24:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L2c:
            if (r4 == 0) goto L58
            com.google.android.gms.measurement.internal.zzic r0 = r3.f73997a     // Catch: android.content.res.Resources.NotFoundException -> L48
            android.content.Context r0 = r0.d()     // Catch: android.content.res.Resources.NotFoundException -> L48
            android.content.res.Resources r0 = r0.getResources()     // Catch: android.content.res.Resources.NotFoundException -> L48
            int r4 = r4.intValue()     // Catch: android.content.res.Resources.NotFoundException -> L48
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch: android.content.res.Resources.NotFoundException -> L48
            if (r4 != 0) goto L43
            return r1
        L43:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch: android.content.res.Resources.NotFoundException -> L48
            return r4
        L48:
            r4 = move-exception
            com.google.android.gms.measurement.internal.zzic r0 = r3.f73997a
            com.google.android.gms.measurement.internal.zzgu r0 = r0.a()
            com.google.android.gms.measurement.internal.zzgs r0 = r0.o()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.b(r2, r4)
        L58:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.K(java.lang.String):java.util.List");
    }

    public final boolean L() {
        this.f73997a.c();
        Boolean boolJ = J("firebase_analytics_collection_deactivated");
        return boolJ != null && boolJ.booleanValue();
    }

    public final boolean M() {
        Boolean boolJ = J("google_analytics_adid_collection_enabled");
        return boolJ == null || boolJ.booleanValue();
    }

    public final boolean N() {
        Boolean boolJ = J("google_analytics_automatic_screen_reporting_enabled");
        return boolJ == null || boolJ.booleanValue();
    }

    public final zzji O(String str, boolean z2) {
        Object obj;
        Preconditions.g(str);
        zzic zzicVar = this.f73997a;
        Bundle bundleI = I();
        if (bundleI == null) {
            zzicVar.a().o().a("Failed to load metadata: Metadata bundle is null");
            obj = null;
        } else {
            obj = bundleI.get(str);
        }
        if (obj == null) {
            return zzji.UNINITIALIZED;
        }
        if (Boolean.TRUE.equals(obj)) {
            return zzji.GRANTED;
        }
        if (Boolean.FALSE.equals(obj)) {
            return zzji.DENIED;
        }
        if (z2 && "eu_consent_policy".equals(obj)) {
            return zzji.POLICY;
        }
        zzicVar.a().r().b("Invalid manifest metadata for", str);
        return zzji.UNINITIALIZED;
    }

    public final boolean P() {
        Boolean boolJ = J("google_analytics_sgtm_upload_enabled");
        if (boolJ == null) {
            return false;
        }
        return boolJ.booleanValue();
    }

    public final void Q(String str) {
        this.f73399c = str;
    }

    public final String R() {
        return this.f73399c;
    }

    public final String i() {
        return s("debug.firebase.analytics.app", "");
    }

    public final String j() {
        return s("debug.deferred.deeplink", "");
    }

    public final boolean k(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(this.f73400d.f(str, "gaia_collection_enabled"));
    }

    public final boolean l(String str) {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(this.f73400d.f(str, "measurement.event_sampling_enabled"));
    }

    final boolean m() {
        if (this.f73398b == null) {
            Boolean boolJ = J("app_measurement_lite");
            this.f73398b = boolJ;
            if (boolJ == null) {
                this.f73398b = Boolean.FALSE;
            }
        }
        return this.f73398b.booleanValue() || !this.f73997a.G();
    }

    final void t(zzak zzakVar) {
        this.f73400d = zzakVar;
    }

    final String u() {
        this.f73997a.c();
        return "FA";
    }

    public final int v() {
        return this.f73997a.C().V(201500000, true) ? 100 : 25;
    }

    public final int w(String str) {
        return F(str, zzfy.Y, 25, 100);
    }

    final int x(String str, boolean z2) {
        if (z2) {
            return F(str, zzfy.f73644i0, 100, 500);
        }
        return 500;
    }

    final int y(String str, boolean z2) {
        return Math.max(x(str, z2), Function.MAX_NARGS);
    }

    final int z(String str) {
        return F(str, zzfy.X, 500, AdError.SERVER_ERROR_CODE);
    }
}
