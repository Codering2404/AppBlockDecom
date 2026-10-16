package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
class zzhkx {
    final long[] zza;
    final long[] zzb;
    final long[] zzc;

    zzhkx(long[] jArr, long[] jArr2, long[] jArr3) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = jArr3;
    }

    void zza(long[] jArr, long[] jArr2) {
        System.arraycopy(jArr2, 0, jArr, 0, 10);
    }

    final void zzb(zzhkx zzhkxVar, int i3) {
        zzhkw.zza(this.zza, zzhkxVar.zza, i3);
        zzhkw.zza(this.zzb, zzhkxVar.zzb, i3);
        zzhkw.zza(this.zzc, zzhkxVar.zzc, i3);
    }

    zzhkx() {
        this(new long[10], new long[10], new long[10]);
    }

    zzhkx(zzhkx zzhkxVar) {
        this.zza = Arrays.copyOf(zzhkxVar.zza, 10);
        this.zzb = Arrays.copyOf(zzhkxVar.zzb, 10);
        this.zzc = Arrays.copyOf(zzhkxVar.zzc, 10);
    }
}
