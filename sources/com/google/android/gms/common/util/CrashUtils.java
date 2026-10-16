package com.google.android.gms.common.util;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class CrashUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f72268a = {"android.", "com.android.", "dalvik.", "java.", "javax."};

    public static boolean a(Context context, Throwable th) {
        try {
            Preconditions.m(context);
            Preconditions.m(th);
            return false;
        } catch (Exception e3) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", e3);
            return false;
        }
    }
}
