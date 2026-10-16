package com.caverock.androidsvg;

import android.graphics.Canvas;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class CanvasLegacy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f67386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Method f67387b;

    static {
        try {
            f67386a = ((Integer) Canvas.class.getField("MATRIX_SAVE_FLAG").get(null)).intValue();
            f67387b = Canvas.class.getMethod("save", Integer.TYPE);
        } catch (Throwable th) {
            throw a(th);
        }
    }

    private static RuntimeException a(Throwable th) {
        if (th != null) {
            return (RuntimeException) b(th);
        }
        throw new NullPointerException("t");
    }

    private static Throwable b(Throwable th) throws Throwable {
        throw th;
    }
}
