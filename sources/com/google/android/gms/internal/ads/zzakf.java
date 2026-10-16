package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzakf implements zzahb {
    private final zzafm zza;
    private final SparseArray zzb;
    private final long zzc;
    private final int zzd;

    public zzakf(SparseArray sparseArray, long j3, int i3, long j4, long j5) {
        int i4;
        this.zzb = sparseArray;
        this.zzc = j3;
        this.zzd = i3;
        List list = (List) sparseArray.get(i3);
        zzafm zzafmVar = null;
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            int[] iArrCopyOf = new int[size];
            long[] jArrCopyOf = new long[size];
            long[] jArrCopyOf2 = new long[size];
            long[] jArrCopyOf3 = new long[size];
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                zzake zzakeVar = (zzake) list.get(i6);
                jArrCopyOf3[i6] = zzakeVar.zza();
                jArrCopyOf[i6] = zzakeVar.zzb();
            }
            while (true) {
                i4 = size - 1;
                if (i5 >= i4) {
                    break;
                }
                int i7 = i5 + 1;
                iArrCopyOf[i5] = (int) (jArrCopyOf[i7] - jArrCopyOf[i5]);
                jArrCopyOf2[i5] = jArrCopyOf3[i7] - jArrCopyOf3[i5];
                i5 = i7;
            }
            int i8 = i4;
            while (i8 > 0 && jArrCopyOf3[i8] >= j3) {
                i8--;
            }
            iArrCopyOf[i8] = (int) ((j4 + j5) - jArrCopyOf[i8]);
            jArrCopyOf2[i8] = j3 - jArrCopyOf3[i8];
            if (i8 < i4) {
                zzeg.zzc("MatroskaExtractor", "Discarding trailing cue points with timestamps greater than total duration.");
                int i9 = i8 + 1;
                iArrCopyOf = Arrays.copyOf(iArrCopyOf, i9);
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i9);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i9);
                jArrCopyOf3 = Arrays.copyOf(jArrCopyOf3, i9);
            }
            zzafmVar = new zzafm(iArrCopyOf, jArrCopyOf, jArrCopyOf2, jArrCopyOf3);
        }
        this.zza = zzafmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final boolean zzb() {
        List list = (List) this.zzb.get(this.zzd);
        return (list == null || list.isEmpty()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final zzagz zzc(long j3) {
        zzafm zzafmVar = this.zza;
        if (zzafmVar != null) {
            return zzafmVar.zzc(j3);
        }
        zzahc zzahcVar = zzahc.zza;
        return new zzagz(zzahcVar, zzahcVar);
    }
}
