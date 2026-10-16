package com.google.android.gms.ads.internal.util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzce {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static zzce f70311b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f70312a;

    private zzce() {
    }

    public static zzce a() {
        if (f70311b == null) {
            f70311b = new zzce();
        }
        return f70311b;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(android.content.Context r7) {
        /*
            r6 = this;
            java.lang.String r0 = "Updating user agent."
            com.google.android.gms.ads.internal.util.zze.k(r0)
            java.lang.String r0 = android.webkit.WebSettings.getDefaultUserAgent(r7)
            java.lang.String r1 = r6.f70312a
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L3e
            android.content.Context r1 = com.google.android.gms.common.GooglePlayServicesUtilLight.e(r7)
            boolean r2 = com.google.android.gms.common.util.ClientLibraryUtils.a()
            if (r2 != 0) goto L1e
            if (r1 != 0) goto L3c
            r1 = 0
        L1e:
            java.lang.String r2 = android.webkit.WebSettings.getDefaultUserAgent(r7)
            r3 = 0
            java.lang.String r4 = "admob_user_agent"
            android.content.SharedPreferences r3 = r7.getSharedPreferences(r4, r3)
            android.content.SharedPreferences$Editor r3 = r3.edit()
            java.lang.String r5 = "user_agent"
            android.content.SharedPreferences$Editor r2 = r3.putString(r5, r2)
            if (r1 != 0) goto L39
            r2.apply()
            goto L3c
        L39:
            com.google.android.gms.common.util.SharedPreferencesUtils.a(r7, r2, r4)
        L3c:
            r6.f70312a = r0
        L3e:
            java.lang.String r7 = "User agent is updated."
            com.google.android.gms.ads.internal.util.zze.k(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzce.b(android.content.Context):void");
    }
}
