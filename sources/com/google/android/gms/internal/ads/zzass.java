package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzass {
    private int zza = 2500;
    private int zzb;

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final void zzc(zzatn zzatnVar) throws zzatn {
        int i3 = this.zzb + 1;
        this.zzb = i3;
        int i4 = this.zza;
        this.zza = i4 + i4;
        if (i3 > 1) {
            throw zzatnVar;
        }
    }
}
