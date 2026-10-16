package com.google.android.play.core.review.internal;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.glance.session.ecY.lisODU;
import java.util.IllegalFormatException;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f83110a;

    private static String e(String str, String str2, Object... objArr) {
        if (objArr.length > 0) {
            try {
                str2 = String.format(Locale.US, str2, objArr);
            } catch (IllegalFormatException e3) {
                Log.e("PlayCore", "Unable to format ".concat(String.valueOf(str2)), e3);
                str2 = str2 + " [" + TextUtils.join(", ", objArr) + "]";
            }
        }
        return str + " : " + str2;
    }

    public final int a(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 6)) {
            return Log.e("PlayCore", e(this.f83110a, "Play Store app is either not installed or not the official version", objArr));
        }
        return 0;
    }

    public final int b(Throwable th, String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 6)) {
            return Log.e("PlayCore", e(this.f83110a, str, objArr), th);
        }
        return 0;
    }

    public final int c(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 4)) {
            return Log.i("PlayCore", e(this.f83110a, str, objArr));
        }
        return 0;
    }

    public final int d(String str, Object... objArr) {
        if (Log.isLoggable("PlayCore", 5)) {
            return Log.w("PlayCore", e(this.f83110a, str, objArr));
        }
        return 0;
    }

    public zzi(String str) {
        this.f83110a = ("UID: [" + Process.myUid() + "]  PID: [" + Process.myPid() + lisODU.sXckZVERlb).concat(str);
    }
}
