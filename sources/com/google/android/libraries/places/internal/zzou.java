package com.google.android.libraries.places.internal;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzou {
    public static final Parcelable a(Bundle bundle, String key, Class clazz) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Parcelable parcelable = Build.VERSION.SDK_INT >= 33 ? (Parcelable) bundle.getParcelable(key, clazz) : bundle.getParcelable(key);
        if (parcelable != null) {
            return parcelable;
        }
        throw new IllegalStateException("Required value was null.");
    }
}
