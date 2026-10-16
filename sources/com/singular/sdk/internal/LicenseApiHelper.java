package com.singular.sdk.internal;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class LicenseApiHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SingularLog f92598a = SingularLog.f(LicenseApiHelper.class.getSimpleName());

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class LicenseResultHandler {
        LicenseResultHandler() {
        }

        public abstract void a(int i3, String str, String str2);
    }

    public static void a(Context context, LicenseResultHandler licenseResultHandler) {
        try {
            new LicenseChecker(context, licenseResultHandler).b();
        } catch (Throwable th) {
            f92598a.d("Error occurred while trying to run license check", th);
        }
    }
}
