package com.evernote.android.job.util;

import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class JobPreconditions {
    public static long a(long j3, long j4, long j5, String str) {
        if (j3 < j4) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", str, Long.valueOf(j4), Long.valueOf(j5)));
        }
        if (j3 <= j5) {
            return j3;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", str, Long.valueOf(j4), Long.valueOf(j5)));
    }

    public static int b(int i3, String str) {
        if (i3 >= 0) {
            return i3;
        }
        throw new IllegalArgumentException(str);
    }

    public static long c(long j3, String str) {
        if (j3 >= 0) {
            return j3;
        }
        throw new IllegalArgumentException(str);
    }

    public static long d(long j3, String str) {
        if (j3 > 0) {
            return j3;
        }
        throw new IllegalArgumentException(str);
    }

    public static CharSequence e(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            throw new IllegalArgumentException();
        }
        return charSequence;
    }

    public static Object f(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object g(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(String.valueOf(obj2));
    }
}
