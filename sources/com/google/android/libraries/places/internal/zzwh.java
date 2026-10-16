package com.google.android.libraries.places.internal;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzwh implements Comparator {
    zzwh() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        zzwn zzwnVarA = zzwn.a(obj);
        zzwn zzwnVarA2 = zzwn.a(obj2);
        if (zzwnVarA != zzwnVarA2) {
            return zzwnVarA.compareTo(zzwnVarA2);
        }
        int iOrdinal = zzwnVarA.ordinal();
        if (iOrdinal == 0) {
            return ((Boolean) obj).compareTo((Boolean) obj2);
        }
        if (iOrdinal == 1) {
            return ((String) obj).compareTo((String) obj2);
        }
        if (iOrdinal == 2) {
            return ((Long) obj).compareTo((Long) obj2);
        }
        if (iOrdinal == 3) {
            return ((Double) obj).compareTo((Double) obj2);
        }
        throw null;
    }
}
