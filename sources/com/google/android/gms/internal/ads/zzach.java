package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzach {
    private static final Comparator zza = zzacg.zza;
    private static final Comparator zzb = zzacf.zza;
    private int zzf;
    private int zzg;
    private int zzh;
    private final zzace[] zzd = new zzace[5];
    private final ArrayList zzc = new ArrayList();
    private int zze = -1;

    public zzach(int i3) {
    }

    public final void zza() {
        this.zzc.clear();
        this.zze = -1;
        this.zzf = 0;
        this.zzg = 0;
    }

    public final void zzb(int i3, float f3) {
        zzace zzaceVar;
        if (this.zze != 1) {
            Collections.sort(this.zzc, zza);
            this.zze = 1;
        }
        int i4 = this.zzh;
        if (i4 > 0) {
            zzace[] zzaceVarArr = this.zzd;
            int i5 = i4 - 1;
            this.zzh = i5;
            zzaceVar = zzaceVarArr[i5];
        } else {
            zzaceVar = new zzace(null);
        }
        int i6 = this.zzf;
        this.zzf = i6 + 1;
        zzaceVar.zza = i6;
        zzaceVar.zzb = i3;
        zzaceVar.zzc = f3;
        ArrayList arrayList = this.zzc;
        arrayList.add(zzaceVar);
        this.zzg += i3;
        while (true) {
            int i7 = this.zzg;
            if (i7 <= 2000) {
                return;
            }
            int i8 = i7 - 2000;
            zzace zzaceVar2 = (zzace) arrayList.get(0);
            int i9 = zzaceVar2.zzb;
            if (i9 <= i8) {
                this.zzg -= i9;
                arrayList.remove(0);
                int i10 = this.zzh;
                if (i10 < 5) {
                    zzace[] zzaceVarArr2 = this.zzd;
                    this.zzh = i10 + 1;
                    zzaceVarArr2[i10] = zzaceVar2;
                }
            } else {
                zzaceVar2.zzb = i9 - i8;
                this.zzg -= i8;
            }
        }
    }

    public final float zzc(float f3) {
        int i3 = 0;
        if (this.zze != 0) {
            Collections.sort(this.zzc, zzb);
            this.zze = 0;
        }
        float f4 = this.zzg;
        int i4 = 0;
        while (true) {
            ArrayList arrayList = this.zzc;
            if (i3 >= arrayList.size()) {
                if (arrayList.isEmpty()) {
                    return Float.NaN;
                }
                return ((zzace) arrayList.get(arrayList.size() - 1)).zzc;
            }
            float f5 = 0.5f * f4;
            zzace zzaceVar = (zzace) arrayList.get(i3);
            i4 += zzaceVar.zzb;
            if (i4 >= f5) {
                return zzaceVar.zzc;
            }
            i3++;
        }
    }
}
