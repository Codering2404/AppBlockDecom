package com.google.android.gms.internal.ads;

import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbhn {
    private final InputStream zza;
    private final boolean zzb;
    private final boolean zzc;
    private final long zzd;
    private final boolean zze;

    private zzbhn(InputStream inputStream, boolean z2, boolean z3, long j3, boolean z4) {
        this.zza = inputStream;
        this.zzb = z2;
        this.zzc = z3;
        this.zzd = j3;
        this.zze = z4;
    }

    public static zzbhn zza(InputStream inputStream, boolean z2, boolean z3, long j3, boolean z4) {
        return new zzbhn(inputStream, z2, z3, j3, z4);
    }

    public final InputStream zzb() {
        return this.zza;
    }

    public final boolean zzc() {
        return this.zzb;
    }

    public final boolean zzd() {
        return this.zzc;
    }

    public final long zze() {
        return this.zzd;
    }

    public final boolean zzf() {
        return this.zze;
    }
}
