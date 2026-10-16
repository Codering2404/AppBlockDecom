package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzno {
    private final zzs zza;
    private final SparseArray zzb;

    public zzno(zzs zzsVar, SparseArray sparseArray) {
        this.zza = zzsVar;
        SparseArray sparseArray2 = new SparseArray(zzsVar.zzb());
        for (int i3 = 0; i3 < zzsVar.zzb(); i3++) {
            int iZzc = zzsVar.zzc(i3);
            zznn zznnVar = (zznn) sparseArray.get(iZzc);
            zznnVar.getClass();
            sparseArray2.append(iZzc, zznnVar);
        }
        this.zzb = sparseArray2;
    }

    public final zznn zza(int i3) {
        zznn zznnVar = (zznn) this.zzb.get(i3);
        zznnVar.getClass();
        return zznnVar;
    }

    public final boolean zzb(int i3) {
        return this.zza.zza(i3);
    }

    public final int zzc() {
        return this.zza.zzb();
    }

    public final int zzd(int i3) {
        return this.zza.zzc(i3);
    }
}
