package com.google.android.gms.internal.fido;

import java.util.Comparator;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdb {
    public static boolean zza(Comparator comparator, Iterable iterable) {
        Comparator comparator2;
        comparator.getClass();
        iterable.getClass();
        if (iterable instanceof SortedSet) {
            comparator2 = ((SortedSet) iterable).comparator();
            if (comparator2 == null) {
                comparator2 = zzcq.zza;
            }
        } else {
            if (!(iterable instanceof zzda)) {
                return false;
            }
            comparator2 = ((zzda) iterable).comparator();
        }
        return comparator.equals(comparator2);
    }
}
