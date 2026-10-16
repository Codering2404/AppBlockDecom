package com.google.android.play.core.integrity;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class ax {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static aw f82996a;

    static synchronized aw a(Context context) {
        try {
            if (f82996a == null) {
                u uVar = new u(null);
                uVar.a(com.google.android.play.integrity.internal.ag.a(context));
                f82996a = uVar.b();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f82996a;
    }
}
