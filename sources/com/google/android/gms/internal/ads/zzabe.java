package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzabe extends zzabh {
    protected abstract Pair zzh(zzabd zzabdVar, int[][][] iArr, int[] iArr2, zzxk zzxkVar, zzbf zzbfVar) throws zzjk;

    @Override // com.google.android.gms.internal.ads.zzabh
    public final void zzq(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzabh
    public final zzabi zzr(zznc[] zzncVarArr, zzzn zzznVar, zzxk zzxkVar, zzbf zzbfVar) throws zzjk {
        int[] iArr;
        int[] iArr2 = new int[3];
        zzbg[][] zzbgVarArr = new zzbg[3][];
        int[][][] iArr3 = new int[3][][];
        for (int i3 = 0; i3 < 3; i3++) {
            int i4 = zzznVar.zzb;
            zzbgVarArr[i3] = new zzbg[i4];
            iArr3[i3] = new int[i4][];
        }
        int i5 = 2;
        int[] iArr4 = new int[2];
        for (int i6 = 0; i6 < 2; i6++) {
            iArr4[i6] = zzncVarArr[i6].zzu();
        }
        int i7 = 0;
        while (i7 < zzznVar.zzb) {
            zzbg zzbgVarZza = zzznVar.zza(i7);
            int i8 = zzbgVarZza.zzc;
            int i9 = i5;
            int i10 = 0;
            int i11 = 0;
            boolean z2 = true;
            while (i10 < i5) {
                zznc zzncVar = zzncVarArr[i10];
                int iMax = 0;
                for (int i12 = 0; i12 < zzbgVarZza.zza; i12++) {
                    iMax = Math.max(iMax, zzncVar.zzad(zzbgVarZza.zza(i12)) & 7);
                }
                boolean z3 = iArr2[i10] == 0;
                if (iMax > i11) {
                    z2 = z3;
                    i9 = i10;
                    i11 = iMax;
                } else if (iMax == i11 && i8 == 5 && !z2 && z3) {
                    i9 = i10;
                    i11 = iMax;
                    z2 = true;
                }
                i10++;
                i5 = 2;
            }
            if (i9 == i5) {
                iArr = new int[zzbgVarZza.zza];
            } else {
                zznc zzncVar2 = zzncVarArr[i9];
                int i13 = zzbgVarZza.zza;
                int[] iArr5 = new int[i13];
                for (int i14 = 0; i14 < i13; i14++) {
                    iArr5[i14] = zzncVar2.zzad(zzbgVarZza.zza(i14));
                }
                iArr = iArr5;
            }
            int i15 = iArr2[i9];
            zzbgVarArr[i9][i15] = zzbgVarZza;
            iArr3[i9][i15] = iArr;
            iArr2[i9] = i15 + 1;
            i7++;
            i5 = 2;
        }
        zzzn[] zzznVarArr = new zzzn[i5];
        String[] strArr = new String[i5];
        int[] iArr6 = new int[i5];
        int i16 = 0;
        while (i16 < i5) {
            int i17 = iArr2[i16];
            zzznVarArr[i16] = new zzzn((zzbg[]) zzfl.zzb(zzbgVarArr[i16], i17));
            iArr3[i16] = (int[][]) zzfl.zzb(iArr3[i16], i17);
            strArr[i16] = zzncVarArr[i16].zzU();
            iArr6[i16] = zzncVarArr[i16].zza();
            i16++;
            i5 = 2;
        }
        int i18 = i5;
        zzabd zzabdVar = new zzabd(strArr, iArr6, zzznVarArr, iArr4, iArr3, new zzzn((zzbg[]) zzfl.zzb(zzbgVarArr[i18], iArr2[i18])));
        Pair pairZzh = zzh(zzabdVar, iArr3, iArr4, zzxkVar, zzbfVar);
        zzabf[] zzabfVarArr = (zzabf[]) pairZzh.second;
        int length = zzabfVarArr.length;
        List[] listArr = new List[length];
        for (int i19 = 0; i19 < zzabfVarArr.length; i19++) {
            zzabf zzabfVar = zzabfVarArr[i19];
            listArr[i19] = zzabfVar != null ? zzgwm.zzj(zzabfVar) : zzgwm.zzi();
        }
        zzgwj zzgwjVar = new zzgwj();
        for (int i20 = 0; i20 < 2; i20++) {
            zzzn zzznVarZzb = zzabdVar.zzb(i20);
            int i21 = 0;
            while (i21 < zzznVarZzb.zzb) {
                zzbg zzbgVarZza2 = zzznVarZzb.zza(i21);
                boolean z4 = zzabdVar.zzd(i20, i21, false) != 0;
                int i22 = zzbgVarZza2.zza;
                int[] iArr7 = new int[i22];
                boolean[] zArr = new boolean[i22];
                for (int i23 = 0; i23 < i22; i23++) {
                    iArr7[i23] = zzabdVar.zzc(i20, i21, i23) & 7;
                    int i24 = 0;
                    boolean z5 = false;
                    while (i24 < length) {
                        List list = listArr[i24];
                        int i25 = length;
                        List[] listArr2 = listArr;
                        int i26 = 0;
                        while (true) {
                            if (i26 < list.size()) {
                                zzabf zzabfVar2 = (zzabf) list.get(i26);
                                int i27 = i26;
                                if (zzabfVar2.zza().equals(zzbgVarZza2) && zzabfVar2.zzg(i23) != -1) {
                                    z5 = true;
                                    break;
                                }
                                i26 = i27 + 1;
                            }
                        }
                        i24++;
                        length = i25;
                        listArr = listArr2;
                    }
                    zArr[i23] = z5;
                }
                zzgwjVar.zzf(new zzbm(zzbgVarZza2, z4, iArr7, zArr));
                i21++;
                length = length;
            }
        }
        zzzn zzznVarZze = zzabdVar.zze();
        for (int i28 = 0; i28 < zzznVarZze.zzb; i28++) {
            zzbg zzbgVarZza3 = zzznVarZze.zza(i28);
            int i29 = zzbgVarZza3.zza;
            int[] iArr8 = new int[i29];
            Arrays.fill(iArr8, 0);
            zzgwjVar.zzf(new zzbm(zzbgVarZza3, false, iArr8, new boolean[i29]));
        }
        return new zzabi((zznd[]) pairZzh.first, (zzaba[]) pairZzh.second, new zzbn(zzgwjVar.zzi()), zzabdVar);
    }
}
