package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzzu extends zzzw {
    protected zzzu(zzbg zzbgVar, int[] iArr, int i3, zzabq zzabqVar, long j3, long j4, long j5, int i4, int i5, float f3, float f4, List list, zzdo zzdoVar) {
        super(zzbgVar, iArr, 0);
        zzgwm.zzq(list);
    }

    static /* synthetic */ zzgwm zzd(zzaaz[] zzaazVarArr) {
        int i3;
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            i3 = 1;
            if (i5 >= 2) {
                break;
            }
            zzaaz zzaazVar = zzaazVarArr[i5];
            if (zzaazVar == null || zzaazVar.zzb.length <= 1) {
                arrayList.add(null);
            } else {
                int i6 = zzgwm.zzd;
                zzgwj zzgwjVar = new zzgwj();
                zzgwjVar.zzf(new zzzs(0L, 0L));
                arrayList.add(zzgwjVar);
            }
            i5++;
        }
        long[][] jArr = new long[2][];
        for (int i7 = 0; i7 < 2; i7++) {
            zzaaz zzaazVar2 = zzaazVarArr[i7];
            if (zzaazVar2 == null) {
                jArr[i7] = new long[0];
            } else {
                int[] iArr = zzaazVar2.zzb;
                jArr[i7] = new long[iArr.length];
                for (int i8 = 0; i8 < iArr.length; i8++) {
                    long j3 = zzaazVar2.zza.zza(iArr[i8]).zzj;
                    long[] jArr2 = jArr[i7];
                    if (j3 == -1) {
                        j3 = 0;
                    }
                    jArr2[i8] = j3;
                }
                Arrays.sort(jArr[i7]);
            }
        }
        int[] iArr2 = new int[2];
        long[] jArr3 = new long[2];
        for (int i9 = 0; i9 < 2; i9++) {
            long[] jArr4 = jArr[i9];
            jArr3[i9] = jArr4.length == 0 ? 0L : jArr4[0];
        }
        zzi(arrayList, jArr3);
        zzgxh zzgxhVarZza = zzgyb.zzc(zzgyg.zzb()).zzb(2).zza();
        int i10 = 0;
        while (i10 < 2) {
            int length = jArr[i10].length;
            if (length > i3) {
                double[] dArr = new double[length];
                int i11 = i4;
                while (true) {
                    long[] jArr5 = jArr[i10];
                    double dLog = 0.0d;
                    if (i11 >= jArr5.length) {
                        break;
                    }
                    long j4 = jArr5[i11];
                    if (j4 != -1) {
                        dLog = Math.log(j4);
                    }
                    dArr[i11] = dLog;
                    i11++;
                }
                int i12 = length - 1;
                double d3 = dArr[i12] - dArr[i4];
                int i13 = i4;
                while (i13 < i12) {
                    double d4 = dArr[i13];
                    i13++;
                    zzgxhVarZza.zze(Double.valueOf(d3 == 0.0d ? 1.0d : (((d4 + dArr[i13]) * 0.5d) - dArr[i4]) / d3), Integer.valueOf(i10));
                    i3 = i3;
                    i4 = 0;
                }
            }
            i10++;
            i3 = i3;
            i4 = 0;
        }
        zzgwm zzgwmVarZzq = zzgwm.zzq(zzgxhVarZza.zzt());
        for (int i14 = 0; i14 < zzgwmVarZzq.size(); i14++) {
            int iIntValue = ((Integer) zzgwmVarZzq.get(i14)).intValue();
            int i15 = iArr2[iIntValue] + 1;
            iArr2[iIntValue] = i15;
            jArr3[iIntValue] = jArr[iIntValue][i15];
            zzi(arrayList, jArr3);
        }
        for (int i16 = 0; i16 < 2; i16++) {
            if (arrayList.get(i16) != null) {
                long j5 = jArr3[i16];
                jArr3[i16] = j5 + j5;
            }
        }
        zzi(arrayList, jArr3);
        zzgwj zzgwjVar2 = new zzgwj();
        for (int i17 = 0; i17 < arrayList.size(); i17++) {
            zzgwj zzgwjVar3 = (zzgwj) arrayList.get(i17);
            zzgwjVar2.zzf(zzgwjVar3 == null ? zzgwm.zzi() : zzgwjVar3.zzi());
        }
        return zzgwjVar2.zzi();
    }

    private static void zzi(List list, long[] jArr) {
        long j3 = 0;
        for (int i3 = 0; i3 < 2; i3++) {
            j3 += jArr[i3];
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            zzgwj zzgwjVar = (zzgwj) list.get(i4);
            if (zzgwjVar != null) {
                zzgwjVar.zzf(new zzzs(j3, jArr[i4]));
            }
        }
    }
}
