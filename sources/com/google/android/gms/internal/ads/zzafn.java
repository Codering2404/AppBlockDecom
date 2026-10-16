package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzafn {
    private final Map zza = new LinkedHashMap();

    public final void zza(zzafm zzafmVar) {
        long[] jArr = zzafmVar.zze;
        if (jArr.length > 0) {
            Map map = this.zza;
            if (map.containsKey(Long.valueOf(jArr[0]))) {
                return;
            }
            map.put(Long.valueOf(jArr[0]), zzafmVar);
        }
    }

    public final zzafm zzb() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (zzafm zzafmVar : this.zza.values()) {
            arrayList.add(zzafmVar.zzb);
            arrayList2.add(zzafmVar.zzc);
            arrayList3.add(zzafmVar.zzd);
            arrayList4.add(zzafmVar.zze);
        }
        int[][] iArr = (int[][]) arrayList.toArray(new int[arrayList.size()][]);
        long length = 0;
        for (int[] iArr2 : iArr) {
            length += (long) iArr2.length;
        }
        int i3 = (int) length;
        zzgtj.zze(length == ((long) i3), "the total number of elements (%s) in the arrays must fit in an int", length);
        int[] iArr3 = new int[i3];
        int i4 = 0;
        for (int[] iArr4 : iArr) {
            int length2 = iArr4.length;
            System.arraycopy(iArr4, 0, iArr3, i4, length2);
            i4 += length2;
        }
        return new zzafm(iArr3, zzhak.zza((long[][]) arrayList2.toArray(new long[arrayList2.size()][])), zzhak.zza((long[][]) arrayList3.toArray(new long[arrayList3.size()][])), zzhak.zza((long[][]) arrayList4.toArray(new long[arrayList4.size()][])));
    }

    public final int zzc() {
        return this.zza.size();
    }
}
