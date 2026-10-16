package com.google.firebase.crashlytics.internal.common;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class InstallerPackageNameProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f88446a;

    InstallerPackageNameProvider() {
    }

    private static String b(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName == null ? "" : installerPackageName;
    }

    synchronized String a(Context context) {
        try {
            if (this.f88446a == null) {
                this.f88446a = b(context);
            }
        } finally {
        }
        return "".equals(this.f88446a) ? null : this.f88446a;
    }
}
