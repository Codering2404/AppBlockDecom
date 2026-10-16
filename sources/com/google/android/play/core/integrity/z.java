package com.google.android.play.core.integrity;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static s f83080a;

    static synchronized s a(Context context) {
        try {
            if (f83080a == null) {
                q qVar = new q(null);
                qVar.a(com.google.android.play.integrity.internal.ag.a(context));
                f83080a = qVar.b();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f83080a;
    }
}
