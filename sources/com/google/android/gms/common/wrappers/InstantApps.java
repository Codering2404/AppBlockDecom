package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.google.android.gms.common.util.PlatformVersion;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class InstantApps {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f72305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Boolean f72306b;

    public static synchronized boolean a(Context context) {
        Boolean bool;
        Context applicationContext = context.getApplicationContext();
        Context context2 = f72305a;
        if (context2 != null && (bool = f72306b) != null && context2 == applicationContext) {
            return bool.booleanValue();
        }
        f72306b = null;
        if (PlatformVersion.e()) {
            f72306b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
        } else {
            try {
                context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                f72306b = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                f72306b = Boolean.FALSE;
            }
        }
        f72305a = applicationContext;
        return f72306b.booleanValue();
    }
}
