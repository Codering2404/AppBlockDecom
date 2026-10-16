package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgxm {
    public static ArrayList zza(Iterator it) {
        ArrayList arrayList = new ArrayList();
        it.getClass();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static ArrayList zzb(int i3) {
        zzgvi.zzb(i3, "initialArraySize");
        return new ArrayList(i3);
    }

    public static List zzc(List list, zzgta zzgtaVar) {
        return list instanceof RandomAccess ? new zzgxj(list, zzgtaVar) : new zzgxl(list, zzgtaVar);
    }
}
