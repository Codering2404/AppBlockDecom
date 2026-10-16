package com.google.android.gms.internal.fido;

import java.util.Comparator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgl {
    static final String zza;
    static final Comparator zzb;

    static {
        Comparator comparator;
        String strConcat = zzgl.class.getName().concat("$UnsafeComparator");
        zza = strConcat;
        try {
            Object[] enumConstants = Class.forName(strConcat).getEnumConstants();
            Objects.requireNonNull(enumConstants);
            comparator = (Comparator) enumConstants[0];
        } catch (Throwable unused) {
            comparator = zzgk.INSTANCE;
        }
        zzb = comparator;
    }

    zzgl() {
    }
}
