package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzalp implements zzahb {
    private final SparseArray zza;
    private final SparseArray zzb;
    private final long zzc;
    private final long zzd;
    private final int zze;

    /* synthetic */ zzalp(SparseArray sparseArray, SparseArray sparseArray2, long j3, long j4, int i3, byte[] bArr) {
        this.zza = sparseArray;
        this.zzb = sparseArray2;
        this.zzc = j3;
        this.zzd = j4;
        this.zze = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final zzagz zzc(long j3) {
        SparseArray sparseArray = this.zza;
        int i3 = this.zze;
        long[] jArr = (long[]) sparseArray.get(i3);
        SparseArray sparseArray2 = this.zzb;
        long[] jArr2 = (long[]) sparseArray2.get(i3);
        if (jArr == null || jArr2 == null) {
            jArr = (long[]) sparseArray.get(i3);
            jArr2 = (long[]) sparseArray2.get(i3);
            if (jArr == null || jArr2 == null) {
                jArr = (long[]) sparseArray.valueAt(0);
                jArr2 = (long[]) sparseArray2.valueAt(0);
            }
        }
        if (jArr.length == 0 || j3 < jArr[0]) {
            zzahc zzahcVar = new zzahc(0L, this.zzd);
            return new zzagz(zzahcVar, zzahcVar);
        }
        int iZzo = zzfl.zzo(jArr, j3, true, true);
        zzahc zzahcVar2 = new zzahc(jArr[iZzo], jArr2[iZzo]);
        return new zzagz(zzahcVar2, zzahcVar2);
    }
}
