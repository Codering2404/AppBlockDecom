package com.google.android.libraries.places.internal;

import android.content.Context;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zznh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f78246a;

    public zznh(Context context) {
        Preconditions.u(context, "Context must not be null.");
        this.f78246a = context;
    }

    public final ImmutableMap a() {
        Context context = this.f78246a;
        String packageName = context.getPackageName();
        String strA = zzmr.a(context.getPackageManager(), packageName);
        ImmutableMap.Builder builderA = ImmutableMap.a();
        if (packageName != null) {
            builderA.g("X-Android-Package", packageName);
        }
        if (strA != null) {
            builderA.g("X-Android-Cert", strA);
        }
        return builderA.d();
    }
}
