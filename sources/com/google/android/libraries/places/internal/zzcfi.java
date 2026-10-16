package com.google.android.libraries.places.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcfi {
    public static final zzcfj a(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        zzcfj zzcfjVar = new zzcfj(zzcfy.b(str));
        zzcfjVar.d(str);
        return zzcfjVar;
    }

    public static final zzcfj b(byte... data) {
        Intrinsics.checkNotNullParameter(data, "data");
        byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return new zzcfj(bArrCopyOf);
    }
}
