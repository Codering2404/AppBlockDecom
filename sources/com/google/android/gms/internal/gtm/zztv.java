package com.google.android.gms.internal.gtm;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zztv implements Comparator {
    zztv() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzud zzudVar = (zzud) obj;
        zzud zzudVar2 = (zzud) obj2;
        zztu zztuVar = new zztu(zzudVar);
        zztu zztuVar2 = new zztu(zzudVar2);
        while (zztuVar.hasNext() && zztuVar2.hasNext()) {
            int iCompareTo = Integer.valueOf(zztuVar.zza() & 255).compareTo(Integer.valueOf(zztuVar2.zza() & 255));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        return Integer.valueOf(zzudVar.zzd()).compareTo(Integer.valueOf(zzudVar2.zzd()));
    }
}
