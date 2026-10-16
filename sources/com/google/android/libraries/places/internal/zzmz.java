package com.google.android.libraries.places.internal;

import android.content.Context;
import android.content.pm.PackageManager;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzmz {
    public static zzmx d(Context context) {
        String packageName = context.getPackageName();
        int i3 = 0;
        try {
            i3 = context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        zzmv zzmvVar = new zzmv();
        zzmvVar.e(packageName);
        zzmvVar.a(i3);
        zzmvVar.b(zzmy.PROGRAMMATIC_API);
        return zzmvVar;
    }

    public abstract String a();

    public abstract int b();

    public abstract zzmy c();
}
