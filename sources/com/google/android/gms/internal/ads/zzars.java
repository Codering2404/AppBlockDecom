package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzars {
    public final int zza;
    public final long zzb;

    private zzars(int i3, long j3) {
        this.zza = i3;
        this.zzb = j3;
    }

    public static zzars zza(zzafz zzafzVar, zzet zzetVar) throws IOException {
        zzafzVar.zzi(zzetVar.zzi(), 0, 8);
        zzetVar.zzh(0);
        return new zzars(zzetVar.zzB(), zzetVar.zzA());
    }
}
