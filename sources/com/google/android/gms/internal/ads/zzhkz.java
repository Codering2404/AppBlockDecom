package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhkz {
    final zzhla zza;
    final long[] zzb;

    zzhkz(zzhla zzhlaVar, long[] jArr) {
        this.zza = zzhlaVar;
        this.zzb = jArr;
    }

    zzhkz() {
        this(new zzhla(), new long[10]);
    }

    zzhkz(zzhkz zzhkzVar) {
        this.zza = new zzhla(zzhkzVar.zza);
        this.zzb = Arrays.copyOf(zzhkzVar.zzb, 10);
    }
}
