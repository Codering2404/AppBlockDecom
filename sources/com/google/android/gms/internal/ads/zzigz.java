package com.google.android.gms.internal.ads;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzigz {
    final Unsafe zza;

    zzigz(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract void zza(Object obj, long j3, byte b3);

    public abstract boolean zzb(Object obj, long j3);

    public abstract void zzc(Object obj, long j3, boolean z2);

    public abstract float zzd(Object obj, long j3);

    public abstract void zze(Object obj, long j3, float f3);

    public abstract double zzf(Object obj, long j3);

    public abstract void zzg(Object obj, long j3, double d3);

    public abstract byte zzh(long j3);
}
