package com.google.android.gms.common.wrappers;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Wrappers {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Wrappers f72308b = new Wrappers();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PackageManagerWrapper f72309a = null;

    public static PackageManagerWrapper a(Context context) {
        return f72308b.b(context);
    }

    public final synchronized PackageManagerWrapper b(Context context) {
        try {
            if (this.f72309a == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                this.f72309a = new PackageManagerWrapper(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f72309a;
    }
}
