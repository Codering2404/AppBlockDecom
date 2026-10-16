package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.wrappers.Wrappers;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f72087a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f72088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f72089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f72090d;

    public static int a(Context context) {
        b(context);
        return f72090d;
    }

    private static void b(Context context) {
        synchronized (f72087a) {
            try {
                if (f72088b) {
                    return;
                }
                f72088b = true;
                try {
                    Bundle bundle = Wrappers.a(context).c(context.getPackageName(), ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD).metaData;
                    if (bundle == null) {
                        return;
                    }
                    f72089c = bundle.getString("com.google.app.id");
                    f72090d = bundle.getInt("com.google.android.gms.version");
                } catch (PackageManager.NameNotFoundException e3) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
