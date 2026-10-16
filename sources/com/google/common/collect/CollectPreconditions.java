package com.google.common.collect;

import androidx.glance.color.Tq.KqqtdetwHMIO;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class CollectPreconditions {
    static void a(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        }
        if (obj2 != null) {
            return;
        }
        throw new NullPointerException("null value in entry: " + obj + "=null");
    }

    static int b(int i3, String str) {
        if (i3 >= 0) {
            return i3;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i3);
    }

    static long c(long j3, String str) {
        if (j3 >= 0) {
            return j3;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + j3);
    }

    static void e(boolean z2) {
        Preconditions.A(z2, "no calls to next() since the last call to remove()");
    }

    static void d(int i3, String str) {
        if (i3 > 0) {
            return;
        }
        throw new IllegalArgumentException(str + KqqtdetwHMIO.amKiwHAZXwC + i3);
    }
}
