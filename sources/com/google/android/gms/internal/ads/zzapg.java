package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzapg implements zzang {
    private final List zza;
    private final long[] zzb;
    private final long[] zzc;

    public zzapg(List list) {
        this.zza = Collections.unmodifiableList(new ArrayList(list));
        int size = list.size();
        this.zzb = new long[size + size];
        for (int i3 = 0; i3 < list.size(); i3++) {
            zzaow zzaowVar = (zzaow) list.get(i3);
            long[] jArr = this.zzb;
            int i4 = i3 + i3;
            jArr[i4] = zzaowVar.zzb;
            jArr[i4 + 1] = zzaowVar.zzc;
        }
        long[] jArr2 = this.zzb;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.zzc = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final int zza() {
        return this.zzc.length;
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final long zzb(int i3) {
        zzgtj.zza(i3 >= 0);
        long[] jArr = this.zzc;
        zzgtj.zza(i3 < jArr.length);
        return jArr[i3];
    }

    @Override // com.google.android.gms.internal.ads.zzang
    public final List zzc(long j3) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i3 = 0;
        while (true) {
            List list = this.zza;
            if (i3 >= list.size()) {
                break;
            }
            long[] jArr = this.zzb;
            int i4 = i3 + i3;
            if (jArr[i4] <= j3 && j3 < jArr[i4 + 1]) {
                zzaow zzaowVar = (zzaow) list.get(i3);
                zzcx zzcxVar = zzaowVar.zza;
                if (zzcxVar.zze == -3.4028235E38f) {
                    arrayList2.add(zzaowVar);
                } else {
                    arrayList.add(zzcxVar);
                }
            }
            i3++;
        }
        Collections.sort(arrayList2, zzapf.zza);
        for (int i5 = 0; i5 < arrayList2.size(); i5++) {
            zzcw zzcwVarZza = ((zzaow) arrayList2.get(i5)).zza.zza();
            zzcwVarZza.zzf((-1) - i5, 1);
            arrayList.add(zzcwVarZza.zzr());
        }
        return arrayList;
    }
}
